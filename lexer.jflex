package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%
%class Lexer
%unicode
%cup
%line
%column
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
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

num = 0 | [1-9][0-9]*

%state STRING
%%

<YYINITIAL>	{
	{Whitespace} 		{		                            						}
	";"          		{ return symbolFactory.newSymbol("SEMI",sym.SEMI); 			}
	"if"		   		{ return symbolFactory.newSymbol("IF",sym.IF);     			}
	"then"	   			{ return symbolFactory.newSymbol("THEN",sym.THEN); 			}
	"else"	   			{ return symbolFactory.newSymbol("ELSE",sym.ELSE);  		}
	"while"				{ return symbolFactory.newSymbol("WHILE",sym.WHILE);		}
	"do"				{ return symbolFactory.newSymbol("DO",sym.DO);				}
	"bajar-pluma"		{ return symbolFactory.newSymbol("BAJARP",sym.BAJARP);		}
	"levantar-pluma"	{ return symbolFactory.newSymbol("SUBIRP",sym.SUBIRP);		}
	"color-pluma"		{ return symbolFactory.newSymbol("COLORP",sym.COLORP);		}
	"direccion-pluma"	{ return symbolFactory.newSymbol("DIRP",sym.DIRP);			}
	"avanzar"			{ return symbolFactory.newSymbol("AVAZ",sym.AVAZ);			}
	"pluma-dir"			{ return symbolFactory.newSymbol("PLUMADIR",sym.PLUMADIR);	}
	"pluma-col"			{ return symbolFactory.newSymbol("PLUMACOL",sym.PLUMACOL);	}
	"pluma-arriba"		{ return symbolFactory.newSymbol("PLUMAUP",sym.PLUMAUP);	}
	"pluma-abajo"		{ return symbolFactory.newSymbol("PLUMADOWN",sym.PLUMADOWN);}
	"and"				{ return symbolFactory.newSymbol("AND",sym.AND);			}
	"or"				{ return symbolFactory.newSymbol("OR",sym.OR);				}
	"not"				{ return symbolFactory.newSymbol("NOT",sym.NOT);			}
	"borde"				{ return symbolFactory.newSymbol("BORDE",sym.BORDE);		}
	"{"					{ return symbolFactory.newSymbol("BRACKETL",sym.BRACKETL);  }
	"}"					{ return symbolFactory.newSymbol("BRACKETR" ,sym.BRACKETR);	}
	{Number}     		{ return symbolFactory.newSymbol("num", sym.num, Integer.parseInt(yytext())); }
}



[^]                 { throw new Error("Illegal character <"+
                                                        yytext()+">"); }