/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bedroom.Bedroom;
import excelManager.ExcelManager;
import gui.MainGUI;
import hashTable.HashTable;
import java.io.File;
import linkedList.LinkedList;
import reservation.Reservation;
import user.User;

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
        // this.gui();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions">   
    /**
     * READY
     *
     * @param numDni
     */
    public void searchReservation(int numDni) {
        // NOTA: La búsqueda de reservaciones se hacen en xlsx.reservas
        LinkedList reservas = xlsx.reservas.copyList();
        reservas.sort();
        // =====================================================================
        // User data introducing: 10_000_000, 19_998_198, 14_223_456
        int dni = numDni;
        Reservation reserv = reservas.seachBina(dni, reservas);
        // =====================================================================
        // Verification
        if (reserv != null) {
            reserv.show();
        } else {
            System.out.println("[!] ERROR: La reservación no existe!");
        }
    }

    /**
     * READY
     *
     * @param numBed
     */
    public void searchBedroomHistorial(int numBed) {
        // NOTA: La búsqueda de historial se hacen en xlsx.habs
        Bedroom[] habs = this.xlsx.habs;
        // =====================================================================
        // User data introducing. Ex: 3100, 256, 300, 1
        int numBedroom = numBed;
        // =====================================================================
        // Control error
        if (numBedroom <= habs.length && numBedroom > 0) {
            habs[numBedroom - 1].getTree().inOrder(habs[numBedroom - 1].getTree().getpRoot());
        } else {
            System.out.println("[!] ERROR: La habitación introducida no es válida");
        }
    }

    /**
     *
     */
    public void checkIn() {

    }

    /**
     *
     */
    public void checkOut() {

    }

    /**
     *
     * @param name
     * @param lastname
     */
    public void searchHosted(String name, String lastname) {
        // NOTA: La búsqueda de habitaciones hospedadas se hacen en xlsx.statusHabs
        HashTable hash = this.xlsx.statusHabs;
        // =====================================================================
        String nameTo = name.toLowerCase();
        String lastnameTo = lastname.toLowerCase();
        // =====================================================================
        User aux = (User) hash.search(nameTo, lastnameTo);
        // =====================================================================
        if (aux != null){
            aux.show();
        } else {
            System.out.println("[!] ERROR: El cliente no se encuentra");
        }
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
