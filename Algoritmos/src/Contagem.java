
public class Contagem {

	public int contagem(int x) {
		
		int maior;
		
		int menor;
		
		if(x > 1) {
			
			maior = x;
			
			menor = 1;
			
		}else {
			
			maior = 1;
			
			menor = x;
			
		}
		
		return maior - menor + 1;
		
	}
}
