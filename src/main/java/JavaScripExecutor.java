<<<<<<< HEAD
import io.netty.util.Timeout;
=======
>>>>>>> de9c20e34bd26b866e40eba43eaf50644f0103e2
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
=======
>>>>>>> de9c20e34bd26b866e40eba43eaf50644f0103e2
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

<<<<<<< HEAD
import java.time.Duration;
import java.util.concurrent.TimeUnit;

=======
>>>>>>> de9c20e34bd26b866e40eba43eaf50644f0103e2
public class JavaScripExecutor {
    WebDriver chromDriver;

    @BeforeTest
    public void Setup(){
        chromDriver = new ChromeDriver();
        chromDriver.get("https://demoqa.com/");
<<<<<<< HEAD
        chromDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
=======
>>>>>>> de9c20e34bd26b866e40eba43eaf50644f0103e2
        chromDriver.manage().window().maximize();
        Sleep(3000);
    }
    @Test
    public void JavaScriptExcutor(){
        JavascriptExecutor js = (JavascriptExecutor) chromDriver;

        WebElement btn = chromDriver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]/div[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",btn);
        Sleep(500);
        btn.click();
    }
<<<<<<< HEAD
    @Test
    public void Wait(){
        WebDriverWait wait = new WebDriverWait(chromDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/Toolsqa.jpg']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/images/Toolsqa.jpg']")));

        chromDriver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).click();
    }
=======
>>>>>>> de9c20e34bd26b866e40eba43eaf50644f0103e2
    @AfterTest
    public void Clear(){
        Sleep(3000);
        chromDriver.quit();
    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
