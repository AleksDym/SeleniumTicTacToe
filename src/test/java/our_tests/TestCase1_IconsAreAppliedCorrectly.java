
package our_tests;

import enums.Options;
import enums.Players;
import models.GameBoard;
import models.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// Überprüfen, dass die Eingegebene Symbole für beide Players korrekt gespeichert und angewendet werden

public class TestCase1_IconsAreAppliedCorrectly extends SetupClass {

	@Test
	public void player1_Icon_x_Matches() {
		Options x = Options.X;
		settings.selectPlayerOption(Players.PLAYER1, x);
		board.clickOnCell(0);
		WebElement cell0 = board.getCell(0);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, x.label)
		));
		assertTrue(buttonImage.isDisplayed());
	}

	@Test
	public void player1_Icon_o_Matches() {
		Options o = Options.O;
		settings.selectPlayerOption(Players.PLAYER1, o);
		board.clickOnCell(0);
		WebElement cell0 = board.getCell(0);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, o.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player1_Icon_o_green_Matches() {
		Options o_green = Options.O_GREEN;
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		board.clickOnCell(0);
		WebElement cell0 = board.getCell(0);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, o_green.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player1_Icon_tessa_r_Matches() {
		Options tessa_r = Options.TESSA_R;
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		board.clickOnCell(0);
		WebElement cell0 = board.getCell(0);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, tessa_r.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player1_Icon_tessa_b_Matches() {
		Options tessa_b = Options.TESSA_B;
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		board.clickOnCell(0);
		WebElement cell0 = board.getCell(0);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, tessa_b.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player2_Icon_o_green_Matches() {
		Options o_green = Options.O_GREEN;
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		//bei jedem Test wird das Board neu gestartet - das bedeutet, dass Player 1 wird immer zuerst klicken. Wir brauchen Player 2 zu pruefen
		//deswegen klicken wir zweimal
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, o_green.label)));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player2_Icon_tessa_r_Matches() {
		Options tessa_r = Options.TESSA_R;
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, tessa_r.label)
		));
		assertTrue(buttonImage.isDisplayed());
	}

	@Test
	public void player2_Icon_x_Matches() {
		Options x = Options.X;
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, x.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player2_Icon_o_Matches() {
		Options o = Options.O;
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, o.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}

	@Test
	public void player2_Icon_tessa_b_Matches() {
		Options tessa_b = Options.TESSA_B;
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, tessa_b.label)
		));
		assertTrue(buttonImage.isDisplayed());

	}
}
