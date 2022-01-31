
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		MenorCaminho menorCaminho = new MenorCaminho();
		
		List<No> g = caminho();
		
		menorCaminho.run(g);
		
		No A = g.get(0);
		
		for(No n : g) {
			
			System.out.println(A.id + "-->" + n);
			
		}

	}
	
	public static List<No> caminho(){
		
		No A = new No("A");
		No B = new No("B");
		No C = new No("C");
		No D = new No("D");
		No E = new No("E");
		
		A.addTransition(B, 0);
		A.addTransition(C, 5);
		A.addTransition(D, 10);
		B.addTransition(E, 100);
		C.addTransition(E, 7);
		C.addTransition(D, 3);
		D.addTransition(E, 1);
		
		A.value = 0;
		A.ant = A.id;
		
		List<No> g = Arrays.asList(A,B,C,D,E);		
		
		return g;
	}

}
