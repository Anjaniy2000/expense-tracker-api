package com.anjaniy.expensetracker.services;

import com.anjaniy.expensetracker.dto.ExpenseDto;
import com.anjaniy.expensetracker.models.AppUser;
import com.anjaniy.expensetracker.models.Expense;
import com.anjaniy.expensetracker.repositories.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppUserService appUserService;

    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findByUserId(
                modelMapper.map(appUserService.getCurrentUser(), AppUser.class)
                        .getId()
        );
        return expenses.stream().map(expense -> modelMapper.map(expense, ExpenseDto.class)).collect(Collectors.toList());
    }

    public ExpenseDto addExpense(ExpenseDto expenseDto) {
        expenseDto.setUserId(
                modelMapper.map(appUserService.getCurrentUser(), AppUser.class)
                        .getId()
        );
        Expense savedExpense = expenseRepository.save(modelMapper.map(expenseDto, Expense.class));
        expenseDto.setId(savedExpense.getId());
        return expenseDto;
    }

    public ExpenseDto getExpense(String expenseId) {
        return modelMapper.map(expenseRepository.findById(expenseId), ExpenseDto.class);
    }

    public void deleteExpense(String expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    public ExpenseDto updateExpense(ExpenseDto expenseDto) {
        return modelMapper.map(expenseRepository.save(modelMapper.map(expenseDto, Expense.class)), ExpenseDto.class);
    }
}
