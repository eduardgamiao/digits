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

  private static Map<String, HashMap<Long, Contact>> contacts = new HashMap<String, HashMap<Long, Contact>>();

  /**
   * Add contact.
   * 
   * @param email The email of the user.
   * @param dataForm Data form data.
   * @return The contact created.
   */
  public static Contact addContact(String email, ContactFormData dataForm) {
    System.out.println(dataForm.id + " -> " + contacts.size());
    long id = (dataForm.id == 0) ? contacts.size() + 1 : dataForm.id;
    Contact contact =
        new Contact(id, dataForm.firstName, dataForm.lastName, dataForm.telephone, dataForm.address,
            dataForm.telephoneType);
    if (!isUser(email)) {
      contacts.put(email, new HashMap<Long, Contact>());
    }
    contacts.get(email).put(contact.getID(), contact);
    return contact;
  }

  /**
   * Check if user is in database.
   * 
   * @param email The email of the user.
   * @return True if the user is in the database, false otherwise.
   */
  public static boolean isUser(String email) {
    return contacts.containsKey(email);
  }

  /**
   * Return list of contacts.
   * @param email The email of the user.
   * @return List of contacts.
   */
  public static List<Contact> getContacts(String email) {
    if (!isUser(email)) {
      return null;
    }
    return new ArrayList<Contact>(contacts.get(email).values());
  }

  /**
   * Return contact with matching ID.
   * @param email The email of the user.
   * @param id The ID to be matched.
   * @return The contact with the matching ID.
   */
  public static Contact getContact(String email, long id) {
    if (!isUser(email)) {
      throw new RuntimeException("User is not valid.");      
    }
    Contact contact = contacts.get(email).get(id);
    if (contact == null) {
      throw new RuntimeException("Contact ID is not valid.");
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
    contacts.get(email).remove(id);
  }

}
