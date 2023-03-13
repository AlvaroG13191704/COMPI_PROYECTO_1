package org.proyecto.codeAFD;

public class objectJSON {

    private String value;
    private String nameRE;
    private String result;

    public objectJSON(String value, String nameRE, String result) {
        this.value = value;
        this.nameRE = nameRE;
        this.result = result;
    }

    public String getValue() {
        return value;
    }

    public String getNameRE() {
        return nameRE;
    }

    public String getResult() {
        return result;
    }


}
