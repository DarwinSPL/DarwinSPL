// $ANTLR 3.4

	package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class HyvalidityformulaLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
    	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
    	
    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public HyvalidityformulaLexer() {} 
    public HyvalidityformulaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HyvalidityformulaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Hyvalidityformula.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:20:7: ( '!' )
            // Hyvalidityformula.g:20:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:21:7: ( '!=' )
            // Hyvalidityformula.g:21:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:22:7: ( '&&' )
            // Hyvalidityformula.g:22:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:23:7: ( '(' )
            // Hyvalidityformula.g:23:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:24:7: ( ')' )
            // Hyvalidityformula.g:24:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:25:7: ( '*' )
            // Hyvalidityformula.g:25:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:26:7: ( '+' )
            // Hyvalidityformula.g:26:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:27:7: ( ',' )
            // Hyvalidityformula.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:28:7: ( '-' )
            // Hyvalidityformula.g:28:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:29:7: ( '->' )
            // Hyvalidityformula.g:29:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:30:7: ( '.' )
            // Hyvalidityformula.g:30:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:31:7: ( '/' )
            // Hyvalidityformula.g:31:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:32:7: ( ':' )
            // Hyvalidityformula.g:32:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:33:7: ( '<' )
            // Hyvalidityformula.g:33:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:34:7: ( '<->' )
            // Hyvalidityformula.g:34:9: '<->'
            {
            match("<->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:35:7: ( '<=' )
            // Hyvalidityformula.g:35:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:36:7: ( '=' )
            // Hyvalidityformula.g:36:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:37:7: ( '>' )
            // Hyvalidityformula.g:37:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:38:7: ( '>=' )
            // Hyvalidityformula.g:38:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:39:7: ( '?' )
            // Hyvalidityformula.g:39:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:40:7: ( 'Enum(' )
            // Hyvalidityformula.g:40:9: 'Enum('
            {
            match("Enum("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:41:7: ( 'EnumLiteral(' )
            // Hyvalidityformula.g:41:9: 'EnumLiteral('
            {
            match("EnumLiteral("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:42:7: ( '[' )
            // Hyvalidityformula.g:42:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:43:7: ( '\\u0025' )
            // Hyvalidityformula.g:43:9: '\\u0025'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:44:7: ( ']' )
            // Hyvalidityformula.g:44:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:45:7: ( '^' )
            // Hyvalidityformula.g:45:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:46:7: ( 'context:' )
            // Hyvalidityformula.g:46:9: 'context:'
            {
            match("context:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:47:7: ( 'enum:' )
            // Hyvalidityformula.g:47:9: 'enum:'
            {
            match("enum:"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:48:7: ( 'eternity' )
            // Hyvalidityformula.g:48:9: 'eternity'
            {
            match("eternity"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:49:7: ( 'false' )
            // Hyvalidityformula.g:49:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:50:7: ( 'ifPossible(' )
            // Hyvalidityformula.g:50:9: 'ifPossible('
            {
            match("ifPossible("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:51:7: ( 'max(' )
            // Hyvalidityformula.g:51:9: 'max('
            {
            match("max("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:52:7: ( 'min(' )
            // Hyvalidityformula.g:52:9: 'min('
            {
            match("min("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:53:7: ( 'true' )
            // Hyvalidityformula.g:53:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:54:7: ( '||' )
            // Hyvalidityformula.g:54:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5547:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Hyvalidityformula.g:5548:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Hyvalidityformula.g:5548:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Hyvalidityformula.g:5548:2: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Hyvalidityformula.g:5548:2: ( '\"' )
            // Hyvalidityformula.g:5548:3: '\"'
            {
            match('\"'); 

            }


            // Hyvalidityformula.g:5548:7: (~ ( '\"' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // Hyvalidityformula.g:5548:16: ( '\"' )
            // Hyvalidityformula.g:5548:17: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    // $ANTLR start "IDENTIFIER_TOKEN"
    public final void mIDENTIFIER_TOKEN() throws RecognitionException {
        try {
            int _type = IDENTIFIER_TOKEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5550:17: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? ) )
            // Hyvalidityformula.g:5551:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            {
            // Hyvalidityformula.g:5551:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            // Hyvalidityformula.g:5551:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Hyvalidityformula.g:5551:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // Hyvalidityformula.g:5551:59: ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='@') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Hyvalidityformula.g:5551:60: '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    {
                    match('@'); 

                    // Hyvalidityformula.g:5551:63: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    // Hyvalidityformula.g:5551:64: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    {
                    // Hyvalidityformula.g:5551:64: ( '-' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Hyvalidityformula.g:5551:65: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyvalidityformula.g:5551:71: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Hyvalidityformula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match('/'); 

                    // Hyvalidityformula.g:5551:86: ( '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Hyvalidityformula.g:5551:87: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyvalidityformula.g:5551:93: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Hyvalidityformula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    match('/'); 

                    // Hyvalidityformula.g:5551:108: ( '-' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Hyvalidityformula.g:5551:109: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyvalidityformula.g:5551:115: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Hyvalidityformula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    // Hyvalidityformula.g:5551:127: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='T') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Hyvalidityformula.g:5551:129: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            {
                            match('T'); 

                            // Hyvalidityformula.g:5551:132: ( '-' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0=='-') ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // Hyvalidityformula.g:5551:133: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyvalidityformula.g:5551:139: ( '0' .. '9' )+
                            int cnt10=0;
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // Hyvalidityformula.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt10 >= 1 ) break loop10;
                                        EarlyExitException eee =
                                            new EarlyExitException(10, input);
                                        throw eee;
                                }
                                cnt10++;
                            } while (true);


                            match(':'); 

                            // Hyvalidityformula.g:5551:154: ( '-' )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0=='-') ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // Hyvalidityformula.g:5551:155: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyvalidityformula.g:5551:161: ( '0' .. '9' )+
                            int cnt12=0;
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // Hyvalidityformula.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt12 >= 1 ) break loop12;
                                        EarlyExitException eee =
                                            new EarlyExitException(12, input);
                                        throw eee;
                                }
                                cnt12++;
                            } while (true);


                            // Hyvalidityformula.g:5551:173: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==':') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // Hyvalidityformula.g:5551:174: ':' ( '-' )? ( '0' .. '9' )+
                                    {
                                    match(':'); 

                                    // Hyvalidityformula.g:5551:178: ( '-' )?
                                    int alt13=2;
                                    int LA13_0 = input.LA(1);

                                    if ( (LA13_0=='-') ) {
                                        alt13=1;
                                    }
                                    switch (alt13) {
                                        case 1 :
                                            // Hyvalidityformula.g:5551:179: '-'
                                            {
                                            match('-'); 

                                            }
                                            break;

                                    }


                                    // Hyvalidityformula.g:5551:185: ( '0' .. '9' )+
                                    int cnt14=0;
                                    loop14:
                                    do {
                                        int alt14=2;
                                        int LA14_0 = input.LA(1);

                                        if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                                            alt14=1;
                                        }


                                        switch (alt14) {
                                    	case 1 :
                                    	    // Hyvalidityformula.g:
                                    	    {
                                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                                    	        input.consume();
                                    	    }
                                    	    else {
                                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                                    	        recover(mse);
                                    	        throw mse;
                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    if ( cnt14 >= 1 ) break loop14;
                                                EarlyExitException eee =
                                                    new EarlyExitException(14, input);
                                                throw eee;
                                        }
                                        cnt14++;
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER_TOKEN"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5553:5: ( ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) ) )
            // Hyvalidityformula.g:5554:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            {
            // Hyvalidityformula.g:5554:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            // Hyvalidityformula.g:5554:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            {
            // Hyvalidityformula.g:5554:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            // Hyvalidityformula.g:5554:3: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            {
            // Hyvalidityformula.g:5554:3: ( '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Hyvalidityformula.g:5554:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyvalidityformula.g:5554:10: ( '0' .. '9' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            match('/'); 

            // Hyvalidityformula.g:5554:25: ( '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='-') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Hyvalidityformula.g:5554:26: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyvalidityformula.g:5554:32: ( '0' .. '9' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= '0' && LA21_0 <= '9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            match('/'); 

            // Hyvalidityformula.g:5554:47: ( '-' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='-') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Hyvalidityformula.g:5554:48: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyvalidityformula.g:5554:54: ( '0' .. '9' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= '0' && LA23_0 <= '9')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            // Hyvalidityformula.g:5554:66: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='T') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Hyvalidityformula.g:5554:68: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    {
                    match('T'); 

                    // Hyvalidityformula.g:5554:71: ( '-' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='-') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // Hyvalidityformula.g:5554:72: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyvalidityformula.g:5554:78: ( '0' .. '9' )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0 >= '0' && LA25_0 <= '9')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Hyvalidityformula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    match(':'); 

                    // Hyvalidityformula.g:5554:93: ( '-' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='-') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // Hyvalidityformula.g:5554:94: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyvalidityformula.g:5554:100: ( '0' .. '9' )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0 >= '0' && LA27_0 <= '9')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // Hyvalidityformula.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    // Hyvalidityformula.g:5554:112: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==':') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // Hyvalidityformula.g:5554:113: ':' ( '-' )? ( '0' .. '9' )+
                            {
                            match(':'); 

                            // Hyvalidityformula.g:5554:117: ( '-' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0=='-') ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // Hyvalidityformula.g:5554:118: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyvalidityformula.g:5554:124: ( '0' .. '9' )+
                            int cnt29=0;
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( ((LA29_0 >= '0' && LA29_0 <= '9')) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // Hyvalidityformula.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt29 >= 1 ) break loop29;
                                        EarlyExitException eee =
                                            new EarlyExitException(29, input);
                                        throw eee;
                                }
                                cnt29++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "INTEGER_LITERAL"
    public final void mINTEGER_LITERAL() throws RecognitionException {
        try {
            int _type = INTEGER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5556:16: ( ( ( '-' )? ( '0' .. '9' )+ ) )
            // Hyvalidityformula.g:5557:2: ( ( '-' )? ( '0' .. '9' )+ )
            {
            // Hyvalidityformula.g:5557:2: ( ( '-' )? ( '0' .. '9' )+ )
            // Hyvalidityformula.g:5557:2: ( '-' )? ( '0' .. '9' )+
            {
            // Hyvalidityformula.g:5557:2: ( '-' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='-') ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Hyvalidityformula.g:5557:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyvalidityformula.g:5557:9: ( '0' .. '9' )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0 >= '0' && LA33_0 <= '9')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_LITERAL"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5559:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Hyvalidityformula.g:5560:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Hyvalidityformula.g:5560:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Hyvalidityformula.g:5560:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Hyvalidityformula.g:5560:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0 >= '\u0000' && LA34_0 <= '\t')||(LA34_0 >= '\u000B' && LA34_0 <= '\f')||(LA34_0 >= '\u000E' && LA34_0 <= '\uFFFE')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Hyvalidityformula.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5563:11: ( ( '/*' ( . )* '*/' ) )
            // Hyvalidityformula.g:5564:2: ( '/*' ( . )* '*/' )
            {
            // Hyvalidityformula.g:5564:2: ( '/*' ( . )* '*/' )
            // Hyvalidityformula.g:5564:2: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Hyvalidityformula.g:5564:6: ( . )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0=='*') ) {
                    int LA35_1 = input.LA(2);

                    if ( (LA35_1=='/') ) {
                        alt35=2;
                    }
                    else if ( ((LA35_1 >= '\u0000' && LA35_1 <= '.')||(LA35_1 >= '0' && LA35_1 <= '\uFFFF')) ) {
                        alt35=1;
                    }


                }
                else if ( ((LA35_0 >= '\u0000' && LA35_0 <= ')')||(LA35_0 >= '+' && LA35_0 <= '\uFFFF')) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Hyvalidityformula.g:5564:6: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            match("*/"); 



            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5567:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Hyvalidityformula.g:5568:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Hyvalidityformula.g:5568:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Hyvalidityformula.g:5568:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Hyvalidityformula.g:5568:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='\r') ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1=='\n') ) {
                    alt36=1;
                }
                else {
                    alt36=2;
                }
            }
            else if ( (LA36_0=='\n') ) {
                alt36=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // Hyvalidityformula.g:5568:3: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:5568:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:5568:15: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyvalidityformula.g:5571:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Hyvalidityformula.g:5572:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // Hyvalidityformula.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE )
        int alt37=43;
        alt37 = dfa37.predict(input);
        switch (alt37) {
            case 1 :
                // Hyvalidityformula.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // Hyvalidityformula.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // Hyvalidityformula.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // Hyvalidityformula.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // Hyvalidityformula.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // Hyvalidityformula.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // Hyvalidityformula.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // Hyvalidityformula.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // Hyvalidityformula.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // Hyvalidityformula.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // Hyvalidityformula.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // Hyvalidityformula.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // Hyvalidityformula.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // Hyvalidityformula.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // Hyvalidityformula.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // Hyvalidityformula.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // Hyvalidityformula.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // Hyvalidityformula.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // Hyvalidityformula.g:1:118: T__30
                {
                mT__30(); 


                }
                break;
            case 20 :
                // Hyvalidityformula.g:1:124: T__31
                {
                mT__31(); 


                }
                break;
            case 21 :
                // Hyvalidityformula.g:1:130: T__32
                {
                mT__32(); 


                }
                break;
            case 22 :
                // Hyvalidityformula.g:1:136: T__33
                {
                mT__33(); 


                }
                break;
            case 23 :
                // Hyvalidityformula.g:1:142: T__34
                {
                mT__34(); 


                }
                break;
            case 24 :
                // Hyvalidityformula.g:1:148: T__35
                {
                mT__35(); 


                }
                break;
            case 25 :
                // Hyvalidityformula.g:1:154: T__36
                {
                mT__36(); 


                }
                break;
            case 26 :
                // Hyvalidityformula.g:1:160: T__37
                {
                mT__37(); 


                }
                break;
            case 27 :
                // Hyvalidityformula.g:1:166: T__38
                {
                mT__38(); 


                }
                break;
            case 28 :
                // Hyvalidityformula.g:1:172: T__39
                {
                mT__39(); 


                }
                break;
            case 29 :
                // Hyvalidityformula.g:1:178: T__40
                {
                mT__40(); 


                }
                break;
            case 30 :
                // Hyvalidityformula.g:1:184: T__41
                {
                mT__41(); 


                }
                break;
            case 31 :
                // Hyvalidityformula.g:1:190: T__42
                {
                mT__42(); 


                }
                break;
            case 32 :
                // Hyvalidityformula.g:1:196: T__43
                {
                mT__43(); 


                }
                break;
            case 33 :
                // Hyvalidityformula.g:1:202: T__44
                {
                mT__44(); 


                }
                break;
            case 34 :
                // Hyvalidityformula.g:1:208: T__45
                {
                mT__45(); 


                }
                break;
            case 35 :
                // Hyvalidityformula.g:1:214: T__46
                {
                mT__46(); 


                }
                break;
            case 36 :
                // Hyvalidityformula.g:1:220: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;
            case 37 :
                // Hyvalidityformula.g:1:233: IDENTIFIER_TOKEN
                {
                mIDENTIFIER_TOKEN(); 


                }
                break;
            case 38 :
                // Hyvalidityformula.g:1:250: DATE
                {
                mDATE(); 


                }
                break;
            case 39 :
                // Hyvalidityformula.g:1:255: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 


                }
                break;
            case 40 :
                // Hyvalidityformula.g:1:271: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 41 :
                // Hyvalidityformula.g:1:282: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 42 :
                // Hyvalidityformula.g:1:293: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 43 :
                // Hyvalidityformula.g:1:303: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA37_eotS =
        "\1\uffff\1\42\6\uffff\1\44\1\uffff\1\47\1\uffff\1\52\1\uffff\1\54"+
        "\1\uffff\1\35\4\uffff\6\35\3\uffff\1\67\16\uffff\11\35\2\uffff\17"+
        "\35\2\uffff\1\121\1\uffff\2\35\1\uffff\1\35\1\125\1\35\1\uffff\3"+
        "\35\1\uffff\6\35\1\uffff\1\140\2\35\1\uffff\4\35\2\uffff";
    static final String DFA37_eofS =
        "\147\uffff";
    static final String DFA37_minS =
        "\1\11\1\75\6\uffff\1\60\1\uffff\1\52\1\uffff\1\55\1\uffff\1\75\1"+
        "\uffff\1\156\4\uffff\1\157\1\156\1\141\1\146\1\141\1\162\3\uffff"+
        "\1\57\16\uffff\1\165\1\156\1\165\1\145\1\154\1\120\1\170\1\156\1"+
        "\165\2\uffff\1\155\1\164\1\155\1\162\1\163\1\157\2\50\1\145\1\50"+
        "\1\145\1\72\1\156\1\145\1\163\2\uffff\1\60\1\uffff\1\151\1\170\1"+
        "\uffff\1\151\1\60\1\163\1\uffff\3\164\1\uffff\1\151\1\145\1\72\1"+
        "\171\1\142\1\162\1\uffff\1\60\1\154\1\141\1\uffff\1\145\1\154\2"+
        "\50\2\uffff";
    static final String DFA37_maxS =
        "\1\174\1\75\6\uffff\1\76\1\uffff\1\57\1\uffff\1\75\1\uffff\1\75"+
        "\1\uffff\1\156\4\uffff\1\157\1\164\1\141\1\146\1\151\1\162\3\uffff"+
        "\1\71\16\uffff\1\165\1\156\1\165\1\145\1\154\1\120\1\170\1\156\1"+
        "\165\2\uffff\1\155\1\164\1\155\1\162\1\163\1\157\2\50\1\145\1\114"+
        "\1\145\1\72\1\156\1\145\1\163\2\uffff\1\172\1\uffff\1\151\1\170"+
        "\1\uffff\1\151\1\172\1\163\1\uffff\3\164\1\uffff\1\151\1\145\1\72"+
        "\1\171\1\142\1\162\1\uffff\1\172\1\154\1\141\1\uffff\1\145\1\154"+
        "\2\50\2\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\uffff\1\15\1\uffff"+
        "\1\21\1\uffff\1\24\1\uffff\1\27\1\30\1\31\1\32\6\uffff\1\43\1\44"+
        "\1\45\1\uffff\1\52\1\53\1\2\1\1\1\12\1\11\1\50\1\51\1\14\1\17\1"+
        "\20\1\16\1\23\1\22\11\uffff\1\46\1\47\17\uffff\1\40\1\41\1\uffff"+
        "\1\25\2\uffff\1\34\3\uffff\1\42\3\uffff\1\36\6\uffff\1\33\3\uffff"+
        "\1\35\4\uffff\1\37\1\26";
    static final String DFA37_specialS =
        "\147\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\40\1\37\1\uffff\1\40\1\37\22\uffff\1\40\1\1\1\34\2\uffff"+
            "\1\22\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\36\1"+
            "\13\1\uffff\1\14\1\15\1\16\1\17\1\uffff\4\35\1\20\25\35\1\21"+
            "\1\uffff\1\23\1\24\1\35\1\uffff\2\35\1\25\1\35\1\26\1\27\2\35"+
            "\1\30\3\35\1\31\6\35\1\32\6\35\1\uffff\1\33",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\4\uffff\1\43",
            "",
            "\1\46\4\uffff\1\45",
            "",
            "\1\50\17\uffff\1\51",
            "",
            "\1\53",
            "",
            "\1\55",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57\5\uffff\1\60",
            "\1\61",
            "\1\62",
            "\1\63\7\uffff\1\64",
            "\1\65",
            "",
            "",
            "",
            "\1\66\12\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112\43\uffff\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\122",
            "\1\123",
            "",
            "\1\124",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "\1\141",
            "\1\142",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE );";
        }
    }
 

}