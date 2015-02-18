package controllers;


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


}
