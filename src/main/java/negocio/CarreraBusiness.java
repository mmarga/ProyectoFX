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
	
	public String ConsultarPorId(Integer id) throws SQLException {
		
		
		Carrera carrera = carreraDao.obtenerPorId(id);		
		StringBuilder stringBuilder = new StringBuilder();
		String resultado = "No se encontraron registros";
		if (carrera != null) {
			stringBuilder.append("Carrera seleccionada: " + carrera.getNombre() + ", número de ID" + carrera.getId());
			resultado = stringBuilder.toString();
		}
			
		return resultado;
	}

}
