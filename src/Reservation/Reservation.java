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

    /**
     * User information of reservation
     */
    private User user;
    /**
     * Tipo de habitación: Simple, doble, triple, suite
     */
    private String type;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Reservation(User user, String type) {
        this.user = user;
        this.type = type;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="User">   
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Type">   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="FUNCIÓN: Buscar reservación">   
    public int getDni() {
        return user.getDni();
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Show">   
    public void show() {
        System.out.println(user.getDni());
        user.show();
    }
    // </editor-fold>  
}
