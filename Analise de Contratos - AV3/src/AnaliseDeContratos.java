import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AnaliseDeContratos {
    public static void main(String[] args) throws Exception {
        FileInputStream ir = new FileInputStream("src/entradaAV3.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(ir));
        Scanner input = new Scanner(System.in);

        int fornecedores = 0;
        int meses = 0;
        double taxa = 0.0;
        int fileSize = 0;
        int contratosPorFornecedor = 0;

        String linha[] = null;

        Contrato contratos[];
        Matriz matrix;

        Contrato contrato;

        String str = null;

        while (in.ready()) {
            str = in.readLine();

            linha = str.split(" ");

            if (linha.length > 3) {
                break;
            }

            meses = Integer.parseInt(linha[0]);
            fornecedores = Integer.parseInt(linha[1]);
            taxa = Double.parseDouble(linha[2]);
            // Iten B: Função de T(n, m) = (n^2+n)/2*m

            int m = fornecedores;
            int n = meses;
            int expo = (int) Math.pow(n, 2);

            contratosPorFornecedor = (expo + n) / 2;
            fileSize = contratosPorFornecedor * m;
        }

        ir.getChannel().position(0);
        contratos = new Contrato[(int) fileSize];
        matrix = new Matriz(fornecedores, meses, fileSize);

        in = new BufferedReader(new InputStreamReader(ir));

        int index = 0;

        while (in.ready()) {
            str = in.readLine();

            linha = str.split(" ");

            if (linha.length > 3) {
                contrato = new Contrato(linha[0], linha[1], linha[2], linha[3]);
                contratos[index] = contrato;
                matrix.contratosMatrix[Integer.parseInt(linha[0])][Integer.parseInt(linha[1])][Integer
                        .parseInt(linha[2])] = Double.parseDouble(linha[3].replace(",", "."));// cont++;//x*/

                index++;
            }
        }

        in.close();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println(" ");
            System.out.println("Escolha sua operação:");
            System.out.println("1 - Dijkstra.");
            System.out.println("2 - Guloso.");
            System.out.println("3 - Parentização Dinamica.");
            System.out.println("0 - SAIR");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                   /*MenorCaminho menorCaminho = new MenorCaminho(contratos, taxa);
                    menorCaminho.caminho();
                    menorCaminho.run(menorCaminho.g);

                    No A = menorCaminho.g.get(0);

                    for (No n : menorCaminho.g) {
                        System.out.println(A.id + "-->" + n);
                    }*/

                    Dijkstra dijkstra = new Dijkstra(matrix.contratosMatrix);
                    dijkstra.sp(taxa);
                    break;
                case 2:
                    Guloso.min(matrix.contratosMatrix);

                    long t = System.currentTimeMillis();
                    Guloso.run(matrix.contratosMatrix, taxa);
                    t = System.currentTimeMillis() - t;

                    System.out.println("Tempo Guloso: " + t);
                    break;
                case 3:
                    ParentizacaoDinamica p = new ParentizacaoDinamica();
                    p.min(matrix.contratosMatrix);
                    p.dinamico(taxa);
                    // double[][] s = ParentizacaoDinamica.dinamico();

                    // a = 1;
                    break;
            }
        }

        input.close();
    }
}
