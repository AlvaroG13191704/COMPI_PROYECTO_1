package org.proyecto.Errors;
public class LexicalError extends Throwable {
    private String type;
    private int line;
    private int column;
    private String message;

    private String lexema;

    public LexicalError(String type, int line, int column, String message, String lexema) {
        this.type = type;
        this.line = line;
        this.column = column;
        this.message = message;
        this.lexema = lexema;
    }

    public String getType() {
        return type;
    }
    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getMessage() {
        return message;
    }

    public String getLexema() {
        return lexema;
    }

}
