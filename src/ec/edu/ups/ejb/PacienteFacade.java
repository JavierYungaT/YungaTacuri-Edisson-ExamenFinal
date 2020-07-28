package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente>{
	
	@PersistenceContext(unitName = "YungaTacuri-Edisson-ExamenFinal")
	private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
		
	}
	

	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}
