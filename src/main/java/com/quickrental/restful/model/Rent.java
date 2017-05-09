package com.quickrental.restful.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@Entity
@Table(name = "rent")
public class Rent implements Serializable{
    private static final long serialVersionUID = -222343080777927003L;

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

    @Column(name = "description", length = 500)
    private String description;

    @Transient
    private User customer;
    @Transient
    private Vehicle vehicle;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
