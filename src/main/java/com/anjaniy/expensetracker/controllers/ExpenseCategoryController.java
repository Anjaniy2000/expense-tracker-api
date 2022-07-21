package com.anjaniy.expensetracker.controllers;

import com.anjaniy.expensetracker.enums.ExpenseCategory;
import com.anjaniy.expensetracker.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expenseCategory")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @GetMapping("/categories")
    public List<ExpenseCategory> getAllCategories(){
        return expenseCategoryService.getAllCategories();
    }
}
