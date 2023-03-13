package org.proyecto.treeMethod;

import org.proyecto.treeMethod.followTable;
import org.proyecto.treeMethod.leave;
import org.proyecto.treeMethod.node;
import org.proyecto.treeMethod.transicion;

import java.io.File;
import java.util.*;

public class transitionTable {

    // Variables to manage the code of the AFD
    public Set<String> statesAFD;
    public Map<String, List<Map<String, String>>> transitionsAFD;
    public String initialStateAFD;
    public Set<String> finalStatesAFD;

    public ArrayList<ArrayList> states;
    public int cont;

    public ArrayList<String> acceptStates;
    public ArrayList<node> leaves;

    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
        // initialize the variables
        this.statesAFD = new HashSet<>();
        this.transitionsAFD = new HashMap<>();
        this.finalStatesAFD = new HashSet<>();
        this.initialStateAFD = "S0";

        this.states = new ArrayList(); // are the states of the AFD
        ArrayList datos = new ArrayList(); // are the data of the states
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);
        datos.add(new ArrayList());
        int aceptacion = 0;
        // graphs
        acceptStates = new ArrayList<>();
        this.leaves = leaves;
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
                    nuevo.add(new ArrayList());
                    states.add(nuevo);
                    // add the accept state

                }
                transicion trans = new transicion(state.get(0) + "", entrada.getKey(), nombreEstadoSiguiente);
                ((ArrayList)state.get(2)).add(trans);
                ((ArrayList)state.get(4)).add(trans.toArray());
            }
        }
    }

    public void impTable(String name){
        String graphviz = "digraph transitionTable {\n";
        graphviz += "n[shape=none label = <\n" +
                " <TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"10\" style=\"collapse\">\n" +
                "  <TR >\n" +
                "  <TD rowspan=\"2\" colspan=\"1\" border=\"1\">ESTADOS</TD>\n" +
                "  <TD colspan=\"6\" border=\"1\">Terminales</TD>\n" +
                "  </TR>\n" ;
        // reverse the order of the leaves
        Collections.reverse(leaves);
        // elimiante duplicates
        for(int i = 0; i < leaves.size(); i++){
            for(int j = i + 1; j < leaves.size(); j++){
                if(leaves.get(i).lexeme.equals(leaves.get(j).lexeme)){
                    leaves.remove(j);
                }
            }
        }
        // remove the last leave
        leaves.remove(leaves.size() - 1);
        // the official order of the leaves in the table
        graphviz += "  <TR>\n";
        for(node hoja : this.leaves){
            graphviz += "  <TD border=\"1\">" + hoja.lexeme + "</TD>\n";
        }
        graphviz += "  </TR>\n";

        for(ArrayList state : states){
            // add the state
            statesAFD.add((String) state.get(0));
            // add accept states
            if((boolean) state.get(3)){
                finalStatesAFD.add((String) state.get(0));
            }

            graphviz += "  <TR>\n";
            graphviz += "  <TD border=\"1\">" + state.get(0) + " " + state.get(1) +  "</TD>\n";
            // create a string array of the size of leaves
            String[] tdValues = new String[leaves.size()];
            for(int i = 0; i < tdValues.length; i++){
                tdValues[i] = "<TD border=\"1\">---</TD>";
            }
            // iretate throught leaves and find the transitions an use the that index
            ArrayList fourthPart = (ArrayList) state.get(4);
            for(int i = 0; i< leaves.size(); i++){
                int finalI = i;

                List<Map<String, String>> list = new ArrayList<>();
                Map<String, String> map = new HashMap<>();

                fourthPart.forEach((item) -> {
                    String value = item.toString().replace("[", "").replace("]", "");
                    String[] values = value.split(",");

                    map.put(values[0].replace("\"",""), values[1].replace(" ",""));

                    if(values[0].equals(leaves.get(finalI).lexeme)){


                        //System.out.println("state : " + state.get(0) + " lexeme : " + values[0] + " value : " + values[1]);
                        tdValues[finalI] = "<TD border=\"1\">" + values[1] + "</TD>";
                    }

                });
                list.add(map);
                transitionsAFD.put((String) state.get(0), list);
            }

            for(String td : tdValues){
                graphviz += "  " + td + "\n";
            }
            graphviz += "  </TR>\n";
        }
        graphviz += " </TABLE>\n" +
                ">];\n" +
                "}";
        //System.out.println(graphviz);
        // generate the dot and image
        File file = new File("src/main/reports/TRANSICIONES_202109567/"+name+".dot");
        try{
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(graphviz);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("dot -Tpng src/main/reports/TRANSICIONES_202109567/"+name+".dot -o src/main/reports/TRANSICIONES_202109567/"+name+".png");
            System.out.println("Graphviz generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void impGraph(String name){
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
        //System.out.println(graph);
        // generate the dot and image
        File file = new File("src/main/reports/AFD_202109567/"+name+".dot");
        try{
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(graph);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("dot -Tpng src/main/reports/AFD_202109567/"+name+".dot -o src/main/reports/AFD_202109567/"+name+".png");
            System.out.println("Graphviz generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}