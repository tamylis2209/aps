package Pck_2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Submarino {
	
//CRIAÇÃO DAS VARIAVEIS 
private boolean lev2 = false;
private int x,y;
private int dx,dy;
private Image imagem;
private int altura,largura;
//CRIANDO O CONSTRUTOR
public Submarino() {
	//DEFININDO A COORDENADA DA TELA QUE O PLAYER IRÁ APARECER
	this.x=100;
	this.y=100;
}
public void level2() {
	lev2=true;
}
public void level1() {
	lev2=false;
}
	
//METODO PARA DEFINIR A IMAGEM DO PLAYER
public void load() {
	//COLOCANDO A IMAGEM DO SUBMARINO
	ImageIcon referencia = new ImageIcon("res//Submarino.png");
	//DEFININDO A ALTURA E LARGURA DA IMAGEM
	imagem=referencia.getImage();
	altura = imagem.getHeight(null);
	largura = imagem.getWidth(null);
}
//METODO PARA MEXER O PLAYER
public void update() {
	//MOVENDO NO EIXO X E NO EIXO Y
	if(x>1165 && dx>=3) {
		dx=0;
	}
	if(x<0 && dx<=-3) {
		dx=0;
	}
	if(y<0 &&dy<=-3) {
		dy=0;
	}
	if(y>609 &&dy>=3) {
		dy=0;
	}
	x+= dx;
	y+= dy;	
	
	}
public Rectangle getBounds() {
	return new Rectangle(x,y,largura,altura);
}
	// CRIANDO UM METODO PARA MOVER O CAMINHAO A PARTIR DA TECLA PRESSIONADA
public void KeyPressed (KeyEvent tecla) {
	//QUANDO A TECLA FOR PRESSIONADA O PROGRAMA IRÁ RECONHECER E REALIZAR ALGUMA AÇÃO
	int codigo = tecla.getKeyCode();
	//SE A TECLA PRESSIONADA FOR A SETA PARA CIMA, Y IRÁ PARA -2
	if(codigo == KeyEvent.VK_UP){
		if(lev2==false) {
		dy=-3;}else {
			dy=-5;
		}
	}
	//SE A TECLA PRESSIONADA FOR A SETA PARA BAIXO, Y IRÁ PARA 2
	if(codigo == KeyEvent.VK_DOWN){
		if(lev2==false) {
			dy=3;
			}else 
			{
				dy=5;
			}
	}
	//SE A TECLA PRESSIONADA FOR A SETA PARA ESQUERDA, X IRÁ PARA -2
	if(codigo == KeyEvent.VK_LEFT){
		if(lev2==false) {
			dx=-3;
			}else 
			{
				dx=-5;
			}
	}
	//SE A TECLA PRESSIONADA FOR A SETA PARA DIREITA, X IRÁ PARA 2
	if(codigo == KeyEvent.VK_RIGHT){
		if(lev2==false) {
			dx=3;
			}else
			{
				dx=5;
			}
	}
}

/* METODO AO PARAR DE PRESSIONAR A TECLA, AS VARIAVEIS DX E DY IRÁ ZERAR FAZENDO COM 
QUE O CAMINHAO PARE E VOLTE AO NUMERO 0 PARA UM NOVO COMANDO AO CLICAR*/
public void keyRelease(KeyEvent tecla) {
	int codigo = tecla.getKeyCode();
	if(codigo == KeyEvent.VK_UP){
		dy=0;
	}
	if(codigo == KeyEvent.VK_DOWN){
		dy=0;
	}
	if(codigo == KeyEvent.VK_LEFT){
		dx=0;
	}
	if(codigo == KeyEvent.VK_RIGHT){
		dx=0;
}
}
//METODO PARA RETORNAR O VALOR DE X 

public int getX() {
	return x;
	}
public void setX(int x) {
	this.x = x;
}

public void setY(int y) {
	this.y = y;
}

//METODO PARA RETORNAR O VALOR DE Y
public int getY() {
	return y;
	}
//METODO PARA RETORNAR O VALOR DA IMAGEM 
public Image getImagem() {
	return imagem;
	}

public void setDx(int dx) {
	this.dx = dx;
}

public void setDy(int dy) {
	this.dy = dy;
}



}
