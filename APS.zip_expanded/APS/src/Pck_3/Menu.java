package Pck_3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Pck_1.Principal;
import Pck_2.Fase;

public class Menu extends JFrame implements ActionListener{
	// CRIA AS VARIAVEIS DOS BOT�ES QUE IR�O COMPOR O MENU
	JButton iniciar = new JButton("Iniciar");
	JButton instrucoes = new JButton("Instru��es");
	JButton sair = new JButton("Sair");
	private Image Mar;
	JLabel recado = new JLabel("Lixo coletado");
	
	//M�TODO ACITIONLISTENER PARA DEFINIR FUN��O AOS BOT�ES
public void actionPerformed(ActionEvent e) {
	//O LA�O SEGUINTE DEFINE O EVENTO DA VARIAVEL e AO BOT�O INICIAR
	if(e.getSource()==iniciar) { // SE CLICAR NO BOT�O INICIAR
		Principal jogo = new Principal(); // INSTANCIA O JFRAME DA TELA PRINCIAPL
		this.dispose(); // INFORMA QUE AO CLICAR NO BOT�O INICIAR, A TELA MENU IR� FECHAR
		jogo.setVisible(true); // INFORMA QUE AO CLICAR NO BOT�O INICIAR A TELA PRINCIPAL SE TORNAR� VIS�VEL	
		}
	
	if(e.getSource()==instrucoes) {// SE CLICAR NO BOTAO INSTRUCOES
		Instrucoes instrucoes = new Instrucoes(); // INSTANCIA O JFRAME DA TELA INSTRUCOES
		
		this.dispose(); // INFORMA QUE AO CLICAR NO BOT�O INSTRU��ES, A TELA MENU IR� FECHAR
		instrucoes.setVisible(true); // INFORMA QUE AO LICAR NO BOT�O INSTRU��ES A TELA INSTRU��ES SE TORNAR� VIS�VEL
	}
	
	if(e.getSource()==sair) { // SE CLICAR NO BOT�O SAIR
		System.exit(0); // FAZ COM QUE O APLICATIVO SE FECHE
	}
	
}
	//M�TODO CONSTRUTOR DO MENU
	public Menu() {
		Panel a = new Panel();
		a.add(iniciar);
		a.add(instrucoes);
		a.add(sair);
		a.add(recado);
		add(a);
		//recado.setLayout(null);
		a.setLayout(getLayout());
		
		
		iniciar.addActionListener(this); // ADICIONA O M�TODO ACTIONLISTENER AO BOT�O INICIAR
		instrucoes.addActionListener(this); // ADICIONA O M�TODO ACTIONLISTENER AO BOT�O INSTRU��ES
		sair.addActionListener(this); // ADICIONA O M�TODO ACITION LISTENER AO BOT�O SAIR
		
		//setLayout(null); // DEFINE QUE N�O IREMOS USAR NENHUM LAYOUT
		iniciar.setBounds(475, 100, 300, 100); // DEFINE RESPECTIVAMENTE O X,Y,LARGURA, ALTURA DO BOT�O INICIAR
		//add(iniciar); //ADICIONA O BOT�O INICIAR NA JANELA
		
		// ABAIXO SEGUE A MESMA L�GICA
		instrucoes.setBounds(475, 300, 300, 100);
		//add(instrucoes);
		
		sair.setBounds(475, 500, 300, 100);
		//add(sair);
		
		setTitle("Ca�a ao Lixo"); // DEFINE O T�TULO DA JANELA
		setSize(1280,720); // DEFINE O TAMANHO DA JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // INFORMA QUE AO CLICAR NO XZINHO DA JANELA, ELA FECHA E N�O FICA EM SEGUNDO PLANO
		setLocationRelativeTo(null);  // DEFINE PARA QUE A JANELA APARE�A CENTRALIZADA NO MONITOR
		setResizable(false); // DEFINE QUE ELA N�O PODER� SER REDIMENSIONADA
		setVisible(true); // INFORMA QUE ELA ESTAR� VIS�VEL
	}
	public static void main(String[] args) {
		new Menu(); // INSTANCIA A JANELA MENU
		

	}
	//CRIANDO UM PANEL PARA COLOCAR A IMAGEM DE FUNDO E OS BOTOES DO JFRAME
	public class Panel extends JPanel{
		public void paintComponent(Graphics g ) {
			super.paintComponent(g);
			ImageIcon referencia = new ImageIcon("res//Sol.jpg");
			Mar = referencia.getImage();
			g.drawImage(Mar, 0, 0, this);		
		}
	}

}
