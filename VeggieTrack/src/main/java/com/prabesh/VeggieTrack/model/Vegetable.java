package com.prabesh.VeggieTrack.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="vegetables")
public class Vegetable {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "english_name")
    private String engName;

    @Column(name = "nepali_name")
    private String nepName;

    @Column(name = "max_price")
    private String maxPrice;

    @Column(name = "min_price")
    private String minPrice;

    @Column(name = "avg_price")
    private String avgPrice;

    @Column(name = "date")
    private Date date;


    public  Vegetable(){

    }

    public Vegetable(UUID id, String engName, String nepName, String maxPrice, String minPrice, String avgPrice, Date date) {
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
