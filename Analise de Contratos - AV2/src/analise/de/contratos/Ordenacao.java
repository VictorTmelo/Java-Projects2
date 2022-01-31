package analise.de.contratos;

public class Ordenacao {

    // METODO QUICK SORT
    //int cont = 0;

    public void quick(Contrato vetor[], int start, int end) {
        //T(n) = n log(base 2) n + n
        //T(n)= Θ(n log n)
        //Analise detalhada: https://jamboard.google.com/d/1QtR-jkwRtS5Zgig4fNrokAHW6-PnLXL-7MrDpKPDgMw/edit?usp=sharing

        if (start < end) {
            //cont++;
            int posicao = separa(vetor, start, end);

            quick(vetor, start, posicao - 1);
            quick(vetor, posicao + 1, end);
        }

    }

    public int separa(Contrato vetor[], int start, int end) {
        //Θ(n)

        Contrato pivo = vetor[start];// 1
        int i = start + 1;// 1
        int fim = end;// 1

        while (i <= fim) {// n+1
            if (vetor[i].getValor() <= pivo.getValor()) {// n
                i++;

            } else if (pivo.getValor() < vetor[fim].getValor()) {// n
                fim--;
            } else {// n
                Contrato troca = vetor[i];

                vetor[i] = vetor[fim];
                vetor[fim] = troca;

                i++;
                fim--;
            }
        }

        vetor[start] = vetor[fim];//1
        vetor[fim] = pivo;//1

        return fim;//1
    }

    // FIM QUICK SORT

    // METODO INSERTION SORT

    public void insertionSort(Contrato vetor[]) {

        // melhor caso = 5n-4
        // pior caso = 4n-3 + 2 * ((n^2-n)/2)

        // melhor caso Θ(n)
        // pior caso Θ(n^2)

        for (int i = 1; i < vetor.length; i++) {// n
            Contrato key = vetor[i];// n-1
            int index = i - 1;// n-1

            // n-1 (Caso seja o melhor caso, o loop sera checado n-1 vezes e nao entrara
            // nenhuma vez)
            // Caso seja pior caso analisa abaixo o loop fica com a seguinte analise
            for (int aux = index; index >= 0 && vetor[index].getValor() > key.getValor(); index--) {// PA(1,2,3....n-1),
                                                                                                    // (1+n-1)*n-1/2,
                                                                                                    // n^2-n/2

                vetor[index + 1] = vetor[index];// PA(1,2,3....n-1), (1+n-1)*n-1/2 , n^2-n/2
            }

            vetor[index + 1] = key;// n-1
        }
    }

    // METODO HEAP-SORT
    // Filho esquerdo
    public int left(int i) {
        return 2 * i + 1;// 1
    }

    // Filho direito
    public int right(int i) {
        return 2 * i + 2;// 1
    }

    // v = vetor
    // i = indice do nó a sofrer o maxHeapify
    // n = tamanho do vetor
    // Aplica o Max-Heap
    public void maxHeapify(Contrato v[], int n, int i) {
        // Equação: T(n) = log(base 3) 2 n + 1
        // T(n) <= O(log n)

        int largest;// 1

        int left = this.left(i);// 1
        int right = this.right(i);// 1

        // LADO ESQUERDO
        if (left < n && v[left].getValor() > v[i].getValor()) {// 1
            largest = left;// x
        } else {
            largest = i;// y
        }
        // x ou y = 1

        // LADO DIREITO
        if (right < n && v[right].getValor() > v[largest].getValor()) {// 1
            largest = right;// pode ser 1
        }

        if (largest != i) {// 1
            // TROCA
            Contrato aux = v[i];// 1

            v[i] = v[largest];// 1
            v[largest] = aux;// 1

            // RECURSÃO
            maxHeapify(v, n, largest);// log(base 3) 2 n + 1
        }
    }

    public void minHeapify(Contrato v[], int n, int i) {
        // Equação: T(n) = log(base 3) 2 n + 1
        // T(n) <= O(log n)

        int smallest;// 1

        int left = this.left(i);// 1
        int right = this.right(i);// 1

        // LADO ESQUERDO
        if (left < n && v[left].getValor() < v[i].getValor()) {// 1
            smallest = left;// x
        } else {
            smallest = i;// y
        }
        // x ou y = 1

        // LADO DIREITO
        if (right < n && v[right].getValor() < v[smallest].getValor()) {// 1
            smallest = right;// pode ser 1
        }

        if (smallest != i) {// 1
            // TROCA
            Contrato aux = v[i];// 1

            v[i] = v[smallest];// 1
            v[smallest] = aux;// 1

            // RECURSÃO
            minHeapify(v, n, smallest);// log(base 3) 2 n + 1
        }
    }

