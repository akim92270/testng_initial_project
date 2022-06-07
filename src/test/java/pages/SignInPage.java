package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sds-heading--1")
    public static WebElement heading1; //Sign in heading

    @FindBy(css = ".signup-block")
    public static WebElement paragraph;

    @FindBy(css = "div[class='sds-input-container']>input")
    public static WebElement emailInputBox;

    @FindBy(css = "div[class='sds-disclaimer ']>a")
    public WebElement privacy;

    @FindBy(css = "label[for='email']")
    public static WebElement emailLabelBox;

    @FindBy(id = "password")
    public static WebElement passwordInputBox;

    @FindBy(css = ".social-title")
    public static WebElement connectWithSocial;

    @FindBy(xpath = "(//label[@class='sds-label'])[2]")
    public static WebElement passwordLabelBox;

    @FindBy(css = "p[class='sds-helper-text']")
    public static WebElement warningInputBox;

    @FindBy(partialLinkText = "Forgot password?")
    public static WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='sds-disclaimer ']")
    public static WebElement bySigningIn;

    @FindBy(css = "div[class='sds-field']>button")
    public static WebElement purpleSignInButton;

    @FindBy(css = "div[class='column-2 sidebar-social-login']>ul>li>a")
    public static List<WebElement> signInButtons;

    @FindBy(css = ".sds-notification__title")
    public static WebElement weWereUnable;

    @FindBy(css = ".sds-notification__desc")
    public static WebElement yourEmailOrPassword;

}
