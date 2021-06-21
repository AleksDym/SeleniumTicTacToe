package our_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Überprüfen, dass diagonale Folge ( in alle Richtungen)
 * von ab 3 Symbolen der Gewinn bedeutet:
 */
public class TestCase12_GewinnDiagonaleFolge extends SetupClass {

    //Fehlerbeschreibungen Nr 10
    @Test
    public void testDiagonalFrom_0_4() {
        board.clickOnCell(4);
        board.clickOnCell(2);
        board.clickOnCell(8);
        board.clickOnCell(9);
        board.clickOnCell(12);

        Assert.assertTrue(board.gameIsOver());
    }

    @Test
    public void testDiagonalFrom_3_0() throws InterruptedException {
        board.clickOnCell(15);
        board.clickOnCell(2);
        board.clickOnCell(11);
        board.clickOnCell(2);
        board.clickOnCell(7);
        Assert.assertTrue(board.gameIsOver());
    }

    //Fail ist erwartet
    @Test
    public void testDiagonalFrom_0_0() throws InterruptedException {
        board.clickOnCell(0);
        board.clickOnCell(2);
        board.clickOnCell(6);
        board.clickOnCell(3);
        board.clickOnCell(12);
        board.clickOnCell(13);
        Assert.assertTrue(board.gameIsOver());
    }

    //Fail ist erwartet
    @Test
    public void testDiagonalFrom_3_4() throws InterruptedException {
        board.clickOnCell(19);
        board.clickOnCell(2);
        board.clickOnCell(13);
        board.clickOnCell(2);
        board.clickOnCell(7);
        board.clickOnCell(2);
        Assert.assertTrue(board.gameIsOver());
    }


}
