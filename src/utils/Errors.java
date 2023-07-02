/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Errors {
    public static void invalidInput(){
        String msg = "ERROR: No es posible este comportamiento!";
        message(msg);
    }
    
    public static void reservationNotFounded(){
        String msg = "ERROR: La reservación no existe!";
        message(msg);
    }
    
    public static void hostedNotFounded(){
        String msg = "ERROR: El cliente no se encuntra!";
        message(msg);
    }
    
    public static void undefinedError(){
        String msg = "ERROR: Se ha producido un error inesperado!";
        message(msg);
    }
    
    private static void message(String msg){
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
