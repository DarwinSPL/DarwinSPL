package eu.hyvar.feature.data.util;

public class Tuple<T,S> {

	private T t;
	private S s;
	
	public Tuple() {
		
	}
	
	public Tuple(T t, S s) {
		this.t = t;
		this.s = s;
	}

	public T getFirstEntry() {
		return t;
	}

	public void setFirstEntry(T t) {
		this.t = t;
	}

	public S getSecondEntry() {
		return s;
	}

	public void setSecondEntry(S s) {
		this.s = s;
	}
	
	
	
}
