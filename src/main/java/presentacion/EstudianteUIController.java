package presentacion;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.EstudianteBusiness;

public class EstudianteUIController {
	
	private EstudianteBusiness estudianteBusiness;		

    public void setEstudianteBusiness(EstudianteBusiness estudianteBusiness) {
    	this.estudianteBusiness = estudianteBusiness;
	}

	@FXML
    private Button botonConsultarTodos;

    @FXML
    private Button botonConsutarPorId;

    @FXML
    private TextField campoId;
    

    @FXML
    private TextArea areaTextoResultados;

    @FXML
    public void consutarPorId(ActionEvent event) throws SQLException {
    	
    	

    }

    @FXML
    public void consutarTodos(ActionEvent event) throws SQLException {
    	
    	
    	areaTextoResultados.setText(estudianteBusiness.consultarTodos());

    }

}
