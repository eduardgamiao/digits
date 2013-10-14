package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Stores data from contact form.
 */
public class ContactFormData {
  private static final int TELEPHONE_INPUT_SIZE = 12;
  private static final int ADDRESS_INPUT_SIZE = 25;

  
  /** ID field */
  public long id = 0;
  
  /** First name field. */
  public String firstName = "";
  
  /** Last name field. */
  public String lastName = "";
  
  /** Telephone field. */
  public String telephone = "";
  
  /** Address field. */
  public String address = "";
  
  /** Constructor. */
  public ContactFormData() {
    
  }
  
  /** Contructor */
  public ContactFormData(Contact contact) {
    this.id = contact.getID();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.address = contact.getAddress();
  }
  
  /**
   * Validates contact form input.
   * @return A list of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First Name is required."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last Name is required."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    if (telephone.length() != TELEPHONE_INPUT_SIZE) {
      errors.add(new ValidationError("telephone", "Telephone must be formatted as xxx-xxx-xxxx."));
    }
    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address is required."));
    }
    if (address.length() <= ADDRESS_INPUT_SIZE) {
      errors.add(new ValidationError("address", "Address must be at least 25 characters long.")); 
    }
    
    return errors.isEmpty() ? null : errors;
  }

}
