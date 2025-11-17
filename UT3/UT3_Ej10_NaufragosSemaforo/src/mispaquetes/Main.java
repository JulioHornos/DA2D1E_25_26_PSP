package mispaquetes;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main 
{
	  
	  public static void main(String[] args)  
	  	  
	  {		
		  final Random RANDOM = new Random();
		  final int NUM_NAUFRAGOS_BARCA = 15;
		  Semaphore acceso = new Semaphore(2);
		  
		  
		  int numero = RANDOM.nextInt(800,1000);
		  Naufrago nf = new Naufrago(numero);
		 
		  Balsa balsa1 = new Balsa(NUM_NAUFRAGOS_BARCA,nf,acceso,"Balsa 1");		  
		  Balsa balsa2 = new Balsa(NUM_NAUFRAGOS_BARCA ,nf,acceso,"Balsa 2");
		  Balsa balsa3 = new Balsa(NUM_NAUFRAGOS_BARCA ,nf,acceso, "Balsa 3");		
		  Balsa balsa4 = new Balsa(NUM_NAUFRAGOS_BARCA,nf,acceso,"Balsa 4");		  
		  Balsa balsa5 = new Balsa(NUM_NAUFRAGOS_BARCA ,nf,acceso,"Balsa 5");
		  
		  Contador contador = new Contador(nf);
		
		  balsa1.setPriority(Thread.MAX_PRIORITY);		
		  balsa2.setPriority(Thread.MIN_PRIORITY);		
		  balsa3.setPriority(Thread.MIN_PRIORITY);		
		  balsa4.setPriority(Thread.MIN_PRIORITY);
		  balsa5.setPriority(Thread.MIN_PRIORITY);

		  ExecutorService executor = Executors.newFixedThreadPool(6);
	  	      
	      executor.submit(balsa1);
	      executor.submit(balsa2);
	      executor.submit(balsa3);
	      executor.submit(balsa4);
	      executor.submit(balsa5);
	      executor.submit(contador);
	      
	      executor.shutdown();
		  
	      try {
			executor.awaitTermination(1,TimeUnit.HOURS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  						
			System.out.printf("El rescate ha concluido%n");
		  

		}	  	
}
