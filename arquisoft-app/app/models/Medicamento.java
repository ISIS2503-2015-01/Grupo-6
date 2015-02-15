package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medicamento {

  
    @Id
    private String nombre;
    private double dosis; 
    private int frecuencia;
    
    public double getNombre() {
		return dosis;
	}
	
	public void setNombre(double dosis) {
		this.dosis = dosis;
	}

	
	public double getDosis() {
		return dosis;
	}
	
	public void setDosis(double dosis) {
		this.dosis = dosis;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
    
    
    
}

