package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements behavior of index page.
 * @author Philip Johnson
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("digits: Login");
  }
  
  /**
   * Test login.
   */
  public void login() {
    String adminEmail = Play.application().configuration().getString("admin.email");
    String adminPassword = Play.application().configuration().getString("admin.password"); 
    fill("#email").with(adminEmail);
    fill("#password").with(adminPassword);
    submit("#submit");
  }
}
