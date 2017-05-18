package com.quickrental.restful.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@Entity
@Table(name = "hire")
public class Hire implements Serializable {


    private static final long serialVersionUID = -3266670305976286165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "destination")
    private String destination;

    @Column(name = "hireDate")
    private String hireDate;

    @Column(name = "hireTime")
    private String hireTime;

    @Column(name = "startMilage",columnDefinition="Decimal(10,2) default '0.00'")
    private double startMilage;

    @Column(name = "endMilage",columnDefinition="Decimal(10,2) default '0.00'")
    private double endMilage;

    @Column(name = "amount", columnDefinition="Decimal(10,2) default '0.00'")
    private double amount;

    @Column(name = "bookingSeats")
    private int bookingSeats;

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
    @JoinColumn(name = "driverId",referencedColumnName="id")
    private User driver;
    @OneToOne
    @JoinColumn(name = "vehicleId",referencedColumnName="id")
    private Vehicle vehicle;

    public Hire(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBookingSeats() {
        return bookingSeats;
    }

    public void setBookingSeats(int bookingSeats) {
        this.bookingSeats = bookingSeats;
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

    public String getHireTime() {
		return hireTime;
	}

	public void setHireTime(String hireTime) {
		this.hireTime = hireTime;
	}
}
