package our_tests;

import enums.Players;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//Überprüfen, dass alle Felder entsprechend markiert werden

public class TestCase8_FelderEntsprechendMarkiert extends SetupClass {
    @Test
    public void player1EntsprechendMakierenTest() {
        List<WebElement> player1AllOption = settings.getAllPlayerOption(Players.PLAYER1);

        int i;
        WebElement cell0;
        for(i = 0; i < 5; ++i) {
            cell0 = board.getCell(0);
            ((WebElement)player1AllOption.get(i)).click();
            cell0.click();
            if (i % 2 == 0) {
                Assert.assertEquals(
                        board.getImageSrc(),
                        board.getImage(player1AllOption, i)
                );
            }
        }

        for(i = 0; i < 5; ++i) {
            cell0 = board.getCell(0);;
            ((WebElement)player1AllOption.get(i)).click();
            cell0.click();
            if (i % 2 != 0) {
                Assert.assertEquals(
                        board.getImageSrc(),
                        board.getImage(player1AllOption, i)
                );            }
        }

    }

    @Test
    public void player2EntsprechendMakierenTest() {
        List<WebElement> player2AllOption = settings.getAllPlayerOption(Players.PLAYER2);

        int i;
        for(i = 0; i < 5; ++i) {
            ((WebElement)player2AllOption.get(i)).click();
            board.clickOnCell(0);
            if (i % 2 != 0) {
                Assert.assertEquals(
                        board.getImageSrc(),
                        board.getImage(player2AllOption, i)
                );
            }
        }

        for(i = 0; i < 5; ++i) {
            ((WebElement)player2AllOption.get(i)).click();
            board.clickOnCell(0);
            if (i % 2 == 0) {
                Assert.assertEquals(
                        board.getImageSrc(),
                        board.getImage(player2AllOption, i)
                );            }
        }

    }

}
