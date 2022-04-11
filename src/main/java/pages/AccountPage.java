package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//div[@class='info info-centre']")
    private WebElement infoCentre;

    @FindBy(xpath = "//a[@id='signup-google']")
    private WebElement joinViaGoogleButton;

    @FindBy(xpath = "//a[@id='signup-apple']")
    private WebElement joinViaAppleButton;

    @FindBy(xpath = "//a[@id='signup-facebook']")
    private WebElement joinViaFacebookButton;

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@aria-labelledby='PasswordLabel']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement errorMessage;

    public boolean isSignUpViaGoogleVisible() {
        return joinViaGoogleButton.isDisplayed();
    }

    public boolean isSignUpViaAppleVisible() {
        return joinViaAppleButton.isDisplayed();
    }

    public boolean isSignUpViaFacebookVisible() {
        return joinViaFacebookButton.isDisplayed();
    }

    public String checkThatJoinPageHeaderContainsWord() {
        return infoCentre.getText();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void typeEmailFromKeyword(final String keyword) {
        emailField.sendKeys(keyword);
    }

    public String checkErrorMessageInSignInPage() {
        return errorMessage.getText();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public AccountPage(WebDriver driver) {
        super(driver);
    }
}