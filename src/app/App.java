/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bedroom.Bedroom;
import excelManager.ExcelManager;
import gui.MainGUI;
import java.io.File;
import linkedList.LinkedList;
import reservation.Reservation;

// <editor-fold defaultstate="collapsed" desc="============">   
// </editor-fold> 
/**
 *
 * @author Daniel
 */
public class App {
    // 1. Excel class
    // 2. Open GUI
    /*
        2.1. Reservas: xlsx.reservas
        2.2. Habitaciones: xlsx.habs
        2.3. Estado: xlsx.statusHabs
    */

    /**
     *
     */
    private String title = "CRUD PROJECT V2";
    /**
     *
     */
    private ExcelManager xlsx = new ExcelManager();
    /**
     *
     */
    private String databasePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "database" + File.separator + "database.xlsx";

    /**
     *
     */
    public void start() {
        this.excel();
        this.searchReservation();
        // this.gui();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions">   
    public void searchReservation() {
        // NOTA: La búsuqeda de reservaciones se hacen en xlsx.reservas
        LinkedList reservas = xlsx.reservas.copyList();
        reservas.sort();
        // =====================================================================
        // User data
        int dni = 30085424;
        Reservation reserv = reservas.seachBina(dni, reservas);
        // =====================================================================
        // Verification
        if (reserv != null){
            reserv.show();
        } else{
            System.out.println("[!] ERROR: La reservación no existe!");
            // ERRROR: NO SE ENCUENTRA
        }
    }

    public void searchBedroomHistorial() {

    }

    public void checkIn() {

    }

    public void checkOut() {

    }

    public void searchHosted() {

    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="App functions">   
    /**
     *
     */
    private void excel() {
        xlsx.read(this.databasePath);
    }

    /**
     *
     */
    private void gui() {
        MainGUI gui = new MainGUI(this.title);
    }
    // </editor-fold> 
}
