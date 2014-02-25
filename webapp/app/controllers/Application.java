package controllers;

import controllers.plugin.Authentication;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

import static play.data.Form.form;

public class Application extends Controller {

  /**
   * default page
   *
   * @return
   */
  public static Result index() {
    return redirect(routes.Projects.index());
  }

  /**
   * login page
   * @return
   */
  public static Result login() {
    return ok(
      login.render(
        Form.form(Authentication.class)
      )
    );
  }

  /**
   * authenticate post
   * @return
   */
  public static Result authenticate() {
    Form<Authentication> loginForm = Form.form(Authentication.class).bindFromRequest();
    if (loginForm.hasErrors()) {
      return badRequest(login.render(loginForm));
    } else {
      session("email", loginForm.get().email); //save to session
      return redirect(
        routes.Dashboard.index()
      );
    }
  }

  /**
   * logout page
   * @return
   */
  public static Result logout() {
    session().clear(); //remove session
    flash("success_logout", "You've been logged out");
    return redirect(
      routes.Application.login()
    );
  }
}
