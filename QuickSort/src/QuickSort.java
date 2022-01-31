
public class QuickSort {

	public void quick(int vetor[], int start, int end){
		
		if(start < end) {
			
			int posicao = separa(vetor,start,end);
			
			quick(vetor, start, posicao - 1);
			
			quick(vetor, posicao + 1, end);
			
		}
		
		
	}
	
	public int separa(int vetor[], int start, int end) {
		
		int pivo = vetor[start];
		
		int i = start + 1;
		
		int fim = end;
		
		while(i <= fim) {
			
			if(vetor[i] <= pivo) {
				
				i++;
				
			}else if(pivo < vetor[fim]){
				
				fim--;
				
			}else {
				
				int troca = vetor[i];
				
				vetor[i] = vetor[fim];
				
				vetor[fim] = troca;
				
				i++;
				
				fim--;
			}
			
		}
		
		vetor[start] = vetor[fim];
		
		vetor[fim] = pivo;
		
		return fim;
		
	}
}
