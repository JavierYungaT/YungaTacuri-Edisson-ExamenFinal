package ec.edu.ups.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class CitasMedicas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String signosVitales;
	private String sintomas;
	private String alergias;
	private String enferPrevias;
	private String fecha;
	
	@ManyToOne
	private Paciente paciente;
	
	@Transient
	private boolean editable;

	public CitasMedicas() {
		
	}

	public CitasMedicas(String signosVitales, String sintomas, String alergias, String enferPrevias,
			String fecha, Paciente paciente) {
		this.signosVitales = signosVitales;
		this.sintomas = sintomas;
		this.alergias = alergias;
		this.enferPrevias = enferPrevias;
		this.fecha = fecha;
		this.paciente = paciente;
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitasMedicas other = (CitasMedicas) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitasMedicas [id=" + id + ", signosVitales=" + signosVitales + ", sintomas=" + sintomas + ", alergias="
				+ alergias + ", enferPrevias=" + enferPrevias + ", fecha=" + fecha + ", paciente=" + paciente
				+ ", editable=" + editable + "]";
	}

	
	
	
	

}
