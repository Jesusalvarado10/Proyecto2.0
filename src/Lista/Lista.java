/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

import Reservation.Reservation;
import User.User;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 * @param <T>
 */
public class Lista<T> {

    Nodo head;
    Nodo tail;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Lista() {
        this.head = null;
        this.tail = null;
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Tail">   
    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Head">   
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Basic functions">   
    public boolean isEmpty() {
        return head == null;
    }

    public Lista rotate() {
        Nodo aux = head;
        Lista volteada = new Lista();
        while (aux != null) {
            volteada.addFirst(aux.getDato());
            aux = aux.getNext();
        }

        return volteada;
    }

    public void sort() {
        Nodo pivot = head;
        Nodo siguiente;
        Nodo antes;
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
                    antes.setNext(pivot);;
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

    public Nodo mergeSort(Nodo node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Nodo middle = getMiddle(node);
        Nodo nextOfMiddle = middle.getNext();
        middle.setNext(null);
        Nodo left = mergeSort(node);
        Nodo right = mergeSort(nextOfMiddle);
        Nodo sortedList = merge(left, right);
        return sortedList;
    }

    private Nodo getMiddle(Nodo node) {
        if (node == null) {
            return node;
        }
        Nodo slow = node;
        Nodo fast = node;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private Nodo merge(Nodo left, Nodo right) {
        Nodo sortedList = null;
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

    public int size() {
        Nodo aux = head;
        int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getNext();
        }
        return i;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Add">   
    public void addFirst(T dato) {
        Nodo aux = new Nodo(dato);
        if (isEmpty()) {
            setHead(aux);
            setTail(aux);

        } else {
            aux.setNext(head);
            setHead(aux);

        }
    }

    public void addLast(T dato) {
        Nodo aux = new Nodo(dato);
        if (isEmpty()) {
            setHead(aux);
            setTail(aux);

        } else {
            getTail().setNext(aux);
            setTail(aux);

        }

    }

    public void addInIndex(int index, T dato) {
        Nodo aux = new Nodo(dato);

        if (isEmpty()) {
            setHead(aux);

        } else {

            if (index > size()) {
                JOptionPane.showMessageDialog(null, "Esta fuera del tama;o de la lista");

            } else {
                Nodo pivot = getHead();
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
            Nodo pivot = getHead();
            setHead(pivot.getNext());
            pivot.setNext(null);

        } else {
            JOptionPane.showMessageDialog(null, "Esta vacia");

        }
    }

    public void deleteLast() {

        if (!isEmpty()) {
            Nodo pivot = getHead();

            if (size() == 1) {
                setHead(null);

            } else {
                while (pivot.getNext() != null && pivot.getNext().getNext() != null) {
                    pivot = pivot.getNext();
                }
                Nodo last = pivot.getNext();
                pivot.setNext(null);
                setTail(pivot);
            }

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");

        }

    }

    public void deleteInIndex(int index) {
        if (!isEmpty()) {
            Nodo pivot = getHead();
            if (index > size()) {
                JOptionPane.showMessageDialog(null, "Esta fuera del tama;o");

            } else {
                int count = 0;
                while (count < (index - 1) && pivot.getNext() != null) {
                    pivot = pivot.getNext();
                    count++;

                }
            }
            Nodo aux = pivot.getNext();
            pivot.setNext(aux.getNext());
            aux.setNext(null);
        }

    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Show">   
    public void show() {
        Nodo aux = head;
        while (aux != null) {
            Reservation r = (Reservation) aux.getDato();
            r.show();
            aux = aux.next;
        }
    }
    // </editor-fold> 

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
        Nodo aux = head;
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
        Nodo aux = head;
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
        Nodo aux = head;
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
        Nodo aux = head;
        while (aux != null) {
            User u = (User) aux.getDato();
            if (u.getName() == data && u.getLast_name() == data2) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public Lista copyList() {
        Lista n = new Lista();
        Nodo aux = head;
        while (aux != null) {
            n.addLast(aux.getDato());
            aux = aux.getNext();

        }
        return n;

    }

    public Reservation seachBina(T dni, Lista aux) {
        Nodo middle = getMiddle(aux.getHead());
        Reservation r = (Reservation) middle.getDato();
        if (r.getDni() < (int) dni) {
            aux.setHead(middle);
            return seachBina(dni, aux);
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

    /**
     * Elimina el nodo de la lista
     *
     * @param data Tipo de dato (User, reservation, bedroom, etc)
     */
    public void delete(T data) {
        Nodo aux = head;
        Nodo prev = null;
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
        Nodo aux = head;
        while (aux != null) {
            String[] numeros = (String[]) aux.getDato();
            if ((int) data == Integer.parseInt(numeros[1])) {
                return (T) aux.getDato();
            }
            aux = aux.getNext();
        }
        return null;
    }
}
