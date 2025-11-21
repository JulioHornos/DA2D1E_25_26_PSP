package mispaquetes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Tac {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
		Socket Cliente = new Socket(Host, Puerto);
	
		OutputStream salida;				
		// CREO FLUJO DE SALIDA AL SERVIDOR	
		salida = Cliente.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);	
							
		for(int i=0; i<100; i++) {
			
			flujoSalida.writeUTF("TUC");
			flujoSalida.flush();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		flujoSalida.writeUTF("*");		
		flujoSalida.close();		//

		System.out.println("Fin del envio... ");
		Cliente.close();
		}//
}
