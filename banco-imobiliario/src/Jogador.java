import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private double saldo;
	private List<Propriedade> propriedades;
	
	public Jogador ( String nome, double saldo )
	{
		this.nome = nome;
		this.saldo = saldo;
		this.propriedades = new ArrayList<Propriedade>();
	}
	
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
	
	public void adicionarPropriedade (Propriedade p)
	{
		this.propriedades.add(p);
	}
}
