package ecommerce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import ecommerce.model.Carrinho;
import ecommerce.model.Produto;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		int opcao;
		Carrinho c = new Carrinho();
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

			switch (opcao) {
			case 1:
				System.out.println("Adicionar produto ao carrinho");
                System.out.println("Digite o nome do produto: ");
                String nomeProduto = leia.nextLine();
                leia.nextLine();
                System.out.print("Digite a quantidade do produto: ");
                int qtdProduto = leia.nextInt();

                Produto novoProduto = new Produto(nomeProduto, qtdProduto);
                listaProdutos.add(novoProduto);
                System.out.println("Produto adicionado com sucesso!");
                break;
			case 2:
				System.out.println("Remover produto do carrinho");
			    System.out.print("Digite o ID do produto a ser removido: ");
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
			        double totalCompra = c.calcularTotal();
			        System.out.println("Total da compra: R$" + totalCompra);
			        System.out.println("Compra finalizada. Carrinho resetado.");
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
}
