package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class = 'header-btn-text js-member-name']")
    private WebElement userName;

    @Step
    public String isHomePage() {
        return userName.getText();
    }
}
