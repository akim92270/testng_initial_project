package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class CarsTest extends Base{
    @Test(priority = 1, description = "Test Case 1: Validate Cars.com Sign in page form")
    public void testCarSignInPage(){
        /*
        Test Case 1: Validate Cars.com Sign in page form
        Given user navigates to “https://www.cars.com/” DONE
        When user clicks on top right “Sign In” link DONE
        Then user should be navigated to “Sign in” page DONE
        And user should be able to see heading1 as "Sign in" DONE
        And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?” DONE
        And user should be able to see Email input box with “Email” label and enabled DONE
        And user should be able to see Password input box with “Password” label and enabled DONE
        And user should be able to see warning under Password input box as “Minimum of eight characters” DONE
        And user should be able to see a link as “Forgot password?” under the Password input box DONE
        And user should be able see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.” Text DONE
        And user should be able to “Sign in” button with its text and be displayed and enabled
         */

        driver.get("https://www.cars.com/"); //Given user navigates to “https://www.cars.com/”
        HomePage.signIn.click(); //When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F"); //Then user should be navigated to “Sign in” page

        Assert.assertTrue(SignInPage.heading1.isDisplayed());
        Assert.assertEquals(SignInPage.heading1.getText(), "Sign in"); //And user should be able to see heading1 as "Sign in"

        Assert.assertTrue(SignInPage.paragraph.isDisplayed());
        Assert.assertEquals(SignInPage.paragraph.getText(), "New to Cars.com? Sign up. Are you a dealer?"); //And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”

        Assert.assertTrue(SignInPage.emailInputBox.isDisplayed());
        Assert.assertTrue(SignInPage.emailInputBox.isEnabled());
        Assert.assertEquals(SignInPage.emailLabelBox.getText(),"Email"); //And user should be able to see Email input box with “Email” label and enabled

        Assert.assertTrue(SignInPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(SignInPage.passwordInputBox.isEnabled());
        Assert.assertEquals(SignInPage.passwordLabelBox.getText(), "Password"); //And user should be able to see Password input box with “Password” label and enabled

        Assert.assertTrue(SignInPage.warningInputBox.isDisplayed());
        Assert.assertTrue(SignInPage.warningInputBox.isEnabled());
        Assert.assertEquals(SignInPage.warningInputBox.getText(), "Minimum of eight characters"); //And user should be able to see Password input box with “Password” label and enabled

        Assert.assertTrue(SignInPage.forgotPassword.isDisplayed());
        Assert.assertTrue(SignInPage.forgotPassword.isEnabled());
        Assert.assertEquals(SignInPage.forgotPassword.getText(), "Forgot password?"); //And user should be able to see a link as “Forgot password?” under the Password input box

        Assert.assertTrue(SignInPage.tos.isDisplayed());
        Assert.assertTrue(SignInPage.tos.isEnabled());
        Assert.assertEquals(SignInPage.tos.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");//And user should be able to see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of ServicFore.”

        Assert.assertTrue(SignInPage.purpleSignInButton.isDisplayed());
        Assert.assertTrue(SignInPage.purpleSignInButton.isEnabled());
        Assert.assertEquals(SignInPage.purpleSignInButton.getText(), "Sign in"); //And user should be able to “Sign in” button with its text and be displayed and enabled
    }


    /*
    Test Case 2: Validate Cars.com Sign in page social media section
    Given user navigates to “https://www.cars.com/” DONE
    When user clicks on top right “Sign In” link DONE
    Then user should be navigated to “Sign in” page DONE
    And user should be able to see headings as "Connect with social" DONE
    And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
    And user should be able to “Sign in with Google” link with its text and be displayed and enabled
    And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
     */
    @Test(priority = 2, description = "Validate Cars.com Sign in page social media section")
    public void testValidateSocialMedia() {
        driver.get("https://www.cars.com/"); //Given user navigates to “https://www.cars.com/”
        HomePage.signIn.click(); //When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F"); //Then user should be navigated to “Sign in” page

        Assert.assertTrue(SignInPage.connectWithSocial.isDisplayed());
        Assert.assertTrue(SignInPage.connectWithSocial.isEnabled());
        Assert.assertEquals(SignInPage.connectWithSocial.getText(), "Connect with social"); //And user should be able to see headings as "Connect with social"

        /*Assert.assertTrue(SignInPage.SignInButtons.get(0).isDisplayed());
        Assert.assertTrue(SignInPage.SignInButtons.get(0).isEnabled());
        Assert.assertEquals(SignInPage.SignInButtons.get(0).getText(), "Sign in with Facebook"); //And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled

        Assert.assertTrue(SignInPage.SignInButtons.get(1).isDisplayed());
        Assert.assertTrue(SignInPage.SignInButtons.get(1).isEnabled());
        Assert.assertEquals(SignInPage.SignInButtons.get(1).getText(), "Sign in with Google"); // And user should be able to “Sign in with Google” link with its text and be displayed and enabled

        Assert.assertTrue(SignInPage.SignInButtons.get(2).isDisplayed());
        Assert.assertTrue(SignInPage.SignInButtons.get(2).isEnabled());
        Assert.assertEquals(SignInPage.SignInButtons.get(2).getText(), "Sign in with Apple"); // And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
         */

        String[] connectWithSocialButtons = {"Sign in with Facebook", "Sign in with Google", "Sign in with Apple"};
        for (int i = 0; i < SignInPage.signInButtons.size(); i++) {
            Assert.assertTrue(SignInPage.signInButtons.get(i).isDisplayed());
            Assert.assertTrue(SignInPage.signInButtons.get(i).isEnabled());
            Assert.assertEquals(SignInPage.signInButtons.get(i).getText(),(connectWithSocialButtons[i]));
        }
    }

    /*
    Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials
    Given user navigates to “https://www.cars.com/” DONE
    When user clicks on top right “Sign In” link DONE
    Then user should be navigated to “Sign in” page DONE
    When user enters johndoe@gmail.com to the Email input box DONE
    And user enters abcd1234 to the Password input box DONE
    And user clicks on the “Sign in” button DONE
    Then user should not be logged in and displayed an error message on the top of the form as below
    “We were unable to sign you in.
    Your email or password was not recognized. Try again soon.”
     */
    @Test(priority = 3, description = "Validate user cannot sign in to Cars.com with invalid credentials")
    public void testInvalidCredentials(){
        driver.get("https://www.cars.com/"); //Given user navigates to “https://www.cars.com/”
        HomePage.signIn.click(); //When user clicks on top right “Sign In” link
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");; //Then user should be navigated to “Sign in” page
        SignInPage.emailInputBox.sendKeys("johndoe@gmail.com"); //When user enters johndoe@gmail.com to the Email input box
        SignInPage.passwordInputBox.sendKeys("abcd1234"); //And user enters abcd1234 to the Password input box
        SignInPage.purpleSignInButton.click(); //And user clicks on the “Sign in” button
        Assert.assertTrue(SignInPage.weWereUnable.isDisplayed()); //Then user should not be logged in and displayed an error message on the top of the form as below
        Assert.assertEquals(SignInPage.weWereUnable.getText(), "We were unable to sign you in.");
        Assert.assertEquals(SignInPage.yourEmailOrPassword.getText(), "Your email or password was not recognized. Try again soon.");
    }

}
