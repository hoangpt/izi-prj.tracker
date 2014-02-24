package controllers.plugin;

import controllers.routes;
import models.Project;
import models.Task;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;

/**
 * Securator for access page
 * @author hoangpt
 */
public class Securator extends Security.Authenticator {
  @Override
  public String getUsername(Http.Context ctx) {
    return ctx.session().get("email");
  }

  @Override
  public Result onUnauthorized(Http.Context ctx) {
    return Results.redirect(routes.Application.login());
  }

  // Access rights

  public static boolean isMemberOf(Long projectId) {
    return Project.isMember(
      projectId,
      Http.Context.current().request().username()
    );
  }

  public static boolean isOwnerOf(Long task) {
    return Task.isOwner(
      task,
      Http.Context.current().request().username()
    );
  }
}
