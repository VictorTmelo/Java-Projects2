
public class Recursivo {
	
	public static int m[][] = null;
	
	public static int s[][] = null;
	
	public static void run(int p[]) {
		
		int n = p.length - 1;
		
		long t = System.currentTimeMillis();

		recursivo(p, 1, n);
		
		t = System.currentTimeMillis() - t;
		
		Imprime.parentizar(s);
		
		System.out.println("Tempo Recursivo: " + t);
		System.out.println();
		
	}

	private static int recursivo(int p[], int i, int j) {
		
		if(m == null || s == null) {
			
			int n = p.length - 1;
			
			m = new int[n+1][n+1];
			
			s = new int[n+1][n+1];
			
		}
		
		if(i == j) return 0;
		
		m[i][j] = Integer.MAX_VALUE;
		
		for(int k = i; k < j; k++) {
			
			int q = recursivo(p, i, k) + recursivo(p, k + 1, j) + p[i-1] * p[k] * p[j];
			
			if(q < m[i][j]) {
				
				m[i][j] = q;
				s[i][j] = k;
			}
			
		}
		
		return m[i][j];
	}
	
	
}
