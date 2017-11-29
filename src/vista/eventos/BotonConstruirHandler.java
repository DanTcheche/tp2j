package vista.eventos;

import caible.propiedades.barrios.Barrio;
import casilleros.Caible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import partida.Partida;
import vista.ContenedorPrincipal;

public class BotonConstruirHandler implements EventHandler<ActionEvent> {
	

    Stage stage;//no se usa?
    Partida partida;
	private ContenedorPrincipal contenedor;
    
    public BotonConstruirHandler(Stage stage, Partida partida, ContenedorPrincipal contenedorPrincipal) { 
        this.stage = stage;
        this.partida = partida;
        this.contenedor = contenedorPrincipal;
               
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	Caible barrioActual = partida.getCaibleActual();
    	partida.construirEn((Barrio) barrioActual);
    	contenedor.setPanelDerecha();

    }
}
