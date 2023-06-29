/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bedroom;

import ArbolesBinarios.Arbol;

/**
 *
 * @author User
 */
public class Bedroom {

    private String type;
    private int floor;
    private boolean occupied;
    private Arbol tree;

    public Bedroom(String type, int floor) {
        this.type = type;
        this.floor = floor;
        this.tree = new Arbol();
    }

    public Arbol getTree() {
        return tree;
    }

    public void setTree(Arbol tree) {
        this.tree = tree;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void show() {
        System.out.println(type);
        System.out.println(floor);

    }
}
