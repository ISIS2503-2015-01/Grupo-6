package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CatalizadorAsociado {

  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    private String actividadFisica;
    private String estadoTiempo;
    
    /**
     * Retorna la actividad fisica del paciente durante el episodio
     * @return actividadFisica
     */
	public String getActividadFisica() {
		return actividadFisica;
	}
	
	/**
	 * Metodo que registra la actividad fisica durante el episodio
	 * @param actividadFisica
	 */
	public void setActividadFisica(String actividadFisica) {
		this.actividadFisica = actividadFisica;
	}
	
	/**
	 * Retorna el estado del tiempo durante el periodo del episodio
	 * @return estadoTiempo
	 */
	public String getEstadoTiempo() {
		return estadoTiempo;
	}
	
	/**
	 * Metodo que registra el estado del tiempo durante el episodio
	 * @param estadoTiempo
	 */
	public void setEstadoTiempo(String estadoTiempo) {
		this.estadoTiempo = estadoTiempo;
	}
    
    
}

