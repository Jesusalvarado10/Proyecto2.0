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
    /**
     * Build a Reservation Class to control de clients when reserved a bedroom
     *
     * This save the User data (DNI, name, lastname, etc)
     *
     * Same save the Type of bedroom (Simple, double, triple, etc)
     *
     * @param user User information (User Class)
     * @param type Type of bedroom
     */
    public Reservation(User user, String type) {
        this.user = user;
        this.type = type;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="User">   
    /**
     * Return User of the reservation
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Update reservation owner
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Type">   
    /**
     * Return Type of reservation
     *
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * Update Type of reservation
     *
     * @param type New Type
     */
    public void setType(String type) {
        this.type = type;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="FUNCIÓN: Buscar reservación">   
    /**
     * This return DNI of the user of reservation
     * 
     * This is create because it work perfectly with the others classes
     * 
     * @return
     */
    public int getDni() {
        return user.getDni();
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Show">   
    /**
     * Show basic information 
     */
    public void show() {
        System.out.println(user.getDni());
        user.show();
    }
    // </editor-fold>  
}
