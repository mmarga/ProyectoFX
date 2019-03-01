package presentacion;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import negocio.EstudianteBusiness;
import persistencia.ConnectionManager;
import persistencia.EstudianteDao;

public class UniversidadUIController {

    @FXML
    private Button botonAbrirEstudiante;

    @FXML
    private Button botonAbrirMaterias;

    @FXML
    private Button botonAbrirCarreras;

    @FXML
    void abrirVentanaCarreras(ActionEvent event) throws IOException {    	     
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentacion/CarreraUI.fxml"));  
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CARRERA");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    void abrirVentanaEstudiante(ActionEvent event) {    	
      	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentacion/EstudianteUI.fxml"));  
            Parent root2 = (Parent) fxmlLoader.load();
            EstudianteUIController controller = fxmlLoader.getController();
            //ID
            ConnectionManager connectionManager = new ConnectionManager();
            EstudianteDao estudianteDao = new EstudianteDao(connectionManager);
            EstudianteBusiness estudianteBusiness = new EstudianteBusiness(estudianteDao);            
            controller.setEstudianteBusiness(estudianteBusiness);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("ESTUDIANTE");      
            stage.setResizable(false);
            stage.setScene(new Scene(root2));
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
