package test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;
import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import test.pages.IndexPage;
import test.pages.LoginPage;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Test that index can be retrieved.
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
  
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        loginPage.isAt();
        loginPage.setName("user");
        loginPage.setPassword("password");
      }    
  });
}
}
