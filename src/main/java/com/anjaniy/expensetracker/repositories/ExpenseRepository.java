package com.anjaniy.expensetracker.repositories;

import com.anjaniy.expensetracker.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{'userId': ?0}")
    List<Expense> findByUserId(String userId);
}
