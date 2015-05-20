package model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sintoma {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
   	private String descripcion;
   	private Long episodioDeDolorId;
   	
   	
   	public Sintoma(String descripcion, Long episodioDeDolorId){
   		
   		this.descripcion = descripcion;
   		this.setEpisodioDeDolorId(episodioDeDolorId);
   	}
   	
   	/**
   	 * Metodo que retorna la descripcion del sintoma
   	 * @return descripcion
   	 */
   	
	public Long getId() {
		return id;
	}
	
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

	public Long getEpisodioDeDolorId() {
		return episodioDeDolorId;
	}

	public void setEpisodioDeDolorId(Long episodioDeDolorId) {
		this.episodioDeDolorId = episodioDeDolorId;
	}
   	
   	
    
}