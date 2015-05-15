package controllers;

import model.CatalizadorAsociado;
import model.Doctor;
import model.EpisodioDeDolor;
import model.Medicamento;
import model.Paciente;
import model.Sintoma;

import javax.persistence.Query;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

import play.data.Form;
import play.db.jpa.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.episodio;
import views.html.Pacientes;
import views.html.index;
import views.html.EpisodiosDeDolor;
public class EpisodioController extends Controller
{
	static Form<EpisodioDeDolor> episodioDeDolor = Form.form(EpisodioDeDolor.class);
	
	@Restrict({@Group("admin")})
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
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result getEpisodios(Long id)
	{
		Query q = JPA.em().createQuery("SELECT p FROM EpisodioDeDolor p WHERE pacienteId = '"+id+"'");
		List<EpisodioDeDolor> lista = q.getResultList();
		
		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		
		
		
		return ok(EpisodiosDeDolor.render("Episodios De Dolor", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), lista));
		
		

	}
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result getEpisodio(Long id)
	{
		
		Query q = JPA.em().createQuery("SELECT e FROM EpisodioDeDolor e WHERE e.id =" + id);
		List<EpisodioDeDolor> epi = q.getResultList();
		
		
		
		
		Query c = JPA.em().createQuery("SELECT p FROM CatalizadorAsociado p WHERE episodioDeDolorId = '"+id+"'");
		List<CatalizadorAsociado> cata = c.getResultList();
		
		Query s = JPA.em().createQuery("SELECT p FROM Sintoma p WHERE episodioDeDolorId = '"+id+"'");
		List<Sintoma> sint = s.getResultList();
		
		Query m = JPA.em().createQuery("SELECT p FROM Medicamento p WHERE episodioDeDolorId = '"+id+"'");
		List<Medicamento> med = m.getResultList();
		
		Doctor d = null;
		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		
		return ok(episodio.render("Episodio" + id, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(), d), epi,cata,sint,med));

	}

	@Restrict({@Group("admin")})
	@Transactional
	public static Result updateEpisodio(Long id)
	{
//	    User user = Json.fromJson(request().body().asJson(), User.class);
//	    User updated = Database.updateUser(id, user);
//	    return ok(Json.toJson(updated));
//		return ok(index.render("updateEpisodio"));
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}
	
	@Restrict({@Group("admin")})
	@Transactional
	public static Result deleteEpisodio(Long id)
	{
//	    Database.deleteUser(id);
//	    return noContent(); // http://stackoverflow.com/a/2342589/1415732
		Paciente q = JPA.em().find(Paciente.class, id);
	    return Results.ok(Json.toJson(q));
	}
	
}