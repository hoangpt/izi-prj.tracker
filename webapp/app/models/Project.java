package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * use entity framework for ORM
 */
@Entity
public class Project extends Model {
  @Id
  Long id;
  @Constraints.Required
  String name;
  @ManyToOne
  @Constraints.Required
  Client client;
  @Formats.DateTime(pattern = "dd/MM/yy")
  Date startAt;
  @Formats.DateTime(pattern = "dd/MM/yy")
  Date endAt;
  Boolean isActive;
  Boolean isDeleted;

  public Project(Long id, String name, Client client) {
    this.id = id;
    this.name = name;
    this.client = client;
  }

  public Project(Long id, String name, Client client,
                 Date startAt, Date endAt, Boolean isActive, Boolean isDeleted) {
    this.id = id;
    this.name = name;
    this.client = client;
    this.startAt = startAt;
    this.endAt = endAt;
    this.isActive = isActive;
    this.isDeleted = isDeleted;
  }

  public static boolean isMember(Long projectId, String username) {
    return true;
  }

  public static List<Project> findProjectbyUser(String username) {
    List<Project> projectsUser = new ArrayList<Project>();
    Client c = new Client(1l, "Testcl1");
    Project p1 = new Project(1l, "Testprj1", c);
    projectsUser.add(p1);

    return projectsUser;
  }
}
