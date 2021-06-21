package models;

import enums.Options;
import enums.Players;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Settings {
    protected WebDriver driver;
    protected Actions actionsBuilder;

    private By byPlayer1 = By.id("player1-icon");
    private By byPlayer2 = By.id("player2-icon");
    private By byPlayer1Score = By.id("score-1");
    private By byPlayer2Score = By.id("score-2");


    public Settings(WebDriver driver) {
        this.driver = driver;
        this.actionsBuilder = new Actions(driver);
    }

    public void selectPlayerOption(Players player, Options option) {
        Select playerField;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("gwt-ListBox")));
        if (player.ordinal() == 0)
            playerField = new Select(driver.findElement(byPlayer1).findElement(By.className("gwt-ListBox")));
        else
            playerField = new Select(driver.findElement(byPlayer2).findElement(By.className("gwt-ListBox")));
        List<WebElement> allOptions = playerField.getOptions();
        for (int i=0; i < 5; i++) {
            if (allOptions.get(i).getText().equals(option.label)) {
                allOptions.get(i).click();
            }
        }
    }

    public List<WebElement> getAllPlayerOption(Players player){
        Select playerField;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("gwt-ListBox")));
        if (player.ordinal() == 0)
            playerField = new Select(driver.findElement(byPlayer1).findElement(By.className("gwt-ListBox")));
        else
            playerField = new Select(driver.findElement(byPlayer2).findElement(By.className("gwt-ListBox")));
        List<WebElement> allOptions = playerField.getOptions();
        return allOptions;
    }
    public int getPlayer1Score() {
        return stringToInt(driver.findElement(byPlayer1Score).getText());
    }

    public int getPlayer2Score() {
        return stringToInt(driver.findElement(byPlayer2Score).getText());
    }

    public static int stringToInt(String x) {
        try {
            return Integer.parseInt(x);
        }
        catch (Exception ex) {
            return 0;
        }
    }

}
