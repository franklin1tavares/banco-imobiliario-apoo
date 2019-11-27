
public class Propriedade {
	private double valor;
	private double valorAluguel;
	private int quantidadeCasas;
	private double valorConstrucaoCasa;
	
	
	public Propriedade(double valor, double valorAluguel, double valorConstrucaoCasa ){
		this.valor = valor;
		this.valorAluguel = valorAluguel ;
		this.quantidadeCasas = 0;
		this.valorConstrucaoCasa = valorConstrucaoCasa ;
	}
	
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
