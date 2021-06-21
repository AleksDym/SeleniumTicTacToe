package our_tests;

import models.GameBoard;
import models.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SetupClass {

    protected static String appUrl = "https://ct.informatik.haw-hamburg.de/tessa_tac_toe/";
    private static String driverPath = "/Users/venancekonan/Documents/STUDIUM/HAW/Semester_5/Kurse/CT/Praktikum/P2/chromedriver";
    //private static String driverPath = "D:\\\\B-AI5\\\\CT\\\\Praktikum\\\\chromedriver.exe";
    //private static String driverPath = "/Users/valeriaserebrova/Documents/Semester_5/WP_Certified_Tester/chromedriver/chromedriver";
    //private static String driverPath = "/Users/sasa/Desktop/CT_P2/chromedriver";
    protected static WebDriver driver ;
    protected static GameBoard  board;
    protected static Settings settings;

    @BeforeTest
    public static void setUp() {
        System.out.println("launching chrome browser...");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(appUrl);
        board = new GameBoard(driver);
        settings = new Settings(driver);
    }

    @AfterMethod
    public void resetGameBoard() {
        driver.navigate().refresh();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(
                By.id("boardTable")
        ));
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }
}
