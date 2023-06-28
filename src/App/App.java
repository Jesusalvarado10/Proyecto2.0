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
    
    public void start(){
        this.openUI();
    }
    
    private void openUI(){
        MainUI gui = new MainUI(this.title);
    }
}
