import java.util.Scanner;

public class Forca {

	Scanner sc = new Scanner(System.in);

	private int chances = 7;
	boolean controle = true;
	int acertou = 0;

	Palavra palavra0 = new Palavra("Cachorro", "Animal");
	Palavra palavra1 = new Palavra("Cama", "Objeto de casa");
	Palavra palavra2 = new Palavra("Celular", "Aparelho eletronico");
	Palavra palavra3 = new Palavra("Medico", "Profissão");
	Palavra palavra4 = new Palavra("Hospital", "Lugar público");
	Palavra palavra5 = new Palavra("Futebol", "Esporte");
	Palavra palavra6 = new Palavra("Windows", "Sistema operacional");
	Palavra palavra7 = new Palavra("Java", "Linguagem de programação");
	Palavra palavra8 = new Palavra("Fortnite", "Jogo");
	Palavra palavra9 = new Palavra("Coracao", "Orgão do corpo humano");

	private Palavra[] palavras = { palavra0, palavra1, palavra2, palavra3, palavra4, palavra5, palavra6, palavra7,
			palavra8, palavra9 };

	public void forca() {

		int x = (int) Math.floor(Math.random() * 10);

		System.out.print("Palavra selecionada: ");

		for (int i = 0; i < palavras[x].getPalavra().length(); i++) {
			System.out.print("_ ");
		}
		
		char word[] = palavras[x].getPalavra().toCharArray();
		
		char resposta[] = new char[word.length];
		
		for(int j = 0; j < word.length; j++) {
			resposta[j] = '_';
		}

		while (controle == true) {

			System.out.println("\n");
			System.out.println("Voce tem " + chances + " chances, qual letra deseja arriscar ? ");
			String letra = sc.next();

			if (palavras[x].getPalavra().toLowerCase().contains(letra.toLowerCase())) {

				acertou++;

				System.out.println("Letra correta");

				System.out.print("Palavra selecionada: ");

				for (int i = 0; i < word.length; i++) {

					if (word[i] == letra.charAt(0)) {
						
						resposta[i] = letra.charAt(0);

						System.out.print(resposta[i] + " ");
						
					} else {

						System.out.print(resposta[i] + " ");
					}

				}

			} else {

				chances--;

				System.out.println("\n");
				System.out.println("Letra errada, restam " + chances + " chances");

				if (chances == 1) {

					System.out.println("A sua dica especial é: " + palavras[x].getDica());
				}
			}

			if (chances == 0) {

				System.out.println("Você perdeu!");

				controle = false;
			}

			if (acertou == palavras[x].getPalavra().length()) {

				System.out.println("Você acertou a palavra, Parabens!");

				controle = false;

			}

		}

	}

}
