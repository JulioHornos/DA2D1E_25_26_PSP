package mispaquetes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TictacServer {
	public static void main(String args[]) throws IOException  {
		ServerSocket servidor;		
		servidor = new ServerSocket(6000);
		System.out.println("Servidor iniciado...");
		
		while (true) {	
			Socket cliente = new Socket();
			Socket cliente2 = new Socket();
			cliente=servidor.accept();//esperando cliente 1	
			cliente2=servidor.accept();//esperando cliente 2
			TictacServer_Hilo hilo = new TictacServer_Hilo(cliente, cliente2);
			hilo.start();		
		}
	}
}
