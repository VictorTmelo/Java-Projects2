
public class Dinamico {

	public static int m[][] = null;
	
	public static int s[][] = null;
	
	
	public static void run(int p[]) {
		
		int n = p.length - 1;
		
		long t = System.currentTimeMillis();

		dinamico(p);
		
		t = System.currentTimeMillis() - t;
		
		Imprime.parentizar(s);
		
		System.out.println("Tempo Dinamico: " + t);
		System.out.println();
		
	}
	
	private static void dinamico(int p[]) {
		
		int n = p.length - 1;
		
		m = new int[n + 1][n + 1];
		s = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) 
			m[i][i] = 0;
		
			
			for(int l = 2; l <= n; l++) {
				
				for(int i = 1; i <= (n - l + 1); i++) {
					
					int j = i + l - 1;
					
					m[i][j] = Integer.MAX_VALUE;
					
					for(int k = i; k < j; k++) {
						
						int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
						
						if(q < m[i][j]) {
							
							m[i][j] = q;
							s[i][j] = k;
						}
					}
				}
			}
			
	}
	
	
}
