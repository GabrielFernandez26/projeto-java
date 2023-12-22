package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import ecommerce.repository.ICarrinhoRepository;

public class Carrinho implements ICarrinhoRepository{
	
	List<Produto> produtos = new ArrayList<>();
	
	@Override
	public void adicionarProduto(Produto produto, Integer qtd) {
		for (Produto p : produtos) {
			 if (p.equals(produto)) {
	                p.aumentarQtd(qtd);
	                return; 
	            }
        }

        Produto novoProduto = new Produto(produto.getNome(), produto.getQtd());
        novoProduto.setQtd(qtd);
        produtos.add(novoProduto);
	}

	@Override
	public void removerProduto(Produto produto, Integer qtd) {
		for (Produto p : produtos) {
            if (p.equals(produto)) {
                if (qtd >= p.getQtd()) {
                    produtos.remove(p);
                } else {
                    p.diminuirQtd(qtd);
                }
                return; 
            }
        }
	}

	@Override
	public Double calcularTotal() {
		double total = 0;

        for (Produto produto : produtos) {
            total += produto.calcularSubtotal();
        }

        return total;
	}
	
	
}
