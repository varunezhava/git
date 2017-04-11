package SELBIETEST.SELBIETEST;





import java.io.File;

//import java.util.concurrent.TimeUnit;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Properties;

import javax.swing.JFileChooser;


//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.w3c.dom.xpath.XPathExpression;

//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.ie.InternetExplorerDriver;


public class BiE extends Flows{
	
		
	public static void main(String[] args) throws InterruptedException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, ClassNotFoundException, InstantiationException, ReflectiveOperationException
	{
		Class<?> flowclass = Class.forName("SELBIETEST.SELBIETEST.Flows");
		 Object obj = flowclass.newInstance();
		 String funname = null;
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Select the Master Data Input Sheet");
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		 File selectedFilemaster = null;
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
		     selectedFilemaster = fileChooser.getSelectedFile();
		   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		
		JFileChooser fileChooser1 = new JFileChooser();
		fileChooser1.setDialogTitle("Select the Input Sheet");
		fileChooser1.setCurrentDirectory(new File(System.getProperty("user.dir")));
		File selectedFileinout = null;
		int result1 = fileChooser1.showOpenDialog(fileChooser1);
		if (result1 == JFileChooser.APPROVE_OPTION) {
		     selectedFileinout = fileChooser1.getSelectedFile();
		   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		 
		
		
		
		
		//Flows accesor = new BiE();
		
		 XSSFWorkbook workbook = new XSSFWorkbook(selectedFilemaster.getAbsolutePath());
		 XSSFWorkbook workbookinput = new XSSFWorkbook(selectedFileinout.getAbsolutePath());
		 XSSFSheet inputsheet = workbookinput.getSheetAt(0);
		 XSSFSheet sheet;
		 int totalrun = inputsheet.getLastRowNum();
		
		 for (int j=1;j<=totalrun;j++){
			 
			 XSSFRow inputrow = inputsheet.getRow(j);
			 int inputlen;
			 inputlen = inputrow.getLastCellNum();
			 String datarow = inputrow.getCell(inputlen-1).toString();
					 
		 int totalsheets = workbook.getNumberOfSheets();
		 for(int i=0;i<totalsheets;i++){
			 
		if(j==1){ 
		 sheet=workbook.getSheetAt(i);
		}else{
			 sheet=workbook.getSheetAt(i+1);
		}
		 int totalrow = sheet.getLastRowNum();
		 XSSFRow activedatarow = null;
		 
		 for(int k = 0; k<= totalrow; k++){
			 
			 XSSFRow currow = sheet.getRow(k+1);
			 if((currow.getCell(0).toString()).equals(datarow)){
				 
				 int actdatarow = currow.getRowNum();
				activedatarow = sheet.getRow(actdatarow);
				 break;
				 
			 }
			 
		 }
		 
		 	 		 
		 if(i==0){
			  funname =  activedatarow.getCell(1).toString();	
		 }
		 
		 if((funname).equals(sheet.getSheetName().toString())){
		 Method method = flowclass.getDeclaredMethod(funname, XSSFRow.class);
		 funname = (String) method.invoke(obj,activedatarow);    
		 
		 if(funname.equals("exit")){
			 
			 if(j==totalrun){
				 workbook.close();
				 workbookinput.close();
				 System.exit(0);
			 }else{
				 break;
			 }
			 
			 
		 }
		 
		 
		 
		 }
		 
		 }
		 }
	
		// for(int i=1;i<=len;i++){
			
			 
			 
			 
		// }
		 
		 
		 
		 
       
		  
       // chk=0;
       
        
         
        
		
			
      //  chk=((BiE)accesor).login(IEDriver);
        // if(chk == 1) {
         //	System.out.println("Login Successfull");
         //}      
         //else{
         	//System.out.println("Login Unsuccessfull");
         //}	
            
      //   chk=0;
       		
       // chk=((BiE)accesor).waitcomplete(IEDriver, "bie.menu");
       // if(chk == 1) {
       //	System.out.println("Menu Opened");
       // }      
       // else{
       // System.out.println("Menu not available");
       // }	
        // chk=0;
        //     chk=((BiE)accesor).MainRadio(IEDriver, "Create Quote", "bie.menu");      
       
        // if(chk == 1) {
       // 	System.out.println("Quote Creation Inprogress");
        	//IEDriver.findElement(By.id("quotesubmit")).click();
        //}      
       // else{
       // 	System.out.println("Quote Creation not inprogress");
      //  }	
        
       //  Thread.sleep(3500);
       //  String winHandleBefore = IEDriver.getWindowHandle();
        // for(String winHandle : IEDriver.getWindowHandles()){
        	//    IEDriver.switchTo().window(winHandle);
       // 	}
       
         
       //  chk=0;
       //  chk=((BiE)accesor).waitcomplete(IEDriver, "bie.lobmenu");
       //  if(chk == 1) {
       // 	System.out.println("Lob Menu Opened");
       //  }      
       //  else{
       //  System.out.println("Lob Menu not available");
       //  }	
         
       //  chk=0;
       //  chk=((BiE)accesor).MainRadio(IEDriver, "Manufacturing", "bie.lobmenu");      
   
  //   if(chk == 1) {
   // 	System.out.println("Quote Creation Started");
    //}      
  //  else{
    //	System.out.println("Quote Creation Not Started");
  //  }	
         
  //   chk=0;
  //  chk=((BiE)accesor).autopopulator(IEDriver, "bie.effdate", "04-04-2017");
  //  if(chk == 1) {
   //  	System.out.println("Date entered");
   //  }      
  //   else{
   //  	System.out.println("Date not entered");
  //   }	
//     JavascriptExecutor js = (JavascriptExecutor) IEDriver;  
  //   js.executeScript("checkdate(effDate,'Effective Date','quoteind');");
         
  //   chk=0;
  //   chk=((BiE)accesor).autopopulator(IEDriver, "bie.prodcode", "080403");
     
  //   if(chk == 1) {
   //   	System.out.println("Prod code entered");
   //   }      
   //   else{
   //   	System.out.println("Prod code  not entered");
    //  }	
     
  //   chk=0;
  //   chk=((BiE)accesor).clickbutton(IEDriver, "bie.continue");
     
  //   if(chk == 1) {
   //    	System.out.println("Policy Data input started");
    //   }      
     //  else{
      // 	System.out.println("Policy Data input not started");
     //  }	
     
    
	
//	}
	
	

}
}
