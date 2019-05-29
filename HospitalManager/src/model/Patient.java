/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Media
 */
public class Patient {
    
    private int id;
    private String name;
    private String phone;
    private int branchId;
    private Blood blood;

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public Patient(int id, String name, String phone, int branchId, Blood blood) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.branchId = branchId;
        this.blood = blood;
    }
    
    public Patient(int id, String name, String phone, Blood blood) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.blood = blood;
    }

    public Patient(int id, String name, String phone, int branchId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.branchId = branchId;
    }
    
    public Patient(String name, String phone, Blood blood) {
        this.name = name;
        this.phone = phone;
        this.blood = blood;
    }
    
    public Patient(String name, String phone) {
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public Patient() {
    }
    
    
    
}
