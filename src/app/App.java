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
        while (true) {
            String opcion = JOptionPane.showInputDialog("1.Buscar reservacion \n2.Historial de la habitacion \n3.Check in \n4.Check out\n5.Mostar datos por habitacion");
            if ("1".equals(opcion)) {
                this.searchReservation();
            } else if ( "2".equals(opcion)) {
                this.searchBedroomHistorial();
            } else if ("3".equals(opcion)) {
               this.checkIn();
            } else if ("4".equals(opcion)) {
                 this.checkOut();
            } else if ("5".equals(opcion)) {
                this.searchHosted();
            } else {
                
            }

          
        }
//        this.checkIn(13942957);
        // this.gui();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions">   
    /**
     * READY
     *
     * @param numDni
     *///Meade | Abramchik | Female | mabramchik3e@opensource.org | (398) 6399581
//Indice238
    public void searchReservation() {
        // NOTA: La búsqueda de reservaciones se hacen en xlsx.reservas
        // =====================================================================
        // User data introducing: 10_000_000, 19_998_198, 14_223_456
        LinkedList d = reserv.copyList();
        int dni = Integer.parseInt(JOptionPane.showInputDialog("Cedula").replace(" ", ""));
        Reservation booking = (Reservation) reserv.seachBina(dni, d);
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

//        booking.show();
        // =====================================================================
        // Buscar habitación con la reservación, verificar si está disponible la habitación
        for (Bedroom aux : habs) {
            counter++;
//            System.out.println("SAKDFL");

            // Condición: Si no está ocupado
            if (!aux.isOccupied()) {
                System.out.println("NO ESTÁ OCUPADA!!! ");

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
            user_aux.show();
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
            //elimina
            status.delete(name, lastname);

            // Elimina...
            int index = user_aux.getNum()-1;
            habs[index].setOccupied(false);
            if (user_aux.getDni()==0){
                int dni=Integer.parseInt(JOptionPane.showInputDialog("Cedula").replace(" ", ""));
            user_aux.setDni(dni);}
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
        // NOTA: La búsqueda de habitaciones hospedadas se hacen en xlsx.statusHabs
        HashTable hash = this.xlsx.statusHabs;
        // =====================================================================
        String name = JOptionPane.showInputDialog("Nombre");
        String lastname = JOptionPane.showInputDialog("Apellido");
   
        // =====================================================================
        User aux = (User) hash.search(name, lastname);
        // =====================================================================
        if (aux != null) {
            aux.show();
            System.out.println(aux.getNum());
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
