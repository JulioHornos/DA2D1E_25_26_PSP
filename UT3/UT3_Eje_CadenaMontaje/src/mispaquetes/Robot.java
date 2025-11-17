package mispaquetes;

import java.util.Arrays;
import java.util.Random;

public class Robot extends Thread{
	
	private final static Random RANDOM = new Random();
	private Cinta miCinta;
	private int contador = 0;
	private final int NUMERO_VUELTAS = 20;
	
	public Robot(Cinta cinta){
		this.miCinta = cinta;
	}

	@Override
	public  void run() {
		int n;
		Integer retorno=0;
		while(miCinta.isSimulaciónMarcha()||miCinta.getHuecosLibres()<3){
			if(miCinta.isSimulaciónMarcha()) {
				 try {
				     n = RANDOM.nextInt(3)+1;
				     System.out.println("Produciendo tipo "+ n);
				     sleep(RANDOM.nextInt(250));
				     retorno = this.miCinta.setcadena(n);	    			    	 		     
				  } catch (InterruptedException e) {			  
					  // Si paran el hilo, salimos
					  return;
				  }
				 contador++;
				 if (contador == NUMERO_VUELTAS) miCinta.setSimulaciónMarcha();
				
			}else {
				miCinta.despiertaHilos();
			}
		}		
	}
}
