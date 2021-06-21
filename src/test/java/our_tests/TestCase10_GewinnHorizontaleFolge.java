package our_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Überprüfen, dass horizontale Folge von ab 3
 * Symbolen der Gewinn bedeutet: 3-Eck & L-Formen sollen nicht gewinnen
 */
public class TestCase10_GewinnHorizontaleFolge extends SetupClass {
    @Test
    public void testHorizontal() {
        board.clickOnCell(0);
        board.clickOnCell(11);
        board.clickOnCell(1);
        board.clickOnCell(13);
        board.clickOnCell(2);
        Assert.assertTrue(board.gameIsOver());
    }

    // //Fehlerbeschreibungen Nr 7
    @Test
    public void testDreieck() {
        board.clickOnCell(1);
        board.clickOnCell(11);
        board.clickOnCell(3);
        board.clickOnCell(13);
        board.clickOnCell(8);
        board.clickOnCell(17);
        Assert.assertFalse(board.gameIsOver());
    }

    //Fehlerbeschreibungen Nr 2
    @Test
    public void test_L_Form() {
        board.clickOnCell(1);
        board.clickOnCell(3);
        board.clickOnCell(6);
        board.clickOnCell(13);
        board.clickOnCell(7);
        board.clickOnCell(14);
        Assert.assertFalse(board.gameIsOver());
    }


    //Fail erwartet
    @Test
    public void zweitesRoundPlayer14FelderNotwendig() throws InterruptedException {

        //round 1 - Player 1 startet und gewinnt mit 3 Eintraege
        board.clickOnCell(1);
        board.clickOnCell(2);
        board.clickOnCell(6);
        board.clickOnCell(15);
        board.clickOnCell(11);

        WebElement buttonClose1 = board.getCloseButton();
        buttonClose1.click();

        //round 2 - PLayer 2 startet, nach 3 korrekte Eintraege von Player1 passiert Gewinn trotzdem nicht

        board.clickOnCell(2);
        board.clickOnCell(6);
        board.clickOnCell(2);
        board.clickOnCell(11);
        board.clickOnCell(2);
        board.clickOnCell(16);

        //Button, das nach dem Gewinn normalerweise angezeigt wird, kan mann nicht finden
        WebElement buttonClose2 = board.getCloseButton();
        Assert.assertTrue(buttonClose2.isDisplayed());
    }
}
