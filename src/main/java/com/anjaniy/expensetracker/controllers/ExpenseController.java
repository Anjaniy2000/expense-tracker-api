package com.anjaniy.expensetracker.controllers;

import com.anjaniy.expensetracker.dto.ExpenseDto;
import com.anjaniy.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/getAllExpenses")
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseDto> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/getExpense/{expenseId}")
    @ResponseStatus(HttpStatus.OK)
    public ExpenseDto getExpense(@PathVariable ("expenseId") String expenseId){
        return expenseService.getExpense(expenseId);
    }

    @PostMapping("/addExpense")
    @ResponseStatus(HttpStatus.CREATED)
    public String addExpense(@RequestBody ExpenseDto expenseDto){
        expenseService.addExpense(expenseDto);
        return "Expense Added Successfully";
    }

    @PutMapping("/updateExpense")
    @ResponseStatus(HttpStatus.OK)
    public String updateExpense(@RequestBody ExpenseDto expenseDto){
        expenseService.updateExpense(expenseDto);
        return "Expense Updated Successfully";
    }

    @DeleteMapping("/deleteExpense/{expenseId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteExpense(@PathVariable ("expenseId") String expenseId){
        expenseService.deleteExpense(expenseId);
        return "Expense Deleted Successfully";
    }
}
