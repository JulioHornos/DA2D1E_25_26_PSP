package mispaquetes;

import java.util.Random;

public class Cocinero extends Thread{
	
	private final int MAX_COMIDAS = 15;
	private final Random RANDOM = new Random();
	private ColaEntrega miCola;
	private String miTipo;
	
	public Cocinero(String tipo, ColaEntrega cola){
		this.miCola = cola;
		this.miTipo = tipo;
	}
	
	public void HacerPizza() {
		for(int i=0; i<MAX_COMIDAS; i++) {
			 try {			     
			     System.out.println("Preparando una pizza... ");
			     sleep(RANDOM.nextInt(200));
			     this.miCola.colocarComidaArmario(this.miTipo);	
			  } catch (InterruptedException e) {			  
				  // Si paran el hilo, salimos
				  return;}
		}
		
		miCola.cocineroAcabaTurno();
		System.out.println("HILO PRODUCTOR FIN: El cocinero que hace pizzas ha acabado su turno");
	}

	public void HacerHamburguesa() {
		for(int i=0; i<MAX_COMIDAS; i++) {
			 try {			     
			     System.out.println("Preparando una hamburguesa... ");
			     sleep(RANDOM.nextInt(300));
			     this.miCola.colocarComidaArmario(this.miTipo);	  
			  } catch (Exception e) {			  
				  // Si paran el hilo, salimos
				  return;}
		}
		miCola.cocineroAcabaTurno();
		System.out.println("HILO PRODUCTOR FIN: El cocinero que hace hamburguesas ha acabado su turno");
	}	
	
	@Override
	public  void run() {
		if (this.miTipo.contains("P")) {
			HacerPizza();
		}else {
			HacerHamburguesa();
		}
				
	}

}
