package our_tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//Überprüfen, dass die Gewinnpunkte bei Player 1 korrekt hochgezählt werden

public class TestCase5_Player1PunkteKorrektHochgezaehlt extends SetupClass {

	//Fail ist erwartet
	//Fehlerbeschreibungen Nr 3
	@Test
	public void gewinnpunktePlayer1() {

		int Score1 = settings.getPlayer1Score();

		board.clickOnCell(1);
		board.clickOnCell(2);
		board.clickOnCell(6);
		board.clickOnCell(7);
		board.clickOnCell(11);

		int Score2 = settings.getPlayer1Score();

		if (board.isWinner(1)) {
			assertEquals(Score1 + 1, Score2);
		}
	}
}
