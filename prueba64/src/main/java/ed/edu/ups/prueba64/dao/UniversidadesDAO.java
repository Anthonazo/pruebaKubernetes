package ed.edu.ups.prueba64.dao;

import java.util.List;

import ed.edu.ups.prueba64.model.Universidades;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UniversidadesDAO {

	@PersistenceContext
	private EntityManager em;

	public void save(Universidades universidades) {
		em.persist(universidades);
	}

	public void put(Universidades universidades) {
		em.merge(universidades);
	}
	
	public void delete(Universidades universidades) {
		em.remove(universidades);
	}
	
	public Universidades get(int codigo) {
		return em.find(Universidades.class, codigo);
	}
	
	public void remove(int codigo) {
		Universidades universidades = em.find(Universidades.class, codigo);
		em.remove(universidades);
	}

	public List<Universidades> getAll(){
		String jpql = "SELECT c FROM Universidades c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Universidades.class);
		return q.getResultList();
	}
	
}
