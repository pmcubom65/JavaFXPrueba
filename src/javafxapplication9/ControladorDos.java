/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.event.*;
import javafx.scene.shape.Sphere;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControladorDos implements Initializable {

    @FXML
    private Circle bola;

    @FXML
    private Label minombre;

    @FXML
    private Rectangle rectangulo;

    @FXML
    private Label resultado;

    int fuerza;
    int vertical;
    int horizontal;
    String nombre;
    double bolax;
    double bolay;
    
    
        @FXML
    private Button volverAtras;

    @FXML
    void vueltaAtras(ActionEvent event) throws IOException {
                 FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                Parent nuevoparent = loader.load();
                
                Scene nuevaescena = new Scene(nuevoparent, 1920, 1080);
                nuevaescena.getStylesheets().add(getClass().getResource("cascada.css").toExternalForm());
                
                FXMLDocumentController micontrolador = loader.getController();
               
                
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                window.setScene(nuevaescena);
                
                window.show();
        
    }


    public void incializarValores(String t, int v, int h) {

        nombre = t;
        vertical = v;
        horizontal = h;
        

        mover(horizontal, vertical);
        minombre.setText("Hola " + t);
    }

    public void mover(int h, int v) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(3), bola);

        tt.setToX(horizontal);

        tt.setToY(vertical);
        
            tt.setOnFinished(event -> {
                
                bolax=bola.getLayoutX()+bola.getTranslateX();
                bolay=bola.getLayoutY()+bola.getTranslateY();
                       double x = rectangulo.getLayoutX();
        double y = rectangulo.getLayoutY();
 

        resultado.setText(String.format("Te has quedado\n%f en x, %f en y", x - bolax, y - bolay));
            });


        tt.play();
        
        RotateTransition rotate=new RotateTransition(Duration.seconds(5), rectangulo);
        rotate.setToAngle(360);
        rotate.setRate(2);
        rotate.play();

     

    }
    
    

    // inicializar el proyecto haber
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resultado.setText("");
    }

}
