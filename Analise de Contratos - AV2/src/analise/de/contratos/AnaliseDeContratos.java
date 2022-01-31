package analise.de.contratos;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AnaliseDeContratos {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream ir = new FileInputStream("src/entrada_120_10.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(ir));
        Scanner input = new Scanner(System.in);

        String fornecedores = null;
        String meses = null;
        int fileSize = 0;
        int contratosPorFornecedor = 0;

        String linha[] = null;

        Contrato contratos[];
        Matriz matriz;
        Contrato contratosCopy[];

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
            // Iten B: Função de T(n, m) = (n^2+n)/2*m

            int m = Integer.parseInt(fornecedores);
            int n = Integer.parseInt(meses);
            int expo = (int) Math.pow(n, 2);

            contratosPorFornecedor = (expo + n) / 2;
            fileSize = contratosPorFornecedor * m;
        }

        ir.getChannel().position(0);
        contratos = new Contrato[(int) fileSize];
        matriz = new Matriz(Integer.parseInt(fornecedores), Integer.parseInt(meses), fileSize);

        in = new BufferedReader(new InputStreamReader(ir));

        int index = 0;

        while (in.ready()) {
            str = in.readLine();

            linha = str.split(" ");

            if (linha.length > 2) {
                contrato = new Contrato(linha[0], linha[1], linha[2], linha[3]);
                contratos[index] = contrato;
                matriz.contratosMatrix[Integer.parseInt(linha[0]) - 1][Integer.parseInt(linha[1]) - 1][Integer.parseInt(linha[2]) -  Integer.parseInt(linha[1])] = contrato;// cont++;//x

                index++;
            }
        }

        matriz.contratos = contratos;

        in.close();

        long comeco;

        int opcao = -1;

        while (opcao != 0) {
            System.out.println(" ");
            System.out.println("Escolha sua operação:");
            System.out.println("1 - Inserction sort.");
            System.out.println("2 - Merge sort.");
            System.out.println("3 - Heap sort.");
            System.out.println("4 - Quick sort.");
            System.out.println("5 - Albero Renato Victor Sort (Array).");
            System.out.println("6 - Albero Renato Victor Sort (Matriz).");
            System.out.println("0 - SAIR");
            opcao = input.nextInt();
            input.nextLine();

            Ordenacao o = new Ordenacao();

            switch (opcao) {
                case 1:
                    contratosCopy = copyArray(contratos);

                    comeco = System.currentTimeMillis();
                    o.insertionSort(contratosCopy);
                    System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;
                case 2:
                    contratosCopy = copyArray(contratos);

                    comeco = System.currentTimeMillis();

                    o.mergeSort(contratosCopy, 0, contratosCopy.length - 1);

                    System.out.println("tempo: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;
                case 3:
                    contratosCopy = copyArray(contratos);

                    comeco = System.currentTimeMillis();
                    o.heapSort(contratosCopy);
                    System.out.println("tempo: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;
                case 4:
                    contratosCopy = copyArray(contratos);

                    comeco = System.currentTimeMillis();
                    o.quick(contratosCopy, 0, contratosCopy.length - 1);
                    System.out.println("tempo: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;
                case 5:
                    contratosCopy = copyArray(contratos);

                    comeco = System.currentTimeMillis();
                    o.Albero_Renato_Victor_Sort(contratosCopy);
                    System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;

                case 6:
                    Contrato customMatrix[][] = matriz.getCustomMatrix();

                    comeco = System.currentTimeMillis();
                    contratosCopy = o.Albero_Renato_Victor_Sort(customMatrix, fileSize);
                    System.out.println("Tempo de execucao: " + (System.currentTimeMillis() - comeco) + " ms");

                    // writeOnFile(contratosCopy);
                    break;
            }
        }

        input.close();
    }

    public static Contrato[] copyArray(Contrato originalArray[]) {
        Contrato contratos[] = new Contrato[originalArray.length];//1

        for (int i = 0; i < originalArray.length; i++) {//n+1
            contratos[i] = originalArray[i];//n
        }

        return contratos;//1
    }

    public static void writeOnFile(Contrato contratosCopy[]) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream("src/resultado.txt");
        DataOutputStream output = new DataOutputStream(fileOutput);

        for (int i = 0; i < contratosCopy.length; i++) {
            String contratoString = Integer.toString(contratosCopy[i].getFornecedor()) + " ";
            contratoString += Integer.toString(contratosCopy[i].getMesInicial()) + " ";
            contratoString += Integer.toString(contratosCopy[i].getMesFinal()) + " ";
            contratoString += Double.toString(contratosCopy[i].getValor()) + "\n";

            output.writeChars(contratoString);
        }

        output.close();
    }
}
