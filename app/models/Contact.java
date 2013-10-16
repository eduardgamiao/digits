package models;

/**
 * A contact model from the form data.
 */
public class Contact {

  /** First name. */
  private String firstName;
  
  /** Last name. */
  private String lastName;
  
  /** Telehone. */
  private String telephone;
  
  /**
   * Constructor.
   * @param firstName First name.
   * @param lastName Last name.
   * @param telephone Telephone.
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
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
}
