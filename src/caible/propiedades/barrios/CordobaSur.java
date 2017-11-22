package caible.propiedades.barrios;

public class CordobaSur extends BarrioNormal {

	public CordobaSur(String nombre, int precio, int posicion, int precioAlquiler,
			int precioAlquilerConUnaCasa, int precioAlquilerConDosCasas, int precioAlquilerConHotel,
			int precioConstruirCasa, int precioConstruirHotel) {
		super(nombre, precio, posicion, precioAlquiler, precioAlquilerConUnaCasa, precioAlquilerConDosCasas,
				precioAlquilerConHotel, precioConstruirCasa, precioConstruirHotel);
		this.duplaBarrioNormal = "Cordoba Norte";
	}

}
