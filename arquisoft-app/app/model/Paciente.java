package model;
import javax.persistence.*;

import play.db.ebean.Model.Finder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(name="Paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {

    @Id
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name="genero")
    private String genero;
    @Column(name="telefono")
    private int telefono;
    @Column(name="email")
    private String email;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="pacienteId")
    private Collection<EpisodioDeDolor> episodioDeDolor = new ArrayList<EpisodioDeDolor>();
    


    
    /**
     * Constructor Paciente
     * @param nombren 
     * @param id
     * @param nombren
     * @param napellido 
     * @param napellido
     * @param fechaNa 
     * @param fechaNa
     * @param gen 
     * @param gen
     * @param tel 
     * @param tel
     * @param mail 
     * @param mail
     */
    public Paciente (Long idn, String nombren, String napellido, Date fechaNa, String gen, int tel, String mail)
    {
    	id = idn;
    	nombre = nombren;
    	apellido = napellido;
    	fechaNacimiento = fechaNa;
    	genero = gen;
    	telefono = tel;
    	email = mail;
    	
    }
    
    /**
     * Metodo que retorna el documento de identidad del paciente	
     * @param idDocumento
     * @return idDocumento
     */
    public long getIdDocumento(){
    	return this.id;
    	
    }
    
    /**
     * Metodo que registra el documento de identidad del paciente
     * @param idDocumento
     */
    public void setIdDocumento(Long idDocumento){
    	this.id = idDocumento;
    	
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
	
	public static Finder<Long,Paciente> find = new Finder<Long,Paciente>(
		    Long.class, Paciente.class);
     
}