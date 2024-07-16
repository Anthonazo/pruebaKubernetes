package ed.edu.ups.prueba64.bussines;

import java.util.Date;
import java.util.List;

import ed.edu.ups.prueba64.dao.UniversidadesDAO;
import ed.edu.ups.prueba64.model.Universidades;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private UniversidadesDAO daoUniversidades;

	@PostConstruct
	public void init() {
		System.out.println("iniciando");

		Universidades u1 = new Universidades();
		u1.setNombre("UPS");
		
		Universidades u2 = new Universidades();
		u2.setNombre("UDA");
		
		Universidades u3 = new Universidades();
		u3.setNombre("ESTATAL");

		daoUniversidades.save(u1);
		daoUniversidades.save(u2);
		daoUniversidades.save(u3);
	}
}
