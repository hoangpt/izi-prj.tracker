package controllers;

import controllers.plugin.Securator;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard;

/**
 * Manage clients related operation
 *
 * @author hoangpt
 */
@Security.Authenticated(Securator.class)
public class Dashboard extends Controller {

  public static Result index() {
    return ok(
      dashboard.render(User.finder.byId(request().username()))
    );
  }
}
