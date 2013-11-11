package models;

import java.util.HashMap;
import java.util.Map;

/**
 * A database of UserInfos.
 */
public class UserInfoDB {
  
  private static Map<String, UserInfo> userInfos = new HashMap<String, UserInfo>();
  
  /**
   * Add user to the database.
   * @param name Name of user.
   * @param email Email of user.
   * @param password Password of user.
   */
  public static void addUserInfo(String name, String email, String password) {
   userInfos.put(email, new UserInfo(name, email, password)); 
  }
  
  /**
   * Return user with the specified email.
   * @param email Email of the user.
   * @return The user with the specified email.
   */
  public static UserInfo getUser(String email) {
    return userInfos.get((email == null) ? "" : email);
  }
  
  /**
   * Check if a user is part of the database.
   * @param email Email of user.
   * @return True if the user exists, false otherwise.
   */
  public static boolean isUser(String email) {
    return userInfos.containsKey(email);
  }
  
  /**
   * Check if a user is valid.
   * @param email Email of user.
   * @param password Password of user.
   * @return True if the user is valid, false otherwise.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null) && (password != null) && isUser(email) 
             && getUser(email).getPassword().equals(password));
  }

}
