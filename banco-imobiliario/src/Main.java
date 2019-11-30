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
		System.out.println("Digite a quantidade de Jogadores que vão participar da partida:");
		int quantJogadores = input.nextInt();
		
		// Para cada jogador, perguntar seu nome
		for(int i = 0; i<quantJogadores; i++) {
			System.out.println("Digite seu nome:");
			String nome = input.next();
			Double saldo = 100.00;
			jogo.criarJogador(nome, saldo);
		}
		//cria as propriedades
		Propriedade tirol = new Propriedade(50, 15, 30);
		Propriedade quintas = new Propriedade(70, 10, 40);
		Propriedade capim_macio = new Propriedade(40, 20, 35);
		Propriedade parque_dos_coqueiros = new Propriedade(45, 25, 25);
		//coloca as propriedades nos espacos
		t.espacos.get(3).setProriedade(tirol);
		t.espacos.get(1).setProriedade(parque_dos_coqueiros);
		t.espacos.get(4).setProriedade(quintas);
		t.espacos.get(2).setProriedade(capim_macio);
		//coloca os jogadores na posição inicial
		for(int i=0 ; i<quantJogadores; i++) {
			t.espacos.get(0).associarjogador(jogo.jogadores.get(i));
			jogo.jogadores.get(i).setEspaco (t.espacos.get(0));
		}
		
		
		
		
		
		int sequencia = 0;
		// o jogo começa agora
		while (true) {
			
			if(quantJogadores > 1) {
				
				Jogador jogadorDaVez = jogo.jogadores.get(sequencia);
				int dado = 0;
				// Sortear um numero
				while(dado == 0) {
					dado =  random.nextInt(7);
				}
				System.out.println("A vez e de: " + jogadorDaVez.getNome());
				System.out.println("Seu numero foi " + dado);
				
				//calcula a nova posicao do jogador
				Espaco espaco = t.moverJogador(jogadorDaVez, dado);
				
				// CONFERI SE A PARADA É LIVRE
				if (jogadorDaVez.getEspaco().getProriedade() == null) {
					System.out.println("Parada Livre!\n");
					System.out.println("---------------------------------------------\n");
				}
				
				//pego a propriedade onde o jogador caiu
				Propriedade propriedadeTalvez = jogadorDaVez.getEspaco().getProriedade();
				
				//Se a propriedade do espaço não for null
				if ( propriedadeTalvez != null) {
					
					//BUSCA O DONO DA PROPRIEDADE NA LISTA DE PROPRIEDADES DE CADA JOGADOR
					Jogador donoTalvez = jogo.donoDe( propriedadeTalvez );
	
					
					// ---------------------FUNÇÃO COMPRAR PROPRIEDADE--------------------------
					//verifica se não tem dono
					if(donoTalvez == null) {
						System.out.println("A propriedade nao tem dono! \n Deseja compra-la? \n Digite: \n [1] Sim \n [2] Não");
						int entrada;
						entrada = input.nextInt();
						
						//se ele nao quiser comprar
						if(entrada == 2) {
							System.out.println("Nao comprou \n");
							System.out.println("---------------------------------------------\n");
						}
						//se ele ,quiser comprar
						else {
							Propriedade propriedade = jogadorDaVez.getEspaco().getProriedade();
							System.out.println(propriedade.getValor());
							//função de comprar propriedade
							jogo.comprarPropriedade(propriedade, jogadorDaVez);
							System.out.println("---------------------------------------------\n");

						}
					}
					
					
					// ---------------------FUNÇÃO CONSTRUIR CASA--------------------------
					if(donoTalvez != null ) {
						
						if(donoTalvez.equals(jogadorDaVez)) {
							System.out.println("Você caiu em um propriedade que já é sua, deseja construir uma casa? \n");
							System.out.println("Digite [1] se sim \nDigite [2] se não \n");
							int entradaSN = input.nextInt();
							
							if(entradaSN == 1 ) {
								System.out.println("-----Construir casa-----");
								if(jogadorDaVez.getSaldo() >= jogadorDaVez.getEspaco().getProriedade().getValorConstrucaoCasa()) {
									jogadorDaVez.setSaldo(jogadorDaVez.getSaldo()-jogadorDaVez.getEspaco().getProriedade().getValorConstrucaoCasa());
									jogadorDaVez.getEspaco().getProriedade().setQuantidadeCasas(jogadorDaVez.getEspaco().getProriedade().getQuantidadeCasas() + 1);
									jogadorDaVez.getEspaco().getProriedade().setValorAluguel(jogadorDaVez.getEspaco().getProriedade().getValorAluguel() + 5);
								}
							}
							else {
								System.out.println("Não construiu\n");
								System.out.println("---------------------------------------------\n");
							}
						}
						else {
							// ---------------------FUNÇÃO PAGAR ALUGUEL--------------------------
							//MOSTRA O VALOR DO ALUGUEL E INFORMA QUE O JOGADOR NÃO TEM DINHEIRO PARA PAGAR E REMOVE O JOGADOR
							System.out.println("O valor do aluguel é:" + propriedadeTalvez.getValorAluguel());
							if(jogadorDaVez.getSaldo()<propriedadeTalvez.getValorAluguel()) {
								System.out.println("O jogador não tem dinheiro para pagar o aluguel \n");
								
								quantJogadores = jogo.removerJogador(jogadorDaVez, quantJogadores);
					
								
							}
							//DESCONTA O VALOR DO JOGADOR DA VEZ E ACRESCENTA AO DONO DA PROPRIEDADE
							else {
								jogadorDaVez.setSaldo(jogadorDaVez.getSaldo()- propriedadeTalvez.getValorAluguel());
								donoTalvez.setSaldo(donoTalvez.getSaldo()+propriedadeTalvez.getValorAluguel());
								System.out.println("Jogador Pagou o Aluguel! \n");
								System.out.println("---------------------------------------------\n");

							}
						}
					}
				}
			}
			else {
				System.out.println("O jogador vencedor é :"+ jogo.buscaJogador());
				System.out.println("-----------FIM DE JOGO-------------");
				break;
			}
			
			sequencia = (sequencia + 1) % quantJogadores;
		}
	}

	
}
