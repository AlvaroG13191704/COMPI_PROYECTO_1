package org.proyecto.treeMethod;
import org.proyecto.treeMethod.type.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
public class Tree {

    node root;

    public Tree( String er, ArrayList<node> leaves, ArrayList<ArrayList> table) {

        numLeave numHoja = new numLeave(er); // count the number of leaves
        Stack pila = new Stack(); // will help to build the tree

        String[] expReg = er.split(","); // split the string to evaluate each character
        ArrayList<String> strList = new ArrayList<>( Arrays.asList(expReg));// make te
        System.out.println(strList);

        strList.forEach((character) -> {
            switch (character) {
                case "|" -> {
                    node lefto = (node) pila.pop();
                    node righto = (node) pila.pop();

                    node no = new node(character, Types.OR, 0, lefto, righto, leaves, table);
                    pila.push(no);

                }
                case "." -> {
                    node lefta = (node) pila.pop();
                    node righta = (node) pila.pop();

                    node na = new node(character, Types.AND, 0, lefta, righta, leaves, table);
                    pila.push(na);
                }
                case "*" -> {
                    node unario = (node) pila.pop();
                    node nk = new node(character, Types.KLEENE, 0, unario, null, leaves, table);
                    pila.push(nk);
                }
                case "+" -> {
                    node unario = (node) pila.pop();
                    node nk = new node(character, Types.PLUS, 0, unario, null, leaves, table);
                    pila.push(nk);
                }
                case "?" -> {
                    node unario = (node) pila.pop();
                    node nk = new node(character, Types.QUESTION, 0, unario, null, leaves, table);
                    pila.push(nk);
                }
                default -> {
                    node nd = new node(character, Types.HOJA, numHoja.getNum(), null, null, leaves, table);
                    pila.push(nd); //build the tree
                    leave hoja = new leave();
                    hoja.addLeave(nd, leaves); //Tabla de siguientes o transiciones
                }
            }
        });
        this.root = (node) pila.pop(); // extract the last value of the stack that contain the root of the tree
    }

    public node getRoot(){
        return this.root;
    }

}
