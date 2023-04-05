package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

public class MainPage extends BasePage<MainPage> {

  private SelenideElement messageField = $(AppiumBy.className("android.widget.EditText"));

  private SelenideElement sendButton = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Send"));


  private ElementsCollection messageVisible = $$(AppiumBy.className("android.widget.TextView"));

  private SelenideElement exercise = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Exercise"));


  public MainPage sendMessage() {
    messageField.click();
    messageField.sendKeys("test");
    getWebDriver().navigate().back();
    sendButton.click();
    messageVisible();
    return this;
  }

  public MainPage sendMessageWithoutKeyBoard() {
    messageField.sendKeys("test");
    sendButton.click();
    messageVisible();
    return this;
  }


  public MainPage messageVisible() {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("test")).shouldBe(Condition.visible);
    return this;
  }


  public MainPage learningMessageVisible() {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("Learn 5 new words today")).shouldBe(Condition.visible);
    return this;
  }

  public MainPage checkClickExercise() {
    exercise.click();
    learningMessageVisible();
    return this;
  }


}
