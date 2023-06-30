/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import ArbolesBinarios.Nodo;
import Bedroom.Bedroom;
import ExcelManager.ExcelManager;
import HashTable.HashTable;
import Lista.Lista;
import MainUI.MainUI;
import Reservation.Reservation;
import User.User;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class App {

    private String title = "CRUD project in java";
    private ExcelManager exm = new ExcelManager();

    public void start() {
        this.openUI();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions"> 
    public void searchReservation(Lista reserv) {
        reserv.sort();
        Lista p = reserv.copyList();
        int dni = Integer.parseInt(JOptionPane.showInputDialog(null, "dni:"));
        Reservation d = (Reservation) reserv.seachBina(dni, p);
        if (d == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra");
            return;
        }
        d.show();

    }

    public void searchBedroomHistorial(Bedroom[] habs) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de la habitacion:"));
        if (num < habs.length && num > 0) {
            habs[num - 1].getTree().inOrder(habs[num - 1].getTree().getpRoot());
            return;
        }
        JOptionPane.showMessageDialog(null, "No se encuentra habitacion ");
    }

    public void checkIn(Bedroom[] habs, Lista reserv, HashTable status) {
        User u = null;
        int num = 0;
        Lista p = reserv.copyList();
        int dni = Integer.parseInt(JOptionPane.showInputDialog(null, "dni:"));
        Reservation o = (Reservation) reserv.seachBina(dni, p);

        for (Bedroom h : habs) {
            num++;
            if (!h.isOccupied() && h.getType().equals(o.getType())) {
                u = o.getUser();
                h.setOccupied(true);
                u.setNum(num);
                break;
            }
        }
        if (u == null) {
            JOptionPane.showMessageDialog(null, "No hay habitacion vacia");
            return;
        }
        status.insert(u);
        JOptionPane.showMessageDialog(null, "Felicidades");
    }

    public void checkOut(Bedroom[] habs, HashTable status) {
        User u = null;
        while (true) {
            String name = JOptionPane.showInputDialog(null, "Ingerese su nombre:").replace(" ", "");
            String last_name = JOptionPane.showInputDialog(null, "Ingerese su apellido:").replace(" ", "");
            try {
                char i = (name.charAt(0));
                String f = String.valueOf(i).toUpperCase();
                name = name.replaceFirst(String.valueOf(i), f);
                System.out.println(name);
                char y = (last_name.charAt(0));
                String e = String.valueOf(y).toUpperCase();
                last_name = last_name.replaceFirst(String.valueOf(y), e);
                System.out.println(last_name);

            } catch (Exception e) {
                System.out.println("smdsa");
            }
            u = status.search(name, last_name);
            if (u != null) {
                u.show();
                String opcion = JOptionPane.showInputDialog(null, "Son sus datos?(S)(N) :").replace(" ", "");
                if ("S".equals(opcion.toUpperCase())) {
//                    status.delete(name, last_name); No tengo eliminar lista
                    break;
                }

            }
        }
        habs[u.getNum()].setOccupied(false);
        Nodo aux = new Nodo(u);
        habs[u.getNum()].getTree().insert(habs[u.getNum()].getTree().getpRoot(), aux);
    }

    public void searchHosted(HashTable status) {
        String name = JOptionPane.showInputDialog(null, "Ingerese su nombre:").replace(" ", "");
        String last_name = JOptionPane.showInputDialog(null, "Ingerese su apellido:").replace(" ", "");
        try {
            char i = (name.charAt(0));
            String f = String.valueOf(i).toUpperCase();
            name = name.replaceFirst(String.valueOf(i), f);
            System.out.println(name);
            char y = (last_name.charAt(0));
            String e = String.valueOf(y).toUpperCase();
            last_name = last_name.replaceFirst(String.valueOf(y), e);
            System.out.println(last_name);

        } catch (Exception e) {
            System.out.println("smdsa");
        }
        User u = (User) status.search(name, last_name);
        if (u == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra");
            return;
        }
        u.show();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="App functions"> 
    private void openUI() {
        MainUI gui = new MainUI(this.title, this);
    }

    private void excel() {
    }
    // </editor-fold>
}
