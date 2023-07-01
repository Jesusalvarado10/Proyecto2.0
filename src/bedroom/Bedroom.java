/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedroom;

import binaryTree.Tree;

/**
 *
 * @author Daniel
 */
public class Bedroom {

    /**
     *
     */
    private String type;
    /**
     *
     */
    private int floor;
    /**
     *
     */
    private boolean occupied;
    /**
     *
     */
    private Tree tree;

    /**
     *
     * @param type
     * @param floor
     */
    public Bedroom(String type, int floor) {
        this.type = type;
        this.floor = floor;
        this.tree = new Tree();
    }

    /**
     *
     * @return
     */
    public Tree getTree() {
        return tree;
    }

    /**
     *
     * @param tree
     */
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    /**
     *
     * @return
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     *
     * @param occupied
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getFloor() {
        return floor;
    }

    /**
     *
     * @param floor
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     *
     */
    public void show() {
        System.out.println(type);
        System.out.println(floor);

    }
}
