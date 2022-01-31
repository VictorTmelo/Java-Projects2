public class Matriz {
    double[][][] contratosMatrix;
    int fornecedores;
    int meses;
    int length;

    Matriz(int fornecedores, int meses, int fileSize) {
        // Equação: m + 1 + (m*n) * 2 + 1 
        // Θ(m, n)
        // int cont = 0;
        this.fornecedores = fornecedores;// 1
        this.meses = meses;// 1
        this.length = fileSize;//1

        this.contratosMatrix = new double[fornecedores+1][meses+1][meses+1];// cont++;//1

        /*for (int i = 0; i < fornecedores; i++) {//m+1
            for (int j = 0; j < meses; j++) {//m*n+1
                this.contratosMatrix[i][j] = new double[meses - j];//m*n
            }
        }*/
    }
}
