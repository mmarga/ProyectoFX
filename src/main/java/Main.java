import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import negocio.EstudianteBusiness;
import negocio.MateriaBusiness;
import persistencia.ConnectionManager;
import persistencia.DaoSupport;
import persistencia.EstudianteDao;
import persistencia.MateriaDao;
import presentacion.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dominio.Estudiante;
import dominio.Materia;

public class Main extends Application {
	
	public static Stage primaryStage;
	
    public static void main(String[] args) throws SQLException {    	    	
     launch(args);
    }    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/presentacion/UniversidadUI.fxml"));
        Parent root = loader.load();
        UniversidadUIController controller = loader.getController();           
        Scene scene = new Scene(root);       
        primaryStage.setScene(scene);        
        primaryStage.show();
        
    }
    
    

}
