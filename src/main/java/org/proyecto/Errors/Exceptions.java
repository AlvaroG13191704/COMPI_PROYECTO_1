package org.proyecto.Errors;

public class Exceptions {
    public String type;
    public String description;
    public int line;
    public int col;
    public String value;
    // constructor
    public Exceptions(String type, String value, String description, int line, int col) {
        this.type = type;
        this.value= value;
        this.description = description;
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Error: " + type + " - " + description + " - Linea: " + line + " - Columna: " + col;
    }
}
