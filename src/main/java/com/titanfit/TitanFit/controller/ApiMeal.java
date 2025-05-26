package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.Meal;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete/meal/{id}")
    private ResponseEntity<String> delete(@PathVariable String id){
        try {
            mealService.deleteMeal(id);
            return ResponseEntity.ok().build(); // 200 OK sin contenido
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 si no se encuentra
        }
    }

    @PostMapping("/add/meal")
    public ResponseEntity<Meal> add(@RequestBody Meal meal){
        mealService.addMeal(meal);;
        return ResponseEntity.ok(meal);
    }


}
