package com.company.mypizza.entity;

import java.util.List;

public class ExtendedPizza extends Pizza{
    private boolean visibility;

    public ExtendedPizza() {
    }

    public ExtendedPizza(String name, double price, String image, boolean visibility) {
        super(name, price, image);
        this.visibility = visibility;
    }

    public ExtendedPizza(int id, String name, double price, PizzaSize pizzaSize, Board board, DoughType doughType, String image, List<Ingredient> ingredients, boolean visibility) {
        super(id, name, price, pizzaSize, board, doughType, image, ingredients);
        this.visibility = visibility;
    }

    public ExtendedPizza(String test, double v, String test_image) {
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
