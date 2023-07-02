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
        name = JOptionPane.showInputDialog("Nombre por favor").trim();
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
        name = JOptionPane.showInputDialog("Apellido por favor").trim();
        // =====================================================================
        return name;
    }

    /**
     *
     * @return
     */
    public static int requestNumBedroom() {
        int bedroom;
        // =====================================================================
        bedroom = Integer.parseInt(JOptionPane.showInputDialog("Número de habitación por favor (Solo números)"));
        // =====================================================================
        return bedroom;
    }

    /**
     *
     */
    public static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
