import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Initialization for Play.
 * 
 * @author eduardgamiao
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Initialization methods.
   * 
   * @param app An application.
   */
  public void onStart(Application app) {
    ContactDB
        .addContact(new ContactFormData("Eduard", "Gamiao", "111-111-1111", "1234567890123456789012345", "Mobile"));
    ContactDB.addContact(new ContactFormData("John", "Doe", "I do not have.", "!!!!!!!!!!!!!!!!!!!!!!!!!", "Home"));
    ContactDB.addContact(new ContactFormData("El", "Diablo", "666-666-6666", "6666666666666666666666666", "Work"));
    ContactDB.addContact(new ContactFormData("Je suis", "fatigué", "un un un un", "vingt-cinq vingt-cinq vingt-cinq",
        "Mobile"));
  }

}
