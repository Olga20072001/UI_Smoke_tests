package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestOfSalePage extends BasePage{

    @FindBy(xpath = "//section[@id='category-banner-wrapper']")
    private WebElement saleHeader;



    public BestOfSalePage(WebDriver driver) {
        super(driver);
    }

    public String getSaleHeaderText(){
        return saleHeader.getText();
    }
}
