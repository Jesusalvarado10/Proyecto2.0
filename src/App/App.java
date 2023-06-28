/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import ExcelManager.ExcelManager;
import MainUI.MainUI;

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
    public void searchReservation() {
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
    private void openUI() {
        MainUI gui = new MainUI(this.title, this);
    }

    private void excel() {
    }
    // </editor-fold>
}
