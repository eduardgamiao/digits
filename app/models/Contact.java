package models;

/**
 * Implements a contact data object.
 */
public class Contact {
  
  /** ID Field. */
  private long id;
  
  /** First name. */
  private String firstName;  
  
  /** First name. */
  private String lastName;  
  
  /** First name. */
  private String telephone;

  /**
   * Constructor.
   * @param first First name.
   * @param last  Last name.
   * @param tele  Telephone.
   */
  public Contact(long id, String first, String last, String tele) {
    this.id = id;
    this.firstName = first;
    this.lastName = last;
    this.telephone = tele;
  }
  
  /**
   * Get first name.
   * @return First name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set first name.
   * @param firstName The name to be set.
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
   * @param lastName Last name to be set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get the telephone number.
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Set telephone number.
   * @param telephone The telephone number to be set.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Return ID of contact.
   * @return The ID of contact.
   */
  public long getID() {
    return id;
  }

  /**
   * Set ID of contact.
   * @param id The ID to set of contact.
   */
  public void setID(long id) {
    this.id = id;
  }
  

}
