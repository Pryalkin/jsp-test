package com.example.jsptest;

import java.sql.Date;

public class User {
    private Integer userId;
    private String username;
    private Double rating;
    private Integer numberOfVisits;
    private Date currentVisitingTime;



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", numberOfVisits=" + numberOfVisits +
                ", currentVisitingTime=" + currentVisitingTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Integer numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public Date getCurrentVisitingTime() {
        return currentVisitingTime;
    }

    public void setCurrentVisitingTime(Date currentVisitingTime) {
        this.currentVisitingTime = currentVisitingTime;
    }
}
