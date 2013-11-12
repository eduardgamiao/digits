package controllers;

import java.util.Map;
import models.ContactDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.RegistrationFormData;
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
  @Security.Authenticated(Secured.class)
  public static Result index() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    return ok(Index.render(ContactDB.getContacts(userInfo.getEmail()), isLoggedIn, userInfo));
  }

  /**
   * Returns new contact, a page for new contacts.
   * @param id ID of the contact.
   * @return The newcontact.
   */
  @Security.Authenticated(Secured.class)
  public static Result newContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    ContactFormData data = (id == 0) ? new ContactFormData() 
                                       : new ContactFormData(ContactDB.getContact(userInfo.getEmail(), id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render(formData, telephoneTypeMap, isLoggedIn, userInfo));
  }

  /**
   * Returns new contact, a page for new contacts.
   * 
   * @return The newcontact.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    if (formData.hasErrors()) {
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap, isLoggedIn, userInfo));
    }
    else {
      ContactFormData form = formData.get();
      ContactDB.addContact(userInfo.getEmail(), form);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(form.telephoneType);
      return ok(NewContact.render(formData, telephoneTypeMap, isLoggedIn, userInfo));
    }
  }
  
  /**
   * Delete a contact.
   * @param id ID of contact to delete.
   * @return Index page after deletion.
   */
  public static Result deleteContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts(userInfo.getEmail()), isLoggedIn, userInfo));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class);
    Form<RegistrationFormData> registrationFormData = Form.form(RegistrationFormData.class);
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    return ok(Login.render("Login", isLoggedIn, userInfo, 
              loginFormData, registrationFormData));
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
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class).bindFromRequest();
    Form<RegistrationFormData> registrationFormData = Form.form(RegistrationFormData.class).bindFromRequest();
    
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    boolean isLoggedIn = (userInfo != null);
    
    if (loginFormData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", isLoggedIn, userInfo, 
                        loginFormData, registrationFormData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", loginFormData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postRegistration() {
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class).bindFromRequest();
    Form<RegistrationFormData> registrationFormData = Form.form(RegistrationFormData.class).bindFromRequest();
    
    if (registrationFormData.hasErrors()) {
      UserInfo userInfo = UserInfoDB.getUser(request().username());
      boolean isLoggedIn = (userInfo != null);
      flash("error", "Registration error.");
      return badRequest(Login.render("Login", isLoggedIn, userInfo, 
                        loginFormData, registrationFormData));     
    }
    else {
      RegistrationFormData form = registrationFormData.get();
      UserInfoDB.addUserInfo(form.name, form.email, form.password);
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
