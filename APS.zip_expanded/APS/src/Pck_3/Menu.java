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
	// CRIA AS VARIAVEIS DOS BOTÕES QUE IRÃO COMPOR O MENU
	JButton iniciar = new JButton("Iniciar");
	JButton instrucoes = new JButton("Instruções");
	JButton sair = new JButton("Sair");
	private Image Mar;
	JLabel recado = new JLabel("Lixo coletado");
	
	//MÉTODO ACITIONLISTENER PARA DEFINIR FUNÇÃO AOS BOTÕES
public void actionPerformed(ActionEvent e) {
	//O LAÇO SEGUINTE DEFINE O EVENTO DA VARIAVEL e AO BOTÃO INICIAR
	if(e.getSource()==iniciar) { // SE CLICAR NO BOTÃO INICIAR
		Principal jogo = new Principal(); // INSTANCIA O JFRAME DA TELA PRINCIAPL
		this.dispose(); // INFORMA QUE AO CLICAR NO BOTÃO INICIAR, A TELA MENU IRÁ FECHAR
		jogo.setVisible(true); // INFORMA QUE AO CLICAR NO BOTÃO INICIAR A TELA PRINCIPAL SE TORNARÁ VISÍVEL	
		}
	
	if(e.getSource()==instrucoes) {// SE CLICAR NO BOTAO INSTRUCOES
		Instrucoes instrucoes = new Instrucoes(); // INSTANCIA O JFRAME DA TELA INSTRUCOES
		
		this.dispose(); // INFORMA QUE AO CLICAR NO BOTÃO INSTRUÇÕES, A TELA MENU IRÁ FECHAR
		instrucoes.setVisible(true); // INFORMA QUE AO LICAR NO BOTÃO INSTRUÇÕES A TELA INSTRUÇÕES SE TORNARÁ VISÍVEL
	}
	
	if(e.getSource()==sair) { // SE CLICAR NO BOTÃO SAIR
		System.exit(0); // FAZ COM QUE O APLICATIVO SE FECHE
	}
	
}
	//MÉTODO CONSTRUTOR DO MENU
	public Menu() {
		Panel a = new Panel();
		a.add(iniciar);
		a.add(instrucoes);
		a.add(sair);
		a.add(recado);
		add(a);
		//recado.setLayout(null);
		a.setLayout(getLayout());
		
		
		iniciar.addActionListener(this); // ADICIONA O MÉTODO ACTIONLISTENER AO BOTÃO INICIAR
		instrucoes.addActionListener(this); // ADICIONA O MÉTODO ACTIONLISTENER AO BOTÃO INSTRUÇÕES
		sair.addActionListener(this); // ADICIONA O MÉTODO ACITION LISTENER AO BOTÃO SAIR
		
		//setLayout(null); // DEFINE QUE NÃO IREMOS USAR NENHUM LAYOUT
		iniciar.setBounds(475, 100, 300, 100); // DEFINE RESPECTIVAMENTE O X,Y,LARGURA, ALTURA DO BOTÃO INICIAR
		//add(iniciar); //ADICIONA O BOTÃO INICIAR NA JANELA
		
		// ABAIXO SEGUE A MESMA LÓGICA
		instrucoes.setBounds(475, 300, 300, 100);
		//add(instrucoes);
		
		sair.setBounds(475, 500, 300, 100);
		//add(sair);
		
		setTitle("Caça ao Lixo"); // DEFINE O TÍTULO DA JANELA
		setSize(1280,720); // DEFINE O TAMANHO DA JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // INFORMA QUE AO CLICAR NO XZINHO DA JANELA, ELA FECHA E NÃO FICA EM SEGUNDO PLANO
		setLocationRelativeTo(null);  // DEFINE PARA QUE A JANELA APAREÇA CENTRALIZADA NO MONITOR
		setResizable(false); // DEFINE QUE ELA NÃO PODERÁ SER REDIMENSIONADA
		setVisible(true); // INFORMA QUE ELA ESTARÁ VISÍVEL
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
