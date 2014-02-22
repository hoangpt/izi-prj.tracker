package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client extends Model {
    @Id
    Long id;
    @Constraints.Required
    String name;
    String phone;
    String address;
    Date createAt;
    Integer taxNr;

    //account support
    String supportName;
    String supportPass;

    //information of chef
    String chefName;
    String chefEmail;
    String chefPhone;

    public Client(Long id, String name, String phone, String address,
                  Date createAt, Integer taxNr, String supportName,
                  String supportPass, String chefName, String chefEmail, String chefPhone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.taxNr = taxNr;
        this.supportName = supportName;
        this.supportPass = supportPass;
        this.chefName = chefName;
        this.chefEmail = chefEmail;
        this.chefPhone = chefPhone;
    }
}
