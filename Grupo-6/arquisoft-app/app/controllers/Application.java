package controllers;


import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import model.Doctor;
import play.data.Form;
import play.db.jpa.JPA;
import play.mvc.*;
import views.formdata.LoginFormData;
import views.html.*;

public class Application extends Controller {

	
//    public static Result index() {
//        return ok(index.render("CODE PIMP"));
//    }
//    


	@play.db.jpa.Transactional
    public static Result sayHello()
    {
    	Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(Paciente.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d)));
    }
	
	


	/**
	 * Provides the Index page.
	 * @return The Index page. 
	 */
	
	@play.db.jpa.Transactional
	public static Result index() 
	{
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		return ok(index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d)));
	}

	/**
	 * Provides the Login page (only to unauthenticated users). 
	 * @return The Login page. 
	 */
	@play.db.jpa.Transactional
	public static Result login() 
	{
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
		{
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
			
		}

		Form<LoginFormData> formData = Form.form(LoginFormData.class);
		return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d), formData));
	}

	/**
	 * Processes a login form submission from an unauthenticated user. 
	 * First we bind the HTTP POST data to an instance of LoginFormData.
	 * The binding process will invoke the LoginFormData.validate() method.
	 * If errors are found, re-render the page, displaying the error data. 
	 * If errors not found, render the page with the good data. 
	 * @return The index page with the results of validation. 
	 */
	@play.db.jpa.Transactional
	public static Result postLogin() {
		Doctor d=null;

		if(Secured.isLoggedIn(ctx()))
			d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));

		// Get the submitted form data from the request object, and run validation.
		Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

		if (formData.hasErrors()) {
			flash("error", "Usuario o contrasena invalida.");
			return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d), formData));
		}
		else {
			// email/password OK, so now we set the session variable and only go to authenticated pages.
			session().clear();
			session("email", formData.get().email);
			return redirect(routes.Application.index());
		}
	}

	/**
	 * Logs out (only for authenticated users) and returns them to the Index page. 
	 * @return A redirect to the Index page. 
	 */
	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}

	/**
	 * Provides the Profile page (only to authenticated users).
	 * @return The Profile page. 
	 */
	
	@Security.Authenticated(Secured.class)
	@play.db.jpa.Transactional
	public static Result profile() {
		Doctor d=JPA.em().find(Doctor.class, Secured.getUser(ctx()));
		return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx(),d)));
	}


}
