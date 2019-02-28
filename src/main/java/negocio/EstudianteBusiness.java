package negocio;

import persistencia.EstudianteDao;

public class EstudianteBusiness {
	
	private EstudianteDao estudianteDao;

	public EstudianteBusiness(EstudianteDao estudianteDao) {
		super();
		this.estudianteDao = estudianteDao;
	}
	
	public void consultarTodos() {
		
	}

}
