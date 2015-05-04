package controllers;

import java.util.List;

import javax.persistence.Query;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;

import com.fasterxml.jackson.databind.JsonNode;

import model.Doctor;
import model.Paciente;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;



public class DoctorController extends Controller 
{
	static Form<Doctor> doctorForm = Form.form(Doctor.class);
	
	
	@Restrict({@Group("admin")})
	@Transactional
	
    public static Result createDoctor()
	{

    	JsonNode web = Controller.request().body().asJson(); 	
        String documento = web.findPath("documento").asText();
        String nombre = web.findPath("nombre").asText();
        String password = web.findPath("password").asText();
        try
        {
        	
            Doctor doctor = new Doctor(password, documento, nombre) ;
            JPA.em().persist(doctor);

        } catch (Exception e) {
            e.printStackTrace();
            return Results.ok("Error al crear el doctor");
        }
        return Results.created();
		
	}
	

	
	@Restrict({@Group("admin")})
	@play.db.jpa.Transactional
	public static Result getDoctores()
	{
		List<Doctor> resp=null;
		Query q=JPA.em().createQuery("from Doctor");
		resp=q.getResultList();
		return Results.ok(Json.toJson(resp));
	}
				
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result getDoctor(String id)
	{

		Doctor q = JPA.em().find(Doctor.class, id);
	    return Results.ok(Json.toJson(q));
	    
	}
	
	

	@Restrict({@Group("admin")})
	@Transactional
	public static Result updateDoctor(String id)
	{
		
		//no lo actualiza
		Doctor q = JPA.em().find(Doctor.class, id);
	    return Results.ok(Json.toJson(q));
	}

	@Restrict({@Group("admin")})
	@Transactional
	public static Result deleteDoctor(String id)
	{
		
		//no lo borra
		Doctor q = JPA.em().find(Doctor.class, id);
	    return Results.ok(Json.toJson(q));
	}

}
