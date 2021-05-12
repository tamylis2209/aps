package Pck_2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//import Pck_1.Principal.Panel;

//USANDO HERENÇA DA JPANEL E IMPLEMENTANDO A INTERFACE ACTIONLISTENER
public class Fase extends JPanel implements ActionListener {
	private boolean level2 = false;
	// CRIANDO UMA VARIAVEL DO TIPO IMAGEM QUE SERÁ O FUNDO DA INTERFACE
	private Image Mar;
	// CRIANDO A VARIAVEL SUBMARNO
	private Submarino sub;
	// VARIAVEL TIMER
	private Timer timer;
	// VARIAVEL PARA CONTROLAR AONDE AS IMAGENS IRÃO APARECER DAS DECORAÇÕES E DA
	// VIDA
	int valor;
	// VARIAVEL QUE DEFINE AS VIDAS DO JOGO
	private static int vidas = 3;
	// VARIAVEL PARA OS LIXOS COLETADOS
	private static int coleta;
	// LISTA ANIMAL
	private List<Animal> animal = new ArrayList<Animal>();
	// LISTA ANIMAL2
	private List<Animal> animal2 = new ArrayList<Animal>();
	// LISTA ANIMAL3
	private List<Animal> animal3 = new ArrayList<Animal>();
	// LISTA LIXO
	private List<Lixo> lixo = new ArrayList<Lixo>();
	// ISTA LIXO2
	private List<Lixo> lixo2 = new ArrayList<Lixo>();
	// LISTA VIDA
	private List<Vida> vida = new ArrayList<Vida>();
	// LISTA VIDA2
	private List<Vida> vida2 = new ArrayList<Vida>();
	// LISTA PARA DECORACAO
	private List<Decoracao> Dec = new ArrayList<Decoracao>();
	// LISTA PARA DECORACAO2
	private List<Decoracao> Dec2 = new ArrayList<Decoracao>();
	// LISTA PARA DECORACAO3
	private List<Decoracao> Dec3 = new ArrayList<Decoracao>();
	// LISTA PARA DECORACAO4
	private List<Decoracao> Dec4 = new ArrayList<Decoracao>();
	// VARIAVEL MAXIMA DO VALOR QUE IRÁ SUBTRAIR CONFORME A VELOCIDADE DO JOGO E
	// QUANDO ZERAR O JOGO IRÁ TERMINAR
	private int Fim = 10000;
	// VARIAVEL QUE DETERMINA O FIM DO JOGO
	boolean gameOver = false;
	// CIRANDO UM OBJETO DA CLASSE SOM
	Som s = new Som();	
	// METODO CONSTRUTOR
	public Fase() {
		// O OBJETO S ENTRARÁ EM UM LOOP
		s.som.loop();
		// OBTENDO O FOCO PARA O COMPONENTE
		setFocusable(true);
		// METODO PARA MELHORAR O DESEMPENHO
		setDoubleBuffered(true);
		// CRIANDO UM NOVO SUBMARINO
		sub = new Submarino();
		// CARREGANDO A IMAGEM DO SUBMARINO
		sub.load();
		// INSTANCIANDO O TECLADO NA FASE
		addKeyListener(new TecladoAdapter());
		// DEFININDO A VELOCIDADE DO JOGO A PARTIR DA CLASSE TIMER
		timer = new Timer(4, this);
		// INICIANDO O TIMER
		timer.start();
		// CHAMANDO O METODO PARA INICILIZAR OS OBJETOS
		inicializaObjetos();
	}

