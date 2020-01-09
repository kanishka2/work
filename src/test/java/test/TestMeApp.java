package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.ReadExcel;


public class TestMeApp {
	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	static ExtentTest test;
	
	static WebDriver driver;
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
//signup
@Test(priority=0)
public static void signUp()
{ test = extent.createTest("Sign up");
//WebDriverWait wait = new WebDriverWait(driver, 10);
  
//providing implicit wait
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

//clicking on the signup button
driver.findElement(By.xpath(".//a[@href='RegisterUser.htm']")).click();
test.log(Status.INFO,"Clicked on the Sign Up Button");

//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='Username']"))));

//Enter the values
//Entering the username
driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("ASWER410110148");
test.log(Status.INFO,"Entered the username");

//Entering the firstname
driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("bvcnbhfd");
test.log(Status.INFO,"Entered the First Name");

//Entering the lastname
driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("kjhjkd");
test.log(Status.INFO,"Entered the Last Name");

//Entering the password
driver.findElement(By.xpath("//*[@id='password']")).sendKeys("kkk134ASDF");
test.log(Status.INFO,"Entered the Password");

driver.findElement(By.xpath("//*[@id='pass_confirmation']")).sendKeys("kkk134ASDF");
test.log(Status.INFO,"Confirmed Password");

//gender
driver.findElement(By.xpath(".//input[@value='Female']")).click();
//Entering the Email
driver.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys("kanishka@gmail.com");
test.log(Status.INFO,"Entered the Email");

//Entering the Mobile Number
driver.findElement(By.xpath("//*[@id='mobileNumber']")).sendKeys("9988855584");
test.log(Status.INFO,"Entered the Email");

//Entering the Date of Birth
driver.findElement(By.xpath("//*[@id='dob']")).sendKeys("07/12/1994");
test.log(Status.INFO,"Entered the dateofbirth");

//Entering the Address
driver.findElement(By.xpath("//*[@id='address']")).sendKeys("Model Town");
test.log(Status.INFO,"Entered the address");

Select security=new Select(driver.findElement(By.name("securityQuestion")));
security.selectByVisibleText("What is your Birth Place?");
test.log(Status.INFO,"Select security question");


driver.findElement(By.xpath("//*[@id='answer']")).sendKeys("Delhi");
test.log(Status.INFO,"Entered the answer");



driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();




}

//Login
@Test(priority=1)
public static void login()
{
	 test = extent.createTest("Login");
	  
	//providing implicit wait
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	

	
	//username entered
	driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("ASWER410110148");
	test.log(Status.INFO,"Entered the username");
	
	
	//password entered
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys("kkk134ASDF");
	test.log(Status.INFO,"Entered the Password");
	
	driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	
}

@Test(priority=2)
public static void item()
{
	 test = extent.createTest("Item");
	  
	//providing implicit wait
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[2]/a")).click();
driver.findElement(By.xpath("//*[@id=\"submenuul11292\"]/li[1]/a/span")).click();
driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
}

@Test(priority=3)
public static void addcart()
{
	 test = extent.createTest("addcart");
	  
	//providing implicit wait
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("Lalitha");
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password123");
	driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"submenuul11292\"]/li[1]/a/span")).click();
	
	
	
	
	
	
	
}

//driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();


	
 @AfterTest
	public static void closethebrowser() {
		//driver.close();
		
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
