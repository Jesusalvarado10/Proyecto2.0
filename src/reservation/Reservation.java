/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import user.User;

/**
 *
 * @author Daniel
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
    /**
     *
     * @param user
     * @param type
     */
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
