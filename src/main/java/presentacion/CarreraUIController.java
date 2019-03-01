package presentacion;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.CarreraBusiness;
import negocio.EstudianteBusiness;

public class CarreraUIController {
	
	private CarreraBusiness carreraBusiness;
	
	 public void setCarreraBusiness(CarreraBusiness carreraBusiness) {
		this.carreraBusiness = carreraBusiness;
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
    void consutarPorId(ActionEvent event) throws SQLException {
    	
    	Integer id = Integer.parseInt(campoId.getText());
    	String resultado = carreraBusiness.ConsultarPorId(id);
    	areaTextoResultados.setText(resultado);

    }

    @FXML
    void consutarTodos(ActionEvent event) {
    	
    	try {
			areaTextoResultados.setText(carreraBusiness.consultarTodos());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
