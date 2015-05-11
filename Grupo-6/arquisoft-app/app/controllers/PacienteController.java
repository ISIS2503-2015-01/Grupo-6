package controllers;


import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import model.Doctor;
import model.Paciente;
import views.html.Pacientes;
import play.db.jpa.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;



public class PacienteController extends Controller
{
	
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result createPaciente()
	{	Object d = "documento";
		Object n = "nombre";
		Object a = "apellido";
		Object f = "fechaNacimiento";
		Object g = "genero";
		Object t = "telefono";
		Object e = "email";
		System.out.println(request().body().asFormUrlEncoded());
		String[] doc = request().body().asFormUrlEncoded().get(d);
		String[] nom = request().body().asFormUrlEncoded().get(n);
		String[] ape = request().body().asFormUrlEncoded().get(a);
		String[] fec = request().body().asFormUrlEncoded().get(f);
		String[] gen = request().body().asFormUrlEncoded().get(g);
		String[] tel = request().body().asFormUrlEncoded().get(t);
		String[] ema = request().body().asFormUrlEncoded().get(e);
		
        String documento =  doc[0];
        String nombre = nom[0];
        String apellido = ape[0];
        String fechaNacimiento = fec[0];
        Date fecha = new Date();
        String genero = gen[0];
        String telefonoString = tel[0];
        int telefono = Integer.parseInt(telefonoString);
        String email = ema[0];
        
        
        try
        {	Long doc1 = Long.parseLong(documento);
            Paciente paciente = new Paciente(doc1, nombre, apellido, fecha, genero, telefono, email) ;
            JPA.em().persist(paciente);

        } catch (Exception e2) {
            e2.printStackTrace();
            return Results.ok("Error al crear al paciente");
        }
        return Results.created();
		
	}
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result getPacientes()
	{
		Query q = JPA.em().createQuery("SELECT p FROM Paciente p");
		List<Paciente> lista = q.getResultList();
		
		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		
		return ok(Pacientes.render("Pacientes", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), lista));

	}
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result getPaciente(Long id)
	{
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}

	@Restrict({@Group("admin")})
	@Transactional
	public static Result updatePaciente(Long id)
	{
		//no lo actualiza
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}

	@Restrict({@Group("admin")})
	@Transactional
	public static Result deletePaciente(Long id)
	{

		//no lo borra
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}

}
