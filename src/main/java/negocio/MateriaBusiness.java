package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Materia;
import persistencia.EstudianteDao;
import persistencia.MateriaDao;
import utl.MateriaDuplicadaException;
import utl.NegocioException;


public class MateriaBusiness {

    private MateriaDao materiaDao;

    public MateriaBusiness(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }

   public String consultarTodos() throws SQLException {
	   List<Materia> listaMateria = new ArrayList<>();
	   listaMateria = materiaDao.obtenerTodos();
	   StringBuilder stringBuilder = new StringBuilder();
	   for (Materia materia : listaMateria) {
		   stringBuilder.append("Nombre: " + materia.getNombre());
		   stringBuilder.append(", carga horaria: " + materia.getCargaHoraria());
		   stringBuilder.append("\n");
		
	}
	   return stringBuilder.toString();
   }
   
   public String consultarPorId(Integer id) throws SQLException {
	   
	   Materia materia = materiaDao.obtenerPorId(id);
	   StringBuilder stringBuilder = new StringBuilder();
	   String resultado = "No hay registros";
	   if (materia != null) {
		   stringBuilder.append("Nombre: "  + materia.getNombre());
		   stringBuilder.append(",carga horaria: " + materia.getCargaHoraria());
		   resultado = stringBuilder.toString();
		
	}
	   
	   return resultado;
   }
}
