package org.proyecto;

import org.proyecto.treeMethod.Tree;
import org.proyecto.treeMethod.node;
import org.proyecto.treeMethod.numLeave;

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
                EXPreg2 -> .. |{letra} "2" * {nums} . | * |{separados} {mayus} "x" {separados};
                                
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
        //System.out.println(aux);
    }
}