package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.SecurityRole;
import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor implements Subject{

    @Id
    private String id;
    
    private String password;
    
    private String email;
    
	@ManyToMany
    public List<SecurityRole> roles;

    protected Doctor(){
    	
    }
    /**
     * Constructor Doctor
     * @param id
     * @param nombre
     * @param apellido
     */
    public Doctor(String password, String id, String email)
    {
    	roles=new ArrayList<SecurityRole>();
    	this.id = id;
    	this.email = email;
    	this.password = password;
    }
    /**
     * Metodo que retorna el nombre del doctor
     * @return nombre
     */
	public String getId() {
		return id;
	}
	
	/**
	 * Metodo que registra el nombre del doctor
	 * @param nombre
	 */
	public void setId(String id) {
		this.id = id;
	}
	
    /**
     * Metodo que retorna el nombre del doctor
     * @return nombre
     */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo que registra el nombre del doctor
	 * @param nombre
	 */
	public void setEmail(String nombre) {
		this.email = nombre;
	}
	
	/**
	 * Metodo que retorna el apellido del doctor
	 * @return apellido
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Metodo que registra el apellido del doctor
	 * @param apellido
	 */
	public void setPassword(String apellido) {
		this.password = apellido;
	}
	
	
	
	@Override
	public String getIdentifier() {
		return email;
	}

	@Override
	public List<? extends Permission> getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Role> getRoles() {
		return roles;
	}
	
	public void agregarRol(SecurityRole s)
	{
		roles.add(s);
	}

	
}