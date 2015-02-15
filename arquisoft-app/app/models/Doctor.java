package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {

    public static final int MASCULINO = 1;
    public static final int FEMENINO = 1;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    private String nombre;
    private String apellido;
    
    
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
   
}