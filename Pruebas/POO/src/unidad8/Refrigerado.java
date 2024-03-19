package unidad8;

import java.time.Month;

public class Refrigerado extends Fresco {

	private int codigoSupAli;
	private static int codigo = 1;;
	private int temperaturaMant;

	public Refrigerado(String nombre, int anyoCaducidad, Month mesCaducidad, int diaCaducidad, int anyoEnvasado,
			Month mesEnvasado, int diaEnvasado, int temperaturaMant, String paisOrigen) {

		super(nombre, anyoCaducidad, mesCaducidad, diaCaducidad, anyoEnvasado, mesEnvasado, diaEnvasado,
				temperaturaMant, paisOrigen);
		this.codigoSupAli = codigo;
		codigo++;
		this.temperaturaMant = temperaturaMant;
	}

	//getters
	public int getCodigoSupAli() {
		return codigoSupAli;
	}

	public int getTemperaturaMant() {
		return temperaturaMant;
	}

	//setter
	public void setTemperaturaMant(int temperatura) {
		this.temperaturaMant = temperatura;
	}
	@Override
	public String toString() {
		return super.toString() + " Codigo Alimentacion:" + this.getCodigoSupAli() + " Temperatura:"
				+ this.getTemperaturaMant();
	}

}
