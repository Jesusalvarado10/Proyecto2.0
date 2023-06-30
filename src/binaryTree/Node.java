/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

/**
 *
 * @author Daniel
 * @param <T>
 */
public class Node<T> {

    /**
     *
     */
    T dato;
    /**
     *
     */
    Node left;
    /**
     *
     */
    Node right;

    /**
     *
     * @param dato
     */
    public Node(T dato) {
        this.dato = dato;
        this.right = null;
        this.left = null;
    }

    /**
     *
     * @return
     */
    public T getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
}
