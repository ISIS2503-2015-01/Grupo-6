package models;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EpisodioDeDolor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    private Date fecha;
    private Date hora;
    private String intensidad;
    private int horasDeSueno;
    private String lugar;
    
    
    public EpisodioDeDolor(){}
    
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
		this.fecha = fecha;
	}
	
	/**
	 * Metodo que retorna la hora en que sucedio el episodio
	 * @return hora
	 */
	public Date getHora() {
		return hora;
	}
	
	/**
	 * Metodo que registra la hora en que sucedio el episodio
	 * @param hora
	 */
	public void setHora(Date hora) {
		this.hora = hora;
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
    


}