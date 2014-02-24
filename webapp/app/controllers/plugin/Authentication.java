package controllers.plugin;

import models.User;

/**
 * Authentication plugin
 *
 * @author hoangpt
 */
public class Authentication {
  public String email;
  public String password;

  public String validate() {
    if (User.authenticate(email, password) == null) {
      return "Invalid user or password";
    }

    return null;
  }

}
