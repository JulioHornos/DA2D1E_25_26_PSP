package mispaquetes;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		  ColaEntrega cola = new ColaEntrega(2);	
		  Cocinero cocineroHamburguesas = new Cocinero("H",cola);
		  Cocinero cocineroPizzas = new Cocinero("P",cola);
		  Repartidor  repartidor1 = new Repartidor(cola, "HP", "Juan");
		  Repartidor  repartidor2 = new Repartidor(cola, "HP", "Maria");
		  Repartidor  repartidor3 = new Repartidor(cola, "HP", "Pedro");
		  Repartidor  repartidor4 = new Repartidor(cola,"HP", "Ana");
		
		  
		  ExecutorService executor = Executors.newFixedThreadPool(6);

		        // Arrancamos los hilos
		  executor.submit(cocineroHamburguesas);
		  executor.submit(cocineroPizzas);
		  executor.submit(repartidor1);
		  executor.submit(repartidor2);
		  executor.submit(repartidor3);
		  executor.submit(repartidor4);
	  
	      executor.shutdown();
	      
	      try {
			executor.awaitTermination(1,TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.out.println("============================================================");
		  System.out.println("SIMULACION TERMINADA");		 
		  System.out.println("============================================================");
	
	}

}
