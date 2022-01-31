
public class Main {

	public static void main(String[] args) {
		
		Somatorio soma = new Somatorio();
		
		Fibonacci fibo = new Fibonacci();
		
		NumeroPrimo primo = new NumeroPrimo();
		
		MaximoDivisor mdc = new MaximoDivisor();
		
		QuickSort quicksort = new QuickSort();
		
		Contagem contagem = new Contagem();
		
		int vetor[] = {1,2,3,4,5,6,7,8,9};
		
		System.out.println("Soma dos números: " + soma.soma(vetor));
		
		System.out.println("Número fibonacci: " + fibo.fibo(6));
		
		int num = 4;
		
		System.out.println("Numero " + num + " é primo ? " + primo.primo(num));
		
		int numero = -5;
		
		System.out.println("Algoritmo contagem do número " + numero +  ": " + contagem.contagem(numero));
		
		System.out.println();
		
		int vetor2[] = {25,12,17,9,5,90,276,10,3};
		
		quicksort.quick(vetor2, 0, vetor2.length - 1);
		
		System.out.print("Vetor após ordenação por QuickSort: ");
		
		for(int i = 0; i < vetor2.length; i++) {
			
			System.out.print(vetor2[i]+ ", ");
			
		}
		System.out.println();
		
		System.out.println();
		System.out.println("MDC Recursivo: ");
		System.out.println();
		
		System.out.println("mdc(30, 60) = " + mdc.mdcRecursivo(30, 60));
	    System.out.println("mdc(50, 12) = "+ mdc.mdcRecursivo(50, 12));
	    System.out.println("mdc(100, 11) = "+ mdc.mdcRecursivo(100, 11));
	     
	    System.out.println();
	    System.out.println("MDC Iterativo: ");
	    System.out.println();
	    
        System.out.println("mdc(30, 60) = "+ mdc.mdcIterativo(30, 60));
        System.out.println("mdc(50, 12) = "+ mdc.mdcIterativo(50, 12));
        System.out.println("mdc(100, 11) = "+ mdc.mdcIterativo(100, 11));
	     
	        
	        
		 
	       
	    }

	}

