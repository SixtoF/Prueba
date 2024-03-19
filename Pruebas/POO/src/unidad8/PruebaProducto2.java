package unidad8;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaProducto2 {

	public static void main(String[] args) {

		ArrayList<Producto> productos = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		int opcion = 0, agregar = 0, ver = 0, modificar = 0, posicionBorrado = 0;
		String nombre = "", pais = "";
		int anyoCaducidad = 0, diaCaducidad = 0, anyoEnvasado = 0, diaEnvasado = 0, mesCad = 0, mesEnv = 0;
		Month mesCaducidad, mesEnvasado;

//		Fresco fresco = new Fresco("Manzana", 2024, Month.DECEMBER, 10, 2024, Month.APRIL, 3, "Marruecos");
//		Fresco fresco1 = null;
//		Fresco fresco2 = new Fresco("Aguacate", 2024, Month.DECEMBER, 10, 2024, Month.APRIL, 3, "Ecuador");
//		Refrigerado refrigerado = new Refrigerado("Yogur", 2025, Month.APRIL, 1, 2024, Month.AUGUST, 3, 0, "España");
//		Refrigerado refrigerado1 = null;
//		Congelado congelado = new Congelado("Salmon", 2025, Month.DECEMBER, 6, 2024, Month.JUNE, 12, "Noruega", -3);
//		Congelado congelado1 = null;
		productos.add(new Fresco("Manzana", 2024, Month.DECEMBER, 10, 2024, Month.APRIL, 3, "Marruecos"));
		productos.add(new Fresco("Aguacate", 2024, Month.DECEMBER, 10, 2024, Month.APRIL, 3, "Ecuador"));
		productos.add(new Refrigerado("Yogur", 2025, Month.APRIL, 1, 2024, Month.AUGUST, 3, 0, "España"));
		productos.add(new Congelado("Salmon", 2025, Month.DECEMBER, 6, 2024, Month.JUNE, 12, "Noruega", -3));

		do {
			System.out.println("\n1. Añadir productos ");
			System.out.println("2. Mostrar todos los productos ");
			System.out.println("3. Mostrar productos por separado ");
			System.out.println("4. Modificar un producto existente ");
			System.out.println("5. Borrar producto ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("1. FRESCO");
				System.out.println("2. REFRIGERADO");
				System.out.println("3. CONGELADO");
				agregar = entrada.nextInt();
				switch (agregar) {
				case 1:
					añadirProductoFresco(productos, entrada);
					break;
				case 2:
					añadirProductoRefrigerado(productos, entrada);
					break;
				case 3:
					añadirProductoCongelado(productos, entrada);
					break;
				}
				break;
			case 2:
				System.out.println("Los productos son:");
				for (int i = 0; i < productos.size(); i++) {
					System.out.println(productos.get(i));
				}
				break;
			case 3:
				System.out.println("1. FRESCO");
				System.out.println("2. REFRIGERADO");
				System.out.println("3. CONGELADO");
				ver = entrada.nextInt();
				switch (ver) {
				case 1:
					System.out.println("Los Productos Frescos son:");
					for (Producto producto : productos) {
						comprobarInstanciaFresco(producto);
					}
//					comprobarInstanciaFresco(fresco);
//					comprobarInstanciaFresco(fresco1);
//					comprobarInstanciaFresco(fresco2);

					break;
				case 2:
					System.out.println("Los Productos Refrigerados son:");
					for (Producto producto : productos) {
						comprobarInstanciaRefrigerado(producto);
					}
//					comprobarInstanciaRefrigerado(refrigerado);
//					comprobarInstanciaRefrigerado(refrigerado1);
					;
					break;
				case 3:
					System.out.println("Los Productos Congelados son:");
					for (int i = 0; i < productos.size(); i++) {
						comprobarInstanciaCongelado(productos.get(i));
					}
//					comprobarInstanciaCongelado(congelado);
//					comprobarInstanciaCongelado(congelado1);
					break;
				}
				break;
			case 4:
				System.out.println("Los productos son los siguientes:");
				for (int i = 0; i < productos.size(); i++) {
					System.out.println("La posicion:" + i + " / " + productos.get(i).getNombre());
				}
				System.out.println("******************************");
				System.out.println("Elige el producto a modificar:");
				modificar = entrada.nextInt();

				entrada.nextLine();
				System.out.println("Dime el nombre");
				nombre = entrada.nextLine();
				System.out.println("Dime año de caducidad");
				anyoCaducidad = entrada.nextInt();
				System.out.println("Dime mes de caducidad");
				mesCad = entrada.nextInt();
				mesCaducidad = Month.of(mesCad);
				System.out.println("Dime dia de caducidad");
				diaCaducidad = entrada.nextInt();
				System.out.println("Dime año de envasado");
				anyoEnvasado = entrada.nextInt();
				System.out.println("Dime mes de envasado");
				mesEnv = entrada.nextInt();
				mesEnvasado = Month.of(mesEnv);
				System.out.println("Dime dia de envasado");
				diaEnvasado = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Pais de origen");
				pais = entrada.nextLine();
				productos.get(modificar).setNombre(nombre);
				productos.get(modificar).setFechaCaducidad(LocalDate.of(anyoCaducidad, mesCaducidad, diaCaducidad));
				// realizo un castin ya que heredan de fresco estos atributos
				((Fresco) (productos.get(modificar))).setEnvasado(LocalDate.of(anyoEnvasado, mesEnvasado, diaEnvasado));
				((Fresco) (productos.get(modificar))).setPaisOrigen(pais);
//				((Fresco)(productos.get(modificar))).setNombre(nombre);
				break;
			case 5:
				System.out.println("Los productos son los siguientes:");
				for (int i = 0; i < productos.size(); i++) {
					System.out.println("La posicion:" + i + " / " + productos.get(i).getNombre());
				}
				System.out.println("Dime la Posicion del Producto que quieres borrar");
				posicionBorrado = entrada.nextInt();
				productos.remove(posicionBorrado);
				break;
			}
		} while (opcion != 6);
		entrada.close();
	}

	private static void añadirProductoCongelado(ArrayList<Producto> productos, Scanner entrada) {
		Congelado congelado1;
		int repetir;
		String nombre;
		String pais;
		int anyoCaducidad;
		int diaCaducidad;
		int anyoEnvasado;
		int diaEnvasado;
		int temperatura;
		int mesCad;
		int mesEnv;
		Month mesCaducidad;
		Month mesEnvasado;
		do {
			entrada.nextLine();
			System.out.println("Dime el nombre");
			nombre = entrada.nextLine();
			System.out.println("Dime año de caducidad");
			anyoCaducidad = entrada.nextInt();
			System.out.println("Dime mes de caducidad");
			mesCad = entrada.nextInt();
			mesCaducidad = Month.of(mesCad);
			System.out.println("Dime dia de caducidad");
			diaCaducidad = entrada.nextInt();
			System.out.println("Dime año de envasado");
			anyoEnvasado = entrada.nextInt();
			System.out.println("Dime mes de envasado");
			mesEnv = entrada.nextInt();
			mesEnvasado = Month.of(mesEnv);
			System.out.println("Dime dia de envasado");
			diaEnvasado = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Pais de origen");
			pais = entrada.nextLine();
			System.out.println("Dime temperatura de mantenimiento");
			temperatura = entrada.nextInt();
			try {
				congelado1 = new Congelado(nombre, anyoCaducidad, mesCaducidad, diaCaducidad, anyoEnvasado, mesEnvasado,
						diaEnvasado, pais, temperatura);
				if (!productos.contains(congelado1)) {
					productos.add(congelado1);
				} else {
					System.out.println("El producto ya existe, no puedes sobreescribir el mismo producto");
				}
			} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Quieres volver ha introducir los datos?" + "\nPulsa 1.Para Si" + "\nPulsa 2.Para No");
			repetir = entrada.nextInt();
		} while (repetir != 2);

	}

	private static void añadirProductoRefrigerado(ArrayList<Producto> productos, Scanner entrada) {
		Refrigerado refrigerado1;
		int repetir;
		String nombre;
		String pais;
		int anyoCaducidad;
		int diaCaducidad;
		int anyoEnvasado;
		int diaEnvasado;
		int temperatura;
		int mesCad;
		int mesEnv;
		Month mesCaducidad;
		Month mesEnvasado;
		do {
			entrada.nextLine();
			System.out.println("Dime el nombre");
			nombre = entrada.nextLine();
			System.out.println("Dime año de caducidad");
			anyoCaducidad = entrada.nextInt();
			System.out.println("Dime mes de caducidad");
			mesCad = entrada.nextInt();
			mesCaducidad = Month.of(mesCad);
			System.out.println("Dime dia de caducidad");
			diaCaducidad = entrada.nextInt();
			System.out.println("Dime año de envasado");
			anyoEnvasado = entrada.nextInt();
			System.out.println("Dime mes de envasado");
			mesEnv = entrada.nextInt();
			mesEnvasado = Month.of(mesEnv);
			System.out.println("Dime dia de envasado");
			diaEnvasado = entrada.nextInt();
			System.out.println("Dime temperatura de mantenimiento");
			temperatura = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Pais de origen");
			pais = entrada.nextLine();
			try {
				refrigerado1 = new Refrigerado(nombre, anyoCaducidad, mesCaducidad, diaCaducidad, anyoEnvasado,
						mesEnvasado, diaEnvasado, temperatura, pais);
				if (!productos.contains(refrigerado1)) {
					productos.add(refrigerado1);
				} else {
					System.out.println("El producto ya existe, no puedes sobreescribir el mismo producto");
				}
			} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Quieres volver ha introducir los datos?" + "\nPulsa 1.Para Si" + "\nPulsa 2.Para No");
			repetir = entrada.nextInt();
		} while (repetir != 2);

	}

	private static void añadirProductoFresco(ArrayList<Producto> productos, Scanner entrada) {
		Fresco fresco1;
		int repetir;
		String nombre;
		String pais;
		int anyoCaducidad;
		int diaCaducidad;
		int anyoEnvasado;
		int diaEnvasado;
		int mesCad;
		int mesEnv;
		Month mesCaducidad;
		Month mesEnvasado;
		do {
			entrada.nextLine();
			System.out.println("Dime el nombre");
			nombre = entrada.nextLine();
			System.out.println("Dime año de caducidad");
			anyoCaducidad = entrada.nextInt();
			System.out.println("Dime mes de caducidad");
			mesCad = entrada.nextInt();
			mesCaducidad = Month.of(mesCad);
			System.out.println("Dime dia de caducidad");
			diaCaducidad = entrada.nextInt();
			System.out.println("Dime año de envasado");
			anyoEnvasado = entrada.nextInt();
			System.out.println("Dime mes de envasado");
			mesEnv = entrada.nextInt();
			mesEnvasado = Month.of(mesEnv);
			System.out.println("Dime dia de envasado");
			diaEnvasado = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Pais de origen");
			pais = entrada.nextLine();
			try {
				fresco1 = new Fresco(nombre, anyoCaducidad, mesCaducidad, diaCaducidad, anyoEnvasado, mesEnvasado,
						diaEnvasado, pais);
				if (!productos.contains(fresco1)) {
					productos.add(fresco1);
				} else {
					System.out.println("El producto ya existe, no puedes sobreescribir el mismo producto");
				}
			} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Quieres volver ha introducir los datos?" + "\nPulsa 1.Para Si" + "\nPulsa 2.Para No");
			repetir = entrada.nextInt();
		} while (repetir != 2);
	}

	// Comprobacion Instancias
	public static void comprobarInstanciaFresco(Producto m2) {
		if (m2 instanceof Fresco && !(m2 instanceof Refrigerado) && !(m2 instanceof Congelado)) {
			System.out.println(m2.toString());
		}
	}

	public static void comprobarInstanciaRefrigerado(Producto m2) {
		if (m2 instanceof Refrigerado) {
			System.out.println(m2.toString());
		}
	}

	public static void comprobarInstanciaCongelado(Producto m2) {
		if (m2 instanceof Congelado) {
			System.out.println(m2.toString());
		}
	}
}
