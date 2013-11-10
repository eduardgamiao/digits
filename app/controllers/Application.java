package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * 
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns new contact, a page for new contacts.
   * @param id ID of the contact.
   * @return The newcontact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);    
    return ok(NewContact.render(formData, telephoneTypeMap));
  }

  /**
   * Returns new contact, a page for new contacts.
   * 
   * @return The newcontact.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap));
    }
    else {
      ContactFormData form = formData.get();
      ContactDB.addContact(form);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(form.telephoneType);      
      return ok(NewContact.render(formData, telephoneTypeMap));
    }
  }
  
  /**
   * Delete a contact.
   * @param id ID of contact to delete.
   * @return Index page after deletion.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
}
