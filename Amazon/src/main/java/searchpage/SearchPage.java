package searchpage;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends CommonAPI {

    @FindBy(how=How.NAME, using="twotabsearchbox")
    WebElement searchbox;

    @FindBy(className = "nav-input")
    WebElement submitbutton;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
}
