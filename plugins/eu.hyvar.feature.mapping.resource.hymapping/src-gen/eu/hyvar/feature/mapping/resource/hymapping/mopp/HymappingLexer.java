// $ANTLR 3.4

	package eu.hyvar.feature.mapping.resource.hymapping.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class HymappingLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int QUOTED_6060_6262=10;
    public static final int SL_COMMENT=11;
    public static final int WHITESPACE=12;

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

    public HymappingLexer() {} 
    public HymappingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HymappingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Hymapping.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:20:7: ( '!' )
            // Hymapping.g:20:9: '!'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:21:7: ( '!=' )
            // Hymapping.g:21:9: '!='
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:22:7: ( '&&' )
            // Hymapping.g:22:9: '&&'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:23:7: ( '(' )
            // Hymapping.g:23:9: '('
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:24:7: ( ')' )
            // Hymapping.g:24:9: ')'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:25:7: ( '*' )
            // Hymapping.g:25:9: '*'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:26:7: ( '+' )
            // Hymapping.g:26:9: '+'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:27:7: ( ',' )
            // Hymapping.g:27:9: ','
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:28:7: ( '-' )
            // Hymapping.g:28:9: '-'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:29:7: ( '->' )
            // Hymapping.g:29:9: '->'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:30:7: ( '.' )
            // Hymapping.g:30:9: '.'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:31:7: ( '/' )
            // Hymapping.g:31:9: '/'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:32:7: ( ':' )
            // Hymapping.g:32:9: ':'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:33:7: ( '<' )
            // Hymapping.g:33:9: '<'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:34:7: ( '<->' )
            // Hymapping.g:34:9: '<->'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:35:7: ( '<=' )
            // Hymapping.g:35:9: '<='
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:36:7: ( '=' )
            // Hymapping.g:36:9: '='
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:37:7: ( '>' )
            // Hymapping.g:37:9: '>'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:38:7: ( '>=' )
            // Hymapping.g:38:9: '>='
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:39:7: ( '?' )
            // Hymapping.g:39:9: '?'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:40:7: ( 'Enum(' )
            // Hymapping.g:40:9: 'Enum('
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:41:7: ( 'EnumLiteral(' )
            // Hymapping.g:41:9: 'EnumLiteral('
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:42:7: ( '[' )
            // Hymapping.g:42:9: '['
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:43:7: ( '\\u0025' )
            // Hymapping.g:43:9: '\\u0025'
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:44:7: ( ']' )
            // Hymapping.g:44:9: ']'
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:45:7: ( '^' )
            // Hymapping.g:45:9: '^'
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:46:7: ( 'enum:' )
            // Hymapping.g:46:9: 'enum:'
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
            // Hymapping.g:47:7: ( 'eternity' )
            // Hymapping.g:47:9: 'eternity'
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
            // Hymapping.g:48:7: ( 'false' )
            // Hymapping.g:48:9: 'false'
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
            // Hymapping.g:49:7: ( 'true' )
            // Hymapping.g:49:9: 'true'
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:50:7: ( '{' )
            // Hymapping.g:50:9: '{'
            {
            match('{'); 

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
            // Hymapping.g:51:7: ( '||' )
            // Hymapping.g:51:9: '||'
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
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:52:7: ( '}' )
            // Hymapping.g:52:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "QUOTED_6060_6262"
    public final void mQUOTED_6060_6262() throws RecognitionException {
        try {
            int _type = QUOTED_6060_6262;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:4218:17: ( ( ( '<<' ) (~ ( '>' ) | '>' ~ ( '>' ) )* ( '>>' ) ) )
            // Hymapping.g:4219:2: ( ( '<<' ) (~ ( '>' ) | '>' ~ ( '>' ) )* ( '>>' ) )
            {
            // Hymapping.g:4219:2: ( ( '<<' ) (~ ( '>' ) | '>' ~ ( '>' ) )* ( '>>' ) )
            // Hymapping.g:4219:2: ( '<<' ) (~ ( '>' ) | '>' ~ ( '>' ) )* ( '>>' )
            {
            // Hymapping.g:4219:2: ( '<<' )
            // Hymapping.g:4219:3: '<<'
            {
            match("<<"); 



            }


            // Hymapping.g:4219:8: (~ ( '>' ) | '>' ~ ( '>' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='>') ) {
                    int LA1_1 = input.LA(2);

                    if ( ((LA1_1 >= '\u0000' && LA1_1 <= '=')||(LA1_1 >= '?' && LA1_1 <= '\uFFFF')) ) {
                        alt1=2;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '=')||(LA1_0 >= '?' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hymapping.g:4219:9: ~ ( '>' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // Hymapping.g:4219:16: '>' ~ ( '>' )
            	    {
            	    match('>'); 

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
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


            // Hymapping.g:4219:27: ( '>>' )
            // Hymapping.g:4219:28: '>>'
            {
            match(">>"); 



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
    // $ANTLR end "QUOTED_6060_6262"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hymapping.g:4221:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Hymapping.g:4222:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Hymapping.g:4222:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Hymapping.g:4222:2: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Hymapping.g:4222:2: ( '\"' )
            // Hymapping.g:4222:3: '\"'
            {
            match('\"'); 

            }


            // Hymapping.g:4222:7: (~ ( '\"' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Hymapping.g:
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
            	    break loop2;
                }
            } while (true);


            // Hymapping.g:4222:16: ( '\"' )
            // Hymapping.g:4222:17: '\"'
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
            // Hymapping.g:4224:17: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? ) )
            // Hymapping.g:4225:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            {
            // Hymapping.g:4225:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            // Hymapping.g:4225:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Hymapping.g:4225:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Hymapping.g:
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
            	    break loop3;
                }
            } while (true);


            // Hymapping.g:4225:59: ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='@') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Hymapping.g:4225:60: '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    {
                    match('@'); 

                    // Hymapping.g:4225:63: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    // Hymapping.g:4225:64: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    {
                    // Hymapping.g:4225:64: ( '-' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='-') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Hymapping.g:4225:65: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hymapping.g:4225:71: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Hymapping.g:
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
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    match('/'); 

                    // Hymapping.g:4225:86: ( '-' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // Hymapping.g:4225:87: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hymapping.g:4225:93: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Hymapping.g:
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
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    match('/'); 

                    // Hymapping.g:4225:108: ( '-' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='-') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // Hymapping.g:4225:109: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hymapping.g:4225:115: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Hymapping.g:
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
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    // Hymapping.g:4225:127: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='T') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // Hymapping.g:4225:129: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            {
                            match('T'); 

                            // Hymapping.g:4225:132: ( '-' )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='-') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // Hymapping.g:4225:133: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hymapping.g:4225:139: ( '0' .. '9' )+
                            int cnt11=0;
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // Hymapping.g:
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
                            	    if ( cnt11 >= 1 ) break loop11;
                                        EarlyExitException eee =
                                            new EarlyExitException(11, input);
                                        throw eee;
                                }
                                cnt11++;
                            } while (true);


                            match(':'); 

                            // Hymapping.g:4225:154: ( '-' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='-') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // Hymapping.g:4225:155: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hymapping.g:4225:161: ( '0' .. '9' )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // Hymapping.g:
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
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            // Hymapping.g:4225:173: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==':') ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // Hymapping.g:4225:174: ':' ( '-' )? ( '0' .. '9' )+
                                    {
                                    match(':'); 

                                    // Hymapping.g:4225:178: ( '-' )?
                                    int alt14=2;
                                    int LA14_0 = input.LA(1);

                                    if ( (LA14_0=='-') ) {
                                        alt14=1;
                                    }
                                    switch (alt14) {
                                        case 1 :
                                            // Hymapping.g:4225:179: '-'
                                            {
                                            match('-'); 

                                            }
                                            break;

                                    }


                                    // Hymapping.g:4225:185: ( '0' .. '9' )+
                                    int cnt15=0;
                                    loop15:
                                    do {
                                        int alt15=2;
                                        int LA15_0 = input.LA(1);

                                        if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
                                            alt15=1;
                                        }


                                        switch (alt15) {
                                    	case 1 :
                                    	    // Hymapping.g:
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
                                    	    if ( cnt15 >= 1 ) break loop15;
                                                EarlyExitException eee =
                                                    new EarlyExitException(15, input);
                                                throw eee;
                                        }
                                        cnt15++;
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
            // Hymapping.g:4227:5: ( ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) ) )
            // Hymapping.g:4228:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            {
            // Hymapping.g:4228:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            // Hymapping.g:4228:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            {
            // Hymapping.g:4228:2: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            // Hymapping.g:4228:3: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            {
            // Hymapping.g:4228:3: ( '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Hymapping.g:4228:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hymapping.g:4228:10: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Hymapping.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            match('/'); 

            // Hymapping.g:4228:25: ( '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='-') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Hymapping.g:4228:26: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hymapping.g:4228:32: ( '0' .. '9' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= '0' && LA22_0 <= '9')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Hymapping.g:
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
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            match('/'); 

            // Hymapping.g:4228:47: ( '-' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='-') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Hymapping.g:4228:48: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hymapping.g:4228:54: ( '0' .. '9' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= '0' && LA24_0 <= '9')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Hymapping.g:
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            // Hymapping.g:4228:66: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='T') ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Hymapping.g:4228:68: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    {
                    match('T'); 

                    // Hymapping.g:4228:71: ( '-' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='-') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // Hymapping.g:4228:72: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hymapping.g:4228:78: ( '0' .. '9' )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // Hymapping.g:
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
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    match(':'); 

                    // Hymapping.g:4228:93: ( '-' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0=='-') ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // Hymapping.g:4228:94: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hymapping.g:4228:100: ( '0' .. '9' )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0 >= '0' && LA28_0 <= '9')) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Hymapping.g:
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
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    // Hymapping.g:4228:112: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==':') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // Hymapping.g:4228:113: ':' ( '-' )? ( '0' .. '9' )+
                            {
                            match(':'); 

                            // Hymapping.g:4228:117: ( '-' )?
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0=='-') ) {
                                alt29=1;
                            }
                            switch (alt29) {
                                case 1 :
                                    // Hymapping.g:4228:118: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hymapping.g:4228:124: ( '0' .. '9' )+
                            int cnt30=0;
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( ((LA30_0 >= '0' && LA30_0 <= '9')) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // Hymapping.g:
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
                            	    if ( cnt30 >= 1 ) break loop30;
                                        EarlyExitException eee =
                                            new EarlyExitException(30, input);
                                        throw eee;
                                }
                                cnt30++;
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
            // Hymapping.g:4230:16: ( ( ( '-' )? ( '0' .. '9' )+ ) )
            // Hymapping.g:4231:2: ( ( '-' )? ( '0' .. '9' )+ )
            {
            // Hymapping.g:4231:2: ( ( '-' )? ( '0' .. '9' )+ )
            // Hymapping.g:4231:2: ( '-' )? ( '0' .. '9' )+
            {
            // Hymapping.g:4231:2: ( '-' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='-') ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Hymapping.g:4231:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hymapping.g:4231:9: ( '0' .. '9' )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0 >= '0' && LA34_0 <= '9')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Hymapping.g:
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
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
            // Hymapping.g:4233:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Hymapping.g:4234:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Hymapping.g:4234:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Hymapping.g:4234:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Hymapping.g:4234:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0 >= '\u0000' && LA35_0 <= '\t')||(LA35_0 >= '\u000B' && LA35_0 <= '\f')||(LA35_0 >= '\u000E' && LA35_0 <= '\uFFFE')) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Hymapping.g:
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
            	    break loop35;
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
            // Hymapping.g:4237:11: ( ( '/*' ( . )* '*/' ) )
            // Hymapping.g:4238:2: ( '/*' ( . )* '*/' )
            {
            // Hymapping.g:4238:2: ( '/*' ( . )* '*/' )
            // Hymapping.g:4238:2: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Hymapping.g:4238:6: ( . )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0=='*') ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1=='/') ) {
                        alt36=2;
                    }
                    else if ( ((LA36_1 >= '\u0000' && LA36_1 <= '.')||(LA36_1 >= '0' && LA36_1 <= '\uFFFF')) ) {
                        alt36=1;
                    }


                }
                else if ( ((LA36_0 >= '\u0000' && LA36_0 <= ')')||(LA36_0 >= '+' && LA36_0 <= '\uFFFF')) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Hymapping.g:4238:6: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop36;
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
            // Hymapping.g:4241:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Hymapping.g:4242:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Hymapping.g:4242:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Hymapping.g:4242:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Hymapping.g:4242:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0=='\r') ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1=='\n') ) {
                    alt37=1;
                }
                else {
                    alt37=2;
                }
            }
            else if ( (LA37_0=='\n') ) {
                alt37=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // Hymapping.g:4242:3: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Hymapping.g:4242:10: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Hymapping.g:4242:15: '\\n'
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
            // Hymapping.g:4245:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Hymapping.g:4246:2: ( ( ' ' | '\\t' | '\\f' ) )
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
        // Hymapping.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | QUOTED_6060_6262 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE )
        int alt38=42;
        alt38 = dfa38.predict(input);
        switch (alt38) {
            case 1 :
                // Hymapping.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // Hymapping.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // Hymapping.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // Hymapping.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // Hymapping.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // Hymapping.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // Hymapping.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // Hymapping.g:1:52: T__20
                {
                mT__20(); 


                }
                break;
            case 9 :
                // Hymapping.g:1:58: T__21
                {
                mT__21(); 


                }
                break;
            case 10 :
                // Hymapping.g:1:64: T__22
                {
                mT__22(); 


                }
                break;
            case 11 :
                // Hymapping.g:1:70: T__23
                {
                mT__23(); 


                }
                break;
            case 12 :
                // Hymapping.g:1:76: T__24
                {
                mT__24(); 


                }
                break;
            case 13 :
                // Hymapping.g:1:82: T__25
                {
                mT__25(); 


                }
                break;
            case 14 :
                // Hymapping.g:1:88: T__26
                {
                mT__26(); 


                }
                break;
            case 15 :
                // Hymapping.g:1:94: T__27
                {
                mT__27(); 


                }
                break;
            case 16 :
                // Hymapping.g:1:100: T__28
                {
                mT__28(); 


                }
                break;
            case 17 :
                // Hymapping.g:1:106: T__29
                {
                mT__29(); 


                }
                break;
            case 18 :
                // Hymapping.g:1:112: T__30
                {
                mT__30(); 


                }
                break;
            case 19 :
                // Hymapping.g:1:118: T__31
                {
                mT__31(); 


                }
                break;
            case 20 :
                // Hymapping.g:1:124: T__32
                {
                mT__32(); 


                }
                break;
            case 21 :
                // Hymapping.g:1:130: T__33
                {
                mT__33(); 


                }
                break;
            case 22 :
                // Hymapping.g:1:136: T__34
                {
                mT__34(); 


                }
                break;
            case 23 :
                // Hymapping.g:1:142: T__35
                {
                mT__35(); 


                }
                break;
            case 24 :
                // Hymapping.g:1:148: T__36
                {
                mT__36(); 


                }
                break;
            case 25 :
                // Hymapping.g:1:154: T__37
                {
                mT__37(); 


                }
                break;
            case 26 :
                // Hymapping.g:1:160: T__38
                {
                mT__38(); 


                }
                break;
            case 27 :
                // Hymapping.g:1:166: T__39
                {
                mT__39(); 


                }
                break;
            case 28 :
                // Hymapping.g:1:172: T__40
                {
                mT__40(); 


                }
                break;
            case 29 :
                // Hymapping.g:1:178: T__41
                {
                mT__41(); 


                }
                break;
            case 30 :
                // Hymapping.g:1:184: T__42
                {
                mT__42(); 


                }
                break;
            case 31 :
                // Hymapping.g:1:190: T__43
                {
                mT__43(); 


                }
                break;
            case 32 :
                // Hymapping.g:1:196: T__44
                {
                mT__44(); 


                }
                break;
            case 33 :
                // Hymapping.g:1:202: T__45
                {
                mT__45(); 


                }
                break;
            case 34 :
                // Hymapping.g:1:208: QUOTED_6060_6262
                {
                mQUOTED_6060_6262(); 


                }
                break;
            case 35 :
                // Hymapping.g:1:225: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;
            case 36 :
                // Hymapping.g:1:238: IDENTIFIER_TOKEN
                {
                mIDENTIFIER_TOKEN(); 


                }
                break;
            case 37 :
                // Hymapping.g:1:255: DATE
                {
                mDATE(); 


                }
                break;
            case 38 :
                // Hymapping.g:1:260: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 


                }
                break;
            case 39 :
                // Hymapping.g:1:276: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 40 :
                // Hymapping.g:1:287: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 41 :
                // Hymapping.g:1:298: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 42 :
                // Hymapping.g:1:308: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\1\uffff\1\41\6\uffff\1\43\1\uffff\1\46\1\uffff\1\52\1\uffff\1\54"+
        "\1\uffff\1\34\4\uffff\3\34\5\uffff\1\63\17\uffff\5\34\2\uffff\11"+
        "\34\1\103\1\uffff\1\34\1\uffff\1\34\1\106\1\uffff\2\34\1\uffff\3"+
        "\34\1\114\1\34\1\uffff\2\34\1\uffff";
    static final String DFA38_eofS =
        "\120\uffff";
    static final String DFA38_minS =
        "\1\11\1\75\6\uffff\1\60\1\uffff\1\52\1\uffff\1\55\1\uffff\1\75\1"+
        "\uffff\1\156\4\uffff\1\156\1\141\1\162\5\uffff\1\57\17\uffff\2\165"+
        "\1\145\1\154\1\165\2\uffff\2\155\1\162\1\163\1\145\1\50\1\72\1\156"+
        "\1\145\1\60\1\uffff\1\151\1\uffff\1\151\1\60\1\uffff\2\164\1\uffff"+
        "\1\145\1\171\1\162\1\60\1\141\1\uffff\1\154\1\50\1\uffff";
    static final String DFA38_maxS =
        "\1\175\1\75\6\uffff\1\76\1\uffff\1\57\1\uffff\1\75\1\uffff\1\75"+
        "\1\uffff\1\156\4\uffff\1\164\1\141\1\162\5\uffff\1\71\17\uffff\2"+
        "\165\1\145\1\154\1\165\2\uffff\2\155\1\162\1\163\1\145\1\114\1\72"+
        "\1\156\1\145\1\172\1\uffff\1\151\1\uffff\1\151\1\172\1\uffff\2\164"+
        "\1\uffff\1\145\1\171\1\162\1\172\1\141\1\uffff\1\154\1\50\1\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\uffff\1\15\1\uffff"+
        "\1\21\1\uffff\1\24\1\uffff\1\27\1\30\1\31\1\32\3\uffff\1\37\1\40"+
        "\1\41\1\43\1\44\1\uffff\1\51\1\52\1\2\1\1\1\12\1\11\1\47\1\50\1"+
        "\14\1\17\1\20\1\42\1\16\1\23\1\22\5\uffff\1\45\1\46\12\uffff\1\25"+
        "\1\uffff\1\33\2\uffff\1\36\2\uffff\1\35\5\uffff\1\34\2\uffff\1\26";
    static final String DFA38_specialS =
        "\120\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\37\1\36\1\uffff\1\37\1\36\22\uffff\1\37\1\1\1\33\2\uffff"+
            "\1\22\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\35\1"+
            "\13\1\uffff\1\14\1\15\1\16\1\17\1\uffff\4\34\1\20\25\34\1\21"+
            "\1\uffff\1\23\1\24\1\34\1\uffff\4\34\1\25\1\26\15\34\1\27\6"+
            "\34\1\30\1\31\1\32",
            "\1\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\35\4\uffff\1\42",
            "",
            "\1\45\4\uffff\1\44",
            "",
            "\1\47\16\uffff\1\51\1\50",
            "",
            "\1\53",
            "",
            "\1\55",
            "",
            "",
            "",
            "",
            "\1\56\5\uffff\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "",
            "",
            "",
            "\1\62\12\35",
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
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76\43\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\34\6\uffff\33\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\104",
            "",
            "\1\105",
            "\12\34\6\uffff\33\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\107",
            "\1\110",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\34\6\uffff\33\34\4\uffff\1\34\1\uffff\32\34",
            "\1\115",
            "",
            "\1\116",
            "\1\117",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | QUOTED_6060_6262 | QUOTED_34_34 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE );";
        }
    }
 

}