package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Implements contact form data.
 */
public class ContactFormData {

  private static final int TELEPHONE_LENGTH = 12;
  private static final int ADDRESS_LENGTH = 25;

  /** First name. */
  public String firstName = "";

  /** Last name. */
  public String lastName = "";

  /** Telephone. */
  public String telephone = "";
  
  /** Telephone type. */
  public String telephoneType = "";
  
  /** ID number. */
  public long id = 0;
  
  /** Address. */
  public String address = "";
  
  /**
   * Constructor.
   */
  public ContactFormData() {
    
  }
  
  /**
   * @param firstName First name.
   * @param lastName Last name.
   * @param telephone Telephone.
   * @param telephoneType Telephone type.
   * @param address Address.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.address = address;
  }

  /**
   * Constructor.
   * @param contact Contact to be stored in DB.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getID();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.address = contact.getAddress();
    this.telephoneType = contact.getTelephoneType();
  }

  /**
   * Validation of form input.
   * 
   * @return List of errors.
   */
  public List<ValidationError> validate() {
    ArrayList<ValidationError> errors = new ArrayList<ValidationError>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    if (telephone.length() != TELEPHONE_LENGTH) {
      errors.add(new ValidationError("telephone", "Telephone must be formatted as xxx-xxx-xxxx."));
    }
    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address is required."));
    }
    if (address.length() < ADDRESS_LENGTH) {
      errors.add(new ValidationError("address", "Address must be at least 25 characters."));
    }
    if (!(TelephoneType.isType(telephoneType))) {
      errors.add(new ValidationError("telephoneType", "Telephone type is not valid"));
    }

    return errors.isEmpty() ? null : errors;
  }
}
