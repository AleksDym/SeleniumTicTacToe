package our_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Ueberpruefen, dass alle Felder klickabel sind

public class TestCase7_alleFelderKlickabel extends SetupClass {

    @Test
    public void oberesFeldKlickbarTest() {
        WebElement feld;
        int x;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
                board.getBoardById()
        ));
        for(x = 0; x < 10; ++x) {
            feld = board.getCell(x);
            feld.click();
            WebElement buttonImage = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(
                    board.getImageTag(feld)
            ));
            Assert.assertTrue(buttonImage.isDisplayed());
        }

    }

    //Fehlerbeschreibungen Nr 1
    @Test
    public void unteresFeldKlickbarTest() {
        WebElement feld;
        int x;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
                board.getBoardById()
        ));
        for(x = 10; x < 20; ++x) {
            feld = board.getCell(x);
            feld.click();
            WebElement buttonImage = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(
                    board.getImageTag(feld)
            ));
            Assert.assertTrue(buttonImage.isDisplayed());
        }

    }

}
