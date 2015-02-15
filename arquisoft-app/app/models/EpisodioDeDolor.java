package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EpisodioDeDolor {

    public static final int MASCULINO = 1;
    public static final int FEMENINO = 1;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    private Date fecha;
    private Date hora;
    private String intensidad;
    private int horasDeSueno;
    private String lugar;
    
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public String getIntensidad() {
		return intensidad;
	}
	
	public void setIntensidad(String intensidad) {
		this.intensidad = intensidad;
	}
	
	public int getHorasDeSueno() {
		return horasDeSueno;
	}
	
	public void setHorasDeSueno(int horasDeSueno) {
		this.horasDeSueno = horasDeSueno;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
    


}