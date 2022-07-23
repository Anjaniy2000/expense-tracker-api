package com.anjaniy.expensetracker.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Document("user")
public class AppUser {

    @Id
    private String id;

    @Field("name")
    @NotBlank(message = "Name Is Required!")
    private String name;

    @Field("email")
    @NotBlank(message = "Email Address Is Required!")
    @Email(message="Given Email Address Is Not Valid Email Address, Please Enter Valid One.")
    private String email;

    @Field("password")
    @NotBlank(message = "Password Is Required!")
    private String password;

    @Field("salary")
    private int salary;
}
