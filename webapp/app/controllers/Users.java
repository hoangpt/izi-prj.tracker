package controllers;

import controllers.plugin.Securator;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

/**
 * Manage clients related operation
 *
 * @author hoangpt
 */
@Security.Authenticated(Securator.class)
public class Users extends Controller {

  static User loginUser = User.finder.byId(request().username());

  public static Result index() {
    List<User> users = User.findAll();

    return ok(
      views.html.users.index.render(
        loginUser,
        users
      )
    );
  }

  public static Result add() {
    return TODO;
  }

  public static Result delete(String email) {
    User user = User.finder.ref(email);
    System.out.println(user);
    user.delete();

    return redirect(routes.Users.index());
  }

  public static Result edit(String email) {
    List<User> users = User.findAll();
    User user = User.findByEmail(email);

    return ok(views.html.users.edit.render(loginUser, user, users));
  }

  public static Result view(String email) {
    List<User> users = User.findAll();
    User user = User.findByEmail(email);

    return ok(views.html.users.edit.render(loginUser, user, users));
  }
}
