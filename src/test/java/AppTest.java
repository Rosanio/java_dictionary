import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Rosanio Dictionary");
  }

  @Test
  public void addWord() {
    goTo("http://localhost:4567/");
    click("a", withText("Teach me a new word here"));
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void displayWord() {
    goTo("http://localhost:4567/");
    click("a", withText("Teach me a new word here"));
    fill("#newWord").with("platypus");
    submit(".btn");
    assertThat(pageSource()).contains("platypus");
  }

  @Test
  public void wordPage() {
    goTo("http://localhost:4567/");
    click("a", withText("Teach me a new word here"));
    fill("#newWord").with("platypus");
    submit(".btn");
    click("a", withText("platypus"));
    assertThat(pageSource()).contains("platypus");
  }

}
