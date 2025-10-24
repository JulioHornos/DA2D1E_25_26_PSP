package mispaquetes;

public class Bailarin extends Thread{
	
	Integer PosicionBaileActual = -1, posicionAnterior = -1;
	String nombre;
	Integer casaIncompatible;
	String listaParejas[];
	PistaBaile miPista;
	Boolean tengoPareja=false;
	
	public Bailarin(String nombre, Integer casaIncompatible, String listaParejas[], PistaBaile miPista, Integer numeroCasa) {
		this.nombre=nombre;
		this.casaIncompatible=casaIncompatible;		
		this.listaParejas = listaParejas;
		this.miPista = miPista;
		this.posicionAnterior = numeroCasa;
		System.out.println(this.nombre+" empieza bailando con "+listaParejas[numeroCasa]);
	}
	
	public void baile() {
		int i = 0;
		// El baile dura hasta que se acaba
		while (!miPista.getFinBaile()) {
			if(miPista.getCambioPareja()) {
				if(!tengoPareja) {
					//Buscamos la pareja			
					PosicionBaileActual = this.miPista.getPareja(posicionAnterior, casaIncompatible);
					tengoPareja = true;
					posicionAnterior = PosicionBaileActual;
					if (PosicionBaileActual==-1) {
						System.out.println(this.nombre+" descansa esta vez");				
					}else {				
						System.out.println(this.nombre+" bailará con "+listaParejas[PosicionBaileActual]);				
					}														
				}					
			}else {
				if(tengoPareja) tengoPareja=false;
				i++;
				try {
					Thread.sleep(100);
					if(i%20==0) System.out.println("Soy "+this.nombre+" y estoy bailando con "+listaParejas[posicionAnterior]);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//if(i%10==0) System.out.println("Soy "+this.nombre+" y estoy bailando con "+listaParejas[PosicionBaileActual]);
			}
		}
		if (PosicionBaileActual!=-1) {
			System.out.println(this.nombre+ " y "+listaParejas[PosicionBaileActual]+" han acabado de bailar.");
		}
		
	}

	@Override
	public void run() {
		this.baile();
	}
}
