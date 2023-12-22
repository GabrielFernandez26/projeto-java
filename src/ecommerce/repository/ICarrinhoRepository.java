package ecommerce.repository;

import java.util.List;

import ecommerce.model.Produto;

public interface ICarrinhoRepository {
	public void adicionarProduto(Produto p, Integer qtd);
	public void removerProduto(Produto p, Integer qtd);
	Double calcularTotal(List<Produto> produtos);
}
