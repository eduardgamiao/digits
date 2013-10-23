package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hobby types for hobby checkboxes.
 * @author eduardgamiao
 *
 */
public class HobbyType {
  
  private static String [] hobbies = {"Reading", "Music", "Television", "Other"};
  
  /**
   * Return a mapping of the typed of hobbies.
   * @return A mapping of hobby types.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> hobbyMap = new HashMap<String, Boolean>();
    for (String type : hobbies) {
      hobbyMap.put(type, false);
    }
    return hobbyMap;
  }
  
  /**
   * Return a mapping of hobbies.
   * @param hobbyList The list of hobbies.
   * @return A mapping of telephone types.
   */
  public static Map<String, Boolean> getTypes(List<String> hobbyList) {
    Map<String, Boolean> hobbyMap = HobbyType.getTypes();
    for (String currentHobby : hobbies) {
      if (hobbyList.contains(currentHobby)) {
        hobbyMap.put(currentHobby, true);
      }
    }
    return hobbyMap;
  }
  
  /**
   * Checks if the hobby is a valid hobby.
   * @param hobby The hobby to check.
   * @return True if it is valid, false otherwise.
   */
  public static Boolean isHobby(String hobby) {
    return HobbyType.getTypes().keySet().contains(hobby);
  }

}
