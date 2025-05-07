package com.titanfit.TitanFit.model;

public class UserGoal {

    private int dailyCalories;
    private double carbsPercentage;
    private double proteinPercentage;
    private double fatsPercentage;
    private String goal;

    public UserGoal() {}

    public UserGoal(int dailyCalories, double carbsPercentage, double proteinPercentage, double fatsPercentage, String goal) {
        this.dailyCalories = dailyCalories;
        this.carbsPercentage = carbsPercentage;
        this.proteinPercentage = proteinPercentage;
        this.fatsPercentage = fatsPercentage;
        this.goal = goal;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public double getCarbsPercentage() {
        return carbsPercentage;
    }

    public void setCarbsPercentage(double carbsPercentage) {
        this.carbsPercentage = carbsPercentage;
    }

    public double getProteinPercentage() {
        return proteinPercentage;
    }

    public void setProteinPercentage(double proteinPercentage) {
        this.proteinPercentage = proteinPercentage;
    }

    public double getFatsPercentage() {
        return fatsPercentage;
    }

    public void setFatsPercentage(double fatsPercentage) {
        this.fatsPercentage = fatsPercentage;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}

