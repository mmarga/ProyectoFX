package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Estudiante;
import persistencia.EstudianteDao;

public class EstudianteBusiness {
	
	private EstudianteDao estudianteDao;

	public EstudianteBusiness(EstudianteDao estudianteDao) {
		super();
		this.estudianteDao = estudianteDao;
	}
	
	public String consultarTodos() throws SQLException {		
		List<Estudiante> lista = new ArrayList<>();
		lista = estudianteDao.obtenerTodos();
    	StringBuilder stringBuilder = new StringBuilder();
    	for (Estudiante estudiante : lista) {
    		stringBuilder.append("Nombre: ");
    		stringBuilder.append(estudiante.getNombre());
    		stringBuilder.append(", apellido:" );
    		stringBuilder.append(estudiante.getApellido());
    		stringBuilder.append(", carrera:");
    		stringBuilder.append(estudiante.getCarrera());
    		stringBuilder.append("\n");
		}    	
    	
    	return stringBuilder.toString();
		
		
		
	}

}
