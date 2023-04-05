package extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import providers.SelenideWebDriver;

public class AppiumExtension implements BeforeEachCallback, AfterEachCallback {

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    Configuration.browserSize = null;
    Configuration.browser = SelenideWebDriver.class.getName();
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    Selenide.closeWebDriver();
  }
}
