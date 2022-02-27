package com.company.mypizza.entity;

import java.util.List;

public class Pizza {
    private int id;
    private String name;
    private double price;
    private PizzaSize pizzaSize;
    private Board board;
    private DoughType doughType;
    private String image;
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public Pizza(String name, double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Pizza(int id, String name, double price, PizzaSize pizzaSize, Board board, DoughType doughType, String image, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaSize = pizzaSize;
        this.board = board;
        this.doughType = doughType;
        this.image = image;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public void setDoughType(DoughType doughType) {
        this.doughType = doughType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
