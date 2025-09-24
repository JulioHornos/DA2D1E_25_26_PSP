package mispaquetes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PedirFichero {

	public static void main(String[] args) throws IOException {
		//creamos objeto File al directorio donde esta Ejemplo2
		File directorio = new File("C:\\Julio\\Modulos\\PSP\\PSP_CURSO\\PSP_CURSO\\UT2\\UT2_9_CalcularParImpar\\bin");	

		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java","mispaquetes.Calcular");		
	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
	    
	    File fBat = new File("C:\\Julio","entrada.txt");
	    File fOut = new File("C:\\Julio","salida.txt");
	    File fErr = new File("C:\\Julio","error.txt");
	 
	    pb.redirectInput(fBat);
	    pb.redirectOutput(fOut);
	    pb.redirectError(fErr); 
		
	    //se ejecuta el proceso
		Process p = pb.start();

	}

}
