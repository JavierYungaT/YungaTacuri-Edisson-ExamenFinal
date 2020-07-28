package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidades.CitasMedicas;

@Stateless
public class CitasMedicasFacade extends AbstractFacade<CitasMedicas>{
	
	@PersistenceContext(unitName = "YungaTacuri-Edisson-ExamenFinal")
    private EntityManager em;

	
	public CitasMedicasFacade() {
		super(CitasMedicas.class);
	}


	public CitasMedicasFacade(Class<CitasMedicas> entityClass, EntityManager em) {
		super(entityClass);
		this.em = em;
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
