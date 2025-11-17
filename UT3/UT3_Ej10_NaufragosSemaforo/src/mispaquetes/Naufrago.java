package mispaquetes;

import java.util.Random;

public class Naufrago 
{
	private int cantidadNaufragos = 0;
	private final Random RANDOM = new Random();

	  public int getCantidadNaufragos()
{
	    return cantidadNaufragos;
	  }

	  public void setCantidadNaufragos(int cantidadNaufragos) 
	  {
	    this.cantidadNaufragos = cantidadNaufragos;
	  }

	  public Naufrago()
	  {

	  }

	  public Naufrago(int cantidadNaufragos)
	  {
	    this.cantidadNaufragos = cantidadNaufragos;
	  }

	  // método para actualizar el número de náufragos
	  public synchronized void rescatesRestantes(int rescatados)
	  {
	    cantidadNaufragos -= rescatados;
	  }
	  
	  public int rescatar(int naufragos, int numPlazas, String nombreBalsa) {
		  try{			   
			int naufragosrescatados = 0;
				  
			if (naufragos >numPlazas){
				naufragosrescatados=numPlazas;  
			}else {
				naufragosrescatados=naufragos;
			}
			
		    // mostramos la balsa actual y la cantidad de plazas de ésta
		    System.out.println("La balsa actual es " + nombreBalsa
		                        + " y rescatamos a  " + naufragosrescatados);
	      	this.rescatesRestantes(naufragosrescatados);		   
	
		    // asignamos un tiempo entre 1 y 3 segundos que tarda cada balsa en
		    // recoger a los náufragos y llegar la siguiente
		
		    Thread.sleep((RANDOM.nextInt(2000,3000)));
			    // actualizamos el número de náufragos

			return 	naufragosrescatados;

		    }catch(InterruptedException e) {  	return 	0; }

		}
}