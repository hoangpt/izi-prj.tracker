package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * use entity framework for ORM
 *  @author nghia
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

    Date startAt;
    Date endAt;

    Boolean isActive;
    Boolean isDeleted;
}
