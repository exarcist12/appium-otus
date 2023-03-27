package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.MainMenuItemsData;
import data.accessability.ISubmenuItems;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage<MainPage> {

//  public MainPage open() {
//    Selenide.open();
//
//    return this;
//  }
//
//
//  public void clickMenuItem(ISubmenuItems menuItems) {
//    String selectorTemplate = "[text='%s']";
//
//    $(String.format(selectorTemplate, menuItems.getMainMenuItemsData().getName())).click();
//
//    $(String.format(selectorTemplate, menuItems.getName())).shouldBe(Condition.visible);
//    $(String.format(selectorTemplate, menuItems.getName())).click();
//  }

}
