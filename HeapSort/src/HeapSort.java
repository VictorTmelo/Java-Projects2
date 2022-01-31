
public class HeapSort {
	
	//Filho esquerdo
	public int left(int i) {
		
		return 2 * i + 1;
	}
	
	//Filho direito
	public int right(int i) {
		
		return 2 * i + 2; 
	}

	
	//v = vetor
	//i = indice do nó a sofrer o maxHeapify
	//n = tamanho do vetor
	//Aplica o Max-Heap
	public void maxHeapify(int v[], int n, int i) {
		
		int largest;
	
		int left = this.left(i);
		
		int right = this.right(i);
		
		// LADO ESQUERDO
		
		if(left < n && v[left] > v[i]) {
			
			largest = left;
			
		}else {
			
			largest = i;
		}
		
		
		// LADO DIREITO
		
		if(right < n && v[right] > v[largest]) {
			
			largest = right;
			
		}
		
		
		if(largest != i) {
			
			// TROCA
			int aux = v[i];
			
			v[i] = v[largest];
			v[largest] = aux;
			
			
			// RECURSÃO
			maxHeapify(v,n, largest);
		}
		
	}
	
	
	//v = vetor
	//n = tamanho do vetor
	//Constroi o Max-Heap em todo o vetor
	public void buildMaxheap(int v[], int n) {
		
		//Do ultimo nó com filho até a raiz
		for(int i = (int)Math.floor(n / 2) - 1; i >= 0; i--) {
			
			maxHeapify(v, n, i);
		}
		
	}
	
	
	//v = vetor
	//Ordena o Vetor
	public void heapSort(int v[]) {
		
		int heapsize = v.length;
		
		buildMaxheap(v, heapsize);
		
		for(int i = heapsize - 1; i > 0; i--) {
			
			// TROCA
			int aux = v[0];
			
			v[0] = v[i];
			v[i] = aux;
			
			//diminuir tamanho do vetor?
			//v.length-- ?
			
			maxHeapify(v, i, 0);
			
		}
		
	}
	
	
}
