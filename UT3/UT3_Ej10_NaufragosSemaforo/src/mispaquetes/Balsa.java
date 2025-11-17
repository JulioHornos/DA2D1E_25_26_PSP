package mispaquetes;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Balsa extends Thread {
	  private int numPlazas;
	  private Naufrago miNaufrago; 
	  private int numNufragosRescatados = 0;
	  private Semaphore acceso;
	  private final Random RANDOM = new Random();


	  public Balsa(int numPlazas, Naufrago miNaufrago, Semaphore acceso, String name) {
	    this.numPlazas = numPlazas;
	 // mostramos la balsa actual y la cantidad de plazas de ésta
	    this.setName(name);
		System.out.println("La balsa actual es " + this.getName()
		                        + " y tiene  " + numPlazas + " plazas");
	    this.miNaufrago = miNaufrago;
	    this.acceso = acceso;
	  }

	  public int getNumPlazas() {
	    return numPlazas;
	  }
	  
	  public void setNumRescatados(int numRescates) {
		    this.numNufragosRescatados = numNufragosRescatados + numRescates;
		  }
		  
	  public int getNumRecatados() {
		    return this.numNufragosRescatados;
	  }
	  
	  @Override
	  public void run() {
	    while(this.miNaufrago.getCantidadNaufragos() > 0) {
	    	
		    try {
				acceso.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		      // mostramos el número de náufragos restantes
				System.out.println("\nQuedan " + this.miNaufrago.getCantidadNaufragos() + " náufragos");
		      // llamamos al método sincronizado para rescatar náufragos
		    int naufragosRescatados =  this.miNaufrago.rescatar(this.miNaufrago.getCantidadNaufragos(), this.getNumPlazas(), this.getName());
		    
		    this.setNumRescatados(naufragosRescatados);
		    acceso.release();
		    this.yield(); // Si comentamos, los hilos se vuelven "egoistas"
		    try {
				Thread.sleep(RANDOM.nextInt(1800,2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    }
	    // cuando una balsa está rescatando a los últimos náufragos las demás
	    // vuelven a su puesto
	    System.out.println("\nYa no quedan náufragos y la " + this.getName()
	                        + " está volviendo a su puesto. Ha rescatado " + 
	    		this.getNumRecatados()+" naufragos en total");
	    
	    return;
	  }
}
