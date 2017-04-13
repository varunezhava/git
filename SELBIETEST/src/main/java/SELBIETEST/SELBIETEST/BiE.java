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
			 sheet=workbook.getSheetAt(i+2);
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
		 
		 if((funname).equals(sheet.getSheetName().toString()) || funname.equals("exit")){
		 Method method = flowclass.getDeclaredMethod(funname, XSSFRow.class);
		 funname = (String) method.invoke(obj,activedatarow);    
		 
		 if(funname.equals("exit")){
			 
			 if(j==totalrun){
				 workbook.close();
				 workbookinput.close();
				 System.exit(0);
			 }
			 
			 
		 }
		 
		 if(funname.equals("transcontrolnew")){
			 continue;
			
			 
		 }
		 
		 
		 
		 }
		 
		 }
		 }
	

	

}
}
