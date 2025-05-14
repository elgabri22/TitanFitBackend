package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.Meal;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiMeal {
    @Autowired
    private MealService mealService;

    @GetMapping("/meals/{fecha}")
    public ResponseEntity<List<Meal>> getMeals(@PathVariable String fecha) {
        List<Meal> meals = mealService.getAllMealsOfDay(fecha);
        return ResponseEntity.ok(meals);
    }

}
