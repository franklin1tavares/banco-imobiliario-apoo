
public class Jogador {
	private String nome;
	private double saldo = 100.00;
	private Propriedade[] propriedades;
	
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPropriedade(Propriedade propriedade) {
		for(int i = 0 ; i<propriedades.length; i++ ) {
			if(propriedades[i] == null) {
				propriedades[i] = propriedade;
			}
		}
	}
}
