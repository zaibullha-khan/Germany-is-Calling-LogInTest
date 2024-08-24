package TestClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.BaseClass1;
import com.pageObject.LogInPage;
@Listeners(com.utility.ListenerClass01.class)
public class LogInPageTestClass extends BaseClass1 {
	 LogInPage logInTest;
	 @Parameters("url")
     @BeforeClass
     public void OpenWebsite(String url)
     {
    	
    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	 driver.manage().deleteAllCookies();
    	 driver.manage().window().maximize();
    	 driver.get(url);
    	 logInTest=new LogInPage(driver);	 
     }
     
     @Test(dataProvider="LoginData")
     public void verifyAbleToEnterCredential(String un,String pw,String res)
     {
    	   	 
    	logInTest.enterTheCredentialInUserName(un);
    	logInTest.enterTheCredentialInPassword(pw);
    	logInTest.clickOnLoginButton();
    	
    	if(res.equals("Valid"))
    	{
    		String act_url="https://app.germanyiscalling.com/cv/upload/";
        	String exp_url=driver.getCurrentUrl();
        	Assert.assertEquals(act_url, exp_url);
        	System.out.println("valid");
        	driver.findElement(By.xpath("//a[@id='dropdownUser1']")).click();
        	driver.findElement(By.xpath("//a[@class='text-decoration-none text-danger dropdown-item']")).click();
        	
    	}
    	else
    	{
    		String act_url="https://app.germanyiscalling.com/cv/upload/";
        	String exp_url=driver.getCurrentUrl();
        	Assert.assertNotEquals(act_url,exp_url);
        	System.out.println("invalid");
    		
    	}
     }
     
}
