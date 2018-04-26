package googlesheetpage;

import google.api.GoogleSheetReader;
import googleSheetPage.GoogleSheetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjectmodel.HomePage;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class TestGoogleSheetPage extends GoogleSheetPage {

    //compare readout with expected result
    @Parameters({"spreadSheetId", "dataRange"})
    @Test
    public void testGoogleSheetData(@Optional("") String spreadSheetId, @Optional("") String dataRange)
            throws GeneralSecurityException, IOException, InterruptedException {
        GoogleSheetPage gsp = PageFactory.initElements(driver, GoogleSheetPage.class);
//        gsp.searchItem();
        List<String> actualResult = gsp.getBookNames();
        for (String st : actualResult) System.out.println("The actual result :::::" + st);

        //expected result
        List<List<Object>> expectedList = GoogleSheetReader.getGoogleSheetValues(spreadSheetId, dataRange);
        List<String> expectedResult = new ArrayList<String>();
        for (int i = 0; i < expectedList.size(); i++) {
            List row = expectedList.get(i);
            expectedResult.add(row.get(0).toString());
            System.out.println("The expected ====" + expectedResult.get(i));
        }

        //compare -- test
        try {
            for (int k = 0; k < 5; k++) {
                Assert.assertTrue((expectedList.get(k).toString().substring(1, expectedList.get(k).toString().length()-2)).contains(actualResult.get(k)), "book doesn't match in NO. " + k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
