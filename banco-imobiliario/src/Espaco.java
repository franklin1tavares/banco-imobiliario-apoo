import java.util.ArrayList;
import java.util.List;

public class Espaco {
	private Propriedade proriedade;
	private List<Jogador> jogadores;
	
	public Espaco(){
		jogadores = new ArrayList<Jogador>();
	}

	public Propriedade getProriedade() {
		return proriedade;
	}

	public void setProriedade(Propriedade proriedade) {
		this.proriedade = proriedade;
	}
	
	//coloca o jogador no arrayList de jogadores no espaço
	public void associarjogador(Jogador jogador) {
		jogadores.add(jogador);
	}
	public void retirarJogador(Jogador jogador) {
		jogadores.remove(jogador);
	}
}
