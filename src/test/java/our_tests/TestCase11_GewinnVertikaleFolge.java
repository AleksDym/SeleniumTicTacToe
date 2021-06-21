package our_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Überprüfen, dass vertikale Folge von ab 3
 * Symbolen der Gewinn bedeutet: "i" und "!" sollen nicht gewinnen
 */
public class TestCase11_GewinnVertikaleFolge extends SetupClass {
    @Test
    public void testVertical() {
        board.clickOnCell(1);
        board.clickOnCell(2);
        board.clickOnCell(6);
        board.clickOnCell(12);
        board.clickOnCell(11);
        Assert.assertTrue(board.gameIsOver());
    }

    // //Fehlerbeschreibungen Nr 4
    @Test
    public void test_i() {
        board.clickOnCell(1);
        board.clickOnCell(2);
        board.clickOnCell(5);
        board.clickOnCell(12);
        board.clickOnCell(10);
        board.clickOnCell(17);
        Assert.assertFalse(board.gameIsOver());
    }

    @Test
    public void test_inverse_i() {
        board.clickOnCell(1);
        board.clickOnCell(2);
        board.clickOnCell(5);
        board.clickOnCell(7);
        board.clickOnCell(10);
        board.clickOnCell(17);
        Assert.assertFalse(board.gameIsOver());
    }

}
