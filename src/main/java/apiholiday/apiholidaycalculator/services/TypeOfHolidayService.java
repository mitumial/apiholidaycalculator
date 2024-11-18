package apiholiday.apiholidaycalculator.services;

import java.util.List;

import org.springframework.stereotype.Service;

import apiholiday.apiholidaycalculator.entities.TypeOfHoliday;
import apiholiday.apiholidaycalculator.interfaces.ITypeOfHolidayService;
import apiholiday.apiholidaycalculator.repositories.ITypeOfHolidayRepository;

@Service
public class TypeOfHolidayService implements ITypeOfHolidayService {
    
    private final ITypeOfHolidayRepository repository;

    public TypeOfHolidayService(ITypeOfHolidayRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TypeOfHoliday> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeOfHoliday findById(int id) {
        return repository.findById(id).isEmpty() ? null : repository.findById(id).get();
    }

    @Override
    public TypeOfHoliday save(TypeOfHoliday typeOfHoliday) {
        return repository.save(typeOfHoliday);
    }

    @Override
    public TypeOfHoliday update(TypeOfHoliday typeOfHoliday) {
        return repository.findById(typeOfHoliday.getId()).isEmpty() ? null : repository.save(typeOfHoliday);
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
