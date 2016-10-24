package eu.hyvar.reconfigurator.input.exporter;

public class DomainTuple<T> {

	private T min;
	private T max;
	
	public DomainTuple() {
	}
	
	public DomainTuple(T min, T max) {
		this.min = min;
		this.max = max;
	}
	
	public T getMin() {
		return min;
	}
	
	public T getMax() {
		return max;
	}
	
	public void setMin(T min) {
		this.min = min;
	}
	
	public void setMax(T max) {
		this.max = max;
	}
	
}
