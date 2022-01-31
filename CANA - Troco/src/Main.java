
public class Main {
	
	public static int mem[] = null;

	public static void main(String[] args) {
		
		int troco = 35;
		
		int [] caixa = {1,2,3,4,7};
		
		long t = System.currentTimeMillis();
		
		int x = trocoDinamico(troco, caixa);
		
		System.out.println("Tempo Troco dinamico em TimeMillis: " + (System.currentTimeMillis() - t));
		
		System.out.println("Cedulas qtd: " + x);
		
	    t = System.currentTimeMillis();
		
		x = trocoGuloso(troco, caixa);
		
		System.out.println("Tempo Troco guloso em TimeMillis: " + (System.currentTimeMillis() - t));
		
		System.out.println("Cedulas qtd: " + x);
		System.out.println();
		
	    t = System.currentTimeMillis();
	    
		x = trocoMemorization(troco, caixa);
		
		System.out.println("Tempo Troco Memorization em TimeMillis: " + (System.currentTimeMillis() - t));
		
		System.out.println("Cedulas qtd: " + x);

	}
	
	
	public static int trocoDinamico(int troco, int caixa[]) { 
		
		int[] q = new int[troco + 1];
		int[] c = new int[troco + 1];

		for (int i = 1; i <= troco; i++) {
			q[i] = Integer.MAX_VALUE;

			for (int j = 0; j < caixa.length; j++) {
				
				q[0] = 0;

				if (i - caixa[j] >= 0) {

					if (q[i - caixa[j]] + 1 < q[i]) {
						
						q[i] = q[i - caixa[j]] + 1;
						
						c[i] = Math.max(c[i], caixa[j]);
						
					}

				}
			}
		}

		imprimeDinamico(c, troco);
		return q[troco];
	}
	
	
	public static void imprimeDinamico(int[] c, int troco) {
		
		int count = 0;
		
		int i = c.length - 1;
		
		while (count != troco) {
			
			System.out.println(c[i]);
			
			count += c[i];
			
			i -= c[i];
			
		}
		
	}
	
	
	/* Melhor caso T(troco, caixa.length) = troco * caixa.length+1 + 2*troco + 2
	 * 
	 * exemplo: troco = 8, length = 3, caixa = [1,2,8]
	 * 
	 * Pior caso T(troco, caixa.length) = troco * caixa.length+1 + 2*troco + 2
	 * 
	 * exemplo: troco = 8, length = 3, caixa = [1,10,20]
	 */
	public static int trocoGuloso(int troco, int caixa[]) { 
		
		int t = troco; 
		int qtd = 0; 
		int k = caixa.length-1; 
		
		int checkSum = 0; 
		
		if(caixa.length == 0 || troco == 0) return 0; 
		
		for(; k >= 0 && t > 0; ) {
			
			if(t - caixa[k] >= 0) {
				
				t -= caixa[k]; 
				checkSum += caixa[k];
				qtd++;
				System.out.println(caixa[k]);
			}
			
			else k--;
			  
		}
		
		return troco==checkSum?qtd:-1;
		
	}
	
	
	public static int trocoRecursivo(int troco, int caixa[]) {
		
		if(troco != 0) {
			
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i < caixa.length; i++) {
				
				if(troco - caixa[i] >= 0) {
					
					int q  = trocoRecursivo(troco - caixa[i], caixa) + 1;
					
					if(q < 0) q = Integer.MAX_VALUE;
					
					if(q < min) min = q;
					
				}
				
			}
			
			return min;
			
		}
		
		return 0;
	}
	
	
	public static int trocoMemorization(int troco, int caixa[]) {
		
		int q;
		
		if (mem == null) mem = new int[troco + 1];
		
		
		for (int i = 0; i <= troco; i++) 
			mem[i] = -1;
			
		
		if (troco != 0) {
			
			int qMin = Integer.MAX_VALUE;
			
			for (int i = 0; i < caixa.length; i++) {
				
				if (troco - caixa[i] >= 0) {
					
					if (mem[troco - caixa[i]] == -1) {
						
						q = trocoMemorization(troco - caixa[i], caixa) + 1;
						
						mem[troco - caixa[i]] = q;
						
								
					} else {
						
						q = mem[troco - caixa[i]];
						
					}
					
					if (q < 0) q = Integer.MAX_VALUE;
						
					if (q < qMin) qMin = q;
						
				}
				
			}

			return qMin;
		}

		return 0;
	}
	

}
