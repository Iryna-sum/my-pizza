package com.company.mypizza.entity;

public class Order {
    private int id;
    private User user;
    private Pizza pizza;
    private PaymentMethod payment;
    private DeliveryTime deliveryTime;

    public Order() {
    }

    public Order(int id, User user, Pizza pizza, PaymentMethod payment, DeliveryTime deliveryTime) {
        this.id = id;
        this.user = user;
        this.pizza = pizza;
        this.payment = payment;
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PaymentMethod getPayment() {
        return payment;
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    public DeliveryTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(DeliveryTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
