/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

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
        p.show();
        int dni = Integer.parseInt(JOptionPane.showInputDialog(null, "dni:"));
        Reservation d = (Reservation) reserv.seachBina(dni, p);
        if (d == null) {
            JOptionPane.showMessageDialog(null, "No se encuentra");
            return;
        }
        d.show();

    }

    public void searchBedroomHistorial(Bedroom[] habs) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "dni:"));
        habs[num].getTree().preOrder(habs[num].getTree().getpRoot());
    }

    public void checkIn(Bedroom[] habs,Lista reserv,HashTable status) {
        User u= null;
        int num=0;
        Lista p= reserv.copyList();
        int dni = Integer.parseInt(JOptionPane.showInputDialog(null, "dni:"));
        u= (User)((Reservation)reserv.seachBina(dni, p)).getUser();
        for (Bedroom h: habs) uuuuuu{
            num++;
uuuuuuuuuuuuuuuuuu/u           
}
    }

    public void checkOut() {
    }

    public void searchHosted(HashTable status) {
        String name = JOptionPane.showInputDialog(null, "Ingerese su nombre:").replace(" ", "");
        String last_name = JOptionPane.showInputDialog(null, "Ingerese su apellido:").replace(" ", "");

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
