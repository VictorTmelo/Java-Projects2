package analise.de.contratos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AnaliseDeContratos {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream ir = new FileInputStream("src/entrada_120_10.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(ir));
        Scanner input = new Scanner(System.in);
        //System.out.println(in.lines());

        String fornecedores = null;
        String meses = null;
        double fileSize = 0;

        String linha[] = null;
        Contrato contratos[];

        Contrato contrato;

        String str = null;

        while (in.ready()) {
            str = in.readLine();

            linha = str.split(" ");

            if (linha.length > 2) {
                break;
            }

            meses = linha[0];
            fornecedores = linha[1];
            //Iten B: Função de T(n, m) = (n^2+n)/2*m

            double m = Double.parseDouble(fornecedores);
            double n = Double.parseDouble(meses);
            double expo = Math.pow(n, 2);

            fileSize = (expo + n) / 2 * m;
        }

        ir.getChannel().position(0);
        contratos = new Contrato[(int) fileSize];

        in = new BufferedReader(new InputStreamReader(ir));

        int index = 0;

        while (in.ready()) {
            str = in.readLine();

            linha = str.split(" ");

            if (linha.length > 2) {
                contrato = new Contrato(linha[0], linha[1], linha[2], linha[3]);
                contratos[index] = contrato;
                index++;
            }
        }

        int opcao = -1;

        while (opcao != 0) {
            System.out.println(" ");
            System.out.println("Escolha sua operação:");
            System.out.println("1 - Contrato de menor valor de um dado fornecedor.");
            System.out.println("2 - Contrato de menor valor do mercado.");
            System.out.println("3 - Contrato de menor valor do mês 1 ao mês n.");
            System.out.println("4 - Contratos de menor valor para os próximos n meses.");
            System.out.println("0 - SAIR");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o número do fornecedor.");
                    int fornecedor = input.nextInt();

                    if (fornecedor <= Integer.parseInt(fornecedores) && fornecedor > 0) {
                        minValueProviderContract(contratos, fornecedor, Integer.parseInt(fornecedores));
                    }
                    break;
                case 2:
                    minValueMarketContract(contratos);
                    break;
                case 3:
                    System.out.println("Informe o mês n.");
                    int mes = input.nextInt();

                    minValueNMonthContract(contratos, mes);
                    break;
                case 4:
                    System.out.println("Informe o mês n.");
                    mes = input.nextInt();

                    System.out.println("Melhores contratos");

                    minValueNMonthContracts(contratos, Integer.parseInt(fornecedores), Integer.parseInt(meses));
                    break;
                default:
            }
        }
    }

    public static void minValueProviderContract(Contrato contratos[], int fornecedor, int fornecedores) {
        //x = (n^2+n)/2*m
        //f = fornecedor escolhido
        //T(m, n) = (3x/m)f+(2*x/m)+7 + 2x/m+1
        //Θ(n)
        int cont = 0;

        Contrato contratosFornecedor[];
        cont++; //1

        int index = 0;
        cont++;//1

        contratosFornecedor = new Contrato[contratos.length / fornecedores];
        cont++;//1
        

        for (int i = 0; i < contratos.length; i++) {cont++;//x/m * f + 1 

            cont++;
            if (contratos[i].getFornecedor() > fornecedor) {//x/m * f
                cont++;
                break;//1
            }

            cont++;
            if (contratos[i].getFornecedor() == fornecedor) {//x/m * f
                contratosFornecedor[index] = contratos[i];
                cont++;//x/m

                index++;
                cont++;//x/m
            }
        }

        Contrato contrato = new Contrato(1, 1, 1, Double.POSITIVE_INFINITY);
        cont++;//1

        cont++;
        for (int i = 0; i < contratosFornecedor.length; i++) {
            cont++;//x/m+1
            cont++;
            if (contratosFornecedor[i].getValor() < contrato.getValor()) {//x/m
                contrato = contratos[i];
                cont++;//O(n)
            }
        }

        System.out.println(contrato);
        cont++;//1
        System.out.println("passos: " + cont);
    }

    public static void minValueMarketContract(Contrato contratos[]) {
        //x = (n^2+n)/2*m
        //T(m, n) = 2x+3
        //Θ(n)
        int cont = 0;

        Contrato contrato = new Contrato(1, 1, 1, Double.POSITIVE_INFINITY);cont++;//1

        cont++;
        for (int i = 0; i < contratos.length; i++) {cont++;//x+1
            cont++;
            if (contratos[i].getValor() < contrato.getValor()) {//x
                contrato = contratos[i];//cont++;//O(n)
            }
        }

        System.out.println(contrato);cont++;//1
        System.out.println("passos: " + cont);
    }

    public static void minValueNMonthContract(Contrato contratos[], int mesEscolhido) {
        //x = (n^2+n)/2*m
        //T(m, n) = m + 2x + 3
        //Θ(n)
        int cont = 0;
        /*int cont0 = 0;
        int cont1 = 0;
        int cont2 = 0;*/

        Contrato contrato = new Contrato(1, 1, mesEscolhido, Double.POSITIVE_INFINITY);cont++;//1

        cont++;
        for (int i = 0; i < contratos.length; i++) {cont++;//x + 1
            cont++;
            if (contratos[i].getMesInicial() == 1 && contratos[i].getMesFinal() == mesEscolhido) {// x
                cont++;
                if (contrato.getValor() > contratos[i].getValor()) {// m
                    contrato = contratos[i];cont++;//O(n)
                }
            }
        }
        System.out.println(contrato.toString());
        cont++;//1

        /*System.out.println("cont " + cont);
        System.out.println("cont0 " + cont0);
        System.out.println("cont1 " + cont1);
        System.out.println("cont2 " + cont2);*/
        System.out.println("passos: " + cont);
    }

    public static void minValueNMonthContracts(Contrato[] contratos, int m, int n) {

        /*Contrato c = new Contrato(1, 1, 1, 0);

        int linhas = n;
        int colunas = n;
        int index = 0;
        int i = 1;
        int index2 = 0;
        int aux = 1;
        int fornecedor = 1;

        Contrato[][][] contrato = new Contrato[m][linhas][colunas];

        for (int j = 0; j < contratos.length; j++) {
            if (contratos[j].getMesInicial() == i && contratos[j].getFornecedor() == fornecedor) {
                contrato[fornecedor - 1][index2][aux - 1] = contratos[j];

                index++;
                aux++;

                if (index == n - i + 1) {
                    j = 0;
                    index = 0;
                    index2++;
                    i++;
                    aux = i;
                }

                if (index2 == n && aux == n + 1) {
                    fornecedor++;
                    index = 0;
                    index2 = 0;
                    i = 1;
                    aux = 1;
                    j = 0;
                }
            }
        }*/
        //x = (n^2+n)/2*m
        //(Somatório * 2 + 1 + (4 * pa) + 5 * n) + 8
        int cont = 0;//(2x+1) + 4PA + 6n

        Contrato c = new Contrato(1, 1, 1, 0);
        cont++;//1

        int linhas = n;
        cont++;//1
        int colunas = n;
        cont++;//1
        int index = 0;
        cont++;//1
        int i = 1;
        cont++;//1
        int index2 = 0;
        cont++;//1
        int aux = 1;
        cont++;//1

        Contrato[][] contrato = new Contrato[linhas][colunas];
        cont++;//1

        cont++;
        for (int j = 0; j < (1 + n) * n / 2; j++) {
            cont++;//Somatório: PA = PA - i + 1 sendo que i->(1...120)+1 
            cont++;//Somatório
            if (contratos[j].getMesInicial() == i && contratos[j].getFornecedor() == 1) {
                contrato[index2][aux - 1] = contratos[j];
                cont++;//PA: (1+n)*n/2

                index++;cont++;//PA
                
                aux++;cont++;//PA

                cont++;//PA
                if (index == n - i + 1) {//n

                    j = 0;cont++;//n
                    
                    index = 0;cont++;//n
                    
                    index2++;cont++;//n
                    
                    i++;cont++;//n
                    
                    aux = i;cont++;//n
                }
            }
        }

        //System.out.println("cont " + cont);
        //(n * 2 + 1) + ((n^2) * 2) + 1 + PA'
        int cont2 = 0;

        cont2++;
        for (int a = 0; a < linhas; a++) {
            cont2++;//n+1
            cont2++;//n
            for (int j = 0; j < colunas; j++) {
                cont2++;//n*n+1

                cont2++;//n*n
                if (contrato[a][j] == null) {
                    contrato[a][j] = c;
                    cont2++;//PA': (1...119)
                }
            }

        }
        cont2++;//n

        System.out.println("cont2 " + cont2);

        double distancia[] = new double[contrato.length];//1
        boolean visitou[] = new boolean[contrato.length];//1
        int[] caminhos = new int[distancia.length];//1
        Contrato[] caminho = new Contrato[distancia.length];//1

        distancia[0] = 0;//1

        contrato[0][6].setValor(44.0);//1
        contrato[7][42].setValor(195.0);//1
        contrato[43][119].setValor(449.3);//1

        for (int a = 1; a < contrato.length; a++) {//n+1

            distancia[a] = Integer.MAX_VALUE;//n
        }

        for (int a = 0; a < contrato.length; a++) {//n+1
            int vertice = minDistance(distancia, visitou);//n
            visitou[vertice] = true;//n

            for (int j = 0; j < contrato.length; j++) {//n*n+1
                if (!(contrato[vertice][j] == null)) {

                    if (!visitou[j]) {
                        if (distancia[vertice] == Integer.MAX_VALUE) {
                            distancia[j] = distancia[vertice] + contrato[vertice][j].getValor();
                        } else if (contrato[vertice][j].getValor() != 0 && distancia[vertice] + contrato[vertice][j].getValor() < distancia[j]) {
                            distancia[j] = distancia[vertice] + contrato[vertice][j].getValor();
                            caminhos[j] = vertice;
                            caminho[j] = contrato[vertice][j];
                        }
                    }
                }
            }
        }

        System.out.println(distancia[distancia.length - 1]);

        int j = contrato.length - 1;

        do {

            System.out.println(caminho[j]);
            j = caminhos[j];
            System.out.println(" <- " + j);

        } while (j != 0);
    }
    static int cont = 0;

    public static int minDistance(double[] distancia, boolean[] visitou) {

        int index = Integer.MAX_VALUE;//1
        double comparaDistancia = Integer.MAX_VALUE;//1

        for (int i = 0; i < distancia.length; i++) {//n+1

            if (!visitou[i] && distancia[i] < comparaDistancia) {
                cont++;
                comparaDistancia = distancia[i];
                index = i;

            }
        }

        return index;
    }
}
