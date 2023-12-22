package ecommerce;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                GF Sneakers                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Exibir Carrinho                      ");
			System.out.println("            2 - Adicionar no carrinho                ");
			System.out.println("            3 - Finalizar                            ");
			System.out.println("            4 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 5) {
				System.out.println("\nGF Sneakers");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Exibir Carrinho\n\n");

				break;
			case 2:
				System.out.println("Adicionar no carrinho\n\n");

				break;
			case 3:
				System.out.println("Finalizar\n\n");

				break;
			case 4:
				System.out.println("Sair\n\n");

				break;

			default:
				System.out.println("\nOpção Inválida!\n");

				break;
			}
		}
	}
}
