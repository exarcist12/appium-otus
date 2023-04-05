package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

public class GrammarPage extends BasePage<GrammarPage> {
  private ElementsCollection messageVisible = $$(AppiumBy.className("android.widget.TextView"));

  private SelenideElement grammar = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Grammar"));

  private SelenideElement freeLesson = $(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Get free lessons')]"));

  private SelenideElement someAny = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Some - Any"));
  private SelenideElement someAnyNextElement = someAny.sibling(0);

  private SelenideElement selectLesson(String lesson) {
    return $(AppiumBy.xpath("//android.widget.TextView[@text='" + lesson + "']/following-sibling::android.view.View"));
  }


  public GrammarPage learningMessageVisible() {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("Learn 5 new words today")).shouldBe(Condition.visible);
    return this;
  }


  public GrammarPage grammarTabVisible() {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("BASIC")).shouldBe(Condition.visible);
    return this;
  }

  public GrammarPage freeLessonVisible() {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("Get one free lesson for each friend you refer")).shouldBe(Condition.visible);
    return this;
  }


  public MainPage someAnyLessonVisible(String lesson) {
    messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
        .find(Condition.text("\"" + lesson + "\"" + " lesson please ")).shouldBe(Condition.visible);
    return new MainPage();
  }

  public GrammarPage checkClickGrammar() {
    grammar.click();
    grammarTabVisible();
    freeLesson.click();
    freeLessonVisible();
    return this;
  }

  public MainPage checkClickStart(String lesson) {
    grammar.click();
    grammarTabVisible();
    selectLesson(lesson).shouldBe(Condition.visible).click();
    someAnyLessonVisible(lesson);
    return new MainPage();
  }
}
