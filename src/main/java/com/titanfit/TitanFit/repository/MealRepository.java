package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, String> {
}
