package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns new conact, a page for new contacts.
   * @return The new contact.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
    
  }
  
  /**
   * Returns post conact, a page after contact form is submitted.
   * @return The post contact.
   */
  public static Result postContact() {
    System.out.println("In post contact");
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    ContactFormData form = formData.get();
    System.out.format("%s %s %n%s", form.firstName, form.lastName, form.telephone);
    return ok(NewContact.render(formData));
  }
}
