package ecommerce.model;

public class Roupa extends Produto {
	private String tamanho;

	public Roupa(String nome, Integer qtd) {
		super(nome, qtd);
		this.nome = nome;
		this.qtd = qtd;
	}
	
	

	public String getTamanho() {
		return tamanho;
	}



	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	@Override
	public double gerarPreco() {
		// TODO Auto-generated method stub
		return super.gerarPreco();
	}

	@Override
	public double calcularSubtotal() {
		// TODO Auto-generated method stub
		return super.calcularSubtotal();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
