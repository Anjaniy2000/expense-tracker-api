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

    @PostMapping("/getExpenseByName/{expenseName}")
    @ResponseStatus(HttpStatus.OK)
    public ExpenseDto getExpenseByName(@PathVariable ("expenseName") String expenseName){
        return expenseService.getExpenseByName(expenseName);
    }

    @PostMapping("/addExpense")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseDto addExpense(@RequestBody ExpenseDto expenseDto){
        return expenseService.addExpense(expenseDto);
    }

    @DeleteMapping("/deleteExpense/{expenseId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExpense(@PathVariable ("expenseId") String expenseId){
        expenseService.deleteExpense(expenseId);
    }
}
