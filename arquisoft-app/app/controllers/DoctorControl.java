package controllers;

import java.util.Date;
import javax.xml.transform.Result;
import play.mvc.*;
//Chicaiza 15.02.2015
public class DoctorControl extends Controller 
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
    public static Result getEpisodios(Long id)
    {
        return null;
    }
    /**
     * Metodo que retorna todos los episodios de un paciente a partir de su id, en un rango de fechas
     * @param id
     * @param date1
     * @param date2
     * @return
     */
    public static Result getEpisodiosPorFecha(Long id, Date date1, Date date2)
    {
        return null;
    }
    /**
     * Retorna la informacion asociada a un episodio a partir su id
     * @param id
     * @return
     */
    public static Result getEpisodio(Long id)
    {
        return null;
    }
    //
    //---------------------------------------||
    //


}
