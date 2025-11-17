package mispaquetes;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Cinta cinta = new Cinta();	
		  Robot robot = new Robot(cinta);
		  Empaquetador  empaquetador1 = new Empaquetador(1,cinta);
		  Empaquetador  empaquetador2 = new Empaquetador(2,cinta);
		  Empaquetador  empaquetador3 = new Empaquetador(3,cinta);
		  
		  ExecutorService executor = Executors.newFixedThreadPool(4);

		        // Arrancamos los hilos
		  executor.submit(robot);
		  executor.submit(empaquetador1);
		  executor.submit(empaquetador2);
		  executor.submit(empaquetador3);
	  
	      executor.shutdown();
	      
	      try {
			executor.awaitTermination(1,TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	      System.out.println("************************************************");
		  System.out.println("Quedan en la cinta"+ Arrays.toString(cinta.getCadena()));
		  System.out.println("Puestos en total:"+ cinta.getTotalPuestos());
		  System.out.println("Recogidos por tipo:"+ Arrays.toString(cinta.getRecogidos()));


	}

}
