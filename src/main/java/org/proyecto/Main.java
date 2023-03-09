package org.proyecto;

import org.proyecto.Errors.LexicalError;
import org.proyecto.treeMethod.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {



        String expr = """
                {

                //                       ----DEFINIENDO CONJUNTOS----
                CONJ: mayus - > A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
                CONJ: minus -     > a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
                CONJ: letra -  > a~z;
                CONJ: digito -  > 0~9;

                //                       ----DEFINIENDO EXPRESIONES----
                frase -> ."C"."O"."M"."P"."I"."1" ? + | | {letra} {digito} " ";
                cadena  -> . \\' . + | | | |  \\n [{minus} {mayus} {digito} " " \\';
                kevinExp -> . . |{letra} "2" * {nums} ( . | * |{separados} {mayus} "x" {separados};
                %%
                %%
                cadena : "\\'cadena entre comilla simple\\'"; //bueno
                frase : "COMPI1 sale con 100"; // bueno

                }
                """;


        Lexer lexer = new Lexer(new StringReader(expr));
        Parser parser = new Parser(lexer);
        parser.parse();
        // errors
        ArrayList<LexicalError> errors = new ArrayList<>();
        ArrayList<LexicalError> errorsLexer = lexer.errors;
        errors.addAll(errorsLexer);
        errors.addAll(parser.getErrors());
        generateHTMLErros(errors);
        // reverse the arraylist
        Collections.reverse(parser.identifiersName);
        String regularExpression = parser.results.get(0);
        // split the regular expression by NEXT
        String[] regularExpressionArray = regularExpression.split("NEXT");
        // remove the first element
        String[] regularExpressionArrayNew = Arrays.copyOfRange(regularExpressionArray, 1, regularExpressionArray.length);
        // iterate over the array
        for (int i = 0; i < regularExpressionArrayNew.length; i++) {
            // get the name of the regular expresion
            String regularExpresionName = parser.identifiersName.get(i);
            // remove the first and last character
            regularExpressionArrayNew[i] = regularExpressionArrayNew[i].substring(1, regularExpressionArrayNew[i].length() - 1);
            System.out.println(regularExpressionArrayNew[i]);
            // evaluate the index is the last of the array
            String expresionString;
            String replace = regularExpressionArrayNew[i].replace("[", "").replace("]", "");
            if(i == regularExpressionArrayNew.length - 1){
                // add to the arraylist # and the beginning and . and the end
                expresionString = "#," + replace.replace(" ","") + ",.";
            }else {
                // add to the arraylist # and the beginning and . and the end
                expresionString = "#," + replace.replace(" ","") + ".";
            }
            // GENERATE EACH TREE, TABLES AND AFD
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
            raiz.generateGraphviz(regularExpresionName);
            System.out.println("==============================TABLA SIGUIENTES==============================");
            followTable ft = new followTable();
            ft.printTable(table,regularExpresionName);
            System.out.println("=============================TABLA TRANSICIONES=============================");
            transitionTable tran = new transitionTable(raiz, table, leaves);
            tran.impTable(regularExpresionName);
            System.out.println("============================= GRAPHVIZ===============================================");
            tran.impGraph(regularExpresionName);
        }
    }

    public static void generateHTMLErros(ArrayList<LexicalError> errors) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src/main/reports/ERRORES_202109567/error.html");
            pw = new PrintWriter(fichero);
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"en\">");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            //style
            pw.println("<style>");
            pw.println("table, th, td {");
            pw.println("border: 1px solid black;");
            pw.println("border-collapse: collapse;");
            pw.println("}");
            pw.println("th, td {");
            pw.println("padding: 15px;");
            pw.println("}");
            pw.println("th {");
            pw.println("text-align: left;");
            pw.println("}");
            pw.println("</style>");
            pw.println("<title>ERRORES</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>Errores</h1>");
            pw.println("<table>");
            pw.println("<tr>");
            pw.println("<th>Tipo</th>");
            pw.println("<th>Valor</th>");
            pw.println("<th>Descripcion</th>");
            pw.println("<th>Linea</th>");
            pw.println("<th>Columna</th>");
            pw.println("</tr>");
            for (LexicalError error : errors) {
                pw.println("<tr>");
                pw.println("<td>" + error.getType() + "</td>");
                pw.println("<td>" + error.getLexema() + "</td>");
                pw.println("<td>" + error.getMessage() + "</td>");
                pw.println("<td>" + error.getLine() + "</td>");
                pw.println("<td>" + error.getColumn() + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}