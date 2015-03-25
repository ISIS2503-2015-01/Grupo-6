package controllers;

import java.util.List;

import javax.persistence.Query;

import com.fasterxml.jackson.databind.JsonNode;

import model.Doctor;
import model.Paciente;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;



public class DoctorController extends Controller 
{
	@Transactional
    public static Result createDoctor()
	{

    	JsonNode web = Controller.request().body().asJson(); 	
        Long documento = Long.parseLong(web.findPath("documento").asText());
        String nombre = web.findPath("nombre").asText();
        String apellido = web.findPath("apellido").asText();
        try
        {

            Doctor doctor = new Doctor(documento, nombre, apellido);
            JPA.em().persist(doctor);

        } catch (Exception e) {
            e.printStackTrace();
            return Results.ok("Error al crear el doctor");
        }
        return Results.created();
		
	}
	@Transactional
	public static Result getDoctores()
	{
		
		Query q = JPA.em().createQuery("SELECT p FROM Doctor p");
		List<Paciente> lista = q.getResultList();
		return Results.ok(Json.toJson(lista));
		
	}
	@Transactional
	public static Result getDoctor(Long id)
	{

		Doctor q = JPA.em().find(Doctor.class, id);
	    return Results.ok(Json.toJson(q));
	    
	}

	
	public static Result updateDoctor(Long id)
	{
//	    User user = Json.fromJson(request().body().asJson(), User.class);
//	    User updated = Database.updateUser(id, user);
//	    return ok(Json.toJson(updated));
		return ok(index.render("updateDoctor"));
	}

	public static Result deleteDoctor(Long id)
	{
//	    Database.deleteUser(id);
		return ok(index.render("deleteDoctor")); // http://stackoverflow.com/a/2342589/1415732
	}

}
