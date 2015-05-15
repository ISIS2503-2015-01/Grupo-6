package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EpisodioDeDolor {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Long id;

	private Date fecha;
	private String intensidad;
	private int horasDeSueno;
	private String lugar;
	private Long pacienteId;
	
    @OneToMany(cascade=CascadeType.ALL, mappedBy="episodioDeDolorId")
    private Collection<CatalizadorAsociado> catalalizadorAsociado = new ArrayList<CatalizadorAsociado>();
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="episodioDeDolorId")
    private Collection<Sintoma> sintoma = new ArrayList<Sintoma>();
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="episodioDeDolorId")
    private Collection<Medicamento> medicamento = new ArrayList<Medicamento>();

    protected EpisodioDeDolor(){}

	public EpisodioDeDolor(Date fecha, String intensidad, int horasDeSueno, String lugar, Long pacienteId){
		
		this.fecha = fecha;
		this.intensidad = intensidad;
		this.horasDeSueno = horasDeSueno;
		this.lugar = lugar;
		this.setPacienteId(pacienteId);
		
	}
	
	
	public Long getId() {
		return id;
	}
	

	/**
	 * Metodo que retorna el anio y dia del suceso del episodio
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo que registra la fecha del episodio
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = new Date();
	}

	/**
	 * Metodo que retorna la intensidad del episodio
	 * @return intensidad
	 */
	public String getIntensidad() {
		return intensidad;
	}

	/**
	 * Metodo que registra la intensidad del episodio
	 * @param intensidad
	 */
	public void setIntensidad(String intensidad) {
		this.intensidad = intensidad;
	}

	/**
	 * Metodo que retorna la cantidad de horas de sueno del paciente durante el episodio
	 * @return horas de sueno
	 */
	public int getHorasDeSueno() {
		return horasDeSueno;
	}

	/**
	 * Metodo que registra la cantidad de horas de sueno del paciente durante el episodio
	 * @param horasDeSueno
	 */
	public void setHorasDeSueno(int horasDeSueno) {
		this.horasDeSueno = horasDeSueno;
	}

	/**
	 * Metodo que devuelve el lugar donde se presento el episodio
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo que registra el lugar donde se presento el episodio
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}



}