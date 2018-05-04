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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'->'", "'<->'", "'&&'", "'||'", "'('", "')'", "'!'", "'?'", "'['", "']'", "'true'", "'false'", "'-'", "'>'", "'<'", "'>='", "'<='", "'='", "'!='", "'+'", "'*'", "'/'", "'.'"
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
    // InternalExpressionDsl.g:65:1: entryRuleHyExpression returns [EObject current=null] : iv_ruleHyExpression= ruleHyExpression EOF ;
    public final EObject entryRuleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyExpression = null;


        try {
            // InternalExpressionDsl.g:65:53: (iv_ruleHyExpression= ruleHyExpression EOF )
            // InternalExpressionDsl.g:66:2: iv_ruleHyExpression= ruleHyExpression EOF
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
    // InternalExpressionDsl.g:72:1: ruleHyExpression returns [EObject current=null] : this_HyImpliesExpression_0= ruleHyImpliesExpression ;
    public final EObject ruleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyImpliesExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:78:2: (this_HyImpliesExpression_0= ruleHyImpliesExpression )
            // InternalExpressionDsl.g:79:2: this_HyImpliesExpression_0= ruleHyImpliesExpression
            {
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
    // InternalExpressionDsl.g:90:1: entryRuleHyImpliesExpression returns [EObject current=null] : iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF ;
    public final EObject entryRuleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyImpliesExpression = null;


        try {
            // InternalExpressionDsl.g:90:60: (iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF )
            // InternalExpressionDsl.g:91:2: iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF
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
    // InternalExpressionDsl.g:97:1: ruleHyImpliesExpression returns [EObject current=null] : (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) ;
    public final EObject ruleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyEquivalenceExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:103:2: ( (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) )
            // InternalExpressionDsl.g:104:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            {
            // InternalExpressionDsl.g:104:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            // InternalExpressionDsl.g:105:3: this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            {
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
            // InternalExpressionDsl.g:113:3: ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpressionDsl.g:114:4: () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    {
            	    // InternalExpressionDsl.g:114:4: ()
            	    // InternalExpressionDsl.g:115:5: 
            	    {
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
            	    // InternalExpressionDsl.g:125:4: ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    // InternalExpressionDsl.g:126:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    {
            	    // InternalExpressionDsl.g:126:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    // InternalExpressionDsl.g:127:6: lv_operand2_3_0= ruleHyEquivalenceExpression
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
    // InternalExpressionDsl.g:149:1: entryRuleHyEquivalenceExpression returns [EObject current=null] : iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF ;
    public final EObject entryRuleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEquivalenceExpression = null;


        try {
            // InternalExpressionDsl.g:149:64: (iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF )
            // InternalExpressionDsl.g:150:2: iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF
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
    // InternalExpressionDsl.g:156:1: ruleHyEquivalenceExpression returns [EObject current=null] : (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) ;
    public final EObject ruleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyAndExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:162:2: ( (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) )
            // InternalExpressionDsl.g:163:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            {
            // InternalExpressionDsl.g:163:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            // InternalExpressionDsl.g:164:3: this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            {
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
            // InternalExpressionDsl.g:172:3: ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpressionDsl.g:173:4: () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    {
            	    // InternalExpressionDsl.g:173:4: ()
            	    // InternalExpressionDsl.g:174:5: 
            	    {
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
            	    // InternalExpressionDsl.g:184:4: ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    // InternalExpressionDsl.g:185:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    {
            	    // InternalExpressionDsl.g:185:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    // InternalExpressionDsl.g:186:6: lv_operand2_3_0= ruleHyAndExpression
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
    // InternalExpressionDsl.g:208:1: entryRuleHyAndExpression returns [EObject current=null] : iv_ruleHyAndExpression= ruleHyAndExpression EOF ;
    public final EObject entryRuleHyAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAndExpression = null;


        try {
            // InternalExpressionDsl.g:208:56: (iv_ruleHyAndExpression= ruleHyAndExpression EOF )
            // InternalExpressionDsl.g:209:2: iv_ruleHyAndExpression= ruleHyAndExpression EOF
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
    // InternalExpressionDsl.g:215:1: ruleHyAndExpression returns [EObject current=null] : (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) ;
    public final EObject ruleHyAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:221:2: ( (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) )
            // InternalExpressionDsl.g:222:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            {
            // InternalExpressionDsl.g:222:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            // InternalExpressionDsl.g:223:3: this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            {
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
            // InternalExpressionDsl.g:231:3: ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalExpressionDsl.g:232:4: () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    {
            	    // InternalExpressionDsl.g:232:4: ()
            	    // InternalExpressionDsl.g:233:5: 
            	    {
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
            	    // InternalExpressionDsl.g:243:4: ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    // InternalExpressionDsl.g:244:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    {
            	    // InternalExpressionDsl.g:244:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    // InternalExpressionDsl.g:245:6: lv_operand2_3_0= ruleHyOrExpression
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
    // InternalExpressionDsl.g:267:1: entryRuleHyOrExpression returns [EObject current=null] : iv_ruleHyOrExpression= ruleHyOrExpression EOF ;
    public final EObject entryRuleHyOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyOrExpression = null;


        try {
            // InternalExpressionDsl.g:267:55: (iv_ruleHyOrExpression= ruleHyOrExpression EOF )
            // InternalExpressionDsl.g:268:2: iv_ruleHyOrExpression= ruleHyOrExpression EOF
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
    // InternalExpressionDsl.g:274:1: ruleHyOrExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) ;
    public final EObject ruleHyOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:280:2: ( (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) )
            // InternalExpressionDsl.g:281:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            {
            // InternalExpressionDsl.g:281:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            // InternalExpressionDsl.g:282:3: this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            {
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
            // InternalExpressionDsl.g:290:3: ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExpressionDsl.g:291:4: () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    {
            	    // InternalExpressionDsl.g:291:4: ()
            	    // InternalExpressionDsl.g:292:5: 
            	    {
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
            	    // InternalExpressionDsl.g:302:4: ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    // InternalExpressionDsl.g:303:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    {
            	    // InternalExpressionDsl.g:303:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    // InternalExpressionDsl.g:304:6: lv_operand2_3_0= ruleTerminalExpression
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
    // InternalExpressionDsl.g:326:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalExpressionDsl.g:326:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalExpressionDsl.g:327:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
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
    // InternalExpressionDsl.g:333:1: ruleTerminalExpression returns [EObject current=null] : (this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression | this_HyNestedExpression_1= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_3= ruleHyNotExpression | this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression | ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyFeatureReferenceExpression_0 = null;

        EObject this_HyNestedExpression_1 = null;

        EObject this_HyConditionalFeatureReferenceExpression_2 = null;

        EObject this_HyNotExpression_3 = null;

        EObject this_HyBooleanValueExpression_4 = null;

        EObject this_HyArithmeticalComparisonExpression_5 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:339:2: ( (this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression | this_HyNestedExpression_1= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_3= ruleHyNotExpression | this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression | ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression ) ) )
            // InternalExpressionDsl.g:340:2: (this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression | this_HyNestedExpression_1= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_3= ruleHyNotExpression | this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression | ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression ) )
            {
            // InternalExpressionDsl.g:340:2: (this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression | this_HyNestedExpression_1= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_3= ruleHyNotExpression | this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression | ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression ) )
            int alt5=6;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalExpressionDsl.g:341:3: this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyFeatureReferenceExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyFeatureReferenceExpression_0=ruleHyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyFeatureReferenceExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:350:3: this_HyNestedExpression_1= ruleHyNestedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyNestedExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNestedExpression_1=ruleHyNestedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNestedExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:359:3: this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyConditionalFeatureReferenceExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyConditionalFeatureReferenceExpression_2=ruleHyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyConditionalFeatureReferenceExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:368:3: this_HyNotExpression_3= ruleHyNotExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyNotExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNotExpression_3=ruleHyNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNotExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpressionDsl.g:377:3: this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyBooleanValueExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyBooleanValueExpression_4=ruleHyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyBooleanValueExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpressionDsl.g:386:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression )
                    {
                    // InternalExpressionDsl.g:386:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression )
                    // InternalExpressionDsl.g:387:4: ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTerminalExpressionAccess().getHyArithmeticalComparisonExpressionParserRuleCall_5());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_HyArithmeticalComparisonExpression_5=ruleHyArithmeticalComparisonExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_HyArithmeticalComparisonExpression_5;
                      				afterParserOrEnumRuleCall();
                      			
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
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleHyNestedExpression"
    // InternalExpressionDsl.g:401:1: entryRuleHyNestedExpression returns [EObject current=null] : iv_ruleHyNestedExpression= ruleHyNestedExpression EOF ;
    public final EObject entryRuleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedExpression = null;


        try {
            // InternalExpressionDsl.g:401:59: (iv_ruleHyNestedExpression= ruleHyNestedExpression EOF )
            // InternalExpressionDsl.g:402:2: iv_ruleHyNestedExpression= ruleHyNestedExpression EOF
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
    // InternalExpressionDsl.g:408:1: ruleHyNestedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:414:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) )
            // InternalExpressionDsl.g:415:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            {
            // InternalExpressionDsl.g:415:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            // InternalExpressionDsl.g:416:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExpressionDsl.g:420:3: ( (lv_operand_1_0= ruleHyExpression ) )
            // InternalExpressionDsl.g:421:4: (lv_operand_1_0= ruleHyExpression )
            {
            // InternalExpressionDsl.g:421:4: (lv_operand_1_0= ruleHyExpression )
            // InternalExpressionDsl.g:422:5: lv_operand_1_0= ruleHyExpression
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
    // InternalExpressionDsl.g:447:1: entryRuleHyNotExpression returns [EObject current=null] : iv_ruleHyNotExpression= ruleHyNotExpression EOF ;
    public final EObject entryRuleHyNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotExpression = null;


        try {
            // InternalExpressionDsl.g:447:56: (iv_ruleHyNotExpression= ruleHyNotExpression EOF )
            // InternalExpressionDsl.g:448:2: iv_ruleHyNotExpression= ruleHyNotExpression EOF
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
    // InternalExpressionDsl.g:454:1: ruleHyNotExpression returns [EObject current=null] : (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) ;
    public final EObject ruleHyNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:460:2: ( (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) )
            // InternalExpressionDsl.g:461:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            {
            // InternalExpressionDsl.g:461:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            // InternalExpressionDsl.g:462:3: otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNotExpressionAccess().getExclamationMarkKeyword_0());
              		
            }
            // InternalExpressionDsl.g:466:3: ( (lv_operand_1_0= ruleTerminalExpression ) )
            // InternalExpressionDsl.g:467:4: (lv_operand_1_0= ruleTerminalExpression )
            {
            // InternalExpressionDsl.g:467:4: (lv_operand_1_0= ruleTerminalExpression )
            // InternalExpressionDsl.g:468:5: lv_operand_1_0= ruleTerminalExpression
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
    // InternalExpressionDsl.g:489:1: entryRuleHyFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyFeatureReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:489:69: (iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF )
            // InternalExpressionDsl.g:490:2: iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF
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
    // InternalExpressionDsl.g:496:1: ruleHyFeatureReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_versionRestriction_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:502:2: ( ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) )
            // InternalExpressionDsl.g:503:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            {
            // InternalExpressionDsl.g:503:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            // InternalExpressionDsl.g:504:3: ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            {
            // InternalExpressionDsl.g:504:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:505:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:505:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:506:5: otherlv_0= RULE_STRING
            {
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

            // InternalExpressionDsl.g:517:3: ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19||LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalExpressionDsl.g:518:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    {
                    // InternalExpressionDsl.g:518:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    // InternalExpressionDsl.g:519:5: lv_versionRestriction_1_0= ruleHyVersionRestriction
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
    // InternalExpressionDsl.g:540:1: entryRuleHyConditionalFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyConditionalFeatureReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:540:80: (iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF )
            // InternalExpressionDsl.g:541:2: iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF
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
    // InternalExpressionDsl.g:547:1: ruleHyConditionalFeatureReferenceExpression returns [EObject current=null] : (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_versionRestriction_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:553:2: ( (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) )
            // InternalExpressionDsl.g:554:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            {
            // InternalExpressionDsl.g:554:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            // InternalExpressionDsl.g:555:3: otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getQuestionMarkKeyword_0());
              		
            }
            // InternalExpressionDsl.g:559:3: ( (otherlv_1= RULE_STRING ) )
            // InternalExpressionDsl.g:560:4: (otherlv_1= RULE_STRING )
            {
            // InternalExpressionDsl.g:560:4: (otherlv_1= RULE_STRING )
            // InternalExpressionDsl.g:561:5: otherlv_1= RULE_STRING
            {
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

            // InternalExpressionDsl.g:572:3: ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19||LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalExpressionDsl.g:573:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    {
                    // InternalExpressionDsl.g:573:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    // InternalExpressionDsl.g:574:5: lv_versionRestriction_2_0= ruleHyVersionRestriction
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
    // InternalExpressionDsl.g:595:1: entryRuleHyVersionRestriction returns [EObject current=null] : iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF ;
    public final EObject entryRuleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRestriction = null;


        try {
            // InternalExpressionDsl.g:595:61: (iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF )
            // InternalExpressionDsl.g:596:2: iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF
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
    // InternalExpressionDsl.g:602:1: ruleHyVersionRestriction returns [EObject current=null] : (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) ;
    public final EObject ruleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject this_HyRelativeVersionRestriction_0 = null;

        EObject this_HyVersionRangeRestriction_1 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:608:2: ( (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) )
            // InternalExpressionDsl.g:609:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
            {
            // InternalExpressionDsl.g:609:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
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
                    // InternalExpressionDsl.g:610:3: this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction
                    {
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
                    // InternalExpressionDsl.g:619:3: this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction
                    {
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
    // InternalExpressionDsl.g:631:1: entryRuleHyRelativeVersionRestriction returns [EObject current=null] : iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF ;
    public final EObject entryRuleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyRelativeVersionRestriction = null;


        try {
            // InternalExpressionDsl.g:631:69: (iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF )
            // InternalExpressionDsl.g:632:2: iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF
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
    // InternalExpressionDsl.g:638:1: ruleHyRelativeVersionRestriction returns [EObject current=null] : (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) ;
    public final EObject ruleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:644:2: ( (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) )
            // InternalExpressionDsl.g:645:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            {
            // InternalExpressionDsl.g:645:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            // InternalExpressionDsl.g:646:3: otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyRelativeVersionRestrictionAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalExpressionDsl.g:650:3: ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) )
            // InternalExpressionDsl.g:651:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            {
            // InternalExpressionDsl.g:651:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            // InternalExpressionDsl.g:652:5: lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator
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

            // InternalExpressionDsl.g:669:3: ( (otherlv_2= RULE_ID ) )
            // InternalExpressionDsl.g:670:4: (otherlv_2= RULE_ID )
            {
            // InternalExpressionDsl.g:670:4: (otherlv_2= RULE_ID )
            // InternalExpressionDsl.g:671:5: otherlv_2= RULE_ID
            {
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
    // InternalExpressionDsl.g:690:1: entryRuleHyVersionRangeRestriction returns [EObject current=null] : iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF ;
    public final EObject entryRuleHyVersionRangeRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRangeRestriction = null;


        try {
            // InternalExpressionDsl.g:690:66: (iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF )
            // InternalExpressionDsl.g:691:2: iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF
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
    // InternalExpressionDsl.g:697:1: ruleHyVersionRangeRestriction returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) ;
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
            // InternalExpressionDsl.g:703:2: ( ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) )
            // InternalExpressionDsl.g:704:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            {
            // InternalExpressionDsl.g:704:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==RULE_STRING) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==20) ) {
                        alt9=3;
                    }
                    else if ( (LA9_3==23) ) {
                        alt9=2;
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
                    // InternalExpressionDsl.g:705:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    {
                    // InternalExpressionDsl.g:705:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    // InternalExpressionDsl.g:706:4: otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) )
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getHyVersionRangeRestrictionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalExpressionDsl.g:710:4: ( (lv_lowerIncluded_1_0= 'true' ) )
                    // InternalExpressionDsl.g:711:5: (lv_lowerIncluded_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:711:5: (lv_lowerIncluded_1_0= 'true' )
                    // InternalExpressionDsl.g:712:6: lv_lowerIncluded_1_0= 'true'
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
                    // InternalExpressionDsl.g:726:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    {
                    // InternalExpressionDsl.g:726:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    // InternalExpressionDsl.g:727:4: otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_1_0());
                      			
                    }
                    // InternalExpressionDsl.g:731:4: ( (otherlv_3= RULE_STRING ) )
                    // InternalExpressionDsl.g:732:5: (otherlv_3= RULE_STRING )
                    {
                    // InternalExpressionDsl.g:732:5: (otherlv_3= RULE_STRING )
                    // InternalExpressionDsl.g:733:6: otherlv_3= RULE_STRING
                    {
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
                    // InternalExpressionDsl.g:748:4: ( (lv_upperIncluded_5_0= 'true' ) )
                    // InternalExpressionDsl.g:749:5: (lv_upperIncluded_5_0= 'true' )
                    {
                    // InternalExpressionDsl.g:749:5: (lv_upperIncluded_5_0= 'true' )
                    // InternalExpressionDsl.g:750:6: lv_upperIncluded_5_0= 'true'
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
                    // InternalExpressionDsl.g:764:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    {
                    // InternalExpressionDsl.g:764:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    // InternalExpressionDsl.g:765:4: otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_2_0());
                      			
                    }
                    // InternalExpressionDsl.g:769:4: ( (otherlv_7= RULE_STRING ) )
                    // InternalExpressionDsl.g:770:5: (otherlv_7= RULE_STRING )
                    {
                    // InternalExpressionDsl.g:770:5: (otherlv_7= RULE_STRING )
                    // InternalExpressionDsl.g:771:6: otherlv_7= RULE_STRING
                    {
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
    // InternalExpressionDsl.g:791:1: entryRuleHyBooleanValueExpression returns [EObject current=null] : iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF ;
    public final EObject entryRuleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValueExpression = null;


        try {
            // InternalExpressionDsl.g:791:65: (iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF )
            // InternalExpressionDsl.g:792:2: iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF
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
    // InternalExpressionDsl.g:798:1: ruleHyBooleanValueExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:804:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalExpressionDsl.g:805:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalExpressionDsl.g:805:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalExpressionDsl.g:806:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalExpressionDsl.g:806:3: ()
            // InternalExpressionDsl.g:807:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHyBooleanValueExpressionAccess().getHyBooleanValueExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalExpressionDsl.g:813:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
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
                    // InternalExpressionDsl.g:814:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalExpressionDsl.g:814:4: ( (lv_value_1_0= 'true' ) )
                    // InternalExpressionDsl.g:815:5: (lv_value_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:815:5: (lv_value_1_0= 'true' )
                    // InternalExpressionDsl.g:816:6: lv_value_1_0= 'true'
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
                    // InternalExpressionDsl.g:829:4: otherlv_2= 'false'
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
    // InternalExpressionDsl.g:838:1: entryRuleHyArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalComparisonExpression = null;


        try {
            // InternalExpressionDsl.g:838:75: (iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF )
            // InternalExpressionDsl.g:839:2: iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF
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
    // InternalExpressionDsl.g:845:1: ruleHyArithmeticalComparisonExpression returns [EObject current=null] : this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression ;
    public final EObject ruleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyBinaryArithmeticalComparisonExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:851:2: (this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression )
            // InternalExpressionDsl.g:852:2: this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression
            {
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
    // InternalExpressionDsl.g:863:1: entryRuleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyBinaryArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBinaryArithmeticalComparisonExpression = null;


        try {
            // InternalExpressionDsl.g:863:81: (iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF )
            // InternalExpressionDsl.g:864:2: iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF
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
    // InternalExpressionDsl.g:870:1: ruleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : this_HyGreaterExpression_0= ruleHyGreaterExpression ;
    public final EObject ruleHyBinaryArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyGreaterExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:876:2: (this_HyGreaterExpression_0= ruleHyGreaterExpression )
            // InternalExpressionDsl.g:877:2: this_HyGreaterExpression_0= ruleHyGreaterExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getHyBinaryArithmeticalComparisonExpressionAccess().getHyGreaterExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_HyGreaterExpression_0=ruleHyGreaterExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_HyGreaterExpression_0;
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
    // $ANTLR end "ruleHyBinaryArithmeticalComparisonExpression"


    // $ANTLR start "entryRuleHyGreaterExpression"
    // InternalExpressionDsl.g:888:1: entryRuleHyGreaterExpression returns [EObject current=null] : iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF ;
    public final EObject entryRuleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterExpression = null;


        try {
            // InternalExpressionDsl.g:888:60: (iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF )
            // InternalExpressionDsl.g:889:2: iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF
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
    // InternalExpressionDsl.g:895:1: ruleHyGreaterExpression returns [EObject current=null] : ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessExpression_3= ruleHyLessExpression ) ;
    public final EObject ruleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject this_HyLessExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:901:2: ( ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessExpression_3= ruleHyLessExpression ) )
            // InternalExpressionDsl.g:902:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessExpression_3= ruleHyLessExpression )
            {
            // InternalExpressionDsl.g:902:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessExpression_3= ruleHyLessExpression )
            int alt11=2;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA11_1 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA11_2 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                int LA11_3 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA11_4 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA11_5 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 5, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA11_6 = input.LA(2);

                if ( (synpred2_InternalExpressionDsl()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalExpressionDsl.g:903:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    {
                    // InternalExpressionDsl.g:903:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    // InternalExpressionDsl.g:904:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    {
                    // InternalExpressionDsl.g:904:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:905:5: ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:909:5: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:910:6: lv_operand1_0_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0_0());
                      					
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

                      				newLeafNode(otherlv_1, grammarAccess.getHyGreaterExpressionAccess().getGreaterThanSignKeyword_0_1());
                      			
                    }
                    // InternalExpressionDsl.g:931:4: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:932:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:932:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:933:6: lv_operand2_2_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_0_2_0());
                      					
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
                    break;
                case 2 :
                    // InternalExpressionDsl.g:952:3: this_HyLessExpression_3= ruleHyLessExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getHyLessExpressionParserRuleCall_1());
                      		
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
    // InternalExpressionDsl.g:964:1: entryRuleHyLessExpression returns [EObject current=null] : iv_ruleHyLessExpression= ruleHyLessExpression EOF ;
    public final EObject entryRuleHyLessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessExpression = null;


        try {
            // InternalExpressionDsl.g:964:57: (iv_ruleHyLessExpression= ruleHyLessExpression EOF )
            // InternalExpressionDsl.g:965:2: iv_ruleHyLessExpression= ruleHyLessExpression EOF
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
    // InternalExpressionDsl.g:971:1: ruleHyLessExpression returns [EObject current=null] : ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyGreaterOrEqualExpression_3= ruleHyGreaterOrEqualExpression ) ;
    public final EObject ruleHyLessExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject this_HyGreaterOrEqualExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:977:2: ( ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyGreaterOrEqualExpression_3= ruleHyGreaterOrEqualExpression ) )
            // InternalExpressionDsl.g:978:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyGreaterOrEqualExpression_3= ruleHyGreaterOrEqualExpression )
            {
            // InternalExpressionDsl.g:978:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyGreaterOrEqualExpression_3= ruleHyGreaterOrEqualExpression )
            int alt12=2;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA12_1 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA12_2 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                int LA12_3 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA12_4 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA12_5 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 5, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA12_6 = input.LA(2);

                if ( (synpred3_InternalExpressionDsl()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalExpressionDsl.g:979:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    {
                    // InternalExpressionDsl.g:979:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    // InternalExpressionDsl.g:980:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    {
                    // InternalExpressionDsl.g:980:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:981:5: ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:985:5: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:986:6: lv_operand1_0_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyLessExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0_0());
                      					
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

                      				newLeafNode(otherlv_1, grammarAccess.getHyLessExpressionAccess().getLessThanSignKeyword_0_1());
                      			
                    }
                    // InternalExpressionDsl.g:1007:4: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1008:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1008:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1009:6: lv_operand2_2_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyLessExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_0_2_0());
                      					
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
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1028:3: this_HyGreaterOrEqualExpression_3= ruleHyGreaterOrEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyLessExpressionAccess().getHyGreaterOrEqualExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyGreaterOrEqualExpression_3=ruleHyGreaterOrEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyGreaterOrEqualExpression_3;
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
    // $ANTLR end "ruleHyLessExpression"


    // $ANTLR start "entryRuleHyGreaterOrEqualExpression"
    // InternalExpressionDsl.g:1040:1: entryRuleHyGreaterOrEqualExpression returns [EObject current=null] : iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF ;
    public final EObject entryRuleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterOrEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1040:67: (iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF )
            // InternalExpressionDsl.g:1041:2: iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF
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
    // InternalExpressionDsl.g:1047:1: ruleHyGreaterOrEqualExpression returns [EObject current=null] : ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessOrEqualExpression_3= ruleHyLessOrEqualExpression ) ;
    public final EObject ruleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject this_HyLessOrEqualExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1053:2: ( ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessOrEqualExpression_3= ruleHyLessOrEqualExpression ) )
            // InternalExpressionDsl.g:1054:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessOrEqualExpression_3= ruleHyLessOrEqualExpression )
            {
            // InternalExpressionDsl.g:1054:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyLessOrEqualExpression_3= ruleHyLessOrEqualExpression )
            int alt13=2;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA13_1 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA13_2 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                int LA13_3 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA13_4 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 4, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA13_5 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 5, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA13_6 = input.LA(2);

                if ( (synpred4_InternalExpressionDsl()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalExpressionDsl.g:1055:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    {
                    // InternalExpressionDsl.g:1055:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    // InternalExpressionDsl.g:1056:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    {
                    // InternalExpressionDsl.g:1056:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1057:5: ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1061:5: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1062:6: lv_operand1_0_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0_0());
                      					
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

                      				newLeafNode(otherlv_1, grammarAccess.getHyGreaterOrEqualExpressionAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                      			
                    }
                    // InternalExpressionDsl.g:1083:4: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1084:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1084:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1085:6: lv_operand2_2_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_0_2_0());
                      					
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
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1104:3: this_HyLessOrEqualExpression_3= ruleHyLessOrEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getHyLessOrEqualExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyLessOrEqualExpression_3=ruleHyLessOrEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyLessOrEqualExpression_3;
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
    // $ANTLR end "ruleHyGreaterOrEqualExpression"


    // $ANTLR start "entryRuleHyLessOrEqualExpression"
    // InternalExpressionDsl.g:1116:1: entryRuleHyLessOrEqualExpression returns [EObject current=null] : iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF ;
    public final EObject entryRuleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessOrEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1116:64: (iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF )
            // InternalExpressionDsl.g:1117:2: iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF
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
    // InternalExpressionDsl.g:1123:1: ruleHyLessOrEqualExpression returns [EObject current=null] : ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyEqualExpression_3= ruleHyEqualExpression ) ;
    public final EObject ruleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject this_HyEqualExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1129:2: ( ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyEqualExpression_3= ruleHyEqualExpression ) )
            // InternalExpressionDsl.g:1130:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyEqualExpression_3= ruleHyEqualExpression )
            {
            // InternalExpressionDsl.g:1130:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyEqualExpression_3= ruleHyEqualExpression )
            int alt14=2;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA14_1 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA14_2 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                int LA14_3 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA14_4 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA14_5 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA14_6 = input.LA(2);

                if ( (synpred5_InternalExpressionDsl()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalExpressionDsl.g:1131:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    {
                    // InternalExpressionDsl.g:1131:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    // InternalExpressionDsl.g:1132:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    {
                    // InternalExpressionDsl.g:1132:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1133:5: ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1137:5: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1138:6: lv_operand1_0_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0_0());
                      					
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

                      				newLeafNode(otherlv_1, grammarAccess.getHyLessOrEqualExpressionAccess().getLessThanSignEqualsSignKeyword_0_1());
                      			
                    }
                    // InternalExpressionDsl.g:1159:4: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1160:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1160:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1161:6: lv_operand2_2_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_0_2_0());
                      					
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
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1180:3: this_HyEqualExpression_3= ruleHyEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getHyEqualExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyEqualExpression_3=ruleHyEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyEqualExpression_3;
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
    // $ANTLR end "ruleHyLessOrEqualExpression"


    // $ANTLR start "entryRuleHyEqualExpression"
    // InternalExpressionDsl.g:1192:1: entryRuleHyEqualExpression returns [EObject current=null] : iv_ruleHyEqualExpression= ruleHyEqualExpression EOF ;
    public final EObject entryRuleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1192:58: (iv_ruleHyEqualExpression= ruleHyEqualExpression EOF )
            // InternalExpressionDsl.g:1193:2: iv_ruleHyEqualExpression= ruleHyEqualExpression EOF
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
    // InternalExpressionDsl.g:1199:1: ruleHyEqualExpression returns [EObject current=null] : ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyNotEqualExpression_3= ruleHyNotEqualExpression ) ;
    public final EObject ruleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject this_HyNotEqualExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1205:2: ( ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyNotEqualExpression_3= ruleHyNotEqualExpression ) )
            // InternalExpressionDsl.g:1206:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyNotEqualExpression_3= ruleHyNotEqualExpression )
            {
            // InternalExpressionDsl.g:1206:2: ( ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) | this_HyNotEqualExpression_3= ruleHyNotEqualExpression )
            int alt15=2;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA15_1 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA15_2 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                int LA15_3 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA15_4 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 4, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA15_5 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 5, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA15_6 = input.LA(2);

                if ( (synpred6_InternalExpressionDsl()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalExpressionDsl.g:1207:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    {
                    // InternalExpressionDsl.g:1207:3: ( ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
                    // InternalExpressionDsl.g:1208:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    {
                    // InternalExpressionDsl.g:1208:4: ( ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1209:5: ( ( ruleHyArithmeticalValueExpression ) )=> (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1213:5: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1214:6: lv_operand1_0_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0_0());
                      					
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

                      				newLeafNode(otherlv_1, grammarAccess.getHyEqualExpressionAccess().getEqualsSignKeyword_0_1());
                      			
                    }
                    // InternalExpressionDsl.g:1235:4: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
                    // InternalExpressionDsl.g:1236:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    {
                    // InternalExpressionDsl.g:1236:5: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
                    // InternalExpressionDsl.g:1237:6: lv_operand2_2_0= ruleHyArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getOperand2HyArithmeticalValueExpressionParserRuleCall_0_2_0());
                      					
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
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1256:3: this_HyNotEqualExpression_3= ruleHyNotEqualExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getHyNotEqualExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNotEqualExpression_3=ruleHyNotEqualExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNotEqualExpression_3;
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
    // $ANTLR end "ruleHyEqualExpression"


    // $ANTLR start "entryRuleHyNotEqualExpression"
    // InternalExpressionDsl.g:1268:1: entryRuleHyNotEqualExpression returns [EObject current=null] : iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF ;
    public final EObject entryRuleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotEqualExpression = null;


        try {
            // InternalExpressionDsl.g:1268:61: (iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF )
            // InternalExpressionDsl.g:1269:2: iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF
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
    // InternalExpressionDsl.g:1275:1: ruleHyNotEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1281:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalExpressionDsl.g:1282:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalExpressionDsl.g:1282:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalExpressionDsl.g:1283:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalExpressionDsl.g:1283:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1284:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1284:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1285:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
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
            // InternalExpressionDsl.g:1306:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1307:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1307:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1308:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalExpressionDsl.g:1329:1: entryRuleHyArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalValueExpression = null;


        try {
            // InternalExpressionDsl.g:1329:70: (iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF )
            // InternalExpressionDsl.g:1330:2: iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF
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
    // InternalExpressionDsl.g:1336:1: ruleHyArithmeticalValueExpression returns [EObject current=null] : this_HyAdditionExpression_0= ruleHyAdditionExpression ;
    public final EObject ruleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyAdditionExpression_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1342:2: (this_HyAdditionExpression_0= ruleHyAdditionExpression )
            // InternalExpressionDsl.g:1343:2: this_HyAdditionExpression_0= ruleHyAdditionExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getHyArithmeticalValueExpressionAccess().getHyAdditionExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_HyAdditionExpression_0=ruleHyAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_HyAdditionExpression_0;
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


    // $ANTLR start "entryRuleHyAdditionExpression"
    // InternalExpressionDsl.g:1354:1: entryRuleHyAdditionExpression returns [EObject current=null] : iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF ;
    public final EObject entryRuleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAdditionExpression = null;


        try {
            // InternalExpressionDsl.g:1354:61: (iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF )
            // InternalExpressionDsl.g:1355:2: iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF
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
    // InternalExpressionDsl.g:1361:1: ruleHyAdditionExpression returns [EObject current=null] : (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) ;
    public final EObject ruleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HySubtractionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1367:2: ( (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) )
            // InternalExpressionDsl.g:1368:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1368:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            // InternalExpressionDsl.g:1369:3: this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getHySubtractionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_HySubtractionExpression_0=ruleHySubtractionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HySubtractionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1377:3: ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==30) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalExpressionDsl.g:1378:4: () otherlv_2= '+' ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1378:4: ()
            	    // InternalExpressionDsl.g:1379:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyAdditionExpressionAccess().getHyAdditionExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyAdditionExpressionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1389:4: ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    // InternalExpressionDsl.g:1390:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    {
            	    // InternalExpressionDsl.g:1390:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    // InternalExpressionDsl.g:1391:6: lv_operand2_3_0= ruleHySubtractionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getOperand2HySubtractionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_operand2_3_0=ruleHySubtractionExpression();

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
            	      							"de.darwinspl.ExpressionDsl.HySubtractionExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
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


    // $ANTLR start "entryRuleHySubtractionExpression"
    // InternalExpressionDsl.g:1413:1: entryRuleHySubtractionExpression returns [EObject current=null] : iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF ;
    public final EObject entryRuleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHySubtractionExpression = null;


        try {
            // InternalExpressionDsl.g:1413:64: (iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF )
            // InternalExpressionDsl.g:1414:2: iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF
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
    // InternalExpressionDsl.g:1420:1: ruleHySubtractionExpression returns [EObject current=null] : (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) ;
    public final EObject ruleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyMultiplicationExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1426:2: ( (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) )
            // InternalExpressionDsl.g:1427:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1427:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            // InternalExpressionDsl.g:1428:3: this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getHyMultiplicationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_HyMultiplicationExpression_0=ruleHyMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyMultiplicationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1436:3: ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalExpressionDsl.g:1437:4: () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1437:4: ()
            	    // InternalExpressionDsl.g:1438:5: 
            	    {
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
            	    // InternalExpressionDsl.g:1448:4: ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    // InternalExpressionDsl.g:1449:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    {
            	    // InternalExpressionDsl.g:1449:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    // InternalExpressionDsl.g:1450:6: lv_operand2_3_0= ruleHyMultiplicationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getOperand2HyMultiplicationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_operand2_3_0=ruleHyMultiplicationExpression();

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
            	      							"de.darwinspl.ExpressionDsl.HyMultiplicationExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
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


    // $ANTLR start "entryRuleHyMultiplicationExpression"
    // InternalExpressionDsl.g:1472:1: entryRuleHyMultiplicationExpression returns [EObject current=null] : iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF ;
    public final EObject entryRuleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyMultiplicationExpression = null;


        try {
            // InternalExpressionDsl.g:1472:67: (iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF )
            // InternalExpressionDsl.g:1473:2: iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF
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
    // InternalExpressionDsl.g:1479:1: ruleHyMultiplicationExpression returns [EObject current=null] : (this_HyDivisionExpression_0= ruleHyDivisionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )* ) ;
    public final EObject ruleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyDivisionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1485:2: ( (this_HyDivisionExpression_0= ruleHyDivisionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )* ) )
            // InternalExpressionDsl.g:1486:2: (this_HyDivisionExpression_0= ruleHyDivisionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1486:2: (this_HyDivisionExpression_0= ruleHyDivisionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )* )
            // InternalExpressionDsl.g:1487:3: this_HyDivisionExpression_0= ruleHyDivisionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getHyDivisionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_HyDivisionExpression_0=ruleHyDivisionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyDivisionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1495:3: ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalExpressionDsl.g:1496:4: () otherlv_2= '*' ( (lv_operand2_3_0= ruleHyDivisionExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1496:4: ()
            	    // InternalExpressionDsl.g:1497:5: 
            	    {
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
            	    // InternalExpressionDsl.g:1507:4: ( (lv_operand2_3_0= ruleHyDivisionExpression ) )
            	    // InternalExpressionDsl.g:1508:5: (lv_operand2_3_0= ruleHyDivisionExpression )
            	    {
            	    // InternalExpressionDsl.g:1508:5: (lv_operand2_3_0= ruleHyDivisionExpression )
            	    // InternalExpressionDsl.g:1509:6: lv_operand2_3_0= ruleHyDivisionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getOperand2HyDivisionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_operand2_3_0=ruleHyDivisionExpression();

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
            	      							"de.darwinspl.ExpressionDsl.HyDivisionExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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


    // $ANTLR start "entryRuleHyDivisionExpression"
    // InternalExpressionDsl.g:1531:1: entryRuleHyDivisionExpression returns [EObject current=null] : iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF ;
    public final EObject entryRuleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyDivisionExpression = null;


        try {
            // InternalExpressionDsl.g:1531:61: (iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF )
            // InternalExpressionDsl.g:1532:2: iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF
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
    // InternalExpressionDsl.g:1538:1: ruleHyDivisionExpression returns [EObject current=null] : (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) ;
    public final EObject ruleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalArithmeticalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1544:2: ( (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) )
            // InternalExpressionDsl.g:1545:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            {
            // InternalExpressionDsl.g:1545:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            // InternalExpressionDsl.g:1546:3: this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getTerminalArithmeticalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_TerminalArithmeticalExpression_0=ruleTerminalArithmeticalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TerminalArithmeticalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpressionDsl.g:1554:3: ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalExpressionDsl.g:1555:4: () otherlv_2= '/' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    {
            	    // InternalExpressionDsl.g:1555:4: ()
            	    // InternalExpressionDsl.g:1556:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getHyDivisionExpressionAccess().getHyDivisionExpressionOperand1Action_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyDivisionExpressionAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalExpressionDsl.g:1566:4: ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    // InternalExpressionDsl.g:1567:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    {
            	    // InternalExpressionDsl.g:1567:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    // InternalExpressionDsl.g:1568:6: lv_operand2_3_0= ruleTerminalArithmeticalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getOperand2TerminalArithmeticalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_operand2_3_0=ruleTerminalArithmeticalExpression();

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
            	      							"de.darwinspl.ExpressionDsl.TerminalArithmeticalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
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


    // $ANTLR start "entryRuleTerminalArithmeticalExpression"
    // InternalExpressionDsl.g:1590:1: entryRuleTerminalArithmeticalExpression returns [EObject current=null] : iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF ;
    public final EObject entryRuleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalArithmeticalExpression = null;


        try {
            // InternalExpressionDsl.g:1590:71: (iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF )
            // InternalExpressionDsl.g:1591:2: iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF
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
    // InternalExpressionDsl.g:1597:1: ruleTerminalArithmeticalExpression returns [EObject current=null] : (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) ;
    public final EObject ruleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyValueExpression_0 = null;

        EObject this_HyNestedArithmeticalValueExpression_1 = null;

        EObject this_HyContextInformationReferenceExpression_2 = null;

        EObject this_HyAttributeReferenceExpression_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1603:2: ( (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) )
            // InternalExpressionDsl.g:1604:2: (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            {
            // InternalExpressionDsl.g:1604:2: (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            int alt20=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 21:
            case 22:
            case 23:
                {
                alt20=1;
                }
                break;
            case RULE_STRING:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==33) ) {
                    alt20=4;
                }
                else if ( (true) ) {
                    alt20=1;
                }
                else if ( (synpred7_InternalExpressionDsl()) ) {
                    alt20=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt20=2;
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
                    // InternalExpressionDsl.g:1605:3: this_HyValueExpression_0= ruleHyValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyValueExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyValueExpression_0=ruleHyValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyValueExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpressionDsl.g:1614:3: this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyNestedArithmeticalValueExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HyNestedArithmeticalValueExpression_1=ruleHyNestedArithmeticalValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HyNestedArithmeticalValueExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpressionDsl.g:1623:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
                    {
                    // InternalExpressionDsl.g:1623:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
                    // InternalExpressionDsl.g:1624:4: ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTerminalArithmeticalExpressionAccess().getHyContextInformationReferenceExpressionParserRuleCall_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_HyContextInformationReferenceExpression_2=ruleHyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_HyContextInformationReferenceExpression_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExpressionDsl.g:1635:3: this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression
                    {
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
    // InternalExpressionDsl.g:1647:1: entryRuleHyValueExpression returns [EObject current=null] : iv_ruleHyValueExpression= ruleHyValueExpression EOF ;
    public final EObject entryRuleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValueExpression = null;


        try {
            // InternalExpressionDsl.g:1647:58: (iv_ruleHyValueExpression= ruleHyValueExpression EOF )
            // InternalExpressionDsl.g:1648:2: iv_ruleHyValueExpression= ruleHyValueExpression EOF
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
    // InternalExpressionDsl.g:1654:1: ruleHyValueExpression returns [EObject current=null] : ( (lv_value_0_0= ruleHyValue ) ) ;
    public final EObject ruleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1660:2: ( ( (lv_value_0_0= ruleHyValue ) ) )
            // InternalExpressionDsl.g:1661:2: ( (lv_value_0_0= ruleHyValue ) )
            {
            // InternalExpressionDsl.g:1661:2: ( (lv_value_0_0= ruleHyValue ) )
            // InternalExpressionDsl.g:1662:3: (lv_value_0_0= ruleHyValue )
            {
            // InternalExpressionDsl.g:1662:3: (lv_value_0_0= ruleHyValue )
            // InternalExpressionDsl.g:1663:4: lv_value_0_0= ruleHyValue
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
    // InternalExpressionDsl.g:1683:1: entryRuleHyValue returns [EObject current=null] : iv_ruleHyValue= ruleHyValue EOF ;
    public final EObject entryRuleHyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValue = null;


        try {
            // InternalExpressionDsl.g:1683:48: (iv_ruleHyValue= ruleHyValue EOF )
            // InternalExpressionDsl.g:1684:2: iv_ruleHyValue= ruleHyValue EOF
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
    // InternalExpressionDsl.g:1690:1: ruleHyValue returns [EObject current=null] : (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) ;
    public final EObject ruleHyValue() throws RecognitionException {
        EObject current = null;

        EObject this_HyNumberValue_0 = null;

        EObject this_HyStringValue_1 = null;

        EObject this_HyBooleanValue_2 = null;

        EObject this_HyEnumValue_3 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1696:2: ( (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) )
            // InternalExpressionDsl.g:1697:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            {
            // InternalExpressionDsl.g:1697:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            int alt21=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 23:
                {
                alt21=1;
                }
                break;
            case RULE_STRING:
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==EOF||(LA21_2>=11 && LA21_2<=14)||LA21_2==16||(LA21_2>=23 && LA21_2<=32)) ) {
                    alt21=2;
                }
                else if ( (LA21_2==33) ) {
                    alt21=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case 21:
            case 22:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalExpressionDsl.g:1698:3: this_HyNumberValue_0= ruleHyNumberValue
                    {
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
                    // InternalExpressionDsl.g:1707:3: this_HyStringValue_1= ruleHyStringValue
                    {
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
                    // InternalExpressionDsl.g:1716:3: this_HyBooleanValue_2= ruleHyBooleanValue
                    {
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
                    // InternalExpressionDsl.g:1725:3: this_HyEnumValue_3= ruleHyEnumValue
                    {
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
    // InternalExpressionDsl.g:1737:1: entryRuleHyNumberValue returns [EObject current=null] : iv_ruleHyNumberValue= ruleHyNumberValue EOF ;
    public final EObject entryRuleHyNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNumberValue = null;


        try {
            // InternalExpressionDsl.g:1737:54: (iv_ruleHyNumberValue= ruleHyNumberValue EOF )
            // InternalExpressionDsl.g:1738:2: iv_ruleHyNumberValue= ruleHyNumberValue EOF
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
    // InternalExpressionDsl.g:1744:1: ruleHyNumberValue returns [EObject current=null] : ( (lv_value_0_0= ruleEInt ) ) ;
    public final EObject ruleHyNumberValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1750:2: ( ( (lv_value_0_0= ruleEInt ) ) )
            // InternalExpressionDsl.g:1751:2: ( (lv_value_0_0= ruleEInt ) )
            {
            // InternalExpressionDsl.g:1751:2: ( (lv_value_0_0= ruleEInt ) )
            // InternalExpressionDsl.g:1752:3: (lv_value_0_0= ruleEInt )
            {
            // InternalExpressionDsl.g:1752:3: (lv_value_0_0= ruleEInt )
            // InternalExpressionDsl.g:1753:4: lv_value_0_0= ruleEInt
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
    // InternalExpressionDsl.g:1773:1: entryRuleHyStringValue returns [EObject current=null] : iv_ruleHyStringValue= ruleHyStringValue EOF ;
    public final EObject entryRuleHyStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyStringValue = null;


        try {
            // InternalExpressionDsl.g:1773:54: (iv_ruleHyStringValue= ruleHyStringValue EOF )
            // InternalExpressionDsl.g:1774:2: iv_ruleHyStringValue= ruleHyStringValue EOF
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
    // InternalExpressionDsl.g:1780:1: ruleHyStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleHyStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1786:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1787:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1787:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1788:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1788:3: (lv_value_0_0= RULE_STRING )
            // InternalExpressionDsl.g:1789:4: lv_value_0_0= RULE_STRING
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
    // InternalExpressionDsl.g:1808:1: entryRuleHyBooleanValue returns [EObject current=null] : iv_ruleHyBooleanValue= ruleHyBooleanValue EOF ;
    public final EObject entryRuleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValue = null;


        try {
            // InternalExpressionDsl.g:1808:55: (iv_ruleHyBooleanValue= ruleHyBooleanValue EOF )
            // InternalExpressionDsl.g:1809:2: iv_ruleHyBooleanValue= ruleHyBooleanValue EOF
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
    // InternalExpressionDsl.g:1815:1: ruleHyBooleanValue returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1821:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalExpressionDsl.g:1822:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalExpressionDsl.g:1822:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalExpressionDsl.g:1823:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalExpressionDsl.g:1823:3: ()
            // InternalExpressionDsl.g:1824:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHyBooleanValueAccess().getHyBooleanValueAction_0(),
              					current);
              			
            }

            }

            // InternalExpressionDsl.g:1830:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==21) ) {
                alt22=1;
            }
            else if ( (LA22_0==22) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalExpressionDsl.g:1831:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalExpressionDsl.g:1831:4: ( (lv_value_1_0= 'true' ) )
                    // InternalExpressionDsl.g:1832:5: (lv_value_1_0= 'true' )
                    {
                    // InternalExpressionDsl.g:1832:5: (lv_value_1_0= 'true' )
                    // InternalExpressionDsl.g:1833:6: lv_value_1_0= 'true'
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
                    // InternalExpressionDsl.g:1846:4: otherlv_2= 'false'
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
    // InternalExpressionDsl.g:1855:1: entryRuleHyEnumValue returns [EObject current=null] : iv_ruleHyEnumValue= ruleHyEnumValue EOF ;
    public final EObject entryRuleHyEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEnumValue = null;


        try {
            // InternalExpressionDsl.g:1855:52: (iv_ruleHyEnumValue= ruleHyEnumValue EOF )
            // InternalExpressionDsl.g:1856:2: iv_ruleHyEnumValue= ruleHyEnumValue EOF
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
    // InternalExpressionDsl.g:1862:1: ruleHyEnumValue returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1868:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalExpressionDsl.g:1869:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalExpressionDsl.g:1869:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1870:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1870:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1871:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1871:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:1872:5: otherlv_0= RULE_STRING
            {
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
            // InternalExpressionDsl.g:1887:3: ( (otherlv_2= RULE_STRING ) )
            // InternalExpressionDsl.g:1888:4: (otherlv_2= RULE_STRING )
            {
            // InternalExpressionDsl.g:1888:4: (otherlv_2= RULE_STRING )
            // InternalExpressionDsl.g:1889:5: otherlv_2= RULE_STRING
            {
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
    // InternalExpressionDsl.g:1904:1: entryRuleHyNestedArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedArithmeticalValueExpression = null;


        try {
            // InternalExpressionDsl.g:1904:76: (iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF )
            // InternalExpressionDsl.g:1905:2: iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF
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
    // InternalExpressionDsl.g:1911:1: ruleHyNestedArithmeticalValueExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalExpressionDsl.g:1917:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) ) otherlv_2= ')' ) )
            // InternalExpressionDsl.g:1918:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) ) otherlv_2= ')' )
            {
            // InternalExpressionDsl.g:1918:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) ) otherlv_2= ')' )
            // InternalExpressionDsl.g:1919:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExpressionDsl.g:1923:3: ( (lv_operand_1_0= ruleHyArithmeticalValueExpression ) )
            // InternalExpressionDsl.g:1924:4: (lv_operand_1_0= ruleHyArithmeticalValueExpression )
            {
            // InternalExpressionDsl.g:1924:4: (lv_operand_1_0= ruleHyArithmeticalValueExpression )
            // InternalExpressionDsl.g:1925:5: lv_operand_1_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getOperandHyArithmeticalValueExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_operand_1_0=ruleHyArithmeticalValueExpression();

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
              						"de.darwinspl.ExpressionDsl.HyArithmeticalValueExpression");
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
    // InternalExpressionDsl.g:1950:1: entryRuleHyContextInformationReferenceExpression returns [EObject current=null] : iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF ;
    public final EObject entryRuleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyContextInformationReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:1950:80: (iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF )
            // InternalExpressionDsl.g:1951:2: iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF
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
    // InternalExpressionDsl.g:1957:1: ruleHyContextInformationReferenceExpression returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) ) ;
    public final EObject ruleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1963:2: ( ( (otherlv_0= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1964:2: ( (otherlv_0= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1964:2: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1965:3: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1965:3: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:1966:4: otherlv_0= RULE_STRING
            {
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
    // InternalExpressionDsl.g:1980:1: entryRuleHyAttributeReferenceExpression returns [EObject current=null] : iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF ;
    public final EObject entryRuleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAttributeReferenceExpression = null;


        try {
            // InternalExpressionDsl.g:1980:71: (iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF )
            // InternalExpressionDsl.g:1981:2: iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF
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
    // InternalExpressionDsl.g:1987:1: ruleHyAttributeReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:1993:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalExpressionDsl.g:1994:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalExpressionDsl.g:1994:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalExpressionDsl.g:1995:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalExpressionDsl.g:1995:3: ( (otherlv_0= RULE_STRING ) )
            // InternalExpressionDsl.g:1996:4: (otherlv_0= RULE_STRING )
            {
            // InternalExpressionDsl.g:1996:4: (otherlv_0= RULE_STRING )
            // InternalExpressionDsl.g:1997:5: otherlv_0= RULE_STRING
            {
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
            // InternalExpressionDsl.g:2012:3: ( (otherlv_2= RULE_STRING ) )
            // InternalExpressionDsl.g:2013:4: (otherlv_2= RULE_STRING )
            {
            // InternalExpressionDsl.g:2013:4: (otherlv_2= RULE_STRING )
            // InternalExpressionDsl.g:2014:5: otherlv_2= RULE_STRING
            {
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
    // InternalExpressionDsl.g:2029:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalExpressionDsl.g:2029:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalExpressionDsl.g:2030:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalExpressionDsl.g:2036:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2042:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalExpressionDsl.g:2043:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalExpressionDsl.g:2043:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalExpressionDsl.g:2044:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalExpressionDsl.g:2044:3: (kw= '-' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalExpressionDsl.g:2045:4: kw= '-'
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
    // InternalExpressionDsl.g:2062:1: ruleHyRelativeVersionRestrictionOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) ;
    public final Enumerator ruleHyRelativeVersionRestrictionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalExpressionDsl.g:2068:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) )
            // InternalExpressionDsl.g:2069:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            {
            // InternalExpressionDsl.g:2069:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt24=1;
                }
                break;
            case 27:
                {
                alt24=2;
                }
                break;
            case 28:
                {
                alt24=3;
                }
                break;
            case 26:
                {
                alt24=4;
                }
                break;
            case 24:
                {
                alt24=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalExpressionDsl.g:2070:3: (enumLiteral_0= '<' )
                    {
                    // InternalExpressionDsl.g:2070:3: (enumLiteral_0= '<' )
                    // InternalExpressionDsl.g:2071:4: enumLiteral_0= '<'
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
                    // InternalExpressionDsl.g:2078:3: (enumLiteral_1= '<=' )
                    {
                    // InternalExpressionDsl.g:2078:3: (enumLiteral_1= '<=' )
                    // InternalExpressionDsl.g:2079:4: enumLiteral_1= '<='
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
                    // InternalExpressionDsl.g:2086:3: (enumLiteral_2= '=' )
                    {
                    // InternalExpressionDsl.g:2086:3: (enumLiteral_2= '=' )
                    // InternalExpressionDsl.g:2087:4: enumLiteral_2= '='
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
                    // InternalExpressionDsl.g:2094:3: (enumLiteral_3= '>=' )
                    {
                    // InternalExpressionDsl.g:2094:3: (enumLiteral_3= '>=' )
                    // InternalExpressionDsl.g:2095:4: enumLiteral_3= '>='
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
                    // InternalExpressionDsl.g:2102:3: (enumLiteral_4= '>' )
                    {
                    // InternalExpressionDsl.g:2102:3: (enumLiteral_4= '>' )
                    // InternalExpressionDsl.g:2103:4: enumLiteral_4= '>'
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

    // $ANTLR start synpred1_InternalExpressionDsl
    public final void synpred1_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:387:4: ( ruleHyArithmeticalComparisonExpression )
        // InternalExpressionDsl.g:387:5: ruleHyArithmeticalComparisonExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalComparisonExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalExpressionDsl

    // $ANTLR start synpred2_InternalExpressionDsl
    public final void synpred2_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:905:5: ( ( ruleHyArithmeticalValueExpression ) )
        // InternalExpressionDsl.g:905:6: ( ruleHyArithmeticalValueExpression )
        {
        // InternalExpressionDsl.g:905:6: ( ruleHyArithmeticalValueExpression )
        // InternalExpressionDsl.g:906:6: ruleHyArithmeticalValueExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalExpressionDsl

    // $ANTLR start synpred3_InternalExpressionDsl
    public final void synpred3_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:981:5: ( ( ruleHyArithmeticalValueExpression ) )
        // InternalExpressionDsl.g:981:6: ( ruleHyArithmeticalValueExpression )
        {
        // InternalExpressionDsl.g:981:6: ( ruleHyArithmeticalValueExpression )
        // InternalExpressionDsl.g:982:6: ruleHyArithmeticalValueExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalExpressionDsl

    // $ANTLR start synpred4_InternalExpressionDsl
    public final void synpred4_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:1057:5: ( ( ruleHyArithmeticalValueExpression ) )
        // InternalExpressionDsl.g:1057:6: ( ruleHyArithmeticalValueExpression )
        {
        // InternalExpressionDsl.g:1057:6: ( ruleHyArithmeticalValueExpression )
        // InternalExpressionDsl.g:1058:6: ruleHyArithmeticalValueExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalExpressionDsl

    // $ANTLR start synpred5_InternalExpressionDsl
    public final void synpred5_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:1133:5: ( ( ruleHyArithmeticalValueExpression ) )
        // InternalExpressionDsl.g:1133:6: ( ruleHyArithmeticalValueExpression )
        {
        // InternalExpressionDsl.g:1133:6: ( ruleHyArithmeticalValueExpression )
        // InternalExpressionDsl.g:1134:6: ruleHyArithmeticalValueExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalExpressionDsl

    // $ANTLR start synpred6_InternalExpressionDsl
    public final void synpred6_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:1209:5: ( ( ruleHyArithmeticalValueExpression ) )
        // InternalExpressionDsl.g:1209:6: ( ruleHyArithmeticalValueExpression )
        {
        // InternalExpressionDsl.g:1209:6: ( ruleHyArithmeticalValueExpression )
        // InternalExpressionDsl.g:1210:6: ruleHyArithmeticalValueExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyArithmeticalValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalExpressionDsl

    // $ANTLR start synpred7_InternalExpressionDsl
    public final void synpred7_InternalExpressionDsl_fragment() throws RecognitionException {   
        // InternalExpressionDsl.g:1624:4: ( ruleHyContextInformationReferenceExpression )
        // InternalExpressionDsl.g:1624:5: ruleHyContextInformationReferenceExpression
        {
        pushFollow(FOLLOW_2);
        ruleHyContextInformationReferenceExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalExpressionDsl

    // Delegated rules

    public final boolean synpred2_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExpressionDsl_fragment(); // can never throw exception
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
    public final boolean synpred5_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalExpressionDsl_fragment(); // can never throw exception
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
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\2\0\2\uffff\2\0\5\uffff";
    static final String dfa_3s = "\1\27\2\0\2\uffff\2\0\5\uffff";
    static final String dfa_4s = "\3\uffff\1\3\1\4\2\uffff\2\6\1\1\1\2\1\5";
    static final String dfa_5s = "\1\0\1\1\1\2\2\uffff\1\3\1\4\5\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\10\10\uffff\1\2\1\uffff\1\4\1\3\2\uffff\1\5\1\6\1\7",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
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
            return "340:2: (this_HyFeatureReferenceExpression_0= ruleHyFeatureReferenceExpression | this_HyNestedExpression_1= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_2= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_3= ruleHyNotExpression | this_HyBooleanValueExpression_4= ruleHyBooleanValueExpression | ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_5= ruleHyArithmeticalComparisonExpression ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_0 = input.LA(1);

                         
                        int index5_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_0==RULE_STRING) ) {s = 1;}

                        else if ( (LA5_0==15) ) {s = 2;}

                        else if ( (LA5_0==18) ) {s = 3;}

                        else if ( (LA5_0==17) ) {s = 4;}

                        else if ( (LA5_0==21) ) {s = 5;}

                        else if ( (LA5_0==22) ) {s = 6;}

                        else if ( (LA5_0==23) && (synpred1_InternalExpressionDsl())) {s = 7;}

                        else if ( (LA5_0==RULE_INT) && (synpred1_InternalExpressionDsl())) {s = 8;}

                         
                        input.seek(index5_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_1 = input.LA(1);

                         
                        int index5_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 9;}

                        else if ( (synpred1_InternalExpressionDsl()) ) {s = 8;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 10;}

                        else if ( (synpred1_InternalExpressionDsl()) ) {s = 8;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 11;}

                        else if ( (synpred1_InternalExpressionDsl()) ) {s = 8;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 11;}

                        else if ( (synpred1_InternalExpressionDsl()) ) {s = 8;}

                         
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
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});

}