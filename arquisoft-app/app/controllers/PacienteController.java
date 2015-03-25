package controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.fasterxml.jackson.databind.JsonNode;

import model.Doctor;
import model.Paciente;
import play.api.mvc.BodyParser;
import play.data.Form;
import play.db.jpa.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;

public class PacienteController extends Controller
{
	static Form<Paciente> pacienteForm = Form.form(Paciente.class);
	
	
	@Transactional
	public static Result createPaciente()
	{	
		
		JsonNode web = Controller.request().body().asJson(); 	
        Long documento = Long.parseLong(web.findPath("documento").asText());
        String nombre = web.findPath("nombre").asText();
        String apellido = web.findPath("apellido").asText();
        String fechaNacimiento = web.findPath("fechaNacimiento").asText();
        Date fecha = new Date();
        String genero = web.findPath("genero").asText();
        String telefonoString = web.findPath("telefono").asText();
        int telefono = Integer.parseInt(telefonoString);
        String email = web.findPath("email").asText();
        
        
        try
        {

            Paciente paciente = new Paciente(documento, nombre, apellido, fecha, genero, telefono, email) ;
            JPA.em().persist(paciente);

        } catch (Exception e) {
            e.printStackTrace();
            return Results.ok("Error al crear el doctor");
        }
        return Results.created();
		
	}
	
	@Transactional
	public static Result getPacientes()
	{
		Query q = JPA.em().createQuery("SELECT p FROM Paciente p");
		List<Paciente> lista = q.getResultList();
		return Results.ok(Json.toJson(lista));
	}
	
	@Transactional
	public static Result getPaciente(Long id)
	{
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}

//	public static Result updatePaciente(Long id)
//	{
//		JPA.em().
////	    User usen.fromJson(request().body().asJson(), User.class);
////	    User updated = Database.updateUser(id, user);
////	    return ok(Jsonr = Jso.toJson(updated));
//		return ok(index.render("updatePaciente"));
//	}
//
//	public static Result deletePaciente(Long id)
//	{
////	    Database.deleteUser(id);
//	    return noContent(); // http://stackoverflow.com/a/2342589/1415732
//	}

}
