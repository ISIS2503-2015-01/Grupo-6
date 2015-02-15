package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CatalizadorAsociado {

  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String actividadFisica;
    private String estadoTiempo;
    
	public String getActividadFisica() {
		return actividadFisica;
	}
	
	public void setActividadFisica(String actividadFisica) {
		this.actividadFisica = actividadFisica;
	}
	
	public String getEstadoTiempo() {
		return estadoTiempo;
	}
	
	public void setEstadoTiempo(String estadoTiempo) {
		this.estadoTiempo = estadoTiempo;
	}
    
    
}

