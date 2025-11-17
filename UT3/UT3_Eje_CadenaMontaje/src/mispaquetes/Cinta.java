package mispaquetes;

import java.util.Arrays;

public class Cinta {
	
	private int [] cadena  = {0,0,0}; 
	private int huecoslibres = 3, totalpuestos = 0;
	private int [] recogidos  = {0,0,0};
	private boolean simulacionMarcha = true;	
	
	public Cinta() {		
	}
	
	public int getTotalPuestos() {
		return totalpuestos;
	}
	
	public int[] getRecogidos() {
		return recogidos;
	}
	
	public int[] getCadena() {
		return cadena;
	}
	
	public void setSimulaciónMarcha() {
		simulacionMarcha = false;
	}
	
	public boolean isSimulaciónMarcha() {
		return simulacionMarcha;
	}
	
	public int getHuecosLibres() {
		return huecoslibres;
	}
	
	public synchronized void despiertaHilos() {
		notifyAll();
	}
	
	public synchronized Integer setcadena(int tipo){
		int i;
		while (this.huecoslibres==0) {
			try {
				wait();
			} catch (InterruptedException e){}
		}
			for(i=0; i<3;i++ ) {
				if (cadena[i]==0) {
					cadena[i] = tipo;
					System.out.println("Coloco un producto "+ tipo + " en la posición "+ i +"\n"+ Arrays.toString(this.cadena));		    
					huecoslibres = huecoslibres-1;
					totalpuestos = totalpuestos+1;
					notifyAll();
					break;
				}		
			}
			return 1;
	}


	public synchronized Integer getcadena(int tipo, int tiempo){
		int i;
		if(huecoslibres == 3&&simulacionMarcha) {
			try {
				wait();
			} catch (InterruptedException e){}
		}
		for(i=0; i<3;i++ )  {
			if (tipo==cadena[i]) {
				cadena[i] = 0; // dejamos libre el hueco
				huecoslibres = huecoslibres+1;
				recogidos[tipo-1] = recogidos[tipo-1]+1; 
				System.out.println("Recogido producto "+ tipo);	
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					return 0;
				}
				notifyAll();
				return 1;
			}
		}
		// si estoy aquí es que de mi tipo no hay
		return 0;
	}
}
