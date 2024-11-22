package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseTest {
	
public WebDriver driver;
public Logger logger;
public Properties p;

	@BeforeClass (groups= {"Master", "Regression", "Sanity", "Datadriven"})
	@Parameters({ "browser"})
	public void setUp( String br) throws IOException
	{
		FileReader file=new FileReader("C:\\Users\\Admin\\eclipse-workspace\\OpencartDemo\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
		switch(br.toLowerCase())
		{
		case "chrome": driver= new ChromeDriver(); break;
		case "firefox": driver= new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default :System.out.println("Default Browser............"); return;
		}
		//driver= new ChromeDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	public String randomeNumber()
	{
		String generatenumber=RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String generatealpha=RandomStringUtils.randomAlphanumeric(10);
		return generatealpha;
	}
}
