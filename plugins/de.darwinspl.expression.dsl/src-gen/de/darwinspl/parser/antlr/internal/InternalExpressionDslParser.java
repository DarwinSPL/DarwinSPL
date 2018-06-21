package de.darwinspl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.darwinspl.services.ExpressionDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'->'", "'<->'", "'&&'", "'||'", "'('", "')'", "'!'", "'?'", "'['", "']'", "'true'", "'false'", "'-'", "'>'", "'<'", "'>='", "'<='", "'='", "'!='", "'/'", "'*'", "'+'", "'.'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalExpressionDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExpressionDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private ExpressionDslGrammarAccess grammarAccess;

        public InternalExpressionDslParser(TokenStream input, ExpressionDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "HyExpression";
       	}

       	@Override
       	protected ExpressionDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleHyExpression"
    // InternalExpressionDsl.g:71:1: entryRuleHyExpression returns [EObject current=null] : iv_ruleHyExpression= ruleHyExpression EOF ;
    public final EObject entryRuleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyExpression = null;


        try {
            // InternalExpressionDsl.g:71:53: (iv_ruleHyExpression= ruleHyExpression EOF )
            // InternalExpressionDsl.g:72:2: iv_ruleHyExpression= ruleHyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyExpression=ruleHyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyExpression"


    // $ANTLR start "ruleHyExpression"
    // InternalExpressionDsl.g:78:1: ruleHyExpression returns [EObject current=null] : this_HyImpliesExpression_0= ruleHyImpliesExpression ;
    public final EObject ruleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyImpliesExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:84:2: (this_HyImpliesExpression_0= ruleHyImpliesExpression )
            // InternalExpressionDsl.g:85:2: this_HyImpliesExpression_0= ruleHyImpliesExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getHyExpressionAccess().getHyImpliesExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_HyImpliesExpression_0=ruleHyImpliesExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_HyImpliesExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyExpression"


    // $ANTLR start "entryRuleHyImpliesExpression"
    // InternalExpressionDsl.g:99:1: entryRuleHyImpliesExpression returns [EObject current=null] : iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF ;
    public final EObject entryRuleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyImpliesExpression = null;


        try {
            // InternalExpressionDsl.g:99:60: (iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF )
            // InternalExpressionDsl.g:100:2: iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyImpliesExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyImpliesExpression=ruleHyImpliesExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyImpliesExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyImpliesExpression"


    // $ANTLR start "ruleHyImpliesExpression"
    // InternalExpressionDsl.g:106:1: ruleHyImpliesExpression returns [EObject current=null] : (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) ;
    public final EObject ruleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyEquivalenceExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:112:2: ( (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) )
            // InternalExpressionDsl.g:113:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            {
            // InternalExpressionDsl.g:113:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            // InternalExpressionDsl.g:114:3: this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyImpliesExpressionAccess().getHyEquivalenceExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_3);
            this_HyEquivalenceExpression_0=ruleHyEquivalenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyEquivalenceExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:125:3: ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpressionDsl.g:126:4: () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    {
            	    // InternalExpressionDsl.g:126:4: ()
            	    // InternalExpressionDsl.g:127:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyImpliesExpressionAccess().getHyImpliesExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,11,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyImpliesExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:140:4: ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    // InternalExpressionDsl.g:141:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    {
            	    // InternalExpressionDsl.g:141:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    // InternalExpressionDsl.g:142:6: lv_operand2_3_0= ruleHyEquivalenceExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyImpliesExpressionAccess().getOperand2HyEquivalenceExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_operand2_3_0=ruleHyEquivalenceExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyImpliesExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HyEquivalenceExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyImpliesExpression"


    // $ANTLR start "entryRuleHyEquivalenceExpression"
    // InternalExpressionDsl.g:164:1: entryRuleHyEquivalenceExpression returns [EObject current=null] : iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF ;
    public final EObject entryRuleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEquivalenceExpression = null;


        try {
            // InternalExpressionDsl.g:164:64: (iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF )
            // InternalExpressionDsl.g:165:2: iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyEquivalenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyEquivalenceExpression=ruleHyEquivalenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyEquivalenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyEquivalenceExpression"


    // $ANTLR start "ruleHyEquivalenceExpression"
    // InternalExpressionDsl.g:171:1: ruleHyEquivalenceExpression returns [EObject current=null] : (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) ;
    public final EObject ruleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyAndExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:177:2: ( (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) )
            // InternalExpressionDsl.g:178:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            {
            // InternalExpressionDsl.g:178:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            // InternalExpressionDsl.g:179:3: this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyEquivalenceExpressionAccess().getHyAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_5);
            this_HyAndExpression_0=ruleHyAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:190:3: ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpressionDsl.g:191:4: () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    {
            	    // InternalExpressionDsl.g:191:4: ()
            	    // InternalExpressionDsl.g:192:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyEquivalenceExpressionAccess().getHyEquivalenceExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,12,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyEquivalenceExpressionAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:205:4: ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    // InternalExpressionDsl.g:206:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    {
            	    // InternalExpressionDsl.g:206:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    // InternalExpressionDsl.g:207:6: lv_operand2_3_0= ruleHyAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyEquivalenceExpressionAccess().getOperand2HyAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_operand2_3_0=ruleHyAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyEquivalenceExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HyAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyEquivalenceExpression"


    // $ANTLR start "entryRuleHyAndExpression"
    // InternalExpressionDsl.g:229:1: entryRuleHyAndExpression returns [EObject current=null] : iv_ruleHyAndExpression= ruleHyAndExpression EOF ;
    public final EObject entryRuleHyAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAndExpression = null;


        try {
            // InternalExpressionDsl.g:229:56: (iv_ruleHyAndExpression= ruleHyAndExpression EOF )
            // InternalExpressionDsl.g:230:2: iv_ruleHyAndExpression= ruleHyAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyAndExpression=ruleHyAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyAndExpression"


    // $ANTLR start "ruleHyAndExpression"
    // InternalExpressionDsl.g:236:1: ruleHyAndExpression returns [EObject current=null] : (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) ;
    public final EObject ruleHyAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:242:2: ( (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) )
            // InternalExpressionDsl.g:243:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            {
            // InternalExpressionDsl.g:243:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            // InternalExpressionDsl.g:244:3: this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyAndExpressionAccess().getHyOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_6);
            this_HyOrExpression_0=ruleHyOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:255:3: ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalExpressionDsl.g:256:4: () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    {
            	    // InternalExpressionDsl.g:256:4: ()
            	    // InternalExpressionDsl.g:257:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyAndExpressionAccess().getHyAndExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:270:4: ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    // InternalExpressionDsl.g:271:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    {
            	    // InternalExpressionDsl.g:271:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    // InternalExpressionDsl.g:272:6: lv_operand2_3_0= ruleHyOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyAndExpressionAccess().getOperand2HyOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_operand2_3_0=ruleHyOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HyOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyAndExpression"


    // $ANTLR start "entryRuleHyOrExpression"
    // InternalExpressionDsl.g:294:1: entryRuleHyOrExpression returns [EObject current=null] : iv_ruleHyOrExpression= ruleHyOrExpression EOF ;
    public final EObject entryRuleHyOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyOrExpression = null;


        try {
            // InternalExpressionDsl.g:294:55: (iv_ruleHyOrExpression= ruleHyOrExpression EOF )
            // InternalExpressionDsl.g:295:2: iv_ruleHyOrExpression= ruleHyOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyOrExpression=ruleHyOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyOrExpression"


    // $ANTLR start "ruleHyOrExpression"
    // InternalExpressionDsl.g:301:1: ruleHyOrExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) ;
    public final EObject ruleHyOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:307:2: ( (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) )
            // InternalExpressionDsl.g:308:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            {
            // InternalExpressionDsl.g:308:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            // InternalExpressionDsl.g:309:3: this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyOrExpressionAccess().getTerminalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_7);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TerminalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:320:3: ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExpressionDsl.g:321:4: () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    {
            	    // InternalExpressionDsl.g:321:4: ()
            	    // InternalExpressionDsl.g:322:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyOrExpressionAccess().getHyOrExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:335:4: ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    // InternalExpressionDsl.g:336:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    {
            	    // InternalExpressionDsl.g:336:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    // InternalExpressionDsl.g:337:6: lv_operand2_3_0= ruleTerminalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyOrExpressionAccess().getOperand2TerminalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_operand2_3_0=ruleTerminalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.TerminalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyOrExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalExpressionDsl.g:359:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalExpressionDsl.g:359:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalExpressionDsl.g:360:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalExpressionDsl.g:366:1: ruleTerminalExpression returns [EObject current=null] : ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyArithmeticalComparisonExpression_0 = null;

        EObject this_HyFeatureReferenceExpression_1 = null;

        EObject this_HyNestedExpression_2 = null;

        EObject this_HyConditionalFeatureReferenceExpression_3 = null;

        EObject this_HyNotExpression_4 = null;

        EObject this_HyBooleanValueExpression_5 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:372:2: ( ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression ) )
            // InternalExpressionDsl.g:373:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )
            {
            // InternalExpressionDsl.g:373:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )
            int alt5=6;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalExpressionDsl.g:374:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
                    {
                    // InternalExpressionDsl.g:374:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
                    // InternalExpressionDsl.g:375:4: ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyArithmeticalComparisonExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_HyArithmeticalComparisonExpression_0=ruleHyArithmeticalComparisonExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_HyArithmeticalComparisonExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:389:3: this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyFeatureReferenceExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyFeatureReferenceExpression_1=ruleHyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyFeatureReferenceExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:401:3: this_HyNestedExpression_2= ruleHyNestedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyNestedExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNestedExpression_2=ruleHyNestedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNestedExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:413:3: this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyConditionalFeatureReferenceExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyConditionalFeatureReferenceExpression_3=ruleHyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyConditionalFeatureReferenceExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpressionDsl.g:425:3: this_HyNotExpression_4= ruleHyNotExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyNotExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNotExpression_4=ruleHyNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNotExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpressionDsl.g:437:3: this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyBooleanValueExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyBooleanValueExpression_5=ruleHyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyBooleanValueExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleHyNestedExpression"
    // InternalExpressionDsl.g:452:1: entryRuleHyNestedExpression returns [EObject current=null] : iv_ruleHyNestedExpression= ruleHyNestedExpression EOF ;
    public final EObject entryRuleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedExpression = null;


        try {
            // InternalExpressionDsl.g:452:59: (iv_ruleHyNestedExpression= ruleHyNestedExpression EOF )
            // InternalExpressionDsl.g:453:2: iv_ruleHyNestedExpression= ruleHyNestedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyNestedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyNestedExpression=ruleHyNestedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyNestedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyNestedExpression"


    // $ANTLR start "ruleHyNestedExpression"
    // InternalExpressionDsl.g:459:1: ruleHyNestedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:465:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) )
            // InternalExpressionDsl.g:466:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            {
            // InternalExpressionDsl.g:466:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            // InternalExpressionDsl.g:467:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExpressionDsl.g:471:3: ( (lv_operand_1_0= ruleHyExpression ) )
            // InternalExpressionDsl.g:472:4: (lv_operand_1_0= ruleHyExpression )
            {
            // InternalExpressionDsl.g:472:4: (lv_operand_1_0= ruleHyExpression )
            // InternalExpressionDsl.g:473:5: lv_operand_1_0= ruleHyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNestedExpressionAccess().getOperandHyExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_operand_1_0=ruleHyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyNestedExpressionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"de.darwinspl.ExpressionDsl.HyExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getHyNestedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyNestedExpression"


    // $ANTLR start "entryRuleHyNotExpression"
    // InternalExpressionDsl.g:498:1: entryRuleHyNotExpression returns [EObject current=null] : iv_ruleHyNotExpression= ruleHyNotExpression EOF ;
    public final EObject entryRuleHyNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotExpression = null;


        try {
            // InternalExpressionDsl.g:498:56: (iv_ruleHyNotExpression= ruleHyNotExpression EOF )
            // InternalExpressionDsl.g:499:2: iv_ruleHyNotExpression= ruleHyNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyNotExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyNotExpression=ruleHyNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyNotExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyNotExpression"


    // $ANTLR start "ruleHyNotExpression"
    // InternalExpressionDsl.g:505:1: ruleHyNotExpression returns [EObject current=null] : (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) ;
    public final EObject ruleHyNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:511:2: ( (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) )
            // InternalExpressionDsl.g:512:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            {
            // InternalExpressionDsl.g:512:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            // InternalExpressionDsl.g:513:3: otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNotExpressionAccess().getExclamationMarkKeyword_0());
              		
            }
            // InternalExpressionDsl.g:517:3: ( (lv_operand_1_0= ruleTerminalExpression ) )
            // InternalExpressionDsl.g:518:4: (lv_operand_1_0= ruleTerminalExpression )
            {
            // InternalExpressionDsl.g:518:4: (lv_operand_1_0= ruleTerminalExpression )
            // InternalExpressionDsl.g:519:5: lv_operand_1_0= ruleTerminalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNotExpressionAccess().getOperandTerminalExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyNotExpressionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"de.darwinspl.ExpressionDsl.TerminalExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyNotExpression"


    // $ANTLR start "entryRuleHyFeatureReferenceExpression"
    // InternalExpressionDsl.g:540:1: entryRuleHyFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyFeatureReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:540:69: (iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF )
            // InternalExpressionDsl.g:541:2: iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyFeatureReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyFeatureReferenceExpression=ruleHyFeatureReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyFeatureReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyFeatureReferenceExpression"


    // $ANTLR start "ruleHyFeatureReferenceExpression"
    // InternalExpressionDsl.g:547:1: ruleHyFeatureReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_versionRestriction_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:553:2: ( ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) )
            // InternalExpressionDsl.g:554:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            {
            // InternalExpressionDsl.g:554:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            // InternalExpressionDsl.g:555:3: ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            {
            // InternalExpressionDsl.g:555:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:556:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:556:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:557:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyFeatureReferenceExpressionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyFeatureReferenceExpressionAccess().getFeatureHyFeatureCrossReference_0_0());
              				
            }

            }


            }

            // InternalExpressionDsl.g:571:3: ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19||LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalExpressionDsl.g:572:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    {
                    // InternalExpressionDsl.g:572:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    // InternalExpressionDsl.g:573:5: lv_versionRestriction_1_0= ruleHyVersionRestriction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getHyFeatureReferenceExpressionAccess().getVersionRestrictionHyVersionRestrictionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_versionRestriction_1_0=ruleHyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getHyFeatureReferenceExpressionRule());
                      					}
                      					set(
                      						current,
                      						"versionRestriction",
                      						lv_versionRestriction_1_0,
                      						"de.darwinspl.ExpressionDsl.HyVersionRestriction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyFeatureReferenceExpression"


    // $ANTLR start "entryRuleHyConditionalFeatureReferenceExpression"
    // InternalExpressionDsl.g:594:1: entryRuleHyConditionalFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyConditionalFeatureReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:594:80: (iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF )
            // InternalExpressionDsl.g:595:2: iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyConditionalFeatureReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyConditionalFeatureReferenceExpression=ruleHyConditionalFeatureReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyConditionalFeatureReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyConditionalFeatureReferenceExpression"


    // $ANTLR start "ruleHyConditionalFeatureReferenceExpression"
    // InternalExpressionDsl.g:601:1: ruleHyConditionalFeatureReferenceExpression returns [EObject current=null] : (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_versionRestriction_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:607:2: ( (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) )
            // InternalExpressionDsl.g:608:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            {
            // InternalExpressionDsl.g:608:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            // InternalExpressionDsl.g:609:3: otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getQuestionMarkKeyword_0());
              		
            }
            // InternalExpressionDsl.g:613:3: ( (otherlv_1= RULE_STRING ) )
            // InternalExpressionDsl.g:614:4: (otherlv_1= RULE_STRING )
            {
            // InternalExpressionDsl.g:614:4: (otherlv_1= RULE_STRING )
            // InternalExpressionDsl.g:615:5: otherlv_1= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyConditionalFeatureReferenceExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_STRING,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getFeatureHyFeatureCrossReference_1_0());
              				
            }

            }


            }

            // InternalExpressionDsl.g:629:3: ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19||LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalExpressionDsl.g:630:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    {
                    // InternalExpressionDsl.g:630:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    // InternalExpressionDsl.g:631:5: lv_versionRestriction_2_0= ruleHyVersionRestriction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getVersionRestrictionHyVersionRestrictionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_versionRestriction_2_0=ruleHyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getHyConditionalFeatureReferenceExpressionRule());
                      					}
                      					set(
                      						current,
                      						"versionRestriction",
                      						lv_versionRestriction_2_0,
                      						"de.darwinspl.ExpressionDsl.HyVersionRestriction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyConditionalFeatureReferenceExpression"


    // $ANTLR start "entryRuleHyVersionRestriction"
    // InternalExpressionDsl.g:652:1: entryRuleHyVersionRestriction returns [EObject current=null] : iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF ;
    public final EObject entryRuleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRestriction = null;


        try {
            // InternalExpressionDsl.g:652:61: (iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF )
            // InternalExpressionDsl.g:653:2: iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyVersionRestrictionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyVersionRestriction=ruleHyVersionRestriction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyVersionRestriction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyVersionRestriction"


    // $ANTLR start "ruleHyVersionRestriction"
    // InternalExpressionDsl.g:659:1: ruleHyVersionRestriction returns [EObject current=null] : (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) ;
    public final EObject ruleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject this_HyRelativeVersionRestriction_0 = null;

        EObject this_HyVersionRangeRestriction_1 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:665:2: ( (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) )
            // InternalExpressionDsl.g:666:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
            {
            // InternalExpressionDsl.g:666:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                int LA8_1 = input.LA(2);

                if ( ((LA8_1>=24 && LA8_1<=28)) ) {
                    alt8=1;
                }
                else if ( (LA8_1==21) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalExpressionDsl.g:667:3: this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyVersionRestrictionAccess().getHyRelativeVersionRestrictionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyRelativeVersionRestriction_0=ruleHyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyRelativeVersionRestriction_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:679:3: this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyVersionRestrictionAccess().getHyVersionRangeRestrictionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyVersionRangeRestriction_1=ruleHyVersionRangeRestriction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyVersionRangeRestriction_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyVersionRestriction"


    // $ANTLR start "entryRuleHyRelativeVersionRestriction"
    // InternalExpressionDsl.g:694:1: entryRuleHyRelativeVersionRestriction returns [EObject current=null] : iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF ;
    public final EObject entryRuleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyRelativeVersionRestriction = null;


        try {
            // InternalExpressionDsl.g:694:69: (iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF )
            // InternalExpressionDsl.g:695:2: iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyRelativeVersionRestrictionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyRelativeVersionRestriction=ruleHyRelativeVersionRestriction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyRelativeVersionRestriction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyRelativeVersionRestriction"


    // $ANTLR start "ruleHyRelativeVersionRestriction"
    // InternalExpressionDsl.g:701:1: ruleHyRelativeVersionRestriction returns [EObject current=null] : (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) ;
    public final EObject ruleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:707:2: ( (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) )
            // InternalExpressionDsl.g:708:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            {
            // InternalExpressionDsl.g:708:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            // InternalExpressionDsl.g:709:3: otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyRelativeVersionRestrictionAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalExpressionDsl.g:713:3: ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) )
            // InternalExpressionDsl.g:714:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            {
            // InternalExpressionDsl.g:714:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            // InternalExpressionDsl.g:715:5: lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyRelativeVersionRestrictionAccess().getOperatorHyRelativeVersionRestrictionOperatorEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_operator_1_0=ruleHyRelativeVersionRestrictionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyRelativeVersionRestrictionRule());
              					}
              					set(
              						current,
              						"operator",
              						lv_operator_1_0,
              						"de.darwinspl.ExpressionDsl.HyRelativeVersionRestrictionOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpressionDsl.g:732:3: ( (otherlv_2= RULE_ID ) )
            // InternalExpressionDsl.g:733:4: (otherlv_2= RULE_ID )
            {
            // InternalExpressionDsl.g:733:4: (otherlv_2= RULE_ID )
            // InternalExpressionDsl.g:734:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyRelativeVersionRestrictionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getHyRelativeVersionRestrictionAccess().getVersionHyVersionCrossReference_2_0());
              				
            }

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getHyRelativeVersionRestrictionAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyRelativeVersionRestriction"


    // $ANTLR start "entryRuleHyVersionRangeRestriction"
    // InternalExpressionDsl.g:756:1: entryRuleHyVersionRangeRestriction returns [EObject current=null] : iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF ;
    public final EObject entryRuleHyVersionRangeRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRangeRestriction = null;


        try {
            // InternalExpressionDsl.g:756:66: (iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF )
            // InternalExpressionDsl.g:757:2: iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyVersionRangeRestrictionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyVersionRangeRestriction=ruleHyVersionRangeRestriction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyVersionRangeRestriction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyVersionRangeRestriction"


    // $ANTLR start "ruleHyVersionRangeRestriction"
    // InternalExpressionDsl.g:763:1: ruleHyVersionRangeRestriction returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) ;
    public final EObject ruleHyVersionRangeRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lowerIncluded_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_upperIncluded_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:769:2: ( ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) )
            // InternalExpressionDsl.g:770:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            {
            // InternalExpressionDsl.g:770:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==RULE_STRING) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==23) ) {
                        alt9=2;
                    }
                    else if ( (LA9_3==20) ) {
                        alt9=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalExpressionDsl.g:771:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    {
                    // InternalExpressionDsl.g:771:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    // InternalExpressionDsl.g:772:4: otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) )
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getHyVersionRangeRestrictionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalExpressionDsl.g:776:4: ( (lv_lowerIncluded_1_0= 'true' ) )
                    // InternalExpressionDsl.g:777:5: (lv_lowerIncluded_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:777:5: (lv_lowerIncluded_1_0= 'true' )
                    // InternalExpressionDsl.g:778:6: lv_lowerIncluded_1_0= 'true'
                    {
                    lv_lowerIncluded_1_0=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_lowerIncluded_1_0, grammarAccess.getHyVersionRangeRestrictionAccess().getLowerIncludedTrueKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      						setWithLastConsumed(current, "lowerIncluded", true, "true");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:792:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    {
                    // InternalExpressionDsl.g:792:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    // InternalExpressionDsl.g:793:4: otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_1_0());
                      			
                    }
                    // InternalExpressionDsl.g:797:4: ( (otherlv_3= RULE_STRING ) )
                    // InternalExpressionDsl.g:798:5: (otherlv_3= RULE_STRING )
                    {
                    // InternalExpressionDsl.g:798:5: (otherlv_3= RULE_STRING )
                    // InternalExpressionDsl.g:799:6: otherlv_3= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getHyVersionRangeRestrictionAccess().getLowerVersionHyVersionCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getHyVersionRangeRestrictionAccess().getHyphenMinusKeyword_1_2());
                      			
                    }
                    // InternalExpressionDsl.g:817:4: ( (lv_upperIncluded_5_0= 'true' ) )
                    // InternalExpressionDsl.g:818:5: (lv_upperIncluded_5_0= 'true' )
                    {
                    // InternalExpressionDsl.g:818:5: (lv_upperIncluded_5_0= 'true' )
                    // InternalExpressionDsl.g:819:6: lv_upperIncluded_5_0= 'true'
                    {
                    lv_upperIncluded_5_0=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_upperIncluded_5_0, grammarAccess.getHyVersionRangeRestrictionAccess().getUpperIncludedTrueKeyword_1_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      						setWithLastConsumed(current, "upperIncluded", true, "true");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:833:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    {
                    // InternalExpressionDsl.g:833:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    // InternalExpressionDsl.g:834:4: otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_2_0());
                      			
                    }
                    // InternalExpressionDsl.g:838:4: ( (otherlv_7= RULE_STRING ) )
                    // InternalExpressionDsl.g:839:5: (otherlv_7= RULE_STRING )
                    {
                    // InternalExpressionDsl.g:839:5: (otherlv_7= RULE_STRING )
                    // InternalExpressionDsl.g:840:6: otherlv_7= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      					
                    }
                    otherlv_7=(Token)match(input,RULE_STRING,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_7, grammarAccess.getHyVersionRangeRestrictionAccess().getUpperVersionHyVersionCrossReference_2_1_0());
                      					
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getHyVersionRangeRestrictionAccess().getRightSquareBracketKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyVersionRangeRestriction"


    // $ANTLR start "entryRuleHyBooleanValueExpression"
    // InternalExpressionDsl.g:863:1: entryRuleHyBooleanValueExpression returns [EObject current=null] : iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF ;
    public final EObject entryRuleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValueExpression = null;


        try {
            // InternalExpressionDsl.g:863:65: (iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF )
            // InternalExpressionDsl.g:864:2: iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyBooleanValueExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyBooleanValueExpression=ruleHyBooleanValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyBooleanValueExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyBooleanValueExpression"


    // $ANTLR start "ruleHyBooleanValueExpression"
    // InternalExpressionDsl.g:870:1: ruleHyBooleanValueExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:876:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalExpressionDsl.g:877:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalExpressionDsl.g:877:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalExpressionDsl.g:878:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalExpressionDsl.g:878:3: ()
            // InternalExpressionDsl.g:879:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHyBooleanValueExpressionAccess().getHyBooleanValueExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalExpressionDsl.g:888:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==22) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalExpressionDsl.g:889:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalExpressionDsl.g:889:4: ( (lv_value_1_0= 'true' ) )
                    // InternalExpressionDsl.g:890:5: (lv_value_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:890:5: (lv_value_1_0= 'true' )
                    // InternalExpressionDsl.g:891:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getHyBooleanValueExpressionAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyBooleanValueExpressionRule());
                      						}
                      						setWithLastConsumed(current, "value", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:904:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHyBooleanValueExpressionAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyBooleanValueExpression"


    // $ANTLR start "entryRuleHyArithmeticalComparisonExpression"
    // InternalExpressionDsl.g:913:1: entryRuleHyArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalComparisonExpression = null;


        try {
            // InternalExpressionDsl.g:913:75: (iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF )
            // InternalExpressionDsl.g:914:2: iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyArithmeticalComparisonExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyArithmeticalComparisonExpression=ruleHyArithmeticalComparisonExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyArithmeticalComparisonExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyArithmeticalComparisonExpression"


    // $ANTLR start "ruleHyArithmeticalComparisonExpression"
    // InternalExpressionDsl.g:920:1: ruleHyArithmeticalComparisonExpression returns [EObject current=null] : this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression ;
    public final EObject ruleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyBinaryArithmeticalComparisonExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:926:2: (this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression )
            // InternalExpressionDsl.g:927:2: this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getHyArithmeticalComparisonExpressionAccess().getHyBinaryArithmeticalComparisonExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_HyBinaryArithmeticalComparisonExpression_0=ruleHyBinaryArithmeticalComparisonExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_HyBinaryArithmeticalComparisonExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyArithmeticalComparisonExpression"


    // $ANTLR start "entryRuleHyBinaryArithmeticalComparisonExpression"
    // InternalExpressionDsl.g:941:1: entryRuleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyBinaryArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBinaryArithmeticalComparisonExpression = null;


        try {
            // InternalExpressionDsl.g:941:81: (iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF )
            // InternalExpressionDsl.g:942:2: iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyBinaryArithmeticalComparisonExpression=ruleHyBinaryArithmeticalComparisonExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyBinaryArithmeticalComparisonExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyBinaryArithmeticalComparisonExpression"


    // $ANTLR start "ruleHyBinaryArithmeticalComparisonExpression"
    // InternalExpressionDsl.g:948:1: ruleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression ) ;
    public final EObject ruleHyBinaryArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyGreaterOrEqualExpression_0 = null;

        EObject this_HyGreaterExpression_1 = null;

        EObject this_HyLessOrEqualExpression_2 = null;

        EObject this_HyLessExpression_3 = null;

        EObject this_HyNotEqualExpression_4 = null;

        EObject this_HyEqualExpression_5 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:954:2: ( (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression ) )
            // InternalExpressionDsl.g:955:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )
            {
            // InternalExpressionDsl.g:955:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalExpressionDsl.g:956:3: this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyGreaterOrEqualExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyGreaterOrEqualExpression_0=ruleHyGreaterOrEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyGreaterOrEqualExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:968:3: this_HyGreaterExpression_1= ruleHyGreaterExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyGreaterExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyGreaterExpression_1=ruleHyGreaterExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyGreaterExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:980:3: this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyLessOrEqualExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyLessOrEqualExpression_2=ruleHyLessOrEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyLessOrEqualExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:992:3: this_HyLessExpression_3= ruleHyLessExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyLessExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyLessExpression_3=ruleHyLessExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyLessExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpressionDsl.g:1004:3: this_HyNotEqualExpression_4= ruleHyNotEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyNotEqualExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNotEqualExpression_4=ruleHyNotEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNotEqualExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpressionDsl.g:1016:3: this_HyEqualExpression_5= ruleHyEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyEqualExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyEqualExpression_5=ruleHyEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyEqualExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyBinaryArithmeticalComparisonExpression"


    // $ANTLR start "entryRuleHyGreaterExpression"
    // InternalExpressionDsl.g:1031:1: entryRuleHyGreaterExpression returns [EObject current=null] : iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF ;
    public final EObject entryRuleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterExpression = null;


        try {
            // InternalExpressionDsl.g:1031:60: (iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF )
            // InternalExpressionDsl.g:1032:2: iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyGreaterExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyGreaterExpression=ruleHyGreaterExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyGreaterExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyGreaterExpression"


    // $ANTLR start "ruleHyGreaterExpression"
    // InternalExpressionDsl.g:1038:1: ruleHyGreaterExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1044:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1045:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1045:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1046:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1046:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1047:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1047:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1048:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyGreaterExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyGreaterExpressionAccess().getGreaterThanSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1069:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1070:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1070:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1071:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyGreaterExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyGreaterExpression"


    // $ANTLR start "entryRuleHyLessExpression"
    // InternalExpressionDsl.g:1092:1: entryRuleHyLessExpression returns [EObject current=null] : iv_ruleHyLessExpression= ruleHyLessExpression EOF ;
    public final EObject entryRuleHyLessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessExpression = null;


        try {
            // InternalExpressionDsl.g:1092:57: (iv_ruleHyLessExpression= ruleHyLessExpression EOF )
            // InternalExpressionDsl.g:1093:2: iv_ruleHyLessExpression= ruleHyLessExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyLessExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyLessExpression=ruleHyLessExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyLessExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyLessExpression"


    // $ANTLR start "ruleHyLessExpression"
    // InternalExpressionDsl.g:1099:1: ruleHyLessExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyLessExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1105:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1106:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1106:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1107:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1107:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1108:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1108:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1109:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyLessExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyLessExpressionAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1130:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1131:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1131:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1132:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyLessExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyLessExpression"


    // $ANTLR start "entryRuleHyGreaterOrEqualExpression"
    // InternalExpressionDsl.g:1153:1: entryRuleHyGreaterOrEqualExpression returns [EObject current=null] : iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF ;
    public final EObject entryRuleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterOrEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1153:67: (iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF )
            // InternalExpressionDsl.g:1154:2: iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyGreaterOrEqualExpression=ruleHyGreaterOrEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyGreaterOrEqualExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyGreaterOrEqualExpression"


    // $ANTLR start "ruleHyGreaterOrEqualExpression"
    // InternalExpressionDsl.g:1160:1: ruleHyGreaterOrEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1166:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1167:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1167:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1168:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1168:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1169:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1169:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1170:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyGreaterOrEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyGreaterOrEqualExpressionAccess().getGreaterThanSignEqualsSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1191:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1192:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1192:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1193:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyGreaterOrEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyGreaterOrEqualExpression"


    // $ANTLR start "entryRuleHyLessOrEqualExpression"
    // InternalExpressionDsl.g:1214:1: entryRuleHyLessOrEqualExpression returns [EObject current=null] : iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF ;
    public final EObject entryRuleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessOrEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1214:64: (iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF )
            // InternalExpressionDsl.g:1215:2: iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyLessOrEqualExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyLessOrEqualExpression=ruleHyLessOrEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyLessOrEqualExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyLessOrEqualExpression"


    // $ANTLR start "ruleHyLessOrEqualExpression"
    // InternalExpressionDsl.g:1221:1: ruleHyLessOrEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1227:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1228:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1228:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1229:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1229:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1230:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1230:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1231:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyLessOrEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyLessOrEqualExpressionAccess().getLessThanSignEqualsSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1252:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1253:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1253:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1254:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyLessOrEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyLessOrEqualExpression"


    // $ANTLR start "entryRuleHyEqualExpression"
    // InternalExpressionDsl.g:1275:1: entryRuleHyEqualExpression returns [EObject current=null] : iv_ruleHyEqualExpression= ruleHyEqualExpression EOF ;
    public final EObject entryRuleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1275:58: (iv_ruleHyEqualExpression= ruleHyEqualExpression EOF )
            // InternalExpressionDsl.g:1276:2: iv_ruleHyEqualExpression= ruleHyEqualExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyEqualExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyEqualExpression=ruleHyEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyEqualExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyEqualExpression"


    // $ANTLR start "ruleHyEqualExpression"
    // InternalExpressionDsl.g:1282:1: ruleHyEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1288:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1289:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1289:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1290:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1290:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1291:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1291:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1292:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyEqualExpressionAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1313:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1314:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1314:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1315:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyEqualExpression"


    // $ANTLR start "entryRuleHyNotEqualExpression"
    // InternalExpressionDsl.g:1336:1: entryRuleHyNotEqualExpression returns [EObject current=null] : iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF ;
    public final EObject entryRuleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1336:61: (iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF )
            // InternalExpressionDsl.g:1337:2: iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyNotEqualExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyNotEqualExpression=ruleHyNotEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyNotEqualExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyNotEqualExpression"


    // $ANTLR start "ruleHyNotEqualExpression"
    // InternalExpressionDsl.g:1343:1: ruleHyNotEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1349:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1350:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1350:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1351:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1351:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1352:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1352:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1353:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNotEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_operand1_0_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyNotEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand1",
              						lv_operand1_0_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyNotEqualExpressionAccess().getExclamationMarkEqualsSignKeyword_1());
              		
            }
            // InternalExpressionDsl.g:1374:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1375:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1375:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1376:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNotEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand2_2_0=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyNotEqualExpressionRule());
              					}
              					set(
              						current,
              						"operand2",
              						lv_operand2_2_0,
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyNotEqualExpression"


    // $ANTLR start "entryRuleHyArithmeticalValueExpression"
    // InternalExpressionDsl.g:1397:1: entryRuleHyArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalValueExpression = null;


        try {
            // InternalExpressionDsl.g:1397:70: (iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF )
            // InternalExpressionDsl.g:1398:2: iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyArithmeticalValueExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyArithmeticalValueExpression=ruleHyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyArithmeticalValueExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyArithmeticalValueExpression"


    // $ANTLR start "ruleHyArithmeticalValueExpression"
    // InternalExpressionDsl.g:1404:1: ruleHyArithmeticalValueExpression returns [EObject current=null] : this_HyDivisionExpression_0= ruleHyDivisionExpression ;
    public final EObject ruleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyDivisionExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1410:2: (this_HyDivisionExpression_0= ruleHyDivisionExpression )
            // InternalExpressionDsl.g:1411:2: this_HyDivisionExpression_0= ruleHyDivisionExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getHyArithmeticalValueExpressionAccess().getHyDivisionExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_HyDivisionExpression_0=ruleHyDivisionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_HyDivisionExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyArithmeticalValueExpression"


    // $ANTLR start "entryRuleHyDivisionExpression"
    // InternalExpressionDsl.g:1425:1: entryRuleHyDivisionExpression returns [EObject current=null] : iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF ;
    public final EObject entryRuleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyDivisionExpression = null;


        try {
            // InternalExpressionDsl.g:1425:61: (iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF )
            // InternalExpressionDsl.g:1426:2: iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyDivisionExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyDivisionExpression=ruleHyDivisionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyDivisionExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyDivisionExpression"


    // $ANTLR start "ruleHyDivisionExpression"
    // InternalExpressionDsl.g:1432:1: ruleHyDivisionExpression returns [EObject current=null] : (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) ;
    public final EObject ruleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyMultiplicationExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1438:2: ( (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) )
            // InternalExpressionDsl.g:1439:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1439:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            // InternalExpressionDsl.g:1440:3: this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getHyMultiplicationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_HyMultiplicationExpression_0=ruleHyMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyMultiplicationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1451:3: ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalExpressionDsl.g:1452:4: () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1452:4: ()
            	    // InternalExpressionDsl.g:1453:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyDivisionExpressionAccess().getHyDivisionExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyDivisionExpressionAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1466:4: ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    // InternalExpressionDsl.g:1467:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    {
            	    // InternalExpressionDsl.g:1467:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    // InternalExpressionDsl.g:1468:6: lv_operand2_3_0= ruleHyMultiplicationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getOperand2HyMultiplicationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_operand2_3_0=ruleHyMultiplicationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyDivisionExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HyMultiplicationExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyDivisionExpression"


    // $ANTLR start "entryRuleHyMultiplicationExpression"
    // InternalExpressionDsl.g:1490:1: entryRuleHyMultiplicationExpression returns [EObject current=null] : iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF ;
    public final EObject entryRuleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyMultiplicationExpression = null;


        try {
            // InternalExpressionDsl.g:1490:67: (iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF )
            // InternalExpressionDsl.g:1491:2: iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyMultiplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyMultiplicationExpression=ruleHyMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyMultiplicationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyMultiplicationExpression"


    // $ANTLR start "ruleHyMultiplicationExpression"
    // InternalExpressionDsl.g:1497:1: ruleHyMultiplicationExpression returns [EObject current=null] : (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) ;
    public final EObject ruleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HySubtractionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1503:2: ( (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) )
            // InternalExpressionDsl.g:1504:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1504:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            // InternalExpressionDsl.g:1505:3: this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getHySubtractionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_HySubtractionExpression_0=ruleHySubtractionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HySubtractionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1516:3: ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==31) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalExpressionDsl.g:1517:4: () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1517:4: ()
            	    // InternalExpressionDsl.g:1518:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyMultiplicationExpressionAccess().getHyMultiplicationExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyMultiplicationExpressionAccess().getAsteriskKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1531:4: ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    // InternalExpressionDsl.g:1532:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    {
            	    // InternalExpressionDsl.g:1532:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    // InternalExpressionDsl.g:1533:6: lv_operand2_3_0= ruleHySubtractionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getOperand2HySubtractionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_operand2_3_0=ruleHySubtractionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyMultiplicationExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HySubtractionExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyMultiplicationExpression"


    // $ANTLR start "entryRuleHySubtractionExpression"
    // InternalExpressionDsl.g:1555:1: entryRuleHySubtractionExpression returns [EObject current=null] : iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF ;
    public final EObject entryRuleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHySubtractionExpression = null;


        try {
            // InternalExpressionDsl.g:1555:64: (iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF )
            // InternalExpressionDsl.g:1556:2: iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHySubtractionExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHySubtractionExpression=ruleHySubtractionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHySubtractionExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHySubtractionExpression"


    // $ANTLR start "ruleHySubtractionExpression"
    // InternalExpressionDsl.g:1562:1: ruleHySubtractionExpression returns [EObject current=null] : (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* ) ;
    public final EObject ruleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyAdditionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1568:2: ( (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* ) )
            // InternalExpressionDsl.g:1569:2: (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1569:2: (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* )
            // InternalExpressionDsl.g:1570:3: this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getHyAdditionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_HyAdditionExpression_0=ruleHyAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyAdditionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1581:3: ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalExpressionDsl.g:1582:4: () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1582:4: ()
            	    // InternalExpressionDsl.g:1583:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHySubtractionExpressionAccess().getHySubtractionExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHySubtractionExpressionAccess().getHyphenMinusKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1596:4: ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
            	    // InternalExpressionDsl.g:1597:5: (lv_operand2_3_0= ruleHyAdditionExpression )
            	    {
            	    // InternalExpressionDsl.g:1597:5: (lv_operand2_3_0= ruleHyAdditionExpression )
            	    // InternalExpressionDsl.g:1598:6: lv_operand2_3_0= ruleHyAdditionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getOperand2HyAdditionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_operand2_3_0=ruleHyAdditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHySubtractionExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.HyAdditionExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHySubtractionExpression"


    // $ANTLR start "entryRuleHyAdditionExpression"
    // InternalExpressionDsl.g:1620:1: entryRuleHyAdditionExpression returns [EObject current=null] : iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF ;
    public final EObject entryRuleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAdditionExpression = null;


        try {
            // InternalExpressionDsl.g:1620:61: (iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF )
            // InternalExpressionDsl.g:1621:2: iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyAdditionExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyAdditionExpression=ruleHyAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyAdditionExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyAdditionExpression"


    // $ANTLR start "ruleHyAdditionExpression"
    // InternalExpressionDsl.g:1627:1: ruleHyAdditionExpression returns [EObject current=null] : (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) ;
    public final EObject ruleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalArithmeticalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1633:2: ( (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) )
            // InternalExpressionDsl.g:1634:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1634:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            // InternalExpressionDsl.g:1635:3: this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getTerminalArithmeticalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_TerminalArithmeticalExpression_0=ruleTerminalArithmeticalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TerminalArithmeticalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1646:3: ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalExpressionDsl.g:1647:4: () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1647:4: ()
            	    // InternalExpressionDsl.g:1648:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyAdditionExpressionAccess().getHyAdditionExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyAdditionExpressionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1661:4: ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    // InternalExpressionDsl.g:1662:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    {
            	    // InternalExpressionDsl.g:1662:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    // InternalExpressionDsl.g:1663:6: lv_operand2_3_0= ruleTerminalArithmeticalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getOperand2TerminalArithmeticalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_operand2_3_0=ruleTerminalArithmeticalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getHyAdditionExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operand2",
            	      							lv_operand2_3_0,
            	      							"de.darwinspl.ExpressionDsl.TerminalArithmeticalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyAdditionExpression"


    // $ANTLR start "entryRuleTerminalArithmeticalExpression"
    // InternalExpressionDsl.g:1685:1: entryRuleTerminalArithmeticalExpression returns [EObject current=null] : iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF ;
    public final EObject entryRuleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalArithmeticalExpression = null;


        try {
            // InternalExpressionDsl.g:1685:71: (iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF )
            // InternalExpressionDsl.g:1686:2: iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTerminalArithmeticalExpression=ruleTerminalArithmeticalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalArithmeticalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalArithmeticalExpression"


    // $ANTLR start "ruleTerminalArithmeticalExpression"
    // InternalExpressionDsl.g:1692:1: ruleTerminalArithmeticalExpression returns [EObject current=null] : ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression ) | this_HyValueExpression_1= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_2= ruleHyNestedArithmeticalValueExpression | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) ;
    public final EObject ruleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyContextInformationReferenceExpression_0 = null;

        EObject this_HyValueExpression_1 = null;

        EObject this_HyNestedArithmeticalValueExpression_2 = null;

        EObject this_HyAttributeReferenceExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1698:2: ( ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression ) | this_HyValueExpression_1= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_2= ruleHyNestedArithmeticalValueExpression | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) )
            // InternalExpressionDsl.g:1699:2: ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression ) | this_HyValueExpression_1= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_2= ruleHyNestedArithmeticalValueExpression | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            {
            // InternalExpressionDsl.g:1699:2: ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression ) | this_HyValueExpression_1= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_2= ruleHyNestedArithmeticalValueExpression | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==33) ) {
                    alt16=4;
                }
                else if ( (synpred27_InternalExpressionDsl()) ) {
                    alt16=1;
                }
                else if ( (synpred28_InternalExpressionDsl()) ) {
                    alt16=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case 21:
            case 22:
            case 23:
                {
                alt16=2;
                }
                break;
            case 15:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalExpressionDsl.g:1700:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression )
                    {
                    // InternalExpressionDsl.g:1700:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression )
                    // InternalExpressionDsl.g:1701:4: ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyContextInformationReferenceExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_HyContextInformationReferenceExpression_0=ruleHyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_HyContextInformationReferenceExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1715:3: this_HyValueExpression_1= ruleHyValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyValueExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyValueExpression_1=ruleHyValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyValueExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:1727:3: this_HyNestedArithmeticalValueExpression_2= ruleHyNestedArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyNestedArithmeticalValueExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNestedArithmeticalValueExpression_2=ruleHyNestedArithmeticalValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNestedArithmeticalValueExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:1739:3: this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyAttributeReferenceExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyAttributeReferenceExpression_3=ruleHyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyAttributeReferenceExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalArithmeticalExpression"


    // $ANTLR start "entryRuleHyValueExpression"
    // InternalExpressionDsl.g:1754:1: entryRuleHyValueExpression returns [EObject current=null] : iv_ruleHyValueExpression= ruleHyValueExpression EOF ;
    public final EObject entryRuleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValueExpression = null;


        try {
            // InternalExpressionDsl.g:1754:58: (iv_ruleHyValueExpression= ruleHyValueExpression EOF )
            // InternalExpressionDsl.g:1755:2: iv_ruleHyValueExpression= ruleHyValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyValueExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyValueExpression=ruleHyValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyValueExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyValueExpression"


    // $ANTLR start "ruleHyValueExpression"
    // InternalExpressionDsl.g:1761:1: ruleHyValueExpression returns [EObject current=null] : ( (lv_value_0_0= ruleHyValue ) ) ;
    public final EObject ruleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1767:2: ( ( (lv_value_0_0= ruleHyValue ) ) )
            // InternalExpressionDsl.g:1768:2: ( (lv_value_0_0= ruleHyValue ) )
            {
            // InternalExpressionDsl.g:1768:2: ( (lv_value_0_0= ruleHyValue ) )
            // InternalExpressionDsl.g:1769:3: (lv_value_0_0= ruleHyValue )
            {
            // InternalExpressionDsl.g:1769:3: (lv_value_0_0= ruleHyValue )
            // InternalExpressionDsl.g:1770:4: lv_value_0_0= ruleHyValue
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getHyValueExpressionAccess().getValueHyValueParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleHyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getHyValueExpressionRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.darwinspl.ExpressionDsl.HyValue");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyValueExpression"


    // $ANTLR start "entryRuleHyValue"
    // InternalExpressionDsl.g:1790:1: entryRuleHyValue returns [EObject current=null] : iv_ruleHyValue= ruleHyValue EOF ;
    public final EObject entryRuleHyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValue = null;


        try {
            // InternalExpressionDsl.g:1790:48: (iv_ruleHyValue= ruleHyValue EOF )
            // InternalExpressionDsl.g:1791:2: iv_ruleHyValue= ruleHyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyValue=ruleHyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyValue"


    // $ANTLR start "ruleHyValue"
    // InternalExpressionDsl.g:1797:1: ruleHyValue returns [EObject current=null] : (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) ;
    public final EObject ruleHyValue() throws RecognitionException {
        EObject current = null;

        EObject this_HyNumberValue_0 = null;

        EObject this_HyStringValue_1 = null;

        EObject this_HyBooleanValue_2 = null;

        EObject this_HyEnumValue_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1803:2: ( (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) )
            // InternalExpressionDsl.g:1804:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            {
            // InternalExpressionDsl.g:1804:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            int alt17=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 23:
                {
                alt17=1;
                }
                break;
            case RULE_STRING:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==33) ) {
                    alt17=4;
                }
                else if ( (LA17_2==EOF||(LA17_2>=11 && LA17_2<=14)||LA17_2==16||(LA17_2>=23 && LA17_2<=32)) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case 21:
            case 22:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalExpressionDsl.g:1805:3: this_HyNumberValue_0= ruleHyNumberValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyValueAccess().getHyNumberValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNumberValue_0=ruleHyNumberValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNumberValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1817:3: this_HyStringValue_1= ruleHyStringValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyValueAccess().getHyStringValueParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyStringValue_1=ruleHyStringValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyStringValue_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:1829:3: this_HyBooleanValue_2= ruleHyBooleanValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyValueAccess().getHyBooleanValueParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyBooleanValue_2=ruleHyBooleanValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyBooleanValue_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:1841:3: this_HyEnumValue_3= ruleHyEnumValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyValueAccess().getHyEnumValueParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyEnumValue_3=ruleHyEnumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyEnumValue_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyValue"


    // $ANTLR start "entryRuleHyNumberValue"
    // InternalExpressionDsl.g:1856:1: entryRuleHyNumberValue returns [EObject current=null] : iv_ruleHyNumberValue= ruleHyNumberValue EOF ;
    public final EObject entryRuleHyNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNumberValue = null;


        try {
            // InternalExpressionDsl.g:1856:54: (iv_ruleHyNumberValue= ruleHyNumberValue EOF )
            // InternalExpressionDsl.g:1857:2: iv_ruleHyNumberValue= ruleHyNumberValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyNumberValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyNumberValue=ruleHyNumberValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyNumberValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyNumberValue"


    // $ANTLR start "ruleHyNumberValue"
    // InternalExpressionDsl.g:1863:1: ruleHyNumberValue returns [EObject current=null] : ( (lv_value_0_0= ruleEInt ) ) ;
    public final EObject ruleHyNumberValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1869:2: ( ( (lv_value_0_0= ruleEInt ) ) )
            // InternalExpressionDsl.g:1870:2: ( (lv_value_0_0= ruleEInt ) )
            {
            // InternalExpressionDsl.g:1870:2: ( (lv_value_0_0= ruleEInt ) )
            // InternalExpressionDsl.g:1871:3: (lv_value_0_0= ruleEInt )
            {
            // InternalExpressionDsl.g:1871:3: (lv_value_0_0= ruleEInt )
            // InternalExpressionDsl.g:1872:4: lv_value_0_0= ruleEInt
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getHyNumberValueAccess().getValueEIntParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getHyNumberValueRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.darwinspl.ExpressionDsl.EInt");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyNumberValue"


    // $ANTLR start "entryRuleHyStringValue"
    // InternalExpressionDsl.g:1892:1: entryRuleHyStringValue returns [EObject current=null] : iv_ruleHyStringValue= ruleHyStringValue EOF ;
    public final EObject entryRuleHyStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyStringValue = null;


        try {
            // InternalExpressionDsl.g:1892:54: (iv_ruleHyStringValue= ruleHyStringValue EOF )
            // InternalExpressionDsl.g:1893:2: iv_ruleHyStringValue= ruleHyStringValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyStringValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyStringValue=ruleHyStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyStringValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyStringValue"


    // $ANTLR start "ruleHyStringValue"
    // InternalExpressionDsl.g:1899:1: ruleHyStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleHyStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1905:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1906:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1906:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1907:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1907:3: (lv_value_0_0= RULE_STRING )
            // InternalExpressionDsl.g:1908:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getHyStringValueAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getHyStringValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.xtext.common.Terminals.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyStringValue"


    // $ANTLR start "entryRuleHyBooleanValue"
    // InternalExpressionDsl.g:1927:1: entryRuleHyBooleanValue returns [EObject current=null] : iv_ruleHyBooleanValue= ruleHyBooleanValue EOF ;
    public final EObject entryRuleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValue = null;


        try {
            // InternalExpressionDsl.g:1927:55: (iv_ruleHyBooleanValue= ruleHyBooleanValue EOF )
            // InternalExpressionDsl.g:1928:2: iv_ruleHyBooleanValue= ruleHyBooleanValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyBooleanValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyBooleanValue=ruleHyBooleanValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyBooleanValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyBooleanValue"


    // $ANTLR start "ruleHyBooleanValue"
    // InternalExpressionDsl.g:1934:1: ruleHyBooleanValue returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1940:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalExpressionDsl.g:1941:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalExpressionDsl.g:1941:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalExpressionDsl.g:1942:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalExpressionDsl.g:1942:3: ()
            // InternalExpressionDsl.g:1943:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHyBooleanValueAccess().getHyBooleanValueAction_0(),
              					current);
              			
            }

            }

            // InternalExpressionDsl.g:1952:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            else if ( (LA18_0==22) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalExpressionDsl.g:1953:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalExpressionDsl.g:1953:4: ( (lv_value_1_0= 'true' ) )
                    // InternalExpressionDsl.g:1954:5: (lv_value_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:1954:5: (lv_value_1_0= 'true' )
                    // InternalExpressionDsl.g:1955:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getHyBooleanValueAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyBooleanValueRule());
                      						}
                      						setWithLastConsumed(current, "value", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1968:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHyBooleanValueAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyBooleanValue"


    // $ANTLR start "entryRuleHyEnumValue"
    // InternalExpressionDsl.g:1977:1: entryRuleHyEnumValue returns [EObject current=null] : iv_ruleHyEnumValue= ruleHyEnumValue EOF ;
    public final EObject entryRuleHyEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEnumValue = null;


        try {
            // InternalExpressionDsl.g:1977:52: (iv_ruleHyEnumValue= ruleHyEnumValue EOF )
            // InternalExpressionDsl.g:1978:2: iv_ruleHyEnumValue= ruleHyEnumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyEnumValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyEnumValue=ruleHyEnumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyEnumValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyEnumValue"


    // $ANTLR start "ruleHyEnumValue"
    // InternalExpressionDsl.g:1984:1: ruleHyEnumValue returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1990:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalExpressionDsl.g:1991:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalExpressionDsl.g:1991:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1992:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1992:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1993:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1993:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:1994:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyEnumValueRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyEnumValueAccess().getEnumHyEnumCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyEnumValueAccess().getFullStopKeyword_1());
              		
            }
            // InternalExpressionDsl.g:2012:3: ( (otherlv_2= RULE_STRING ) )
            // InternalExpressionDsl.g:2013:4: (otherlv_2= RULE_STRING )
            {
            // InternalExpressionDsl.g:2013:4: (otherlv_2= RULE_STRING )
            // InternalExpressionDsl.g:2014:5: otherlv_2= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyEnumValueRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getHyEnumValueAccess().getEnumLiteralHyEnumLiteralCrossReference_2_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyEnumValue"


    // $ANTLR start "entryRuleHyNestedArithmeticalValueExpression"
    // InternalExpressionDsl.g:2032:1: entryRuleHyNestedArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedArithmeticalValueExpression = null;


        try {
            // InternalExpressionDsl.g:2032:76: (iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF )
            // InternalExpressionDsl.g:2033:2: iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyNestedArithmeticalValueExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyNestedArithmeticalValueExpression=ruleHyNestedArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyNestedArithmeticalValueExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyNestedArithmeticalValueExpression"


    // $ANTLR start "ruleHyNestedArithmeticalValueExpression"
    // InternalExpressionDsl.g:2039:1: ruleHyNestedArithmeticalValueExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:2045:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' ) )
            // InternalExpressionDsl.g:2046:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' )
            {
            // InternalExpressionDsl.g:2046:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' )
            // InternalExpressionDsl.g:2047:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExpressionDsl.g:2051:3: ( (lv_operand_1_0= ruleHyDivisionExpression ) )
            // InternalExpressionDsl.g:2052:4: (lv_operand_1_0= ruleHyDivisionExpression )
            {
            // InternalExpressionDsl.g:2052:4: (lv_operand_1_0= ruleHyDivisionExpression )
            // InternalExpressionDsl.g:2053:5: lv_operand_1_0= ruleHyDivisionExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getOperandHyDivisionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_operand_1_0=ruleHyDivisionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHyNestedArithmeticalValueExpressionRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"de.darwinspl.ExpressionDsl.HyDivisionExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyNestedArithmeticalValueExpression"


    // $ANTLR start "entryRuleHyContextInformationReferenceExpression"
    // InternalExpressionDsl.g:2078:1: entryRuleHyContextInformationReferenceExpression returns [EObject current=null] : iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF ;
    public final EObject entryRuleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyContextInformationReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:2078:80: (iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF )
            // InternalExpressionDsl.g:2079:2: iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyContextInformationReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyContextInformationReferenceExpression=ruleHyContextInformationReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyContextInformationReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyContextInformationReferenceExpression"


    // $ANTLR start "ruleHyContextInformationReferenceExpression"
    // InternalExpressionDsl.g:2085:1: ruleHyContextInformationReferenceExpression returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) ) ;
    public final EObject ruleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2091:2: ( ( (otherlv_0= RULE_STRING ) ) )
            // InternalExpressionDsl.g:2092:2: ( (otherlv_0= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:2092:2: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:2093:3: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:2093:3: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:2094:4: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getHyContextInformationReferenceExpressionRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getHyContextInformationReferenceExpressionAccess().getContextInformationHyContextualInformationCrossReference_0());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyContextInformationReferenceExpression"


    // $ANTLR start "entryRuleHyAttributeReferenceExpression"
    // InternalExpressionDsl.g:2111:1: entryRuleHyAttributeReferenceExpression returns [EObject current=null] : iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF ;
    public final EObject entryRuleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAttributeReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:2111:71: (iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF )
            // InternalExpressionDsl.g:2112:2: iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyAttributeReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyAttributeReferenceExpression=ruleHyAttributeReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyAttributeReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHyAttributeReferenceExpression"


    // $ANTLR start "ruleHyAttributeReferenceExpression"
    // InternalExpressionDsl.g:2118:1: ruleHyAttributeReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2124:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalExpressionDsl.g:2125:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalExpressionDsl.g:2125:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalExpressionDsl.g:2126:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:2126:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:2127:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:2127:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:2128:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyAttributeReferenceExpressionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyAttributeReferenceExpressionAccess().getFeatureHyFeatureCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyAttributeReferenceExpressionAccess().getFullStopKeyword_1());
              		
            }
            // InternalExpressionDsl.g:2146:3: ( (otherlv_2= RULE_STRING ) )
            // InternalExpressionDsl.g:2147:4: (otherlv_2= RULE_STRING )
            {
            // InternalExpressionDsl.g:2147:4: (otherlv_2= RULE_STRING )
            // InternalExpressionDsl.g:2148:5: otherlv_2= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyAttributeReferenceExpressionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getHyAttributeReferenceExpressionAccess().getAttributeHyFeatureAttributeCrossReference_2_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyAttributeReferenceExpression"


    // $ANTLR start "entryRuleEInt"
    // InternalExpressionDsl.g:2166:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalExpressionDsl.g:2166:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalExpressionDsl.g:2167:2: iv_ruleEInt= ruleEInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEIntRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEInt.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalExpressionDsl.g:2173:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2179:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalExpressionDsl.g:2180:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalExpressionDsl.g:2180:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalExpressionDsl.g:2181:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalExpressionDsl.g:2181:3: (kw= '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalExpressionDsl.g:2182:4: kw= '-'
                    {
                    kw=(Token)match(input,23,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                      			
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "ruleHyRelativeVersionRestrictionOperator"
    // InternalExpressionDsl.g:2199:1: ruleHyRelativeVersionRestrictionOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) ;
    public final Enumerator ruleHyRelativeVersionRestrictionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2205:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) )
            // InternalExpressionDsl.g:2206:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            {
            // InternalExpressionDsl.g:2206:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            int alt20=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt20=1;
                }
                break;
            case 27:
                {
                alt20=2;
                }
                break;
            case 28:
                {
                alt20=3;
                }
                break;
            case 26:
                {
                alt20=4;
                }
                break;
            case 24:
                {
                alt20=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalExpressionDsl.g:2207:3: (enumLiteral_0= '<' )
                    {
                    // InternalExpressionDsl.g:2207:3: (enumLiteral_0= '<' )
                    // InternalExpressionDsl.g:2208:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getLessThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:2215:3: (enumLiteral_1= '<=' )
                    {
                    // InternalExpressionDsl.g:2215:3: (enumLiteral_1= '<=' )
                    // InternalExpressionDsl.g:2216:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getLessThanOrEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getLessThanOrEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:2223:3: (enumLiteral_2= '=' )
                    {
                    // InternalExpressionDsl.g:2223:3: (enumLiteral_2= '=' )
                    // InternalExpressionDsl.g:2224:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:2231:3: (enumLiteral_3= '>=' )
                    {
                    // InternalExpressionDsl.g:2231:3: (enumLiteral_3= '>=' )
                    // InternalExpressionDsl.g:2232:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getGreaterThanOrEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getGreaterThanOrEqualEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExpressionDsl.g:2239:3: (enumLiteral_4= '>' )
                    {
                    // InternalExpressionDsl.g:2239:3: (enumLiteral_4= '>' )
                    // InternalExpressionDsl.g:2240:4: enumLiteral_4= '>'
                    {
                    enumLiteral_4=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getGreaterThanEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getHyRelativeVersionRestrictionOperatorAccess().getGreaterThanEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHyRelativeVersionRestrictionOperator"

    // $ANTLR start synpred6_InternalExpressionDsl
    public final void synpred6_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyArithmeticalComparisonExpression_0 = null;


        // InternalExpressionDsl.g:374:3: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) )
        // InternalExpressionDsl.g:374:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
        {
        // InternalExpressionDsl.g:374:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
        // InternalExpressionDsl.g:375:4: ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression
        {
        pushFollow(FOLLOW_2);
        this_HyArithmeticalComparisonExpression_0=ruleHyArithmeticalComparisonExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalExpressionDsl

    // $ANTLR start synpred7_InternalExpressionDsl
    public final void synpred7_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyFeatureReferenceExpression_1 = null;


        // InternalExpressionDsl.g:389:3: (this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression )
        // InternalExpressionDsl.g:389:3: this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyFeatureReferenceExpression_1=ruleHyFeatureReferenceExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalExpressionDsl

    // $ANTLR start synpred8_InternalExpressionDsl
    public final void synpred8_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyNestedExpression_2 = null;


        // InternalExpressionDsl.g:401:3: (this_HyNestedExpression_2= ruleHyNestedExpression )
        // InternalExpressionDsl.g:401:3: this_HyNestedExpression_2= ruleHyNestedExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyNestedExpression_2=ruleHyNestedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalExpressionDsl

    // $ANTLR start synpred17_InternalExpressionDsl
    public final void synpred17_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyGreaterOrEqualExpression_0 = null;


        // InternalExpressionDsl.g:956:3: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression )
        // InternalExpressionDsl.g:956:3: this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyGreaterOrEqualExpression_0=ruleHyGreaterOrEqualExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalExpressionDsl

    // $ANTLR start synpred18_InternalExpressionDsl
    public final void synpred18_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyGreaterExpression_1 = null;


        // InternalExpressionDsl.g:968:3: (this_HyGreaterExpression_1= ruleHyGreaterExpression )
        // InternalExpressionDsl.g:968:3: this_HyGreaterExpression_1= ruleHyGreaterExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyGreaterExpression_1=ruleHyGreaterExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalExpressionDsl

    // $ANTLR start synpred19_InternalExpressionDsl
    public final void synpred19_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyLessOrEqualExpression_2 = null;


        // InternalExpressionDsl.g:980:3: (this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression )
        // InternalExpressionDsl.g:980:3: this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyLessOrEqualExpression_2=ruleHyLessOrEqualExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalExpressionDsl

    // $ANTLR start synpred20_InternalExpressionDsl
    public final void synpred20_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyLessExpression_3 = null;


        // InternalExpressionDsl.g:992:3: (this_HyLessExpression_3= ruleHyLessExpression )
        // InternalExpressionDsl.g:992:3: this_HyLessExpression_3= ruleHyLessExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyLessExpression_3=ruleHyLessExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalExpressionDsl

    // $ANTLR start synpred21_InternalExpressionDsl
    public final void synpred21_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyNotEqualExpression_4 = null;


        // InternalExpressionDsl.g:1004:3: (this_HyNotEqualExpression_4= ruleHyNotEqualExpression )
        // InternalExpressionDsl.g:1004:3: this_HyNotEqualExpression_4= ruleHyNotEqualExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyNotEqualExpression_4=ruleHyNotEqualExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalExpressionDsl

    // $ANTLR start synpred27_InternalExpressionDsl
    public final void synpred27_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyContextInformationReferenceExpression_0 = null;


        // InternalExpressionDsl.g:1700:3: ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression ) )
        // InternalExpressionDsl.g:1700:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression )
        {
        // InternalExpressionDsl.g:1700:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression )
        // InternalExpressionDsl.g:1701:4: ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_0= ruleHyContextInformationReferenceExpression
        {
        pushFollow(FOLLOW_2);
        this_HyContextInformationReferenceExpression_0=ruleHyContextInformationReferenceExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalExpressionDsl

    // $ANTLR start synpred28_InternalExpressionDsl
    public final void synpred28_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject this_HyValueExpression_1 = null;


        // InternalExpressionDsl.g:1715:3: (this_HyValueExpression_1= ruleHyValueExpression )
        // InternalExpressionDsl.g:1715:3: this_HyValueExpression_1= ruleHyValueExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyValueExpression_1=ruleHyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalExpressionDsl

    // Delegated rules

    public final boolean synpred20_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\1\0\2\uffff\3\0\5\uffff";
    static final String dfa_3s = "\1\27\1\0\2\uffff\3\0\5\uffff";
    static final String dfa_4s = "\2\uffff\1\1\4\uffff\1\4\1\5\1\2\1\6\1\3";
    static final String dfa_5s = "\1\uffff\1\0\2\uffff\1\1\1\2\1\3\5\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\2\10\uffff\1\6\1\uffff\1\10\1\7\2\uffff\1\4\1\5\1\2",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "373:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_1 = input.LA(1);

                         
                        int index5_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalExpressionDsl()) ) {s = 2;}

                        else if ( (synpred7_InternalExpressionDsl()) ) {s = 9;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalExpressionDsl()) ) {s = 2;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalExpressionDsl()) ) {s = 2;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalExpressionDsl()) ) {s = 2;}

                        else if ( (synpred8_InternalExpressionDsl()) ) {s = 11;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\15\uffff";
    static final String dfa_8s = "\1\4\6\0\6\uffff";
    static final String dfa_9s = "\1\27\6\0\6\uffff";
    static final String dfa_10s = "\7\uffff\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String dfa_11s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\6\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\1\uffff\1\3\10\uffff\1\6\5\uffff\1\4\1\5\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "955:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalExpressionDsl()) ) {s = 7;}

                        else if ( (synpred18_InternalExpressionDsl()) ) {s = 8;}

                        else if ( (synpred19_InternalExpressionDsl()) ) {s = 9;}

                        else if ( (synpred20_InternalExpressionDsl()) ) {s = 10;}

                        else if ( (synpred21_InternalExpressionDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000E68050L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000480002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000E08050L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});

}