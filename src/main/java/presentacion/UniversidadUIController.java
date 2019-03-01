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
import negocio.CarreraBusiness;
import negocio.EstudianteBusiness;
import negocio.MateriaBusiness;
import persistencia.CarreraDao;
import persistencia.ConnectionManager;
import persistencia.EstudianteDao;
import persistencia.MateriaDao;

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
            CarreraUIController controller = fxmlLoader.getController();
            
            ConnectionManager connectionManager = new ConnectionManager();
            CarreraDao carreraDao = new CarreraDao(connectionManager);
            CarreraBusiness carreraBusiness = new CarreraBusiness(carreraDao);
            controller.setCarreraBusiness(carreraBusiness);
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
    		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentacion/MateriaUI.fxml"));  
             Parent root2 = (Parent) fxmlLoader.load();
             MateriaUIController controller = fxmlLoader.getController();
             //ID
             ConnectionManager connectionManager = new ConnectionManager();
             MateriaDao materiaDao = new MateriaDao(connectionManager);
             MateriaBusiness materiaBusiness = new MateriaBusiness(materiaDao);
             controller.setMateriaBusiness(materiaBusiness);
             
            
             Stage stage = new Stage();
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.setTitle("MATERIA");      
             stage.setResizable(false);
             stage.setScene(new Scene(root2));
             stage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }

}
