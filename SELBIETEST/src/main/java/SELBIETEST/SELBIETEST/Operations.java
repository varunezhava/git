package SELBIETEST.SELBIETEST;




import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

 class Operations 
{
	 public static WebDriver IEDriver;
	 public static Properties pro =new Properties();
	 public static String winHandleBefore;
	 public static String winHandle;

	public Properties loadrepository() throws IOException{
		
		 
		InputStream input = new FileInputStream("Obj_repo.properties");
		pro.load(input);
			 
	
		 
		 
		 	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"\\IEDriverServer.exe");
			IEDriver = new InternetExplorerDriver();
			  IEDriver.manage().window().maximize();
									return pro;
	 }

	public int Login(String url, String usrnameloc,  String usrnm, String passwdloc,  String passwd)
	{
		IEDriver.get(url);
		String locatorProperty = pro.getProperty(usrnameloc);
		String uidtype = locatorProperty.split(":")[0];
		String uid = locatorProperty.split(":")[1];
		
		String locatorProperty1 = pro.getProperty(passwdloc);
		String passwdid = locatorProperty1.split(":")[1];
		
		
		switch (uidtype){
		case "id" :
			
			IEDriver.findElement(By.id(uid)).sendKeys(usrnm);
			IEDriver.findElement(By.id(passwdid)).sendKeys(passwd);
			break;
			
		case "name"	:
			
			IEDriver.findElement(By.name(uid)).sendKeys(usrnm);
			IEDriver.findElement(By.name(passwdid)).sendKeys(passwd);
			break;
		case "xpath"	:
			
			IEDriver.findElement(By.xpath(uid)).sendKeys(usrnm);
			IEDriver.findElement(By.xpath(passwdid)).sendKeys(passwd);	
			break;
		case "cssselector"	:
			
			IEDriver.findElement(By.cssSelector(uid)).sendKeys(usrnm);
			IEDriver.findElement(By.cssSelector(passwdid)).sendKeys(passwd);		
			break;
		default:
			System.out.println("element is not found");
			return 0;
		}	
		
		List<WebElement> elems = IEDriver.findElements(By.tagName("input"));
		Iterator<WebElement> iter = elems.iterator();
		
		while (iter.hasNext()){
			
			WebElement curr = iter.next();
			
			if (curr.getAttribute("type").equals("submit")){
				
				curr.submit();
				return 1;
			}
				
			
		}
		
		return 0;	
		
	}
	
	public int autopopulator(String inputloc, String val){
		
		IEDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String locatorProperty = pro.getProperty(inputloc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		
		switch (idtype){
		case "id" :
			
			IEDriver.findElement(By.id(id)).sendKeys(val + Keys.TAB);
			break;
			
		case "name"	:
			
			IEDriver.findElement(By.name(id)).sendKeys(val + Keys.TAB);
			break;
		case "xpath"	:
			
			IEDriver.findElement(By.xpath(id)).sendKeys(val + Keys.TAB);
			break;
		case "cssselector"	:
			
			IEDriver.findElement(By.cssSelector(id)).sendKeys(val + Keys.TAB);
			break;
		default:
			System.out.println("Invalid idtype");
			return 0;
		}
		
		
		return 1;
	}
	
	public int MainRadio(String val, String boxloc){
		
		String locatorProperty = pro.getProperty(boxloc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		
		IEDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(idtype.equals("xpath")){
		
		WebElement clss = IEDriver.findElement(By.xpath(id));
		
		List<WebElement> radiolist = clss.findElements(By.tagName("input"));
		Iterator<WebElement> iter = radiolist.iterator();
		radiolist.size();
		while(iter.hasNext()){
			
			WebElement curr = iter.next();
			WebElement prent;
			prent = curr.findElement(By.xpath("./.."));
			String innertxt = prent.getText();
			if((innertxt).equals(val)){
				curr.click();
				return 1;
				
				}
				//return 0;
			}
		
		}
		else{
			
			System.out.println("MainRadio accepts only xpath as identifier");
		}
			
	
			
			return 0;
	
		
	}
	
	public int waitcomplete(String boxloc) throws InterruptedException{
		
		String locatorProperty = pro.getProperty(boxloc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		IEDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
		WebElement tofind;
		
		boolean done;
		switch(idtype){
		
		case "name":
			done=false;
			tofind=IEDriver.findElement(By.name(id));
			while(!done){
				if(tofind.isDisplayed()){
				done =true;
					return 1;
					
				}else{
					Thread.sleep(5000);
				}
			}
					break;
		case "id":
			done=false;
			tofind=IEDriver.findElement(By.id(id));
			while(!done){
				if(tofind.isDisplayed()){
				done =true;
					return 1;
					
				}else{
					Thread.sleep(5000);
				}
			}
					break;
		case "xpath":
					
					done=false;
					try{
					tofind=IEDriver.findElement(By.xpath(id));
					while(!done){
						if(tofind.isDisplayed()){
						done =true;
							return 1;
							
						}else{
							Thread.sleep(5000);
						}
					}
					}catch(NoSuchElementException MSEE){
					    MSEE.printStackTrace();
					}
					break;
		case "cssSelector":
			done=false;
			tofind=IEDriver.findElement(By.cssSelector(id));
			while(!done){
				if(tofind.isDisplayed()){
				done =true;
					return 1;
					
				}else{
					Thread.sleep(5000);
				}
			}
					break;
		default:
			System.out.println("Invalid idtype");
			return 0;
					
					
		}
		
		return 0;
		
	}
	
	public int clickbutton(String buttonloc) throws InterruptedException
{
		if(buttonloc.equals("bie.sicselectbutton")){
			
			List<WebElement> selectlist= IEDriver.findElements(By.tagName("button"));
			Iterator<WebElement> iter = selectlist.iterator();
			selectlist.size();
			int i=1;
			while(iter.hasNext()){
				
				WebElement currele = iter.next();
				if(i==4){
					currele.sendKeys("");
					currele.sendKeys(Keys.ENTER);
					//currele.click();
					
				}
				i=i+1;
			}
			return 1;

		}
		String locatorProperty = pro.getProperty(buttonloc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		IEDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		switch(idtype){
		
		case "id":
		
				IEDriver.findElement(By.id(id)).sendKeys("");
				if(buttonloc.contains("checkbox")){
				IEDriver.findElement(By.id(id)).sendKeys(Keys.SPACE);
				}else{
					IEDriver.findElement(By.id(id)).click();
				}
			
			return 1;
	
		
		case "name":
			
			IEDriver.findElement(By.name(id)).sendKeys("");
			if(buttonloc.contains("checkbox")){
				IEDriver.findElement(By.name(id)).sendKeys(Keys.SPACE);
			}else{
				IEDriver.findElement(By.name(id)).click();
			}	
						
			
		
			return 1;
		
			
		case "xpath":
		
				IEDriver.findElement(By.xpath(id)).sendKeys("");
				if(buttonloc.contains("checkbox")){
					IEDriver.findElement(By.xpath(id)).sendKeys(Keys.SPACE);
				}else{
				IEDriver.findElement(By.xpath(id)).click();
				}
			
			
			return 1;
			
		case "cssSelector":

				IEDriver.findElement(By.cssSelector(id)).sendKeys("");
				if(buttonloc.contains("checkbox")){
					IEDriver.findElement(By.cssSelector(id)).sendKeys(Keys.SPACE);
				}else{
				IEDriver.findElement(By.cssSelector(id)).click();
				}
		
			return 1;
				
		default:
				System.out.println("Element not found");
				return 0;
		
		}
		
		
			         
		}
	
	public int SwitchToNewWindow() throws InterruptedException{
		
		  Thread.sleep(4500);
		   winHandleBefore  = IEDriver.getWindowHandle();
		   String newwinhandle = null;
	         for(String winHandle : IEDriver.getWindowHandles()){
	        	 
	           IEDriver.switchTo().window(winHandle);
	           newwinhandle  = winHandle;
	          
	          
	         }
	         IEDriver.manage().window().maximize();
	         winHandle=newwinhandle;
	         return 1;
		
	}
	
	public int SwitchToOldWindow() throws InterruptedException{
		
		  Thread.sleep(4500);
			        	 
	           IEDriver.switchTo().window(winHandleBefore);
	         return 1;
		
	}
	
	public int CloseWindow() throws InterruptedException{
		
		  Thread.sleep(4500);
			        	 
	           IEDriver.close();
	         return 1;
		
	}
	
	public int dropdownbyval(String droploc, String val)
	{
		
				
		String locatorProperty = pro.getProperty(droploc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		IEDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		switch(idtype){
		
		case "id":
			Select dropdown = new Select(IEDriver.findElement(By.id(id)));
			dropdown.selectByVisibleText(val);
			return 1;
	
		
		case "name":
			Select dropdown1 = new Select(IEDriver.findElement(By.name(id)));
			dropdown1.selectByVisibleText(val);
			return 1;
		
		
			
		case "xpath":
			Select dropdown2 = new Select(IEDriver.findElement(By.xpath(id)));
			dropdown2.selectByVisibleText(val);
			return 1;
			
		case "cssSelector":
			Select dropdown3 = new Select(IEDriver.findElement(By.cssSelector(id)));
			dropdown3.selectByVisibleText(val);
			return 1;
				
		default:
				System.out.println("Element not found");
				return 0;
		
		}
		
		}
			         
		
	
	public int dropdownbyindex(String droploc, int index)
	{
		String locatorProperty = pro.getProperty(droploc);
		String idtype = locatorProperty.split(":")[0];
		String id = locatorProperty.split(":")[1];
		IEDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		switch(idtype){
		
		case "id":
			Select dropdown = new Select(IEDriver.findElement(By.id(id)));
			dropdown.selectByIndex(index);
			return 1;
	
		
		case "name":
			Select dropdown1 = new Select(IEDriver.findElement(By.name(id)));
			dropdown1.selectByIndex(index);
			
			return 1;
		
		
			
		case "xpath":
			Select dropdown2 = new Select(IEDriver.findElement(By.xpath(id)));
			dropdown2.selectByIndex(index);
			return 1;
			
		case "cssSelector":
			Select dropdown3 = new Select(IEDriver.findElement(By.cssSelector(id)));
			dropdown3.selectByIndex(index);
			return 1;
				
		default:
				System.out.println("Element not found");
				return 0;
		
		}
		
		
			         
		}
	public void WaitForJS() throws InterruptedException
    {

        while (true)
        {

         //   String JSIsComplete = (String) ((JavascriptExecutor)IEDriver).executeScript("return document.readyState");
            if (((JavascriptExecutor)IEDriver).executeScript("return document.readyState").equals("complete")){
                break;
            }
            Thread.sleep(100);
        }
    }
	
	

	
	
}


