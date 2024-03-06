package com.jyothsna.payloads;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class MyFriendsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private Date metDate;

    public MyFriendsDto(int id, String firstName, String lastName, Date metDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.metDate = metDate;
    }

    public  MyFriendsDto() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getMetDate() {
        return metDate;
    }

    public void setMetDate(Date metDate) {
        this.metDate = metDate;
    }
}
