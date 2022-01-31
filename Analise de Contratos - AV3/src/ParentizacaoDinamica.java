import java.util.Arrays;

public class ParentizacaoDinamica {

    private int[][] fornecedores = null;//1
    private double[][] values = null;//1
    int cont = 0;

    public void dinamico(double taxa) {
        //T(n): n+1 + 4*(n^2+n)/2)+1 + 5*Somatorio: l(1...120) (l-1)*(n-l+1)+1 + print: c*2 + 2c+2
        //O(n^3)

        //int cont = 0;
        int n = values[0].length - 1;//1
        double[][] m = new double[n + 1][n + 1];//1
        int[][] s = new int[n + 1][n + 1];//1

        //System.out.println(n);

        for (int l = 1; l <= n; l++) {//n+1
            for (int i = 1; i <= (n - l + 1); i++) {//(n^2+n)/2)+1
            
                int j = i + l - 1;//(n^2+n)/2

                m[i][j] = values[i][j];//(n^2+n)/2
                s[i][j] = j;//(n^2+n)/2

                for (int k = i; k < j; k++) {//Somatorio: l(1...120) (l-1)*(n-l+1)+1
                    
                    double q = m[i][k] + m[k + 1][j] + taxa;//Somatorio

                    if (q < m[i][j]) {//Somatorio
                        //cont++;

                        s[i][j] = k;//O: Somatorio

                        m[i][j] = q;//O: Somatorio
                    }
                }
            }
        }

        //System.out.println(cont);

        imprime(s, values, fornecedores, 1, n);//T(c): c*2 + 2c+2
        //System.out.println(cont);
        System.out.printf("Total: %1.2f\n", m[1][n]);//1
    }

    public void min(double[][][] contratos) {

        fornecedores = new int[contratos[0].length][contratos[0].length]; //1
        values = new double[contratos[0].length][contratos[0].length]; //1

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

    public void imprime(int[][] s, double[][] v, int[][] f, int i, int j) {
        //T(c): c*2 + 2c+2
        //Θ(c)

        cont++;
        
        if (s[i][j] == j) {//n*2-1
            System.out.printf("%d %d %d %1.2f\n", f[i][j], i, j, v[i][j]);//n/2+1
            cont++;
            return;//n/2+1
        }

        cont++;
        imprime(s, v, f, i, s[i][j]);//n/2
        imprime(s, v, f, s[i][j] + 1, j);//n/2
    }
}
