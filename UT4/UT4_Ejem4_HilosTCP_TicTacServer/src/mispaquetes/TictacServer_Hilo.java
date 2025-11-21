package mispaquetes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TictacServer_Hilo extends Thread{
	
	DataInputStream flujoEntrada,flujoEntrada2;
	InputStream entrada = null, entrada2 = null;
	Socket miSocket1 = null, miSocket2 = null;

	public TictacServer_Hilo(Socket miSocket1, Socket miSocket2){
		this.miSocket1 = miSocket1;
		this.miSocket2 = miSocket2;
		// se crean flujos de entrada
		try {
			entrada = this.miSocket1.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
			entrada2 = this.miSocket2.getInputStream();
			flujoEntrada2 = new DataInputStream(entrada2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public void run() {// tarea a realizar con el cliente
		String cadena = "";
		String cadena2 = "";
		while (!cadena.trim().equals("*")&&!cadena2.trim().equals("*")) {
			try {
				cadena = flujoEntrada.readUTF();
				System.out.println(cadena);
				cadena2 = flujoEntrada2.readUTF();
				System.out.println(cadena2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // fin while
		System.out.println("FIN CON: " + this.miSocket1.toString());
		System.out.println("FIN CON: " + this.miSocket2.toString());
		try {
			flujoEntrada.close();
			flujoEntrada2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.miSocket1.close();
			this.miSocket2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
