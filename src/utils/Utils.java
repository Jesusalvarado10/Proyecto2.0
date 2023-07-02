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
     *
     * @return
     */
    public static int requestDNI() {
        int dni;
        // =====================================================================
        dni = Integer.parseInt(JOptionPane.showInputDialog("Cédula por favor (Sólo números)"));
        // =====================================================================
        return dni;
    }

    /**
     *
     * @return
     */
    public static String requestName() {
        String name;
        // =====================================================================
        name = JOptionPane.showInputDialog("Nombre por favor");
        // =====================================================================
        return name;
    }

    /**
     *
     * @return
     */
    public static String requestLastame() {
        String name;
        // =====================================================================
        name = JOptionPane.showInputDialog("Apellido por favor");
        // =====================================================================
        return name;
    }

    /**
     *
     * @return 
     */
    public static int requestNumBedroom() {
        int bedroom = -1;
        // =====================================================================

        // =====================================================================
        return bedroom;
    }
}
