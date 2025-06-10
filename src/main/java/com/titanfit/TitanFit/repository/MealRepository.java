package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends MongoRepository<Meal, String> {
    List<Meal> findMealsByfecha (String fecha);
    @Query("SELECT m FROM Meal m WHERE m.fecha BETWEEN :startDate AND :endDate")
    List<Meal> findMealsBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
