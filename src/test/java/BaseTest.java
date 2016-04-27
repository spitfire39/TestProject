import Utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public abstract class BaseTest {

    protected static WebDriver driver;

    File chromeDriverFile = new File("src/main/resources/chromedriver.exe");
    String getChromeDriverPath = chromeDriverFile.getAbsolutePath();
    File IEDriverFile = new File("src/main/resources/IEDriverServer.exe");
    String getIEDriverPath = IEDriverFile.getAbsolutePath();

    SoftAssert softAssert = new SoftAssert();
    Assertion hardAssert = new Assertion();


    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browser) throws IOException {
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase("internet explorer")){
            driver = new InternetExplorerDriver();
        }
        else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.get(ConfigProperties.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.IMP_WAIT), TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterTest() {
        try {
            driver.quit();
        } catch (Exception e) {
            driver = null;
        }
    }
}
