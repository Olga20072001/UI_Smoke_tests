package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final String SEARCH_WORD = "scirt";
    private static final String WRONG_WORD = "idfjghgfg";

    WebDriver driver;
    HomePage homePage;
    AccountPage accountPage;
    AddToCartPage addToCartPage;
    BestOfSalePage bestOfSalePage;
    HomePageWithNavigation homePageWithNavigation;
    ProductPage productPage;
    SearchPage searchPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void makeSearchBySearchWord(final String searchWord) {
        homePage.searchByKeyword(searchWord);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that current url contains {string}")
    public void checkThatCurrentUrlContainsFilterWord(final String currUrl) {
        assertTrue(driver.getCurrentUrl().contains(currUrl));

    }

    @And("User checks that current url contains keyword")
    public void checkThatCurrentUrlContainsKeyword() {
        assertTrue(driver.getCurrentUrl().contains(WRONG_WORD));
    }

    @Then("User checks lack of products with {string}")
    public void checkLackOfProductsWithSearchHeader(final String searchHeader) {

        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.getTextHeader().contains(searchHeader));
    }

    @Then("User checks that amount of products in search page are {string}")
    public void checkThatAmountOfProductsInSearchPageAreAmountOfElements(final String amountOfElements) {
        searchPage = pageFactoryManager.getSearchPage();

        assertEquals(Integer.parseInt(amountOfElements), searchPage.getAmountOfProducts());
    }

    @And("User makes search by keyword ‘searchWord’")
    public void makeSearchByKeyword() {
        homePage.searchByKeyword(SEARCH_WORD);
    }

    @When("User checks filter’s field visibility")
    public void checkFilterSFieldVisibility() {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.isFiltersFieldVisible());
    }

    @And("User clicks 'SaleNewSeason' filter field")
    public void clickSaleNewSeasonFilterField() {
        searchPage.clickFilterFieldButton();
    }

    @And("User clicks 'NewSeason' button")
    public void clickNewSeasonButton() {
        searchPage.clickFilterButton();
    }

    @And("User clicks 'women' button")
    public void clickWomenButton() {
        homePage.clickWomenButton();
    }

    @When("User checks floor navigation menu visibility")
    public void checkFloorNavigationMenuVisibility() {
        homePageWithNavigation = pageFactoryManager.getHomePageWithNavigation();
        assertTrue(homePageWithNavigation.isNavigationFieldVisible());
    }

    @And("User moves to 'sale' field")
    public void moveToSaleField() {
        homePageWithNavigation.movesOnSaleField();
    }

    @And("User clicks 'bestOfSale' button")
    public void userClicksBestOfSaleButton() {
        homePageWithNavigation.clickBestOfSaleButton();
    }

    @Then("User checks that salePage header is {string}")
    public void clickThatSalePageHeaderIsSaleHeader(final String saleHeader) {
        bestOfSalePage = pageFactoryManager.getBestOfSalePage();
        assertTrue(bestOfSalePage.getSaleHeaderText().contains(saleHeader));
    }

    @And("User clicks wish list on first product")
    public void clickWishListOnFirstProduct() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickWishListButton();
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void checkThatAmountOfProductsInWishListAreAmountOfProducts(final String amountOfWishLists) {
        assertEquals(Integer.parseInt(amountOfWishLists), searchPage.getAmountOfProductsInWishList());
    }

    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickOnProduct();
    }

    @And("User checks 'ADD TO BAG' button visibility")
    public void checkAddToBagButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        assertTrue(productPage.isAddToCartButtonVisible());
    }

    @And("User checks size field visibility")
    public void checkSizeFieldVisibility() {
        assertTrue(productPage.isSizeFieldVisible());
    }

    @And("User clicks size field")
    public void userClicksSizeField() {
        productPage.clickSizeField();
    }

    @And("User clicks on first size field")
    public void clickOnFirstSizeField() {
        productPage.clickOnFirstSize();

        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);

    }

    @And("User clicks 'ADD TO BAG' button on product")
    public void clickToBagButton() {
        productPage.clickAddToCartButton();
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);

    }

    @And("User moves to 'MY BAG' button")
    public void moveToMyBagButton() {
        productPage.movesToCartButton();
    }

    @And("User checks 'VIEW BAG' button visibility")
    public void checkViewBagButtonVisibility() {
        assertTrue(productPage.isViewBagButtonVisible());
    }

    @And("User checks 'CHECKOUT' button visibility")
    public void checkCheckoutButtonVisibility() {
        assertTrue(productPage.isCheckoutButtonVisible());
    }

    @And("User clicks 'VIEW BAG' button")
    public void userClicksViewBagButton() {
        productPage.clickViewBagButton();
    }

    @Then("User checks that cart page header is {string}")
    public void checkThatCartPageHeaderIsCartHeader(final String cartHeader) {

        addToCartPage = pageFactoryManager.getAddToCartPage();
        addToCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        addToCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        addToCartPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        assertTrue(addToCartPage.checkCartPage().contains(cartHeader));
    }

    @Then("User checks the {string}")
    public void checkTheMessage(final String errorMessage) {
        assertTrue(productPage.checkErrorMessageAddingCart().contains(errorMessage));
    }

    @When("User checks account field visibility")
    public void checkAccountFieldVisibility() {
        assertTrue(homePage.isAccountFieldVisible());
    }

    @And("User moves to account field")
    public void userMovesToAccountField() {
        homePage.movesToAccountField();
    }

    @And("User clicks 'join' field on account popup")
    public void clickJoinFieldOnAccountPopup() {
        homePage.clickJoinButton();
    }

    @Then("User checks that the join page header contains {string}")
    public void checkThatTheJoinPageHeaderContainsJoinHeader(final String joinHeader) {
        accountPage = pageFactoryManager.getAccountPage();
        assertTrue(accountPage.checkThatJoinPageHeaderContainsWord().contains(joinHeader));
    }

    @And("User checks 'signUpViaGoogle' button visibility")
    public void checkcheckSignUpViaGoogleButtonVisibility() {
        assertTrue(accountPage.isSignUpViaGoogleVisible());
    }

    @And("User checks 'signUpViaApple' button visibility")
    public void checkSignUpViaAppleButtonVisibility() {
        assertTrue(accountPage.isSignUpViaAppleVisible());
    }

    @And("User checks 'signUpViaFacebook' button visibility")
    public void checkSignUpViaFacebookButtonVisibility() {
        assertTrue(accountPage.isSignUpViaFacebookVisible());
    }

    @And("User clicks 'sign in' field on account popup")
    public void clickSignInFieldOnAccountPopup() {
        homePage.clickSignInButton();
    }

    @And("Users checks email field visibility")
    public void checkEmailFieldVisibility() {
        accountPage = pageFactoryManager.getAccountPage();
        assertTrue(accountPage.isEmailFieldVisible());
    }

    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        assertTrue(accountPage.isPasswordFieldVisible());
    }

    @And("User checks 'signIn' button visibility")
    public void checkSignInButtonVisibility() {
        assertTrue(accountPage.isSignInButtonVisible());
    }

    @And("User types email address by keyword 'mailWord'")
    public void typeEmailAddressByKeywordMailWord() {
        accountPage.typeEmailFromKeyword(WRONG_WORD);
    }

    @And("User clicks 'signIn' button")
    public void clickSignInButton() {
        accountPage.clickSignInButton();
    }

    @Then("User checks {string} visibility")
    public void checkErrorMessageVisibility(final String errorMessage) {
        assertTrue(accountPage.checkErrorMessageInSignInPage().contains(errorMessage));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}