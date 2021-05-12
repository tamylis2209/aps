package Pck_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instrucoes extends JFrame implements ActionListener {
	private Image Mar;
	
	JButton menu = new JButton("Menu"); //INSTANCIA E CRIA O BOTAO MENU
	
	Font FTitulo = new Font("Arial", Font.BOLD,50); // CRIA UM ESTILO DE FONTE DO TIPO ARIAL, NEGRITO DE TAMANHO 50
	Font Ftexto = new Font("Arial", Font.BOLD, 25); // CRI UM ESTILO DE FONTE DO TIPO ARIAL, NEGRITO DE TAMANHO 25
	
	//TODOS ABAIXO CRIA UMA LABEL (LEGENDA)

	JLabel titulo = new JLabel("Instru��es");
	JLabel linha1 = new JLabel(""); 
	JLabel linha2 = new JLabel("");
	JLabel linha3 = new JLabel("");
	JLabel linha4 = new JLabel("");
	JLabel linha5 = new JLabel("");
	JLabel linha6 = new JLabel("");
	JLabel linha7 = new JLabel("");
	JLabel linha8 = new JLabel("");
	
	
	
	//M�TODO CONSTRUTOR
	public Instrucoes() {	
		//setLayout(null); //DEFINO QUE N�O USAREMOS LAYOUT
		
		titulo.setFont(FTitulo); // SETO QUE ESTA LABEL USAR� O ESTILO DE FONTE TITULO
		titulo.setBounds(475, -200, 500, 500); //DEFINO RESPECTIVAMENTE O X,Y,LARGURA E ALTURA DA LABEL
		//add(titulo); //ADICIONO A LABEL AO PROGRAMA
		
		//LINHAS ABAIXO SEGUE A MESMA LOGICA
		linha1.setFont(Ftexto);
		linha1.setBounds(100, -100, 1170, 500);
		linha1.setText("Ol�, seja Bem-Vindo (a) ao *NOME DO JOGO*. Aqui voc� encontrar� um pequeno tutorial de como "); // DEFINE O TEXTO DA LABEL
		linha2.setFont(Ftexto);
		linha2.setBounds(50, -50, 1170, 500);
		linha2.setText("jogar, com informa��es �teis para uma melhor experi�ncia");
		linha3.setFont(Ftexto);
		linha3.setBounds(100,0,1170,500);
		linha3.setText("O jogo � muito simples. Voc� faz parte da equipe S.O.S Oceania. Sua miss�o � limpar os mares");
		linha4.setFont(Ftexto);
		linha4.setBounds(50,  50,  1170,  500);
		linha4.setText("garantindo a seguran�a e bem estar dos animais ali presentes. Mas cuidado para n�o acertar os");
		linha5.setFont(Ftexto);
		linha5.setBounds(50, 100, 1170, 500);
		linha5.setText("animais ali presentes.");
		linha6.setFont(Ftexto);
		linha6.setBounds(100, 150, 1170, 500);
		linha6.setText("Utilize as setas do seu teclado para mover o Submarino. Colete os lixos para limpar o mar e");
		linha7.setFont(Ftexto);
		linha7.setBounds(50, 200, 1170, 500);
		linha7.setText("desvie dos animais. Quando aparecer um cora��o, colete-o para aumentar suas chances de vida");
		linha8.setFont(Ftexto);
		linha8.setBounds(50, 250, 1170, 500);
		linha8.setText("Caso voc� fique sem cora��es, ser� Fim de Jogo. Divirta-se!");
		
	
		
		menu.addActionListener(this); // ADICIONA O M�TODO ACTION LISTENER AO BOTAO MENU
		menu.setBounds(560, 550, 150, 100); //DEFINE RESPECTIVAMENTE O X,Y,LARGURA E ALTURA DA LABEL
		//add(menu); //ADICIONA O BOT�O AO PROGRAMA
		
		setTitle("Ca�adores de Lixo");//DEFINE O T�TULO DA JANELA
		setSize(1280,720); // DEFINE O TAMANHO DA JANELA
		setDefaultCloseOperation(EXIT_ON_CLOSE);//INFORMA QUE AO CLICAR NO XZINHO O PROGRAMA FECHARA
		setLocationRelativeTo(null);//FAZ COM QUE A JANELA APARECERA CENTRALIZADA
		setVisible(true);//DEFINE QUE A JANELA FICARA VISIVEL
		Panel a = new Panel();
		/*titulo.setForeground(Color.GREEN);
		menu.setBackground(Color.white);
		linha1.setForeground(Color.white);
		linha2.setForeground(Color.white);
		linha3.setForeground(Color.white);
		linha4.setForeground(Color.white);
		linha5.setForeground(Color.white);
		linha6.setForeground(Color.white);
		linha7.setForeground(Color.white);
		linha8.setForeground(Color.white);*/
		a.add(menu);
		a.add(titulo);
		a.add(linha1);
		a.add(linha2);
		a.add(linha3);
		a.add(linha4);
		a.add(linha5);
		a.add(linha6);
		a.add(linha7);
		a.add(linha8);
		add(a);
		a.setLayout(new BorderLayout());
	}
	
	//M�TODO PARA ADICIONAR FUN��ES AOS BOT�ES
	public void actionPerformed(ActionEvent e) {
		//LA�O SEGUINTE DEFINE A FUN��O DA VARIAVEL e QUANDO CLICAR NO BOTAO MENU
		if(e.getSource()==menu) {// QUANDO CLICAR NO BOTAO MANU
			Menu menu = new Menu(); //INSTANCIA O JFRAME DA TELA MANU
			
			this.dispose(); // INFORMA QUE A JANELA INSTRUCOES SER� FECHADA
			menu.setVisible(true);//ABRE A TELA MENU
		}
		
	}
	//CRIANDO UM PANEL PARA COLOCAR A IMAGEM DE FUNDO E OS BOTOES DO JFRAME
	public class Panel extends JPanel{
		public void paintComponent(Graphics g ) {
			super.paintComponent(g);
			ImageIcon referencia = new ImageIcon("res//Azul.jpg");
			Mar = referencia.getImage();
			g.drawImage(Mar, 0, 0, this);		
		}
	}
}
