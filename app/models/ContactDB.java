package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Stores a list of contacts in a data structure.
 */
public class ContactDB {

  private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();

  /**
   * Add contact.
   * 
   * @param dataForm Data form data.
   * @return The contact created.
   */
  public static Contact addContact(String user, ContactFormData dataForm) {
    long id = (dataForm.id == 0) ? contacts.size() + 1 : dataForm.id;
    Contact contact = new Contact(id, dataForm.firstName, dataForm.lastName, 
                                  dataForm.address, dataForm.telephone, dataForm.telephoneType);
    
    if(!contacts.containsKey(user)) {
      contacts.put(user, new HashMap<Long, Contact>());
    }
    
    contacts.get(user).put(id, contact);
    return contact;
  }

  /**
   * Return list of contacts.
   * 
   * @return List of contacts.
   */
  public static List<Contact> getContacts(String user) {
    if (!isUser(user)) {
      return null;
    }
    return new ArrayList<Contact>(contacts.get(user).values());
  }
  
  /**
   * Check if the user is a user.
   * @param user User to check.
   * @return True if the user exists, false otherwise. 
   */
  public static boolean isUser(String user) {
    return contacts.containsKey(user);
  }

  /**
   * Return contact with matching ID.
   * 
   * @param id The ID to be matched.
   * @return The contact with the matching ID.
   */
  public static Contact getContact(String user, long id) {
    if (!isUser(user)) {
      throw new RuntimeException("User is not valid.");
    }
    Contact contact = contacts.get(user).get(id);
    if (contact == null) {
      throw new RuntimeException("Contact ID is not valid.");
    }
    else {
      return contact;
    }
  }

  /**
   * Delete a contact.
   * 
   * @param id ID of contact.
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
  }

}
