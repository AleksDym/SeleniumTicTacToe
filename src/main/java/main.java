import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/venancekonan/Documents/STUDIUM/HAW/Semester_5/Kurse/CT/Praktikum/P2/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
    }

}
