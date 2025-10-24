package mispaquetes;

import java.util.Random;

public class DirectorBaile implements Runnable {
	
	private PistaBaile miPista;
	
	public DirectorBaile(PistaBaile miPista) {		
		this.miPista = miPista;
	}
	
	private static final Random RANDOM = new Random();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// Calcular el número de iteraciones, de cambios de pareja que va a haber
        int cambiosPareja = RANDOM.nextInt(4, 8); // Entre 5 y 10 segundos
    	
		System.out.println("##### El baile va durar: "+cambiosPareja+" vueltas");
		
        
        for (int i= 0; i<cambiosPareja; i++) {        	   
            // En cada iteracción calculo cuando va durar esa vuelta, en decimas de segundo 
            long tiempoCambio = RANDOM.nextLong(30, 60); // Entre 3 y 6 segundos
            long tiempoLlevamos = 0;
            while (tiempoLlevamos<tiempoCambio*100) {
            	try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	tiempoLlevamos += 10;
            	if((tiempoLlevamos%1000)==0) {
            		System.out.println("+++++++Nananana, na, na,++++++++++++++++");
            	}
            }
            
            if(i < (cambiosPareja-1) ) miPista.setCambioPareja();    
        }
		
		// Acabadas las iteracciones, finalizamos el baile
        miPista.setFinBaile();
	}

}
