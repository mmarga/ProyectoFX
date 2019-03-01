package presentacion;



import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import negocio.MateriaBusiness;
import utl.MateriaDuplicadaException;
import utl.NegocioException;
import utl.NombreInvalidoException;


public class MateriaUIController {

    private MateriaBusiness materiaBusiness;
    
    public void setMateriaBusiness(MateriaBusiness materiaBusiness) {
        this.materiaBusiness = materiaBusiness;
    }

    @FXML
    private TextArea areaTextoResultados;

    @FXML
    private Button botonConsultarTodos;

    @FXML
    private Button botonConsutarPorId;

    @FXML
    private TextField campoId;

    @FXML
    void consutarPorId(ActionEvent event) {

    }

    @FXML
    void consutarTodos(ActionEvent event) {
    	
    	try {
			areaTextoResultados.setText(materiaBusiness.consultarTodos());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
 
}
