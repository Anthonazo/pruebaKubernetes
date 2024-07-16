package ed.edu.ups.prueba64.bussines;

import java.util.List;

import ed.edu.ups.prueba64.dao.UniversidadesDAO;
import ed.edu.ups.prueba64.model.Universidades;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidades {

	@Inject
	private UniversidadesDAO daoUniversidades;
	
	public void save(Universidades u) {
		daoUniversidades.save(u);
	}
	
	public void delete(Universidades u) {
		daoUniversidades.delete(u);
	}
	
	public void put(Universidades u) {
		daoUniversidades.put(u);
	}
	
	public List<Universidades> getall() {
		return daoUniversidades.getAll();
	}
	
	public Universidades getU(int codigo) {
		return daoUniversidades.get(codigo);
	}
	
	public void remove(int codigo) {
		daoUniversidades.remove(codigo);
	}
	
}
