import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private double saldo;
	private List<Propriedade> propriedades;
	private Espaco espaco;
	
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

	public Espaco getEspaco() {
		return this.espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
		/*
		this.posicao = posicao + this.posicao;
		if(this.posicao> 6) {
			this.posicao = this.posicao-6;
		}
		*/
	}
}
