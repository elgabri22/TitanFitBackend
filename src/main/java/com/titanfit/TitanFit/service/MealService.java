package com.titanfit.TitanFit.service;

import com.titanfit.TitanFit.model.Meal;
import com.titanfit.TitanFit.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal getMealById(String id) {
        Meal meal = null;
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if (optionalMeal.isPresent()) {
            meal = optionalMeal.get();
        }
        return meal;
    }

    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal updateMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void deleteMeal(String id) {
        mealRepository.deleteById(id);
    }
}
