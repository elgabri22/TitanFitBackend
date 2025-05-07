package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
