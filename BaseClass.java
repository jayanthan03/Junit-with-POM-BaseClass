package org.JUnit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	static WebDriver driver;
	static Actions ac;
    static Alert a;
    static Robot r;
    static JavascriptExecutor js;
    static  Select s;
    //1.
	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jayanthan\\eclipse-workspace\\SampleMaven\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	//2.
	public static void getUrl(String url) {
		
    driver.get(url);
	}
	//3.
	public static  void type(WebElement element,String name) {
    element.sendKeys(name);
	}
	//4.
    public static void click(WebElement element) {
    element.click();
    }
    //5.
    public static void quitBrowser() {
     driver.quit();
	}
    //6.
    public static String textGet(WebElement element) {
      String s=element.getText();
	return s;
	}
    //7.
    public static void attributeget(WebElement element) {
    String s= element.getAttribute("value");
	}
    //8.
    public static void enabled(WebElement element) {
    boolean enabled = element.isEnabled();
	}
    //9.
    public static void displayed(WebElement element) {
    boolean displayed = element.isDisplayed();
	}
    //10.
    public static void selected(WebElement element) {
    boolean selected = element.isSelected();
	}
    //10.
    public static void titleGettitle() {
    String s=driver.getTitle();
}
    //11.
    
    public static void currenturl() {
    String s = driver.getCurrentUrl();
	}
    //12.
    public static void getWindow() {
     String s = driver.getWindowHandle();
	}
    //13.
    public static void getWindows() {
    Set<String> handles = driver.getWindowHandles();
	}
    //14.
    public static void drag(WebElement element,WebElement element1) {
      ac=new Actions(driver);
      ac.dragAndDrop(element, element1);
	}
    //15.
    public static void mouseOver(WebElement element) {
        ac=new Actions(driver);
        ac.moveToElement(element).perform();
	}
    //16.
    public static void rightClick(WebElement element) {
        ac=new Actions(driver);
    ac.contextClick(element).perform();
	}
    //17.
    public static void doubleclick(WebElement element) {
    ac.doubleClick(element).perform();
	}
    //18.
    public static void acceptAlert() {
    a=driver.switchTo().alert();
    a.accept();
	}
    //19.
    public static void dismissAlert() {
        a=driver.switchTo().alert();
       a.dismiss();
	}
    //20.
    public static void fillAlert(String value) {
        a=driver.switchTo().alert();
        a.sendKeys(value);
	}
    //21.
    public static void close() {
    driver.close();
    }
    //22.
    public static void navigate(String url) {
    driver.navigate().to(url);
	}
    //23.
    public static void navigateBack() {
    driver.navigate().back();
	}
    //24.
    public static void navigatefront() {
    driver.navigate().forward();
	}
    //25.
    public static void maximize() {
    driver.manage().window().maximize();
	}
    //26.
    public static void switchFrame(int index) {
    driver.switchTo().frame(index);
	}
    //27.
    public static void switchFrame1(String id) {
    driver.switchTo().frame(id);
	}
    //28.
    public static void switchframe2(WebElement element) {
    driver.switchTo().frame(element);
	}
    //29.
    public static void parentFrame() {
    driver.switchTo().parentFrame();
	}
    //30.
    public static void frameDefault() {
    driver.switchTo().defaultContent();
	}
    //31.
    public static void thread(int millis) throws Throwable {
    Thread.sleep(millis);
	}
    //31.
    public static void robotUp() throws Throwable {
    r=new Robot();
    r.keyPress(KeyEvent.VK_UP);
    r.keyRelease(KeyEvent.VK_UP);
	}
    //32.
    public static void robotEnter() throws Throwable {
        r=new Robot();
       r.keyPress(KeyEvent.VK_ENTER); 
       r.keyRelease(KeyEvent.VK_ENTER); 
	}
    //33.
    public static void robotDown() throws AWTException {
        r=new Robot();
        r.keyPress(KeyEvent.VK_DOWN); 
        r.keyRelease(KeyEvent.VK_DOWN);
	}
    //34.
    public static void robotSelectAll() throws Throwable {
        r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL); 
        r.keyPress(KeyEvent.VK_A); 
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_A);
	}
    //35.
    public static void takeScreenShot(String path) throws Throwable {
    TakesScreenshot tk=(TakesScreenshot)driver;
    File s = tk.getScreenshotAs(OutputType.FILE);
    File d=new File(path);
    FileUtils.copyFile(s, d);
	}
    //36.
    public static void insertJavaScript(String text,WebElement element) {
    js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0],setAttribute('value','text')", element);
	}
    //37.
    public static void clickJS(WebElement element) {
    js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()", element);
	}
    //38.
    
    public static void scrollUpJs(WebElement element) {
    	js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(false)", element);	
        }
    //39.
    public static void scrollDownJs(WebElement element) {
    	js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
    //40.
    public static void selectbyvisibletext(WebElement element,String value) {
    s=new Select(element);
    s.selectByVisibleText(value);
	}
    //41.
    public static void selectbyIndex(WebElement element,int index) {
        s=new Select(element);
        s.selectByIndex(index);
	}
    //42.
    public static void selectbyValue(WebElement element,String value) {
        s=new Select(element);
s.deselectByValue(value);
	}
}

