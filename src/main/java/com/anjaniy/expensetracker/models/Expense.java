package com.anjaniy.expensetracker.models;

import com.anjaniy.expensetracker.enums.ExpenseCategory;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "Expense Name Is Required!")
    private String expenseName;

    @Field("expenseDescription")
    @NotBlank(message = "Expense Description Is Required!")
    private String expenseDescription;

    @Field("expenseCategory")
    @NotBlank(message = "Expense Category Is Required!")
    private ExpenseCategory expenseCategory;

    @Field("expenseAmount")
    @NotBlank(message = "Expense Amount Is Required!")
    private BigDecimal expenseAmount;

    @Field("user")
    @NotNull
    private AppUser appUser;

}
