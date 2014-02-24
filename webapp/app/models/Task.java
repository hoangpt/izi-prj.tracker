package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by hoangpt on 2/24/14.
 *
 * @author hoangpt
 */
@Entity
public class Task extends Model {
  @Id
  Long id;
  @Constraints.Required
  String name;
  boolean isDone = false;
  @Formats.DateTime(pattern = "dd/MM/yy")
  Date dueDate;
  @ManyToOne
  User assignTo;
  @ManyToOne
  Project project;
  String folder;


  public static boolean isOwner(Long task, String username) {
    return true;
  }

  public static List<Task> findTaskByUser(String username) {
    return null;
  }
}
