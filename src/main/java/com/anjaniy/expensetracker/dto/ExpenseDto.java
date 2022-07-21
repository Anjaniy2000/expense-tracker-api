package com.anjaniy.expensetracker.dto;

import com.anjaniy.expensetracker.enums.ExpenseCategory;
import com.anjaniy.expensetracker.models.AppUser;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExpenseDto {
    private String id;
    private String expenseName;
    private String expenseDescription;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;
    private String userId;
}
