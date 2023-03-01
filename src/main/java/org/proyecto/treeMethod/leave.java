package org.proyecto.treeMethod;

import java.util.ArrayList;


public class leave {

    public void addLeave(node nodo, ArrayList<node> leaves){
        leaves.add(nodo);
    }

    public node getLeave(int numLeave, ArrayList<node> leaves){
        for (node item : leaves) {
            if(item.number == numLeave) return item;
        }
        return null;
    }

    public int isAccept(int numLeave, ArrayList<node> leaves){

        int accept = 0;
        for (node item : leaves) {
            //System.out.println("item.number: " + item.number + " numLeave: " + numLeave + " item.accept: " + item.accept);
            if(item.number != numLeave && item.accept){
                // add the number of the leave to the arraylist
                accept = item.number;
            }
        }
        return accept;
    }
}
