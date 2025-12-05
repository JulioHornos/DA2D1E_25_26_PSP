package mispaquetes;

import java.io.Serializable;

public class Jugada implements Serializable{
	
	private int ganoTurno = 0; // 1 - gano, 0 empato, -1 pierdo
	private String nombre;
	private int miJugada = 0; // 1 - Piedra, 2 - Papel, 3 - Tijeras
	private int WClienteYo = 0, WClienteOtro = 0;
	
	public int getGanoTurno() {
		return ganoTurno;
	}
	
	public void setGanoTurno(int ganoTurno) {
		this.ganoTurno = ganoTurno;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getMiJugada() {
		return miJugada;
	}
	
	public void setMiJugada(int miJugada) {
		this.miJugada = miJugada;
	}
	
	public int getWClienteYo() {
		return WClienteYo;
	}
	
	public void setWClienteYo(int wClienteYo) {
		WClienteYo = wClienteYo;
	}
	
	public int getWClienteOtro() {
		return WClienteOtro;
	}
	
	public void setWClienteOtro(int wClienteOtro) {
		WClienteOtro = wClienteOtro;
	}	
	
}
