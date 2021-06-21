
package our_tests;

import enums.Options;
import enums.Players;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

//Überprüfen, dass Settings Fenster fehlerfrei geöffnet und geschlossen werden können

// //Fehlerbeschreibungen Nr 5

public class TestCase3_DifferentIconCombinationsAllowed extends SetupClass {

	/*Options x = Options.X;
	Options o = Options.O;
	Options o_green = Options.O_GREEN;
	Options tessa_b = Options.TESSA_B;
	Options tessa_r = Options.TESSA_R;*/


	public boolean DifferentIconsCanBeChosenParams(Options one, Options two) {
		settings.selectPlayerOption(Players.PLAYER1, one);
		settings.selectPlayerOption(Players.PLAYER2, two);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = board.getCell(0);
		WebElement cell1 = board.getCell(1);
		WebElement buttonImage0 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell0, one.label)
		));

		WebElement buttonImage1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(
				board.getImage(cell1, two.label)
		));
		return buttonImage0.isDisplayed() && buttonImage1.isDisplayed();
	}

	@Test
	public void DifferentIconsCanBeChosenALL() {
		List<WebElement> player1AllOption = settings.getAllPlayerOption(Players.PLAYER1);
		List<WebElement> player2AllOption = settings.getAllPlayerOption(Players.PLAYER2);
		for (WebElement o1: player1AllOption) {
			for(WebElement o2: player2AllOption){

				if(!o1.getText().equals(o2.getText())){
					Options param1 = null;
					Options param2 = null;

					for (Options c : Options.values()) {
						if ((c.label).equals(o1.getText())) {
							param1 = c;
						}
					}
					for (Options c : Options.values()) {
						if ((c.label).equals(o2.getText())) {
							param2 = c;
						}
					}
					assertTrue(DifferentIconsCanBeChosenParams(param1, param2), param1+" und "+param2+" koennen nicht ausgewählt werden");
				}
			}
		}
	}
/*
	@Test
	public void DifferentIconsCanBeChosenWithX() {
		DifferentIconsCanBeChosenParams(x, o);
		DifferentIconsCanBeChosenParams(x, o_green);
		DifferentIconsCanBeChosenParams(x, tessa_b);
		DifferentIconsCanBeChosenParams(x, tessa_r);
	}
	@Test
	public void DifferentIconsCanBeChosenWithO() {
		DifferentIconsCanBeChosenParams(o, x);
		DifferentIconsCanBeChosenParams(o, o_green);
		DifferentIconsCanBeChosenParams(o, tessa_b);
		DifferentIconsCanBeChosenParams(o, tessa_r);
	}

	@Test
	public void DifferentIconsCanBeChosenWithOGreen() {
		DifferentIconsCanBeChosenParams(o_green, x);
		DifferentIconsCanBeChosenParams(o_green, o);
		DifferentIconsCanBeChosenParams(o, tessa_b);
		DifferentIconsCanBeChosenParams(o, tessa_r);
	}

	@Test
	public void DifferentIconsCanBeChosenWithTessaB() {
		DifferentIconsCanBeChosenParams(tessa_b, x);
		DifferentIconsCanBeChosenParams(tessa_b, o_green);
		DifferentIconsCanBeChosenParams(tessa_b, tessa_r);
		DifferentIconsCanBeChosenParams(tessa_b, o);
	}

	@Test
	public void DifferentIconsCanBeChosenWithTessaR() {
		DifferentIconsCanBeChosenParams(tessa_r, x);
		DifferentIconsCanBeChosenParams(tessa_r, o_green);
		DifferentIconsCanBeChosenParams(tessa_r, tessa_b);
		DifferentIconsCanBeChosenParams(tessa_r, o);
	}*/

/*

	@Test
	public void DifferentIconsCanBeChosenXO() {
		settings.selectPlayerOption(Players.PLAYER1, x);
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenXOGreen() {
		settings.selectPlayerOption(Players.PLAYER1, x);
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenXTessaBlue() {
		settings.selectPlayerOption(Players.PLAYER1, x);
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenXTessaRed() {
		settings.selectPlayerOption(Players.PLAYER1, x);
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOX() {
		settings.selectPlayerOption(Players.PLAYER1, o);
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOOGreen() {
		settings.selectPlayerOption(Players.PLAYER1, o);
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOTessaRed() {
		settings.selectPlayerOption(Players.PLAYER1, o);
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOTessaBlue() {
		settings.selectPlayerOption(Players.PLAYER1, o);
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOGreenX() {
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}

	@Test
	public void DifferentIconsCanBeChosenOGreenO() {
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenOGreenTessaRed() {
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenOGreenTessaBlue() {
		settings.selectPlayerOption(Players.PLAYER1, o_green);
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaBlueX() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaBlueO() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaBlueOGreen() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaBlueTessaRed() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_b);
		settings.selectPlayerOption(Players.PLAYER2, tessa_r);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaRedX() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		settings.selectPlayerOption(Players.PLAYER2, x);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/x.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaRedO() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		settings.selectPlayerOption(Players.PLAYER2, o);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaRedOGreen() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		settings.selectPlayerOption(Players.PLAYER2, o_green);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/o_green.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	@Test
	public void DifferentIconsCanBeChosenTessaRedTessaBlue() {
		settings.selectPlayerOption(Players.PLAYER1, tessa_r);
		settings.selectPlayerOption(Players.PLAYER2, tessa_b);
		board.clickOnCell(0);
		board.clickOnCell(1);
		WebElement cell0 = driver.findElement(By.id("cell-0"));
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement buttonImage0 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell0.findElement(By.xpath("//img[@src='icons/tessa_r.png']"))
		));
		WebElement buttonImage1 = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(
				cell1.findElement(By.xpath("//img[@src='icons/tessa_b.png']"))
		));
		assertTrue(buttonImage0.isDisplayed());
		assertTrue(buttonImage1.isDisplayed());
	}
	*/

}


