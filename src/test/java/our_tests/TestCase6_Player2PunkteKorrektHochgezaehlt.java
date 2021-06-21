package our_tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

//Überprüfen, dass die Gewinnpunkte bei Player 2 korrekt hochgezählt werden

public class TestCase6_Player2PunkteKorrektHochgezaehlt extends SetupClass {

    //Fail ist erwartet
    //Fehlerbeschreibungen Nr 3
    @Test
    public void gewinnpunktePlayer2() {

        int Score1 = settings.getPlayer2Score();

        board.clickOnCell(2);
        board.clickOnCell(1);
        board.clickOnCell(7);
        board.clickOnCell(6);
        board.clickOnCell(16);
        board.clickOnCell(11);

        int Score2 = settings.getPlayer2Score();

        if (board.isWinner(2)) {
            assertEquals(Score1 + 1, Score2);
        }
    }
}