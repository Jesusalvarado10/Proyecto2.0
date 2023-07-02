/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTable;

import linkedList.LinkedList;
import user.User;

/**
 *
 * @author Daniel
 * @param <T>
 */
public class HashTable<T> {

    /**
     *
     */
    LinkedList<User>[] table;
    /**
     *
     */
    int size;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    /**
     * Construye la HashTable según el tamaño pasado por parámetro
     *
     * @param n Tamaño del HastTable: (n) es...
     */
    public HashTable(int n) {
        size = n;
        table = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new LinkedList();
        }

    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Table">  
    /**
     *
     * @return
     */
    public LinkedList[] getTable() {
        return table;
    }

    /**
     *
     * @param table
     */
    public void setTable(LinkedList[] table) {
        this.table = table;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Size"> 
    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Insert">   
    /**
     *
     * @param value
     */
    public void insert(T value) {
        User u = (User) value;
        int index = hashFunction(u.getName(), u.getLast_name());
        LinkedList<User> list = table[index];
        list.addLast((User) u);
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Delete">   
    /**
     *
     * @param key
     * @param key2
     */
    public void delete(String key, String key2) {
        int index = hashFunction(key, key2);
        table[index].deleteUser(key, key2);
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Search">   
    /**
     *
     * @param key
     * @param key2
     * @return
     */
    public User search(String key, String key2) {
        int index = hashFunction(key, key2);
        LinkedList list = table[index];
        if (list.isEmpty()) {
            return null;
        } else {
            return (User) list.getDato(key, key2);
        }
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Show">   
    /**
     *
     */
    public void show() {
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                n++;
                table[i].show();
            }
        }

    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Hash function">  
    /**
     *
     */
    private int hashFunction(String key, String key2) {
        int value = 0;
        key = key.toLowerCase();
        key2 = key2.toLowerCase();
        for (int i = 0; i < key.length(); i++) {
            char caracter = key.charAt(i);
            value += (int) caracter;
        }

        for (int i = 0; i < key2.length(); i++) {
            char caracter = key2.charAt(i);
            value += (int) caracter;
        }
        return value % size;
    }
    // </editor-fold> 
}
