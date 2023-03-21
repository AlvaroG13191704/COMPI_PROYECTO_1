package org.proyecto.codeAFND;
import org.proyecto.treeMethod.node;

import java.io.File;

public class AFNDCode {
    public static int id = 0;

    public void graphAFND(node root, String name) {
        String graph = "";
        id = 0;
        graph += "digraph AFND {\n";
        graph += "fontname=\"Helvetica,Arial,sans-serif\";\n";
        graph += "node [fontname=\"Helvetica,Arial,sans-serif\"]\n";
        graph += "edge [fontname=\"Helvetica,Arial,sans-serif\"]\n";
        graph += "rankdir=LR;\n";

        graph += generateAFND(root);
        graph += "}";
        File file = new File("src/main/reports/AFND_202109567/" + name + ".dot");
        try {
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(graph);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("dot -Tpng src/main/reports/AFND_202109567/" + name + ".dot -o src/main/reports/AFND_202109567/" + name + ".png");
            System.out.println("Graphviz generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String generateAFND(node root) {
        String label = "";

        if (root == null) {
            return label;
        }
        System.out.println(root.type.name());
        switch (root.type.name()) {
            case "HOJA" -> {
                label += "S" + id;
                id++;
                label += " -> S" + id + "\n";
                String lexem = root.lexeme.replace("\\n", "\"\n\"").replace("\\'", "\"\\'\"").replace("#","\"#\"");
                label += "[label = " + lexem + " ];\n";
            }
            case "AND" -> { // Listo
                label += generateAFND((node) root.getRight());
                label += generateAFND((node) root.getLeft());
            }
            case "OR" -> {
                int auxOr = id;
                label += "S" + auxOr;
                id++;
                label += " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += generateAFND((node) root.getLeft());
                int auxleft = id;
                label += "S" + auxOr;
                id++;
                label += " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += generateAFND((node) root.getRight());
                int auxright = id;
                id++;
                label += "S" + auxleft + " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + auxright + " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "PLUS" -> {
                int auxPlus = id + 1;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += generateAFND((node) root.getLeft());
                label += "S" + id + " -> " + "S" + auxPlus + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "KLEENE" -> {
                int idKleene = id;
                int auxKleene = id + 1;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += generateAFND((node) root.getLeft());
                label += "S" + id + " -> " + "S" + auxKleene + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + idKleene + " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "QUESTION" -> {
                int auxInterrogation = id;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += generateAFND((node) root.getLeft());
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + auxInterrogation + " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            default -> {
            }
        }
        return label;
    }
}