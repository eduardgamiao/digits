package tests;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;
import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import tests.pages.NewContactPage;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }
  
  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.clickLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.logout();
        assertThat(indexPage.isLoggedIn()).isFalse();
      }
    });
  }
  
  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testNewContact() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.clickLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.clickNewContact();
        NewContactPage newContactPage = new NewContactPage(browser.getDriver(), PORT);
        newContactPage.isAt();
        newContactPage.makeContact("ThisNameShouldNotExist", "A Date", "111-111-2345", "Home", 
            "1234567890123456789012345");
        browser.goTo(indexPage);
        indexPage.isAt();
        assertThat(browser.pageSource().contains("ThisNameShouldNotExist")).isTrue();
      }
    });
  }

}
