package controllers;

import controllers.plugin.Securator;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Manage projects related operation
 *
 * @author hoangpt
 */
@Security.Authenticated(Securator.class)
public class Projects extends Controller {

  public static Result index() {
    return TODO;
  }

  public static Result add() {
    return TODO;
  }

  public static Result delete(Long projectId) {
    return TODO;
  }

  public static Result rename(Long projectId) {
    return TODO;
  }
}
