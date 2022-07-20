package com.anjaniy.expensetracker.models;

import com.anjaniy.expensetracker.enums.ExpenseCategory;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("expense")
public class Expense {

    @Id
    private String id;

    @Field("expenseName")
    @Indexed(unique = true)
    private String expenseName;

    @Field("expenseDescription")
    private String expenseDescription;

    @Field("expenseCategory")
    private ExpenseCategory expenseCategory;

    @Field("expenseAmount")
    private BigDecimal expenseAmount;

}
