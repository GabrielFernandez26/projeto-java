package ecommerce.model;

import ecommerce.repository.ICarrinhoRepository;

public class Carrinho implements ICarrinhoRepository{
	

	public void adicionarProduto(Produto produto, Integer qtd) {
		
	}

	@Override
	public void removerProduto(Produto p, Integer qtd) {
		
	}

	@Override
	public void limparCarrinho() {
		
	}

	@Override
	public Double calcularTotal() {
	
		return null;
	}
	
	
}
