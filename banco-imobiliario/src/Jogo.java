import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
	
	Scanner input = new Scanner(System.in);		
	Random random = new Random();



	public List<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	private int quantJogadores;
	
	public Jogo() {
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public void configurarJogo() {
		configTabuleiro();
		configePosicionarPropriedades();
		configJogadores();
		posicionaJogadores();
	}
	
	private void configTabuleiro() {
		//cria o objeto tabuleiro
		this.tabuleiro  = new Tabuleiro();
	
		for (int i = 0; i < 6; i++) {
			Espaco e = new Espaco();
			tabuleiro.adicionarEspaco(e);
		}
	}
	
	private void configJogadores() {
		// Pedir a quantidade de jogadores
		System.out.println("Digite a quantidade de Jogadores que vão participar da partida:");
		quantJogadores = input.nextInt();
		
		// Para cada jogador, perguntar seu nome
		for(int i = 0; i<quantJogadores; i++) {
			System.out.println("Digite seu nome:");
			String nome = input.next();
			Double saldo = 200.00;
			this.criarJogador(nome, saldo);
		}
	}
	
	private void configePosicionarPropriedades() {
		//cria as propriedades
		Propriedade tirol = new Propriedade(50, 15, 30);
		Propriedade quintas = new Propriedade(70, 10, 40);
		Propriedade capim_macio = new Propriedade(40, 20, 35);
		Propriedade parque_dos_coqueiros = new Propriedade(45, 25, 25);
		
		
		
		//coloca as propriedades nos espacos
		tabuleiro.espacos.get(3).setProriedade(tirol);
		tabuleiro.espacos.get(1).setProriedade(parque_dos_coqueiros);
		tabuleiro.espacos.get(4).setProriedade(quintas);
		tabuleiro.espacos.get(2).setProriedade(capim_macio);

	}
	
	private void posicionaJogadores() {
		
		for(int i=0 ; i<quantJogadores; i++) {
			tabuleiro.espacos.get(0).associarjogador(this.jogadores.get(i));
			this.jogadores.get(i).setEspaco (tabuleiro.espacos.get(0));
		}

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
		
	public void realizarPartida() {
		int sequencia = 0;
		// o jogo começa agora
		while (true) {
			
			if(quantJogadores > 1) {
				
				Jogador jogadorDaVez = this.jogadores.get(sequencia);
				int dado = 0;
				// Sortear um numero
				dado = 1 + random.nextInt(6);
				
				System.out.println("A vez e de: " + jogadorDaVez.getNome());
				System.out.println("Seu numero foi " + dado);
				
				//calcula a nova posicao do jogador
				Espaco espaco = tabuleiro.moverJogador(jogadorDaVez, dado);
				
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
					Jogador donoTalvez = this.donoDe( propriedadeTalvez );
	
					
					// ---------------------FUNÇÃO COMPRAR PROPRIEDADE--------------------------
					//verifica se não tem dono
					if(donoTalvez == null) {
						
						//INDICA QUE QUER COMPRAR
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
							//MOSTRA O VALOR DA PROPRIEDADE
							System.out.println("O valor da propriedade é: " + propriedadeTalvez.getValor());
							
							//função de comprar propriedade
							this.comprarPropriedade(propriedadeTalvez, jogadorDaVez);
							System.out.println("---------------------------------------------\n");

						}
					}
					
					
					if(donoTalvez != null ) {
						// ---------------------FUNÇÃO CONSTRUIR CASA--------------------------
						if(donoTalvez.equals(jogadorDaVez)) {
							construirCasa(jogadorDaVez);
						}
						else {
							// ---------------------FUNÇÃO PAGAR ALUGUEL--------------------------
							pagarAluguel(jogadorDaVez, propriedadeTalvez, donoTalvez);
						}
					}
				}
			}
			else {
				System.out.println("O jogador vencedor é :"+ this.buscaJogador());
				System.out.println("-----------FIM DE JOGO-------------");
				break;
			}
			
			sequencia = (sequencia + 1) % quantJogadores;
		}
	}
	
	public void pagarAluguel(Jogador jogadorDaVez, Propriedade propriedadeTalvez, Jogador donoTalvez) {
		//MOSTRA O VALOR DO ALUGUEL 
		System.out.println("Essa propriedade não é sua, pague o alugue! \n");
		System.out.println("O valor do aluguel é: " + propriedadeTalvez.getValorAluguel());
		
		//INFORMA QUE O JOGADOR NÃO TEM DINHEIRO PARA PAGAR E REMOVE O JOGADOR
		if(jogadorDaVez.getSaldo()<propriedadeTalvez.getValorAluguel()) {
			System.out.println("O jogador não tem dinheiro para pagar o aluguel \n");
			quantJogadores = this.removerJogador(jogadorDaVez, quantJogadores);
		}
		
		//DESCONTA O VALOR DO JOGADOR DA VEZ E ACRESCENTA AO DONO DA PROPRIEDADE
		else {
			jogadorDaVez.setSaldo(jogadorDaVez.getSaldo()- propriedadeTalvez.getValorAluguel());
			donoTalvez.setSaldo(donoTalvez.getSaldo()+propriedadeTalvez.getValorAluguel());
			System.out.println("Jogador Pagou o Aluguel! \n");
			System.out.println("---------------------------------------------\n");

		}
	}
	
	public void construirCasa(Jogador jogadorDaVez) {
		System.out.println("Você caiu em um propriedade que já é sua, deseja construir uma casa? \n");
		System.out.println("Digite [1] se sim \nDigite [2] se não \n");
		int entradaSN = input.nextInt();
		
		if(entradaSN == 1 ) {
			
			System.out.println("-----FUNÇÃO CONSTRUIR CASA-----\n");
			System.out.println("O valor para construir a casa é: "+ jogadorDaVez.getEspaco().getProriedade().getValorConstrucaoCasa());
			
			if(jogadorDaVez.getSaldo() >= jogadorDaVez.getEspaco().getProriedade().getValorConstrucaoCasa()) {
				jogadorDaVez.setSaldo(jogadorDaVez.getSaldo()-jogadorDaVez.getEspaco().getProriedade().getValorConstrucaoCasa());
				jogadorDaVez.getEspaco().getProriedade().setQuantidadeCasas(jogadorDaVez.getEspaco().getProriedade().getQuantidadeCasas() + 1);
				jogadorDaVez.getEspaco().getProriedade().setValorAluguel(jogadorDaVez.getEspaco().getProriedade().getValorAluguel() + 5);
				System.out.println("Casa construida com sucesso \n");
				System.out.println("Seu novo saldo é: "+ jogadorDaVez.getSaldo());
				System.out.println("---------------------------------------------\n");
			}
			//FLUXO EXCEPCIONAL
			else {
				System.out.println("Você não possui dinheiro para construir \n");
			}
		}
		else {
			System.out.println("Não construiu\n");
			System.out.println("---------------------------------------------\n");
		}
	}
}



