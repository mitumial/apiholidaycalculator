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

import apiholiday.apiholidaycalculator.entities.Holiday;
import apiholiday.apiholidaycalculator.interfaces.IHolidayService;


@RestController
@RequestMapping("api/holiday")
public class HolidayController {
    private IHolidayService holidayService;

    public HolidayController(IHolidayService holidayService) {
        this.holidayService = holidayService;
    }

    
    @GetMapping("/all")
    public List<Holiday> findAll(){
        return holidayService.findAll();
    }

    @GetMapping("/{id}")
    public Holiday findById(@PathVariable int id){
        return holidayService.findById(id);
    };

    @GetMapping("/verify/{year}/{month}/{day}")
    public String verifyDate(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        return holidayService.verifyDate(year, month, day);
    }
    
    @PostMapping("/save")
    public Holiday save(@RequestBody Holiday holiday){
        return holidayService.save(holiday);
    };

    

    @PutMapping("/update")
    public Holiday update(@RequestBody Holiday holiday){
        return holidayService.update(holiday);
    };

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return holidayService.delete(id);
    };
}
