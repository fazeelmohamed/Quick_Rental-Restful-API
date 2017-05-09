package com.quickrental.restful.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
public class Hire implements Serializable {


    private static final long serialVersionUID = -3266670305976286165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "startMilage")
    private double startMilage;

    @Column(name = "endMilage")
    private double endMilage;

    @Transient
    private User customer;
    @Transient
    private User driver;
    @Transient
    private Vehicle vehicle;

    public Hire(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getStartMilage() {
        return startMilage;
    }

    public void setStartMilage(double startMilage) {
        this.startMilage = startMilage;
    }

    public double getEndMilage() {
        return endMilage;
    }

    public void setEndMilage(double endMilage) {
        this.endMilage = endMilage;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
