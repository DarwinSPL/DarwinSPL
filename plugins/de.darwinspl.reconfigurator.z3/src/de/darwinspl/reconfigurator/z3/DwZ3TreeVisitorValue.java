package de.darwinspl.reconfigurator.z3;
import com.microsoft.z3.Expr;


/**
 * 
 * Object needed for the DwZ3TreeVisitor as a return value
 * 
 * @author Anna-Liisa
 *
 */
public class DwZ3TreeVisitorValue {
	
	
	private String tokenString;
	
	
	private Expr expr;
	
	
	public DwZ3TreeVisitorValue(String text) {
		this.setTokenString(text);
	}


	public String getTokenString() {
		return tokenString;
	}


	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}


	public Expr getExpr() {
		return expr;
	}


	public void setExpr(Expr expr) {
		this.expr = expr;
	}

}
