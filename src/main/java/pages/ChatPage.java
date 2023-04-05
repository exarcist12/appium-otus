package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;


public class ChatPage extends BasePage<ChatPage> {

  private SelenideElement messageField = $(AppiumBy.className("android.widget.EditText"));

  private SelenideElement sendButton = $$(AppiumBy.className("android.widget.TextView")).find(Condition.text("Send"));

  public ChatPage sendMessage() {
    messageField.click();
    messageField.sendKeys("test");
    sendButton.click();
    return this;
  }
}
