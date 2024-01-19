package com.ohgiraffers.polymorphism_practice;

import java.util.Arrays;

public abstract class Cook {
    private String name;
    private String[] ingredients;
    private int cookTime;

    public Cook() {
    }

    public Cook(String name, String[] ingredients, int cookTime) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookTime = cookTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public void cooking(){
        System.out.println("요리하기");
    }

    public void setDish(){
        System.out.println("접시에 담기");
    }

    public abstract void eat();

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", cookTime=" + cookTime +
                '}';
    }
}
