grammar SpecificationGrammar;

// To generate files run antlr4 -Dlanguage=Python2 -visitor -no-listener

data: 
  'FEATURE_NUM' INT ';'
  'CONTEXT_NUM' INT ';'
  'ATTRIBUTES_NUM' int_list ';'
  'DOMAIN_ATTRIBUTES' int_list ';'
  'DOMAIN_CONTEXT' int_list ';'
  'INITIAL_FEATURES' int_list ';'
  'INITIAL_ATTRIBUTES' int_list
  ( ';' constraint_list )?                       # Adata;

int_list: 
  '[' ( INT ( ',' INT)* )? ']'           # AintList ;
 
constraint_list:  
  '[' ( constraint ( ',' constraint)* )? ']'           # AconstraintList ;

constraint: 
  constraint bool2Op constraint     # AconstraintBool2Op |
  bool1Op constraint                # AconstraintBool1Op |
  '(' constraint ')'                # AconstraintBrackets |
  expr op expr                      # AconstraintExpression  |
  boolFact                          # AboolFact  ;

expr :
  '('expr ')'                     # AexprBrackets |
  expr arithmetic_op expr					# AexprArithmetic |
  MINUS expr                      # AexprMinus |
  INT                             # AexprInt |
  atom                              # AexprId ;

atom :
  'context[' INT ']'               # AatomContex |
  'feature[' INT ']'              # AatomFeature |
  'attribute[' INT '][' INT ']'   # AatomAttribute ;
 

op : LEQ | EQ | GEQ | LT | GT | NEQ ;

arithmetic_op : PLUS | MINUS | TIMES ;

bool2Op : AND | OR | IMPL | IFF;
bool1Op : NOT;
boolFact : TRUE | FALSE;

AND : 'and';
OR : 'or';
NOT : 'not';
TRUE : 'true';
FALSE : 'false';
IMPL: 'impl';
IFF: 'iff';
EXISTS: 'exists';
FORALL: 'forall';
SUM: 'sum';
COST: 'cost';

LEQ : '<=';
EQ : '=';
GEQ : '>=';
LT : '<';
GT : '>';
NEQ : '!=';

PLUS : '+';
MINUS : '-';
TIMES : '*';

      
ID : [a-zA-Z_][a-zA-Z0-9_]* ;    // match letters, numbers, underscore
INT : [-]?[0-9]+ ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
