import models.ContactDB;
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
    ContactDB.addContact(new ContactFormData("Eduard", "Gamiao", "111-111-1111", "1234567890123456789012345", "Home"));
    ContactDB.addContact(new ContactFormData("John", "Doe", "222-222-2222", "1234567890123456789012345", "Work"));
    ContactDB.addContact(new ContactFormData("Jane", "Doe", "333-333-3333", "1234567890123456789012345", "Mobile"));
    ContactDB.addContact(new ContactFormData("The", "Person", "123-456-7890", "1234567890123456789012345", "Home"));  
  }
}
