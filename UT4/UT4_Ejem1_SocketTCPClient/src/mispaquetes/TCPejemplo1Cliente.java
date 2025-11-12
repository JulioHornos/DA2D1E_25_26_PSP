package mispaquetes;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPejemplo1Cliente  {
  public static void main(String[] args) throws Exception {
	String Host = "localhost"; //"192.168.56.1";
	int Puerto = 6000;//puerto remoto	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket Cliente = new Socket(Host, Puerto);

	// CREO FLUJO DE SALIDA AL SERVIDOR	
	DataOutputStream flujoSalida = new
            DataOutputStream(Cliente.getOutputStream());
	
	// CREO FLUJO DE ENTRADA AL SERVIDOR	
	DataInputStream flujoEntrada = new 
            DataInputStream(Cliente.getInputStream());
	
	System.out.println("Dime tu nombre: ");
	String nombre = sc.nextLine();
	
	flujoSalida.writeUTF(nombre);
	
	// EL SERVIDOR ME ENVIA UN MENSAJE
	System.out.println("Recibiendo del SERVIDOR: \n\t" + 
		               flujoEntrada.readUTF());		

	System.out.println("Vale, ahora dime 5 números (enteros) que quieras sumar");
	int numero;
	for (int i=1; i<6; i++) {
		// ENVIO UN SALUDO AL SERVIDOR
		System.out.println("Dame el número : "+i);
		numero = sc.nextInt();
		flujoSalida.writeInt(numero);
	
		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + 
	               flujoEntrada.readUTF());		
	}
	
	// EL SERVIDOR ME ENVIA UN MENSAJE
	System.out.println("La suma de los números es: " + 
               flujoEntrada.readInt());

	// CERRAR STREAMS Y SOCKETS	
	flujoEntrada.close();	
	flujoSalida.close();	
	Cliente.close();	
  }// main
}// 
