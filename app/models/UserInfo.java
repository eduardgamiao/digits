package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model.Finder;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo {
  private static final long serialVersionUID = 1L;
 
  private String name;
  private String email;
  private String password;
  @Id
  private Long id;
  
  @OneToMany(mappedBy = "userInfo", cascade = CascadeType.PERSIST)
  private Contact contact;
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * The EBean ORM finder method for database queries on emails.
   * @return The finder method for products.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
  }
  

}
