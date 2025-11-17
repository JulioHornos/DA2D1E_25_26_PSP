package mispaquetes;

import java.util.Arrays;
import java.util.Random;

public class ColaEntrega {
	 		
	private final static Random RANDOM = new Random();
	private int totalCocineros, cocinerosAcabanTurno=0;
	boolean pararCocina = false;
	String colaArmario[] = {"X","X","X","X","X"};

	
	
	public ColaEntrega(int totalCocineros) {
		this.totalCocineros = totalCocineros;
	}
	
	public boolean isColaArmarioLlena() {
		boolean retorno = true;
		
		for (int i=0; i<colaArmario.length; i++) {
			if (colaArmario[i].equals("X")) {
				retorno = false;
				break;
			}
		}		
		
		return retorno;
	}
	
	public boolean isPararCocina() {
		return pararCocina;
	}
	
	public boolean isColaArmarioVacia() {
		boolean retorno = true;
		
		for (int i=0; i<colaArmario.length; i++) {
			if (!colaArmario[i].equals("X")) {
				retorno = false;
				break;
			}
		}		
		
		return retorno;
	}
	
	public synchronized void colocarComidaArmario(String tipo) {
		while(this.isColaArmarioLlena()) {
			try {
				wait();
			} catch (InterruptedException e){}
		}
		
		for (int i=0; i<colaArmario.length; i++) {
			if (colaArmario[i].equals("X")) {
				colaArmario[i] = tipo;
				break;
			}
		}		
		
		if(tipo.equals("P")) {
			System.out.println("Pizza preparada para reparto. "+ Arrays.toString(colaArmario));					
		}else {
			System.out.println("Hamburguesa preparada para reparto."+ Arrays.toString(colaArmario));			
		}
		notifyAll();		
	}
	
	
	public synchronized String dameEntrega(String tipo, String nombre){
		while(this.isColaArmarioVacia()) {
			try {
				wait();
			} catch (InterruptedException e){}
		}
		
		String retorno = "X";
		
		// busco 1º hamburguesas
		for (int i=0; i<colaArmario.length; i++) {
			if (colaArmario[i].equals("H")) {
				colaArmario[i] = "X";
				notifyAll();
				return "H";
			}
		}		

		// busco 1º pizzas
		for (int i=0; i<colaArmario.length; i++) {
			if (colaArmario[i].equals("P")) {
				colaArmario[i] = "X";
				notifyAll();
				return "P";
			}
		}				
		
		return retorno;
	}
	
	public synchronized void cocineroAcabaTurno() {
		cocinerosAcabanTurno++;
	//	System.out.println("HAN ACABADO EL TURNO: "+repartidoresAcabanTurno);
		if(cocinerosAcabanTurno==this.totalCocineros) {
			//System.out.println("SE ACABA EL TURNO");
			pararCocina = true;
			notifyAll();
		}
		
	}

}
