package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sintoma {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
   	private String descripcion;
   	
   	
   	public Sintoma(){}
   	
   	/**
   	 * Metodo que retorna la descripcion del sintoma
   	 * @return descripcion
   	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo que registra la descripcion del sintoma
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   	
   	
    
}