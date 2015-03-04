package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {

    @Id
    private Long idDocumento;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;
    private int telefono;
    private String email;
    

    public Paciente(){}
    
    /**
     * Constructor Paciente
     * @param id
     * @param nombren
     * @param napellido
     * @param fechaNa
     * @param gen
     * @param tel
     * @param mail
     */
    public static Paciente create(long id, String nombren, String napellido, Date fechaNa, String gen, int tel, String mail)
    {
    	Paciente p = new Paciente();
    	p.idDocumento = id;
    	p.nombre = nombren;
    	p.apellido = napellido;
    	p.fechaNacimiento = fechaNa;
    	p.genero = gen;
    	p.telefono = tel;
    	p.email = mail;
    	
    	return p;
    }
    
    /**
     * Metodo que retorna el documento de identidad del paciente	
     * @param idDocumento
     * @return idDocumento
     */
    public long getIdDocumento(){
    	return this.idDocumento;
    	
    }
    
    /**
     * Metodo que registra el documento de identidad del paciente
     * @param idDocumento
     */
    public void setIdDocumento(Long idDocumento){
    	this.idDocumento = idDocumento;
    }
    
    /**
     * Metodo que retorna el nombre del paciente	
     * @return nombre
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que registra el nombre del paciente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que retorna el apellido del paciente
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Metodo que registra el apellido del paciente
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Metodo que retorna la fecha de nacimiento del paciente
	 * @return fecha de nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Metodo que registra la fecha de nacimiento del paciente
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Metodo que retorna el genero del paciente
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Metodo que registra el genero del paciente
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Metodo que retorna el telefono del paciente
	 * @return telefono
	 */
	public int getTelefono() {
		return telefono;
	}
	
	/**
	 * Metetodo que registra el telefono del paciente
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Meteodo que retorna el email del paciente
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo que registra el email del paciente
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
     
}