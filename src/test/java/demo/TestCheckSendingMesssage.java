package demo;

import components.popups.AlertApp;
import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;
import pages.StartPage;

@ExtendWith(AppiumExtension.class)
public class TestCheckSendingMesssage {

  private StartPage startPage = new StartPage();
  private MainPage mainPage = new MainPage();

  @Test
  public void testCheckSendingMesssage() {
    mainPage.open();
    if (startPage.isStartPageStart()) {
      new StartPage()
          .clikNext()
          .clikNext()
          .clikSkip();
    }


    AlertApp allertApp = new AlertApp()
        .popupShouldBeVisible();
    allertApp.clickOkButton().popupShouldNotBeVisible();

    mainPage.sendMessage();
  }
}
