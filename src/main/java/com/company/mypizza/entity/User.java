package com.company.mypizza.entity;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private Role role = Role.USER;
    private UserAddress userAddress;
    private int discount = 0;
    boolean isBanned = false;

    public User() {
    }

    public User(String name, String lastName, String userName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String lastName, String userName, String phoneNumber, UserAddress userAddress, boolean isBanned) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
        this.isBanned = isBanned;
    }

    public User(int id, String name, String lastName, String userName, String phoneNumber, Role role, UserAddress userAddress, int discount, boolean isBanned) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userAddress = userAddress;
        this.discount = discount;
        this.isBanned = isBanned;
    }

    public User(String name, String lastName, String userName, String phoneNumber, Role role, boolean isBanned) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
