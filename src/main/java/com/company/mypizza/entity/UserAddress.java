package com.company.mypizza.entity;

public class UserAddress {
    private int id;
    private String country;
    private String city;
    private String streetName;
    private int houseNumber;
    private String frame;
    private String entranceNumber;
    private String apartmentNumber;
    private String intercom;

    public UserAddress() {
    }

    public UserAddress(String country, String city, String streetName, int houseNumber, String frame, String entranceNumber, String apartmentNumber, String intercom) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.frame = frame;
        this.entranceNumber = entranceNumber;
        this.apartmentNumber = apartmentNumber;
        this.intercom = intercom;
    }

    public UserAddress(int id, String country, String city, String streetName, int houseNumber, String frame, String entranceNumber, String apartmentNumber, String intercom) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.frame = frame;
        this.entranceNumber = entranceNumber;
        this.apartmentNumber = apartmentNumber;
        this.intercom = intercom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(String entranceNumber) {
        this.entranceNumber = entranceNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getIntercom() {
        return intercom;
    }

    public void setIntercom(String intercom) {
        this.intercom = intercom;
    }
}
