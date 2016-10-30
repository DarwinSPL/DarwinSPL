// $ANTLR 3.4

	package eu.hyvar.dataValues.resource.hydatavalue.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class HydatavalueLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
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
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

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

    public HydatavalueLexer() {} 
    public HydatavalueLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HydatavalueLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Hydatavalue.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:20:7: ( ')' )
            // Hydatavalue.g:20:9: ')'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:21:7: ( ',' )
            // Hydatavalue.g:21:9: ','
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:22:7: ( '-' )
            // Hydatavalue.g:22:9: '-'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:23:7: ( '.' )
            // Hydatavalue.g:23:9: '.'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:24:7: ( 'Enum(' )
            // Hydatavalue.g:24:9: 'Enum('
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:25:7: ( 'EnumLiteral(' )
            // Hydatavalue.g:25:9: 'EnumLiteral('
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:26:7: ( '[' )
            // Hydatavalue.g:26:9: '['
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:27:7: ( ']' )
            // Hydatavalue.g:27:9: ']'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:28:7: ( 'enum:' )
            // Hydatavalue.g:28:9: 'enum:'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:29:7: ( 'false' )
            // Hydatavalue.g:29:9: 'false'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:30:7: ( 'null' )
            // Hydatavalue.g:30:9: 'null'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:31:7: ( 'true' )
            // Hydatavalue.g:31:9: 'true'
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
    // $ANTLR end "T__22"

    // $ANTLR start "IDENTIFIER_TOKEN"
    public final void mIDENTIFIER_TOKEN() throws RecognitionException {
        try {
            int _type = IDENTIFIER_TOKEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Hydatavalue.g:1533:17: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? ) )
            // Hydatavalue.g:1534:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            {
            // Hydatavalue.g:1534:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )? )
            // Hydatavalue.g:1534:3: ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Hydatavalue.g:1534:26: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hydatavalue.g:
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
            	    break loop1;
                }
            } while (true);


            // Hydatavalue.g:1534:60: ( '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='@') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Hydatavalue.g:1534:61: '@' ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    {
                    match('@'); 

                    // Hydatavalue.g:1534:64: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
                    // Hydatavalue.g:1534:65: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    {
                    // Hydatavalue.g:1534:65: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Hydatavalue.g:1534:66: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hydatavalue.g:1534:72: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Hydatavalue.g:
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
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    match('/'); 

                    // Hydatavalue.g:1534:87: ( '-' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='-') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Hydatavalue.g:1534:88: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hydatavalue.g:1534:94: ( '0' .. '9' )+
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
                    	    // Hydatavalue.g:
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

                    // Hydatavalue.g:1534:109: ( '-' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // Hydatavalue.g:1534:110: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hydatavalue.g:1534:116: ( '0' .. '9' )+
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
                    	    // Hydatavalue.g:
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


                    // Hydatavalue.g:1534:128: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='T') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Hydatavalue.g:1534:130: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            {
                            match('T'); 

                            // Hydatavalue.g:1534:133: ( '-' )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0=='-') ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // Hydatavalue.g:1534:134: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hydatavalue.g:1534:140: ( '0' .. '9' )+
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
                            	    // Hydatavalue.g:
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


                            match(':'); 

                            // Hydatavalue.g:1534:155: ( '-' )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='-') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // Hydatavalue.g:1534:156: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hydatavalue.g:1534:162: ( '0' .. '9' )+
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
                            	    // Hydatavalue.g:
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


                            // Hydatavalue.g:1534:174: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( (LA14_0==':') ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // Hydatavalue.g:1534:175: ':' ( '-' )? ( '0' .. '9' )+
                                    {
                                    match(':'); 

                                    // Hydatavalue.g:1534:179: ( '-' )?
                                    int alt12=2;
                                    int LA12_0 = input.LA(1);

                                    if ( (LA12_0=='-') ) {
                                        alt12=1;
                                    }
                                    switch (alt12) {
                                        case 1 :
                                            // Hydatavalue.g:1534:180: '-'
                                            {
                                            match('-'); 

                                            }
                                            break;

                                    }


                                    // Hydatavalue.g:1534:186: ( '0' .. '9' )+
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
                                    	    // Hydatavalue.g:
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
            // Hydatavalue.g:1536:5: ( ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) ) )
            // Hydatavalue.g:1537:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            {
            // Hydatavalue.g:1537:2: ( ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? ) )
            // Hydatavalue.g:1537:3: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            {
            // Hydatavalue.g:1537:3: ( ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )? )
            // Hydatavalue.g:1537:4: ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ '/' ( '-' )? ( '0' .. '9' )+ ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            {
            // Hydatavalue.g:1537:4: ( '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Hydatavalue.g:1537:5: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hydatavalue.g:1537:11: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Hydatavalue.g:
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            match('/'); 

            // Hydatavalue.g:1537:26: ( '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Hydatavalue.g:1537:27: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hydatavalue.g:1537:33: ( '0' .. '9' )+
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
            	    // Hydatavalue.g:
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

            // Hydatavalue.g:1537:48: ( '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='-') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Hydatavalue.g:1537:49: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hydatavalue.g:1537:55: ( '0' .. '9' )+
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
            	    // Hydatavalue.g:
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


            // Hydatavalue.g:1537:67: ( 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0=='T') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Hydatavalue.g:1537:69: 'T' ( '-' )? ( '0' .. '9' )+ ':' ( '-' )? ( '0' .. '9' )+ ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    {
                    match('T'); 

                    // Hydatavalue.g:1537:72: ( '-' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='-') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // Hydatavalue.g:1537:73: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hydatavalue.g:1537:79: ( '0' .. '9' )+
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
                    	    // Hydatavalue.g:
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


                    match(':'); 

                    // Hydatavalue.g:1537:94: ( '-' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='-') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // Hydatavalue.g:1537:95: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // Hydatavalue.g:1537:101: ( '0' .. '9' )+
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
                    	    // Hydatavalue.g:
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


                    // Hydatavalue.g:1537:113: ( ':' ( '-' )? ( '0' .. '9' )+ )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==':') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // Hydatavalue.g:1537:114: ':' ( '-' )? ( '0' .. '9' )+
                            {
                            match(':'); 

                            // Hydatavalue.g:1537:118: ( '-' )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0=='-') ) {
                                alt27=1;
                            }
                            switch (alt27) {
                                case 1 :
                                    // Hydatavalue.g:1537:119: '-'
                                    {
                                    match('-'); 

                                    }
                                    break;

                            }


                            // Hydatavalue.g:1537:125: ( '0' .. '9' )+
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
                            	    // Hydatavalue.g:
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
            // Hydatavalue.g:1539:16: ( ( ( '-' )? ( '0' .. '9' )+ ) )
            // Hydatavalue.g:1540:2: ( ( '-' )? ( '0' .. '9' )+ )
            {
            // Hydatavalue.g:1540:2: ( ( '-' )? ( '0' .. '9' )+ )
            // Hydatavalue.g:1540:3: ( '-' )? ( '0' .. '9' )+
            {
            // Hydatavalue.g:1540:3: ( '-' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='-') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Hydatavalue.g:1540:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Hydatavalue.g:1540:10: ( '0' .. '9' )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= '0' && LA32_0 <= '9')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Hydatavalue.g:
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
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
            // Hydatavalue.g:1542:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Hydatavalue.g:1543:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Hydatavalue.g:1543:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Hydatavalue.g:1543:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Hydatavalue.g:1543:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0 >= '\u0000' && LA33_0 <= '\t')||(LA33_0 >= '\u000B' && LA33_0 <= '\f')||(LA33_0 >= '\u000E' && LA33_0 <= '\uFFFE')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Hydatavalue.g:
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
            	    break loop33;
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
            // Hydatavalue.g:1546:11: ( ( '/*' ( . )* '*/' ) )
            // Hydatavalue.g:1547:2: ( '/*' ( . )* '*/' )
            {
            // Hydatavalue.g:1547:2: ( '/*' ( . )* '*/' )
            // Hydatavalue.g:1547:3: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Hydatavalue.g:1547:7: ( . )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0=='*') ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1=='/') ) {
                        alt34=2;
                    }
                    else if ( ((LA34_1 >= '\u0000' && LA34_1 <= '.')||(LA34_1 >= '0' && LA34_1 <= '\uFFFF')) ) {
                        alt34=1;
                    }


                }
                else if ( ((LA34_0 >= '\u0000' && LA34_0 <= ')')||(LA34_0 >= '+' && LA34_0 <= '\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Hydatavalue.g:1547:7: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop34;
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
            // Hydatavalue.g:1550:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Hydatavalue.g:1551:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Hydatavalue.g:1551:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Hydatavalue.g:1551:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Hydatavalue.g:1551:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0=='\r') ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1=='\n') ) {
                    alt35=1;
                }
                else {
                    alt35=2;
                }
            }
            else if ( (LA35_0=='\n') ) {
                alt35=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // Hydatavalue.g:1551:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Hydatavalue.g:1551:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Hydatavalue.g:1551:16: '\\n'
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
            // Hydatavalue.g:1554:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Hydatavalue.g:1555:2: ( ( ' ' | '\\t' | '\\f' ) )
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
        // Hydatavalue.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE )
        int alt36=19;
        alt36 = dfa36.predict(input);
        switch (alt36) {
            case 1 :
                // Hydatavalue.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Hydatavalue.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Hydatavalue.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Hydatavalue.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Hydatavalue.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Hydatavalue.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Hydatavalue.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Hydatavalue.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Hydatavalue.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Hydatavalue.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Hydatavalue.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Hydatavalue.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // Hydatavalue.g:1:82: IDENTIFIER_TOKEN
                {
                mIDENTIFIER_TOKEN(); 


                }
                break;
            case 14 :
                // Hydatavalue.g:1:99: DATE
                {
                mDATE(); 


                }
                break;
            case 15 :
                // Hydatavalue.g:1:104: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 


                }
                break;
            case 16 :
                // Hydatavalue.g:1:120: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 17 :
                // Hydatavalue.g:1:131: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 18 :
                // Hydatavalue.g:1:142: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 19 :
                // Hydatavalue.g:1:152: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA36_eotS =
        "\3\uffff\1\21\1\uffff\1\14\2\uffff\4\14\1\uffff\1\30\4\uffff\5\14"+
        "\4\uffff\10\14\1\51\1\52\1\uffff\1\14\1\uffff\1\54\2\uffff\1\14"+
        "\1\uffff\5\14\1\uffff";
    static final String DFA36_eofS =
        "\63\uffff";
    static final String DFA36_minS =
        "\1\11\2\uffff\1\60\1\uffff\1\156\2\uffff\1\156\1\141\1\165\1\162"+
        "\1\uffff\1\57\1\52\3\uffff\2\165\2\154\1\165\4\uffff\2\155\1\163"+
        "\1\154\1\145\1\50\1\72\1\145\2\60\1\uffff\1\151\1\uffff\1\60\2\uffff"+
        "\1\164\1\uffff\1\145\1\162\1\141\1\154\1\50\1\uffff";
    static final String DFA36_maxS =
        "\1\172\2\uffff\1\71\1\uffff\1\156\2\uffff\1\156\1\141\1\165\1\162"+
        "\1\uffff\1\71\1\57\3\uffff\2\165\2\154\1\165\4\uffff\2\155\1\163"+
        "\1\154\1\145\1\114\1\72\1\145\2\172\1\uffff\1\151\1\uffff\1\172"+
        "\2\uffff\1\164\1\uffff\1\145\1\162\1\141\1\154\1\50\1\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\7\1\10\4\uffff\1\15\2\uffff"+
        "\1\22\1\23\1\3\5\uffff\1\16\1\17\1\20\1\21\12\uffff\1\5\1\uffff"+
        "\1\11\1\uffff\1\13\1\14\1\uffff\1\12\5\uffff\1\6";
    static final String DFA36_specialS =
        "\63\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\20\1\17\1\uffff\1\20\1\17\22\uffff\1\20\10\uffff\1\1\2\uffff"+
            "\1\2\1\3\1\4\1\16\12\15\7\uffff\4\14\1\5\25\14\1\6\1\uffff\1"+
            "\7\1\uffff\1\14\1\uffff\4\14\1\10\1\11\7\14\1\12\5\14\1\13\6"+
            "\14",
            "",
            "",
            "\12\15",
            "",
            "\1\22",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "",
            "\1\27\12\15",
            "\1\32\4\uffff\1\31",
            "",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "",
            "",
            "",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45\43\uffff\1\46",
            "\1\47",
            "\1\50",
            "\12\14\6\uffff\33\14\4\uffff\1\14\1\uffff\32\14",
            "\12\14\6\uffff\33\14\4\uffff\1\14\1\uffff\32\14",
            "",
            "\1\53",
            "",
            "\12\14\6\uffff\33\14\4\uffff\1\14\1\uffff\32\14",
            "",
            "",
            "\1\55",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | IDENTIFIER_TOKEN | DATE | INTEGER_LITERAL | SL_COMMENT | ML_COMMENT | LINEBREAK | WHITESPACE );";
        }
    }
 

}