package apiholiday.apiholidaycalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiholiday.apiholidaycalculator.entities.TypeOfHoliday;

@Repository
public interface ITypeOfHolidayRepository extends JpaRepository<TypeOfHoliday, Integer>{

}
