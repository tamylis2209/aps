package Pck_1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Pck_2.Fase;
public class Principal  extends JFrame  {
public Principal() {

	add(new Fase());
	
	//TITULO DA INTERFACA
	setTitle("Meu jogo");
	//TAMANHO DA JANELA
	setSize(1280,720);
	//AO CLICAR NO X DA INTERFACE, ELA IRÁ FECHAR
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//METODO PARA A JANELA APARECER CENTRALIZADA
	setLocationRelativeTo(null);
	//METODO PARA CANCELAR O REDIMENSIONAMENTO DA JANELA
	this.setResizable(false);
	//PARA A JANELA SER VISIVEL
	setVisible(true);
}

}


