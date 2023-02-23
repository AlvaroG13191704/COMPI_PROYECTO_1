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
                // COMENTARIO
                <! multi comentario !>
                CONJ: letra -> a~z;
                CONJ: digito -> 0~9;
                CONJ: vocals -> a,e,i,o,u;
                /////// EXPRESIONES REGULARES
                ExpReg1 -> .{letra}*|"_"|{letra}{digito};
                %% 
                ExpReg1: "primerLexemaCokoa";
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