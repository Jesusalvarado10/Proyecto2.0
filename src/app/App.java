/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import excelManager.ExcelManager;
import gui.MainGUI;
import java.io.File;

// <editor-fold defaultstate="collapsed" desc="============">   
// </editor-fold> 

/**
 *
 * @author Daniel
 */
public class App {
    // 1. Excel class
    // 2. Open GUI

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
    private String databasePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "database" + File.separator + "database.xlsx";;

    /**
     *
     */
    public void start() {
        this.excel();
        // this.gui();
    }

    // <editor-fold defaultstate="collapsed" desc="UI Functions">   
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