	// METODO PARA INICIZALIAR OS OBJETOS
	public void inicializaObjetos() {
		// VETOR PARA A QUANTIDADE DE LIXOS E ANIMAIS NO JOGO
		int coord[] = new int[15];
		// VETOR PARA A QUANTIDADE DE VIDAS QUE IRÁ APARECER E SE MOVIMENTAR
		int cord[] = new int[3];
		// VETOR PARA A QUANTIDADE MAXÍMA DE VIDAS QUE O USUÁRIO PODE TER
		int coordvid[] = new int[7];

		// FOR PARA GERAR ALEATÓRIAMENTE A POSIÇÃO DE X E Y QUE SERÁ ONDE A IMAGEM IRÁ
		// APARECER
		for (int i = 0; i < coord.length; i++) {
			/*
			 * USANDO A BIBLIOTECA MATH E O METODO RANDOM PARA NUMEROS ALEATÓRIOS FOI
			 * ESCOLHIDO ENTRE 8000 + 1024 PARA OS OBJETOS SURGIREM COM O VALOR DE X BEM
			 * MAIOR QUE A RESOLUÇÃO, PARA VIREM DIMINUINDO CONFORME A ATUALIZAÇÃO E
			 * CHEGANDO NA RESOLUÇÃO DE 1280X720 PARA DAR A IMPRESSÃO QUE O SUBMARINO QUE
			 * ESTÁ EM MOVIMENTO
			 */
			int x = (int) (Math.random() * 8000 + 1280);
			int y = (int) (Math.random() * 520 + 30);
			// ADICIONANDO OS VALORES DE X E Y NA LISTA ANIMAL
			animal.add(new Animal(x, y));
			Dec2.add(new Decoracao(x, y));
		}
		// ABAIXO É APENAS CÓPIA DA LOGICA ACIMA MUDA APENAS QUE OS VALORES GERADOS
		// ALEATÓRIAMENTE
		// SERÃO ARMAZENADOS EM OUTRAS LISTAS PARA AS IMAGENS DE OUTROS OBJETOS
		for (int a = 0; a < coord.length; a++) {
			int x = (int) (Math.random() * 8000 + 1280);
			int y = (int) (Math.random() * 520 + 30);
			animal2.add(new Animal(x, y));
			Dec3.add(new Decoracao(x, y));
		}
		for (int j = 0; j < coord.length; j++) {
			int x = (int) (Math.random() * 8000 + 1280);
			int y = (int) (Math.random() * 520 + 30);
			animal3.add(new Animal(x, y));
			Dec4.add(new Decoracao(x, y));
		}
		for (int l = 0; l < coord.length; l++) {
			int x = (int) (Math.random() * 8000 + 1280);
			int y = (int) (Math.random() * 520 + 30);
			lixo.add(new Lixo(x, y));
		}
		for (int m = 0; m < coord.length; m++) {
			int x = (int) (Math.random() * 8000 + 1280);
			int y = (int) (Math.random() * 520 + 30);
			lixo2.add(new Lixo(x, y));
		}

		for (int b = 0; b < coordvid.length; b++) {
			// X RECEBERÁ O VALOR DE 0, VALOR INICIAL DA VARIÁVEL
			int x = valor;
			// Y SERÁ SEMPRE 0
			int y = 0;
			// ADICIONANDO VALORES DE X E Y NA LISTA VIDA
			vida.add(new Vida(x, y));
			// CADA LAÇO DO FOR, X RECEBERÁ MAIS 30, PORTANTO IRÁ APARECER UM DO LADO DO
			// OUTRO E SEMPRE NA POSIÇÃO 0 DE Y
			valor += 30;
		}
		valor = 7000;
		for (int z = 0; z < cord.length; z++) {
			int x = valor;
			int y = (int) (Math.random() * 520 + 30);
			vida2.add(new Vida(x, y));
			valor += 5200;
		}
		valor = 100;
		for (int d = 0; d < cord.length; d++) {
			int x = valor;
			int y = 620;
			Dec.add(new Decoracao(x, y));
			valor += 500;
		}
	}

//USANDO A BIBLIOTECA GRAPHICS PARA A IMAGEM DE FUNDO
	public void paint(Graphics g) {
		// CHAMANDO O O SUPER DA CLASSE PAI
		super.paintComponent(g);
		// CRIANDO UM OBJETO DO TIPO IMAGEICON
		ImageIcon referencia = new ImageIcon("res//Mar.png");		
		// A VARIAVEL DO TIPO IMAGEM VAI RECEBER A IMAGEM DECLARADA ACIMA
		Mar = referencia.getImage();
		// AJUSTANDO A IMAGEM NA TELA
		g.drawImage(Mar, 0, 0, this);
		// PEGANDO OS VALORES DE X Y E DA IMAGEM
		g.drawImage(sub.getImagem(), sub.getX(), sub.getY(), this);
		// FOR PARA AS IMAGENS DAS VIDAS
		for (int z = 0; z < vidas; z++) {
			// A VARIAVEL VI DO TIPO VIDA, VAI RECEBER O ITEM DA LISTA VIDA NA POSIÇÃO Z DO
			// FOR
			Vida vi = vida.get(z);
			// ESSE ITEM DA LISTA SERÁ CARREGADO DE ACORDO COM O METODO FOR DA CLASSE VIDA
			vi.load();
			// AJUSTANDO A IMAGEM
			g.drawImage(vi.getImagem(), vi.getX(), vi.getY(), this);
		}
		// ABAIXO VAI SEGUIR A MESMA LOGICA PARA CARREGAR AS IMAGENS
		for (int ac = 0; ac < Dec4.size(); ac++) {
			Decoracao de4 = Dec4.get(ac);
			if (de4.isColidiu3() == true) {
				de4.load2();
				g.drawImage(de4.getImagem(), de4.getX(), de4.getY(), this);
			}
		}
		for (int ab = 0; ab < Dec3.size(); ab++) {
			Decoracao de3 = Dec3.get(ab);
			if (de3.isColidiu2() == true) {
				de3.load2();
				g.drawImage(de3.getImagem(), de3.getX(), de3.getY(), this);

			}
		}
		for (int a = 0; a < Dec2.size(); a++) {
			Decoracao de2 = Dec2.get(a);
			if (de2.isColidiu1() == true) {
				de2.load2();
				g.drawImage(de2.getImagem(), de2.getX(), de2.getY(), this);
			}
		}
		for (int b = 0; b < animal.size(); b++) {
			Animal tar = animal.get(b);
			tar.load();
			g.drawImage(tar.getImagem(), tar.getX(), tar.getY(), this);
		}
		for (int c = 0; c < animal2.size(); c++) {
			Animal tub = animal2.get(c);
			tub.load2();
			g.drawImage(tub.getImagem(), tub.getX(), tub.getY(), this);
		}
		for (int d = 0; d < animal3.size(); d++) {
			Animal pei = animal3.get(d);
			pei.load3();
			g.drawImage(pei.getImagem(), pei.getX(), pei.getY(), this);
		}
		for (int e = 0; e < lixo.size(); e++) {
			Lixo li = lixo.get(e);
			li.load();
			g.drawImage(li.getImagem(), li.getX(), li.getY(), this);

		}
		for (int f = 0; f < lixo2.size(); f++) {
			Lixo lix = lixo2.get(f);
			lix.load2();
			g.drawImage(lix.getImagem(), lix.getX(), lix.getY(), this);
		}
		for (int h = 0; h < vida2.size(); h++) {
			Vida vi2 = vida2.get(h);
			vi2.load();
			g.drawImage(vi2.getImagem(), vi2.getX(), vi2.getY(), this);
		}
		for (int i = 0; i < Dec.size(); i++) {
			Decoracao de = Dec.get(i);
			de.load();
			g.drawImage(de.getImagem(), de.getX(), de.getY(), this);
		}

		// CASO VIDAS FOR IGUAL A 0 SIGNIFICA QUE O JOGADOR PERDEU TODAS AS SUAS VIDAS
		// PORTANTO O JOGO SERÁ ZERADO E SERÁ CARREGADO A IMAGEM DE GAME OVER
		if (vidas == 0) {
			// LIMPANDO A LISTA ANIMAL
			animal.clear();
			// LIMPANDO A LISTA ANIMAL2
			animal2.clear();
			// LIMPANDO A LISTA ANIMAL3
			animal3.clear();
			// LIMPANDO A LISTA LIXO
			lixo.clear();
			// LIMPANDO A LISTA LIXO2
			lixo2.clear();
			// LIMPANDO A LISTA VIDA2
			vida2.clear();
			// LIMPANDO AS LISTAS DAS DECORACOES
			Dec2.clear();
			Dec3.clear();
			Dec4.clear();
			// CARREGANDO A IMAGEM DO FIM DE JOGO
			ImageIcon fim = new ImageIcon("res//Game.jpg");
			g.drawImage(fim.getImage(), 0, 0, null);
			gameOver = true;
		}

	}

