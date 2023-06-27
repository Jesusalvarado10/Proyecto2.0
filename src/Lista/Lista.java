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
 */
public class Lista<T> {

    Nodo head;
    Nodo tail;

    public Lista() {
        this.head = null;
        this.tail = null;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public Lista rotate(){
        Nodo aux=head;
        Lista volteada= new Lista();
       while(aux!=null){
           volteada.addFirst(aux.getDato());
           aux=aux.getNext();
       }
    
    return volteada;
    }

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

     public void show() {
        Nodo aux = head;
        while (aux != null) {
            User r= (User)aux.getDato();
            r.show();
            aux = aux.next;
        }
    }


    public T getDato(String data, String data2) {
        // Es para obtener el valor del nodo que buscamos, despues de usar el search, igualmente se usa parametos especificos para el tipo de dato.
        Nodo aux = head;
        while (aux != null) {
            User u = (User)aux.getDato();
            if (u.getName().equals(data) && u.getLast_name().equals(data2)) {
                return (T) aux.getDato();
            }

            aux = aux.getNext();
        }
        return null;
    }

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

    public int getPosicion(T dato) {
        Nodo aux = head;
        String x;
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

    public boolean search(T data, T data2) {

        Nodo aux = head;
        while (aux != null) {
            User u = (User)aux.getDato();
            if (u.getName() == data && u.getLast_name() ==data2) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
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
    public void sort() {
        Nodo pivot = head;
        Nodo siguiente;
        Nodo antes;
        siguiente = pivot.getNext();
        antes = null;
        boolean iteraccion = false;
        while (siguiente != null) {
            if (antes == null) {
                if ((int )pivot.getDato() >(int ) siguiente.getDato()) {
                    pivot.setNext(siguiente.getNext());
                    antes = siguiente;
                    antes.setNext(pivot);;
                    siguiente = pivot.getNext();
                    head = antes;
                    iteraccion = true;
//                    System.out.println("antes: " + antes.Data + "next: " + antes.next.Data);
//                    System.out.println("pivot: " + pivot.Data + "next: " + pivot.next.Data);
//                    System.out.println("siguiente: " + siguiente.Data + "next: " + siguiente.next.Data);
                } else {
                    antes = pivot;
                    pivot = antes.getNext();
                    siguiente = pivot.getNext();
                }
            } else {
                if ((int )pivot.getDato() > (int)siguiente.getDato()) {
                    pivot.setNext(siguiente.getNext()) ;
                    siguiente.setNext(pivot) ;
                    antes.setNext(siguiente); 
                    antes = siguiente;
                    siguiente = pivot.getNext();
                    iteraccion = true;
//                    System.out.println("antes: " + antes.Data + "next: " + antes.next.Data);
//                    System.out.println("pivot: " + pivot.Data + "next: " + pivot.next.Data);
//                    System.out.println("siguiente: " + siguiente.Data + "next: " + siguiente.next.Data);
                } else {
                    antes = pivot;
                    pivot = antes.getNext();
                    siguiente = pivot.getNext();
//                    System.out.println("antes: " + antes.Data + "next: " + antes.next);
//                    System.out.println("pivot: " + pivot.Data + "next: " + pivot.next);
//                    System.out.println("siguiente: " + siguiente.Data + "next: " + siguiente.next);
                }
            }
        }
        if (iteraccion == true) {
            sort();
        }
    }
    public T search2(T data)  {
        Nodo aux = head;
        while (aux != null) {
            String[] numeros = (String[]) aux.getDato();
            if ((int) data==Integer.parseInt(numeros[1])  ) {
                    return (T)aux.getDato();
                
            }

            aux = aux.getNext();
        }
        return null;
    }

}

