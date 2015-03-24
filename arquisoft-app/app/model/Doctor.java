package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {

    @Id
    public Long id;
    private String nombre;
    private String apellido;
    
    public Doctor()
    {
    	
    }
    /**
     * Metodo que retorna el nombre del doctor
     * @return nombre
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que registra el nombre del doctor
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que retorna el apellido del doctor
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Metodo que registra el apellido del doctor
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
   
}