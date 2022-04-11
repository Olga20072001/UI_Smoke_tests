package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver);
    }

    public AddToCartPage getAddToCartPage() {
        return new AddToCartPage(driver);
    }

    public HomePageWithNavigation getHomePageWithNavigation() {
        return new HomePageWithNavigation(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public BestOfSalePage getBestOfSalePage(){
        return new BestOfSalePage(driver);
    }
}