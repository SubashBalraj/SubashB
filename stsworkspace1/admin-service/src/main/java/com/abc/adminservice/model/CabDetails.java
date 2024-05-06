package com.abc.adminservice.model;


import lombok.Data;

@Data
public class CabDetails {

    private int cabId;
    private String carType;
    private float ratePerKm;
    private int driverId;

    private Driver driver;
}
