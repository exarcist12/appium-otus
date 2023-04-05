package demo;

import components.popups.AlertApp;
import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GrammarPage;
import pages.MainPage;
import pages.StartPage;

@ExtendWith(AppiumExtension.class)
public class TestClickGrammarAndGetFreeLesson {

  private StartPage startPage = new StartPage();
  private MainPage mainPage = new MainPage();

  private GrammarPage grammarPage = new GrammarPage();

  @Test
  public void firstTest() {
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
    grammarPage.checkClickGrammar();
  }
}
