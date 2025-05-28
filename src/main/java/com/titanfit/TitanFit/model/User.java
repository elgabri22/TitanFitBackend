package com.titanfit.TitanFit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int age;
    private double weight;
    private double height;
    private List<Meal> meals;
    private UserGoal goals;
    private String token;
    private Favoritos favoritos;

    public User() {}

    public User(String name, String email, String password, int age, double weight, double height, UserGoal goals, List<Meal> meals) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goals = goals;
        this.meals = meals;
    }

    public User(String name, String email, String password, int age, double weight, double height, UserGoal goals, List<Meal> meals,String token,Favoritos favoritos) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goals = goals;
        this.meals = meals;
        this.token=token;
        this.favoritos=favoritos;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getters y Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UserGoal getGoals() {
        return goals;
    }

    public void setGoals(UserGoal goals) {
        this.goals = goals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Favoritos getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favoritos favoritos) {
        this.favoritos = favoritos;
    }
}
