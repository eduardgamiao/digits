package test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import java.util.List;
import models.Contact;
import org.junit.Test;
import play.mvc.Content;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are interested in mocking a whole application, see
 * the wiki for more details.
 * 
 */
public class ApplicationTest {

  /**
   * Illustrates a simple test.
   */
  @Test
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }

  /**
   * Illustrates how to render a template for testing.
   */
  @Test
  public void renderTemplate() {
    List<Contact> list = null;
    Content html = views.html.Index.render(list, true, "john@doe.com");
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("home page");
  }
}
