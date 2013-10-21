package controllers;

import play.GlobalSettings;
import play.Logger;

/**
 * Global object for Play Framework.
 * @author eduardgamiao
 *
 */
public class Global extends GlobalSettings {

  /**
   * Defines what to do on start up.
   * @param app An application.
   */
  public void onStart(Application app) {
    Logger.info("Application has started");
  }  
  
}
