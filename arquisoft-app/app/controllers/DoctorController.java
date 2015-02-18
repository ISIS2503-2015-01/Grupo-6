package controllers;

import java.util.List;

import models.Paciente;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;



public class DoctorController extends Controller 
{
	//
	//---------------------------------------||
	//Servicios para experimento 1
	//
    /**
     * Metodo que retorna todos los episodios de un paciente a partir de su id
     * @param id
     * @return
     */
    public static Result getEpisodios(long id)
    {
    	 return ok(index.render("Episodios"));
    }
    

    /**
     * Metodo que retorna todos los episodios de un paciente a partir de su id, en un rango de fechas
     * @param id
     * @param date1
     * @param date2
     * @return
     */
    public static Result getEpisodiosPorFecha(Long id, String date1, String date2)
    {
    	 return (Result) ok(index.render("episodiosPorFecha"));
    }
    /**
     * Retorna la informacion asociada a un episodio a partir su id
     * @param id
     * @return
     */
    public static Result getEpisodio(Long id)
    {
    	 return (Result) ok(index.render("episodio"));
    }
    //
    //---------------------------------------||
    //

    public static Result createPaciente()
	{
//		Paciente newUser = Json.fromJson(request().body().asJson(), Paciente.class);
		return ok(index.render("createPacientes"));
		
	}
		
	public static Result getDoctores()
	{
//	    List<Paciente> users = Database.getUsers();
//	    return ok(Json.toJson(users));
	    return ok(index.render("getDoctores"));
	}

	public static Result getDoctor(Long id)
	{
//	    User user = Database.getUser(id);
//	    return user == null ? notFound() : ok(Json.toJson(user));
	    return ok(index.render("getDoctor"));
	}

	public static Result updateDcotor(Long id)
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
