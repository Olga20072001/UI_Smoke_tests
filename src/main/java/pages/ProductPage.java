package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeField;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//a[@data-test-id='checkout-link']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//span[@class='error basic-error-box']")
    private WebElement errorMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSizeFieldVisible() {
        return sizeField.isDisplayed();
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isDisplayed();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void movesToCartButton() {
        Actions act = new Actions(driver);
        act.moveToElement(cartButton).click().build().perform();
    }

    public boolean isViewBagButtonVisible() {
        return viewBagButton.isDisplayed();
    }

    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public void clickSizeField() {
        sizeField.click();

    }

    public void clickOnFirstSize() {
        sizeField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        sizeField.click();
    }

    public String checkErrorMessageAddingCart() {
        return errorMessage.getText();
    }
}