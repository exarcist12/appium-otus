package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

public class StartPage extends BasePage<StartPage> {

  private ElementsCollection nextButton = $$(AppiumBy.className("android.widget.TextView"));

  public StartPage clikNext() {
    nextButton.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("next")).click();

    return this;
  }

  public MainPage clikSkip() {
    $$(AppiumBy.className("android.widget.TextView"))
        .find(Condition.text("Skip >")).click();

    return new MainPage();
  }

  public boolean isStartPageStart() {
    SelenideElement button = nextButton.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("next"));
    return button.isDisplayed();
  }
}
