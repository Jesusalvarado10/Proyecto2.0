/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

/**
 *
 * @author Daniel
 */
public class Node<T> {

    /**
     * 
     */
    T dato;
    /**
     * 
     */
    Node next;

    /**
     * 
     * @param dato
     */
    public Node(T dato) {
        this.dato = dato;
        this.next = null;
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
    public Node getNext() {
        return next;
    }

    /**
     * 
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
