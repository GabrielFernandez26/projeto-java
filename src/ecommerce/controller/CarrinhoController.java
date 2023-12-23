package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Produto;
import ecommerce.model.Roupa;
import ecommerce.model.Tenis;
import ecommerce.repository.ICarrinhoRepository;

public class CarrinhoController implements ICarrinhoRepository{

	List<Produto> carrinho = new ArrayList<>();
	@Override
	public void adicionarProduto(Produto produto, Integer qtd) {
		for (Produto p : carrinho) {
			 if (p.equals(produto)) {
	                p.aumentarQtd(qtd);
	                return; 
	            }
        }

        Produto novoProduto;
        if (produto instanceof Tenis) {
            novoProduto = new Tenis(produto.getNome(), produto.getQtd());
        } else if (produto instanceof Roupa) {
            novoProduto = new Roupa(produto.getNome(), produto.getQtd());
        } else {
            return;
        }

        novoProduto.setQtd(qtd);
       carrinho.add(novoProduto);
	}

	@Override
	public void removerProduto(Produto produto, Integer qtd) {
		for (Produto p : carrinho) {
            if (p.equals(produto)) {
                if (qtd >= p.getQtd()) {
                    carrinho.remove(p);
                } else {
                    p.diminuirQtd(qtd);
                }
                return; 
            }
        }
	}

	@Override
	public Double calcularTotal(List<Produto> produtos) {
		double total = 0;
        for (Produto p : produtos) {
            total += p.calcularSubtotal();
        }

        return total;
	}
}
