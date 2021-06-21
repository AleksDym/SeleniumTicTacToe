package models;

import enums.Options;
import enums.Players;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.html.Option;
import java.util.List;

/**
 * Page Object encapsulates the Gameboard
 */
public class GameBoard {
    protected WebDriver driver;
    protected Actions actionsBuilder;

    private By byGameEnd = By.id("gameend");

    public GameBoard(WebDriver driver) {
        this.driver = driver;
        this.actionsBuilder = new Actions(driver);
    }

    public By getBoardById() { return By.id("boardTable"); }

    public WebElement getCell(int x) {
        return driver.findElement(By.id("cell-" + String.valueOf(x)));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.className("gwt-Button"));
    }

    public void clickOnCell(int x) {
        performClick(getCell(x));
    }


    public WebElement getImage(WebElement cell, String img) {
        return cell.findElement(By.xpath(String.format("//img[@src='icons/%s.png']", img)));
    }

    public WebElement getImageTag(WebElement cell) {
        return cell.findElement(By.tagName("img"));
    }

    public String getImageSrc() {
        return driver.findElement(By.tagName("img")).getAttribute("src");
    }

    public String getImage(List<WebElement> playerAllOption, int i) {
        return String.format("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/%s.png", ((WebElement)playerAllOption.get(i)).getText());
    }

    private void performClick(WebElement element) {
        actionsBuilder.moveToElement(element).click(element);
        actionsBuilder.perform();
    }

    public boolean gameIsOver() {
        return driver.findElement(byGameEnd).isDisplayed();
    }

    public boolean isWinner(int player) {
        return driver.findElement(By.id("playerwon")).getText().equals("player"+player+" won the match!");
    }

}
