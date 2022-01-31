
public class MergeSort {

	public void mergeSort(int array[], int start, int end) {
		
        if (start < end) {
        	
            int metade = Math.abs((start + end) / 2);
           
            mergeSort(array, start, metade);
            mergeSort(array, metade + 1, end);
            merge(array, start, metade, end);
        }

    }
	
	
	public void merge(int array[], int start, int metade, int end) {
       
        int leftLength = metade - start + 1;
        int rightLength = end - metade;

        int leftArray[] = new int[leftLength + 1];
        int rightArray[] = new int[rightLength + 1];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[start + i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[metade + i + 1];
        }
        
        leftArray[leftLength] = Integer.MAX_VALUE;
        rightArray[rightLength] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = start; k <= end; k++) {
            
            if (leftArray[i] <= rightArray[j]) {
            	
                array[k] = leftArray[i];
                
                i++;
                
            } else {
            	
                array[k] = rightArray[j];

                j++;
            }
        }
        
	}
}
