package googleSheetPage;

import base.CommonAPI;
import google.api.GoogleSheetReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

public class GoogleSheetPage extends CommonAPI {
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchbox;

    @FindBy(id = "nav-input")
    WebElement submitbutton;

    public GoogleSheetPage() {

    }

    public GoogleSheetPage(WebDriver driver) {
        this.driver = driver;
    }

    //get actual result
    public void searchItem() {
        searchbox.sendKeys("Selenium book", Keys.ENTER);
    }

     public List<String> getBookNames() throws InterruptedException {
        searchbox.sendKeys("Selenium book", Keys.ENTER);
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.xpath(".//a/h2"));
//        System.out.println("before extrace names  " + element.get(0).getText());
        for (int i = 0; i < 5; i++) {
            String st = element.get(i).getText();
            text.add(st);
//            System.out.println("get book name ****" + st);
        }
        Thread.sleep(5000);
        return text;
    }

}
