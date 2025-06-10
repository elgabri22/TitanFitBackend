package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.Meal;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    ) throws ParseException {
        // Traemos todas las comidas sin filtro de fechas
        List<Meal> todasComidas = mealService.getAllMeals();

        List<Meal> comidasSemanaUsuario = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Parseamos fechas límite
        Date fechainicio = sdf.parse(fecha_inicio);
        Date fechafin = sdf.parse(fecha_fin);

        for (Meal meal : todasComidas) {
            if (meal.getUser() != null && meal.getUser().getId() != null
                    && meal.getUser().getId().equalsIgnoreCase(id_user)) {

                Date fechaMeal = sdf.parse(meal.getFecha());

                // Filtramos en Java comprobando que fechaMeal esté dentro del rango (inclusive)
                if (!fechaMeal.before(fechainicio) && !fechaMeal.after(fechafin)) {
                    comidasSemanaUsuario.add(meal);
                }
            }
        }
        return ResponseEntity.ok(comidasSemanaUsuario);
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
