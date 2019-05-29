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
public class Blood {
    
    private int id;
    private String name;
    private int qty;

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public Blood(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public Blood(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public Blood(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Blood(int id, int qty) {
        this.id = id;
        this.qty = qty;
    }
    
}
