package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.utility.ExtentManager;
import com.utility.XLUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass1
{
public static WebDriver driver;

@Parameters("browser")
@BeforeTest(groups= {"smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException
	{
	    ExtentManager.setExtent(); // for extending report
	 	if(browser.equals("chrome"))
		{
	 	   //WebDriverManager.chromedriver().browserVersion("125.0.6422.61").setup(); // use this method if latest browser is not oppenning and add the version
	 		 WebDriverManager.chromedriver().setup(); 
     	     driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
     		driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			 /* WebDriverManager.iedriver().setup();
	        driver = new InternetExplorerDriver();*/ //Out dated for webdriver manager
	    	System.setProperty("webdriver.ie.driver","C:\\browserdrivers\\IEDriverServer.exe");
	        driver=new InternetExplorerDriver();
     		
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
     		driver=new EdgeDriver();	
		}
	}
@AfterTest(groups= {"smoke","sanity","Regression"})
 public void closeBrowser() throws Exception
  {
//	    driver.close();  
	    ExtentManager.endReport(); //for end extended report
  }

//data provider for log in page
@DataProvider(name="LoginData")
public String[][] getData1() throws IOException 
{
	//get the data from excel
	String path= System.getProperty("user.dir")+"\\DataFiles\\LoginData.xlsx";
	// String path= "E:\\log in data .xlsx";
	XLUtility xlutil = new XLUtility(path);
	int totalrows = xlutil.getRowCount("Sheet1");
   int totalcols = xlutil.getCellCount("Sheet1", 1);
	System.out.println("rowsnum "+totalrows);
	System.out.println("columnnum "+totalcols);
   String Regdata[][] = new String[totalrows][totalcols];
   for (int i = 1; i <= totalrows; i++) 
	  {
	   for (int j = 0; j < totalcols; j++) 
    {
	  	// Handle the data type conversion appropriately
		 try 
       {
           Regdata[i - 1][j] = String.valueOf(xlutil.getCellNumericValue("Sheet1", i, j)); //Conversation is going on here
       } 
       catch (IllegalStateException e) 
       {
           // Handle if the cell is not numeric, assuming it's a string
           Regdata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
       }
    }
 }		          
//  System.out.println("Successfully done");
//  for (int i = 1; i <= totalrows; i++) 
//  {
//    for (int j = 0; j < totalcols; j++) 
//      {
//          System.out.println(Regdata[i - 1][j]);
//      }
//  }
  return Regdata;
 }		

}
