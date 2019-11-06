
public class Propriedade {
	private double valor = 50.00;
	private double valorAluguel = 15.00;
	private int quantidadeCasas = 0;
	private double valorConstrucaoCasa = 30.00;
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = getValorAluguel()*(0.25*quantidadeCasas);
	}
	public double getValorConstrucaoCasa() {
		return valorConstrucaoCasa;
	}
	public void setValorConstrucaoCasa(double valorConstrucaoCasa) {
		this.valorConstrucaoCasa = valorConstrucaoCasa;
	}
	public int getQuantidadeCasas() {
		return quantidadeCasas;
	}
	public void setQuantidadeCasas(int quantidadeCasas) {
		this.quantidadeCasas = quantidadeCasas;
	}
}
