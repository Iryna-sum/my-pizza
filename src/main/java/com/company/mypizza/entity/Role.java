package com.company.mypizza.entity;

public enum Role {
    ADMINISTRATOR("administrator"),
    MANAGER("manager"),
    USER("user"),
    GUEST("guest");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
