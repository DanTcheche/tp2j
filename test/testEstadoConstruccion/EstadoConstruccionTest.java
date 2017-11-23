package testEstadoConstruccion;
import estadoConstruccion.EstadoConstruccion;
import estadoConstruccion.EstadoSinConstruccion;
import caible.propiedades.barrios.BarrioNormal;
import caible.propiedades.barrios.BuenosAiresSur;
import org.junit.Assert;
import org.junit.Test;

public class EstadoConstruccionTest {
	BarrioNormal BairesSur=new BuenosAiresSur("Buenos Aires Sur", 20000, 2, 2000, 3000, 3500, 5000, 5000,
			8000);
	EstadoSinConstruccion estado=new EstadoSinConstruccion(BairesSur);
	
	@Test
	public void unEstadoSinConstruccionDevuelveElAlquilerSinNingunaConstruccionDeLaPropiedad() {
		
		Assert.assertEquals(2000,BairesSur.getPrecioRentaActual(),0.1);/*** ESTE FALLA***/
		//*Assert.assertEquals(2000,estado.getCostoRenta());*///
	}
}
