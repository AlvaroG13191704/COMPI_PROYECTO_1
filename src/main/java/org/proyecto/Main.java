package org.proyecto;

import org.proyecto.Errors.LexicalError;
import org.proyecto.codeAFD.AFDCode;
import org.proyecto.treeMethod.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String expr = """
                // #############  ESTE ES UN COMENTARIO DE UNA SOLA LINEA, POR LO QUE NO DEBE
                //##############  DAR NINGUN PROBLEMA///////////////////---------
                                
                {
                                
                CONJ: numero - > 0,1,2,3,4, 5,6,7,   8, 9 ;
                CONJ: minuscula -     > a ~  z ;
                CONJ: mayuscula -> A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
                CONJ: simbolos - > -,_;
                                
                //$%$%$%$%$%$%$%&/&/&/&/& ESTO NO DEBE DAR POBLEMA ============
                                
                correoElectronico -> .|{minuscula} {mayuscula} . + | | | {simbolos} {minuscula} {mayuscula} {numero} . "@" . + | {minuscula} {mayuscula} . ".". "c" . "o" "m";
                //url -> . "h". "t". "t". "p".?"s".":"."/"."/". + {minuscula} . "." + {minuscula};
                                
                %%
                    %%
                                
                <!
                                SECCIÓN DE PRUEBAS
                                    #YASALIO
                    !>
                                
                url : "https://facebook.com"; //correcto
                url : "http://google.es"; //correcto
                url : "https://compiladores-1.com"; //incorrecto
                                
                correoElectronico : "lachalana666@ingusac.com"; //correcto
                correoElectronico : "micorreo_123@gMAIL.com"; //correcto
                correoElectronico : "compiladores1.lab@hotMAIL.es"; //incorrecto
                                
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
        // GENERATE THE GLOBAL ALPHABET
        Map<String, List<String>> globalAlphabet = new HashMap<>();
        for(String alphabet : parser.alphabet_1){ // First alphabet with the format a ~ z
            List<String> rangeList = new ArrayList<String>(); // create a list
            String[] range = alphabet.split("~"); // split the string by ~
            System.out.println(range[0] + " " + range[1] + " " + range[2]);
            // iterate over the range
            for (int i = (int) range[1].charAt(0); i <= (int) range[2].charAt(0); i++) {
                char c = (char) i;
                rangeList.add(Character.toString(c));
            }
            globalAlphabet.put(range[0],  rangeList);
        }
        for(String alphabet : parser.alphabet_2){ // Second alphabet with the format a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
            List<String> rangeList = new ArrayList<String>(); // create a list
            String[] range = alphabet.split("~"); // split the string by ~
            System.out.println(range[0] + " " + range[1] );
            // iterate over the range
            for (int i = 0; i < range[1].length(); i++) {
                rangeList.add(Character.toString(range[1].charAt(i)));
            }
            globalAlphabet.put(range[0],  rangeList);
        }
        System.out.println(globalAlphabet);
        // GENERATE THE GLOBAL ALPHABET

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
            // create a new alphabet with words that are inside of leaves
            Map<String, List<String>> alphabet = new HashMap<>();
            for (node alp : leaves) {
                // elimante the elements inside of globalAlphabet
                if( globalAlphabet.containsKey(alp.lexeme)){
                    List<String> list = globalAlphabet.get(alp.lexeme);
                    alphabet.put(alp.lexeme, list);
                }
            }
            transitionTable tran = new transitionTable(raiz, table, leaves);
            tran.impTable(regularExpresionName);
            System.out.println("States -> " + tran.statesAFD);
            System.out.println("Alphabet -> " + alphabet );
            System.out.println("Transitions -> " + tran.transitionsAFD);
            System.out.println("Initial State -> " + tran.initialStateAFD);
            System.out.println("Accept States ->"+ tran.finalStatesAFD);
            System.out.println("============================= GRAPHVIZ AFD===============================================");
            tran.impGraph(regularExpresionName);
            System.out.println("============================= EVALUATE AFD ===============================================");
            // CREATE THE AFD
            AFDCode afd = new AFDCode(tran.statesAFD, alphabet, tran.transitionsAFD, tran.initialStateAFD, tran.finalStatesAFD);
            boolean result = afd.accept("lachalana666@ingusac.com");
            System.out.println("Result: " + result);
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