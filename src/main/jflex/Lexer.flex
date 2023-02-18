package org.proyecto;
import java_cup.runtime.*;
import java.io.*;
%%

%{
    // Some code in java
%}

//Directives
%class Lexer
%public
%cup
%char
%column
%line
%unicode

%init{ // start couting the line and column number
    yyline = 1;
    yychar = 1;
%init}
%eofval{
    return new Symbol(ParserSym.EOF);
%eofval}

// Some states to use in the lexer
%state COMMNET
%state SETS
%state OPTIONS
%state POLISH
%state QUOATION_MARKS
%state RE_SET

// Regular expressions
FLOAT_NUMBER = [0-9]*\.[0-9]+
INT_NUMBER = [0-9]+
ID = [a-zA-Z_][a-zA-Z_0-9]*
SPECIAL_CHARACTERS = [\x20-\x2F\x3A-\x40\x5B-\x60\x7B-\x7E]
LETTER = [a-zA-Z]
NUMBER = [0-9]
%%

// Comments
<YYINITIAL> {
    /* Handle static regular expressions */
    "{" { return new Symbol(ParserSym.LBRACE,yyline, yycolumn, yytext()); }

    "}" { return new Symbol(ParserSym.RBRACE,yyline, yycolumn, yytext()); }

    /* Ignore whitespace */
    [ \t\r\n]+ { /* ignore */ }

    /* count lines */
    \n { yyline++; yychar = 1; }

    /* count jump lines */
    \r { yyline++; yychar = 1; }
    /* One line comment */
    "//".* { /* ignore */ }

    /* Multi line comment */
    "<!" {yybegin(COMMNET);}

     /* Handle sets like to declare regular expressions */
     "CONJ" {
          yybegin(SETS);
          return new Symbol(ParserSym.CONJ,yyline, yycolumn, yytext());
      }

    /* Handle polish regular expressions */
    {ID} {
        return new Symbol(ParserSym.ID,yyline, yycolumn, yytext());
      }
   /* Handle arrow */
   "->" {
        yybegin(POLISH);
        return new Symbol(ParserSym.ARROW,yyline, yycolumn, yytext());
      }
    /* Handle %% then move to analyze the matches */


    /* Handle errors */
    . {
        System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
      }
}
<POLISH>{
   /* Handle semicolon */
   ";" {        yybegin(YYINITIAL);
          return new Symbol(ParserSym.SEMICOLON,yyline, yycolumn, yytext());
      }
   /* Ignore whitespace */
   [ \t\r\n]+ { /* ignore */ }
   /* Handle + */
   "+" {return new Symbol(ParserSym.PLUS,yyline, yycolumn, yytext());}
   /* Handle * */
   "*" {return new Symbol(ParserSym.STAR,yyline, yycolumn, yytext());}
   /* Handle ? */
   "?" {return new Symbol(ParserSym.QUESTION,yyline, yycolumn, yytext());}
   /* Handle | */
   "|" {return new Symbol(ParserSym.OR,yyline, yycolumn, yytext());}
    /* Handle . */
    "." {return new Symbol(ParserSym.DOT,yyline, yycolumn, yytext());}
    /* Handle {  a set */
    "{" {
        yybegin(RE_SET);
        return new Symbol(ParserSym.LBRACE,yyline, yycolumn, yytext());
      }
    /* Handle string  */
    "\"" {
        yybegin(QUOATION_MARKS);
        return new Symbol(ParserSym.QUOTE,yyline, yycolumn, yytext());
      }
     /* Handle errors */
     . {
         System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
       }
   }

<RE_SET>{
    /* Handle identifiers */
   {ID} {return new Symbol(ParserSym.ID,yyline, yycolumn, yytext());}

    "}" {
          yybegin(POLISH);
          return new Symbol(ParserSym.RBRACE,yyline, yycolumn, yytext());
      }
    /* Handle errors */
     . {
         System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
       }
}

<QUOATION_MARKS>{
    /* Handle special characteres */
    {SPECIAL_CHARACTERS} {return new Symbol(ParserSym.SPECIAL,yyline, yycolumn, yytext());}

    /* Handle letters */
    {LETTER} {return new Symbol(ParserSym.LETTER,yyline, yycolumn, yytext());}

    /* Handle numbers */
    {NUMBER} {return new Symbol(ParserSym.NUMBER,yyline, yycolumn, yytext());}

    \" {
          yybegin(POLISH);
          return new Symbol(ParserSym.QUOTE,yyline, yycolumn, yytext());
      }
    /* Handle errors */
     . {
         System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
       }
}
<SETS>{
    /* The unique form to declared sets is: CONJ:identifier -> [special simbols]|[letters]|[numbers] "~" [special simbols]|[letters]|[numbers];  */
    /* Handle semicolon */
    ";" {
        yybegin(YYINITIAL);
        return new Symbol(ParserSym.SEMICOLON,yyline, yycolumn, yytext());
      }
    /* Ignore whitespace */
    [ \t\r\n]+ { /* ignore */ }
    /* Handle colon */
    ":" { return new Symbol(ParserSym.COLON,yyline, yycolumn, yytext()); }

    /* Handle identifiers */
    {ID} { return new Symbol(ParserSym.ID,yyline, yycolumn, yytext()); }

    /* Handle arrow */
    "->" {
        yybegin(OPTIONS);
        return new Symbol(ParserSym.ARROW,yyline, yycolumn, yytext());
      }

    /* Handle ~ */
    "~" {
        yybegin(OPTIONS);
        return new Symbol(ParserSym.TILDE,yyline, yycolumn, yytext());
      }

    /* Handle errors */
    . {
        System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
      }
}

<OPTIONS>{

    /* Ignore whitespace */
    [ \t\r\n]+ { /* ignore */ }
     /* Handle special characteres */
    {SPECIAL_CHARACTERS} {
          yybegin(SETS);
          return new Symbol(ParserSym.SPECIAL,yyline, yycolumn, yytext());
      }

    /* Handle letters */
    {LETTER} {
          yybegin(SETS);
          return new Symbol(ParserSym.LETTER,yyline, yycolumn, yytext());
      }

    /* Handle numbers */
    {NUMBER} {
          yybegin(SETS);
          return new Symbol(ParserSym.NUMBER,yyline, yycolumn, yytext());
      }

    /* Handle errors */
    . {
        System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
      }
}

<COMMNET> {
    /* count lines */
    \n { yyline++; yychar = 1; }

    /* Multi line comment */
    "!>" {yybegin(YYINITIAL);}

    /* Ignore everything else */
    . { /* ignore */ }
}
