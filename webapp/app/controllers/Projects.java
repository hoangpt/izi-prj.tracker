package controllers;

import controllers.plugin.Securator;
import models.Project;
import models.Task;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.projects.index;

/**
 * Manage projects related operation
 *
 * @author hoangpt
 */
@Security.Authenticated(Securator.class)
public class Projects extends Controller {

  public static Result index() {
    return ok(
      index.render(
        Project.findProjectbyUser(request().username()),
        Task.findTaskByUser(request().username()),
        User.finder.byId(request().username())
      )
    );
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
