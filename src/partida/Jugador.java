package partida;
import java.util.LinkedList;

import caible.propiedades.Propiedad;
import casilleros.Caible;
import listaDePremios.IteradorListaPremios;
import listaDePremios.ListaDePremios;
import movimiento.MeMuevo;
public class Jugador {
	
	private MeMuevo movimiento;

	private int posicion;

	private Caible casilleroActual;

	
	int efectivoDisponible;
	LinkedList<Propiedad> listaDePropiedades;
	ListaDePremios premiosQuini;
	IteradorListaPremios premioQuiniAGanar;
	
	int numeroTotalSacadoEnDados; //(Auxiliar para los tests de esta entrega.)
	
	public Jugador(int efectivoInicial, MeMuevo movimientoNormal) {
		
		this.posicion = 0;
		this.movimiento = movimientoNormal;
		this.efectivoDisponible=efectivoInicial;
		this.listaDePropiedades=new LinkedList<Propiedad>();
		this.premiosQuini=new ListaDePremios();
		this.premiosQuini.agregarNodoConPremio(50000);
		this.premiosQuini.agregarNodoConPremio(30000);
		this.premiosQuini.agregarNodoConPremio(0);
		this.premiosQuini.cerrarLista();
		this.premioQuiniAGanar=new IteradorListaPremios(premiosQuini);
	}
	
	public int getEfectivo() {
		// TODO Auto-generated method stub
		return efectivoDisponible;
	}
	
	public void retrocederCasillero() {
		this.posicion-=1;	
		
	}

	public void avanzar(int cantidad) {
		this.movimiento.mover(this, cantidad);
	}
	
	public void nuevoMovimiento(MeMuevo  nuevoMovimiento) {
		this.movimiento = nuevoMovimiento;
		
	}
	
	public void avanzarCasillero() {
		this.posicion+=1;		
	}

	public int getNumeroTotalSacadoEnDados() {
		return numeroTotalSacadoEnDados;
	}

	public int cantidadDePropiedadesASuNombre() {
		// Tanto los terrenos como las casas como los hoteles suman como propiedad. 
		return 0;
	}
	
	public void reducirEfectivo(int efectivoAReducir) {
		this.efectivoDisponible-=efectivoAReducir;
	}
	
	public void aumentarEfectivo(int efectivoAAumentar) {
		this.efectivoDisponible+=efectivoAAumentar;
	}

	public void agregarPropiedad(Propiedad propiedadComprada) {
		this.listaDePropiedades.add(propiedadComprada);
	}
	
	public boolean contienePropiedad(Propiedad propiedadABuscar) {
		int esta=this.listaDePropiedades.indexOf(propiedadABuscar);
		if(esta!=-1) {return true;}
		return false;
	}
	
	public void cobrarPremioDelQuini() {
		int premioACobrar=this.premioQuiniAGanar.obtenerPremio();
		this.aumentarEfectivo(premioACobrar);
		this.premioQuiniAGanar.avanzar();
	}

	public void setPosicion(int nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public int getPosicion() {
		return this.posicion;
	}

	public boolean montoMenorA(int monto) {
		return (this.efectivoDisponible < monto);
	}
	public void setNumeroTotalSacadoEnDados(int numero) {
		numeroTotalSacadoEnDados = numero;
	}
}
