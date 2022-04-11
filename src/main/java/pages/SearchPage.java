package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//section[@class='grid-text__container']")
    private WebElement header;
    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> amountOfProducts;

    @FindBy(xpath = "//div[@aria-label='Filters']")
    private WebElement filtersField;

    @FindBy(xpath = "//div[contains(text(),'Sale / New' )]")
    private WebElement filterFieldButton;

    @FindBy(xpath = "//div[@data-auto-id='refinementItem']//div[contains(text(),'New Season' )]")
    private WebElement filterButton;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private WebElement wishListButton;

    @FindBy(xpath = "//button[@aria-label='Item saved']")
    private List<WebElement> wishListButtonAdded;

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private WebElement product;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getTextHeader() {
        return header.getText();
    }

    public List<WebElement> getSearchResultsList() {
        return amountOfProducts;
    }

    public int getAmountOfProducts() {
        return getSearchResultsList().size();
    }

    public boolean isFiltersFieldVisible() {
        return filtersField.isDisplayed();
    }

    public void clickFilterFieldButton() {
        filterFieldButton.click();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickWishListButton() {
        wishListButton.click();
    }

    public List<WebElement> getWishList() {
        return wishListButtonAdded;
    }

    public int getAmountOfProductsInWishList() {
        return getWishList().size();
    }

    public void clickOnProduct(){
        product.click();
    }
}