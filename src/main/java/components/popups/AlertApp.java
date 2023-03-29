package components.popups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class AlertApp extends AbsBasePopup<AlertApp> {
	private SelenideElement alertPopup = $(AppiumBy.id("android:id/parentPanel"));
	@Override
	public AlertApp popupShouldBeVisible() {
		alertPopup.shouldBe(Condition.visible);
		return this;
	}

	@Override
	public AlertApp popupShouldNotBeVisible() {
		alertPopup.shouldBe(Condition.not(Condition.visible));
		return this;
	}

	public AlertApp clickOkButton(){
		$(AppiumBy.id("android:id/button1")).click();
		return this;
	}
}
