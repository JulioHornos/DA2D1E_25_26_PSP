package mispaquetes;

public class Contador extends Thread{
		
	private Naufrago miNaufrago; 
	
	
	public  Contador(Naufrago miNaufrago) {	
		this.miNaufrago = miNaufrago;
		}
		
	public void contador() {
		try {
			int i = 0;
			while(this.miNaufrago.getCantidadNaufragos() > 0) {
				System.out.printf(i +" %n");
				this.sleep(1000);
				i++;
			}	
			return;
		}catch (InterruptedException e) {	
			return;		
		}														
	}
	
	
	@Override
	public void run() {
		this.contador();
	}
}	
