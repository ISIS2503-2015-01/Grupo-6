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
    
    public static Result login(){
    	
    	return ok();
    }

//    public static Result login() {
//		return ok(views.html.login.render(form(Login.class).bindFromRequest()));
//	}

//	public static Result doLogin() {
//		com.feth.play.module.pa.controllers.Authenticate.noCache(response());
//		final Form<Login> filledForm = form(Login.class).bindFromRequest();
//		if (filledForm.hasErrors()) {
//			// User did not fill everything properly
//			return badRequest(views.html.login.render(filledForm));
//		} else {
//			// Everything was filled
//			return TestUsernamePasswordAuthProvider.handleLogin(ctx());
//		}
//	}

}
