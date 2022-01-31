
public class Guloso {
    private static int[][] fornecedores = null;// 1
    private static double[][] values = null;// 1
    private static double total = 0;// 1
    static int cont = 0;

    public static void run(double[][][] contratos, double taxa) {
        guloso(1, values[0].length - 1, taxa);//

        System.out.printf("Total: %1.2f\n", total - taxa);// 1

        System.out.println(cont);
        total = 0;// 1
    }

    public static double guloso(int i, int j, double taxa) {
        // O: n

        if (i == j) {//O: n
            System.out.printf("%d %d %d %1.2f\n", fornecedores[i][j], i, j, values[i][j]);// 1
            total += values[i][j] + taxa;// 1

            return values[i][j];// 1
        }

        double qMin = values[i][j]; // 1
        int kMin = j; // 1

        for (int k = i; k < j; k++) {// j+1

            double q = values[i][k] + values[k + 1][j] + taxa;// j
            //cont++;

            if (qMin > q) {// j
                kMin = k;//O: j
                qMin = q;//O: j
                //cont++;
            }
        }

        //cont++;

        if (kMin == j) {//O: n
            System.out.printf("%d %d %d %1.2f\n", fornecedores[i][j], i, j, qMin);//c
            //cont++;
            total += qMin + taxa;//c

            return qMin;//c
        }

        //cont++;

        double esq = guloso(i, kMin, taxa);// (O: n)-1
        double dir = guloso(kMin + 1, j, taxa);// (O: n)-1

        return esq + dir;//c-1
    }

    public static void min(double[][][] contratos) {

        fornecedores = new int[contratos[0].length][contratos[0].length]; // 1
        values = new double[contratos[0].length][contratos[0].length]; // 1

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
}
