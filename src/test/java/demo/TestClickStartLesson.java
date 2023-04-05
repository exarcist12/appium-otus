package demo;

import components.popups.AlertApp;
import extensions.AppiumExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GrammarPage;
import pages.MainPage;
import pages.StartPage;

@ExtendWith(AppiumExtension.class)
public class TestClickStartLesson {

  private StartPage startPage = new StartPage();
  private MainPage mainPage = new MainPage();

  private GrammarPage grammarPage = new GrammarPage();

  @ParameterizedTest
  @ValueSource(strings = {"Some - Any", "Much - Many"})
  public void firstTest(String lesson) {
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

    grammarPage.checkClickStart(lesson);

  }
}
