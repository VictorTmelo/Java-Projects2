
public class Main {
	

	public static void main(String[] args) {
		
		System.out.println(fibDinamico(8) + fibRecursivo(8));
		
		System.out.println(fibRecursivo(4));
		
		System.out.println(fibMemorization(4));

	}
	
	
	public static int fibDinamico(int n) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int a = 0;
		int b = 1;
		
		int c = 0;
		
		for(int i = 0; i < n-1; i++) {
			
			c = a + b;
			
			a = b;
			
			b = c;
			
		}
		
		return c;
	}
	
	
	public static int fibMemorization(int n) {
		
		int mem[] = null;
		
		if(mem == null) mem = new int[n + 1];
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		if(mem[n] != 0) return mem[n];
		
		int l1 = fibMemorization(n - 1);
		
		mem[n - 1] = l1;
		
		int l2 = fibMemorization(n - 2);
		
		mem[n - 2] = l2;
		
		return mem[n - 1] + mem[n - 2];
		
	}
	
	
	public static int fibRecursivo(int n) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return fibRecursivo(n - 2) + fibRecursivo(n - 1);
		
	}
	
	
	
	

}
