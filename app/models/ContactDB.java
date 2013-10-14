package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Implements a contact database.
 */
public class ContactDB {
  
  /** Stores contact information. */
  private static List<Contact> contactList = new ArrayList<Contact>();;
  
  /**
   * Adds contact to contact database.
   * @param data Data about a contact.
   */
  public static void addContact(ContactFormData data) {
    contactList.add(new Contact(data.firstName, data.lastName, data.telephone));
    System.out.println(contactList.size());
  }
  
  /**
   * Return a list of contacts.
   * @return A list of contacts.
   */
  public static List<Contact> getContacts() {
    return contactList;
  }

}
