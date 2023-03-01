package org.proyecto.treeMethod;

import org.proyecto.treeMethod.followTable;
import org.proyecto.treeMethod.leave;
import org.proyecto.treeMethod.node;
import org.proyecto.treeMethod.transicion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class transitionTable {

    public ArrayList<ArrayList> states;
    public int cont;

    public ArrayList<String> acceptStates;

    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
        this.states = new ArrayList(); // are the states of the AFD

        ArrayList datos = new ArrayList(); // are the data of the states
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);
        int aceptacion = 0;
        acceptStates = new ArrayList<>();
        // data save the first state, an arraylist and if is an accept state
        this.states.add(datos);
        this.cont = 1;

        for(int i = 0; i < states.size(); i++){ // iterate through the states
            ArrayList state = states.get(i); // get the state

            ArrayList<Integer> elementos = (ArrayList) state.get(1); // get the elements of the state
            Map<String, ArrayList<Integer>> transiciones = new HashMap<>(); // are the transitions of the state

            for(int hoja : elementos){
                followTable sigTabla = new followTable();
                ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();

                if(lexemeNext.get(0) == ""){
                    continue;
                }

                ArrayList<Integer> sigEstados = transiciones.get(lexemeNext.get(0));
                if(sigEstados == null){
                    sigEstados = new ArrayList<>();
                    transiciones.put((String)lexemeNext.get(0), sigEstados);
                }
                sigEstados.addAll((ArrayList<Integer>)lexemeNext.get(1));

                leave hojas = new leave(); // here is the problem with accepted states
                aceptacion = hojas.isAccept(hoja, leaves);
            }

            for(Map.Entry<String, ArrayList<Integer>> entrada : transiciones.entrySet()){
                ArrayList<Integer> sigEstados = entrada.getValue();

                String nombreEstadoSiguiente = null;
                for(ArrayList estado : states){
                    if(estado.get(1).equals(sigEstados)){
                        nombreEstadoSiguiente = (String)estado.get(0);
                        break;
                    }
                }

                if(nombreEstadoSiguiente == null){
                    nombreEstadoSiguiente = "S" + cont;
                    cont++;

                    ArrayList nuevo = new ArrayList();
                    nuevo.add(nombreEstadoSiguiente);
                    nuevo.add(sigEstados);
                    nuevo.add(new ArrayList());
                    // evaluate if the number is in sigEstados
                    if(sigEstados.contains(aceptacion)){
                        nuevo.add(true);
                        acceptStates.add(nombreEstadoSiguiente);
                    }else{
                        nuevo.add(false);
                    }

                    states.add(nuevo);
                    // add the accept state

                }

                transicion trans = new transicion(state.get(0) + "", entrada.getKey(), nombreEstadoSiguiente);
                ((ArrayList)state.get(2)).add(trans);
            }
        }}

    public void impTable(){
        for(ArrayList state : states){
            String tran = "[";
            for(Object tr : (ArrayList)state.get(2)){
                transicion t = (transicion) tr;
                tran += t.toString() + ", ";
            }
            tran += "]";
            tran = tran.replace(", ]", "]");
            System.out.println(state.get(0) + " " + state.get(1) + " " + tran + " " + state.get(3));
        }
    }

    public void impGraph(){
        String graph = "digraph AFD {\n";
        graph += "fontname=\"Helvetica,Arial,sans-serif\";\n";
        graph += "node [fontname=\"Helvetica,Arial,sans-serif\"]\n";
        graph += "edge [fontname=\"Helvetica,Arial,sans-serif\"]\n";
        graph += "rankdir=LR;\n";
        graph += "node [shape = doublecircle]; ";
        for(String state : this.acceptStates){
            graph += state + ",";
        }
        // erase the last comma
        graph = graph.substring(0, graph.length() - 1);
        graph += ";\n";
        graph += "node [shape = circle];\n";
        for(ArrayList state : states){
            for(Object tr : (ArrayList)state.get(2)){
                transicion t = (transicion) tr;
                graph += t.graph() + "\n";
            }
        }
        graph += "}";
        System.out.println(graph);
    }

}