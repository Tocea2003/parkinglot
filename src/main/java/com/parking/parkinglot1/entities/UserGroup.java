package com.parking.parkinglot1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserGroup {
    private long id;
    private String username;
    private String UserGroup;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public  String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserGroup() {
        return UserGroup;
    }
    public void setUserGroup(String userGroup) {
        this.UserGroup = userGroup;
    }
}