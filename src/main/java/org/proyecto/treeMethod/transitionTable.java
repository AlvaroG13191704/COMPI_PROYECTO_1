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

    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
        this.states = new ArrayList();

        ArrayList datos = new ArrayList();
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);

        this.states.add(datos);
        this.cont = 1;

        for(int i = 0; i < states.size(); i++){
            ArrayList state = states.get(i);
            ArrayList<Integer> elementos = (ArrayList) state.get(1);

            Map<String, ArrayList<Integer>> transiciones = new HashMap<>();
            boolean esAceptacion = false;

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

                leave hojas = new leave();
                if(hojas.isAccept(hoja, leaves)){
                    esAceptacion = true;
                }
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
                    nuevo.add(false);

                    states.add(nuevo);
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
        graph += "node [shape = doublecircle]; S4 ;\n";
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