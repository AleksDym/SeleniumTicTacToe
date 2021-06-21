package our_tests;

import enums.Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import org.testng.Assert;

//Überprüfen, dass wenn ein Player gewinnt, werden die Punkte entsprechend hochgezählt

public class TestCase4_PunkteImmerHochgezaehlt extends SetupClass {

	Options x = Options.X;
	Options o = Options.O;

	//Fail ist erwartet
	@Test
	public void Player1PunkteHochgezaehlt() throws InterruptedException {

		//round 1 - Player 1 startet und gewinnt
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, x.label)
		));
		board.clickOnCell(2);
		WebElement cell2 = board.getCell(2);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell2, o.label)
		));
		board.clickOnCell(6);
		WebElement cell6 = board.getCell(6);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell6, x.label)
		));
		board.clickOnCell(15);
		WebElement cell15 = board.getCell(15);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell15, o.label)
		));

		board.clickOnCell(11);


		WebElement buttonClose1 = board.getCloseButton();

		buttonClose1.click();
		int Score1 = settings.getPlayer1Score();



		//round 2 - pLayer 2 startet aber Gewinnt wieder Player 1

		board.clickOnCell(2);
		WebElement r2cell2 = board.getCell(2);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(r2cell2, o.label)
		));
		board.clickOnCell(6);

		WebElement r2cell6 = board.getCell(6);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(r2cell6, x.label)
		));

		board.clickOnCell(2);

		board.clickOnCell(11);
		WebElement r2cell11 = board.getCell(11);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(r2cell11, x.label)
		));
		board.clickOnCell(2);

		board.clickOnCell(16);
		WebElement r2cell16 = board.getCell(16);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(r2cell16, x.label)
		));
		board.clickOnCell(2);

		board.clickOnCell(1);

		WebElement buttonClose2 = board.getCloseButton();

		buttonClose2.click();
		int Score2 = settings.getPlayer1Score();

		Assert.assertNotEquals(Score2, Score1);
	}
}