package org.proyecto.treeMethod;

import java.util.ArrayList;

public class treeInfo {
    public String lexeme;
    public int number;
    public ArrayList<Integer> first;
    public ArrayList<Integer> last;
    public boolean anullable;

    public static ArrayList<treeInfo> treeInfoArrayList = new ArrayList<>();
    public treeInfo( String lexeme, int number, ArrayList<Integer> first, ArrayList<Integer> last, boolean anullable) {
        this.lexeme = lexeme;
        this.number = number;
        this.first = first;
        this.last = last;
        this.anullable = anullable;
    }

    public void addTreeInfo(treeInfo treeInfo){
        treeInfoArrayList.add(treeInfo);
    }


}
