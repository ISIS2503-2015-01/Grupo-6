package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
public class EpisodioController extends Controller
{

	public static Result createEpisodio()
	{
		return ok(index.render("createEpisodio"));
	}
	
	public static Result getEpisodio(Long id)
	{
		return ok(index.render("getEpisodio"));
	}
	
	public static Result updateEpisodio(Long id)
	{
		return ok(index.render("undateEpisodio"));
	}
	
	public static Result deleteEpisodio(Long id)
	{
		return noContent();
	}
	
}