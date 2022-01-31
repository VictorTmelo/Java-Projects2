
public class Guloso {
	

	public static void run(int p[]) {
		
		int n = p.length - 1;
	
		long t = System.currentTimeMillis();

		guloso(p, 1, n);
		
		t = System.currentTimeMillis() - t;
		
		System.out.println();
	
		System.out.println("Tempo Guloso: " + t);
		System.out.println();
		
	}

	private static int guloso(int p[], int i, int j) {
		
		if(i == j) {
			
			System.out.print("A" + i);
			return 0;
			
		}
		
		int qMin = Integer.MAX_VALUE;
		
		int kMin = i;
		
		for(int k = i; k < j; k++) {
			
			int q = p[i-1] * p[k] * p[j];
			
			if(q <= qMin) {
				
				qMin = q;
				kMin = k;
				
			}
		}
		
		System.out.print("(");
		int esq = guloso(p,i,kMin);
		int dir = guloso(p, kMin+1,j);
		System.out.print(")");
		return esq + dir + qMin;
	
	}
	
}
