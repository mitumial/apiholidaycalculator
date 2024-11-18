package apiholiday.apiholidaycalculator.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apiholiday.apiholidaycalculator.entities.Holiday;
import apiholiday.apiholidaycalculator.interfaces.IHolidayService;
import apiholiday.apiholidaycalculator.repositories.IHolidayRepository;
import static apiholiday.apiholidaycalculator.services.DateService.getHolyWeek;
import static apiholiday.apiholidaycalculator.services.DateService.getNextMonday;
import static apiholiday.apiholidaycalculator.services.DateService.incrementDays;

@Service
public class HolidayService implements IHolidayService{

    private final IHolidayRepository repository;

    public HolidayService(IHolidayRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Holiday> findAll() {
        return repository.findAll();
    }

    @Override
    public Holiday findById(int id) {
        return repository.findById(id).isEmpty() ? null : repository.findById(id).get();
    }

    @Override
    public String verifyDate(int year, int month, int day) {
        
        if (year > 2024 || month < 1 || month > 12 || day > 31 || day < 0){
            return "fecha no valida";
        } else if ((month==4 || month==6 || month==9 || month==11) &&  day > 30){
            return "fecha no valida";
        } else if (month == 2 && day > 29){
            return "fecha no valida";
        } else if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && day > 28){
            return "fecha no valida";
        }
        
        Date domingoRamos = getHolyWeek(year);
        Date easterDay = incrementDays(domingoRamos, 7);
        
        List<Holiday> holidays = repository.findAll();

        for (Holiday holiday: holidays){
            switch (holiday.getTypeOfHoliday().getId()) {
                // fijo
                case 1 -> {
                    if (holiday.getDay() == day && holiday.getMonth() == month) {
                        return "Es festivo";
                    }
                }
                //se traslada al siguiente lunes
                case 2 -> {
                    Date modHoliday = getNextMonday(new Date(year-1900, holiday.getMonth()-1, holiday.getDay()));
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(modHoliday);
                    if (cal.get(Calendar.DAY_OF_MONTH) == day && cal.get(Calendar.MONTH)+1 == month) {
                        return "Es festivo";
                    }
                }
                // basado en domingo de pascua
                case 3 -> {
                    Date modHoliday = incrementDays(easterDay, holiday.getEasterDays());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(modHoliday);
                    if (cal.get(Calendar.DAY_OF_MONTH) == day && cal.get(Calendar.MONTH)+1 == month) {
                        return "Es festivo";
                    }
                }
                // basado en domingo de pascua y se traslada al siguiente lunes
                case 4 -> {
                    Date modHoliday = incrementDays(easterDay, holiday.getEasterDays());
                    modHoliday = getNextMonday(modHoliday);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(modHoliday);
                    if (cal.get(Calendar.DAY_OF_MONTH) == day && cal.get(Calendar.MONTH)+1 == month) {
                        return "Es festivo";
                    }
                }
                default -> {
                    return "No es festivo";
                }
            }
        }
        return "No es festivo";
    }

    @Override
    public Holiday save(Holiday holiday) {
        return repository.save(holiday);
    }

    @Override
    public Holiday update(Holiday holiday) {
        return repository.findById(holiday.getId()).isEmpty() ? null : repository.save(holiday);
    }

    @Override
    public boolean delete(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

}
