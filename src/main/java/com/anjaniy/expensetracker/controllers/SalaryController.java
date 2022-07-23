package com.anjaniy.expensetracker.controllers;

import com.anjaniy.expensetracker.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/update/{salary}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("salary") int salary){
        salaryService.update(salary);
        return "Salary Updated Successfully";
    }
}
