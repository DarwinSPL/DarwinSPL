package de.darwinspl.constraint.dsl.parser.antlr.internal;

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
import de.darwinspl.constraint.dsl.services.ConstraintDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalConstraintDslParser extends AbstractInternalAntlrParser {
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


        public InternalConstraintDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConstraintDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConstraintDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalConstraintDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private ConstraintDslGrammarAccess grammarAccess;

        public InternalConstraintDslParser(TokenStream input, ConstraintDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "HyConstraintModel";
       	}

       	@Override
       	protected ConstraintDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleHyConstraintModel"
    // InternalConstraintDsl.g:71:1: entryRuleHyConstraintModel returns [EObject current=null] : iv_ruleHyConstraintModel= ruleHyConstraintModel EOF ;
    public final EObject entryRuleHyConstraintModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyConstraintModel = null;


        try {
            // InternalConstraintDsl.g:71:58: (iv_ruleHyConstraintModel= ruleHyConstraintModel EOF )
            // InternalConstraintDsl.g:72:2: iv_ruleHyConstraintModel= ruleHyConstraintModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyConstraintModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyConstraintModel=ruleHyConstraintModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyConstraintModel; 
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
    // $ANTLR end "entryRuleHyConstraintModel"


    // $ANTLR start "ruleHyConstraintModel"
    // InternalConstraintDsl.g:78:1: ruleHyConstraintModel returns [EObject current=null] : ( () ( (lv_constraints_1_0= ruleHyConstraint ) )+ ) ;
    public final EObject ruleHyConstraintModel() throws RecognitionException {
        EObject current = null;

        EObject lv_constraints_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:84:2: ( ( () ( (lv_constraints_1_0= ruleHyConstraint ) )+ ) )
            // InternalConstraintDsl.g:85:2: ( () ( (lv_constraints_1_0= ruleHyConstraint ) )+ )
            {
            // InternalConstraintDsl.g:85:2: ( () ( (lv_constraints_1_0= ruleHyConstraint ) )+ )
            // InternalConstraintDsl.g:86:3: () ( (lv_constraints_1_0= ruleHyConstraint ) )+
            {
            // InternalConstraintDsl.g:86:3: ()
            // InternalConstraintDsl.g:87:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHyConstraintModelAccess().getHyConstraintModelAction_0(),
              					current);
              			
            }

            }

            // InternalConstraintDsl.g:96:3: ( (lv_constraints_1_0= ruleHyConstraint ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING||LA1_0==RULE_INT||LA1_0==15||(LA1_0>=17 && LA1_0<=18)||(LA1_0>=21 && LA1_0<=23)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalConstraintDsl.g:97:4: (lv_constraints_1_0= ruleHyConstraint )
            	    {
            	    // InternalConstraintDsl.g:97:4: (lv_constraints_1_0= ruleHyConstraint )
            	    // InternalConstraintDsl.g:98:5: lv_constraints_1_0= ruleHyConstraint
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getHyConstraintModelAccess().getConstraintsHyConstraintParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_constraints_1_0=ruleHyConstraint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getHyConstraintModelRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints",
            	      						lv_constraints_1_0,
            	      						"de.darwinspl.constraint.dsl.ConstraintDsl.HyConstraint");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
    // $ANTLR end "ruleHyConstraintModel"


    // $ANTLR start "entryRuleHyConstraint"
    // InternalConstraintDsl.g:119:1: entryRuleHyConstraint returns [EObject current=null] : iv_ruleHyConstraint= ruleHyConstraint EOF ;
    public final EObject entryRuleHyConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyConstraint = null;


        try {
            // InternalConstraintDsl.g:119:53: (iv_ruleHyConstraint= ruleHyConstraint EOF )
            // InternalConstraintDsl.g:120:2: iv_ruleHyConstraint= ruleHyConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHyConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHyConstraint=ruleHyConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHyConstraint; 
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
    // $ANTLR end "entryRuleHyConstraint"


    // $ANTLR start "ruleHyConstraint"
    // InternalConstraintDsl.g:126:1: ruleHyConstraint returns [EObject current=null] : ( (lv_rootExpression_0_0= ruleHyExpression ) ) ;
    public final EObject ruleHyConstraint() throws RecognitionException {
        EObject current = null;

        EObject lv_rootExpression_0_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:132:2: ( ( (lv_rootExpression_0_0= ruleHyExpression ) ) )
            // InternalConstraintDsl.g:133:2: ( (lv_rootExpression_0_0= ruleHyExpression ) )
            {
            // InternalConstraintDsl.g:133:2: ( (lv_rootExpression_0_0= ruleHyExpression ) )
            // InternalConstraintDsl.g:134:3: (lv_rootExpression_0_0= ruleHyExpression )
            {
            // InternalConstraintDsl.g:134:3: (lv_rootExpression_0_0= ruleHyExpression )
            // InternalConstraintDsl.g:135:4: lv_rootExpression_0_0= ruleHyExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getHyConstraintAccess().getRootExpressionHyExpressionParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_rootExpression_0_0=ruleHyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getHyConstraintRule());
              				}
              				set(
              					current,
              					"rootExpression",
              					lv_rootExpression_0_0,
              					"de.darwinspl.ExpressionDsl.HyExpression");
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
    // $ANTLR end "ruleHyConstraint"


    // $ANTLR start "entryRuleHyExpression"
    // InternalConstraintDsl.g:155:1: entryRuleHyExpression returns [EObject current=null] : iv_ruleHyExpression= ruleHyExpression EOF ;
    public final EObject entryRuleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyExpression = null;


        try {
            // InternalConstraintDsl.g:155:53: (iv_ruleHyExpression= ruleHyExpression EOF )
            // InternalConstraintDsl.g:156:2: iv_ruleHyExpression= ruleHyExpression EOF
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
    // InternalConstraintDsl.g:162:1: ruleHyExpression returns [EObject current=null] : this_HyImpliesExpression_0= ruleHyImpliesExpression ;
    public final EObject ruleHyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyImpliesExpression_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:168:2: (this_HyImpliesExpression_0= ruleHyImpliesExpression )
            // InternalConstraintDsl.g:169:2: this_HyImpliesExpression_0= ruleHyImpliesExpression
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
    // InternalConstraintDsl.g:183:1: entryRuleHyImpliesExpression returns [EObject current=null] : iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF ;
    public final EObject entryRuleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyImpliesExpression = null;


        try {
            // InternalConstraintDsl.g:183:60: (iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF )
            // InternalConstraintDsl.g:184:2: iv_ruleHyImpliesExpression= ruleHyImpliesExpression EOF
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
    // InternalConstraintDsl.g:190:1: ruleHyImpliesExpression returns [EObject current=null] : (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) ;
    public final EObject ruleHyImpliesExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyEquivalenceExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:196:2: ( (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* ) )
            // InternalConstraintDsl.g:197:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            {
            // InternalConstraintDsl.g:197:2: (this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )* )
            // InternalConstraintDsl.g:198:3: this_HyEquivalenceExpression_0= ruleHyEquivalenceExpression ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyImpliesExpressionAccess().getHyEquivalenceExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_4);
            this_HyEquivalenceExpression_0=ruleHyEquivalenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyEquivalenceExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:209:3: ( () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalConstraintDsl.g:210:4: () otherlv_2= '->' ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    {
            	    // InternalConstraintDsl.g:210:4: ()
            	    // InternalConstraintDsl.g:211:5: 
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

            	    otherlv_2=(Token)match(input,11,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyImpliesExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:224:4: ( (lv_operand2_3_0= ruleHyEquivalenceExpression ) )
            	    // InternalConstraintDsl.g:225:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    {
            	    // InternalConstraintDsl.g:225:5: (lv_operand2_3_0= ruleHyEquivalenceExpression )
            	    // InternalConstraintDsl.g:226:6: lv_operand2_3_0= ruleHyEquivalenceExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyImpliesExpressionAccess().getOperand2HyEquivalenceExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
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
    // $ANTLR end "ruleHyImpliesExpression"


    // $ANTLR start "entryRuleHyEquivalenceExpression"
    // InternalConstraintDsl.g:248:1: entryRuleHyEquivalenceExpression returns [EObject current=null] : iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF ;
    public final EObject entryRuleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEquivalenceExpression = null;


        try {
            // InternalConstraintDsl.g:248:64: (iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF )
            // InternalConstraintDsl.g:249:2: iv_ruleHyEquivalenceExpression= ruleHyEquivalenceExpression EOF
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
    // InternalConstraintDsl.g:255:1: ruleHyEquivalenceExpression returns [EObject current=null] : (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) ;
    public final EObject ruleHyEquivalenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyAndExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:261:2: ( (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* ) )
            // InternalConstraintDsl.g:262:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            {
            // InternalConstraintDsl.g:262:2: (this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )* )
            // InternalConstraintDsl.g:263:3: this_HyAndExpression_0= ruleHyAndExpression ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyEquivalenceExpressionAccess().getHyAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_6);
            this_HyAndExpression_0=ruleHyAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:274:3: ( () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalConstraintDsl.g:275:4: () otherlv_2= '<->' ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    {
            	    // InternalConstraintDsl.g:275:4: ()
            	    // InternalConstraintDsl.g:276:5: 
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

            	    otherlv_2=(Token)match(input,12,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyEquivalenceExpressionAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:289:4: ( (lv_operand2_3_0= ruleHyAndExpression ) )
            	    // InternalConstraintDsl.g:290:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    {
            	    // InternalConstraintDsl.g:290:5: (lv_operand2_3_0= ruleHyAndExpression )
            	    // InternalConstraintDsl.g:291:6: lv_operand2_3_0= ruleHyAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyEquivalenceExpressionAccess().getOperand2HyAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
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
    // $ANTLR end "ruleHyEquivalenceExpression"


    // $ANTLR start "entryRuleHyAndExpression"
    // InternalConstraintDsl.g:313:1: entryRuleHyAndExpression returns [EObject current=null] : iv_ruleHyAndExpression= ruleHyAndExpression EOF ;
    public final EObject entryRuleHyAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAndExpression = null;


        try {
            // InternalConstraintDsl.g:313:56: (iv_ruleHyAndExpression= ruleHyAndExpression EOF )
            // InternalConstraintDsl.g:314:2: iv_ruleHyAndExpression= ruleHyAndExpression EOF
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
    // InternalConstraintDsl.g:320:1: ruleHyAndExpression returns [EObject current=null] : (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) ;
    public final EObject ruleHyAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:326:2: ( (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* ) )
            // InternalConstraintDsl.g:327:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            {
            // InternalConstraintDsl.g:327:2: (this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )* )
            // InternalConstraintDsl.g:328:3: this_HyOrExpression_0= ruleHyOrExpression ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyAndExpressionAccess().getHyOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_8);
            this_HyOrExpression_0=ruleHyOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:339:3: ( () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalConstraintDsl.g:340:4: () otherlv_2= '&&' ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    {
            	    // InternalConstraintDsl.g:340:4: ()
            	    // InternalConstraintDsl.g:341:5: 
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

            	    otherlv_2=(Token)match(input,13,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:354:4: ( (lv_operand2_3_0= ruleHyOrExpression ) )
            	    // InternalConstraintDsl.g:355:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    {
            	    // InternalConstraintDsl.g:355:5: (lv_operand2_3_0= ruleHyOrExpression )
            	    // InternalConstraintDsl.g:356:6: lv_operand2_3_0= ruleHyOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyAndExpressionAccess().getOperand2HyOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
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
    // $ANTLR end "ruleHyAndExpression"


    // $ANTLR start "entryRuleHyOrExpression"
    // InternalConstraintDsl.g:378:1: entryRuleHyOrExpression returns [EObject current=null] : iv_ruleHyOrExpression= ruleHyOrExpression EOF ;
    public final EObject entryRuleHyOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyOrExpression = null;


        try {
            // InternalConstraintDsl.g:378:55: (iv_ruleHyOrExpression= ruleHyOrExpression EOF )
            // InternalConstraintDsl.g:379:2: iv_ruleHyOrExpression= ruleHyOrExpression EOF
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
    // InternalConstraintDsl.g:385:1: ruleHyOrExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) ;
    public final EObject ruleHyOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:391:2: ( (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* ) )
            // InternalConstraintDsl.g:392:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            {
            // InternalConstraintDsl.g:392:2: (this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )* )
            // InternalConstraintDsl.g:393:3: this_TerminalExpression_0= ruleTerminalExpression ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyOrExpressionAccess().getTerminalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_10);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TerminalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:404:3: ( () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalConstraintDsl.g:405:4: () otherlv_2= '||' ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    {
            	    // InternalConstraintDsl.g:405:4: ()
            	    // InternalConstraintDsl.g:406:5: 
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

            	    otherlv_2=(Token)match(input,14,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:419:4: ( (lv_operand2_3_0= ruleTerminalExpression ) )
            	    // InternalConstraintDsl.g:420:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    {
            	    // InternalConstraintDsl.g:420:5: (lv_operand2_3_0= ruleTerminalExpression )
            	    // InternalConstraintDsl.g:421:6: lv_operand2_3_0= ruleTerminalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyOrExpressionAccess().getOperand2TerminalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
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
            	    break loop5;
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
    // InternalConstraintDsl.g:443:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalConstraintDsl.g:443:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalConstraintDsl.g:444:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
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
    // InternalConstraintDsl.g:450:1: ruleTerminalExpression returns [EObject current=null] : ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression ) ;
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
            // InternalConstraintDsl.g:456:2: ( ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression ) )
            // InternalConstraintDsl.g:457:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )
            {
            // InternalConstraintDsl.g:457:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalConstraintDsl.g:458:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
                    {
                    // InternalConstraintDsl.g:458:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
                    // InternalConstraintDsl.g:459:4: ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression
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
                    // InternalConstraintDsl.g:473:3: this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression
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
                    // InternalConstraintDsl.g:485:3: this_HyNestedExpression_2= ruleHyNestedExpression
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
                    // InternalConstraintDsl.g:497:3: this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression
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
                    // InternalConstraintDsl.g:509:3: this_HyNotExpression_4= ruleHyNotExpression
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
                    // InternalConstraintDsl.g:521:3: this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression
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
    // InternalConstraintDsl.g:536:1: entryRuleHyNestedExpression returns [EObject current=null] : iv_ruleHyNestedExpression= ruleHyNestedExpression EOF ;
    public final EObject entryRuleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedExpression = null;


        try {
            // InternalConstraintDsl.g:536:59: (iv_ruleHyNestedExpression= ruleHyNestedExpression EOF )
            // InternalConstraintDsl.g:537:2: iv_ruleHyNestedExpression= ruleHyNestedExpression EOF
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
    // InternalConstraintDsl.g:543:1: ruleHyNestedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:549:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' ) )
            // InternalConstraintDsl.g:550:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            {
            // InternalConstraintDsl.g:550:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')' )
            // InternalConstraintDsl.g:551:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalConstraintDsl.g:555:3: ( (lv_operand_1_0= ruleHyExpression ) )
            // InternalConstraintDsl.g:556:4: (lv_operand_1_0= ruleHyExpression )
            {
            // InternalConstraintDsl.g:556:4: (lv_operand_1_0= ruleHyExpression )
            // InternalConstraintDsl.g:557:5: lv_operand_1_0= ruleHyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNestedExpressionAccess().getOperandHyExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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
    // InternalConstraintDsl.g:582:1: entryRuleHyNotExpression returns [EObject current=null] : iv_ruleHyNotExpression= ruleHyNotExpression EOF ;
    public final EObject entryRuleHyNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotExpression = null;


        try {
            // InternalConstraintDsl.g:582:56: (iv_ruleHyNotExpression= ruleHyNotExpression EOF )
            // InternalConstraintDsl.g:583:2: iv_ruleHyNotExpression= ruleHyNotExpression EOF
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
    // InternalConstraintDsl.g:589:1: ruleHyNotExpression returns [EObject current=null] : (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) ;
    public final EObject ruleHyNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:595:2: ( (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) ) )
            // InternalConstraintDsl.g:596:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            {
            // InternalConstraintDsl.g:596:2: (otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) ) )
            // InternalConstraintDsl.g:597:3: otherlv_0= '!' ( (lv_operand_1_0= ruleTerminalExpression ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNotExpressionAccess().getExclamationMarkKeyword_0());
              		
            }
            // InternalConstraintDsl.g:601:3: ( (lv_operand_1_0= ruleTerminalExpression ) )
            // InternalConstraintDsl.g:602:4: (lv_operand_1_0= ruleTerminalExpression )
            {
            // InternalConstraintDsl.g:602:4: (lv_operand_1_0= ruleTerminalExpression )
            // InternalConstraintDsl.g:603:5: lv_operand_1_0= ruleTerminalExpression
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
    // InternalConstraintDsl.g:624:1: entryRuleHyFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyFeatureReferenceExpression = null;


        try {
            // InternalConstraintDsl.g:624:69: (iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF )
            // InternalConstraintDsl.g:625:2: iv_ruleHyFeatureReferenceExpression= ruleHyFeatureReferenceExpression EOF
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
    // InternalConstraintDsl.g:631:1: ruleHyFeatureReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_versionRestriction_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:637:2: ( ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? ) )
            // InternalConstraintDsl.g:638:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            {
            // InternalConstraintDsl.g:638:2: ( ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )? )
            // InternalConstraintDsl.g:639:3: ( (otherlv_0= RULE_STRING ) ) ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            {
            // InternalConstraintDsl.g:639:3: ( (otherlv_0= RULE_STRING ) )
            // InternalConstraintDsl.g:640:4: (otherlv_0= RULE_STRING )
            {
            // InternalConstraintDsl.g:640:4: (otherlv_0= RULE_STRING )
            // InternalConstraintDsl.g:641:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyFeatureReferenceExpressionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyFeatureReferenceExpressionAccess().getFeatureHyFeatureCrossReference_0_0());
              				
            }

            }


            }

            // InternalConstraintDsl.g:655:3: ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_STRING) ) {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4==23) ) {
                        int LA7_5 = input.LA(4);

                        if ( (LA7_5==21) ) {
                            int LA7_6 = input.LA(5);

                            if ( (LA7_6==23) ) {
                                int LA7_7 = input.LA(6);

                                if ( (LA7_7==RULE_INT) ) {
                                    int LA7_8 = input.LA(7);

                                    if ( (synpred12_InternalConstraintDsl()) ) {
                                        alt7=1;
                                    }
                                }
                            }
                            else if ( (LA7_6==EOF||LA7_6==RULE_STRING||LA7_6==RULE_INT||(LA7_6>=11 && LA7_6<=18)||(LA7_6>=21 && LA7_6<=22)) ) {
                                alt7=1;
                            }
                        }
                    }
                    else if ( (LA7_4==20) ) {
                        alt7=1;
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalConstraintDsl.g:656:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    {
                    // InternalConstraintDsl.g:656:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
                    // InternalConstraintDsl.g:657:5: lv_versionRestriction_1_0= ruleHyVersionRestriction
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
    // InternalConstraintDsl.g:678:1: entryRuleHyConditionalFeatureReferenceExpression returns [EObject current=null] : iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF ;
    public final EObject entryRuleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyConditionalFeatureReferenceExpression = null;


        try {
            // InternalConstraintDsl.g:678:80: (iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF )
            // InternalConstraintDsl.g:679:2: iv_ruleHyConditionalFeatureReferenceExpression= ruleHyConditionalFeatureReferenceExpression EOF
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
    // InternalConstraintDsl.g:685:1: ruleHyConditionalFeatureReferenceExpression returns [EObject current=null] : (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) ;
    public final EObject ruleHyConditionalFeatureReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_versionRestriction_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:691:2: ( (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? ) )
            // InternalConstraintDsl.g:692:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            {
            // InternalConstraintDsl.g:692:2: (otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )? )
            // InternalConstraintDsl.g:693:3: otherlv_0= '?' ( (otherlv_1= RULE_STRING ) ) ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getQuestionMarkKeyword_0());
              		
            }
            // InternalConstraintDsl.g:697:3: ( (otherlv_1= RULE_STRING ) )
            // InternalConstraintDsl.g:698:4: (otherlv_1= RULE_STRING )
            {
            // InternalConstraintDsl.g:698:4: (otherlv_1= RULE_STRING )
            // InternalConstraintDsl.g:699:5: otherlv_1= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyConditionalFeatureReferenceExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getFeatureHyFeatureCrossReference_1_0());
              				
            }

            }


            }

            // InternalConstraintDsl.g:713:3: ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==RULE_STRING) ) {
                    int LA8_4 = input.LA(3);

                    if ( (LA8_4==23) ) {
                        int LA8_5 = input.LA(4);

                        if ( (LA8_5==21) ) {
                            int LA8_6 = input.LA(5);

                            if ( (LA8_6==EOF||LA8_6==RULE_STRING||LA8_6==RULE_INT||(LA8_6>=11 && LA8_6<=18)||(LA8_6>=21 && LA8_6<=22)) ) {
                                alt8=1;
                            }
                            else if ( (LA8_6==23) ) {
                                int LA8_7 = input.LA(6);

                                if ( (LA8_7==RULE_INT) ) {
                                    int LA8_8 = input.LA(7);

                                    if ( (synpred13_InternalConstraintDsl()) ) {
                                        alt8=1;
                                    }
                                }
                            }
                        }
                    }
                    else if ( (LA8_4==20) ) {
                        alt8=1;
                    }
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalConstraintDsl.g:714:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    {
                    // InternalConstraintDsl.g:714:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
                    // InternalConstraintDsl.g:715:5: lv_versionRestriction_2_0= ruleHyVersionRestriction
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
    // InternalConstraintDsl.g:736:1: entryRuleHyVersionRestriction returns [EObject current=null] : iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF ;
    public final EObject entryRuleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRestriction = null;


        try {
            // InternalConstraintDsl.g:736:61: (iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF )
            // InternalConstraintDsl.g:737:2: iv_ruleHyVersionRestriction= ruleHyVersionRestriction EOF
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
    // InternalConstraintDsl.g:743:1: ruleHyVersionRestriction returns [EObject current=null] : (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) ;
    public final EObject ruleHyVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject this_HyRelativeVersionRestriction_0 = null;

        EObject this_HyVersionRangeRestriction_1 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:749:2: ( (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction ) )
            // InternalConstraintDsl.g:750:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
            {
            // InternalConstraintDsl.g:750:2: (this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction | this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1>=24 && LA9_1<=28)) ) {
                    alt9=1;
                }
                else if ( (LA9_1==21) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalConstraintDsl.g:751:3: this_HyRelativeVersionRestriction_0= ruleHyRelativeVersionRestriction
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
                    // InternalConstraintDsl.g:763:3: this_HyVersionRangeRestriction_1= ruleHyVersionRangeRestriction
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
    // InternalConstraintDsl.g:778:1: entryRuleHyRelativeVersionRestriction returns [EObject current=null] : iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF ;
    public final EObject entryRuleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyRelativeVersionRestriction = null;


        try {
            // InternalConstraintDsl.g:778:69: (iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF )
            // InternalConstraintDsl.g:779:2: iv_ruleHyRelativeVersionRestriction= ruleHyRelativeVersionRestriction EOF
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
    // InternalConstraintDsl.g:785:1: ruleHyRelativeVersionRestriction returns [EObject current=null] : (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) ;
    public final EObject ruleHyRelativeVersionRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:791:2: ( (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) )
            // InternalConstraintDsl.g:792:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            {
            // InternalConstraintDsl.g:792:2: (otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            // InternalConstraintDsl.g:793:3: otherlv_0= '[' ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyRelativeVersionRestrictionAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalConstraintDsl.g:797:3: ( (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator ) )
            // InternalConstraintDsl.g:798:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            {
            // InternalConstraintDsl.g:798:4: (lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator )
            // InternalConstraintDsl.g:799:5: lv_operator_1_0= ruleHyRelativeVersionRestrictionOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyRelativeVersionRestrictionAccess().getOperatorHyRelativeVersionRestrictionOperatorEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalConstraintDsl.g:816:3: ( (otherlv_2= RULE_ID ) )
            // InternalConstraintDsl.g:817:4: (otherlv_2= RULE_ID )
            {
            // InternalConstraintDsl.g:817:4: (otherlv_2= RULE_ID )
            // InternalConstraintDsl.g:818:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyRelativeVersionRestrictionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
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
    // InternalConstraintDsl.g:840:1: entryRuleHyVersionRangeRestriction returns [EObject current=null] : iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF ;
    public final EObject entryRuleHyVersionRangeRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyVersionRangeRestriction = null;


        try {
            // InternalConstraintDsl.g:840:66: (iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF )
            // InternalConstraintDsl.g:841:2: iv_ruleHyVersionRangeRestriction= ruleHyVersionRangeRestriction EOF
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
    // InternalConstraintDsl.g:847:1: ruleHyVersionRangeRestriction returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) ;
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
            // InternalConstraintDsl.g:853:2: ( ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) ) )
            // InternalConstraintDsl.g:854:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            {
            // InternalConstraintDsl.g:854:2: ( (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) ) | (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) ) | (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' ) )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==22) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==RULE_STRING) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==20) ) {
                        alt10=3;
                    }
                    else if ( (LA10_3==23) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalConstraintDsl.g:855:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    {
                    // InternalConstraintDsl.g:855:3: (otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) ) )
                    // InternalConstraintDsl.g:856:4: otherlv_0= '[' ( (lv_lowerIncluded_1_0= 'true' ) )
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getHyVersionRangeRestrictionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    // InternalConstraintDsl.g:860:4: ( (lv_lowerIncluded_1_0= 'true' ) )
                    // InternalConstraintDsl.g:861:5: (lv_lowerIncluded_1_0= 'true' )
                    {
                    // InternalConstraintDsl.g:861:5: (lv_lowerIncluded_1_0= 'true' )
                    // InternalConstraintDsl.g:862:6: lv_lowerIncluded_1_0= 'true'
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
                    // InternalConstraintDsl.g:876:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    {
                    // InternalConstraintDsl.g:876:3: (otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) ) )
                    // InternalConstraintDsl.g:877:4: otherlv_2= 'false' ( (otherlv_3= RULE_STRING ) ) otherlv_4= '-' ( (lv_upperIncluded_5_0= 'true' ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_1_0());
                      			
                    }
                    // InternalConstraintDsl.g:881:4: ( (otherlv_3= RULE_STRING ) )
                    // InternalConstraintDsl.g:882:5: (otherlv_3= RULE_STRING )
                    {
                    // InternalConstraintDsl.g:882:5: (otherlv_3= RULE_STRING )
                    // InternalConstraintDsl.g:883:6: otherlv_3= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getHyVersionRangeRestrictionAccess().getLowerVersionHyVersionCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getHyVersionRangeRestrictionAccess().getHyphenMinusKeyword_1_2());
                      			
                    }
                    // InternalConstraintDsl.g:901:4: ( (lv_upperIncluded_5_0= 'true' ) )
                    // InternalConstraintDsl.g:902:5: (lv_upperIncluded_5_0= 'true' )
                    {
                    // InternalConstraintDsl.g:902:5: (lv_upperIncluded_5_0= 'true' )
                    // InternalConstraintDsl.g:903:6: lv_upperIncluded_5_0= 'true'
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
                    // InternalConstraintDsl.g:917:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    {
                    // InternalConstraintDsl.g:917:3: (otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']' )
                    // InternalConstraintDsl.g:918:4: otherlv_6= 'false' ( (otherlv_7= RULE_STRING ) ) otherlv_8= ']'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getHyVersionRangeRestrictionAccess().getFalseKeyword_2_0());
                      			
                    }
                    // InternalConstraintDsl.g:922:4: ( (otherlv_7= RULE_STRING ) )
                    // InternalConstraintDsl.g:923:5: (otherlv_7= RULE_STRING )
                    {
                    // InternalConstraintDsl.g:923:5: (otherlv_7= RULE_STRING )
                    // InternalConstraintDsl.g:924:6: otherlv_7= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHyVersionRangeRestrictionRule());
                      						}
                      					
                    }
                    otherlv_7=(Token)match(input,RULE_STRING,FOLLOW_19); if (state.failed) return current;
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
    // InternalConstraintDsl.g:947:1: entryRuleHyBooleanValueExpression returns [EObject current=null] : iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF ;
    public final EObject entryRuleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValueExpression = null;


        try {
            // InternalConstraintDsl.g:947:65: (iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF )
            // InternalConstraintDsl.g:948:2: iv_ruleHyBooleanValueExpression= ruleHyBooleanValueExpression EOF
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
    // InternalConstraintDsl.g:954:1: ruleHyBooleanValueExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValueExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:960:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalConstraintDsl.g:961:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalConstraintDsl.g:961:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalConstraintDsl.g:962:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalConstraintDsl.g:962:3: ()
            // InternalConstraintDsl.g:963:4: 
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

            // InternalConstraintDsl.g:972:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            else if ( (LA11_0==22) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalConstraintDsl.g:973:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalConstraintDsl.g:973:4: ( (lv_value_1_0= 'true' ) )
                    // InternalConstraintDsl.g:974:5: (lv_value_1_0= 'true' )
                    {
                    // InternalConstraintDsl.g:974:5: (lv_value_1_0= 'true' )
                    // InternalConstraintDsl.g:975:6: lv_value_1_0= 'true'
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
                    // InternalConstraintDsl.g:988:4: otherlv_2= 'false'
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
    // InternalConstraintDsl.g:997:1: entryRuleHyArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalComparisonExpression = null;


        try {
            // InternalConstraintDsl.g:997:75: (iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF )
            // InternalConstraintDsl.g:998:2: iv_ruleHyArithmeticalComparisonExpression= ruleHyArithmeticalComparisonExpression EOF
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
    // InternalConstraintDsl.g:1004:1: ruleHyArithmeticalComparisonExpression returns [EObject current=null] : this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression ;
    public final EObject ruleHyArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyBinaryArithmeticalComparisonExpression_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1010:2: (this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression )
            // InternalConstraintDsl.g:1011:2: this_HyBinaryArithmeticalComparisonExpression_0= ruleHyBinaryArithmeticalComparisonExpression
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
    // InternalConstraintDsl.g:1025:1: entryRuleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF ;
    public final EObject entryRuleHyBinaryArithmeticalComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBinaryArithmeticalComparisonExpression = null;


        try {
            // InternalConstraintDsl.g:1025:81: (iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF )
            // InternalConstraintDsl.g:1026:2: iv_ruleHyBinaryArithmeticalComparisonExpression= ruleHyBinaryArithmeticalComparisonExpression EOF
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
    // InternalConstraintDsl.g:1032:1: ruleHyBinaryArithmeticalComparisonExpression returns [EObject current=null] : (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression ) ;
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
            // InternalConstraintDsl.g:1038:2: ( (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression ) )
            // InternalConstraintDsl.g:1039:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )
            {
            // InternalConstraintDsl.g:1039:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )
            int alt12=6;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalConstraintDsl.g:1040:3: this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression
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
                    // InternalConstraintDsl.g:1052:3: this_HyGreaterExpression_1= ruleHyGreaterExpression
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
                    // InternalConstraintDsl.g:1064:3: this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression
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
                    // InternalConstraintDsl.g:1076:3: this_HyLessExpression_3= ruleHyLessExpression
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
                    // InternalConstraintDsl.g:1088:3: this_HyNotEqualExpression_4= ruleHyNotEqualExpression
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
                    // InternalConstraintDsl.g:1100:3: this_HyEqualExpression_5= ruleHyEqualExpression
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
    // InternalConstraintDsl.g:1115:1: entryRuleHyGreaterExpression returns [EObject current=null] : iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF ;
    public final EObject entryRuleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterExpression = null;


        try {
            // InternalConstraintDsl.g:1115:60: (iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF )
            // InternalConstraintDsl.g:1116:2: iv_ruleHyGreaterExpression= ruleHyGreaterExpression EOF
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
    // InternalConstraintDsl.g:1122:1: ruleHyGreaterExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyGreaterExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1128:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1129:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1129:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1130:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1130:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1131:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1131:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1132:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            otherlv_1=(Token)match(input,24,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyGreaterExpressionAccess().getGreaterThanSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1153:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1154:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1154:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1155:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1176:1: entryRuleHyLessExpression returns [EObject current=null] : iv_ruleHyLessExpression= ruleHyLessExpression EOF ;
    public final EObject entryRuleHyLessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessExpression = null;


        try {
            // InternalConstraintDsl.g:1176:57: (iv_ruleHyLessExpression= ruleHyLessExpression EOF )
            // InternalConstraintDsl.g:1177:2: iv_ruleHyLessExpression= ruleHyLessExpression EOF
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
    // InternalConstraintDsl.g:1183:1: ruleHyLessExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyLessExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1189:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1190:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1190:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1191:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1191:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1192:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1192:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1193:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            otherlv_1=(Token)match(input,25,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyLessExpressionAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1214:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1215:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1215:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1216:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1237:1: entryRuleHyGreaterOrEqualExpression returns [EObject current=null] : iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF ;
    public final EObject entryRuleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyGreaterOrEqualExpression = null;


        try {
            // InternalConstraintDsl.g:1237:67: (iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF )
            // InternalConstraintDsl.g:1238:2: iv_ruleHyGreaterOrEqualExpression= ruleHyGreaterOrEqualExpression EOF
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
    // InternalConstraintDsl.g:1244:1: ruleHyGreaterOrEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyGreaterOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1250:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1251:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1251:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1252:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '>=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1252:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1253:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1253:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1254:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyGreaterOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            otherlv_1=(Token)match(input,26,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyGreaterOrEqualExpressionAccess().getGreaterThanSignEqualsSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1275:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1276:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1276:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1277:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1298:1: entryRuleHyLessOrEqualExpression returns [EObject current=null] : iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF ;
    public final EObject entryRuleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyLessOrEqualExpression = null;


        try {
            // InternalConstraintDsl.g:1298:64: (iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF )
            // InternalConstraintDsl.g:1299:2: iv_ruleHyLessOrEqualExpression= ruleHyLessOrEqualExpression EOF
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
    // InternalConstraintDsl.g:1305:1: ruleHyLessOrEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyLessOrEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1311:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1312:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1312:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1313:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '<=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1313:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1314:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1314:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1315:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyLessOrEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            otherlv_1=(Token)match(input,27,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyLessOrEqualExpressionAccess().getLessThanSignEqualsSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1336:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1337:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1337:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1338:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1359:1: entryRuleHyEqualExpression returns [EObject current=null] : iv_ruleHyEqualExpression= ruleHyEqualExpression EOF ;
    public final EObject entryRuleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEqualExpression = null;


        try {
            // InternalConstraintDsl.g:1359:58: (iv_ruleHyEqualExpression= ruleHyEqualExpression EOF )
            // InternalConstraintDsl.g:1360:2: iv_ruleHyEqualExpression= ruleHyEqualExpression EOF
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
    // InternalConstraintDsl.g:1366:1: ruleHyEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1372:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1373:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1373:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1374:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1374:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1375:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1375:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1376:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            otherlv_1=(Token)match(input,28,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyEqualExpressionAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1397:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1398:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1398:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1399:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1420:1: entryRuleHyNotEqualExpression returns [EObject current=null] : iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF ;
    public final EObject entryRuleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNotEqualExpression = null;


        try {
            // InternalConstraintDsl.g:1420:61: (iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF )
            // InternalConstraintDsl.g:1421:2: iv_ruleHyNotEqualExpression= ruleHyNotEqualExpression EOF
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
    // InternalConstraintDsl.g:1427:1: ruleHyNotEqualExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) ;
    public final EObject ruleHyNotEqualExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1433:2: ( ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) ) )
            // InternalConstraintDsl.g:1434:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            {
            // InternalConstraintDsl.g:1434:2: ( ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) ) )
            // InternalConstraintDsl.g:1435:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) ) otherlv_1= '!=' ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            {
            // InternalConstraintDsl.g:1435:3: ( (lv_operand1_0_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1436:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1436:4: (lv_operand1_0_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1437:5: lv_operand1_0_0= ruleHyArithmeticalValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNotEqualExpressionAccess().getOperand1HyArithmeticalValueExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            otherlv_1=(Token)match(input,29,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyNotEqualExpressionAccess().getExclamationMarkEqualsSignKeyword_1());
              		
            }
            // InternalConstraintDsl.g:1458:3: ( (lv_operand2_2_0= ruleHyArithmeticalValueExpression ) )
            // InternalConstraintDsl.g:1459:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            {
            // InternalConstraintDsl.g:1459:4: (lv_operand2_2_0= ruleHyArithmeticalValueExpression )
            // InternalConstraintDsl.g:1460:5: lv_operand2_2_0= ruleHyArithmeticalValueExpression
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
    // InternalConstraintDsl.g:1481:1: entryRuleHyArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyArithmeticalValueExpression = null;


        try {
            // InternalConstraintDsl.g:1481:70: (iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF )
            // InternalConstraintDsl.g:1482:2: iv_ruleHyArithmeticalValueExpression= ruleHyArithmeticalValueExpression EOF
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
    // InternalConstraintDsl.g:1488:1: ruleHyArithmeticalValueExpression returns [EObject current=null] : this_HyDivisionExpression_0= ruleHyDivisionExpression ;
    public final EObject ruleHyArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyDivisionExpression_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1494:2: (this_HyDivisionExpression_0= ruleHyDivisionExpression )
            // InternalConstraintDsl.g:1495:2: this_HyDivisionExpression_0= ruleHyDivisionExpression
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
    // InternalConstraintDsl.g:1509:1: entryRuleHyDivisionExpression returns [EObject current=null] : iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF ;
    public final EObject entryRuleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyDivisionExpression = null;


        try {
            // InternalConstraintDsl.g:1509:61: (iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF )
            // InternalConstraintDsl.g:1510:2: iv_ruleHyDivisionExpression= ruleHyDivisionExpression EOF
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
    // InternalConstraintDsl.g:1516:1: ruleHyDivisionExpression returns [EObject current=null] : (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) ;
    public final EObject ruleHyDivisionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyMultiplicationExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1522:2: ( (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* ) )
            // InternalConstraintDsl.g:1523:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            {
            // InternalConstraintDsl.g:1523:2: (this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )* )
            // InternalConstraintDsl.g:1524:3: this_HyMultiplicationExpression_0= ruleHyMultiplicationExpression ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getHyMultiplicationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_HyMultiplicationExpression_0=ruleHyMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyMultiplicationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:1535:3: ( () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalConstraintDsl.g:1536:4: () otherlv_2= '/' ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    {
            	    // InternalConstraintDsl.g:1536:4: ()
            	    // InternalConstraintDsl.g:1537:5: 
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

            	    otherlv_2=(Token)match(input,30,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyDivisionExpressionAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:1550:4: ( (lv_operand2_3_0= ruleHyMultiplicationExpression ) )
            	    // InternalConstraintDsl.g:1551:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    {
            	    // InternalConstraintDsl.g:1551:5: (lv_operand2_3_0= ruleHyMultiplicationExpression )
            	    // InternalConstraintDsl.g:1552:6: lv_operand2_3_0= ruleHyMultiplicationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyDivisionExpressionAccess().getOperand2HyMultiplicationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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
    // $ANTLR end "ruleHyDivisionExpression"


    // $ANTLR start "entryRuleHyMultiplicationExpression"
    // InternalConstraintDsl.g:1574:1: entryRuleHyMultiplicationExpression returns [EObject current=null] : iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF ;
    public final EObject entryRuleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyMultiplicationExpression = null;


        try {
            // InternalConstraintDsl.g:1574:67: (iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF )
            // InternalConstraintDsl.g:1575:2: iv_ruleHyMultiplicationExpression= ruleHyMultiplicationExpression EOF
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
    // InternalConstraintDsl.g:1581:1: ruleHyMultiplicationExpression returns [EObject current=null] : (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) ;
    public final EObject ruleHyMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HySubtractionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1587:2: ( (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* ) )
            // InternalConstraintDsl.g:1588:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            {
            // InternalConstraintDsl.g:1588:2: (this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )* )
            // InternalConstraintDsl.g:1589:3: this_HySubtractionExpression_0= ruleHySubtractionExpression ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getHySubtractionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_HySubtractionExpression_0=ruleHySubtractionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HySubtractionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:1600:3: ( () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalConstraintDsl.g:1601:4: () otherlv_2= '*' ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    {
            	    // InternalConstraintDsl.g:1601:4: ()
            	    // InternalConstraintDsl.g:1602:5: 
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

            	    otherlv_2=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyMultiplicationExpressionAccess().getAsteriskKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:1615:4: ( (lv_operand2_3_0= ruleHySubtractionExpression ) )
            	    // InternalConstraintDsl.g:1616:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    {
            	    // InternalConstraintDsl.g:1616:5: (lv_operand2_3_0= ruleHySubtractionExpression )
            	    // InternalConstraintDsl.g:1617:6: lv_operand2_3_0= ruleHySubtractionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyMultiplicationExpressionAccess().getOperand2HySubtractionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
    // $ANTLR end "ruleHyMultiplicationExpression"


    // $ANTLR start "entryRuleHySubtractionExpression"
    // InternalConstraintDsl.g:1639:1: entryRuleHySubtractionExpression returns [EObject current=null] : iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF ;
    public final EObject entryRuleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHySubtractionExpression = null;


        try {
            // InternalConstraintDsl.g:1639:64: (iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF )
            // InternalConstraintDsl.g:1640:2: iv_ruleHySubtractionExpression= ruleHySubtractionExpression EOF
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
    // InternalConstraintDsl.g:1646:1: ruleHySubtractionExpression returns [EObject current=null] : (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* ) ;
    public final EObject ruleHySubtractionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_HyAdditionExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1652:2: ( (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* ) )
            // InternalConstraintDsl.g:1653:2: (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* )
            {
            // InternalConstraintDsl.g:1653:2: (this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )* )
            // InternalConstraintDsl.g:1654:3: this_HyAdditionExpression_0= ruleHyAdditionExpression ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getHyAdditionExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_HyAdditionExpression_0=ruleHyAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_HyAdditionExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:1665:3: ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==23) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_INT) ) {
                        int LA15_3 = input.LA(3);

                        if ( (synpred25_InternalConstraintDsl()) ) {
                            alt15=1;
                        }


                    }
                    else if ( (LA15_2==RULE_STRING||LA15_2==15||(LA15_2>=21 && LA15_2<=23)) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // InternalConstraintDsl.g:1666:4: () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
            	    {
            	    // InternalConstraintDsl.g:1666:4: ()
            	    // InternalConstraintDsl.g:1667:5: 
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

            	    otherlv_2=(Token)match(input,23,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHySubtractionExpressionAccess().getHyphenMinusKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:1680:4: ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
            	    // InternalConstraintDsl.g:1681:5: (lv_operand2_3_0= ruleHyAdditionExpression )
            	    {
            	    // InternalConstraintDsl.g:1681:5: (lv_operand2_3_0= ruleHyAdditionExpression )
            	    // InternalConstraintDsl.g:1682:6: lv_operand2_3_0= ruleHyAdditionExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getOperand2HyAdditionExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
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
    // $ANTLR end "ruleHySubtractionExpression"


    // $ANTLR start "entryRuleHyAdditionExpression"
    // InternalConstraintDsl.g:1704:1: entryRuleHyAdditionExpression returns [EObject current=null] : iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF ;
    public final EObject entryRuleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAdditionExpression = null;


        try {
            // InternalConstraintDsl.g:1704:61: (iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF )
            // InternalConstraintDsl.g:1705:2: iv_ruleHyAdditionExpression= ruleHyAdditionExpression EOF
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
    // InternalConstraintDsl.g:1711:1: ruleHyAdditionExpression returns [EObject current=null] : (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) ;
    public final EObject ruleHyAdditionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalArithmeticalExpression_0 = null;

        EObject lv_operand2_3_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1717:2: ( (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* ) )
            // InternalConstraintDsl.g:1718:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            {
            // InternalConstraintDsl.g:1718:2: (this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )* )
            // InternalConstraintDsl.g:1719:3: this_TerminalArithmeticalExpression_0= ruleTerminalArithmeticalExpression ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getTerminalArithmeticalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_TerminalArithmeticalExpression_0=ruleTerminalArithmeticalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TerminalArithmeticalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalConstraintDsl.g:1730:3: ( () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==32) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalConstraintDsl.g:1731:4: () otherlv_2= '+' ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    {
            	    // InternalConstraintDsl.g:1731:4: ()
            	    // InternalConstraintDsl.g:1732:5: 
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

            	    otherlv_2=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getHyAdditionExpressionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalConstraintDsl.g:1745:4: ( (lv_operand2_3_0= ruleTerminalArithmeticalExpression ) )
            	    // InternalConstraintDsl.g:1746:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    {
            	    // InternalConstraintDsl.g:1746:5: (lv_operand2_3_0= ruleTerminalArithmeticalExpression )
            	    // InternalConstraintDsl.g:1747:6: lv_operand2_3_0= ruleTerminalArithmeticalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getHyAdditionExpressionAccess().getOperand2TerminalArithmeticalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
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


    // $ANTLR start "entryRuleTerminalArithmeticalExpression"
    // InternalConstraintDsl.g:1769:1: entryRuleTerminalArithmeticalExpression returns [EObject current=null] : iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF ;
    public final EObject entryRuleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalArithmeticalExpression = null;


        try {
            // InternalConstraintDsl.g:1769:71: (iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF )
            // InternalConstraintDsl.g:1770:2: iv_ruleTerminalArithmeticalExpression= ruleTerminalArithmeticalExpression EOF
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
    // InternalConstraintDsl.g:1776:1: ruleTerminalArithmeticalExpression returns [EObject current=null] : (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) ;
    public final EObject ruleTerminalArithmeticalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_HyValueExpression_0 = null;

        EObject this_HyNestedArithmeticalValueExpression_1 = null;

        EObject this_HyContextInformationReferenceExpression_2 = null;

        EObject this_HyAttributeReferenceExpression_3 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1782:2: ( (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression ) )
            // InternalConstraintDsl.g:1783:2: (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            {
            // InternalConstraintDsl.g:1783:2: (this_HyValueExpression_0= ruleHyValueExpression | this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression | ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) | this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression )
            int alt17=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 21:
            case 22:
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
                else if ( (synpred27_InternalConstraintDsl()) ) {
                    alt17=1;
                }
                else if ( (synpred30_InternalConstraintDsl()) ) {
                    alt17=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt17=2;
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
                    // InternalConstraintDsl.g:1784:3: this_HyValueExpression_0= ruleHyValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalConstraintDsl.g:1796:3: this_HyNestedArithmeticalValueExpression_1= ruleHyNestedArithmeticalValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalConstraintDsl.g:1808:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
                    {
                    // InternalConstraintDsl.g:1808:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
                    // InternalConstraintDsl.g:1809:4: ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
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
                    // InternalConstraintDsl.g:1823:3: this_HyAttributeReferenceExpression_3= ruleHyAttributeReferenceExpression
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
    // InternalConstraintDsl.g:1838:1: entryRuleHyValueExpression returns [EObject current=null] : iv_ruleHyValueExpression= ruleHyValueExpression EOF ;
    public final EObject entryRuleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValueExpression = null;


        try {
            // InternalConstraintDsl.g:1838:58: (iv_ruleHyValueExpression= ruleHyValueExpression EOF )
            // InternalConstraintDsl.g:1839:2: iv_ruleHyValueExpression= ruleHyValueExpression EOF
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
    // InternalConstraintDsl.g:1845:1: ruleHyValueExpression returns [EObject current=null] : ( (lv_value_0_0= ruleHyValue ) ) ;
    public final EObject ruleHyValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1851:2: ( ( (lv_value_0_0= ruleHyValue ) ) )
            // InternalConstraintDsl.g:1852:2: ( (lv_value_0_0= ruleHyValue ) )
            {
            // InternalConstraintDsl.g:1852:2: ( (lv_value_0_0= ruleHyValue ) )
            // InternalConstraintDsl.g:1853:3: (lv_value_0_0= ruleHyValue )
            {
            // InternalConstraintDsl.g:1853:3: (lv_value_0_0= ruleHyValue )
            // InternalConstraintDsl.g:1854:4: lv_value_0_0= ruleHyValue
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
    // InternalConstraintDsl.g:1874:1: entryRuleHyValue returns [EObject current=null] : iv_ruleHyValue= ruleHyValue EOF ;
    public final EObject entryRuleHyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyValue = null;


        try {
            // InternalConstraintDsl.g:1874:48: (iv_ruleHyValue= ruleHyValue EOF )
            // InternalConstraintDsl.g:1875:2: iv_ruleHyValue= ruleHyValue EOF
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
    // InternalConstraintDsl.g:1881:1: ruleHyValue returns [EObject current=null] : (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) ;
    public final EObject ruleHyValue() throws RecognitionException {
        EObject current = null;

        EObject this_HyNumberValue_0 = null;

        EObject this_HyStringValue_1 = null;

        EObject this_HyBooleanValue_2 = null;

        EObject this_HyEnumValue_3 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1887:2: ( (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue ) )
            // InternalConstraintDsl.g:1888:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            {
            // InternalConstraintDsl.g:1888:2: (this_HyNumberValue_0= ruleHyNumberValue | this_HyStringValue_1= ruleHyStringValue | this_HyBooleanValue_2= ruleHyBooleanValue | this_HyEnumValue_3= ruleHyEnumValue )
            int alt18=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 23:
                {
                alt18=1;
                }
                break;
            case RULE_STRING:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==33) ) {
                    alt18=4;
                }
                else if ( (LA18_2==EOF||LA18_2==RULE_STRING||LA18_2==RULE_INT||(LA18_2>=11 && LA18_2<=18)||(LA18_2>=21 && LA18_2<=32)) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case 21:
            case 22:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalConstraintDsl.g:1889:3: this_HyNumberValue_0= ruleHyNumberValue
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
                    // InternalConstraintDsl.g:1901:3: this_HyStringValue_1= ruleHyStringValue
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
                    // InternalConstraintDsl.g:1913:3: this_HyBooleanValue_2= ruleHyBooleanValue
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
                    // InternalConstraintDsl.g:1925:3: this_HyEnumValue_3= ruleHyEnumValue
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
    // InternalConstraintDsl.g:1940:1: entryRuleHyNumberValue returns [EObject current=null] : iv_ruleHyNumberValue= ruleHyNumberValue EOF ;
    public final EObject entryRuleHyNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNumberValue = null;


        try {
            // InternalConstraintDsl.g:1940:54: (iv_ruleHyNumberValue= ruleHyNumberValue EOF )
            // InternalConstraintDsl.g:1941:2: iv_ruleHyNumberValue= ruleHyNumberValue EOF
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
    // InternalConstraintDsl.g:1947:1: ruleHyNumberValue returns [EObject current=null] : ( (lv_value_0_0= ruleEInt ) ) ;
    public final EObject ruleHyNumberValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:1953:2: ( ( (lv_value_0_0= ruleEInt ) ) )
            // InternalConstraintDsl.g:1954:2: ( (lv_value_0_0= ruleEInt ) )
            {
            // InternalConstraintDsl.g:1954:2: ( (lv_value_0_0= ruleEInt ) )
            // InternalConstraintDsl.g:1955:3: (lv_value_0_0= ruleEInt )
            {
            // InternalConstraintDsl.g:1955:3: (lv_value_0_0= ruleEInt )
            // InternalConstraintDsl.g:1956:4: lv_value_0_0= ruleEInt
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
    // InternalConstraintDsl.g:1976:1: entryRuleHyStringValue returns [EObject current=null] : iv_ruleHyStringValue= ruleHyStringValue EOF ;
    public final EObject entryRuleHyStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyStringValue = null;


        try {
            // InternalConstraintDsl.g:1976:54: (iv_ruleHyStringValue= ruleHyStringValue EOF )
            // InternalConstraintDsl.g:1977:2: iv_ruleHyStringValue= ruleHyStringValue EOF
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
    // InternalConstraintDsl.g:1983:1: ruleHyStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleHyStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:1989:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalConstraintDsl.g:1990:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalConstraintDsl.g:1990:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalConstraintDsl.g:1991:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalConstraintDsl.g:1991:3: (lv_value_0_0= RULE_STRING )
            // InternalConstraintDsl.g:1992:4: lv_value_0_0= RULE_STRING
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
    // InternalConstraintDsl.g:2011:1: entryRuleHyBooleanValue returns [EObject current=null] : iv_ruleHyBooleanValue= ruleHyBooleanValue EOF ;
    public final EObject entryRuleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyBooleanValue = null;


        try {
            // InternalConstraintDsl.g:2011:55: (iv_ruleHyBooleanValue= ruleHyBooleanValue EOF )
            // InternalConstraintDsl.g:2012:2: iv_ruleHyBooleanValue= ruleHyBooleanValue EOF
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
    // InternalConstraintDsl.g:2018:1: ruleHyBooleanValue returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleHyBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2024:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalConstraintDsl.g:2025:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalConstraintDsl.g:2025:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalConstraintDsl.g:2026:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalConstraintDsl.g:2026:3: ()
            // InternalConstraintDsl.g:2027:4: 
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

            // InternalConstraintDsl.g:2036:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==21) ) {
                alt19=1;
            }
            else if ( (LA19_0==22) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalConstraintDsl.g:2037:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalConstraintDsl.g:2037:4: ( (lv_value_1_0= 'true' ) )
                    // InternalConstraintDsl.g:2038:5: (lv_value_1_0= 'true' )
                    {
                    // InternalConstraintDsl.g:2038:5: (lv_value_1_0= 'true' )
                    // InternalConstraintDsl.g:2039:6: lv_value_1_0= 'true'
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
                    // InternalConstraintDsl.g:2052:4: otherlv_2= 'false'
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
    // InternalConstraintDsl.g:2061:1: entryRuleHyEnumValue returns [EObject current=null] : iv_ruleHyEnumValue= ruleHyEnumValue EOF ;
    public final EObject entryRuleHyEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyEnumValue = null;


        try {
            // InternalConstraintDsl.g:2061:52: (iv_ruleHyEnumValue= ruleHyEnumValue EOF )
            // InternalConstraintDsl.g:2062:2: iv_ruleHyEnumValue= ruleHyEnumValue EOF
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
    // InternalConstraintDsl.g:2068:1: ruleHyEnumValue returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2074:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalConstraintDsl.g:2075:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalConstraintDsl.g:2075:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalConstraintDsl.g:2076:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalConstraintDsl.g:2076:3: ( (otherlv_0= RULE_STRING ) )
            // InternalConstraintDsl.g:2077:4: (otherlv_0= RULE_STRING )
            {
            // InternalConstraintDsl.g:2077:4: (otherlv_0= RULE_STRING )
            // InternalConstraintDsl.g:2078:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyEnumValueRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyEnumValueAccess().getEnumHyEnumCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyEnumValueAccess().getFullStopKeyword_1());
              		
            }
            // InternalConstraintDsl.g:2096:3: ( (otherlv_2= RULE_STRING ) )
            // InternalConstraintDsl.g:2097:4: (otherlv_2= RULE_STRING )
            {
            // InternalConstraintDsl.g:2097:4: (otherlv_2= RULE_STRING )
            // InternalConstraintDsl.g:2098:5: otherlv_2= RULE_STRING
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
    // InternalConstraintDsl.g:2116:1: entryRuleHyNestedArithmeticalValueExpression returns [EObject current=null] : iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF ;
    public final EObject entryRuleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyNestedArithmeticalValueExpression = null;


        try {
            // InternalConstraintDsl.g:2116:76: (iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF )
            // InternalConstraintDsl.g:2117:2: iv_ruleHyNestedArithmeticalValueExpression= ruleHyNestedArithmeticalValueExpression EOF
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
    // InternalConstraintDsl.g:2123:1: ruleHyNestedArithmeticalValueExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleHyNestedArithmeticalValueExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalConstraintDsl.g:2129:2: ( (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' ) )
            // InternalConstraintDsl.g:2130:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' )
            {
            // InternalConstraintDsl.g:2130:2: (otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')' )
            // InternalConstraintDsl.g:2131:3: otherlv_0= '(' ( (lv_operand_1_0= ruleHyDivisionExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalConstraintDsl.g:2135:3: ( (lv_operand_1_0= ruleHyDivisionExpression ) )
            // InternalConstraintDsl.g:2136:4: (lv_operand_1_0= ruleHyDivisionExpression )
            {
            // InternalConstraintDsl.g:2136:4: (lv_operand_1_0= ruleHyDivisionExpression )
            // InternalConstraintDsl.g:2137:5: lv_operand_1_0= ruleHyDivisionExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHyNestedArithmeticalValueExpressionAccess().getOperandHyDivisionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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
    // InternalConstraintDsl.g:2162:1: entryRuleHyContextInformationReferenceExpression returns [EObject current=null] : iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF ;
    public final EObject entryRuleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyContextInformationReferenceExpression = null;


        try {
            // InternalConstraintDsl.g:2162:80: (iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF )
            // InternalConstraintDsl.g:2163:2: iv_ruleHyContextInformationReferenceExpression= ruleHyContextInformationReferenceExpression EOF
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
    // InternalConstraintDsl.g:2169:1: ruleHyContextInformationReferenceExpression returns [EObject current=null] : ( (otherlv_0= RULE_STRING ) ) ;
    public final EObject ruleHyContextInformationReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2175:2: ( ( (otherlv_0= RULE_STRING ) ) )
            // InternalConstraintDsl.g:2176:2: ( (otherlv_0= RULE_STRING ) )
            {
            // InternalConstraintDsl.g:2176:2: ( (otherlv_0= RULE_STRING ) )
            // InternalConstraintDsl.g:2177:3: (otherlv_0= RULE_STRING )
            {
            // InternalConstraintDsl.g:2177:3: (otherlv_0= RULE_STRING )
            // InternalConstraintDsl.g:2178:4: otherlv_0= RULE_STRING
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
    // InternalConstraintDsl.g:2195:1: entryRuleHyAttributeReferenceExpression returns [EObject current=null] : iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF ;
    public final EObject entryRuleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHyAttributeReferenceExpression = null;


        try {
            // InternalConstraintDsl.g:2195:71: (iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF )
            // InternalConstraintDsl.g:2196:2: iv_ruleHyAttributeReferenceExpression= ruleHyAttributeReferenceExpression EOF
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
    // InternalConstraintDsl.g:2202:1: ruleHyAttributeReferenceExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) ;
    public final EObject ruleHyAttributeReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2208:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) ) )
            // InternalConstraintDsl.g:2209:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            {
            // InternalConstraintDsl.g:2209:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) ) )
            // InternalConstraintDsl.g:2210:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= '.' ( (otherlv_2= RULE_STRING ) )
            {
            // InternalConstraintDsl.g:2210:3: ( (otherlv_0= RULE_STRING ) )
            // InternalConstraintDsl.g:2211:4: (otherlv_0= RULE_STRING )
            {
            // InternalConstraintDsl.g:2211:4: (otherlv_0= RULE_STRING )
            // InternalConstraintDsl.g:2212:5: otherlv_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHyAttributeReferenceExpressionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHyAttributeReferenceExpressionAccess().getFeatureHyFeatureCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHyAttributeReferenceExpressionAccess().getFullStopKeyword_1());
              		
            }
            // InternalConstraintDsl.g:2230:3: ( (otherlv_2= RULE_STRING ) )
            // InternalConstraintDsl.g:2231:4: (otherlv_2= RULE_STRING )
            {
            // InternalConstraintDsl.g:2231:4: (otherlv_2= RULE_STRING )
            // InternalConstraintDsl.g:2232:5: otherlv_2= RULE_STRING
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
    // InternalConstraintDsl.g:2250:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalConstraintDsl.g:2250:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalConstraintDsl.g:2251:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalConstraintDsl.g:2257:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2263:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalConstraintDsl.g:2264:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalConstraintDsl.g:2264:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalConstraintDsl.g:2265:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalConstraintDsl.g:2265:3: (kw= '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalConstraintDsl.g:2266:4: kw= '-'
                    {
                    kw=(Token)match(input,23,FOLLOW_34); if (state.failed) return current;
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
    // InternalConstraintDsl.g:2283:1: ruleHyRelativeVersionRestrictionOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) ;
    public final Enumerator ruleHyRelativeVersionRestrictionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalConstraintDsl.g:2289:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) ) )
            // InternalConstraintDsl.g:2290:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            {
            // InternalConstraintDsl.g:2290:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '>' ) )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt21=1;
                }
                break;
            case 27:
                {
                alt21=2;
                }
                break;
            case 28:
                {
                alt21=3;
                }
                break;
            case 26:
                {
                alt21=4;
                }
                break;
            case 24:
                {
                alt21=5;
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
                    // InternalConstraintDsl.g:2291:3: (enumLiteral_0= '<' )
                    {
                    // InternalConstraintDsl.g:2291:3: (enumLiteral_0= '<' )
                    // InternalConstraintDsl.g:2292:4: enumLiteral_0= '<'
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
                    // InternalConstraintDsl.g:2299:3: (enumLiteral_1= '<=' )
                    {
                    // InternalConstraintDsl.g:2299:3: (enumLiteral_1= '<=' )
                    // InternalConstraintDsl.g:2300:4: enumLiteral_1= '<='
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
                    // InternalConstraintDsl.g:2307:3: (enumLiteral_2= '=' )
                    {
                    // InternalConstraintDsl.g:2307:3: (enumLiteral_2= '=' )
                    // InternalConstraintDsl.g:2308:4: enumLiteral_2= '='
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
                    // InternalConstraintDsl.g:2315:3: (enumLiteral_3= '>=' )
                    {
                    // InternalConstraintDsl.g:2315:3: (enumLiteral_3= '>=' )
                    // InternalConstraintDsl.g:2316:4: enumLiteral_3= '>='
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
                    // InternalConstraintDsl.g:2323:3: (enumLiteral_4= '>' )
                    {
                    // InternalConstraintDsl.g:2323:3: (enumLiteral_4= '>' )
                    // InternalConstraintDsl.g:2324:4: enumLiteral_4= '>'
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

    // $ANTLR start synpred7_InternalConstraintDsl
    public final void synpred7_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyArithmeticalComparisonExpression_0 = null;


        // InternalConstraintDsl.g:458:3: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) )
        // InternalConstraintDsl.g:458:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
        {
        // InternalConstraintDsl.g:458:3: ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression )
        // InternalConstraintDsl.g:459:4: ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression
        {
        pushFollow(FOLLOW_2);
        this_HyArithmeticalComparisonExpression_0=ruleHyArithmeticalComparisonExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalConstraintDsl

    // $ANTLR start synpred8_InternalConstraintDsl
    public final void synpred8_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyFeatureReferenceExpression_1 = null;


        // InternalConstraintDsl.g:473:3: (this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression )
        // InternalConstraintDsl.g:473:3: this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression
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
    // $ANTLR end synpred8_InternalConstraintDsl

    // $ANTLR start synpred9_InternalConstraintDsl
    public final void synpred9_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyNestedExpression_2 = null;


        // InternalConstraintDsl.g:485:3: (this_HyNestedExpression_2= ruleHyNestedExpression )
        // InternalConstraintDsl.g:485:3: this_HyNestedExpression_2= ruleHyNestedExpression
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
    // $ANTLR end synpred9_InternalConstraintDsl

    // $ANTLR start synpred12_InternalConstraintDsl
    public final void synpred12_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject lv_versionRestriction_1_0 = null;


        // InternalConstraintDsl.g:656:4: ( (lv_versionRestriction_1_0= ruleHyVersionRestriction ) )
        // InternalConstraintDsl.g:656:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
        {
        // InternalConstraintDsl.g:656:4: (lv_versionRestriction_1_0= ruleHyVersionRestriction )
        // InternalConstraintDsl.g:657:5: lv_versionRestriction_1_0= ruleHyVersionRestriction
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getHyFeatureReferenceExpressionAccess().getVersionRestrictionHyVersionRestrictionParserRuleCall_1_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_versionRestriction_1_0=ruleHyVersionRestriction();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalConstraintDsl

    // $ANTLR start synpred13_InternalConstraintDsl
    public final void synpred13_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject lv_versionRestriction_2_0 = null;


        // InternalConstraintDsl.g:714:4: ( (lv_versionRestriction_2_0= ruleHyVersionRestriction ) )
        // InternalConstraintDsl.g:714:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
        {
        // InternalConstraintDsl.g:714:4: (lv_versionRestriction_2_0= ruleHyVersionRestriction )
        // InternalConstraintDsl.g:715:5: lv_versionRestriction_2_0= ruleHyVersionRestriction
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getHyConditionalFeatureReferenceExpressionAccess().getVersionRestrictionHyVersionRestrictionParserRuleCall_2_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_versionRestriction_2_0=ruleHyVersionRestriction();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalConstraintDsl

    // $ANTLR start synpred18_InternalConstraintDsl
    public final void synpred18_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyGreaterOrEqualExpression_0 = null;


        // InternalConstraintDsl.g:1040:3: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression )
        // InternalConstraintDsl.g:1040:3: this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression
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
    // $ANTLR end synpred18_InternalConstraintDsl

    // $ANTLR start synpred19_InternalConstraintDsl
    public final void synpred19_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyGreaterExpression_1 = null;


        // InternalConstraintDsl.g:1052:3: (this_HyGreaterExpression_1= ruleHyGreaterExpression )
        // InternalConstraintDsl.g:1052:3: this_HyGreaterExpression_1= ruleHyGreaterExpression
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
    // $ANTLR end synpred19_InternalConstraintDsl

    // $ANTLR start synpred20_InternalConstraintDsl
    public final void synpred20_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyLessOrEqualExpression_2 = null;


        // InternalConstraintDsl.g:1064:3: (this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression )
        // InternalConstraintDsl.g:1064:3: this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression
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
    // $ANTLR end synpred20_InternalConstraintDsl

    // $ANTLR start synpred21_InternalConstraintDsl
    public final void synpred21_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyLessExpression_3 = null;


        // InternalConstraintDsl.g:1076:3: (this_HyLessExpression_3= ruleHyLessExpression )
        // InternalConstraintDsl.g:1076:3: this_HyLessExpression_3= ruleHyLessExpression
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
    // $ANTLR end synpred21_InternalConstraintDsl

    // $ANTLR start synpred22_InternalConstraintDsl
    public final void synpred22_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyNotEqualExpression_4 = null;


        // InternalConstraintDsl.g:1088:3: (this_HyNotEqualExpression_4= ruleHyNotEqualExpression )
        // InternalConstraintDsl.g:1088:3: this_HyNotEqualExpression_4= ruleHyNotEqualExpression
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
    // $ANTLR end synpred22_InternalConstraintDsl

    // $ANTLR start synpred25_InternalConstraintDsl
    public final void synpred25_InternalConstraintDsl_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_operand2_3_0 = null;


        // InternalConstraintDsl.g:1666:4: ( () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) ) )
        // InternalConstraintDsl.g:1666:4: () otherlv_2= '-' ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
        {
        // InternalConstraintDsl.g:1666:4: ()
        // InternalConstraintDsl.g:1667:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,23,FOLLOW_23); if (state.failed) return ;
        // InternalConstraintDsl.g:1680:4: ( (lv_operand2_3_0= ruleHyAdditionExpression ) )
        // InternalConstraintDsl.g:1681:5: (lv_operand2_3_0= ruleHyAdditionExpression )
        {
        // InternalConstraintDsl.g:1681:5: (lv_operand2_3_0= ruleHyAdditionExpression )
        // InternalConstraintDsl.g:1682:6: lv_operand2_3_0= ruleHyAdditionExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getHySubtractionExpressionAccess().getOperand2HyAdditionExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_operand2_3_0=ruleHyAdditionExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25_InternalConstraintDsl

    // $ANTLR start synpred27_InternalConstraintDsl
    public final void synpred27_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyValueExpression_0 = null;


        // InternalConstraintDsl.g:1784:3: (this_HyValueExpression_0= ruleHyValueExpression )
        // InternalConstraintDsl.g:1784:3: this_HyValueExpression_0= ruleHyValueExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_HyValueExpression_0=ruleHyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalConstraintDsl

    // $ANTLR start synpred30_InternalConstraintDsl
    public final void synpred30_InternalConstraintDsl_fragment() throws RecognitionException {   
        EObject this_HyContextInformationReferenceExpression_2 = null;


        // InternalConstraintDsl.g:1808:3: ( ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression ) )
        // InternalConstraintDsl.g:1808:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
        {
        // InternalConstraintDsl.g:1808:3: ( ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression )
        // InternalConstraintDsl.g:1809:4: ( ruleHyContextInformationReferenceExpression )=>this_HyContextInformationReferenceExpression_2= ruleHyContextInformationReferenceExpression
        {
        pushFollow(FOLLOW_2);
        this_HyContextInformationReferenceExpression_2=ruleHyContextInformationReferenceExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_InternalConstraintDsl

    // Delegated rules

    public final boolean synpred7_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalConstraintDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalConstraintDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\2\uffff\4\0\5\uffff";
    static final String dfa_3s = "\1\27\2\uffff\4\0\5\uffff";
    static final String dfa_4s = "\1\uffff\1\1\5\uffff\1\4\1\5\1\2\1\6\1\3";
    static final String dfa_5s = "\3\uffff\1\0\1\1\1\2\1\3\5\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\uffff\1\1\10\uffff\1\6\1\uffff\1\10\1\7\2\uffff\1\4\1\5\1\1",
            "",
            "",
            "\1\uffff",
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

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "457:2: ( ( ( ruleHyArithmeticalComparisonExpression )=>this_HyArithmeticalComparisonExpression_0= ruleHyArithmeticalComparisonExpression ) | this_HyFeatureReferenceExpression_1= ruleHyFeatureReferenceExpression | this_HyNestedExpression_2= ruleHyNestedExpression | this_HyConditionalFeatureReferenceExpression_3= ruleHyConditionalFeatureReferenceExpression | this_HyNotExpression_4= ruleHyNotExpression | this_HyBooleanValueExpression_5= ruleHyBooleanValueExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalConstraintDsl()) ) {s = 1;}

                        else if ( (synpred8_InternalConstraintDsl()) ) {s = 9;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalConstraintDsl()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalConstraintDsl()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalConstraintDsl()) ) {s = 1;}

                        else if ( (synpred9_InternalConstraintDsl()) ) {s = 11;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
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
            "\1\3\1\uffff\1\2\10\uffff\1\6\5\uffff\1\4\1\5\1\1",
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

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1039:2: (this_HyGreaterOrEqualExpression_0= ruleHyGreaterOrEqualExpression | this_HyGreaterExpression_1= ruleHyGreaterExpression | this_HyLessOrEqualExpression_2= ruleHyLessOrEqualExpression | this_HyLessExpression_3= ruleHyLessExpression | this_HyNotEqualExpression_4= ruleHyNotEqualExpression | this_HyEqualExpression_5= ruleHyEqualExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalConstraintDsl()) ) {s = 7;}

                        else if ( (synpred19_InternalConstraintDsl()) ) {s = 8;}

                        else if ( (synpred20_InternalConstraintDsl()) ) {s = 9;}

                        else if ( (synpred21_InternalConstraintDsl()) ) {s = 10;}

                        else if ( (synpred22_InternalConstraintDsl()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index12_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000E68052L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000E68850L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000E69050L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000E6A050L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000E6C050L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000E78050L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000E68050L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000480002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000E08050L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000040L});

}