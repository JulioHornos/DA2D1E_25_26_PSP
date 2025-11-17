package mispaquetes;

import java.util.Random;

public class Repartidor extends Thread{
	 
	  private final static Random RANDOM = new Random();	
	  private ColaEntrega miCola;
	  private String retorno, miTipo, nombre;
	  private int pizzasRepartidas=0, hamburguesasRepartidas=0;
		 
	  public Repartidor (ColaEntrega cola, String tipo,  String nombre){
			this.miCola = cola;
			this.miTipo = tipo;
			this.nombre = nombre;
	  }
	  
	  public void run(){		
		   while(!miCola.isColaArmarioVacia()||!miCola.isPararCocina()) {
			   retorno = this.miCola.dameEntrega(miTipo, nombre);			    
			   if (retorno == "P") {
				   System.out.println("El repartidor "+nombre+" ha repartido una pizza.");
				   pizzasRepartidas++;					   
			   } else {
				   if(retorno == "H") {
					   System.out.println("El repartidor "+nombre+" ha repartido una hamburguesa.");
					   hamburguesasRepartidas++; 
				   }
			   }
			   
			   try {
				Thread.sleep(RANDOM.nextInt(300,600));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
		   
		   System.out.println("============================================================");
		   System.out.println("El repartidor "+nombre+" ha repartido "+pizzasRepartidas+" pizzas.");
		   System.out.println("El repartidor "+nombre+" ha repartido "+hamburguesasRepartidas+" hamburguesas.");
		   System.out.println("============================================================");
	  }
}
