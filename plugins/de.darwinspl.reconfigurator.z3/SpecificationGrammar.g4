grammar SpecificationGrammar;

// To generate files run antlr4 -Dlanguage=Python2 -visitor -no-listener

preference:
  constraint                                 #constraintPreference |
  (MIN | MAX) '(' 'attribute[' ID ']' ')' EOF          #minMaxPreference;
 
 
constraint : b_expr EOF;

b_expr : b_term ( (AND | OR | IMPL | IFF | XOR) b_term )* ;

b_term : (NOT)? b_factor ;

b_factor : boolFact                             #bFactorFact |
           relation                             #bFactorRelation |
           ONEONLY '[' b_expr (',' b_expr)* ']'              #bFactorOneOnly;

relation : expr ((LEQ | EQ | GEQ | LT | GT | NEQ) expr)? ;

expr : term ((PLUS | MINUS | TIMES) term)* ;

term :
  INT                       #termInt |
  'context[' ID ']'                 #termContext |
  'feature[' ID ']'                  #termFeature |
  'attribute[' ID ']'                 #termAttribute |
  '(' b_expr ')'            #termBrackets;


boolFact : TRUE | FALSE;


AND : 'and';
OR : 'or';
XOR : 'xor';
ONEONLY : 'oneonly';
NOT : 'not';//	@Override
//	public Expr visitTermContext(SpecificationGrammarParser.TermContextContext ctx) {
//		Expr e = ctx.getChild(1).accept(this);
//	}
TRUE : 'true';
FALSE : 'false';
IMPL: 'impl';
IFF: 'iff';
MIN: 'min';
MAX: 'max';
ABS: 'abs';

LEQ : '<=';
EQ : '=';
GEQ : '>=';
LT : '<';
GT : '>';
NEQ : '!=';

PLUS : '+';
MINUS : '-';
TIMES : '*';

ID : [a-zA-Z_][-a-zA-Z0-9_]* ;    // match letters, numbers, underscore
INT : [-]?[0-9]+ ;
WS : [ \t\r\n]+ -> skip ; 