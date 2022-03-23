/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Chuong
 */
public class Human {

    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private HumanType type;

    public Human() {
    }

    public Human(int id, String name, Date dob, boolean gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public Human(int id, String name, Date dob, boolean gender, HumanType type) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.type = type;
    }
    
    public Human(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public HumanType getType() {
        return type;
    }

    public void setType(HumanType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Human{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", type=" + type + '}';
    }
}
