package pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.appium.commands.AppiumClick;
import components.popups.AlertApp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class MainPage extends BasePage<MainPage> {

	private SelenideElement messageField = $(AppiumBy.className("android.widget.EditText"));

	private SelenideElement sendButton = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Send"));

	private SelenideElement bar = $(AppiumBy.id("android:id/navigationBarBackground"));

	private ElementsCollection messageVisible = $$(AppiumBy.className("android.widget.TextView"));


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
}
