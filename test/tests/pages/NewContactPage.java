package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements behavior of index page.
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("digits: New");
  }
  
  /**
   * Make a new contact.
   * @param firstName First name.
   * @param lastName Last name.
   * @param telephone Telephone.
   * @param type Type.
   * @param address Address.
   */
  public void makeContact(String firstName, String lastName, String telephone, String type, String address) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#telephone").with(telephone);
    find("select", withId("telephoneType")).find("option", withId(type)).click();
    fill("#address").with(address);
    submit("#submit");
  }
}
