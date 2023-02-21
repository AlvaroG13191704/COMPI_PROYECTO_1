package org.proyecto;

import java.io.StringReader;
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
                ExpReg2 -> ...{letra}"_"{digito};
                %% 
                ExpReg1: "primerLexemaCokoa";

                }
                """;
        Lexer lexer = new Lexer(new StringReader(expr));
        Parser parser = new Parser(lexer);
        parser.parse();

    }
}