package org.proyecto;

import org.proyecto.treeMethod.node;
import org.proyecto.treeMethod.numLeave;

import java.io.StringReader;
import java.util.ArrayList;
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
        String[] expReg = parser.results.toArray(new String[0]);
        // create arraylist
        ArrayList<node> list = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();
        // append . and #
        String aux = "." + expReg[0] + "#";
        // try the leave
        numLeave numHoja = new numLeave(aux);
        numHoja.getNum();
    }
}