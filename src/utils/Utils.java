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
public class Utils {

    /**
     * Ready 
     * @return 
     */
    public static int requestDNI() {
        int dni = -1;
        // =====================================================================
        dni = Integer.parseInt(JOptionPane.showInputDialog("Cédula por favor (Sólo números)"));
        // =====================================================================
        return dni;
    }

    /**
     * 
     * @return 
     */
    public static String[] requestBasicInformation(){
        String[] info = new String[1];
        // =====================================================================
        info[0] = JOptionPane.showInputDialog("Nombre por favor:").trim().toLowerCase();
        info[1] = JOptionPane.showInputDialog("Apellido por favor").trim().toLowerCase();
        // =====================================================================
        return info;
    }
    
   public static int requestNumBedroom(){
       int bedroom = -1;
       // =====================================================================
       
       // =====================================================================
       return bedroom;
   }
}
