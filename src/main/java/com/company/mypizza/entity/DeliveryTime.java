package com.company.mypizza.entity;

import java.time.LocalDateTime;

public class DeliveryTime {
    private int id;
    private String name;
    private LocalDateTime time;

    public DeliveryTime() {
    }

    public DeliveryTime(String name, LocalDateTime time) {
        this.name = name;
        this.time = time;
    }

    public DeliveryTime(int id, String name, LocalDateTime time) {
        this.id = id;
        this.name = name;
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
