package mispaquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


final class Contador2 {
	private int c = 0;

	Contador2(int c) {
		this.c = c;
	}

	public void incrementa() {
		c++;
	}

	public void decrementa() {
		c--;
	}

	public int getValor() {
		return c;
	}

}// CONTADOR

class HiloA2 extends Thread {
	private Contador2 contador;

	public HiloA2(String n, Contador2 c) {
		setName(n);
		contador = c;
	}

	public void run() {
		
			for (int j = 0; j < 300; j++) {
				synchronized (contador) {
				contador.incrementa();}
				try {
					sleep(10);
				} catch (InterruptedException e) {		}
				
			}
			System.out.println(getName() + " contador vale "
					+ contador.getValor());
		}

	
}// HILOA

class HiloB2 extends Thread {
	private Contador2 contador;

	public HiloB2(String n, Contador2 c) {
		setName(n);
		contador = c;
	}

	public void run() {
		
			for (int j = 0; j < 300; j++) {
				synchronized (contador) {
				contador.decrementa();}
				try {
					sleep(10);
				} catch (InterruptedException e) {		}
				
			}
			System.out.println(getName() + " contador vale "
					+ contador.getValor());
		}
	
}// HILOB

public class Compartir {
	public static void main(String[] args) {
		Contador2 cont = new Contador2(100);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit(new HiloA2("HiloA", cont));
		executor.submit(new HiloB2("HiloB", cont));
		
		executor.shutdown();		    
	}
}