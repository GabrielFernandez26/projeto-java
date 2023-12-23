package ecommerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import ecommerce.controller.CarrinhoController;
import ecommerce.model.Produto;
import ecommerce.model.Roupa;
import ecommerce.model.Tenis;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		int opcao;
		CarrinhoController c = new CarrinhoController();
		List<Produto> listaProdutos = new ArrayList<>();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                GF Sneakers                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar produto                    ");
			System.out.println("            2 - Remover produto                      ");
			System.out.println("            3 - Finalizar                            ");
			System.out.println("            4 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			leia.skip("\\r");

			switch (opcao) {

			case 1:
				System.out.println("Adicionar produto ao carrinho");
				int tipo;
				do {
					System.out.println("Escolha entre roupa (1) ou tênis (2): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				leia.nextLine();

				switch (tipo) {

				case 1:
					System.out.println("Digite o nome da roupa: ");
					String nome = leia.nextLine();
					System.out.println("Digite a quantidade de roupa: ");
					int qtd = leia.nextInt();
					leia.nextLine();
					System.out.println("Tamanho da roupa");
					String tamanho = leia.nextLine();
					Roupa novaRoupa = new Roupa(nome, qtd);
					novaRoupa.setTamanho(tamanho);
					listaProdutos.add(novaRoupa);
					System.out.println("Produto adicionado com sucesso!");
					break;
				case 2:
					System.out.println("Digite o nome do tênis: ");
					nome = leia.nextLine();
					System.out.print("\nDigite a quantidade de tênis: ");
					qtd = leia.nextInt();
					System.out.println("Tamanho do tÊnis");
					int calcado = leia.nextInt();
					Tenis novoTenis = new Tenis(nome, qtd);
					novoTenis.setCalcado(calcado);
					listaProdutos.add(novoTenis);
					System.out.println("Produto adicionado com sucesso!");
					break;
				default:
					break;
				}
				break;
			case 2:
				System.out.println("Remover produto do carrinho");
				System.out.println("Digite o ID do produto a ser removido: ");
				int idProdutoRemover = leia.nextInt();

				Produto produtoRemover = null;
				for (Produto produto : listaProdutos) {
					if (produto.getId() == idProdutoRemover) {
						produtoRemover = produto;
						break;
					}
				}

				if (produtoRemover != null) {
					listaProdutos.remove(produtoRemover);
					System.out.println("Produto removido com sucesso!");
				} else {
					System.out.println("Produto não encontrado. Nada foi removido.");
				}
				
				break;
			case 3:
				System.out.println("Finalizar compra");
				if (c != null) {
					double totalCompra = c.calcularTotal(listaProdutos);
					for (Produto produto : listaProdutos) {
						System.out.println(produto.toString());
					}
					System.out.printf("Total da compra: R$ %.2f", totalCompra);
					System.out.println();

				} else {
					System.out.println("Carrinho de compras não inicializado. Nada a finalizar.");
				}
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

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
