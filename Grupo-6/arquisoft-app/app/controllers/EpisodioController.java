package controllers;

import model.EpisodioDeDolor;
import model.Paciente;

import javax.persistence.Query;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

import play.data.Form;
import play.db.jpa.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;
public class EpisodioController extends Controller
{
	static Form<EpisodioDeDolor> episodioDeDolor = Form.form(EpisodioDeDolor.class);
	
	@Transactional
	public static Result createEpisodio()
	{
		
		JsonNode web = Controller.request().body().asJson(); 	
        String intensidad = (web.findPath("intensidad").asText());
        String horasSueno = web.findPath("horasSueno").asText();
        int horasDeSueno = Integer.parseInt(horasSueno);
        String fechaN= web.findPath("fechaDolor").asText();
        Date fecha = new Date();
        String lugar = web.findPath("lugar").asText();
        Long pacienteId = Long.parseLong(web.findPath("telefono").asText());
        
        
        try
        {

            EpisodioDeDolor episodioDeDolor = new EpisodioDeDolor(fecha, intensidad, horasDeSueno, lugar, pacienteId);
            JPA.em().persist(episodioDeDolor);

        } catch (Exception e) {
            e.printStackTrace();
            return Results.ok("Error al crear el doctor");
        }
        return Results.created();
		
	}
	
	@Transactional
	public static Result getEpisodios(Long id)
	{
		EpisodioDeDolor q = JPA.em().find(EpisodioDeDolor.class, id);
	    return Results.ok(Json.toJson(q));
	}
	@Transactional
	public static Result getEpisodio(Long id, Long id1)
	{
		
		Query q = JPA.em().createQuery("SELECT e FROM EpisodioDeDolor e WHERE e.pacienteId =" + id);
		List<EpisodioDeDolor> edd = q.getResultList();
	    return Results.ok(Json.toJson(edd));
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