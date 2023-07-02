/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JOptionPane;
import bedroom.Bedroom;
import binaryTree.Node;
import excelManager.ExcelManager;
import gui.MainGUI;
import gui.ShowClientGUI;
import hashTable.HashTable;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import linkedList.LinkedList;
import reservation.Reservation;
import user.User;
import utils.Errors;
import utils.Utils;

// <editor-fold defaultstate="collapsed" desc="============">   
// </editor-fold> 
/**
 *
 * @author Daniel
 */
public class App {

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
        this.updateFormatRequest();
        this.gui();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions">   
    /**
     * READY
     *
     * @param numDni
     */
    public void searchReservation() {
        // NOTA: La búsqueda de reservaciones se hacen en xlsx.reservas
        try {
            int dni = Utils.requestDNI();
            // =================================================================
            LinkedList d = reserv.copyList();
            Reservation booking = (Reservation) reserv.seachBina(dni, d);
            // =================================================================
            if (booking != null){
                User user_aux = booking.getUser();
                ShowClientGUI show = new ShowClientGUI(user_aux);
                
            } else {
                Errors.reservationNotFounded();
            }
        } catch (Exception e) {
            Errors.invalidInput();
        }
    }

    /**
     * READY
     *
     * @param numBed
     */
    public void searchBedroomHistorial() {
        // NOTA: La búsqueda de historial se hacen en xlsx.habs
        // =====================================================================
        // User data introducing. Ex: 3100, 256, 300, 1
        int numBedroom = Integer.parseInt(JOptionPane.showInputDialog("Numero de la habitacion").replace(" ", ""));
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
    public void checkIn() {
        // NOTA: Para hacer el checkIn necesitamos: 
        // =====================================================================
        int dni = Integer.parseInt(JOptionPane.showInputDialog("Cedula").replace(" ", ""));
        User user_aux;
        int counter;
        LinkedList d = reserv.copyList();
        // =====================================================================
        // Buscar según el DNI, la reservación
        user_aux = null;
        counter = 0;
        Reservation booking = (Reservation) reserv.seachBina(dni, d); // Se copia una lista porque despues de hacer la busqueda asi la lista se rompe
        if (booking == null) {
            System.out.println("[!] ERROR No tiene reserva, por lo tanto NO puede hacer Check-In");
            return;
        }

        // =====================================================================
        // Buscar habitación con la reservación, verificar si está disponible la habitación
        for (Bedroom aux : habs) {
            counter++;

            // Condición: Si no está ocupado
            if (!aux.isOccupied()) {
                System.out.println("[I] NO ESTÁ OCUPADA!!! ");

                // Condición: Si es el mismo tipo que la reservada
                if (aux.getType().equals(booking.getType())) {
                    reserv.deleteReserv(booking); //Se elimina el valor de las reservas ya que no puede permanecer ahi 
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
            System.out.println("[!] No hay habitaciones disponibles "); //Si tiene reserva lo que sucede es que no hay habitaciones

        }
    }

    /**
     *
     * @param name
     * @param lastname
     */
    public void checkOut() {
        // NOTE: Para hacer Check-Out necesitamos el (nombre) y el (apellido)
        // =====================================================================
        String name = JOptionPane.showInputDialog("Nombre");
        String lastname = JOptionPane.showInputDialog("Apellido");
        User user_aux;
        // =====================================================================
        // Buscar usuario
        user_aux = status.search(name, lastname);
        // =====================================================================
        // Si el usuario existe, lo eliminas
        if (user_aux != null) {
            // Elimina...
            status.delete(name, lastname);

            // Elimina...
            int index = user_aux.getNum() - 1;
            habs[index].setOccupied(false);
            if (user_aux.getDni() == 0) {
                int dni = Integer.parseInt(JOptionPane.showInputDialog("Cedula").replace(" ", ""));
                user_aux.setDni(dni);
            }
            // input dni y si no esta en el arbol  (con alguno de los recorridos) a;adirlo porque los usuarios que provienen de las habitaciones (Estados) no tiene cedula 
            Node aux = new Node(user_aux);
            habs[index].getTree().insert(habs[index].getTree().getpRoot(), aux);
            habs[index].getTree().inOrder(habs[index].getTree().getpRoot());
        } else {
            System.out.println("[!] ERROR: No existe el usuario");
        }
    }

    /**
     * READY
     *
     * @param name
     * @param lastname
     */
    public void searchHosted() {
        try{
            String[] info = Utils.requestBasicInformation();
            String name = info[0];
            String lastname = info[1];
            User aux = (User) status.search(name, lastname);

            if (aux != null){
                aux.show();
                System.out.println(aux.getNum());
            }
            else {
                Errors.hostedNotFounded();
            }
            
        } catch (Exception e){
            System.out.println(e);
            Errors.undefinedError();
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
        MainGUI gui = new MainGUI(this.title, this);
    }

    private void updateFormatRequest() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
    // </editor-fold> 
}