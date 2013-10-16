package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Stores a list of contacts in a data structure.
 */
public class ContactDB {

  static List<Contact> contacts = new ArrayList<Contact>();
  
  /**
   * Add contact.
   * @param dataForm Data form data.
   * @return The contact created.
   */
  public static Contact addContact(ContactFormData dataForm) {
    Contact contact = new Contact(dataForm.firstName, dataForm.lastName, dataForm.telephone);
    contacts.add(contact);
    return contact;
  }
  
  /**
   * Return list of contacts.
   * @return List of contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
  
}
