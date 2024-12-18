package com.parking.parkinglot1.ejb;


import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import java.util.Set;
import java.util.HashSet   ;
import java.io.Serializable;

@Stateful
@SessionScoped
public class InvoiceBean implements Serializable {
    Set<Long> userIds= new HashSet<>();

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }
}
