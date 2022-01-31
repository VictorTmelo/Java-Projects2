import java.util.Arrays;

public class Dijkstra {
    private int[][] fornecedores = null;
    private double[][] values = null;
    double taxaTotal = 0;// 1

    public Dijkstra(double[][][] contratos) {
        min(contratos);
    }

    public void min(double[][][] contratos) {
        fornecedores = new int[contratos[0].length][contratos[0].length];
        values = new double[contratos[0].length][contratos[0].length];

        for (int i = 1; i < contratos[0].length; i++) {
            for (int j = i; j < contratos[0].length; j++) {
                values[i][j] = Double.MAX_VALUE;

                for (int f = 1; f < contratos.length; f++) {
                    if (contratos[f][i][j] < values[i][j]) {
                        values[i][j] = contratos[f][i][j];
                        fornecedores[i][j] = f;
                    }
                }
            }
        }
    }

    public int minDistance(double[] distancia, boolean[] visitou) {
        // T(n) = 4n
        // O: n

        int index = Integer.MAX_VALUE;// 1
        double comparaDistancia = Double.MAX_VALUE;// 1

        for (int i = 1; i < distancia.length; i++) {// n
            if (!visitou[i] && distancia[i] < comparaDistancia) {// n-1
                comparaDistancia = distancia[i];// O: n-1
                index = i;// O: n-1
            }
        }

        return index;// 1
    }

    public void sp(double taxa) {
        //T(n): 4n-6 + n-2 * 4n + 5(n-2*n)-4 + print: 6c+6 + 4
        //O: n ^ 2

        double distancia[] = new double[values.length];// 1
        boolean visitou[] = new boolean[values.length];// 1
        int[] caminhos = new int[distancia.length];// 1
        double[] caminho = new double[distancia.length];// 1

        for (int a = 2; a < values.length; a++) {// n-1
            distancia[a] = Double.MAX_VALUE;// n-2
        }

        distancia[1] = 0;// 1

        for (int a = 1; a < values.length - 1; a++) {// n-1
            int vertice = minDistance(distancia, visitou);// n-2 * 4n
            visitou[vertice] = true;// n-2

            for (int j = 1; j < values.length; j++) {// n-2 * n
                if (!visitou[j] && values[vertice][j] != 0 && distancia[vertice] + values[vertice][j] + taxa < distancia[j]) {// n-2*n-1
                    distancia[j] = distancia[vertice] + values[vertice][j];// O: n-2*n-1
                    caminhos[j] = vertice;// O: n-2*n-1
                    caminho[j] = values[vertice][j];// O: n-2*n-1
                }
            }
        }

        print(caminhos, caminho, taxa);//6c+6
        System.out.printf("Total: %1.2f\n", distancia[distancia.length - 1] + taxaTotal);// 1
    }

    public void print(int[] fornecedores, double[] values, double taxa) {
        // T(c) = 6c+6
        // Θ(c)

        // int cont = 0;

        int j = values.length - 1;// 1
        int aux;// 1

        do {
            aux = fornecedores[j];// c+1

            if (aux != 0) {// c+1
                System.out.printf("%d %d %d %1.2f\n", this.fornecedores[aux][j], fornecedores[j], j, values[j]);// c
            }

            taxaTotal += taxa;// c+1
            // cont++;

            j = fornecedores[j];// c+1
        } while (j != 0);// c+1

        // System.out.println(cont);
    }
}
