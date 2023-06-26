/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import User.User;

/**
 *
 * @author User
 */
public class Reservation {
    private User user;
    private String type;

    public Reservation(User user, String type) {
        this.user = user;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }  
    public int getDni(){
    return user.getDni();
    }
    public void show(){
        System.out.println(user.getDni());
        System.out.println(user.getName());
    
    
    }
}
