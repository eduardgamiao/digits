package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the types of telephones in the form.
 * @author eduardgamiao
 *
 */
public class TelephoneTypes {

   private static String [] types = {"Home", "Work", "Mobile"};
   
   /**
    * Return a mapping of the types of telephones.
    * @return A mapping of telephone types.
    */
   public static Map<String, Boolean> getTypes() {
     Map<String, Boolean> telephoneMap = new HashMap<String, Boolean>();
     for (String type : types) {
       telephoneMap.put(type, false);
     }
     return telephoneMap;
   }
   
   /**
    * Return a mapping of the types of telephones.
    * @param type The type of phone.
    * @return A mapping of telephone types.
    */
   public static Map<String, Boolean> getTypes(String type) {
     Map<String, Boolean> telephoneMap = TelephoneTypes.getTypes();
     if (isType(type)) {
       telephoneMap.put(type, true);
     }
     return telephoneMap;
   }
   
   /**
    * Check if the telephone type is valid.
    * @param type The type to check.
    * @return True if the type is valid, false otherwise. 
    */
   public static Boolean isType(String type) {
     return TelephoneTypes.getTypes().containsKey(type);
   }
   
}
