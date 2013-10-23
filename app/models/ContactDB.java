package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Stores a list of contacts in a data structure.
 */
public class ContactDB {

  private static HashMap<Long, Contact> contacts = new HashMap<Long, Contact>();

  /**
   * Add contact.
   * 
   * @param dataForm Data form data.
   * @return The contact created.
   */
  public static Contact addContact(ContactFormData dataForm) {
    Contact contact;
    if (dataForm.id == 0) {
      long id = contacts.size() + 1;
      contact =
          new Contact(id, dataForm.firstName, dataForm.lastName, dataForm.telephone, dataForm.address,
              dataForm.telephoneType, dataForm.hobbies);
      contacts.put(id, contact);
      return contact;
    }
    else {
      contact =
          new Contact(dataForm.id, dataForm.firstName, dataForm.lastName, dataForm.telephone, dataForm.address,
              dataForm.telephoneType, dataForm.hobbies);
      contacts.put(contact.getID(), contact);
      return contact;
    }
  }

  /**
   * Return list of contacts.
   * 
   * @return List of contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<Contact>(contacts.values());
  }

  /**
   * Return contact with matching ID.
   * 
   * @param id The ID to be matched.
   * @return The contact with the matching ID.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
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
