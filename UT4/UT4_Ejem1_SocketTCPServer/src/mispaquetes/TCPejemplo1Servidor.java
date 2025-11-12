package mispaquetes;

import java.io.*;
import java.net.*;

public class TCPejemplo1Servidor {
  public static void main(String[] arg) throws IOException {
	// ASIGNO UN PUERTO A MI APLICACION E INSTANCIO UN SERVERSOCKET CON EL PUERT0
	// ASÍ COMO UN SOCKET PARA CUANDO SE CONECTA UN CLIENTE
	int numeroPuerto = 6000;// Puerto
	ServerSocket servidor = new ServerSocket(numeroPuerto);
	Socket clienteConectado = null;
	System.out.println("Esperando al cliente.....");
	clienteConectado = servidor.accept();

	// CREO FLUJO DE ENTRADA DEL CLIENTE
	InputStream entrada = null;
	entrada = clienteConectado.getInputStream();
	DataInputStream flujoEntrada = new DataInputStream(entrada);

	// CREO FLUJO DE SALIDA AL CLIENTE
	OutputStream salida = null;
	salida = clienteConectado.getOutputStream();
	DataOutputStream flujoSalida = new DataOutputStream(salida);
	
	String nombre = flujoEntrada.readUTF();
	
	// ENVIO UN SALUDO AL CLIENTE
	flujoSalida.writeUTF("HOLA: " + nombre);

	int suma = 0;
	int numero = 0;
	for (int i=1; i<6; i++) {
		// EL CLIENTE ME ENVIA UN MENSAJE
		numero = flujoEntrada.readInt();
		System.out.println("Cliente envia: " + numero);
	
		suma += numero;
		// ENVIO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("Estamos en la vuelta: "+i);
	}
	
	// Envíamos la suma
	flujoSalida.writeInt(suma);
	// CERRAR STREAMS Y SOCKETS
	entrada.close();
	flujoEntrada.close();
	salida.close();
	flujoSalida.close();
	clienteConectado.close();
	servidor.close();
  }// main
}// fin
