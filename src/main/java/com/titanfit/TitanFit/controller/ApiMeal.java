package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.Meal;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiMeal {
    @Autowired
    private MealService mealService;

    @GetMapping("/meals/{fecha}/{id}")
    public ResponseEntity<List<Meal>> getMeals(@PathVariable String fecha,@PathVariable String id) {
        List<Meal> meals = mealService.getAllMealsOfDay(fecha);
        List<Meal>mealsusuario=new ArrayList<Meal>();
        for (Meal meal: meals) {
            if (meal.getUser().getId().equals(id)) {
                mealsusuario.add(meal);
            }
        }
        return ResponseEntity.ok(mealsusuario);
    }

    @GetMapping("/meals/{fecha_inicio}/{fecha_fin}/{id_user}")
    public ResponseEntity<List<Meal>> getMealsBYDate(
            @PathVariable String fecha_inicio,
            @PathVariable String fecha_fin,
            @PathVariable String id_user
    ) {
        List<Meal> comidasSemana = mealService.listaComidasSEmana(fecha_inicio, fecha_fin);
        List<Meal> comidasSemanaUsuario = new ArrayList<>(); // Use diamond operator for conciseness

        if (comidasSemana == null) { // Defensive check: if service returns null
            return ResponseEntity.ok(new ArrayList<>()); // Return an empty list instead of null
        }

        for (Meal meal : comidasSemana) {
            // Check if meal.getUser() is not null before trying to get its ID
            if (meal.getUser() != null && meal.getUser().getId() != null && meal.getUser().getId().equalsIgnoreCase(id_user)) {
                comidasSemanaUsuario.add(meal);
            }
        }
        return ResponseEntity.ok(comidasSemanaUsuario); // <--- Corrected variable name
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
        Meal meal1=mealService.addMeal(meal);
        return ResponseEntity.ok(meal1);
    }


}
