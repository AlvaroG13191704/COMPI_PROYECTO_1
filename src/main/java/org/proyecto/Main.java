package org.proyecto;

import org.proyecto.treeMethod.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String expr = """
                {
                CONJ: letra -> a~z;
                CONJ: separados -> 2,a,e,R,d,0,9;
                CONJ: mayus-> G~O;
                CONJ: nums-> 1~5;
                                
                                
                // EXPreg -> . |{letra} "2" * {nums};
                EXPreg2 -> . . |{letra} "2" * {nums} . | * |{separados} {mayus} "x" {separados};
                                
                %%
                %%
                // pruebas
                <! comentario multilinea
                asdasdasdasd
                asdsad
                !>
                EXPreg: "este es un lexema";
                                
                }
                """;
        Lexer lexer = new Lexer(new StringReader(expr));
        Parser parser = new Parser(lexer);
        parser.parse();
        // extact the array with the regular expressions
        System.out.println(parser.results.get(0));
        // add to the arraylist # and the beginning and . and the end
        String expresionString = "#," + parser.results.get(0).replace("[","").replace("]", "").replace(" ","") + ",.";
        // create arraylist
        ArrayList<node> leaves = new ArrayList<>();
        ArrayList<ArrayList> table = new ArrayList<>();
        // Create the tree
        Tree tree = new Tree(expresionString,leaves, table );
        node raiz = tree.getRoot();

        raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
        raiz.follow();
        System.out.println("==============================VALORES NODO ULTIMO . Y TABLA HOJAS ==============================");
        // Create a function to generate the graphviz code of the tree

        System.out.println("==============================TABLA SIGUIENTES==============================");
        followTable ft = new followTable();
        ft.printTable(table);
        transitionTable tran = new transitionTable(raiz, table, leaves); // bug
        System.out.println("=============================TABLA TRANSICIONES=============================");
        tran.impTable();
        System.out.println("============================= GRAPHVIZ===============================================");
        tran.impGraph();
    }
}