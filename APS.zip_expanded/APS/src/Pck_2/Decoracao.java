package Pck_2;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Decoracao {
	private boolean lev2 = false;
	private boolean colidiu1 = false;
	private boolean colidiu12 = false;
	private boolean colidiu3 = false;
	// VARIAVEL PARA A IMAGEM DA IMAGEM
	private Image imagem;
	// VARIAVEIS PARA MOVIMENTAÇÃO DA IMAGEM
	private int x, y;
	// LARGURA E ALTURA DA IMAGEM
	private int largura, altura;
	// VARIAVEL PARA CONTROLAR A VELOCIDADE
	private static int velocidade = 2;

	// METODO CONSTRUTOR
	public Decoracao(int x, int y) {
		// O VALOR DE X QUE ENTRAR COMO PARAMETRO IRÁ SER ARMAZENADO NA VARIAVEL X
		this.x = x;
		// O VALOR DE Y QUE ENTRAR COMO PARAMETRO IRÁ SER ARMAZENADO NA VARIAVEL Y
		this.y = y;
		// IRÁ SER INICIADO COMO VISIVEL
	}
	public void level2() {
		lev2=true;
	}

	public void update() {
		if (lev2 == false) {
			velocidade = 2;
		} else {
			velocidade = 4;
		}
		this.x -= velocidade;
	}

	// METODO PARA CARREGAR A IMAGEM
	public void load() {
		// CRIANDO UMA NOVA IMAGEM E PASSANDO O LOCAL E NOME AONDE ESTÁ
		ImageIcon referencia = new ImageIcon("res//Planta.png");
		// A VARIAVEL DO TIPO IMAGE VAI RECEBER ESSA IMAGEM
		imagem = referencia.getImage();
		// PASSANDO A LARGURA DA IMAGEM
		this.largura = imagem.getWidth(null);
		// PASSANDO A ALTURA DA IMAGEM
		this.altura = imagem.getHeight(null);
	}

	public void load2() {
		// CRIANDO UMA NOVA IMAGEM E PASSANDO O LOCAL E NOME AONDE ESTÁ
		ImageIcon referencia = new ImageIcon("res//Esqueleto.png");
		// A VARIAVEL DO TIPO IMAGE VAI RECEBER ESSA IMAGEM
		imagem = referencia.getImage();
		// PASSANDO A LARGURA DA IMAGEM
		this.largura = imagem.getWidth(null);
		// PASSANDO A ALTURA DA IMAGEM
		this.altura = imagem.getHeight(null);
	}
	// METODO PARA PEGAR O VALOR DE X
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	// METODO PARA PEGAR O VALOR DE Y
	public int getY() {
		return y;
	}

	// METODO PARA PEGAR A IMAGEM
	public Image getImagem() {
		return imagem;
	}

	public boolean isColidiu1() {
		return colidiu1;
	}

	public void setColidiu(boolean colidiu) {
		this.colidiu1 = colidiu;
	}

	public boolean isColidiu2() {
		return colidiu12;
	}

	public void setColidiu2(boolean colidiu12) {
		this.colidiu12 = colidiu12;
	}

	public boolean isColidiu3() {
		return colidiu3;
	}

	public void setColidiu3(boolean colidiu3) {
		this.colidiu3 = colidiu3;
	}


}
