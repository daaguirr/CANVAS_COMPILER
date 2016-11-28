package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;
import Model.*;

%%
%class Lexer
%implements sym
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
    public Symbol symbol(String name, int code, int lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    public Symbol symbol(String name, int code, Color lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    public Symbol symbol(String name, int code, Direction lexem){
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
Color		= A | R | V | B | N
Direction	=	S|N|E|O

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

num = 0 | [1-9][0-9]*

%eofval{
	return symbol("EOF",EOF);
%eofval}

%%

<YYINITIAL>	{
	{Whitespace} 		{		                            		}
	";"          		{ return symbol("SEMI",sym.SEMI); 			}
	"if"		   		{ return symbol("IF",sym.IF);     			}
	"then"	   			{ return symbol("THEN",sym.THEN); 			}
	"else"	   			{ return symbol("ELSE",sym.ELSE);  			}
	"while"				{ return symbol("WHILE",sym.WHILE);			}
	"do"				{ return symbol("DO",sym.DO);				}
	"bajar-pluma"		{ return symbol("BAJARP",sym.BAJARP);		}
	"levantar-pluma"	{ return symbol("SUBIRP",sym.SUBIRP);		}
	"color-pluma"		{ return symbol("COLORP",sym.COLORP);		}
	"direccion-pluma"	{ return symbol("DIRP",sym.DIRP);			}
	"avanzar"			{ return symbol("AVAZ",sym.AVAZ);			}
	"pluma-dir"			{ return symbol("PLUMADIR",sym.PLUMADIR);	}
	"pluma-col"			{ return symbol("PLUMACOL",sym.PLUMACOL);	}
	"pluma-arriba"		{ return symbol("PLUMAUP",sym.PLUMAUP);		}
	"pluma-abajo"		{ return symbol("PLUMADOWN",sym.PLUMADOWN);	}
	"and"				{ return symbol("AND",sym.AND);				}
	"or"				{ return symbol("OR",sym.OR);				}
	"not"				{ return symbol("NOT",sym.NOT);				}
	"borde"				{ return symbol("BORDE",sym.BORDE);			}
	"{"					{ return symbol("BRACKETL",sym.BRACKETL);  	}
	"}"					{ return symbol("BRACKETR" ,sym.BRACKETR);	}
	{Number}     		{ return symbol("num", sym.num, Integer.parseInt(yytext())); }
	{Direction}			{ return symbol("c",sym.c, new Color(yytext().charAt(0)));	}
	{Color}				{ return symbol("d",sym.d, new Direction(yytext().charAt(0)));}
}



[^]                 { throw new Error("Illegal character <"+
                                                        yytext()+">"); }