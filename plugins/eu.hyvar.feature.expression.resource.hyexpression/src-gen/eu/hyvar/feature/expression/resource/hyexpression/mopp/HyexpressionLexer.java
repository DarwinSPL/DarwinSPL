// $ANTLR 3.4

	package eu.hyvar.feature.expression.resource.hyexpression.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class HyexpressionLexer extends Lexer {
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

    public HyexpressionLexer() {} 
    public HyexpressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HyexpressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Hyexpression.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:20:7: ( '!' )
            // Hyexpression.g:20:9: '!'
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
            // Hyexpression.g:21:7: ( '!=' )
            // Hyexpression.g:21:9: '!='
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
            // Hyexpression.g:22:7: ( '&&' )
            // Hyexpression.g:22:9: '&&'
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
            // Hyexpression.g:23:7: ( '(' )
            // Hyexpression.g:23:9: '('
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
            // Hyexpression.g:24:7: ( ')' )
            // Hyexpression.g:24:9: ')'
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
            // Hyexpression.g:25:7: ( '*' )
            // Hyexpression.g:25:9: '*'
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
            // Hyexpression.g:26:7: ( '+' )
            // Hyexpression.g:26:9: '+'
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
            // Hyexpression.g:27:7: ( ',' )
            // Hyexpression.g:27:9: ','
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
            // Hyexpression.g:28:7: ( '-' )
            // Hyexpression.g:28:9: '-'
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
            // Hyexpression.g:29:7: ( '->' )
            // Hyexpression.g:29:9: '->'
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
            // Hyexpression.g:30:7: ( '.' )
            // Hyexpression.g:30:9: '.'
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
            // Hyexpression.g:31:7: ( '/' )
            // Hyexpression.g:31:9: '/'
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
            // Hyexpression.g:32:7: ( '<' )
            // Hyexpression.g:32:9: '<'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:33:7: ( '<->' )
            // Hyexpression.g:33:9: '<->'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:34:7: ( '<=' )
            // Hyexpression.g:34:9: '<='
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:35:7: ( '=' )
            // Hyexpression.g:35:9: '='
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:36:7: ( '>' )
            // Hyexpression.g:36:9: '>'
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:37:7: ( '>=' )
            // Hyexpression.g:37:9: '>='
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:38:7: ( '?' )
            // Hyexpression.g:38:9: '?'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:39:7: ( 'Enum(' )
            // Hyexpression.g:39:9: 'Enum('
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:40:7: ( 'EnumLiteral(' )
            // Hyexpression.g:40:9: 'EnumLiteral('
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:41:7: ( '[' )
            // Hyexpression.g:41:9: '['
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:42:7: ( '\\u0025' )
            // Hyexpression.g:42:9: '\\u0025'
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:43:7: ( ']' )
            // Hyexpression.g:43:9: ']'
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:44:7: ( '^' )
            // Hyexpression.g:44:9: '^'
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:45:7: ( 'context:' )
            // Hyexpression.g:45:9: 'context:'
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:46:7: ( 'enum:' )
            // Hyexpression.g:46:9: 'enum:'
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:47:7: ( 'false' )
            // Hyexpression.g:47:9: 'false'
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:48:7: ( 'ifPossible(' )
            // Hyexpression.g:48:9: 'ifPossible('
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:49:7: ( 'max(' )
            // Hyexpression.g:49:9: 'max('
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
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:50:7: ( 'min(' )
            // Hyexpression.g:50:9: 'min('
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:51:7: ( 'null' )
            // Hyexpression.g:51:9: 'null'
            {
            match("null"); 



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
            // Hyexpression.g:52:7: ( 'true' )
            // Hyexpression.g:52:9: 'true'
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
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:53:7: ( '||' )
            // Hyexpression.g:53:9: '||'
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
    // $ANTLR end "T__45"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hyexpression.g:4749:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Hyexpression.g:4750:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Hyexpression.g:4750:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Hyexpression.g:4750:2: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Hyexpression.g:4750:2: ( '\"' )
            // Hyexpression.g:4750:3: '\"'
            {
            match('\"'); 

            }


            // Hyexpression.g:4750:7: (~ ( '\"' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyexpression.g:
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


            // Hyexpression.g:4750:16: ( '\"' )
            // Hyexpression.g:4750:17: '\"'
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
            // Hyexpression.g:4752:17: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? ) )
            // Hyexpression.g:4753:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            {
            // Hyexpression.g:4753:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            // Hyexpression.g:4753:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Hyexpression.g:4753:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Hyexpression.g:
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


            // Hyexpression.g:4753:59: ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='@') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Hyexpression.g:4753:60: '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    {
                    match('@'); 

                    // Hyexpression.g:4753:63: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    // Hyexpression.g:4753:64: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    {
                    // Hyexpression.g:4753:64: ( '-' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Hyexpression.g:4753:65: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyexpression.g:4753:71: ( '0' .. '9' )+
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
                    	    // Hyexpression.g:
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

                    // Hyexpression.g:4753:86: ( '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Hyexpression.g:4753:87: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyexpression.g:4753:93: ( '0' .. '9' )+
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
                    	    // Hyexpression.g:
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

                    // Hyexpression.g:4753:108: ( '-' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Hyexpression.g:4753:109: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyexpression.g:4753:115: ( '0' .. '9' )+
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
                    	    // Hyexpression.g:
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


                    // Hyexpression.g:4753:127: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='T') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Hyexpression.g:4753:129: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            {
                            match('T'); 

                            // Hyexpression.g:4753:132: ( '-' )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0=='-') ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // Hyexpression.g:4753:133: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyexpression.g:4753:139: ( '0' .. '9' )+
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
                            	    // Hyexpression.g:
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

                            // Hyexpression.g:4753:154: ( '-' )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0=='-') ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // Hyexpression.g:4753:155: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyexpression.g:4753:161: ( '0' .. '9' )+
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
                            	    // Hyexpression.g:
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


                            // Hyexpression.g:4753:173: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==':') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // Hyexpression.g:4753:174: ':' ( '-' )? ( '0' .. '9' )+
                                    {
                                    match(':'); 

                                    // Hyexpression.g:4753:178: ( '-' )?
                                    int alt13=2;
                                    int LA13_0 = input.LA(1);

                                    if ( (LA13_0=='-') ) {
                                        alt13=1;
                                    }
                                    switch (alt13) {
                                        case 1 :
                                            // Hyexpression.g:4753:179: '-'
                                            {
                                            match('-'); 

                                            }
                                            break;

                                    }


                                    // Hyexpression.g:4753:185: ( '0' .. '9' )+
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
                                    	    // Hyexpression.g:
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
            // Hyexpression.g:4755:5: ( ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) ) )
            // Hyexpression.g:4756:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            {
            // Hyexpression.g:4756:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            // Hyexpression.g:4756:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            {
            // Hyexpression.g:4756:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            // Hyexpression.g:4756:3: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            {
            // Hyexpression.g:4756:3: ( '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Hyexpression.g:4756:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyexpression.g:4756:10: ( '0' .. '9' )+
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
            	    // Hyexpression.g:
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

            // Hyexpression.g:4756:25: ( '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='-') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Hyexpression.g:4756:26: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyexpression.g:4756:32: ( '0' .. '9' )+
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
            	    // Hyexpression.g:
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

            // Hyexpression.g:4756:47: ( '-' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='-') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Hyexpression.g:4756:48: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyexpression.g:4756:54: ( '0' .. '9' )+
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
            	    // Hyexpression.g:
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


            // Hyexpression.g:4756:66: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='T') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Hyexpression.g:4756:68: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    {
                    match('T'); 

                    // Hyexpression.g:4756:71: ( '-' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='-') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // Hyexpression.g:4756:72: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyexpression.g:4756:78: ( '0' .. '9' )+
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
                    	    // Hyexpression.g:
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

                    // Hyexpression.g:4756:93: ( '-' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='-') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // Hyexpression.g:4756:94: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hyexpression.g:4756:100: ( '0' .. '9' )+
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
                    	    // Hyexpression.g:
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


                    // Hyexpression.g:4756:112: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==':') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // Hyexpression.g:4756:113: ':' ( '-' )? ( '0' .. '9' )+
                            {
                            match(':'); 

                            // Hyexpression.g:4756:117: ( '-' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0=='-') ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // Hyexpression.g:4756:118: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hyexpression.g:4756:124: ( '0' .. '9' )+
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
                            	    // Hyexpression.g:
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
            // Hyexpression.g:4758:16: ( ( ( '-' )? ( '0' .. '9' )+ ) )
            // Hyexpression.g:4759:2: ( ( '-' )? ( '0' .. '9' )+ )
            {
            // Hyexpression.g:4759:2: ( ( '-' )? ( '0' .. '9' )+ )
            // Hyexpression.g:4759:2: ( '-' )? ( '0' .. '9' )+
            {
            // Hyexpression.g:4759:2: ( '-' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='-') ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Hyexpression.g:4759:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hyexpression.g:4759:9: ( '0' .. '9' )+
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
            	    // Hyexpression.g:
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
            // Hyexpression.g:4761:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Hyexpression.g:4762:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Hyexpression.g:4762:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Hyexpression.g:4762:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Hyexpression.g:4762:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0 >= '\u0000' && LA34_0 <= '\t')||(LA34_0 >= '\u000B' && LA34_0 <= '\f')||(LA34_0 >= '\u000E' && LA34_0 <= '\uFFFE')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Hyexpression.g:
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
            // Hyexpression.g:4765:11: ( ( '/*' ( . )* '*/' ) )
            // Hyexpression.g:4766:2: ( '/*' ( . )* '*/' )
            {
            // Hyexpression.g:4766:2: ( '/*' ( . )* '*/' )
            // Hyexpression.g:4766:2: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Hyexpression.g:4766:6: ( . )*
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
            	    // Hyexpression.g:4766:6: .
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
            // Hyexpression.g:4769:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Hyexpression.g:4770:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Hyexpression.g:4770:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Hyexpression.g:4770:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Hyexpression.g:4770:2: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Hyexpression.g:4770:3: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Hyexpression.g:4770:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Hyexpression.g:4770:15: '\\n'
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
            // Hyexpression.g:4773:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Hyexpression.g:4774:2: ( ( ' ' | '\\t' | '\\f' ) )
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
        // Hyexpression.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE )
        int alt37=42;
        alt37 = dfa37.predict(input);
        switch (alt37) {
            case 1 :
                // Hyexpression.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // Hyexpression.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // Hyexpression.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // Hyexpression.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // Hyexpression.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // Hyexpression.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // Hyexpression.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // Hyexpression.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // Hyexpression.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // Hyexpression.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // Hyexpression.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // Hyexpression.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // Hyexpression.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // Hyexpression.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // Hyexpression.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // Hyexpression.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // Hyexpression.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // Hyexpression.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // Hyexpression.g:1:118: T__30
                {
                mT__30(); 


                }
                break;
            case 20 :
                // Hyexpression.g:1:124: T__31
                {
                mT__31(); 


                }
                break;
            case 21 :
                // Hyexpression.g:1:130: T__32
                {
                mT__32(); 


                }
                break;
            case 22 :
                // Hyexpression.g:1:136: T__33
                {
                mT__33(); 


                }
                break;
            case 23 :
                // Hyexpression.g:1:142: T__34
                {
                mT__34(); 


                }
                break;
            case 24 :
                // Hyexpression.g:1:148: T__35
                {
                mT__35(); 


                }
                break;
            case 25 :
                // Hyexpression.g:1:154: T__36
                {
                mT__36(); 


                }
                break;
            case 26 :
                // Hyexpression.g:1:160: T__37
                {
                mT__37(); 


                }
                break;
            case 27 :
                // Hyexpression.g:1:166: T__38
                {
                mT__38(); 


                }
                break;
            case 28 :
                // Hyexpression.g:1:172: T__39
                {
                mT__39(); 


                }
                break;
            case 29 :
                // Hyexpression.g:1:178: T__40
                {
                mT__40(); 


                }
                break;
            case 30 :
                // Hyexpression.g:1:184: T__41
                {
                mT__41(); 


                }
                break;
            case 31 :
                // Hyexpression.g:1:190: T__42
                {
                mT__42(); 


                }
                break;
            case 32 :
                // Hyexpression.g:1:196: T__43
                {
                mT__43(); 


                }
                break;
            case 33 :
                // Hyexpression.g:1:202: T__44
                {
                mT__44(); 


                }
                break;
            case 34 :
                // Hyexpression.g:1:208: T__45
                {
                mT__45(); 


                }
                break;
            case 35 :
                // Hyexpression.g:1:214: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;
            case 36 :
                // Hyexpression.g:1:227: IDENTIFIER_TOKEN
                {
                mIDENTIFIER_TOKEN(); 


                }
                break;
            case 37 :
                // Hyexpression.g:1:244: DATE
                {
                mDATE(); 


                }
                break;
            case 38 :
                // Hyexpression.g:1:249: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 


                }
                break;
            case 39 :
                // Hyexpression.g:1:265: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 40 :
                // Hyexpression.g:1:276: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 41 :
                // Hyexpression.g:1:287: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 42 :
                // Hyexpression.g:1:297: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA37_eotS =
        "\1\uffff\1\42\6\uffff\1\44\1\uffff\1\47\1\52\1\uffff\1\54\1\uffff"+
        "\1\35\4\uffff\7\35\3\uffff\1\67\16\uffff\11\35\2\uffff\16\35\2\uffff"+
        "\1\120\1\121\1\uffff\2\35\1\uffff\1\124\1\35\2\uffff\2\35\1\uffff"+
        "\5\35\1\uffff\6\35\2\uffff";
    static final String DFA37_eofS =
        "\143\uffff";
    static final String DFA37_minS =
        "\1\11\1\75\6\uffff\1\60\1\uffff\1\52\1\55\1\uffff\1\75\1\uffff\1"+
        "\156\4\uffff\1\157\1\156\1\141\1\146\1\141\1\165\1\162\3\uffff\1"+
        "\57\16\uffff\1\165\1\156\1\165\1\154\1\120\1\170\1\156\1\154\1\165"+
        "\2\uffff\1\155\1\164\1\155\1\163\1\157\2\50\1\154\1\145\1\50\1\145"+
        "\1\72\1\145\1\163\2\uffff\2\60\1\uffff\1\151\1\170\1\uffff\1\60"+
        "\1\163\2\uffff\2\164\1\uffff\1\151\1\145\1\72\1\142\1\162\1\uffff"+
        "\1\154\1\141\1\145\1\154\2\50\2\uffff";
    static final String DFA37_maxS =
        "\1\174\1\75\6\uffff\1\76\1\uffff\1\57\1\75\1\uffff\1\75\1\uffff"+
        "\1\156\4\uffff\1\157\1\156\1\141\1\146\1\151\1\165\1\162\3\uffff"+
        "\1\71\16\uffff\1\165\1\156\1\165\1\154\1\120\1\170\1\156\1\154\1"+
        "\165\2\uffff\1\155\1\164\1\155\1\163\1\157\2\50\1\154\1\145\1\114"+
        "\1\145\1\72\1\145\1\163\2\uffff\2\172\1\uffff\1\151\1\170\1\uffff"+
        "\1\172\1\163\2\uffff\2\164\1\uffff\1\151\1\145\1\72\1\142\1\162"+
        "\1\uffff\1\154\1\141\1\145\1\154\2\50\2\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\20\1\uffff"+
        "\1\23\1\uffff\1\26\1\27\1\30\1\31\7\uffff\1\42\1\43\1\44\1\uffff"+
        "\1\51\1\52\1\2\1\1\1\12\1\11\1\47\1\50\1\14\1\16\1\17\1\15\1\22"+
        "\1\21\11\uffff\1\45\1\46\16\uffff\1\36\1\37\2\uffff\1\24\2\uffff"+
        "\1\33\2\uffff\1\40\1\41\2\uffff\1\34\5\uffff\1\32\6\uffff\1\35\1"+
        "\25";
    static final String DFA37_specialS =
        "\143\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\40\1\37\1\uffff\1\40\1\37\22\uffff\1\40\1\1\1\34\2\uffff"+
            "\1\21\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\36\2"+
            "\uffff\1\13\1\14\1\15\1\16\1\uffff\4\35\1\17\25\35\1\20\1\uffff"+
            "\1\22\1\23\1\35\1\uffff\2\35\1\24\1\35\1\25\1\26\2\35\1\27\3"+
            "\35\1\30\1\31\5\35\1\32\6\35\1\uffff\1\33",
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
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\7\uffff\1\63",
            "\1\64",
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
            "",
            "",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\122",
            "\1\123",
            "",
            "\12\35\6\uffff\33\35\4\uffff\1\35\1\uffff\32\35",
            "\1\125",
            "",
            "",
            "\1\126",
            "\1\127",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE );";
        }
    }
 

}