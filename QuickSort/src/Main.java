
public class Main {

	public static void main(String[] args) {

		QuickSort ordem = new QuickSort();

		int vetor[] = { 5, 2, 9, 4, 2, 6, 1, 88, 35, 11, 90, 12, 33, 13 };

		ordem.quick(vetor, 0, vetor.length - 1);

		for (int i = 0; i < vetor.length; i++) {

			System.out.print(vetor[i] + ", ");

		}

	}

}

