import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		boolean saida = false;
		
		while(saida == false) {
			
			System.out.println ("Deseja fazer um pedido ?");
			System.out.println("1) Sim");
			System.out.println("2) Não");
			opcao = sc.nextInt();
			
			if(opcao == 1) {
				
				String principal = "";
				
				String secundaria = "";
				
				String bebida = "";
				
				String brinquedo = "";
				
				System.out.println("Qual refeição principal você deseja ? ");
				System.out.println("1) Hamburger");
				System.out.println("2) CheeseBurger");
				System.out.println("3) Frango");
				System.out.println("4) Nenhum");
				opcao = sc.nextInt();
				
				if(opcao == 1) {
					
					 principal = "Hamburger";
					
				}
				
				if(opcao == 2) {
					
					 principal = "CheeseBurger";
					
				}
				
				if(opcao == 3) {
					
					 principal = "Frango";
					
				}
				
				System.out.println("Qual refeição secundaria você deseja ? ");
				System.out.println("1) Batata frita");
				System.out.println("2) Nuggets");
				System.out.println("3) Nenhum");
				opcao = sc.nextInt();
				
				if(opcao == 1) {
					
					 secundaria = "Batata frita";
					
				}
				
				if(opcao == 2) {
					
					 secundaria = "Nuggets";
					
				}
				
				System.out.println("Qual bebida você deseja ? ");
				System.out.println("1) Coca cola");
				System.out.println("2) Guaraná");
				System.out.println("3) Suco");
				System.out.println("4) Nenhum");
				opcao = sc.nextInt();
				
				if(opcao == 1) {
					
					 bebida = "Coca cola";
					
				}
				
				if(opcao == 2) {
					
					 bebida = "Guaraná";
					
				}
				
				if(opcao == 3) {
					
					 bebida = "Suco";
					
				}
				
				
				System.out.println("Qual brinquedo você deseja ? ");
				System.out.println("1) Dinossauro");
				System.out.println("2) Dragao");
				System.out.println("3) Nenhum");
				opcao = sc.nextInt();
				
				
				if(opcao == 1) {
					
					 brinquedo = "Dinossauro";
					
				}
				
				if(opcao == 2) {
					
					 brinquedo = "Dragao";
					
				}
				
				
				Pedido pedido = new Pedido(principal, secundaria, bebida, brinquedo);
				
				System.out.println(pedido.toString());
			
				
			}else {
				
				System.out.println("Sem pedido!");
				
				saida = true;
			}
		}

	}

}
