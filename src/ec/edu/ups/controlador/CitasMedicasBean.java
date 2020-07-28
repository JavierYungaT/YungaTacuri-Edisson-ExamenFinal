package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitasMedicasFacade;
import ec.edu.ups.ejb.PacienteFacade;

import ec.edu.ups.entidades.CitasMedicas;
import ec.edu.ups.entidades.Paciente;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitasMedicasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private CitasMedicasFacade ejbCitasFacade;
	@EJB
	private PacienteFacade ejbPacienteFacade;
	
	private int id;
	private String signosVitales;
	private String sintomas;
	private String alergias;
	private String enferPrevias;
	private String fecha;
	private String paciente;
	private String nombre;

	private CitasMedicas citasMedicas;
	
	private List<CitasMedicas> listCitas;
	private List<CitasMedicas> listCitas1;

	public CitasMedicasBean() {
	
	}
	
	@PostConstruct
	public void init() {
		this.citasMedicas = new CitasMedicas();
		listCitas = ejbCitasFacade.findAll();
		new ArrayList<>();
	}

	public CitasMedicasFacade getEjbCitasFacade() {
		return ejbCitasFacade;
	}

	public void setEjbCitasFacade(CitasMedicasFacade ejbCitasFacade) {
		this.ejbCitasFacade = ejbCitasFacade;
	}

	public PacienteFacade getEjbPacienteFacade() {
		return ejbPacienteFacade;
	}

	public void setEjbPacienteFacade(PacienteFacade ejbPacienteFacade) {
		this.ejbPacienteFacade = ejbPacienteFacade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(String signosVitales) {
		this.signosVitales = signosVitales;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnferPrevias() {
		return enferPrevias;
	}

	public void setEnferPrevias(String enferPrevias) {
		this.enferPrevias = enferPrevias;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public CitasMedicas getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(CitasMedicas citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public List<CitasMedicas> getListCitas() {
		return listCitas;
	}

	public void setListCitas(List<CitasMedicas> listCitas) {
		this.listCitas = listCitas;
	}
	
	
	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
	public List<CitasMedicas> getListCitas1() {
		return listCitas1;
	}

	public void setListCitas1(List<CitasMedicas> listCitas1) {
		this.listCitas1 = listCitas1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String add() {
		try {
			CitasMedicas pro = new CitasMedicas(this.signosVitales, this.sintomas, this.alergias, this.enferPrevias, this.fecha, null);
			System.out.println(pro);
			ejbCitasFacade.create(pro);

			listCitas = ejbCitasFacade.findAll();
			//Stock sto = new Stock(bode(), pro);
			//ejbStockFacade.create(sto);
			listCitas = ejbCitasFacade.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public String delete(CitasMedicas p) {
		ejbCitasFacade.remove(p);
		listCitas = ejbCitasFacade.findAll();
		return null;
	}

	public String edit(CitasMedicas p) {
		p.setEditable(true);
		return null;
	}

	public String save(CitasMedicas p) {
		ejbCitasFacade.edit(p);
		p.setEditable(false);
		return null;
	}


	public Paciente buscar() {
		System.out.println(paciente);
		Paciente ca = new Paciente();
		ca = ejbCitasFacade.validar(paciente);
		System.out.println(ca.toString());
		System.out.println(ca.getId());
		return ca;
	}

	public Paciente buscarCitas() {
		System.out.println(paciente);
		System.out.println("Lllega al metooooodooo");
		Paciente ca = new Paciente();
		ca = ejbCitasFacade.validar(paciente);
		System.out.println(ca.toString());
		int id = ca.getId();
		System.out.println(id);
		listCitas = ejbCitasFacade.buscarCitas(id);
		System.out.println(listCitas);
		return ca;

	}

	public CitasMedicas buscarCitasnombre() {
		CitasMedicas pro = new CitasMedicas();
		String paciente = pro.getAlergias();
		System.out.println(paciente);
		listCitas1 = ejbCitasFacade.buscarCitasnombre(paciente);
		System.out.println(listCitas1);
		return pro;

	}

	
	

}
