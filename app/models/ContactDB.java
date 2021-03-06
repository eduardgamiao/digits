package models;

import java.util.List;
import views.formdata.ContactFormData;

/**
 * Stores a list of contacts in a data structure.
 */
public class ContactDB {
  /**
   * Add contact.
   * 
   * @param email The email of the user.
   * @param dataForm Data form data.
   */
  public static void addContact(String email, ContactFormData dataForm) {
    // Check if contact is new.
    boolean isNewContact = (dataForm.id == -1);
    if (isNewContact) {
    Contact contact =
        new Contact(dataForm.firstName, dataForm.lastName, dataForm.telephone, dataForm.address,
            dataForm.telephoneType);
    UserInfo userInfo = UserInfo.find().where().eq("email", email).findUnique();
    if (userInfo == null) {
      throw new RuntimeException("Could not find user: " + email);
    }
    userInfo.addContact(contact);
    contact.setUserInfo(userInfo);
    userInfo.save();
    contact.save();
    }
    else {
      Contact contact = Contact.find().byId(dataForm.id);
      contact.setFirstName(dataForm.firstName);
      contact.setLastName(dataForm.lastName);
      contact.setTelephone(dataForm.telephone);
      contact.setTelephoneType(dataForm.telephoneType);
      contact.setAddress(dataForm.address);
      contact.save();
    }
  }

  /**
   * Check if user is in database.
   * 
   * @param email The email of the user.
   * @return True if the user is in the database, false otherwise.
   */
  public static boolean isUser(String email) {
    return (UserInfo.find().where().eq("email", email).findUnique() != null);
  }

  /**
   * Return list of contacts.
   * @param email The email of the user.
   * @return List of contacts.
   */
  public static List<Contact> getContacts(String email) {
    UserInfo userInfo = UserInfo.find().where().eq("email", email).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }

  /**
   * Return contact with matching ID.
   * @param email The email of the user.
   * @param id The ID to be matched.
   * @return The contact with the matching ID.
   */
  public static Contact getContact(String email, long id) {
    Contact contact = Contact.find().byId(id);    
    if (contact == null) {
      throw new RuntimeException("Contact not found.");      
    }
    UserInfo userInfo = contact.getUserInfo();
    if (!email.equals(userInfo.getEmail())) {
      throw new RuntimeException("Email does not match Contact email.");
    }
    else {
      return contact;
    }
  }

  /**
   * Delete a contact.
   * @param email The email of the user.
   * @param id ID of contact.
   */
  public static void deleteContact(String email, long id) {
    UserInfo userInfo = UserInfo.find().where().eq("email", email).findUnique();
    Contact contact = Contact.find().byId(id);
    userInfo.getContacts().remove(contact);
    contact.setUserInfo(null);
    userInfo.save();
    contact.delete();
  }

}
