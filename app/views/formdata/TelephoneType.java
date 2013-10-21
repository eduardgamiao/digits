package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for types of telephones.
 * @author eduardgamiao
 *
 */
public class TelephoneType {
  
  private static String [] types = {"Home", "Work", "Mobile"};
  
  /**
   * Get types of telephones.
   * @return A mapping of types of telephones.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> telephoneMap = new HashMap<String, Boolean>();    
    for (String current : types) {
      telephoneMap.put(current, false);
    }
    
    return telephoneMap;
  }
  
  /**
   * Return types of telephones.
   * @param key The type of telephone.
   * @return Types of telephones.
   */
  public static Map<String, Boolean> getTypes(String key) {
    Map<String, Boolean> typeMap = TelephoneType.getTypes();
    if (isType(key)) {
      typeMap.put(key, true);
    }
    return typeMap;
  }
  
  /**
   * Checks if a telephone is a valid type.
   * @param key The type of telephone.
   * @return True if the telephone type is valid, false otherwise.
   */
  public static boolean isType(String key) {
    return TelephoneType.getTypes().keySet().contains(key);
  }

}
