import java.util.List;

public class Jogo {
	public List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	
	public Jogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
	public void criarJogador(String nome, Double saldo, int posicao) {
		// Criar um objeto jogador com aquele nome
		Jogador jogador = new Jogador(nome, saldo, posicao); 
		// Adiciona na lista de jogadores
		this.jogadores.add(jogador);
		
	}
}


