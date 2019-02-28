package negocio;

import java.sql.SQLException;

import dominio.Materia;
import persistencia.MateriaDao;
import utl.MateriaDuplicadaException;
import utl.NegocioException;


public class MateriaBusiness {

    private MateriaDao materiaDao;

    public MateriaBusiness(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }

    public void crearMateria(String nombre, Integer cargaHoraria) throws NegocioException {
    	
    	

    	Materia materia = new Materia();
    	materia.setNombre(nombre);
    	materia.setCargaHoraria(cargaHoraria);
    	try {
    		if (materiaDao.obtenerPorDato("nombre", nombre).size() >= 1) {
    			throw new MateriaDuplicadaException();
				
			}
			materiaDao.grabar(materia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       


    }
}
