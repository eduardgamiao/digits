import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.ContactFormData;

/**
 * Global class for Play Framework.
 */
public class Global extends GlobalSettings {

  /**
   * Defines an initialization method.
   * @param app An application.
   */
  public void onStart(Application app) {
    String adminEmail = Play.application().configuration().getString("admin.email");
    String adminPassword = Play.application().configuration().getString("admin.password");    
    
    UserInfoDB.defineAdmin("Administrator", adminEmail, adminPassword);
    
    if (UserInfoDB.adminDefined() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()) {
      ContactDB.addContact(adminEmail, 
          new ContactFormData("Eduard", "Smith", "111-111-1111", "1234567890123456789012345", "Home"));
      ContactDB.addContact(adminEmail, 
          new ContactFormData("John", "Smith", "222-222-2222", "1234567890123456789012345", "Work"));
    }
  }
}