	// METODO PARA ATUALIZAR AS IMAGENS E FAZER COM QUE ELAS SE MOVAM
	@Override
	public void actionPerformed(ActionEvent e) {
		// CASO NAO ESTEJA NO LEVEL 2
		if (level2 == false) {
			// VAI ATUALIZAR O SUBMARINO NORMALMENTE
			sub.update();
		} else {
			// CASO CONTRÁRIO IRÁ CHAMAR O METODO LEVEL 2 DA CLASSE SUBMARINO
			sub.level2();
			// E ASSIM IRÁ MODIFICAR A VELOCIDADE
			sub.update();
		}
		// SUBTRAINDO A VARIAVEL FIM PARA DETERMINAR QUANDO O JOGO IRÁ ACABAR
		if (level2 == false) {
			Fim -= 2;
		} else {
			Fim -= 4;
		}
		// FOR PARA MOVER AS IMAGENS
		for (int ac = 0; ac < Dec4.size(); ac++) {
			// AQUI IRÁ MOVER A IMAGEM DA CLASSE DECORACAO
			Decoracao de4 = Dec4.get(ac);
			// UM IF PARA VERIFICAR SE ESTÁ NO LEVEL2
			if (level2 == false) {
				// CASO NAO ESTEJA, SERÁ ATUALIZADO NORMALMENTE
				de4.update();
			} else {
				// CASO CONTRÁRIO, CHAMARÁ O METODO LEVEL2 FAZENDO COM QUE MODIFIQUE A
				// VELOCIDADE
				de4.level2();
				de4.update();
			}
		}
		// OS OUTROS LAÇOS DE REPETIÇÕES ABAIXO, SEGUE A MESMA LÓGICA PARA MOVIMENTAR O
		// RESTANTE DAS IMAGENS
		for (int ab = 0; ab < Dec3.size(); ab++) {
			Decoracao de3 = Dec3.get(ab);
			if (level2 == false) {
				de3.update();
			} else {
				de3.level2();
				de3.update();
			}
		}
		for (int a = 0; a < Dec2.size(); a++) {
			Decoracao de2 = Dec2.get(a);
			if (level2 == false) {
				de2.update();
			} else {
				de2.level2();
				de2.update();
			}
		}
		for (int b = 0; b < animal.size(); b++) {
			Animal tar = animal.get(b);
			if (level2 == false) {
				tar.update();
			} else {
				tar.level2();
				tar.update();
			}
			if(tar.getX()<-5) {
				animal.remove(b);
			}
	
		}
		for (int c = 0; c < animal2.size(); c++) {
			Animal tub = animal2.get(c);
			if (level2 == false) {
				tub.update();
			} else {
				tub.level2();
				tub.update();
			}
			if(tub.getX()<-5) {
				animal2.remove(c);
			}
		}
		for (int j = 0; j < animal3.size(); j++) {
			Animal pei = animal3.get(j);
			if (level2 == false) {
				pei.update();
			} else {
				pei.level2();
				pei.update();
			}
			if(pei.getX()<-5) {
				animal3.remove(j);
			}
		}
		for (int l = 0; l < lixo.size(); l++) {
			Lixo li = lixo.get(l);
			if (level2 == false) {
				li.update();
			} else {
				li.level2();
				li.update();
			}
			if(li.getX()<-5) {
				lixo.remove(l);
			}
		}
		for (int m = 0; m < lixo2.size(); m++) {
			Lixo li2 = lixo2.get(m);
			if (level2 == false) {
				li2.update();
			} else {
				li2.level2();
				li2.update();
			}
			if(li2.getX()<-5) {
				lixo2.remove(m);
			}
		}
		for (int z = 0; z < vida2.size(); z++) {
			Vida vi2 = vida2.get(z);
			if (level2 == false) {
				vi2.update();
			} else {
				vi2.level2();
				vi2.update();
			}
			if(vi2.getX()<-5) {
				vida2.remove(z);
			}
		}
		// QUANDO FIM CHEGAR A 0, SIGNIFICA QUE TODOS OS OBJETOS JÁ PASSARAM PELA
		// INTERFACE, PORTANTO O JOGO PODERÁ SER INTERROMPIDO
		if (Fim < 0) {
			// O SOM IRÁ PARAR
			s.som.stop();
			// CASO A QUANTIDADE DE LIXOS COLETADOS FOR MENOR DO QUE 15
			if (coleta < 15) {
				// VAI CHAMAR O SOM DE GAME OVER
				s.sons("GameOver");
				/*
				 * A VARIAVEL RES VAI RECEBER A RESPOSTA QUE O USUÁRIO ESCOLHER A PARTIR DE UMA
				 * CAIXA DE CONFIRMAÇÃO
				 */
				int res = JOptionPane.showConfirmDialog(null,
						"Voce não atingiu a meta de lixos coletados! Deseja jogar novamente?");
				// CASO A RESPOSTA SEJA A PRIMEIRA OPÇÃO
				if (res == 0) {
					// SERÁ CHAMADO O METODO PERDEU PARA MODIFICAR A VELOCIDADE DO SUBMARINO PARA O
					// LEVEL 1
					sub.level1();
					level2 = false;
					// CHAMARÁ O METODO PARA INICIAR O JOGO NOVAMENTE
					jogarNovamente();
					// O SOM DO JOGO VOLTARÁ AO LOOP
					s.som.loop();
				}
				// CASO SEJA DIFERENTE DA PRIMEIRA OPÇÃO
				if (res != 0) {
					// O JOGO SERÁ FECHADO
					System.exit(res);
				}
				// ELSE, CASO OS LIXOS COLETADOS SEREM MAIORES DO QUE 15
			} else {
				// CHAMARÁ O SOM DA VITÓRIA
				s.sons("Vitoria");
				if (level2 == true) {
					JOptionPane.showMessageDialog(null,
							"PARABENS, VOCE PASSOU AS DUAS FASES! VOCE AJUDOU O NOSSO OCEANO!");
					System.exit(0);
				}
				// A VARIAVEL RES VAI RECEBER A RESPOSTA DO USUÁRIO A PARTIR DE UMA CAIXA DE
				// CONFIRMAÇÃO
				int res = JOptionPane.showConfirmDialog(null,
						"Parabéns, voce coletou " + coleta + " Lixos!, Deseja ir para a fase 2?");
				// CASO A RESPOSTA SEJA NA PRIMEIRA OPÇÃO
				if (res == 0) {
					level2 = true;
					// CHAMARÁ O METODO PARA INICIAR O JOGO NOVAMENTE
					jogarNovamente();
					// O SOM DO JOGO VOLTARÁ AO LOOP
					s.som.loop();
					// CASO SEJA DIFERENTE DA PRIMEIRA OPÇÃO
				}
				if (res != 0) {
					// O JOGO SERÁ FECHADO
					System.exit(res);
				}
			}
		}

		// CASO O GAME OVER SER VERDADEIRO
		if (gameOver == true) {
			// CHAMA O METODO LEVEL 1 NOVAMENTE
			sub.level1();
			// PASSA O LEVEL 2 PARA FALSO
			level2 = false;
			// O SOM SERÁ INTERROMPIDO
			s.som.stop();
			// IRÁ CHAMAR O SOM DE GAME OVER
			s.sons("GameOver");
			// IRÁ CHAMAR O METODO SLEEP DE 2 SEGUNDOS
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
			// APÓS O METODO SLEEP SERÁ QUESTIONADO SE O USUÁRIO QUER JOGAR NOVAMENTE
			int res = JOptionPane.showConfirmDialog(null, "Voce perdeu todas as vidas. Deseja jogar novamente?");
			// CASO A RESPOSTA SEJA NA PRIMEIRA OPÇÃO
			if (res == 0) {
				// O SOM VOLTARÁ A TOCAR
				s.som.loop();
				// CHAMARÁ O METODO PARA INICIAR O JOGO NOVAMENTE
				jogarNovamente();
				// CASO SEJA DIFERENTE DA PRIMEIRA OPÇÃO
			}
			if (res != 0) {
				// O JOGO SERÁ FECHADO
				System.exit(res);
			}
		}
		// CHAMANDO O METODO PARA CHECAR TODAS AS COLISOES
		checarColisao();
		// REPINTANDO AS IMAGENS NA TELA
		repaint();
	}

