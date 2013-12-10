package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements behavior of index page.
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("digits: Index");
  }
  
  /**
   * Click on login link.
   */
  public void goToLogin() {
    find("#login").click();
  }
  
  /**
   * Check if logged in.
   * @return True if logged in (logout link is present), false otherwise. 
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  /**
   * Logs out user.
   */
  public void logout() {
    find("#logout").click();
  }

  /**
   * Go to new contact page.
   */
  public void goToNewContact() {
    find("#newContact").click();
  }
}
