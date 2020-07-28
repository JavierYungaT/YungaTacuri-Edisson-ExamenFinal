package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitasMedicasFacade;
import ec.edu.ups.ejb.SignosVitalesFacade;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SignosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private SignosVitalesFacade ejbSignosFacade;
	
	private int id;
	private String nombre;

}
