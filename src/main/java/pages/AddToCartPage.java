package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{

    @FindBy(xpath = "//div[@class='bag-contents-holder-panel bag-title-holder']")
    private WebElement cartHeader;

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public String checkCartPage(){
        return cartHeader.getText();
    }
}