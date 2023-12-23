package ecommerce.model;

public abstract class Produto {
	private static int proxId = 1;
	Integer id;
	String nome;
	Double preco;
	Integer qtd;

	public Produto(String nome, Integer qtd) {
		super();
		this.id = proxId++;
		this.nome = nome;
		this.preco = gerarPreco();
		this.qtd = qtd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		if (qtd >= 0) {
			this.qtd = qtd;
		} else {
			System.out.println("Quantidade não pode ser negativa. Configurando para 0.");
			this.qtd = 0;
		}
	}

	public void aumentarQtd(int qtd) {
		if (qtd >= 0) {
			this.qtd += qtd;
		} else {
			System.out.println("A quantidade a ser adicionada não pode ser negativa.");
		}
	}

	public void diminuirQtd(int qtd) {
		if (qtd >= 0) {
			this.qtd -= qtd;
			if (this.qtd < 0) {
				this.qtd = 0;
			}
		} else {
			System.out.println("A quantidade a ser removida não pode ser negativa.");
		}
	}

	public double gerarPreco() {
		return 50.0 + Math.random() * (3000.0 - 50.0);
    }

	public double calcularSubtotal() {
		return getPreco() * qtd;
	}

	@Override
	public String toString() {
		return "Produto: " + getNome() + " | Quantidade: " + getQtd() + " | Preco: $" + String.format("%.2f", getPreco());
	}

}
