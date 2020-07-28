package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.entidades.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PacienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private PacienteFacade ejbPacienteFacade;
	
	private List<Paciente> listaPaciente;
	private String nombre;
	
	public PacienteBean() {
		
	}
	@PostConstruct
	public void init() {
		listaPaciente=ejbPacienteFacade.findAll();
	}
	public PacienteFacade getEjbPacienteFacade() {
		return ejbPacienteFacade;
	}
	public void setEjbPacienteFacade(PacienteFacade ejbPacienteFacade) {
		this.ejbPacienteFacade = ejbPacienteFacade;
	}
	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}
	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
