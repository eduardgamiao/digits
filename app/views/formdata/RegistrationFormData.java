package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;
import play.data.validation.ValidationError;

/**
 * Form data for registration.
 */
public class RegistrationFormData {
  
  /** User name. */
  public String name = "";
  
  /** User email. */
  public String email = "";
  
  /** User password. */
  public String password = "";
  
  /**
   * Empty constructor.
   */
  public RegistrationFormData() {
    
  }
  
  /**
   * Constructor.
   * @param name User name.
   * @param email User email.
   * @param password User password.
   */
  public RegistrationFormData(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * Validate form data.
   * @return If there are errors, a list of errors, otherwise null.
   */
  public List<ValidationError> validate() {
    ArrayList<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (this.name == "" || this.name == null) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    if (this.email == "" || this.email == null) {
      errors.add(new ValidationError("email", "Email is required."));
    }
    if (UserInfoDB.isUser(this.email)) {
      errors.add(new ValidationError("email", "The email is already taken."));      
    }
    if (this.password == "" || this.password == null) {
      errors.add(new ValidationError("password", "Password is required."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
