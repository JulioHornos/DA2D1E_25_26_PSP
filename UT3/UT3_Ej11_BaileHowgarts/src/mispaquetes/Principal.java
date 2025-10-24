package mispaquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String listaparejas[] = {"Harry Potter","Draco Malfoy", "Cedric Digory","Terry Boot"};
		//String listaCasas[] = {"Gryffindor","Slytherin", "Hufflepuff","Ravenclaw"};
		Integer listaCasas[] = {0,1,2,3};
		PistaBaile miPista = new PistaBaile(listaparejas,listaCasas);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		Bailarin Hermione = new Bailarin("Hermione Granger",1,listaparejas,miPista,0 );
		Bailarin Pansy = new Bailarin("Pansy Parkinson",0,listaparejas,miPista,1 );
		Bailarin Tamsin = new Bailarin("Tamsin Applebee",5,listaparejas,miPista,2 );
		Bailarin Luna = new Bailarin("Luna Lovewood",5,listaparejas,miPista,3 );

		executor.submit(Hermione);
		executor.submit(Pansy);
		executor.submit(Tamsin);
		executor.submit(Luna);	
		executor.submit(new DirectorBaile(miPista));
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1,TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***********************************");
		System.out.println("******El baile ha concluido********");
		System.out.println("***********************************");
		
	}
}

