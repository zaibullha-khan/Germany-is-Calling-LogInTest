package com.actionDriver;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	//java script exicutor for scroll down
	public static void scrollElement(WebDriver Idriver, WebElement ele) 
	{
		JavascriptExecutor js = (JavascriptExecutor) Idriver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'})", ele);

	}
	//Select by index
	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (flag)
			{
				System.out.println("Option selected by Index");
			} 
			else 
			{
				System.out.println("Option not selected by Index");
			}
		}
	}
	// select by value
	public static boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) 
		{

			return false;
		} 
		finally 
		{
			if (flag) 
			{
				System.out.println("Option selected by Value");
			}
			else 
			{
				System.out.println("Option not selected by Value");
			}
		}
	}
// slect by visible text
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try 
		{
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (flag) 
			{
				System.out.println("Option selected by VisibleText");
			}
			else 
			{
				System.out.println("Option not selected by VisibleText");
			}
		}
	}
			//click action method
			public static void click(WebDriver Idriver,WebElement locatorName)
			{
				Actions act=new Actions(Idriver);
				act.moveToElement(locatorName)
				.click()
				.build()
				.perform();
			}
			//
			public static void doubleClick(WebDriver Idriver,WebElement locatorName)
			{
				Actions act=new Actions(Idriver);
				act.moveToElement(locatorName)
				.doubleClick()
				.build()
				.perform();
			}
			 // Right click context menu action method
		    public static void rightClick(WebDriver Idriver,WebElement locatorName) {
		        Actions actions = new Actions(Idriver);
		        actions.contextClick(locatorName).build().perform();
		        }
		 // Hover over an element action method
		    public void hoverOver(WebDriver Idriver,WebElement locatorName) {
		        Actions actions = new Actions(Idriver);
		        actions.moveToElement(locatorName).build().perform();
		    }
			//findElement action method
		    public static boolean findElement(WebDriver driver, WebElement ele) {
				boolean flag = false;
				try {
					ele.isDisplayed();
					flag = true;
				} catch (Exception e) {
					// System.out.println("Location not found: "+locatorName);
					flag = false;
				} finally {
					if (flag) {
						System.out.println("Successfully Found element at");

					} else {
						System.out.println("Unable to locate element at");
					}
				}
				return flag;
			}
			// isDisplayed action method
		    
		    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
				boolean flag = false;
				flag = findElement(driver, ele);
				if (flag) {
					flag = ele.isDisplayed();
					if (flag) {
						System.out.println("The element is Displayed");
					} else {
						System.out.println("The element is not Displayed");
					}
				} else {
					System.out.println("Not displayed ");
				}
				return flag;
			}
		    
		    
