package test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.ReadExcel;

public class TestMeApp3 {
static ExtentHtmlReporter reporter;
static ExtentReports extent;
static ExtentTest test;

static WebDriver driver;
static WebDriverWait wait;


@BeforeTest
public static void beforelogin() {
	//Setting the System Property
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_d2.03.07\\Downloads\\chrome _driver\\chromedriver.exe");
	driver = new ChromeDriver();
	
	//Navigate to the URL
	driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//Implement Implicit wait
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	//Configuring the extent reports
	//reporter = new ExtentHtmlReporter("C:\\Users\\training_d2.03.07\\Desktop\\extentreports.html");
	reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/"+new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss").format(new Date())+".html");
	extent = new ExtentReports();
	
	//Adding the properties
	extent.attachReporter(reporter);
	
	extent.setSystemInfo("User Name", "GFT Training");
	extent.setSystemInfo("Host Name", "GFT Training");
	extent.setSystemInfo("Environment", "Training");
	
	reporter.config().setDocumentTitle("GFT Testing Report");
	reporter.config().setReportName("Demo in TestMeApp");
	reporter.config().setTheme(Theme.DARK);
							
}

@Test(dataProvider="data")
public static void shopping(String username, String password, String bankname, String bankusername, String bankpassword, String transactionpwd) throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	test = extent.createTest("Checking the Cart and Payout");
	//clicking login button
	driver.findElement(By.xpath(".//a[@href='login.htm']")).click();
	//sending username and password
	driver.findElement(By.id("userName")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	   
	//clicking login
	driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	Assert.assertTrue(driver.getTitle().contentEquals("Home"));
	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(".//span[contains(text(),'Categories')]"))).click().build().perform();
	Thread.sleep(3000);
	
	action.moveToElement(driver.findElement(By.xpath(".//span[contains(text(),'Home Appliances')]"))).click().build().perform();
	Thread.sleep(3000);
	
	action.moveToElement(driver.findElement(By.xpath(".//span[contains(text(),'Floor')]"))).click().build().perform();
	Thread.sleep(3000);
	
	//Clicking the add to cart button
	driver.findElement(By.xpath(".//a[contains(text(),'Add to cart')]")).click();
	
	//Clicking the Cart button
	driver.findElement(By.xpath(".//a[@href='displayCart.htm']")).click();
	
	//Clicking the Proceed to checkout
	driver.findElement(By.xpath(".//a[@href='checkout.htm']")).click();
	
	//Clicking the Proceed to pay button
	driver.findElement(By.xpath(".//input[@value='Proceed to Pay']")).click();
	
	Thread.sleep(5000);

	//handling the bank
	switch (bankname) {
	case "Andhra Bank":
		driver.findElement(By.xpath(".//label[text()='Andhra Bank']")).click();
		driver.findElement(By.xpath(".//a[text()='Continue']")).click();
		driver.findElement(By.name("username")).sendKeys(bankusername);
		driver.findElement(By.name("password")).sendKeys(bankpassword);
		driver.findElement(By.xpath(".//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).clear();
		driver.findElement(By.name("transpwd")).sendKeys(transactionpwd);
		driver.findElement(By.xpath(".//input[@value='PayNow']")).click();
		break;
	case "HDFC Bank":
		driver.findElement(By.xpath(".//label[text()='HDFC Bank']")).click();
		driver.findElement(By.xpath(".//a[text()='Continue']")).click();
		driver.findElement(By.name("username")).sendKeys(bankusername);
		driver.findElement(By.name("password")).sendKeys(bankpassword);
		driver.findElement(By.xpath(".//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).clear();
		driver.findElement(By.name("transpwd")).sendKeys(transactionpwd);
		driver.findElement(By.xpath(".//input[@value='PayNow']")).click();
		break;
	case "IDBI Bank":
		driver.findElement(By.xpath(".//label[text()='IDBI Bank']")).click();
		driver.findElement(By.xpath(".//a[text()='Continue']")).click();
		driver.findElement(By.name("username")).sendKeys(bankusername);
		driver.findElement(By.name("password")).sendKeys(bankpassword);
		driver.findElement(By.xpath(".//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).clear();
		driver.findElement(By.name("transpwd")).sendKeys(transactionpwd);
		driver.findElement(By.xpath(".//input[@value='PayNow']")).click();
		break;
	case "UCO Bank":
		driver.findElement(By.xpath(".//label[text()='UCO Bank']")).click();
		driver.findElement(By.xpath(".//a[text()='Continue']")).click();
		driver.findElement(By.name("username")).sendKeys(bankusername);
		driver.findElement(By.name("password")).sendKeys(bankpassword);
		driver.findElement(By.xpath(".//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).clear();
		driver.findElement(By.name("transpwd")).sendKeys(transactionpwd);
		driver.findElement(By.xpath(".//input[@value='PayNow']")).click();
		break;
	
	}
	
	//Assert
	Assert.assertTrue(driver.getTitle().contains("Order Details"));
	
	//Clicking the Signout button
	driver.findElement(By.xpath(".//a[@href='logout.htm']")).click();
	
	
}

@AfterTest
public static void closethebrowser() {
	driver.close();
	
	//Closing the Report
	extent.flush();
}

@AfterMethod
public static void reporting(ITestResult result) throws Exception {
	if (result.getStatus()== ITestResult.FAILURE) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod()+ " - Test Case failed ", ExtentColor.RED));
		
		//Take Screenshot
		TakesScreenshot snap = (TakesScreenshot)driver;
		
		File src = snap.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/ExtentReports/snapshots/"+result.getName()+new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss").format(new Date())+".png";
		
		//Copy the file using File Utils
		FileUtils.copyFile(src, new File(path));
		
		//Add the Screenshot to the report
		test.addScreenCaptureFromPath(path);
		
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"The Exception occured is - ", ExtentColor.RED));
		
	} else if (result.getStatus()== ITestResult.SKIP) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod()+ " - Test Case Skipped ", ExtentColor.ORANGE));
	} else if (result.getStatus()== ITestResult.SUCCESS) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod()+"- Test Case Passed", ExtentColor.GREEN));
		
		//Take Screenshot
		TakesScreenshot snap = (TakesScreenshot)driver;
		
		File src = snap.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/ExtentReports/snapshots/"+result.getName()+new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss").format(new Date())+".png";
		
		//Copy the file using File Utils
		FileUtils.copyFile(src, new File(path));
		
		//Add the Screenshot to the report
		test.addScreenCaptureFromPath(path);
		
		test.log(Status.PASS, MarkupHelper.createLabel(result.getThrowable()+"Test Case Passed", ExtentColor.GREEN));
		
	}
}

@DataProvider
public static Object[][] data() throws Exception{		
	return ReadExcel.readvalues();
}

}
