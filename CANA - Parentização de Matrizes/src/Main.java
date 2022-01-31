
public class Main {

	public static void main(String[] args) {
		
		int p[] = {30,35,15,5,10,20,25};
		
		Recursivo.run(p);
		
		Guloso.run(p);
		
		RecursivoMemorization.run(p);
		
		Dinamico.run(p);
	}
	
	
}
