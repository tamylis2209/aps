package Pck_2;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Vida {
	private boolean lev2 = false;
	// VARIAVEL PARA A IMAGEM DA IMAGEM
	private Image imagem;
	// VARIAVEIS PARA MOVIMENTAÇÃO DA IMAGEM
	private int x, y;
	// LARGURA E ALTURA DA IMAGEM
	private int largura, altura;
	// VELOCIDADE SERÁ MAIS RAPIDA POR SE TRATAR DE UM BONUS
	private static int velocidade;

	//METODO CONSTRUTOR
	public Vida(int x, int y) {
		//O VALOR DE X QUE ENTRAR COMO PARAMETRO IRÁ SER ARMAZENADO NA VARIAVEL X 
		this.x = x;
		//O VALOR DE Y QUE ENTRAR COMO PARAMETRO IRÁ SER ARMAZENADO NA VARIAVEL Y
		this.y = y;
	}
	public void level2() {
		lev2=true;
	}
	//METODO PARA CARREGAR A IMAGEM
	public void load() {
		//CRIANDO UMA NOVA IMAGEM E PASSANDO O LOCAL E NOME AONDE ESTÁ
		ImageIcon referencia = new ImageIcon("res//Vida.png");
		//A VARIAVEL DO TIPO IMAGE VAI RECEBER ESSA IMAGEM
		imagem = referencia.getImage();
		//PASSANDO A LARGURA DA IMAGEM
		this.largura = imagem.getWidth(null);
		//PASSANDO A ALTURA DA IMAGEM
		this.altura = imagem.getHeight(null);
	}
	//METODO PARA ATUALIZAR A MOVIMENTAÇÃO DA IMAGEM
	public void update() {
		if (lev2 == false) {
			velocidade = 5;
		} else {
			velocidade = 7;
		}
		this.x -= velocidade;
	}
	//METODO PARA A COLISÃO DAS IMAGENS
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	//METODO PARA PEGAR O VALOR DA VELOCIDADE
	public static int getVelocidade() {
		return velocidade;
	}
	//METODO PARA INSERIR VALOR
	public static void setVelocidade(int velocidade) {
		Vida.velocidade = velocidade;
	}
	//METODO PARA PEGAR O VALOR DE X 
	public int getX() {
		return x;
	}
	//METODO PARA PEGAR O VALOR DE Y
	public int getY() {
		return y;
	}
	//METODO PARA PEGAR A IMAGEM
	public Image getImagem() {
		return imagem;
	}

}

