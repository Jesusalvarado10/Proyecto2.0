/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashTable;

import Lista.Lista;
import User.User;

/**
 *
 * @author User
 */
public class HashTable<T> {

    Lista<User>[] table;
    int size;

    public HashTable(int n) {
        size = n;
        table = new Lista[n];
        for (int i = 0; i < n; i++) {
            table[i] = new Lista();
        }

    }

    private int hashFunction(String key, String key2) {
        int value = 0;
        for (int i = 0; i < key.length(); i++) {
            char caracter = key.charAt(i);
            value += (int) caracter;
        }
        for (int i = 0; i < key2.length(); i++) {
            char caracter = key2.charAt(i);
            value += (int) caracter;
        }
        return value % size; // Función hash simple utilizando el módulo
    }

    public Lista[] getTable() {
        return table;
    }

    public void setTable(Lista[] table) {
        this.table = table;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insert(T value) {
        User u= (User)value;
        int index = hashFunction(u.getName(),u.getLast_name());
        Lista<User> list = table[index];
       list.addLast((User)u);
        }

    public User search(String key, String key2) {
    int index = hashFunction(key,key2);
    Lista list = table[index];
    if(list.isEmpty()){
    return null;
    }else {
        System.out.println("safklfakfak;lfkls;a");
        return (User)list.getDato(key, key2);
    }
    
    }

    public void delete(String key,String key2) {
        int index = hashFunction(key, key2);
        table[index] = null;
        return;

    }

    public void show() {
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                n++;
                System.out.println(n);
                table[i].show();
            }
        }

    }
}

//        for (User entry : table[index]) {
//            if (entry.getKey() == key) {
//                // Si la clave ya existe, actualizamos el valor
//                entry.setValue(value);
//                return;
//            }
//
//        for (Entry entry : list) {
//            if (entry.getKey() == key) {
//                // Si la clave ya existe, actualizamos el valor
//                entry.setValue(value);
//                return;
//            }
//        }
//
//        // Si la clave no existe, la insertamos al final de la lista
//        list.add(new Entry(key, value));