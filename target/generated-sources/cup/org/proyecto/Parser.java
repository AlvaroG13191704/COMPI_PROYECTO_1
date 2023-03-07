
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package org.proyecto;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import org.proyecto.Errors.Exceptions;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\004\000\002\002\005\000\002\003" +
    "\014\000\002\003\012\000\002\003\010\000\002\003\004" +
    "\000\002\003\007\000\002\003\002\000\002\006\002\000" +
    "\002\006\004\000\002\006\004\000\002\006\004\000\002" +
    "\006\004\000\002\006\004\000\002\006\004\000\002\006" +
    "\004\000\002\006\004\000\002\006\006\000\002\006\004" +
    "\000\002\004\003\000\002\004\003\000\002\004\003\000" +
    "\002\005\005\000\002\005\005\000\002\005\005\000\002" +
    "\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\004\004\004\001\002\000\012\005\ufffa\006" +
    "\012\007\010\027\011\001\002\000\004\002\006\001\002" +
    "\000\004\002\001\001\002\000\004\005\104\001\002\000" +
    "\006\010\045\013\046\001\002\000\012\005\ufffa\006\012" +
    "\007\010\027\011\001\002\000\004\013\013\001\002\000" +
    "\004\007\014\001\002\000\004\010\015\001\002\000\004" +
    "\011\016\001\002\000\010\015\023\016\020\017\022\001" +
    "\002\000\004\012\042\001\002\000\010\012\uffee\014\uffee" +
    "\025\040\001\002\000\006\012\uffe8\014\031\001\002\000" +
    "\010\012\uffed\014\uffed\025\027\001\002\000\010\012\uffec" +
    "\014\uffec\025\024\001\002\000\010\015\023\016\020\017" +
    "\022\001\002\000\004\012\uffe9\001\002\000\004\012\uffe8" +
    "\001\002\000\010\015\023\016\020\017\022\001\002\000" +
    "\004\012\uffea\001\002\000\010\015\035\016\034\017\032" +
    "\001\002\000\004\012\uffed\001\002\000\004\012\036\001" +
    "\002\000\004\012\uffee\001\002\000\004\012\uffec\001\002" +
    "\000\012\005\ufffa\006\012\007\010\027\011\001\002\000" +
    "\004\005\uffff\001\002\000\010\015\023\016\020\017\022" +
    "\001\002\000\004\012\uffeb\001\002\000\012\005\ufffa\006" +
    "\012\007\010\027\011\001\002\000\004\005\ufffe\001\002" +
    "\000\004\005\ufffc\001\002\000\004\011\052\001\002\000" +
    "\004\026\047\001\002\000\004\012\050\001\002\000\012" +
    "\005\ufffa\006\012\007\010\027\011\001\002\000\004\005" +
    "\ufffb\001\002\000\030\004\053\012\ufff9\020\060\021\057" +
    "\022\061\023\064\024\063\026\062\030\056\031\055\032" +
    "\054\001\002\000\004\007\101\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\030\004\053" +
    "\012\ufff9\020\060\021\057\022\061\023\064\024\063\026" +
    "\062\030\056\031\055\032\054\001\002\000\004\012\066" +
    "\001\002\000\012\005\ufffa\006\012\007\010\027\011\001" +
    "\002\000\004\005\ufffd\001\002\000\004\012\ufff2\001\002" +
    "\000\004\012\ufff1\001\002\000\004\012\uffef\001\002\000" +
    "\004\012\ufff3\001\002\000\004\012\ufff5\001\002\000\004" +
    "\012\ufff4\001\002\000\004\012\ufff8\001\002\000\004\012" +
    "\ufff7\001\002\000\004\012\ufff6\001\002\000\004\005\102" +
    "\001\002\000\030\004\053\012\ufff9\020\060\021\057\022" +
    "\061\023\064\024\063\026\062\030\056\031\055\032\054" +
    "\001\002\000\004\012\ufff0\001\002\000\004\002\000\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\004\002\004\001\001\000\004\003\006\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\003\043\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\020\005\016\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\004\025\005\024\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\004\025\005\027\001\001" +
    "\000\002\001\001\000\004\004\032\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\003\036\001\001\000\002\001\001\000\006\004" +
    "\025\005\040\001\001\000\002\001\001\000\004\003\042" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\050" +
    "\001\001\000\002\001\001\000\004\006\064\001\001\000" +
    "\002\001\001\000\004\006\077\001\001\000\004\006\076" +
    "\001\001\000\004\006\075\001\001\000\004\006\074\001" +
    "\001\000\004\006\073\001\001\000\004\006\072\001\001" +
    "\000\004\006\071\001\001\000\004\006\070\001\001\000" +
    "\004\006\067\001\001\000\002\001\001\000\004\003\066" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\102\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    //Clases, objetos, variables, lista, etc... en sintaxis java

    //Creo una lista de tipo String llamada 'resultados', donde guardare cada uno de los resultados analizados
    ArrayList<String> results = new ArrayList<String>();
    ArrayList<String> regex = new ArrayList<String>();
    ArrayList<String> identifiersName = new ArrayList<String>();
    // List of errors
    List<Exceptions> errors = new ArrayList();
    // Method to add errors
    public void syntax_error(Symbol s) {
        errors.add(new Exceptions("Error Sintáctico", (String) s.value, "Error sintáctico detectado", s.left, s.right));
    }
    //Unrecovered syntax error detected.
     public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        errors.add(new Exceptions("Error Sintáctico", (String) s.value, "Error sintáctico detectado sin recuperación", s.left, s.right));
     }

     public ArrayList<Exceptions> getErrors(){
         return (ArrayList<Exceptions>) errors;
     }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ini ::= LBRACE body RBRACE 
            {
              Object RESULT =null;
		 System.out.println("The file was written correctly" ); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // body ::= CONJ COLON ID ARROW1 ARROW2 option TILDE option SEMICOLON body 
            {
              Object RESULT =null;
		  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // body ::= CONJ COLON ID ARROW1 ARROW2 option_2 SEMICOLON body 
            {
              Object RESULT =null;
		 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // body ::= ID ARROW1 ARROW2 re SEMICOLON body 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		
                                                                    System.out.println("Reading a regular expresion " );
                                                                    identifiersName.add((String) id);
                                                                    results.add(regex.toString());
                                                                 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // body ::= PERCENT body 
            {
              Object RESULT =null;
		  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // body ::= ID COLON STRING SEMICOLON body 
            {
              Object RESULT =null;
		  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // body ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // re ::= 
            {
              Object RESULT =null;
		
        regex.add("NEXT");
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // re ::= SIMB1 re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);

                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // re ::= SIMB2 re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // re ::= SIMB3 re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // re ::= PLUS re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // re ::= STAR re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // re ::= QUESTION re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // re ::= OR re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);

                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // re ::= DOT re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);

                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // re ::= LBRACE ID RBRACE re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) var);

                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // re ::= STRING re 
            {
              Object RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                    RESULT = regex.add((String) "\""+ var + "\"");
                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("re",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // option ::= LETTER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // option ::= NUMBER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // option ::= SPECIAL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // option_2 ::= LETTER COMMA option_2 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option_2",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // option_2 ::= NUMBER COMMA option_2 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option_2",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // option_2 ::= SPECIAL COMMA option_2 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option_2",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // option_2 ::= option 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("option_2",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
