import Data.DataProviderTrello;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.Stories;

public class LoginTest extends BaseTest{
    @Stories("Some story 1")
    @Features("Some feature 1")
    @Issues({
            @Issue("159"),
            @Issue("951")})
    @Test(dataProvider = "login", dataProviderClass = DataProviderTrello.class)
    // the test logings in to the application and verifies that we are logged in by some username
    public void login(String email,
                      String password,
                      String userName){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.logIn(email, password);
        Assert.assertEquals(userName, homePage.isHomePage());
    }
}
