package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  {Whitespace} 		{                              							}
  ";"          		{ return symbol(sym.SEMI); 		}
  "if"		   		{ return symbol(sym.IF);     		}
  "then"	   		{ return symbol(sym.THEN); 		}
  "else"	   		{ return symbol(sym.ELSE);  		}
  "while"			{ return symbol(sym.WHILE);		}
  "do"				{ return symbol("DO",sym.DO);				}
  "bajar-pluma"		{ return symbol(sym.BAJARP);		}
  "levantar-pluma"	{ return symbol(sym.SUBIRP);		}
  "color-pluma"		{ return symbol(sym.COLORP);		}
  "direccion-pluma"	{ return symbol(sym.DIRP);			}
  "avanzar"			{ return symbol(sym.AVAZ);			}
  "pluma-dir"		{ return symbol(sym.PLUMAD);		}
  "pluma-col"		{ return symbol(sym.PLUMACOL);	}
  "pluma-arriba"	{ return symbol(sym.PLUMAUP);	}
  "pluma-abajo"		{ return symbol(sym.PLUMADOWN);}
  "and"				{ return symbol(sym.AND);			}
  "or"				{ return symbol(sym.OR);				}
  "not"				{ return symbol(sym.NOT);			}
  "borde"			{ return symbol(sym.BORDE);		}
  "{"				{ return symbol(sym.BRACKETL);  }
  "}"				{ return symbol( sym.BRACKETR);}
  {Number}     		{ return symbolFactory.newSymbol("num", num, Integer.parseInt(yytext())); }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }