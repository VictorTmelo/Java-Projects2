import java.util.ArrayList;

public class No implements Comparable<No>{

	protected int value = Integer.MAX_VALUE;
	protected final String id;
	protected String ant = "";
	
	protected final ArrayList<Transition> transitions = new ArrayList<Transition>();
	
	public No(String id) {
		this.id = id;
	}
	
	
	public void addTransition(No n, int custo) {
		
		transitions.add(new Transition(n, custo));
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof No) {
			
			No n = (No)obj;
			return this.id.equals(n.id);
			
		}
		
		return false;
	}
	
	
	@Override
	public int hashCode() {
		
		return this.id.hashCode();
		
	}
	
	@Override
	public String toString() {
		
		return "[ant=" + this.ant + " , Id=" + this.id + " , value=" + this.value + "]";
		
	}


	@Override
	public int compareTo(No no) {
		
		if(this.value < no.value) return -1;
		if(this.value > no.value) return 1;
			
		return this.id.hashCode() < no.id.hashCode()?-1:1;
	}
		
	
}
