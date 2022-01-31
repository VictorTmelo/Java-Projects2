package analise.de.contratos;

public class Matriz {
    Contrato[] contratos;
    Contrato[][][] contratosMatrix;
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

        this.contratosMatrix = new Contrato[fornecedores][meses][];// cont++;//1

        for (int i = 0; i < fornecedores; i++) {//m+1
            for (int j = 0; j < meses; j++) {//m*n+1
                this.contratosMatrix[i][j] = new Contrato[meses - j];//m*n
            }
        }
        // cont++;

        // System.out.println("cont " + cont);
    }

    public Contrato[][][] getMatrix() {
        return this.contratosMatrix;
    }

    public Contrato[][] getCustomMatrix() {
        int index = 0;//1
        int fator = 0;//1
        int fator1 = 0;//1

        int j = 0;//1
        int k = 0;//1

        int contractsPerType = this.meses * this.fornecedores;//1

        Contrato customMatrix[][] = new Contrato[this.meses][];//1

        //int cont = 0;

        for (int i = 0; i < this.meses; i++) {//n+1
            customMatrix[i] = new Contrato[contractsPerType - fator1];//n

            fator1 += this.fornecedores;//n
        }

        for (int i = 0; i < this.length; i++) {//Indeterminado+1
            //cont++;

            if (this.contratos[i].getMesFinal() - this.contratos[i].getMesInicial() == index) {//Indeterminado

                customMatrix[k][j] = this.contratos[i];//x
                j++;//x

                if (j == contractsPerType - fator) {//x
                    j = 0;//n
                    i = 0;//n
                    k++;//n
                    index++;//n
                    fator += this.fornecedores;//n
                }
            }
        }

        //System.out.println(cont);

        return customMatrix;//1
    }
}
