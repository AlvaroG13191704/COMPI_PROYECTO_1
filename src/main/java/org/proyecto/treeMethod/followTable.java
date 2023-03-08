package org.proyecto.treeMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;


public class followTable {
    public void append(int numNode, String lexeme, ArrayList flwList, ArrayList<ArrayList> table){
        for (ArrayList item : table){
            if( (int) item.get(0) == numNode && item.get(1) == lexeme ){
                for (Object flwItem : flwList){
                    if(! ((ArrayList)item.get(2)).contains((int)flwItem) ){
                        ((ArrayList)item.get(2)).add(flwItem);
                    }
                }
                return;
            }
        }
        ArrayList dato = new ArrayList();
        dato.add(numNode);
        dato.add(lexeme);
        dato.add(flwList);

        table.add(dato);
    }

    public ArrayList next(int numNode, ArrayList<ArrayList> table){
        ArrayList result = new ArrayList();
        for(ArrayList item : table){
            if( (int) item.get(0) == numNode ){
                result.add(item.get(1));
                result.add(((ArrayList)item.get(2)).clone());
                return result;
            }
        }
        result.add("");
        result.add(new ArrayList());
        return result;
    }

    public void printTable(ArrayList<ArrayList> table, String name){
        // build a table in graphviz format
        StringBuilder tableString = new StringBuilder("digraph followTable {\n");
        tableString.append("node [shape=plaintext];\n");
        tableString.append("table [label=<\n");
        tableString.append("<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n");
        tableString.append("<tr><td>Nodo</td><td>Lexema</td><td>Siguiente</td></tr>\n");
        int c = 0;

        // sort table by nuumber of node without removing
        table.sort(Comparator.comparingInt(o -> (int) o.get(0)));

        for(ArrayList item : table){
            tableString.append("<tr>");
            tableString.append("<td>").append(item.get(0)).append("</td>");
            tableString.append("<td>").append(item.get(1)).append("</td>");
            tableString.append("<td>").append(item.get(2)).append("</td>");
            tableString.append("</tr>\n");
            c++;
        }
        tableString.append("<tr><td>").append(c+1).append("</td><td>").append("\"#\"").append("</td><td>-</td></tr>\n");
        tableString.append("</table>\n");
        tableString.append(">]\n;");
        tableString.append("}");
        //System.out.println(tableString);
        // generate the dot and image
        File file = new File("src/main/reports/SIGUIENTES_202109567/"+name+".dot");
        try{
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(tableString.toString());
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("dot -Tpng src/main/reports/SIGUIENTES_202109567/"+name+".dot -o src/main/reports/SIGUIENTES_202109567/"+name+".png");
            System.out.println("Graphviz generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
