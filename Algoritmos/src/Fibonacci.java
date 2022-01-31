
public class Fibonacci {
	
	public int fibo(int x) {
		
		if(x == 0 || x == 1) {
			
			return x;
			
		}else {
			
			return fibo(x - 2) + fibo(x - 1);
		}
		
	}

}
