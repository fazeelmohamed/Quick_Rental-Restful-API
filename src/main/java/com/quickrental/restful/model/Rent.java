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

    @Column(name = "startMilage", columnDefinition="Decimal(10,2) default '0.00'")
    private double startMilage;

    @Column(name = "endMilage", columnDefinition="Decimal(10,2) default '0.00'")
    private double endMilage;

    @Column(name = "advanceAmount", columnDefinition="Decimal(10,2) default '0.00'")
    private double advanceAmount;

    @Column(name = "amount", columnDefinition="Decimal(10,2) default '0.00'")
    private double amount;

    @Column(name = "description",length = 500)
    private String description;

    @Column(name = "isFinished", columnDefinition = "tinyint default false")
    private boolean isFinished;

    @Column(name = "status")
    private int status;

    @OneToOne
    @JoinColumn(name = "customerId",referencedColumnName="id")
    private User customer;
    @OneToOne
    @JoinColumn(name = "vehicleId",referencedColumnName="id")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
