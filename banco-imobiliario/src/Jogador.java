import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private double saldo;
	private List<Propriedade> propriedades;
	private int posicao;
	
	public Jogador ( String nome, double saldo, int posicao )
	{
		this.nome = nome;
		this.saldo = saldo;
		this.propriedades = new ArrayList<Propriedade>();
		this.posicao = posicao;

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

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao + this.posicao;
		if(this.posicao> 6) {
			this.posicao = this.posicao-6;
		}
	}
}
