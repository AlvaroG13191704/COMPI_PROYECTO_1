package org.proyecto.treeMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.proyecto.treeMethod.type.Types;
public class node {
    public ArrayList<Integer> first;
    public ArrayList<Integer> last;

    boolean anullable;

    public String lexeme;
    Types type;
    int number;

    public boolean accept;

    Object left;
    Object right;

    ArrayList<node> leaves;
    ArrayList<ArrayList> table;



    public node(String lexeme, Types type, int number, Object left, Object right, ArrayList<node> leaves, ArrayList<ArrayList> table) {
        first = new ArrayList<>();
        last = new ArrayList<>();

        anullable = true;

        this.lexeme = lexeme;
        this.type = type;
        this.number = number;

        accept = "#".equals(this.lexeme);

        this.left = left;
        this.right = right;

        this.leaves = leaves;
        this.table = table;

    }

    public node getNode(){
        // This is a recursive method, go the deepest node and evaluate until the root
        Object leftNode =  this.left instanceof node ? ((node) this.left).getNode(): null;
        Object rightNode = this.right instanceof node ? ((node) this.right).getNode(): null;

        if(null != this.type) switch (this.type) {
            case HOJA -> {
                this.anullable = false;
                this.first.add(this.number);
                this.last.add(this.number);

            }
            case AND -> {
                if (leftNode != null && rightNode != null) {
                    this.anullable = ((node) leftNode).anullable && ((node) rightNode).anullable;

                    this.first.addAll(((node) leftNode).first);
                    if (((node) leftNode).anullable) {
                        this.first.addAll(((node) rightNode).first);
                    }

                    if (((node) rightNode).anullable) {
                        this.last.addAll(((node) leftNode).last);
                    }
                    this.last.addAll(((node) rightNode).last);
                }

            }
            case OR -> {
                if (leftNode != null && rightNode != null) {
                    this.anullable = ((node) leftNode).anullable || ((node) rightNode).anullable;
                    //
                    this.first.addAll(((node) leftNode).first);
                    this.first.addAll(((node) rightNode).first);

                    this.last.addAll(((node) leftNode).last);
                    this.last.addAll(((node) rightNode).last);
                }

            }
            case KLEENE, QUESTION -> {
                if (leftNode != null) {
                    this.anullable = true;
                    this.first.addAll(((node) leftNode).first);
                    this.last.addAll(((node) leftNode).last);
                }

            }
            case PLUS -> {
                if (leftNode != null) {
                    this.anullable = ((node) leftNode).anullable;
                    this.first.addAll(((node) leftNode).first);
                    this.last.addAll(((node) leftNode).last);
                }

            }
            default -> {
            }
        }
        return this;
    }

    public Object follow(){
        Object leftFollow=  this.left instanceof node ? ((node) this.left).follow() : null;
        Object rightFollow =  this.right instanceof node ? ((node) this.right).follow() : null;

        if(null != this.type) switch (this.type) {
            case AND -> {
                for (int item : ((node) leftFollow).last) {
                    leave hoja = new leave();
                    node nodo = hoja.getLeave(item, leaves);
                    followTable tabla = new followTable();
                    tabla.append(nodo.number, nodo.lexeme, ((node) rightFollow).first, table);
                }
            }
            case KLEENE, PLUS -> {
                for (int item : ((node) leftFollow).last) {
                    leave hoja = new leave();
                    node nodo = hoja.getLeave(item, leaves);
                    followTable tabla = new followTable();
                    tabla.append(nodo.number, nodo.lexeme, ((node) leftFollow).first, table);
                }
            }
            default -> {
            }
        }

        return this;
    }

    public void generateGraphviz() {
        StringBuilder graphviz = new StringBuilder();
        graphviz.append("digraph syntax_tree {\n");
        graphviz.append("node [fontname=Helvetica, fontsize=12];\n");
        graphviz.append("edge [arrowhead=vee, arrowtail=none];\n");

        int[] identifier = {0};

        buildGraphvizTree(this, identifier, graphviz);
        graphviz.append("}");
        System.out.println(graphviz);
    }
    public node getNodeVoid(){
        // This is a recursive method, go the deepest node and evaluate until the root
        return this;
    }
    private void buildGraphvizTree(node node, int[] identifier, StringBuilder graphviz) {
        String idNode = "node" + identifier[0]; // a identifier for the node
        // generate this [label="F \n F[1,2] \n L[8] \n .  "];
        if (node.type == Types.HOJA) {
            graphviz.append(idNode).append(" [label=\"").append(node.anullable).append(" \\n F").append(node.first).append(" \\n L").append(node.last).append(" \\n").append(node.lexeme.replace("\"","")).append("\\n "+node.number).append(" \"];\n").append("");
        }else {
            graphviz.append(idNode).append(" [label=\"").append(node.anullable).append(" \\n F").append(node.first).append(" \\n L").append(node.last).append(" \\n ").append(node.lexeme.replace("\"","")).append(" \"];\n").append("");
        }
        Object leftNode =  node.left instanceof node ? ((node) node.left).getNodeVoid(): null;
        Object rightNode = node.right instanceof node ? ((node) node.right).getNodeVoid(): null;

        if (leftNode != null) {
            String idLeftNode = "node" + (identifier[0] + 1); // a identifier for the left node
            graphviz.append(idNode).append(" -> ").append(idLeftNode).append(";\n");
            identifier[0]++; // increment the identifier
            buildGraphvizTree((node) leftNode, identifier, graphviz); // recursive call
        }

        if (rightNode != null) {
            String idRightNode = "node" + (identifier[0] + 1); // a identifier for the right node
            graphviz.append(idNode).append(" -> ").append(idRightNode).append(";\n");
            identifier[0]++; // increment the identifier
            buildGraphvizTree((node) rightNode, identifier, graphviz); // recursive call
        }
        identifier[0]++; // increment the identifier

    }

}