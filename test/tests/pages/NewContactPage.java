package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
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
    assertThat(title()).isEqualTo("New (play-bootstrap-template)");
  }
  
  /**
   * Set the form to the passed values, then submit it.
   * @param firstName
   * @param lastName
   * @param telephone
   * @param telephoneType
   * @param address
   */
  public void makeContact(String firstName, String lastName, String telephone, String telephoneType, String address) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#telephone").with(telephone);
    find("select", withId().equalTo("telephoneType")).find("option", withText().equalTo(telephoneType)).click();
    fill("#address").with(address);
    submit("#newcontactsubmit");
  }
}
