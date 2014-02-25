package controllers;

import controllers.plugin.Securator;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Manage clients related operation
 *
 * @author hoangpt
 */
@Security.Authenticated(Securator.class)
public class Clients extends Controller {

  public static Result index() {
    return ok(
      views.html.clients.index.render(User.finder.byId(request().username()))
    );
  }

  public static Result add() {
    return TODO;
  }

  public static Result delete(Long clientId) {
    return TODO;
  }

  public static Result rename(Long clientId) {
    return TODO;
  }
}
