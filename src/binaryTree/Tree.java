/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import user.User;

/**
 *
 * @author Daniel
 */
public class Tree {

    /**
     *
     */
    Node pRoot;

    /**
     *
     */
    public Tree() {
        this.pRoot = null;
    }

    /**
     *
     * @return 
     */
    public Node getpRoot() {
        return pRoot;
    }

    /**
     *
     * @param pRoot
     */
    public void setpRoot(Node pRoot) {
        this.pRoot = pRoot;
    }

    /**
     *
     * @param pRoot
     * @param aux
     */
    public void insert(Node pRoot, Node aux) {
        if (this.pRoot == null) {
            this.pRoot = aux;
        } else {
            User u = (User) aux.getDato();
            User p = (User) pRoot.getDato();
            if (u.getDni() < p.getDni()) {
                if (pRoot.getLeft() == null) {
                    pRoot.setLeft(aux);
                } else {
                    insert(pRoot.getLeft(), aux);
                }
            } else if (u.getDni() > p.getDni()) {
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

    /**
     *
     * @param aux
     * @param data
     * @return 
     */
    public Node search(Node aux, int data) {
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

    /**
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            User u = (User) root.getDato();
            u.show();
            inOrder(root.getRight());
        }
    }

    /**
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            ;
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     *
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getDato() + ",");
        }
    }
}
