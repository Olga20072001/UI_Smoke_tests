package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageWithNavigation extends BasePage {

@FindBy(xpath = "//div[@class='_3C_NQPb']//span[contains(text(), 'Sale')]")
private WebElement naviField;

@FindBy(xpath = "(//a[contains(text(), 'Best of sale')])[1]")
private WebElement bestOfSaleButton;

    public HomePageWithNavigation(WebDriver driver) {
        super(driver);
    }

    public boolean isNavigationFieldVisible(){
        return naviField.isDisplayed();
    }

    public void movesOnSaleField(){
        Actions act = new Actions(driver);
        act.moveToElement(naviField).click().build().perform();
    }
    public void clickBestOfSaleButton(){
        bestOfSaleButton.click();
    }
}