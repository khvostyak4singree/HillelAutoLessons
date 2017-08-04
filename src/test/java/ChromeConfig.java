import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.net.URL;

public class ChromeConfig {

    protected WebDriver driver;

    @BeforeTest
    protected void startChrome()  throws Exception {
        System.setProperty("webdriver.chrome.driver","bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("/usr/bin/google-chrome");
        //options.addArguments("--no-sandbox");
        //driver = new ChromeDriver(options);

        driver = new RemoteWebDriver(
                                new URL("http://192.168.3.255:9505/"), 
                                DesiredCapabilities.chrome());

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
