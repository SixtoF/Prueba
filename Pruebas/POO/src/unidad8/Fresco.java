package unidad8;

import java.time.LocalDate;
import java.time.Month;

public class Fresco extends Producto{

	private LocalDate fechaEnvasado;
	private String paisOrigen;
	
	
	//constructor
	public Fresco(String nombre, int anyoCaducidad,Month mesCaducidad,int diaCaducidad,
			int anyoEnvasado,Month mesEnvasado,int diaEnvadado, String paisOrigen) {
		
		super(nombre, LocalDate.of(anyoCaducidad, mesCaducidad, diaCaducidad));
		this.fechaEnvasado = LocalDate.of(anyoEnvasado, mesEnvasado, diaEnvadado); 
		this.paisOrigen = paisOrigen;
	}
	
	public Fresco(String nombre, int anyoCaducidad,Month mesCaducidad,int diaCaducidad,
			int anyoEnvasado,Month mesEnvasado,int diaEnvadado,int temperatura, String paisOrigen) {
		
		super(nombre, LocalDate.of(anyoCaducidad, mesCaducidad, diaCaducidad));
		this.fechaEnvasado = LocalDate.of(anyoEnvasado, mesEnvasado, diaEnvadado); 
		this.paisOrigen = paisOrigen;
	}
	
	public Fresco(String nombre, int anyoCaducidad,Month mesCaducidad,int diaCaducidad,
			int anyoEnvasado,Month mesEnvasado,int diaEnvadado, String paisOrigen,int temperatura) {
		
		super(nombre, LocalDate.of(anyoCaducidad, mesCaducidad, diaCaducidad));
		this.fechaEnvasado = LocalDate.of(anyoEnvasado, mesEnvasado, diaEnvadado); 
		this.paisOrigen = paisOrigen;
	}
	//getters
	public LocalDate getEnvasado() {
		return fechaEnvasado;
	}
	
	public String getPaisOrigen() {
		return paisOrigen;
	}
	
	//setters
	public void setEnvasado(LocalDate envasado) {
		this.fechaEnvasado = envasado;
	}
	
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Fecha envasado:" + this.getEnvasado() + " Pais de Origen:" + this.getPaisOrigen();
	}
	
	public String imprimirSaludo() {
		return "Hola esto es un cambio";
	}
	
	public String cambioDos() {
		return "Cambio numero dos";
	}
}
