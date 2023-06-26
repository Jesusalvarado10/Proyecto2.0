/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolesBinarios;

/**
 *
 * @author User
 */
public class Arbol {

    Nodo pRoot;

    public Arbol() {
        this.pRoot = null;
    }

    public void insert(Nodo pRoot, Nodo aux) {
        if (this.pRoot == null) {
            this.pRoot = aux;
        } else {
            if ((int) aux.getDato() < (int) pRoot.getDato()) {
                if (pRoot.getLeft() == null) {
                    pRoot.setLeft(aux);
                } else {
                    insert(pRoot.getLeft(), aux);
                }
            } else if ((int) aux.getDato() > (int) pRoot.getDato()) {
                if (pRoot.getRight() == null) {
                    pRoot.setRight(aux);
                } else {
                    insert(pRoot.getRight(), aux);
                }
            } else {
                System.out.println("El elemento ya se encuentra en el Árbol");
            }
        }

    }

    public Nodo search(Nodo aux, int data) {
        if (aux == null) {
            return null;
        }

        if ((int) aux.getDato() == data) {
            return aux;
        } else if (data < (int) aux.getDato()) {
            return search(aux.getLeft(), data);
        } else {
            return search(aux.getRight(), data);
        }

    }

    public void inOrder(Nodo root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getDato() + ",");
            inOrder(root.getRight());
        }
    }

    public void preOrder(Nodo root) {
        if (root != null) {
            System.out.print(root.getDato() + ",");
            inOrder(root.getLeft());
            inOrder(root.getRight());
        }
    }

    public void postOrder(Nodo root) {
        if (root != null) {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getDato() + ",");
        }
    }
}
