package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement loginBtn;

    @Step
    public boolean isLoginPage() {
        return email.isDisplayed();
    }
    @Step
    public HomePage logIn(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginBtn.click();
        return new HomePage(driver);
    }
}
