package pageobjectmodel;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI{
    @Test
    public void Test1() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.searchBook();
    }
}
