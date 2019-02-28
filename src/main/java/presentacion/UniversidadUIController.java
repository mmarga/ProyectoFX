package presentacion;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UniversidadUIController {

    @FXML
    private Button botonAbrirEstudiante;

    @FXML
    private Button botonAbrirMaterias;

    @FXML
    private Button botonAbrirCarreras;

    @FXML
    void abrirVentanaCarreras(ActionEvent event) {
    	
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/presentacion/CarreraUI.fxml"));   
              /* 
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("CARRERA");                    
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }

    @FXML
    void abrirVentanaEstudiante(ActionEvent event) {
    	
      	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/presentacion/EstudianteUI.fxml"));   
              /* 
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("ESTUDIANTE");                    
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    void abrirVentanaMaterias(ActionEvent event) {
    	
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/presentacion/MateriaUI.fxml"));   
              /* 
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("MATERIA");                    
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }

}
