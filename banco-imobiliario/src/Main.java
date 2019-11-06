
public class Main {
	
	public static void main(String args[]) {
	// Criar os jogadores
		// Pedir a quantidade de jogadores
		// Para cada jogador, perguntar seu nome
		// Criar um objeto jogador com aquele nome
		// Adiciona na lista de jogadores
	
	
	Tabuleiro t = new Tabuleiro();
	
	for (int i = 0; i < 6; i++) {
		Espaco e = new Espaco();
		t.adicionarEspaco(e);
	}
	
	Propriedade tirol = new Propriedade(50, 15, 30);
	Propriedade quintas = new Propriedade(70, 10, 40);
	Propriedade capim_macio = new Propriedade(40, 20, 35);
	Propriedade parque_dos_coqueiros = new Propriedade(45, 25, 25);
	
	t.espacos.get(3).setProriedade(tirol);
	t.espacos.get(1).setProriedade(parque_dos_coqueiros);
	t.espacos.get(4).setProriedade(quintas);
	t.espacos.get(2).setProriedade(capim_macio);
	
	t.espacos.get(0).associarjogador(jogador1);
	t.espacos.get(0).associarjogador(jogador2);
	t.espacos.get(0).associarjogador(jogador3);
	t.espacos.get(0).associarjogador(jogador4);
	
	// Sortear a ordem dos jogadores
	
	// Para cada jogador
		// Sortear um numero
		// Andar o jogador
		// Realizar ação de acordo de onde caiu
	}
}
