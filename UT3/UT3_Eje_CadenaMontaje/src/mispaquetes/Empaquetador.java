package mispaquetes;

import java.util.Arrays;
import java.util.Random;

public class Empaquetador extends Thread{
	
	  private int tipo;
	  private final static Random RANDOM = new Random();	
	  private Cinta miCinta;
		 
	  public Empaquetador (int tipo, Cinta cinta){
	   this.tipo = tipo;	
	   this.miCinta = cinta;
	  }
	  
	  public void run(){
		   Integer retorno = 0;
		   while(miCinta.isSimulaciónMarcha()||miCinta.getHuecosLibres()<3){		
			   try {
				   retorno= this.miCinta.getcadena(tipo,RANDOM.nextInt(500));			    
				   if (retorno>0) {
					   this.sleep(RANDOM.nextInt(500));
				   }			    				    	 		   
		   } catch (Exception e) {
				  // Si paran el hilo, salimos
			   return;}
		   }	  
	  }
}
