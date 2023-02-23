package org.proyecto.treeMethod;

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
        String aux = content.replace(".", "").replace("|", "").replace("*", "").replace("+", "").replace("?", "");
        System.out.println(aux);
        return aux.length();
    }
}
