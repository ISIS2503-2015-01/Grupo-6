package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alimento {

  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private Long catalizadorAsociadoId;
    
    public Alimento(String nombre, String tipo, int cantidad, Long catalizadorAsociadoId){
    

    	this.nombre = nombre;
    	this.tipo = tipo;
    	this.cantidad = cantidad;
    	this.setCatalizadorAsociadoId(catalizadorAsociadoId);
    	
    }
    
    /**
     * Metodo que define el nombre del alimento
     * @return nombre 
     */
	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Metodo que retorna el nombre del alimento
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que devuelve el tipo del alimento
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Metodo que define el tipo del alimento
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo que da la cantidad que ingerio del almiento
	 * @return cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Metodo que registra la cantidad de alimento que comio
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Long getCatalizadorAsociadoId() {
		return catalizadorAsociadoId;
	}

	public void setCatalizadorAsociadoId(Long catalizadorAsociadoId) {
		this.catalizadorAsociadoId = catalizadorAsociadoId;
	}
    
    
}