    // v = vetor
    // n = tamanho do vetor
    // Constroi o Max-Heap em todo o vetor
    public void buildMaxheap(Contrato v[], int n) {
        // T(n) = n/2 + (n/2-1) * log(base 3) 2 n + 1
        // T(n) = O(n log n)

        // Do ultimo nó com filho até a raiz
        for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--) {// n/2
            maxHeapify(v, n, i);// (n/2-1) * log(base 3) 2 n + 1
        }
    }

    public void buildMinheap(Contrato v[], int n) {
        // T(n) = n/2 + (n/2-1) * log(base 3) 2 n + 1
        // T(n) = O(n log n)

        // Do ultimo nó com filho até a raiz
        for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--) {// n/2
            minHeapify(v, n, i);// (n/2-1) * log(base 3) 2 n + 1
        }
    }

        // v = vetor
    // Ordena o Vetor
    public void heapSort(Contrato v[]) {
        //T(n) = n/2 + ((n/2-1) * log(base 3) 2 n) + 1 + (4n-7) + (n-2) * (log(base 3) 2 n + 1)
        //T(n) = O(n log n)

        int heapsize = v.length;// 1

        buildMaxheap(v, heapsize);// n/2 + (n/2-1) * log(base 3) 2 n + 1

        for (int i = heapsize - 1; i > 0; i--) {// n-1
            // TROCA
            Contrato aux = v[0];// n-2

            v[0] = v[i];// n-2
            v[i] = aux;// n-2

            maxHeapify(v, i, 0);// n-2 * log(base 3) 2 n + 1
        }
    }

    // FIM HEAP-SORT

    // METODO MERGE-SORT
    // int cont3 = 0;
    public void mergeSort(Contrato array[], int start, int end) {
        //T(n) = n log(base 2) n + n
        //T(n)= Θ(n log n)
        //Analise detalhada: https://jamboard.google.com/d/1QtR-jkwRtS5Zgig4fNrokAHW6-PnLXL-7MrDpKPDgMw/edit?usp=sharing

        if (start < end) {
            int metade = (start + end) / 2;
            // System.out.println("metade " + metade);
            mergeSort(array, start, metade);
            mergeSort(array, metade + 1, end);
            merge(array, start, metade, end);
        }
    }

    public void merge(Contrato arrayToSort[], int start, int metade, int end) {
        // 7n + 11

        int leftLength = metade - start + 1;// 1
        int rightLength = end - metade;// 1

        Contrato leftArray[] = new Contrato[leftLength + 1];// 1
        Contrato rightArray[] = new Contrato[rightLength + 1];// 1

        for (int i = 0; i < leftLength; i++) {// n/2+1
            leftArray[i] = arrayToSort[start + i];// n/2
        }

        for (int i = 0; i < rightLength; i++) {// n/2+1
            rightArray[i] = arrayToSort[metade + i + 1];// n/2
        }

        leftArray[leftLength] = new Contrato(1, 1, 1, Double.MAX_VALUE);// 1
        rightArray[rightLength] = new Contrato(1, 1, 1, Double.MAX_VALUE);// 1

        int i = 0;// 1
        int j = 0;// 1

        // int cont = 0;
        // int cont1 = 0;

        for (int k = start; k <= end; k++) {// n+1
            
            if (leftArray[i].getValor() <= rightArray[j].getValor()) {// n
                arrayToSort[k] = leftArray[i];// -> = y
                // cont1++;
                i++;// -> = y
            } else {// n
                arrayToSort[k] = rightArray[j];// -> = z

                j++;// -> = z
            }
        } // Ou y ou z... 2n
    }

    // FIM MERGE-SORT

    // Albero-Renato-Victor-Sort

    public void Albero_Renato_Victor_Sort(Contrato contratos[]) {
        //n/2 + ((n/2-1) * log(base 3) 2 n) + 1 + (7n-13) + (n-2) * (log(base 3) 2 n
        //T(n) = O(n log n)

        int index = 0;//1
        Contrato[] aux = new Contrato[contratos.length];//1
        int heapsize = contratos.length;//1

        buildMinheap(contratos, heapsize);// n/2 + (n/2-1) * log(base 3) 2 n + 1

        while (heapsize - 1 > 0) {// n-1
            // TROCA
            Contrato aux2 = contratos[0];//n-2

            contratos[0] = contratos[heapsize - 1];//n-2
            contratos[heapsize - 1] = aux2;//n-2

            // ADD NO VETOR AUXILIAR
            aux[index] = contratos[heapsize - 1];//n-2

            // INCREMENTA O INDICE
            index++;//n-2

            // DIMINUI O TAMANHO DO HEAP, FUNCIONA COMO SE EXCLUISSE O QUE JA FOI ADICIONADO
            // NO VETOR AUXILIAR
            heapsize--;//n-2

            minHeapify(contratos, heapsize, 0);//n-2 * log(base 3) 2 n + 1
        }

        contratos = aux;//1
    }

    public Contrato[] Albero_Renato_Victor_Sort(Contrato contratos[][], int fileSize) {
        //T(n) = (2 meses + 1) + (meses * (n/2 + (n/2-1) * log(base 3) 2 n + 1)) + 
        //7 PA + (PA * n/2 + (n/2-1) * log(base 3) 2 n + 1)
        //T(n) = O(n^2 log n)

        Contrato orderedArray[] = new Contrato[fileSize];//1

        int index = 0;//1

        for (int i = 0; i < contratos.length; i++) {//meses+1

            int heapsize = contratos[i].length;//meses

            buildMinheap(contratos[i], heapsize);//meses * (n/2 + (n/2-1) * log(base 3) 2 n + 1)

            while (heapsize > 0) {//(fator = meses * fornecedores) (PA:(fator...fornecedores) Descrescente, Razão = fornecedores) + 1
                // TROCA
                Contrato aux = contratos[i][0];//PA

                contratos[i][0] = contratos[i][heapsize - 1];//PA
                contratos[i][heapsize - 1] = aux;//PA

                // ADD NO VETOR AUXILIAR
                orderedArray[index] = contratos[i][heapsize - 1];//PA

                // INCREMENTA O INDICE
                index++;//PA

                // DIMINUI O TAMANHO DO HEAP, FUNCIONA COMO SE EXCLUISSE
                // O QUE JA FOI ADICIONADO NO VETOR AUXILIAR
                heapsize--;//PA

                minHeapify(contratos[i], heapsize, 0);//PA * n/2 + (n/2-1) * log(base 3) 2 n + 1
            }
        }

        return orderedArray;//1
    }
}