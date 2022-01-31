
public class MaximoDivisor {
	
	public int mdcRecursivo(int x, int y){
		
		if(y == 0) {
			
			return x;
			
		}else {
			
			return mdcRecursivo(y, x % y);
		}
		
	}
	
	public int mdcIterativo(int x, int y){
		
		while(y != 0) {
			
			int r = x % y;
			
			x = y;
			
			y = r;
			
		}
		
		return x;
		
	}

}
