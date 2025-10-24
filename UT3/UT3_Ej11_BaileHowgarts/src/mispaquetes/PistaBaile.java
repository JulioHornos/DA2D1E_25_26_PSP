package mispaquetes;

public class PistaBaile {
	
	private Boolean parejaLibre[] = {true, true, true, true};
	private String parejasBaile[];
	private Integer parejasCasas[];
	private Boolean finBaile = false, cambioPareja= false; 
	private Integer parejasCambianBaile = 0;
	
	public PistaBaile(String parejasBaile[], Integer parejasCasas[]) {
		this.parejasBaile = parejasBaile;
		this.parejasCasas = parejasCasas;
	}

	public synchronized void liberarPareja(int posicion) {
		this.parejaLibre[posicion] = true;
	}
	
	public void setCambioPareja() {
		System.out.println("====================================");
		System.out.println("=======Cambio de Pareja=============");
		System.out.println("====================================");
		for (int i= 0; i< parejaLibre.length; i++) {
			parejaLibre[i]=true;			
		}
		cambioPareja = true;
	}
	
	public void setFinBaile() {		
		finBaile = true;
	}
	
	public boolean getFinBaile() {
		return finBaile;
	}
	
	public boolean getCambioPareja() {
		return cambioPareja;
	}
	
	public boolean getParejasLibres() {
		for (int i= 0; i< parejaLibre.length; i++) {
			if(!parejaLibre[i])
				System.out.println("no está libre la pareja "+i);
				return false;
		}
		
		System.out.println("todas las parejas están libres ");
		return true;
	}
	
	public synchronized Integer getPareja(int posAnterior, Integer CasaIncompatible) {
		
		Boolean posicionDistintaAnterior = false, casaCompatible=true;
		Integer posicion = posAnterior;
		Integer posicionValida = -1;
		parejasCambianBaile++;	
        if(parejasCambianBaile==4) {        	
        	cambioPareja = false;
        	parejasCambianBaile=0;        	        
        }
		
		// Damos 4 vueltas que corresponden con las 4 posibles parejas, la anterior no vale
		// puede que la ultima vez no bailara, en ese caso empezamos por 0 y mantenemos en 
		// posición anterior el -1		
		for(int i= 0; i < 4; i++) {
			// en cada vuelta inicializamos estas variables
			posicionDistintaAnterior = false; 
			casaCompatible=false;
			posicionValida = -1;
			// si estamos al final del array, vamos al 0, sino sumamos uno a la ultima posición
           if (posicion == (this.parejasBaile.length - 1)) {
        	   posicion = 0;
           }else {
        	   posicion++;
           }
                              
           // Lo primero es asegurarnos de que no bailamos con el mismo que la última vez
           if (posicion!=posAnterior){
        	   // 2º: que la casa es compatible
        	   if (this.parejasCasas[posicion]!=CasaIncompatible){
            	   // Miramos si el baliarín está libre
            	   if (this.parejaLibre[posicion]) {
                	   posicionValida = posicion;
                	   this.parejaLibre[posicion] = false;
                	   break;        		   
            	   }        	           		  
        	   }
           }                                                  
        } ;		 
        
		return posicionValida;
	}
}
