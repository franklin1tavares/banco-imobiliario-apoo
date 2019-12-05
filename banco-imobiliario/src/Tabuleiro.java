import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	public List<Espaco> espacos;

	public Tabuleiro(){
		this.espacos = new ArrayList<Espaco>();
	}

	
	public void adicionarEspaco(Espaco espaco) {
		this.espacos.add(espaco);
	}
	
	public Espaco moverJogador(Jogador jogador, int dado) {
		int posicaoAtual = espacos.indexOf(jogador.getEspaco());
		
		int posicao = (posicaoAtual + dado) % 6;

		Espaco espaco = espacos.get(posicao);
		Espaco espacoAnterior = espacos.get(posicaoAtual);
		

		espacoAnterior.retirarJogador(jogador);
	
		espaco.associarjogador(jogador);
		jogador.setEspaco(espaco);
		
		
		System.out.println("Sua nova posicao é: " + posicao);
		return espaco;
		
	}
	
	
}
