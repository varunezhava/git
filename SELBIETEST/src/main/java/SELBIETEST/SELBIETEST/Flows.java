package SELBIETEST.SELBIETEST;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Properties;

//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Flows extends Operations{
	
	
	
	
	 public Properties pro =new Properties();

	public Flows(){
	 
	}
	
	 public String initialize(XSSFRow activerow) throws IOException{
		 Operations accesor = new Flows();
		pro=((Flows)accesor).loadrepository("C:\\Users\\varun.ezhava\\git\\git\\SELBIETEST\\Obj_repo.properties");
		System.out.println("Repositories loaded");
		return activerow.getCell(activerow.getLastCellNum()-1).toString();
	 }
	 
	 
	 public String login(XSSFRow activerow){
		 
		 int maxpara = activerow.getLastCellNum() - 3;
		// Iterator<Cell> datarow = activerow.cellIterator();
		 ArrayList<String> data = new ArrayList<String>();
					 
			 for( int j = 2; j<= maxpara+1; j++){
			 
				
				 
				  data.add(activerow.getCell(j).toString());
				 	
				
				 
				 
			 }
		 
		 Operations accesor = new Flows();
		 int  chk;
         chk=0;
         chk =((Flows)accesor).Login(pro.getProperty("bie.url.link"),"bie.uid", data.get(0), "bie.passwd",data.get(1));
		 
         if(chk == 1) {
          	System.out.println("Login Successfull");
          }      
          else{
          	System.out.println("Login Unsuccessfull");
          }	
         String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
         return nextfun;
	 }
	 
	 public String transcontrol(XSSFRow activerow) throws InterruptedException{
		 Operations accesor = new Flows();
		 int maxpara = activerow.getLastCellNum() - 3;
			// Iterator<Cell> datarow = activerow.cellIterator();
			 ArrayList<String> data = new ArrayList<String>();
						 
				 for( int j = 2; j<= maxpara+1; j++){
				 
					
					 
					  data.add(activerow.getCell(j).toString());
					 	
					
					 
					 
				 }
				 int chk =0;
				 chk=((Flows)accesor).waitcomplete("bie.menu");
			     if(chk == 1) {
			     System.out.println("Menu Opened");
			      }      
			      else{
			     System.out.println("Menu not available");
			      }	
			 
						
	         chk=0;
	         chk=((Flows)accesor).MainRadio(data.get(0), "bie.menu"); 
	          if(chk == 1) {
	        	 System.out.println("Quote Creation Inprogress");
			      }      
			      else{
			    	  System.out.println("Quote Creation not Inprogress");
			      }	
			 
	          chk=0;
		         chk=((Flows)accesor).clickbutton("bie.quotesubmit");
		          if(chk == 1) {
		        	 System.out.println("Quote Create Window Opened");
				      }      
				      else{
				    	  System.out.println("Quote Create Window not Opened");
				      }	
	          
		          chk=0;
		         
		          chk=((Flows)accesor).SwitchToNewWindow();
		        	  
		           	        	          
	         String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
	         return nextfun;
	 }
	 
	 public String lobmenu(XSSFRow activerow) throws InterruptedException{
		 
		 Operations accesor = new Flows();
		 int maxpara = activerow.getLastCellNum() - 3;
			// Iterator<Cell> datarow = activerow.cellIterator();
			 ArrayList<String> data = new ArrayList<String>();
			 ((Flows)accesor).WaitForJS();
			 	int chk=0;
			 	chk=((Flows)accesor).waitcomplete("bie.lobmenu");
			 	if(chk == 1) {
			 		System.out.println("Lob Menu Opened");
			 		}      
		         else{
		         System.out.println("Lob Menu not available");
		         }	
			 	
			 	for( int j = 2; j<= maxpara+1; j++){
														 
					  data.add(activerow.getCell(j).toString());
										 
				 }
			 	
			 	chk=0;
			    chk=((Flows)accesor).MainRadio(data.get(0), "bie.lobmenu" );     
			    if(chk == 1) {
			 		System.out.println("Lob Selected");
			 		}      
		         else{
		         System.out.println("Lob not Selected");
		         }	
			    
			    chk=0;
			    chk=((Flows)accesor).autopopulator("bie.effdate", data.get(1));
			     if(chk == 1) {
			      	System.out.println("Date entered");
			      }      
			       else{
			      	System.out.println("Date not entered");
			       }
			     chk=0;
			     chk=((Flows)accesor).autopopulator("bie.prodcode", data.get(2));
			        
			       if(chk == 1) {
			       	System.out.println("Prod code entered");
			      }      
			       else{
			       	System.out.println("Prod code  not entered");
			      }	
			       
			       
			       chk=0;
			       chk=((Flows)accesor).clickbutton("bie.continue");
			          
			         if(chk == 1) {
			           	System.out.println("Policy Data input started");
			          }      
			         else{
			       	System.out.println("Policy Data input not started");
			         }	
			         
			         String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
			         return nextfun;
	 }
	 
	 
	 public String insuredsearch(XSSFRow activerow) throws InterruptedException{
		 
		 Operations accesor = new Flows();
		 int maxpara = activerow.getLastCellNum() - 3;
			// Iterator<Cell> datarow = activerow.cellIterator();
			 ArrayList<String> data = new ArrayList<String>();
			 ((Flows)accesor).WaitForJS();
		 int chk =0;
			 chk=((Flows)accesor).waitcomplete("bie.businessname");
			 
			 if(chk == 1) {
		           	System.out.println("Insured Search Criteria screen is displayed");
		          }      
		         else{
		       	System.out.println("Insured Search Criteria screen is displayed");
		         }	
			 
			 for( int j = 2; j<= maxpara+1; j++){
				 
				  data.add(activerow.getCell(j).toString());
									 
			 }
			 
		 chk=0;
		 chk=((Flows)accesor).autopopulator("bie.businessname", data.get(0));
		 
		 if(chk == 1) {
	           	System.out.println("Businessname Entered");
	          }      
	         else{
	       	System.out.println("Businessname Not Entered");
	         }	
			 
		 chk=0;
		 chk=((Flows)accesor).autopopulator("bie.address", data.get(1));
		 
		 if(chk == 1) {
	           	System.out.println("Address Entered");
	          }      
	         else{
	       	System.out.println("Address Not Entered");
	         }	
		 
		 chk=0;
		 chk=((Flows)accesor).autopopulator("bie.city", data.get(2));
		 
		 if(chk == 1) {
	           	System.out.println("City Entered");
	          }      
	         else{
	       	System.out.println("City Not Entered");
	         }	 
		 
		 chk=0;
		 chk=((Flows)accesor).autopopulator("bie.zip", data.get(3));
		 
		 if(chk == 1) {
	           	System.out.println("Zip Entered");
	          }      
	         else{
	       	System.out.println("Zip Not Entered");
	         }	 
			 
		 chk=((Flows)accesor).clickbutton("bie.lookupcompany");
		 
		 chk=((Flows)accesor).waitcomplete("bie.useinfoabove");
		 ((Flows)accesor).WaitForJS();
		 
		 chk=((Flows)accesor).clickbutton("bie.useinfoabove");
		 
		 if(chk == 1) {
	           	System.out.println("Insured search screen is populated");
	          }      
	         else{
	       	System.out.println("Insured search screen is not populated");
	         }	
		 
		 
		 String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
         return nextfun;
			 
			 
	 }
	 
	 
	 public String sicsearch(XSSFRow activerow) throws InterruptedException{
		 Operations accesor = new Flows();
		 int maxpara = activerow.getLastCellNum() - 3;
			// Iterator<Cell> datarow = activerow.cellIterator();
			 ArrayList<String> data = new ArrayList<String>();
			 ((Flows)accesor).WaitForJS();
			 for( int j = 2; j<= maxpara+1; j++){
				 
				  data.add(new BigDecimal(activerow.getCell(j).toString()).stripTrailingZeros().toPlainString());
									 
			 }
			 
			 int chk=0;
			 
			 chk=((Flows)accesor).waitcomplete("bie.sictypesearch");
			 
			 if(chk == 1) {
		           	System.out.println("SIC screen is loaded");
		          }      
		         else{
		       	System.out.println("SIC screen is not loaded");
		         }	
			 
			 chk=0;
			 chk=((Flows)accesor).autopopulator("bie.sictypesearch", data.get(0));
			 
			 if(chk == 1) {
		           	System.out.println("Sic code Entered");
		          }      
		         else{
		       	System.out.println("Sic code not Entered");
		         }
			 
			 chk=((Flows)accesor).clickbutton("bie.sictypesearchbutton");
			 chk=0;
			 ((Flows)accesor).WaitForJS();
			 Thread.sleep(4500);
			 //chk=((Flows)accesor).waitcomplete("bie.sicselectbutton");
			 //if(chk == 1) {
		      //     	System.out.println("SIC found");
		       //   }      
		        // else{
		       	//System.out.println("SIC not found");
		//         }	
			// chk=0;
			
			 chk=((Flows)accesor).clickbutton("bie.sicselectbutton");
			 if(chk == 1) {
		           	System.out.println("SIC selected");
		          }      
		         else{
		       	System.out.println("SIC not selected");
		         }	
			 
			 chk=0;
			 
			 chk=((Flows)accesor).waitcomplete("bie.sicclassificationdropdown");
			 if(chk == 1) {
		           	System.out.println("SIC discription page loaded");
		          }      
		         else{
		       	System.out.println("SIC discription page not loaded");
		         }	 
			 chk=0;
			 
			 chk=((Flows)accesor).dropdownbyval("bie.sicclassificationdropdown", "Yes");
			
			 chk=((Flows)accesor).waitcomplete("bie.sicgoverningdropdown");
			 
			 chk=((Flows)accesor).dropdownbyindex("bie.sicgoverningdropdown", 1);
			 ((Flows)accesor).WaitForJS();
			 Thread.sleep(4500);
			 Actions action = new Actions(IEDriver); 
			 action.sendKeys(Keys.TAB).build().perform();
			 action.sendKeys(Keys.TAB).build().perform();
			 action.sendKeys(Keys.ARROW_DOWN).build().perform();
			// chk=((Flows)accesor).dropdownbyval("bie.sicelegibledropdown", "Yes");
			 chk=0;
			 chk=((Flows)accesor).clickbutton("bie.footernextbutton");
			 if(chk == 1) {
		           	System.out.println("SIC section completed");
		          }      
		         else{
		       	System.out.println("SIC section not completed");
		         }	
			 
			 String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
	         return nextfun; 
	 }
	
}




	
