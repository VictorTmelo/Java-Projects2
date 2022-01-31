
public class Somatorio {
	

	public int soma(int vetor[]){

        int acumulador = 0;

        for(int i = 0; i < vetor.length; i++){

            acumulador = acumulador + vetor[i];
        }

        return acumulador;
    }
}
