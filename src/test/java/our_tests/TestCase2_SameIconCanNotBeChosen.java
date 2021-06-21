
package our_tests;
import enums.Options;
import enums.Players;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//Überprüfen, dass gleiche Symbole nicht gewählt werden können

public class TestCase2_SameIconCanNotBeChosen extends SetupClass{

	//Fail ist erwartet

	Options x = Options.X;
	Options o = Options.O;
	Options o_green = Options.O_GREEN;
	Options tessa_b = Options.TESSA_B;
	Options tessa_r = Options.TESSA_R;

	@Test
	public void sameXIconCanNotBeChosen(){
		settings.selectPlayerOption(Players.PLAYER1, x);
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, x.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, x.label)
		));
		assertNotEquals(buttonImage0, buttonImage1);
	}

	@Test
	public void sameOIconCanNotBeChosen(){
		settings.selectPlayerOption(Players.PLAYER1, o);
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, o.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, o.label)
		));
		assertNotEquals(buttonImage0, buttonImage1);
	}

	@Test
	public void sameOGreenIconCanNotBeChosen(){
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, o_green.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, o_green.label)
		));
		assertNotEquals(buttonImage0, buttonImage1);
	}

	@Test
	public void sameTessaRedIconCanNotBeChosen(){
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, tessa_r.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, tessa_r.label)
		));
		assertNotEquals(buttonImage0, buttonImage1);
	}

	@Test
	public void sameTessaBlueIconCanNotBeChosen(){
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, tessa_b.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, tessa_b.label)
		));
		assertNotEquals(buttonImage0, buttonImage1);
	}
}

