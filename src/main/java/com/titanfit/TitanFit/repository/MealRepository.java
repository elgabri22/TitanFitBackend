package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MealRepository extends MongoRepository<Meal, String> {
    List<Meal> findMealsByfecha (String fecha);
}
