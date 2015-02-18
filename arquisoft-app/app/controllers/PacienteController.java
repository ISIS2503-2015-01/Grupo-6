package controllers;

import java.util.List;

import models.Paciente;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class PacienteController extends Controller
{
	public static Result createPaciente()
	{
//		Paciente newUser = Json.fromJson(request().body().asJson(), Paciente.class);
		return ok(index.render("createPacientes"));
		
	}
		
	public static Result getPacientes()
	{
//	    List<Paciente> users = Database.getUsers();
//	    return ok(Json.toJson(users));
	    return ok(index.render("getPacientes"));
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
