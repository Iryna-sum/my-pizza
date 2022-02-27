package com.company.mypizza.entity;

public enum PizzaSize {
    SMALL(25, "sm"),
    MEDIUM(30, "sm"),
    LARGE(35, "sm");

    private final int diameter;
    private final String unit;

    private PizzaSize(int diameter, String unit) {
        this.diameter = diameter;
        this.unit = unit;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getUnit() {
        return unit;
    }
}
