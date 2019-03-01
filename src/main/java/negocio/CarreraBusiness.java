package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Carrera;
import persistencia.CarreraDao;

public class CarreraBusiness {
	
	private CarreraDao carreraDao;

	public CarreraBusiness(CarreraDao carreraDao) {
		super();
		this.carreraDao = carreraDao;
	}
	
	public String consultarTodos() throws SQLException {
		List<Carrera> listaCarrera = new ArrayList<>();
		listaCarrera = carreraDao.obtenerTodos();
		StringBuilder stringBuilder = new StringBuilder();
		for (Carrera carrera : listaCarrera) {
			stringBuilder.append("Nombre: " + carrera.getNombre());
			stringBuilder.append(", ID: " + carrera.getId());
			stringBuilder.append("\n");
			
		}
		
		return stringBuilder.toString();
	}

}
