import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		MergeSort merge = new MergeSort();
		
		int v[] = {2,1,3,8,4,7};
		
		merge.mergeSort(v, 0, v.length-1);
		
		System.out.println(Arrays.toString(v));

	}

}
