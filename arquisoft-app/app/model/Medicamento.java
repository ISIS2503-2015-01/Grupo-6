package model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medicamento {

  
    @Id
    private String nombre;
    private double dosis; 
    private int frecuencia;
    
    
    public Medicamento(){}
    /**
     * Metodo que devuelve el nombre del medicamento
     * @return nombre
     */
    public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que registra el nombre del medicamento
	 * @param nombre
	 */
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la cantidad de dosis suminstrada del medicamento
	 * @return dosis
	 */
	public double getDosis() {
		return dosis;
	}
	
	/**
	 * Metodo que registra la dosis suministrada del medicamento
	 * @param dosis
	 */
	public void setDosis(double dosis) {
		this.dosis = dosis;
	}

	/**
	 * Metodo que registra la frecuencia de que es suministrada el medicamento 
	 * @return frecuencia
	 */
	public int getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Metodo que retorna la frecuencia de que es suministrada el medicamento
	 * @param frecuencia
	 */
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
    
    
    
}

