package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidades.*;

@Stateless
public class SignosVitalesFacade extends AbstractFacade<SignosVitales>{
	
	@PersistenceContext(unitName = "YungaTacuri-Edisson-ExamenFinal")
    private EntityManager em;
	
	public SignosVitalesFacade() {
		super(SignosVitales.class);
	}
	
	 @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	 
	 public Paciente validar(String paciente ) {
			Paciente pa=new Paciente();
			try {
				String sql="SELECT p FROM Paciente p where p.nombre='"+paciente+"'";
				System.out.println(sql);
				Query query = em.createQuery(sql);
				pa= (Paciente) query.getSingleResult();
				System.out.println("Aqui llego"+paciente);	
			} catch (Exception e) {
				System.out.println("Nombre"+e.getMessage());
			}
				
			return pa;
			
		}
		
		public List<CitasMedicas> buscarCitas(int id){
			System.out.println( id);
			String sql="SELECT c FROM CitasMedicas c where c.paciente.id='"+id+"'";
			List<CitasMedicas> list = em.createQuery(sql).getResultList();
			return list;
		}
		
		public List<CitasMedicas> buscarCitasnombre(String nombre){
			
			String sql="SELECT c FROM CitasMedicas c where c.paciente.nombre='"+nombre+"'";
			List<CitasMedicas> list = em.createQuery(sql).getResultList();
			return list;
		}
	

}
