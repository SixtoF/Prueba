package unidad8;

import java.time.Month;

public class Congelado extends Fresco {

	private int temperaturaMant;

	public Congelado(String nombre, int anyoCaducidad, Month mesCaducidad, int diaCaducidad, int anyoEnvasado,
			Month mesEnvasado, int diaEnvasado, String paisOrigen, int temperaturaMant) {

		super(nombre, anyoCaducidad, mesCaducidad, diaCaducidad, anyoEnvasado, mesEnvasado, diaEnvasado, paisOrigen,
				temperaturaMant);
		this.temperaturaMant = temperaturaMant;
	}

	//getters y setters
	public int getTemperaturaMant() {
		return temperaturaMant;
	}

	public void setTemperaturaMant(int temperatura) {
		this.temperaturaMant = temperatura;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Temperatura:" + this.getTemperaturaMant();
	}
}
