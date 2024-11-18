package apiholiday.apiholidaycalculator.interfaces;

import java.util.List;

import apiholiday.apiholidaycalculator.entities.TypeOfHoliday;

public interface ITypeOfHolidayService {
    public List<TypeOfHoliday> findAll();

    public TypeOfHoliday findById(int id);

    public TypeOfHoliday save(TypeOfHoliday typeOfTypeOfHoliday);

    public TypeOfHoliday update(TypeOfHoliday typeOfTypeOfHoliday);

    public boolean delete(int id);
}
