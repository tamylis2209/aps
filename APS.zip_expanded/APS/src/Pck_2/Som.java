package Pck_2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Som {
	//CRIANDO UM OBJETO DO TIPO URL E PASSANDO O NOME DO ARQUIVO
	URL audio = Som.class.getResource("Som.wav");
	//A VARIAVEL SOM DO TIPO AUDIO CLIP VAI RECEBER ESSE ARQUIVO
	AudioClip som = Applet.newAudioClip(audio);
	//METODO PARA TOCAR OS OUTROS TIPOS DE SOM
	public void sons(String nomeDoAudio) {
		//CRIANDO UM NOVO OBJETO DO TIPO URL + WAV POR CONTA DO FORMATO DO ARQUIVO
		URL som2 = getClass().getResource(nomeDoAudio + ".wav");
		AudioClip audio2 = Applet.newAudioClip(som2);
		//CHAMANDO O METODO PLAY PARA INICIAR O SOM
		audio2.play();
	}
}
