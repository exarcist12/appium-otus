package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.popups.AlertApp;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChatPage extends BasePage<ChatPage>{

	private SelenideElement messageField = $(AppiumBy.className("android.widget.EditText"));

	private SelenideElement sendButton = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Send"));

	public ChatPage sendMessage(){
		messageField.click();
		messageField.sendKeys("test");
		sendButton.click();
		return this;
	}
}
