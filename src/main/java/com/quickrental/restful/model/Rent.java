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

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "startMilage")
    private double startMilage;

    @Column(name = "endMilage")
    private double endMilage;

    @Column(name = "advanceAmount")
    private double advanceAmount;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description",length = 500)
    private int description;

    @Column(name = "isFinished")
    private boolean isFinished;

    @Column(name = "status")
    private int status;

    @OneToOne
    @JoinColumn(name = "id")
    private User customer;
    @OneToOne
    @JoinColumn(name = "id")
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

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
