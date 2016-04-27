package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    // Method get the current page title
    protected String getPageTitle(){
        return driver.getTitle();
    }

    // send keys method
    protected void sendKeys(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Field is unavailable" + e);
        }
    }

    // ckick method
    protected void click(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(visibilityOf(element));
            element.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("BTN is unavailable" + e);
        }
    }

    protected void clickListItem(List<WebElement> element, int index) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            element.get(index).click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("BTN is unavailable" + e);
        }
    }

    // select by text method
    protected void select(WebElement element, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);

            select.selectByVisibleText(value);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Selection is unavailable" + e);
        }
    }
    // select by value method
    protected void selectByValue(WebElement element, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Selection is unavailable" + e);
        }
    }

    // clear method
    protected void clear(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Field is unavailable" + e);
        }
    }

    // get attribute method
    protected String getAttribute(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(visibilityOf(element));
            element.getAttribute(text);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Attribute is unavailable" + e);
        }
        return "";
    }

    // get text method
    protected String getText(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(visibilityOf(element));
            return element.getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Text is unavailable" + e);
        }
        return "";
    }

    // is element present method
    protected boolean isElementPresent(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(visibilityOf(element));
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isTextPresent(WebElement element, String text){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            element.getText();
            //boolean b = driver.getPageSource().contains(text);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    // Drag and Drop
    public void dragAndDrop(WebElement target, WebElement destination) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(target, destination).perform();
    }

    // verifies if element is hidden
    public boolean isElementHidden(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(invisibilityOfElementLocated(element));
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    // method returns a quantity of the list of webelements that have appeared on the page
    protected int getValidatorsCount(List<WebElement> elements){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements.size();
        } catch (NoSuchElementException e){
            return 0;
        }
    }


}