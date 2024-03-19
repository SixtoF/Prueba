package unidad8;

import java.time.LocalDate;
import java.time.Month;

public class Producto {

	private String nombre;
	private LocalDate fechaCaducidad;
	private int numeroLote;
	private static int codigoLote = 1;

	LocalDate fechaInicio = LocalDate.of(2024, Month.MARCH, 1);
	LocalDate fechaFin = LocalDate.of(2026, Month.MARCH, 1);

	// constructor
	public Producto(String nombre, LocalDate fechaCaducidad) {
		this.setNombre(nombre);
		this.setFechaCaducidad(fechaCaducidad);
		this.numeroLote = codigoLote;
		codigoLote++;
	}

	// getters
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	// setters
	public void setNombre(String nombre) throws ArithmeticException{
		if (nombre.length() > 3) {
			this.nombre = nombre;
		} else {
			throw new ArithmeticException("Error tiene que tener 3 caracteres como minimo");
		}

	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) throws ArrayIndexOutOfBoundsException{
		if (fechaCaducidad.isAfter(fechaInicio) && fechaCaducidad.isBefore(fechaFin)) {
			this.fechaCaducidad = fechaCaducidad;
		} else {
			throw new ArrayIndexOutOfBoundsException("Error la fecha de caducidad es incorrecta");
		}
	}


	@Override
	public boolean equals(Object obj) {
		boolean igual = true;
		// Verificar si el objeto pasado es una instancia de Producto
		if (obj instanceof Producto) {
			//realizamos un cast para convertirlo en un objeto Producto
			Producto pro = (Producto) obj;
			//si el nombre de este producto es nulo
			if (this.nombre == null) {
				//Si es nulo, verificamos si el nombre del otro producto también es nulo
				if (pro.getNombre() != null) {
					// Si el nombre del otro producto no es nulo, los productos no son iguales
					igual = false;
				}
				// Si los nombres son diferentes, los objetos no son iguales
			} else if (!this.nombre.equals(pro.getNombre())) {
				igual = false;
			}
		}

		return igual;
	}
	
	@Override
	public String toString() {
		return "El nombre del Producto es:" + this.getNombre() + " Fecha de Caducidad:" + this.getFechaCaducidad()
		+ " Numero de Lote:" + this.getNumeroLote();
	}


}