	// METODO PARA AS COLISÕES
	public void checarColisao() {
		// CRIANDO UM RETANGULO NO SUBMARINO
		Rectangle formaSub = sub.getBounds();
		// CRIANDO UM RETANGULO NA TARTARUGA
		Rectangle formaAnimal;
		// CRIANDO UM RETANGULO NO TUBARAO
		Rectangle formaAnimal2;
		// CRIANDO UM RETANGULO NO PEIXE
		Rectangle formaAnimal3;
		// CRIANDO UM RETANGULO NA GARRAFA
		Rectangle formaLixo;
		// CRIANDO UM RETANGULO NA SACOLA
		Rectangle formaLixo2;
		// CRIANDO UM RETANGULO NA VIDA
		Rectangle formaVida2;
		// FOR PARA TODOS OS ITENS DA LISTA ANIMAL
		for (int i = 0; i < animal.size(); i++) {
			Decoracao de2 = Dec2.get(i);
			// CRIANDO UMA VARIAVEL TEMPORÁRIA E ELA RECEBENDO O ANIMAL DA POSIÇÃO I DO FOR
			Animal tempAnimal = animal.get(i);
			// O RETANGULO RECEBE O VALOR DA VARIAVEL TEMPORÁRIA
			formaAnimal = tempAnimal.getBounds();
			// CASO O SUBMARINO TOCAR NO RETANGULO DA TARTARUGA
			if (formaSub.intersects(formaAnimal)) {
				de2.setColidiu(true);
				de2.setX(tempAnimal.getX());
				de2.setY(tempAnimal.getY());
				animal.remove(i);
				vidas -= 1;
				s.sons("Error");
			}
			repaint();
		}

		// ABAIXO APENAS CÓPIA DA LÓGICA ACIMA

		for (int a = 0; a < animal2.size(); a++) {
			Decoracao de3 = Dec3.get(a);
			Animal tempAnimal2 = animal2.get(a);
			formaAnimal2 = tempAnimal2.getBounds();
			if (formaSub.intersects(formaAnimal2)) {
				de3.setColidiu2(true);
				de3.setX(tempAnimal2.getX());
				de3.setY(tempAnimal2.getY());
				animal2.remove(a);
				vidas -= 1;
				s.sons("Error");
			}
		}
		for (int j = 0; j < animal3.size(); j++) {
			Decoracao de4 = Dec4.get(j);
			Animal tempAnimal3 = animal3.get(j);
			formaAnimal3 = tempAnimal3.getBounds();
			if (formaSub.intersects(formaAnimal3)) {
				de4.setColidiu3(true);
				de4.setX(tempAnimal3.getX());
				de4.setY(tempAnimal3.getY());
				animal3.remove(j);
				vidas -= 1;
				s.sons("Error");
			}
		}
		for (int m = 0; m < lixo.size(); m++) {
			Lixo tempLixo = lixo.get(m);
			formaLixo = tempLixo.getBounds();
			if (formaSub.intersects(formaLixo)) {
				lixo.remove(m);
				coleta += 1;
			}
		}
		for (int l = 0; l < lixo2.size(); l++) {
			Lixo tempLixo2 = lixo2.get(l);
			formaLixo2 = tempLixo2.getBounds();
			if (formaSub.intersects(formaLixo2)) {
				lixo2.remove(l);
				coleta += 1;
			}
		}
		for (int z = 0; z < vida2.size(); z++) {
			Vida tempVida = vida2.get(z);
			formaVida2 = tempVida.getBounds();
			if (formaSub.intersects(formaVida2)) {
				vida2.remove(z);
				vidas += 1;
				s.sons("Bonus");
			}
		}
	}

//METODO PARA INICIAR O JOGO NOVAMENTE	
	public void jogarNovamente() {
		// CASO O JOGO FOR INTERROMPIDO PELO GAME OVER, A VARIAVEL RECEBERÁ FALSE PARA
		// SER INICIADA NOVAMENTE
		if (gameOver == true) {
			gameOver = false;
		}
		// VIDAS RECEBERÁ 3 QUE É COMO SE INICIA O JOGO
		vidas = 3;
		// LISTAS SÃO LIMPADAS
		vida.clear();
		// VALOR RECEBE 0 PARA PASSAR AS POSIÇÕES DAS VIDAS
		valor = 0;
		// PASSANDO O VALOR DE X E Y PARA O SUBMARINO VOLTAR A SUA POSIÇÃO INICIAL DO
		// JOGO
		sub.setX(100);
		sub.setDx(0);
		sub.setY(100);
		sub.setDy(0);
		// CHAMANDO O METODO PARA GERAR AS POSIÇÕES DOS OBJETOS
		inicializaObjetos();
		// PASSANDO A VARIAVEL PARA 10000 NOVAMENTE PARA DETERMINAR O FIM DO JOGO
		Fim = 10000;
		// ZERANDO A VARIAVEL QUE CONTROLA OS LIXOS COLETADOS
		coleta = 0;
	}

//METODO DO TECLADO AO SER PRESSIONADO PARA A FASE
	private class TecladoAdapter extends KeyAdapter {
		@Override
		// KEY EVENT E, SIGNIFICA A TELCA QUE FOR PRESSIONADA
		public void keyPressed(KeyEvent e) {
			sub.KeyPressed(e);
		}

		@Override
//METODO PARA AS VARIAVEIS ZERAR E RECEBEREM UM NOVO COMANDO DA TECLA
		public void keyReleased(KeyEvent e) {
			sub.keyRelease(e);
		}
	}

}
