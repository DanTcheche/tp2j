package vista;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import movimiento.Dado;
import movimiento.Tirador;
import vista.eventos.BotonTirarDadosEventHandler;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    VBox contenedorCentral;
    Tirador tirador;

    public ContenedorPrincipal(Stage stage) {
    	
    	Dado dado = new Dado(6);
    	this.tirador = new Tirador(dado,dado);
    	
    	
    	
        this.setMenu(stage);
//        this.setCentro(robot);
        this.setConsola();
        this.setBotonera(stage);
    }

    private void setBotonera(Stage stage) {

        Button botonTirar = new Button();
        botonTirar.setText("Tirar Dados");
        BotonTirarDadosEventHandler throwButtonHandler = new BotonTirarDadosEventHandler(stage, this.tirador);
        botonTirar.setOnAction(throwButtonHandler);

//        Button botonDireccion = new Button();
  //      botonDireccion.setText("Cambiar direccion");
    //    BotonDireccionHandler directionButtonHandler = new BotonDireccionHandler(robot);
      //  botonDireccion.setOnAction(directionButtonHandler);

        VBox contenedorVertical = new VBox( botonTirar);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

//    private void setCentro(Robot robot) {
//
//        canvasCentral = new Canvas(460, 220);
//        vistaRobot = new VistaRobot(robot, canvasCentral);
//        vistaRobot.dibujar();
//
//        contenedorCentral = new VBox(canvasCentral);
//        contenedorCentral.setAlignment(Pos.CENTER);
//        contenedorCentral.setSpacing(20);
//        contenedorCentral.setPadding(new Insets(25));
//        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
//        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//        contenedorCentral.setBackground(new Background(imagenDeFondo));
//
//        this.setCenter(contenedorCentral);
//    }

    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}
