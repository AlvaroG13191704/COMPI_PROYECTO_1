package org.proyecto.treeMethod;

import java.util.Arrays;

public final class numLeave {

    public int content;

    public numLeave(String content) {
        this.content = clean(content) + 1;
    }

    public int getNum(){
        content -= 1;
        System.out.println(content);
        return content;
    }


    public int clean(String content){
        // Split the string
        String[] contentSplit = content.split(",");
        // Iterate through the array and eleminate the |, . , * , +, ?
        for (String s : contentSplit) {
            if (s.equals("|") || s.equals(".") || s.equals("*") || s.equals("+") || s.equals("?")) {
                // delete
                contentSplit = Arrays.stream(contentSplit).filter(x -> !x.equals(s)).toArray(String[]::new);
            }
        }
        return contentSplit.length;
    }
}
