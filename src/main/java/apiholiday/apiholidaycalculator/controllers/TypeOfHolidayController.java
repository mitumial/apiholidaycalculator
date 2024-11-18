package apiholiday.apiholidaycalculator.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apiholiday.apiholidaycalculator.entities.TypeOfHoliday;
import apiholiday.apiholidaycalculator.interfaces.ITypeOfHolidayService;

@RestController
@RequestMapping("api/type")
public class TypeOfHolidayController {
        private ITypeOfHolidayService typeOfHolidayService;

    public TypeOfHolidayController(ITypeOfHolidayService typeOfHolidayService) {
        this.typeOfHolidayService = typeOfHolidayService;
    }

    
    @GetMapping("/all")
    public List<TypeOfHoliday> findAll(){
        return typeOfHolidayService.findAll();
    }

    @GetMapping("/{id}")
    public TypeOfHoliday findById(@PathVariable int id){
        return typeOfHolidayService.findById(id);
    };

    @PostMapping("/save")
    public TypeOfHoliday save(@RequestBody TypeOfHoliday typeOfHoliday){
        return typeOfHolidayService.save(typeOfHoliday);
    };

    @PutMapping("/update")
    public TypeOfHoliday update(@RequestBody TypeOfHoliday typeOfHoliday){
        return typeOfHolidayService.update(typeOfHoliday);
    };

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return typeOfHolidayService.delete(id);
    };
}
