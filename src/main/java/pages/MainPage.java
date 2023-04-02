package pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.appium.selector.ByAttribute;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class MainPage extends BasePage<MainPage> {

	private SelenideElement messageField = $(AppiumBy.className("android.widget.EditText"));

	private SelenideElement sendButton = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Send"));

	private SelenideElement bar = $(AppiumBy.id("android:id/navigationBarBackground"));

	private ElementsCollection messageVisible = $$(AppiumBy.className("android.widget.TextView"));

	private SelenideElement exercise = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Exercise"));

	private SelenideElement learningMessage = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Learn 5 new words today"));

	private SelenideElement grammar = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Grammar"));

	private SelenideElement freeLesson = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("\uE02F Get free lessons"));

	private SelenideElement someAny = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Some - Any"));



//	private SelenideElement someAnyNextElement = someAny.sibling(0).find(String.valueOf(Condition.attribute("class", "android.view.View")));
//	private SelenideElement startSomeAny = someAnyNextElement.$(AppiumBy.xpath("//android.widget.TextView[@text='Start'][@index='0']"));


	public MainPage sendMessage(){
		messageField.click();
		messageField.sendKeys("test");
		getWebDriver().navigate().back();
		sendButton.click();
		messageVisible();
		return this;
	}

	public MainPage sendMessageWithoutKeyBoard(){
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

	public MainPage checkClickExercise(){
		exercise.click();
		learningMessageVisible();
		return this;
	}


	public MainPage grammarTabVisible() {
		messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
				.find(Condition.text("BASIC")).shouldBe(Condition.visible);
		return this;
	}

	public MainPage freeLessonVisible() {
		messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
				.find(Condition.text("Get one free lesson for each friend you refer")).shouldBe(Condition.visible);
		return this;
	}


	public MainPage someAnyLessonVisible() {
		messageVisible.should(CollectionCondition.sizeNotEqual(0), Duration.ofSeconds(15))
				.find(Condition.text("\"Some - Any\" lesson please ")).shouldBe(Condition.visible);
		return this;
	}

	public MainPage checkClickGrammar(){
		grammar.click();
		grammarTabVisible();
		freeLesson.click();
		freeLessonVisible();
		return this;
	}

	public MainPage checkClickStart() {
		grammar.click();
		grammarTabVisible();
		someAny.click();
		someAnyLessonVisible();
		return this;
	}
}
