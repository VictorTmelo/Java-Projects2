
public class Main {

	public static void main(String[] args) {
		
		System.out.println(soma2("12345"));
	}

	public static int soma(int numero) {
		
		int soma = 0;
        int resto;

      while (numero != 0) {
    	  
          resto = numero % 10;
          
          numero = numero/10;
          
          soma+=resto;

       }
      
      return soma;
      
	}
	
	
	public static int soma2(String x) {
		
		int soma = 0;
		
		String[] y = x.split(""); 
		
		for(int i = 0; i < x.length(); i++) {
			
			int p = Integer.parseInt(y[i]);
			
			soma += p;
			
		}
		
		return soma;
	}
	
}
