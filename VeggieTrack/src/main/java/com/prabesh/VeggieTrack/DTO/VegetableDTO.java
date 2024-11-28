package com.prabesh.VeggieTrack.DTO;

import java.util.UUID;
import java.util.Date;


public class VegetableDTO {
    private UUID id;
    private String engName;
    private String nepName;
    private String maxPrice;
    private String minPrice;
    private String avgPrice;

    private Date date;

    public VegetableDTO(UUID id, String engName, String nepName, String maxPrice, String minPrice, String avgPrice, Date date) {
        this.id = id;
        this.engName = engName;
        this.nepName = nepName;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.avgPrice = avgPrice;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getNepName() {
        return nepName;
    }

    public void setNepName(String nepName) {
        this.nepName = nepName;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
