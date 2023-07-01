/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import reservation.Reservation;
import user.User;

/**
 *
 * @author Daniel
 */
public class LinkedList<T> {

    Node head;
    Node tail;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Tail">   
    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Head">   
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Basic functions">   
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        Node aux = head;
        int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getNext();
        }
        return i;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Advance functions">   
    public LinkedList rotate() {
        Node aux = head;
        LinkedList volteada = new LinkedList();
        while (aux != null) {
            volteada.addFirst(aux.getDato());
            aux = aux.getNext();
        }

        return volteada;
    }

    public void sort() {
        Node pivot = head;
        Node siguiente;
        Node antes;
        siguiente = pivot.getNext();
        antes = null;
        boolean iteraccion = false;
        while (siguiente != null) {
            Reservation r = (Reservation) pivot.getDato();
            Reservation a = (Reservation) siguiente.getDato();
            if (antes == null) {
                if ((int) r.getDni() > (int) a.getDni()) {
                    pivot.setNext(siguiente.getNext());
                    antes = siguiente;
                    antes.setNext(pivot);
                    siguiente = pivot.getNext();
                    head = antes;
                    iteraccion = true;
                } else {
                    antes = pivot;
                    pivot = antes.getNext();
                    siguiente = pivot.getNext();
                }
            } else {
                if ((int) r.getDni() > (int) a.getDni()) {
                    pivot.setNext(siguiente.getNext());
                    siguiente.setNext(pivot);
                    antes.setNext(siguiente);
                    antes = siguiente;
                    siguiente = pivot.getNext();
                    iteraccion = true;
                } else {
                    antes = pivot;
                    pivot = antes.getNext();
                    siguiente = pivot.getNext();
                }
            }
        }
        if (iteraccion == true) {
            sort();
        }
    }

    public Node mergeSort(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.getNext();
        middle.setNext(null);
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);
        Node sortedList = merge(left, right);
        return sortedList;
    }

    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        Node sortedList = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Reservation r = (Reservation) left.getDato();
        Reservation a = (Reservation) left.getDato();
        if (r.getUser().getDni() <= a.getUser().getDni()) {
            sortedList = left;
            sortedList.setNext(merge(left.getNext(), right));
        } else {
            sortedList = right;
            sortedList.setNext(merge(left, right.getNext()));
        }
        return sortedList;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Add">   
    public void addFirst(T dato) {
        Node aux = new Node(dato);
        if (isEmpty()) {
            setHead(aux);
            setTail(aux);

        } else {
            aux.setNext(head);
            setHead(aux);

        }
    }

    public void addLast(T dato) {
        Node aux = new Node(dato);
        if (isEmpty()) {
            setHead(aux);
            setTail(aux);

        } else {
            getTail().setNext(aux);
            setTail(aux);

        }

    }

    public void addInIndex(int index, T dato) {
        Node aux = new Node(dato);

        if (isEmpty()) {
            setHead(aux);
        } else {
            if (index > size()) {
                // JOptionPane.showMessageDialog(null, "Esta fuera del tamaño de la lista");
            } else {
                Node pivot = getHead();
                int count = 0;
                while (count < (index - 1) && pivot.getNext() != null) {
                    pivot = pivot.getNext();
                    count++;
                }
                aux.setNext(pivot.getNext());
                pivot.setNext(aux);
            }
        }
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Delete">   
    public void deleteFirst() {
        if (!isEmpty()) {
            Node pivot = getHead();
            setHead(pivot.getNext());
            pivot.setNext(null);
        } else {
            // JOptionPane.showMessageDialog(null, "Esta vacia");
        }
    }

    public void deleteLast(String name, String last_name) {

        if (!isEmpty()) {
            Node pivot = getHead();
            User r = (User) pivot.getDato();
            if (r.getName() == name && r.getLast_name() == last_name) {
                setHead(null);
            } else {
                while (pivot.getNext() != null) {
                    r = (User) pivot.getNext().getDato();
                    if (r.getName() == name && r.getLast_name() == last_name) {
                        pivot.setNext(pivot.getNext().getNext());
                    }
                    pivot = pivot.getNext();
                }
            }

        } else {
            // JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void deleteLast() {

        if (!isEmpty()) {
            Node pivot = getHead();

            if (size() == 1) {
                setHead(null);

            } else {
                while (pivot.getNext() != null && pivot.getNext().getNext() != null) {
                    pivot = pivot.getNext();
                }
                Node last = pivot.getNext();
                pivot.setNext(null);
                setTail(pivot);
            }

        } else {
            // JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void deleteInIndex(int index) {
        if (!isEmpty()) {
            Node pivot = getHead();
            if (index > size()) {
                // JOptionPane.showMessageDialog(null, "Esta fuera del tamaño");
            } else {
                int count = 0;
                while (count < (index - 1) && pivot.getNext() != null) {
                    pivot = pivot.getNext();
                    count++;
                }
            }
            Node aux = pivot.getNext();
            pivot.setNext(aux.getNext());
            aux.setNext(null);
        }
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Show">   
    public void show() {
        Node aux = head;
        while (aux != null) {
            User r = (User) aux.getDato();
            r.show();
            aux = aux.next;
        }
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Extra functions">
    /**
     * Busca con el (nombre) y (apellido) proporcionado el nodo en el que se
     * ubica esta información en la lista
     *
     *
     * @param data Nombre del usuario
     * @param data2 Apellido del usuario
     * @return Nodo si este existe. Null si no existe ningún nodo con esa
     * información
     */
    public T getDato(String data, String data2) {
        // Es para obtener el valor del nodo que buscamos, despues de usar el search, igualmente se usa parametos especificos para el tipo de dato.
        Node aux = head;
        while (aux != null) {
            User u = (User) aux.getDato();
            if (u.getName().equals(data) && u.getLast_name().equals(data2)) {
                return (T) aux.getDato();
            }

            aux = aux.getNext();
        }
        return null;
    }

    /**
     * Función que según la posición dada, devuelve los datos almacenados en el
     * nodo
     *
     * @param d Posición
     * @return Nodo. Null si la posición no es válida
     */
    public T getValuePosition(int d) {
        Node aux = head;
        int i = 0;
        while (aux != null) {
            if (i == d) {
                return (T) aux.getDato();
            }
            i++;
            aux = aux.getNext();
        }
        return null;
    }

    /**
     * ?????
     *
     * @param dato
     * @return
     */
    public int getPosicion(T dato) {
        Node aux = head;
        int i = 0;
        while (aux != null) {
            if ((int) aux.getDato() == (int) dato) {
                return i;
            }
            i++;
            aux = aux.getNext();
        }
        return -1;
    }

    /**
     * Busca con el (nombre) y el (apellido) de la persona, el nodo
     *
     *
     * @param data Nombre de la persona
     * @param data2 Apellido de la persona
     * @return True si existe el nodo. False si no existe
     */
    public boolean search(T data, T data2) {
        Node aux = head;
        while (aux != null) {
            User u = (User) aux.getDato();
            if (u.getName() == data && u.getLast_name() == data2) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    /**
     *
     * @return
     */
    public LinkedList copyList() {
        LinkedList n = new LinkedList();
        Node aux = head;
        while (aux != null) {
            n.addLast(aux.getDato());
            aux = aux.getNext();

        }
        return n;

    }

    /**
     *
     * @param dni
     * @param aux
     * @param counter
     * @return
     */
    public Reservation seachBina(T dni, LinkedList aux) {
        Node middle = getMiddle(aux.getHead());
        Reservation r = (Reservation) middle.getDato();
        Reservation lastReserv = (Reservation) aux.tail.getDato();
        Reservation firstReserv = (Reservation) aux.head.getDato();

        // CONTROL ERROR
        if ((int) dni > lastReserv.getDni()) {
            System.out.println("[!] DNI INVÁLIDO");
            return null;

        } else if ((int) dni < firstReserv.getDni()) {
            System.out.println("[!] DNI INVÁLIDO");
            return null;

        } else if ((int) dni == lastReserv.getDni()) {
            return lastReserv;
        } // Algorithm
        else {
            // Si el valor de la mitad de la lista es menor: Se corta desde el 
            // valor tomado (Pasa a ser el último) 
            if (r.getDni() < (int) dni) {
                aux.setHead(middle);
                return seachBina(dni, aux);

                // Si el valor de la mayor de la lista es mayor: Se corta desde el 
                // valor tomado (Pasa a ser el primero)
            } else if (r.getDni() > (int) dni) {
                middle.setNext(null);
                aux.setTail(middle);
                return seachBina(dni, aux);

            } else if (r.getDni() == (int) dni) {
                return (Reservation) middle.getDato();

            } else {
                return null;
            }
        }
    }

    /**
     * Elimina el nodo de la lista
     *
     * @param data Tipo de dato (User, reservation, bedroom, etc)
     */
    public void delete(T data) {
        Node aux = head;
        Node prev = null;
        String x;
        while (aux != null) {
            if (prev == null) {
                if (aux.getDato() == data) {
                    head = null;
                    break;
                }
            } else {
                if (aux.getDato() == data) {
                    prev.setNext(aux.getNext());
                    aux.setNext(null);
                    break;
                }
            }
            prev = aux;
            aux = prev.getNext();
        }
    }

    /**
     * ?????
     *
     * @param data
     * @return
     */
    public T search2(T data) {
        Node aux = head;
        while (aux != null) {
            String[] numeros = (String[]) aux.getDato();
            if ((int) data == Integer.parseInt(numeros[1])) {
                return (T) aux.getDato();
            }
            aux = aux.getNext();
        }
        return null;
    }
    // </editor-fold> 
}
