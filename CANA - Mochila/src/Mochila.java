
public class Mochila {

	private int w;
	private int vi[];
	private int wi[];
	private int m[][];
	
	
	public Mochila(int w, int[] vi, int[] wi) {
		
		this.w = w;
		this.vi = vi;
		this.wi = wi;
		
		int l = this.wi.length + 1;
		int c = this.w + 1;
		
		this.m = new int[l][c];
		
	}
	
	
	public int maximo() {
		
		if(wi.length != vi.length) return Integer.MAX_VALUE * -1;
		
		int n = wi.length;
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 1; j <= w; j++) {
				
				if(wi[i-1] <= j) {
					
					m[i][j] = Math.max(vi[i-1] + m[i-1][j - wi[i-1]] , m[i-1][j]);
				}
				
				else m[i][j] = m[i-1][j];
			}
		}
		
		return m[n][w];
	}
	
}
