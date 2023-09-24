import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Alert {
    WebDriver chromDriver;

    @BeforeTest
    public void Setup(){
        chromDriver = new ChromeDriver();
        chromDriver.get("https://anhtester.com/contact");
        chromDriver.manage().window().maximize();
        Sleep(3000);
    }
//    @Test (priority = 0)
//    public void AlertTest(){
//        WebElement gioHang = chromDriver.findElement(By.xpath("//div[@class='cart clearfix']//a[@title='cart']"));
//        gioHang.click();
//        Sleep(1000);
//
//        org.openqa.selenium.Alert alert = chromDriver.switchTo().alert();
//        alert.accept();
//        Sleep(500);
//    }
//    @Test (priority = 1)
//    public void PopupWindows(){
//        WebElement zalo = chromDriver.findElement(By.xpath("//img[@alt='sodienthoaizalo']"));
//        zalo.click();
//
//        String mainWindow = chromDriver.getWindowHandle();
//        System.out.println("Window cha: "+mainWindow);
//
//        Set<String> windows = chromDriver.getWindowHandles();
//
//        for(String window : windows){
//            System.out.println(window);
//            if(!mainWindow.equalsIgnoreCase(window)){
//                chromDriver.switchTo().window(window);
//                Sleep(1000);
//                System.out.println("Da chuyen den window con");
//                System.out.println(chromDriver.getTitle());
//                Sleep(1000);
//                chromDriver.close();
//            }
//        }
//    }
//    @Test (priority = 2)
//    public void IFrame(){
//        int frameTotal = chromDriver.findElements(By.tagName("iframe")).size();
//        System.out.println(frameTotal);
//
//        chromDriver.switchTo().frame(0);
//        Sleep(3000);
//
//        WebElement element = chromDriver.findElement(By.xpath("/html[1]/body[1]"));
//        System.out.println(element.getText());
//    }

    @AfterTest
    public void Clear(){
        Sleep(3000);
        //chromDriver.quit();
    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
