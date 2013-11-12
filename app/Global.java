import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Global class for Play Framework.
 * @author eduardgamiao
 *
 */
public class Global extends GlobalSettings {

  /**
   * Defines an initialization method.
   * @param app An applcation.
   */
  public void onStart(Application app) {
    UserInfoDB.addUserInfo("John Smith", "john@example.com", "password");
    UserInfoDB.addUserInfo("Jane Smith", "jane@example.com", "password");
    
    ContactDB.addContact("john@example.com", new ContactFormData("Eduard", "Smith", "111-111-1111", "1234567890123456789012345", "Home"));
    ContactDB.addContact("john@example.com", new ContactFormData("John", "Smith", "222-222-2222", "1234567890123456789012345", "Work"));
    ContactDB.addContact("jane@example.com", new ContactFormData("Jane", "Doe", "333-333-3333", "1234567890123456789012345", "Mobile"));
    ContactDB.addContact("jane@example.com", new ContactFormData("Jane", "Person", "123-456-7890", "1234567890123456789012345", "Home")); 
  }
}
