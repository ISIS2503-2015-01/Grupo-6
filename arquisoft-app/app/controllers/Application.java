package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("CODE PIMP"));
    }
    
    public static Result sayHello()
    {
    	return ok(Paciente.render("Crear Paciente"));
    }
    public static Result vamos()
    {
    	return ok(verpaciente.render("Lista de pacientes"));
    	
    }

}
