import java.util.ArrayList;
import java.util.List;

public class Jogo {
	public List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	
	public Jogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public int removerJogador(Jogador jogadorFalido, int quantJogadores) {
		for(Jogador jogador : jogadores) {
			if(jogadorFalido.equals(jogador)) {
				System.out.println("O jogador "+ jogadorFalido.getNome() + " foi eliminado do jogo!");
				jogadores.remove(jogador);
				quantJogadores--;
				return quantJogadores;
			}
			
		}
		return 0;
	}
	
	public String buscaJogador() {
		
		for(Jogador jogador : jogadores) {
			if(jogador.getNome() != null) {
				return jogador.getNome();
			}
		}
		return null;
	}
	
	public void criarJogador(String nome, Double saldo) {
		// Criar um objeto jogador com aquele nome
		Jogador jogador = new Jogador(nome, saldo); 
		
		// Adiciona na lista de jogadores
		jogadores.add(jogador);
		
	}
	
	public void comprarPropriedade(Propriedade propriedade, Jogador jogador) {
		// verifica se tem valor
		
		if(	jogador.getSaldo() >= propriedade.getValor()) {
			//PAGA AO BANCO
			double saldo = jogador.getSaldo() - propriedade.getValor();
			jogador.setSaldo(saldo);
			jogador.adicionarPropriedade(propriedade);
			//CONFIRMAÇÃO
			System.out.println("Propriedade adquirida! \n");
		}

		else {
			System.out.println("Não comprou a propriedade porque você ta sem dinheiro!");
		}

	}

	
	public Jogador donoDe(Propriedade propriedade)
	{
		for(Jogador jogador : jogadores) {
			if(jogador.getPropriedades().contains(propriedade))
			{
				return jogador;
			}
		}
		return null;
	}
}