//			 public static boolean  isDisplayed(WebDriver Idriver, WebElement ele) 
//				 {
//				 try
//				 {
//				   if(ele.isDisplayed())
//				   {
//					   System.out.println("The element is displayed");
//				   }
//				   else
//				   {
//					   System.out.println("The element is not displayed");
//				   }
//				 }
//				 catch(Exception e)
//				 {
//					 System.out.println(e);
//				 }
//				return false;
//					
//				 }
				
			 // isSelected action method
			 public static boolean isSelected(WebDriver Idriver,WebElement ele)
			 {
				 boolean flag=false;
				 flag=findElement(Idriver,ele);
				if(flag)
				{
					flag=ele.isSelected();
					if(flag)
					{
						System.out.println("The element is selected");
					}
					else
					{
						System.out.println("The element is not selectd");
						
					}
				}
				else
				{
					System.out.println("Not selected");
				} 
				return flag; 
			 }
		//isEnabled action Method
			 public static boolean isEnabled(WebDriver Idriver,WebElement ele)
			 {
				 boolean flag=false;
				 flag=findElement(Idriver,ele);
				if(flag)
				{
					flag=ele.isEnabled();
					if(flag)
					{
						System.out.println("The element is selected");
					}
					else
					{
						System.out.println("The element is not selectd");
					}
				}
				else
				{
					System.out.println("Not selected");
				} 
				return flag; 
			 }
			 // type acion class
			 public static boolean type(WebElement ele,String text)
			 {
				 boolean flag=false;
				 try
				 {
					flag=ele.isDisplayed();
//					Actions action=new Actions(driver);
//					action.click(ele)
//					.keyDown(Keys.CONTROL) // Press control key
//					.sendKeys("a")         //select
//					.keyUp(Keys.CONTROL) // Releas control key
//					.sendKeys(Keys.BACK_SPACE) // Clear	
//					.build().perform();       //perform
					//or
					ele.clear();
					ele.sendKeys(text);
					//Logger.info ("Entered text;" +text);
					flag=true;
				 }
				 catch(Exception e)
				 {
					 System.out.println("Location not found");
					 flag=false;
				 }
				 finally
				 {
						if(flag)
						{
							System.out.println("The element is entered");
						}
						else
						{
							System.out.println("The element is not entered");
						}  
				 }
				 
				return flag; 
			 }
			 //
			 public static void copy(WebDriver Idriver,WebElement ele)
			 {
				 Actions action=new Actions(Idriver); 
				 action.moveToElement(ele)
				 
				 .keyDown(Keys.CONTROL)
				 .sendKeys("a")
				 .sendKeys("c")
				 .keyUp(Keys.CONTROL)
				 .build().perform();
				 
			 }
			 ///
			 public static void paste(WebDriver Idriver,WebElement ele)
			 {
				 Actions action=new Actions(Idriver); 
				 action.moveToElement(ele)
				 .keyDown(Keys.CONTROL)
				 .sendKeys("v")
				 .keyUp(Keys.CONTROL)
				 .build().perform();
				 
			 }
			 ///
			 public static void delete(WebDriver Idriver,WebElement ele)
			 {
				 Actions action=new Actions(Idriver); 
				 action.moveToElement(ele)
				 .keyDown(Keys.CONTROL)
				 .sendKeys("a")
				 .sendKeys(Keys.DELETE)
				 .keyUp(Keys.CONTROL)
				 .build().perform();
				 
			 }
			 //BackSpace action methods
			 public static void backSpace(WebDriver Idriver,WebElement ele)
			 {
				 Actions action=new Actions(Idriver); 
				 action.moveToElement(ele)
				 .keyDown(Keys.CONTROL)
				 .sendKeys("a")
				 .sendKeys(Keys.BACK_SPACE)
				 .keyUp(Keys.CONTROL)
				 .build().perform();
				 
			 }
			 // Get attribute value action method
			    public static String getAttributeValue(WebElement ele)
			    {
			        return ele.getAttribute("value");
			    }

			    // Switch to a different frame by index action method
			    public static void switchToFrame( WebDriver driver,int frameIndex) {
			        driver.switchTo().frame(frameIndex);
			    }

			    // Switch to a different frame by name or ID action method
			    public static void switchToFrame(WebDriver driver,String frameNameOrId) {
			        driver.switchTo().frame(frameNameOrId);
			    }

			    // Switch back to the default content action method
			    public static void switchToDefaultContent(WebDriver driver) {
			        driver.switchTo().defaultContent();
			    }
			    //
			    public static void moveToElement(WebDriver Idriver,WebElement element) {
			    	Actions act=new Actions(Idriver);
			        act.moveToElement(element).build().perform();
			    }
			    //
			    public static void moveToElementAndDragAndDropBy(WebDriver Idriver,WebElement slider, int xOffset, int yOffset) 
			    {
			    	Actions act=new Actions(Idriver);
			        act.moveToElement(slider).dragAndDropBy(slider, xOffset, yOffset).perform();
			    }
			    //
			    public static void dragAndDropBy(WebDriver Idriver,WebElement slider, int xOffset, int yOffset) {
			    	Actions act=new Actions(Idriver);
			        act.dragAndDropBy(slider, xOffset, yOffset).perform();
			    }
			    //
			    public static void moveToElementAndDragAndDrop(WebDriver Idriver,WebElement source, WebElement target) 
			    {
			    	  Actions act=new Actions(Idriver);
			        act.moveToElement(source).dragAndDrop(source, target).perform();
			    }
			    //
			    public static void dragAndDrop(WebDriver Idriver,WebElement source, WebElement target) {
			    	Actions act=new Actions(Idriver);
			        act.dragAndDrop(source, target).build().perform();
			    }    
			    //Screenshot
			    public static String screenShot(WebDriver driver, String filename) 
			    {
					String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
					File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
					String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

					try {
						FileUtils.copyFile(source, new File(destination));
					} catch (Exception e) {
						e.getMessage();
					}
					// This new path for jenkins
			        //String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"+ dateName + ".png";
					return destination;
		       }
			    
			    
			    
			    
			    
			    // takeScreenShot
			    public static void takeScreenShot(WebDriver driver,String filename)
			    {
			    TakesScreenshot takeScreenShot=(TakesScreenshot) driver;
				File source=takeScreenShot.getScreenshotAs(OutputType.FILE);
				try {
					//FileUtils.copyFile(source,new File("C:\\Users\\zaibu\\eclipse-workspace\\wwee\\ScreenShots\\ScreenShot1.png"));
					FileUtils.copyFile(source,new File( System.getProperty("user.dir") + "\\ScreenShots\\" + filename + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			    //Autosuggestion dropDown
			   
			    ///
			    public static void autosuggDropDown(List<WebElement> ele, String TextValue) {
			        try {
			            List<WebElement> list = ele;
			            //System.out.println(list.size());

			            for (WebElement auto_suggestion : list) {
			                String value = auto_suggestion.getText();
			                //System.out.println(value);
			                if (value.equals(TextValue)) {
			                    auto_suggestion.click();
			                    break; // Break out of the loop after clicking on the desired option
			                }
			            }
			        } catch (Exception e) {
			            System.out.println("An exception occurred: " + e.getMessage());
			            // Handle or log the exception as needed
			        }
			    }
			    
//			 // generateName Random name
//			    public static void generateName(WebElement ele,int length)
//			    {
//			    	StringBuilder name = new StringBuilder();
//			        for (int i = 0; i < length; i++) 
//			        {
//			            // Assuming you want to generate random uppercase letters
//			            char randomChar = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
//			           name.append(randomChar); 
//			        }
//			         String generateName=name.toString();
//			         ele.sendKeys(generateName);	
//					
//			      }
			   // generatePassword Random generateValidPassword
			   public static void generateValidPassword(WebElement ele,int PASSWORD_LENGTH) {
		        final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		        //final int PASSWORD_LENGTH = 16;
		        final String REGEX_PATTERN =  "^(?![!@#$%_])[A-Za-z0-9!@#$%_]*(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^!@#$%_]*[!@#$%_][^!@#$%_]*{1})[A-Za-z0-9!@#$%_]{8,20}$";
		                                      //"^(?![!@#$%_])[A-Za-z0-9!@#$%_]*(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^!@#$%_]*[!@#$%_][^!@#$%_]*{1})[A-Za-z0-9!@#$%_]{8,20}$";
		        while (true) 
                {
		                SecureRandom random = new SecureRandom();
		                StringBuilder password = new StringBuilder();
		                for (int i = 0; i < PASSWORD_LENGTH; i++) 
		                {
		                    int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
		                    char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
		                    password.append(randomChar);
		                }
		                String generatedPassword = password.toString();
		                if (generatedPassword.matches(REGEX_PATTERN))
		                {
		                    System.out.println("Generated password is valid");
		                    ele.sendKeys(generatedPassword);  //return generatedPassword;
		                   System.out.println(generatedPassword);
		                    break;
		                }
		        }
		    }
			// generateName Random text for text field for  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~"
			   public static void generateValidText(WebElement ele,int PASSWORD_LENGTH) {
				   final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~";
			        final String REGEX_PATTERN = 
			        		"^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])"
			        		+ "(?=.*[!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>/?`~])"
			        		+ "[A-Za-z0-9!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>/?`~]{3,205}$";
                               
		        while (true) 
                {
		                SecureRandom random = new SecureRandom();
		                StringBuilder Text = new StringBuilder();
		                for (int i = 0; i < PASSWORD_LENGTH; i++) 
		                {
		                    int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
		                    char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
		                   Text.append(randomChar);
		                }
		                String generatedText = Text.toString();
		                if (generatedText.matches(REGEX_PATTERN))
		                {
		                    System.out.println("Generated password is valid");
		                    ele.sendKeys(generatedText);  //return generatedPassword;
		                   System.out.println(generatedText);
		                    break;
		                }
		        }
		    }
			// generateName Random text for Name field for  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			   public static void generateValidNameText(WebElement ele,int Text_Length) {
				   final String ALLOWED_CHARACTERS ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			        final String REGEX_PATTERN ="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{3,205}$";
                               
		        while (true) 
                {
		                SecureRandom random = new SecureRandom();
		                StringBuilder NameText = new StringBuilder();
		                for (int i = 0; i < Text_Length; i++) 
		                {
		                    int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
		                    char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
		                    NameText.append(randomChar);
		                }
		                String generateName = NameText.toString();
		                if (generateName.matches(REGEX_PATTERN))
		                {
		                    System.out.println("Generated password is valid");
		                    ele.sendKeys(generateName);  //return generatedPassword;
		                   System.out.println(generateName);
		                    break;
		                }
		        }
		    }
			// generateName Random numbertext for Number field for  "0123456789";
			   public static void generateValidNumber(WebElement ele) {
				   final String ALLOWED_CHARACTERS ="0123456789";
			        final String REGEX_PATTERN ="^(?!.*(\\d).*\\1)[0-9]{1,20}$"; //cant repeat
			                                     //^(?=.*[0-9])[0-9]{1,20}$ //for repeatation
			        final int length=10;           
		        while (true) 
                {
		                SecureRandom random = new SecureRandom();
		                StringBuilder numbertext = new StringBuilder();
		                for (int i = 0; i < length; i++) 
		                {
		                    int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
		                    char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
		                    numbertext.append(randomChar);
		                }
		                String generatedNumber = numbertext.toString();
		                if (generatedNumber.matches(REGEX_PATTERN))
		                {
		                    System.out.println("Generated password is valid");
		                    ele.sendKeys(generatedNumber);  //return generatedPassword;
		                   System.out.println(generatedNumber);
		                    break;
		                }
		        }
		    }
			   
                //getText method
			   public static String gettext(WebElement ele)
			   {
				   try {
					    ele.getText();  
				   }
					   
				catch (Exception e) {
					    // Handle other exceptions that might occur
					    System.err.println("An unexpected error occurred: " + e.getMessage());
					}
				return null;
			   }
			   // WebDriverWait for elemet visible
			   public static void WebDriverWait(WebDriver Idriver,int Duration,WebElement ele)
			   {
				   try {
				    WebDriverWait wait=new WebDriverWait(Idriver,Duration);
				 	wait.until(ExpectedConditions.visibilityOf(ele)); //Expilcitlywait for individual
				   } 
				   catch (TimeoutException e) 
				   {
				        // Handle TimeoutException (e.g., log the error, take a screenshot, etc.)
				        System.err.println("Timeout waiting for element to be visible: " + e.getMessage());
				    } 
				   catch (Exception e)
				   	{
				        // Handle other exceptions (e.g., log the error, take a screenshot, etc.)
				        System.err.println("An unexpected exception occurred: " + e.getMessage());
				    }
				   
			   }

}
			    

                