package ecommerce.model;

public class Tenis extends Produto{
 private Integer calcado;
	public Tenis(String nome, Integer qtd) {
		super(nome, qtd);
		this.nome = nome;
		this.qtd = qtd;
	}
	
	
	public Integer getCalcado() {
		return calcado;
	}


	public void setCalcado(Integer calcado) {
		this.calcado = calcado;
	}


	@Override
	public void aumentarQtd(int qtd) {
		// TODO Auto-generated method stub
		super.aumentarQtd(qtd);
	}
	@Override
	public void diminuirQtd(int qtd) {
		// TODO Auto-generated method stub
		super.diminuirQtd(qtd);
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
