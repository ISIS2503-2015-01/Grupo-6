package models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sintoma {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    public String descripcion;
    
}