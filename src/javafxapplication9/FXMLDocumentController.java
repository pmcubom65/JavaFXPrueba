/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;
// 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.*;

import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.event.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField t1;
    
    @FXML
    private CheckBox v;
    
    @FXML
    private CheckBox h;
    
    @FXML
    private Button miboton;
    
    @FXML
    private TextField fuerza;
    
    @FXML
    private Label mierror;
    
    @FXML
    public void siguientePantalla(ActionEvent event) throws IOException {
        int vertical = 0;
        int horizontal = 0;
        int fsalida = 0;
        
        if (v.isSelected() || h.isSelected()) {
            System.out.println("aqui");
            if (!fuerza.getText().isEmpty()) {
                vertical = (v.isSelected()) ? Integer.parseInt(fuerza.getText()) : 0;
                horizontal = (h.isSelected()) ? Integer.parseInt(fuerza.getText()) : 0;
                System.out.println("aqui");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXMLSegundo.fxml"));
                Parent nuevoparent = loader.load();
                
                Scene nuevaescena = new Scene(nuevoparent, 1920, 1080);
                nuevaescena.getStylesheets().add(getClass().getResource("cascada.css").toExternalForm());
                
                ControladorDos micontrolador = loader.getController();
                
                micontrolador.incializarValores(t1.getText().toString(), horizontal, vertical);
                
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                window.setScene(nuevaescena);
                
                window.show();
            } else {
                mierror.setText("Campos vacios");
                mierror.setVisible(true);
                
            }
        } else {
            
            errores();
            
        }
        
    }
    
    public void errores() {
        mierror.setText("Campos vacios");
        mierror.setTextFill(Color.RED);
        mierror.setUnderline(true);
        mierror.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        t1.setText("");
        
    }
    
}
