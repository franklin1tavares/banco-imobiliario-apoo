import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();

		//cria o objeto tabuleiro
		Tabuleiro t = new Tabuleiro();
		for (int i = 0; i < 6; i++) {
			Espaco e = new Espaco();
			t.adicionarEspaco(e);
		} 
		
		Jogo jogo = new Jogo(t);
		// Pedir a quantidade de jogadores
		System.out.println("Digite a quantidade de Jogadores que irão oparticipar da partida:");
		int quantJogadores = input.nextInt();
		// Para cada jogador, perguntar seu nome
		for(int i = 0; i<quantJogadores; i++) {
			String nome = input.nextLine();
			Double saldo = 100.00;
			int posicao = 0;
			jogo.criarJogador(nome, saldo, posicao);
		}
		

		//cria as propriedades
		Propriedade tirol = new Propriedade(50, 15, 30);
		Propriedade quintas = new Propriedade(70, 10, 40);
		Propriedade capim_macio = new Propriedade(40, 20, 35);
		Propriedade parque_dos_coqueiros = new Propriedade(45, 25, 25);
		
		//coloca as propriedades nos espaços
		t.espacos.get(3).setProriedade(tirol);
		t.espacos.get(1).setProriedade(parque_dos_coqueiros);
		t.espacos.get(4).setProriedade(quintas);
		t.espacos.get(2).setProriedade(capim_macio);
	
		//coloca os jogadores na posição inicial
		for(int i=0 ; i<quantJogadores; i++) {
			t.espacos.get(0).associarjogador(jogo.jogadores.get(i));
		}
		

		while (true) {
			int sequencia = 0;
			if(quantJogadores > 1) {
				// Sortear um numero
				int dado =  random.nextInt(7);
				System.out.println("Seu numero foi " + dado);
				//calcula a nova posicao do jogador
				int novaPosicao = jogo.jogadores.get(sequencia).getPosicao() + dado;
				
				
//				jogadore t.espacos.get(jogo.jogadores.get(sequencia).getPosicao();

				
			}
			else {
				break;
			}
			
		}
		
		
		// Para cada jogador
			// Andar o jogador
			// Realizar ação de acordo de onde caiu
	}
}
