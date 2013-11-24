package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * A contact model from the form data.
 */
@Entity
public class Contact extends Model {
  private static final long serialVersionUID = 1L;
  
  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;
  private String telephoneType;
  
  // Many Contacts maps to one UserInfo.
  @ManyToOne
  private UserInfo userInfo;
  
  /**
   * Constructor.
   * @param firstName First name.
   * @param lastName Last name.
   * @param telephone Telephone.
   * @param address Address.
   * @param telephoneType Telephone type.
   */
  public Contact(String firstName, String lastName, String telephone, String address,
                 String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.address = address;
    this.telephoneType = telephoneType;
  }

  /**
   * Get first name.
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set first name.
   * @param firstName Name to be set to.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get last name.
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set last name.
   * @param lastName The last name to be set to.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get telephone.
   * @return The telephone.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Set telephone.
   * @param telephone Telephone number to be set to.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Return ID.
   * @return The ID.
   */
  public Long getID() {
    return id;
  }

  /**
   * Set the ID.
   * @param id ID to be set.
   */
  public void setID(Long id) {
    this.id = id;
  }

  /**
   * Return the address.
   * @return The address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set the address.
   * @param address The address to set to.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Return the telephone type.
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Set telephone type.
   * @param telephoneType The telephone type to be set.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  
  /**
   * The EBean ORM finder method for database queries on ID.
   * @return The finder method for products.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }
}
