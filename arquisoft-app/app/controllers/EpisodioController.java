package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
public class EpisodioController extends Controller
{

	public static Result createEpisodio()
	{
//		Paciente newUser = Json.fromJson(request().body().asJson(), Paciente.class);
		return ok(index.render("createEpisodio"));
		
	}
		
	public static Result getEpisodios()
	{
//	    List<Paciente> users = Database.getUsers();
//	    return ok(Json.toJson(users));
	    return ok(index.render("getEpisodio"));
	}

	public static Result getEpisodio(Long id)
	{
//	    User user = Database.getUser(id);
//	    return user == null ? notFound() : ok(Json.toJson(user));
	    return ok(index.render("getEpisodio"));
	}

	public static Result updateEpisodio(Long id)
	{
//	    User user = Json.fromJson(request().body().asJson(), User.class);
//	    User updated = Database.updateUser(id, user);
//	    return ok(Json.toJson(updated));
		return ok(index.render("updateEpisodio"));
	}

	public static Result deleteEpisodio(Long id)
	{
//	    Database.deleteUser(id);
	    return noContent(); // http://stackoverflow.com/a/2342589/1415732
	}
	
}