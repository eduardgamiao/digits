package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Implements a contact database.
 */
public class ContactDB {
  /** Stores mapping of Contacts. */
  private static HashMap<Long, Contact> contactMap = new HashMap<Long, Contact>();
  
  /**
   * Adds contact to contact database.
   * @param data Data about a contact.
   */
  public static void addContact(ContactFormData data) {
    Contact contact;
    if(data.id == 0) {
      long id = contactMap.size() + 1;
      contact = new Contact(id, data.firstName, data.lastName, data.telephone);
      contactMap.put(id, contact);
    }
    else {
      contact = new Contact(data.id, data.firstName, data.lastName, data.telephone);
      contactMap.put(contact.getID(), contact);
    }
  }
  
  /**
   * Return a list of contacts.
   * @return A list of contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<Contact>(contactMap.values());
  }
  
  public static Contact getContact(long id) {
    Contact contact = contactMap.get(id);
    if(contact == null) {
      throw new RuntimeException("ID is not valid.");
    }
    else {
      return contactMap.get(id);
    }
  }

}
