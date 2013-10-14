package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Stores data from contact form.
 */
public class ContactFormData {
  private static final int TELEPHONE_INPUT_SIZE = 12;
  
  /** First name field. */
  public String firstName = "";
  
  /** Last name field. */
  public String lastName = "";
  
  /** Telephone field. */
  public String telephone = "";
  
  /**
   * Validates contact form input.
   * @return A list of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First Name is required."));
    }
    else if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last Name is required."));
    }
    else if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    else if (telephone.length() != TELEPHONE_INPUT_SIZE) {
      errors.add(new ValidationError("telephone", "Telephone must be formatted as xxx-xxx-xxxx."));
    }
    
    return errors.isEmpty() ? null : errors;
  }

}
