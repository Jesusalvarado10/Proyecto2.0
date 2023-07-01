/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bedroom.Bedroom;
import binaryTree.Node;
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
    private Bedroom[] habs;
    /**
     *
     */
    private LinkedList reserv;
    /**
     *
     */
    private HashTable status;

    /**
     *
     */
    public void start() {
        this.excel();
        this.checkOut("Karilynn", "Gant");
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
        // =====================================================================
        // User data introducing: 10_000_000, 19_998_198, 14_223_456
        int dni = numDni;
        Reservation booking = reserv.seachBina(dni, reserv);
        // =====================================================================
        // Verification
        if (booking != null) {
            booking.show();
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
     * READY
     *
     * @param dni
     */
    public void checkIn(int dni) {
        // NOTA: Para hacer el checkIn necesitamos: 
        // =====================================================================
        User user_aux;
        int counter;
        // =====================================================================
        // Buscar según el DNI, la reservación
        user_aux = null;
        counter = 0;
        Reservation booking = (Reservation) reserv.seachBina(dni, reserv);
        // =====================================================================
        // Buscar habitación con la reservación, verificar si está disponible la habitación
        for (Bedroom aux : habs) {
            counter++;

            // Condición: Si no está ocupado
            if (!aux.isOccupied()) {
                System.out.println("NO ESTÁ OCUPADA!!! ");

                // Condición: Si es el mismo tipo que la reservada
                if (aux.getType().equals(booking.getType())) {
                    user_aux = booking.getUser();
                    aux.setOccupied(true);
                    user_aux.setNum(counter);
                    break;
                }
            }
        }
        // =====================================================================
        if (user_aux != null) {
            status.insert(user_aux);
            System.out.println("[+] Su Check-In ha sido completado con éxito");
        } else {
            System.out.println("[!] ERROR: No tiene reserva, por lo tanto NO puede hacer Check-In");
        }
    }

    /**
     *
     * @param name
     * @param lastname
     */
    public void checkOut(String name, String lastname) {
        // NOTE: Para hacer Check-Out necesitamos el (nombre) y el (apellido)
        // =====================================================================
        User user_aux;
        String nameTo = name.toLowerCase();
        String lastnameTo = lastname.toLowerCase();
        // =====================================================================
        // Buscar usuario
        user_aux = status.search(nameTo, lastnameTo);
        // =====================================================================
        // Si el usuario existe, lo eliminas
        if (user_aux != null) {
            // Elimina...
            user_aux.show();
            status.delete(nameTo, lastnameTo);

            // Elimina...
            habs[user_aux.getNum()].setOccupied(false);
            Node aux = new Node(user_aux);
            habs[user_aux.getNum()].getTree().insert(habs[user_aux.getNum()].getTree().getpRoot(), aux);
        }
    }

    /**
     * READY
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
        if (aux != null) {
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
        // =====================================================================
        habs = this.xlsx.habs;
        reserv = this.xlsx.reservas.copyList();
        reserv.sort();
        status = this.xlsx.statusHabs;
    }

    /**
     *
     */
    private void gui() {
        MainGUI gui = new MainGUI(this.title);
    }
    // </editor-fold> 
}
