import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		InsertionSort insertion = new InsertionSort();
		
		int v[] = { 5, 3, 9, 4, 2, 6, 1, 88, 35, 11, 90, 12, 33, 13 };
		
		insertion.insertionSort(v);
		
		System.out.println(Arrays.toString(v));

	}

}
