package com.quickrental.restful.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = -1637451629861950182L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "type", length = 30)
    private String type; // car, van

    @Column(name = "noOfSeats")
    private int noOfSeats;

    @Column(name = "vehicleNo", length = 50)
    private String vehicleNo;

    @Column(name = "modelName", length = 50)
    private String modelName;

    @Column(name = "rentPerDay")
    private double rentPerDay;

    @Column(name = "hirePerMilage")
    private double hirePerMilage;

    @Column(name = "colour", length = 30)
    private String colour;

    @Column(name = "year")
    private int year;

    @Column(name = "currentMillage")
    private double currentMillage;

    @Column(name = "available")
    private boolean available;

    public Vehicle(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public double getHirePerMilage() {
        return hirePerMilage;
    }

    public void setHirePerMilage(double hirePerMilage) {
        this.hirePerMilage = hirePerMilage;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCurrentMillage() {
        return currentMillage;
    }

    public void setCurrentMillage(double currentMillage) {
        this.currentMillage = currentMillage;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean available() {
        return available;
    }

    public void setAvailable(boolean available) {
        available = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", currentMillage=" + currentMillage +
                '}';
    }


}
