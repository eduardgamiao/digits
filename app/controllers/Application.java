package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.Login;
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
    return ok(Index.render(ContactDB.getContacts(Secured.getUser(ctx())), 
        "Index", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Returns new contact, a page for new contacts.
   * @param id ID of the contact.
   * @return The newcontact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == -1) ? new ContactFormData() 
      : new ContactFormData(ContactDB.getContact(Secured.getUser(ctx()), id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);    
    return ok(NewContact.render(formData, telephoneTypeMap, 
        "New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
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
      return badRequest(NewContact.render(formData, telephoneTypeMap, 
          "New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    else {
      ContactFormData form = formData.get();
      ContactDB.addContact(Secured.getUser(ctx()), form);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(form.telephoneType);      
      return ok(NewContact.render(formData, telephoneTypeMap, 
          "New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
  }
  
  /**
   * Delete a contact.
   * @param id ID of contact to delete.
   * @return Index page after deletion.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(Secured.getUser(ctx()), id);
    return ok(Index.render(ContactDB.getContacts(Secured.getUser(ctx())), 
        "Index", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
