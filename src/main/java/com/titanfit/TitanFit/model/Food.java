package com.titanfit.TitanFit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "foods")
public class Food {

    @Id
    private String id;
    private String name;
    private int calories;
    private double protein;
    private double carbs;
    private double fats;

    public Food() {
    }

    public Food(String id, String name, int calories, double protein, double carbs, double fats) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return calories == food.calories && Double.compare(protein, food.protein) == 0 && Double.compare(carbs, food.carbs) == 0 && Double.compare(fats, food.fats) == 0 && Objects.equals(id, food.id) && Objects.equals(name, food.name);
    }
}
