// DO NOT EDIT
// Generated by JFlex 1.9.0 http://jflex.de/
// source: src/main/jflex/Lexer.flex

package org.proyecto;
import java_cup.runtime.*;
import org.proyecto.Errors.Exceptions;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("fallthrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int COMMNET = 2;
  public static final int SETS = 4;
  public static final int OPTIONS = 6;
  public static final int POLISH = 8;
  public static final int QUOATION_MARKS = 10;
  public static final int RE_SET = 12;
  public static final int STRING = 14;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\4\22\0\1\1\1\5"+
    "\1\6\2\7\1\10\4\7\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\12\17\1\20\1\21\1\22\1\7\1\23"+
    "\1\24\1\7\2\25\1\26\6\25\1\27\3\25\1\30"+
    "\1\31\13\25\1\7\1\32\2\7\1\33\1\7\15\25"+
    "\1\34\3\25\1\35\1\25\1\36\6\25\1\37\1\40"+
    "\1\41\1\42\6\0\1\3\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\10\0\1\1\1\2\1\3\1\1\1\4\1\1\1\5"+
    "\1\6\1\1\1\7\2\10\1\11\1\12\1\2\1\13"+
    "\1\2\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\2\1\40\1\10"+
    "\1\41\1\42\1\43\1\44\1\45\1\10\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\106\0\151\0\214\0\257\0\322\0\365"+
    "\0\u0118\0\u013b\0\u0118\0\u015e\0\u0118\0\u0181\0\u0118\0\u0118"+
    "\0\u01a4\0\u0118\0\u01c7\0\u01ea\0\u0118\0\u0118\0\u0118\0\u0118"+
    "\0\u020d\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118"+
    "\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118"+
    "\0\u0118\0\u0230\0\u0118\0\u0253\0\u0118\0\u0276\0\u0118\0\u0299"+
    "\0\u0118\0\u0118\0\u0118\0\u0118\0\u0118\0\u02bc\0\u01c7";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\11\2\12\1\0\1\12\1\11\1\13\1\11\1\14"+
    "\3\11\1\15\1\11\1\16\1\11\1\17\1\20\1\21"+
    "\1\22\1\11\1\23\1\24\3\23\1\11\4\23\1\25"+
    "\1\11\1\26\1\11\2\27\1\30\2\0\1\31\35\27"+
    "\1\11\2\12\1\0\1\12\6\11\1\32\1\15\3\11"+
    "\1\17\1\33\1\11\1\34\1\11\5\23\1\11\4\23"+
    "\3\11\1\35\1\11\2\12\1\0\1\12\12\36\1\37"+
    "\5\36\5\40\2\36\3\40\4\36\1\41\2\12\1\0"+
    "\1\12\1\41\1\13\2\41\1\42\1\43\2\41\1\44"+
    "\3\41\1\45\2\41\1\46\12\41\1\47\1\50\2\41"+
    "\2\11\3\0\36\11\2\41\3\0\20\41\5\23\1\41"+
    "\4\23\2\41\1\51\1\41\2\52\1\0\1\52\1\0"+
    "\1\52\1\53\23\52\1\54\10\52\44\0\2\12\1\0"+
    "\1\12\46\0\1\55\50\0\1\56\31\0\1\57\54\0"+
    "\1\23\5\0\5\23\1\0\4\23\23\0\1\23\5\0"+
    "\4\23\1\60\1\0\4\23\27\0\1\61\17\0\2\52"+
    "\1\0\1\52\1\0\1\52\1\0\23\52\1\0\10\52"+
    "\6\0\1\62\25\0\1\63\1\64\1\65\4\0\2\56"+
    "\3\0\36\56\17\0\1\23\5\0\3\23\1\66\1\23"+
    "\1\0\4\23\23\0\1\23\5\0\2\23\1\67\2\23"+
    "\1\0\4\23\4\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[735];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\10\0\1\11\1\1\1\11\1\1\1\11\1\1\2\11"+
    "\1\1\1\11\2\1\4\11\1\1\20\11\1\1\1\11"+
    "\1\1\1\11\1\1\1\11\1\1\5\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    StringBuffer string = new StringBuffer();
            // Array of errors
    public List<Exceptions> errors = new ArrayList<Exceptions>();


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
      yyline = 1;
    yychar = 1;
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return new Symbol(ParserSym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
        errors.add(new Exceptions("Error Léxico",yytext(), "Caracter desconocido: ", yyline, yycolumn));
            }
          // fall through
          case 39: break;
          case 2:
            { /* ignore */
            }
          // fall through
          case 40: break;
          case 3:
            { yybegin(STRING);
        string.setLength(0);
            }
          // fall through
          case 41: break;
          case 4:
            { return new Symbol(ParserSym.ARROW1,yyline, yycolumn, yytext());
            }
          // fall through
          case 42: break;
          case 5:
            { return new Symbol(ParserSym.COLON,yyline, yycolumn, yytext());
            }
          // fall through
          case 43: break;
          case 6:
            { return new Symbol(ParserSym.SEMICOLON,yyline, yycolumn, yytext());
            }
          // fall through
          case 44: break;
          case 7:
            { yybegin(POLISH);
    return new Symbol(ParserSym.ARROW2,yyline, yycolumn, yytext());
            }
          // fall through
          case 45: break;
          case 8:
            { return new Symbol(ParserSym.ID,yyline, yycolumn, yytext());
            }
          // fall through
          case 46: break;
          case 9:
            { return new Symbol(ParserSym.LBRACE,yyline, yycolumn, yytext());
            }
          // fall through
          case 47: break;
          case 10:
            { return new Symbol(ParserSym.RBRACE,yyline, yycolumn, yytext());
            }
          // fall through
          case 48: break;
          case 11:
            { yyline++; yychar = 1;
            }
          // fall through
          case 49: break;
          case 12:
            { yybegin(OPTIONS);
          return new Symbol(ParserSym.COMMA,yyline, yycolumn, yytext());
            }
          // fall through
          case 50: break;
          case 13:
            { yybegin(YYINITIAL);
        return new Symbol(ParserSym.SEMICOLON,yyline, yycolumn, yytext());
            }
          // fall through
          case 51: break;
          case 14:
            { yybegin(OPTIONS);
    return new Symbol(ParserSym.ARROW2,yyline, yycolumn, yytext());
            }
          // fall through
          case 52: break;
          case 15:
            { yybegin(OPTIONS);
        return new Symbol(ParserSym.TILDE,yyline, yycolumn, yytext());
            }
          // fall through
          case 53: break;
          case 16:
            { yybegin(SETS);
          return new Symbol(ParserSym.SPECIAL,yyline, yycolumn, yytext());
            }
          // fall through
          case 54: break;
          case 17:
            { yybegin(SETS);
          return new Symbol(ParserSym.NUMBER,yyline, yycolumn, yytext());
            }
          // fall through
          case 55: break;
          case 18:
            { yybegin(SETS);
          return new Symbol(ParserSym.LETTER,yyline, yycolumn, yytext());
            }
          // fall through
          case 56: break;
          case 19:
            { System.err.println("Error: Line " + yyline + ", Column " + yycolumn + ": Unknow character: " + yytext());
         errors.add(new Exceptions("Error Léxico",yytext(), "Caracter desconocido: ", yyline, yycolumn));
            }
          // fall through
          case 57: break;
          case 20:
            { return new Symbol(ParserSym.STAR,yyline, yycolumn, yytext());
            }
          // fall through
          case 58: break;
          case 21:
            { return new Symbol(ParserSym.PLUS,yyline, yycolumn, yytext());
            }
          // fall through
          case 59: break;
          case 22:
            { return new Symbol(ParserSym.DOT,yyline, yycolumn, yytext());
            }
          // fall through
          case 60: break;
          case 23:
            { yybegin(YYINITIAL);
          return new Symbol(ParserSym.SEMICOLON,yyline, yycolumn, yytext());
            }
          // fall through
          case 61: break;
          case 24:
            { return new Symbol(ParserSym.QUESTION,yyline, yycolumn, yytext());
            }
          // fall through
          case 62: break;
          case 25:
            { yybegin(RE_SET);
        return new Symbol(ParserSym.LBRACE,yyline, yycolumn, yytext());
            }
          // fall through
          case 63: break;
          case 26:
            { return new Symbol(ParserSym.OR,yyline, yycolumn, yytext());
            }
          // fall through
          case 64: break;
          case 27:
            { yybegin(POLISH);
          return new Symbol(ParserSym.RBRACE,yyline, yycolumn, yytext());
            }
          // fall through
          case 65: break;
          case 28:
            { string.append( yytext() );
            }
          // fall through
          case 66: break;
          case 29:
            { yybegin(POLISH);
                                      return new Symbol(ParserSym.STRING, yyline, yycolumn, string.toString());
            }
          // fall through
          case 67: break;
          case 30:
            { string.append('\\');
            }
          // fall through
          case 68: break;
          case 31:
            { return new Symbol(ParserSym.PERCENT,yyline, yycolumn, yytext());
            }
          // fall through
          case 69: break;
          case 32:
            { yybegin(COMMNET);
            }
          // fall through
          case 70: break;
          case 33:
            { yybegin(YYINITIAL);
            }
          // fall through
          case 71: break;
          case 34:
            { string.append('\"');
            }
          // fall through
          case 72: break;
          case 35:
            { string.append('\n');
            }
          // fall through
          case 73: break;
          case 36:
            { string.append('\r');
            }
          // fall through
          case 74: break;
          case 37:
            { string.append('\t');
            }
          // fall through
          case 75: break;
          case 38:
            { yybegin(SETS);
          return new Symbol(ParserSym.CONJ,yyline, yycolumn, yytext());
            }
          // fall through
          case 76: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
