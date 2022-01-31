
public class Main {

	public static void main(String[] args) {
		
		int []vi = {100,70,50,10,80,30};
		
		int []wi = {10,4,6,12,2,2};
		
		int w = 14;
		
		Mochila mochila = new Mochila(w, vi, wi);
		
		int total = mochila.maximo();
		
		System.out.println("Valor que consigo deixar dentro da mochila: " + total);
	}

}
