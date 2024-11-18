package apiholiday.apiholidaycalculator.interfaces;

import java.util.List;

import apiholiday.apiholidaycalculator.entities.Holiday;

public interface IHolidayService {
    public List<Holiday> findAll();

    public Holiday findById(int id);

    public String verifyDate(int year, int month, int day);

    public Holiday save(Holiday holiday);

    public Holiday update(Holiday holiday);

    public boolean delete(int id);
}
