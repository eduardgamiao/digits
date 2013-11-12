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
   * @param app An application.
   */
  public void onStart(Application app) {
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    ContactDB.addContact("smith@example.com", new ContactFormData("Eduard", "Gamiao", "111-111-1111", "1234567890123456789012345", "Home"));
    ContactDB.addContact("smith@example.com", new ContactFormData("John", "Smith", "222-222-2222", "1234567890123456789012345", "Work"));
    
    UserInfoDB.addUserInfo("Eduard Gamiao", "eduard@hawaii.edu", "password");
    ContactDB.addContact("eduard@hawaii.edu", new ContactFormData("Jane", "Doe", "333-333-3333", "1234567890123456789012345", "Mobile"));
    ContactDB.addContact("eduard@hawaii.edu", new ContactFormData("The", "Person", "123-456-7890", "1234567890123456789012345", "Home"));
  }
}
