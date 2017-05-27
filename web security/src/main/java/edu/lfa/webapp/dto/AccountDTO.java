/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.dto;

/**
 *
 * @author LAKHE
 */
public class AccountDTO {
    private int id;
    private String name;
    private double interest;
    private int balance;
    private boolean status;

    public AccountDTO() {
    }

    public AccountDTO(int id, String name, double interest, int balance, boolean status) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.balance = balance;
        this.status = status;
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

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
