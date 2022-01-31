
public class Imprime {

	public static void parentizar(int s[][]) {
		
		parentizar(s, 1, s.length-1);
		System.out.println();
	}

	
	public static void parentizar(int s[][], int i, int j) {
		
		if(i == j) {
			System.out.format("A%d", i);
			return;
		}
		
		System.out.print("(");
		parentizar(s, i, s[i][j]);
		parentizar(s, s[i][j] + 1, j);
		System.out.print(")");
		
	}
	
	public static void printMatrix(int a[][]) {
		
		for(int i = 1; i < a.length; i++) {
			
			System.out.format("[ ");
			
			for(int j = 1; j < a[0].length; j++) 
				System.out.format(getString(a[i][j], 6) + "{" + i + "." + j + "}" + " ");
				
			System.out.format("]\n");
		}
		
	}
	
	public static String getString(int v, int len) {
		
		String f = "" + v;
		
		int mais = f.length() > len?0:len-f.length();
		
		for(int i = 0; i < mais; i++)
			f = " " + f;
		
		return f;
		
	}
}
