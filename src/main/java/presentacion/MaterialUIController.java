package presentacion;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import negocio.MateriaBusiness;
import utl.MateriaDuplicadaException;
import utl.NegocioException;
import utl.NombreInvalidoException;


public class MaterialUIController {

    private MateriaBusiness materiaBusiness;
    
    public void setMateriaBusiness(MateriaBusiness materiaBusiness) {
        this.materiaBusiness = materiaBusiness;
    }

    @FXML
    private Button botonGrabar;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoCargaHoraria;
    @FXML
    private Button botonResetear;


    @FXML
    private Button botonNuevaVentana;

    @FXML 
    public void grabarMateria(ActionEvent event) {
    	String nombre = campoNombre.getText();
    	
    	//validación de nombre
    	try {
    	if (nombre == null || nombre.trim().isEmpty()) {
			throw new NombreInvalidoException("Nombre inválido");
		}
    	
    	//VALIDACIÓN carga horaria no nula y entero
     	Integer cargaHoraria = null;
    	
		cargaHoraria = Integer.valueOf(campoCargaHoraria.getText());
		materiaBusiness.crearMateria(nombre, cargaHoraria);
		} catch (NumberFormatException nfe) {	
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("La carga horaria tiene que ser expresada en enteros");
			alert.showAndWait();
		} catch (NombreInvalidoException e) {	
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("El nombre no puede ser nulla");
			alert.showAndWait();
		} catch (MateriaDuplicadaException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("La materia está duplicada");
			alert.showAndWait();
		} 
    	
    	catch (NegocioException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("No fue posible guardar la materia, intente más tarde");
			alert.showAndWait();
		}
    
    }
    
    @FXML
    public void resetear(ActionEvent event) {
    	
    	campoNombre.setText("");
    	campoCargaHoraria.setText("");

    }
    
    ///pruebas
    
   @FXML
    public void nuevaVentana(ActionEvent event) {
    	
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/presentacion/EstudiantesUI.fxml"));   
              /* 
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New Window");
                    
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }
    
 
}
