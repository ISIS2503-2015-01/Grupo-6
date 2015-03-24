package controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import model.Paciente;
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
		
		Paciente n = new Paciente(null, null, null, null, 1, null);
		JPA.em().persist(n);
//		"wareverson", "junior", new Date(),"asgwe", 1,"warever@hotmail"
//		Paciente newUser = Json.fromJson(request().body().asJson(), Paciente.class);
		return Results.created();
		
	}
	
	@Transactional
	public static Result getPacientes()
	{
		Query q = JPA.em().createQuery("SELECT p FROM Paciente p");
		List<Paciente> lista = q.getResultList();
		return Results.ok(Json.toJson(lista));
	}

	public static Result getPaciente(Long id)
	{
//	    User user = Database.getUser(id);
//	    return user == null ? notFound() : ok(Json.toJson(user));
	    return ok(index.render("getPaciente"));
	}

	public static Result updatePaciente(Long id)
	{
//	    User user = Json.fromJson(request().body().asJson(), User.class);
//	    User updated = Database.updateUser(id, user);
//	    return ok(Json.toJson(updated));
		return ok(index.render("updatePaciente"));
	}

	public static Result deletePaciente(Long id)
	{
//	    Database.deleteUser(id);
	    return noContent(); // http://stackoverflow.com/a/2342589/1415732
	}

}
