package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Implements contact form data.
 */
public class ContactFormData {

  private static final int TELEPHONE_LENGTH = 12;

  /** First name. */
  public String firstName = "";

  /** Last name. */
  public String lastName = "";

  /** Telephone. */
  public String telephone = "";

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

    return errors.isEmpty() ? null : errors;
  }
}
