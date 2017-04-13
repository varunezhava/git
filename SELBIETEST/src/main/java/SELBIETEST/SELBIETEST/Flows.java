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
		pro=((Flows)accesor).loadrepository();
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
			// ((Flows)accesor).WaitForJS();
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
	 
	 public String businessinfo(XSSFRow activerow) throws InterruptedException{
		 Operations accesor = new Flows();
		 int maxpara = activerow.getLastCellNum() - 3;
			// Iterator<Cell> datarow = activerow.cellIterator();
			 ArrayList<String> data = new ArrayList<String>();
			// ((Flows)accesor).WaitForJS();
			 for( int j = 2; j<= maxpara+1; j++){
				 
				  data.add(activerow.getCell(j).toString());
									 
			 }
			 int chk;
			 chk=((Flows)accesor).waitcomplete("bie.businessentitydropdown");
			 if(chk == 1) {
		           	System.out.println("Business Info loaded");
		          }      
		         else{
		       	System.out.println("Business Info not loaded");
		         }	
			 
			 chk=((Flows)accesor).dropdownbyval("bie.businessentitydropdown", data.get(0));
			 if(chk == 1) {
		           	System.out.println("Entity type selected");
		          }      
		         else{
		       	System.out.println("Entity type not selected");
		         }	
			 
			 Thread.sleep(2000);
			 chk=0;
			 if(data.get(1).length() != 0){
				 chk=((Flows)accesor).waitcomplete("bie.describeother");
				 chk=((Flows)accesor).autopopulator("bie.describeother", data.get(1));
				
			 }
			 if(chk == 1) {
		           	System.out.println("Other type entered");
		          }      
		         else{
		       	System.out.println("Other type not entered");
		         }	
			 
			 chk=0;
			 chk=((Flows)accesor).waitcomplete("bie.businessname");
			 chk=((Flows)accesor).autopopulator("bie.businessname", data.get(2));
			 if(chk == 1) {
		           	System.out.println("Business name entered");
		          }      
		         else{
		       	System.out.println("Business name not entered");
		         }	
			 chk=0;
			 if(data.get(3).length() != 0){
				 chk=((Flows)accesor).waitcomplete("bie.dba");
				 chk=((Flows)accesor).autopopulator("bie.dba", data.get(3));
				
			 }
			 if(chk == 1) {
		           	System.out.println("DBA entered");
		          }      
		         else{
		       	System.out.println("DBA not entered");
		         }	
			 chk=0;
			 if(data.get(4).length() != 0){
				 chk=((Flows)accesor).waitcomplete("bie.firstinsuredlastname");
				 chk=((Flows)accesor).autopopulator("bie.firstinsuredlastname", data.get(4));
				
			 }
			 if(chk == 1) {
		           	System.out.println("First Insured Last name entered");
		          }      
		         else{
		       	System.out.println("First Insured Last name not entered");
		         }	
			 chk=0;
			 if(data.get(5).length() != 0){
				 chk=((Flows)accesor).waitcomplete("bie.firstinsuredfirstname");
				 chk=((Flows)accesor).autopopulator("bie.firstinsuredfirstname", data.get(5));
				 	
			 }
			 if(chk == 1) {
		           	System.out.println("First Insured First name entered");
		          }      
		         else{
		       	System.out.println("First Insured First name not entered");
		         }
			 chk=0;
			 if(data.get(6).length() != 0){
				 chk=((Flows)accesor).waitcomplete("bie.seconinsuredlastname");
				 chk=((Flows)accesor).autopopulator("bie.seconinsuredlastname", data.get(6));
				 
			 }
			 if(chk == 1) {
		           	System.out.println("Second Insured Last name entered");
		          }      
		         else{
		       	System.out.println("Second Insured Last name not entered");
		         }	
			 
			chk=0;
			 if(data.get(7).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.seconinsuredfirstname", data.get(7));
				 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Second Insured First name entered");
		          }      
		         else{
		       	System.out.println("Second Insured First name not entered");
		         }	
			 chk=0;
			 if(data.get(8).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.businessinfoaddress", data.get(8));
				
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Address re-entered");
		          }      
		         else{
		       	System.out.println("Address not entered");
		         }	
			 
			 chk=0;
			 if(data.get(9).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.businessinfoaddress2", data.get(9));
				 
			 }
			 if(chk == 1) {
		           	System.out.println("Additonal Address re-entered");
		          }      
		         else{
		       	System.out.println("Additonal Address not entered");
		         }	
			 chk=0;
			 if(data.get(10).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.businessinfocity", data.get(10));
				 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("City re-entered");
		          }      
		         else{
		       	System.out.println("City not entered");
		         }
			 
			 chk=0;
			 if(data.get(11).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.businessinfozip", data.get(11));
				 
			 }
			 if(chk == 1) {
		           	System.out.println("Zip re-entered");
		          }      
		         else{
		       	System.out.println("Zip not entered");
		         }
			 		 
			 chk=0;
			 if(data.get(12).length() != 0){
			 String ph = data.get(12);
			 String[] phn = ph.split("-");
			 
			 chk=((Flows)accesor).autopopulator("bie.businessphone1", phn[0]);
			 chk=((Flows)accesor).autopopulator("bie.businessphone2", phn[1]);
			 chk=((Flows)accesor).autopopulator("bie.businessphone3", phn[2]);
			 }
			 if(chk == 1) {
		           	System.out.println("Phone entered");
		          }      
		         else{
		       	System.out.println("Phone not entered");
		         }
			 
			 chk=0;
			 if(data.get(13).length() != 0){
			 chk=((Flows)accesor).autopopulator("bie.businessemail", data.get(13));
			 }
			 if(chk == 1) {
		           	System.out.println("email entered");
		          }      
		         else{
		       	System.out.println("email not entered");
		         }
			 
			 
			 chk=0;
			 
			 chk=((Flows)accesor).dropdownbyval("bie.anypersonalpolicyfarmersdropdown",data.get(14));
			 
			 if(chk == 1) {
		           	System.out.println("Any personal policy farmers dropdown entered");
		          }      
		         else{
		       	System.out.println("Any personal policy farmers dropdown not entered");
		         }
			 
			 
		
			 chk=0;
			 if(data.get(15).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.householdnumber", data.get(15));
				 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Household number entered");
		          }      
		         else{
		       	System.out.println("Household number not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 if(data.get(16).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.fein", data.get(16));
			 }
			 if(chk == 1) {
		           	System.out.println("FEIN entered");
		          }      
		         else{
		       	System.out.println("FEIN not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 if(data.get(17).length() != 0){
				 chk=((Flows)accesor).autopopulator("bie.websiteaddress", data.get(17));
			 }
			 if(chk == 1) {
		           	System.out.println("Website entered");
		          }      
		         else{
		       	System.out.println("Website not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 
			 chk=((Flows)accesor).dropdownbyval("bie.typeofquotedropdown", data.get(18));
			 if(chk == 1) {
		           	System.out.println("Quote type entered");
		          }      
		         else{
		       	System.out.println("Quote type not entered");
		         }
			 chk=0;
			 chk=((Flows)accesor).dropdownbyval("bie.agencymetapplicantdropdown", data.get(19));
			 if(chk == 1) {
		           	System.out.println("Applicant met or not entered");
		          }      
		         else{
		       	System.out.println("Applicant met or not is not entered");
		         }
			 chk=0;
			 chk=((Flows)accesor).autopopulator("bie.establishedyear", data.get(20));
			 if(chk == 1) {
		           	System.out.println("Established year entered");
		          }      
		         else{
		       	System.out.println("Established year not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 if(data.get(21).length() != 0){
				 chk=((Flows)accesor).dropdownbyval("bie.maintaincontinsurance", data.get(21));
			 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Maintain insurance entered");
		          }      
		         else{
		       	System.out.println("Maintain insurance  not entered");
		         }
			 
			 
			 chk=((Flows)accesor).waitcomplete("bie.yearsofmanagementexp");
			 
			 chk=((Flows)accesor).autopopulator("bie.yearsofmanagementexp", new BigDecimal (data.get(22)).stripTrailingZeros().toPlainString());
			 if(chk == 1) {
		           	System.out.println("Experience entered");
		          }      
		         else{
		       	System.out.println("Experience not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 chk=((Flows)accesor).dropdownbyval("bie.anypoliciesinsuredwithfarmersdropdown", data.get(23));
			 
			 if(chk == 1) {
		           	System.out.println("insurance with farmers entered");
		          }      
		         else{
		       	System.out.println("insurance with farmers  not entered");
		         }
			 ((Flows)accesor).WaitForJS();
			 chk=0;
			 if(data.get(24).length() != 0){
				 chk=((Flows)accesor).clickbutton("bie.commercialcheckbox"); 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Commercial checkbox selected");
		          }      
		         else{
		       	System.out.println("Commercial checkbox  not selected");
		         }
			 chk=0;
			 if(data.get(25).length() != 0){
				 chk=((Flows)accesor).clickbutton("bie.wccheckbox"); 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("WC checkbox selected");
		          }      
		         else{
		       	System.out.println("WC checkbox  not selected");
		         }
			 
			 
			// chk=0;
			// chk=((Flows)accesor).dropdownbyval("bie.anypoliciesinsuredwithfarmersdropdown", data.get(26));
			 
		//	 if(chk == 1) {
		  //         	System.out.println("Any policies with farmers entered");
		 //         }      
		//         else{
		//       	System.out.println("Any policies with farmers not entered");
		//         }
			 
			 chk=0;
			 chk=((Flows)accesor).dropdownbyval("bie.anyotherbusinessnotinsureddropdown", data.get(26));
			 
			 if(chk == 1) {
		           	System.out.println("Any policies not with farmers entered");
		          }      
		         else{
		       	System.out.println("Any policies not with farmers not entered");
		         }
			 
			 chk=0;
			
			 chk=((Flows)accesor).autopopulator("bie.additionalinterests", new BigDecimal (data.get(27)).stripTrailingZeros().toPlainString());
			 
			 if(chk == 1) {
		           	System.out.println("Additional interest entered");
		          }      
		         else{
		       	System.out.println("Additional interest not entered");
		         }
			 
			 chk=0;
			 if(data.get(28).length() != 0 && data.get(28).equals("Yes")){
				 chk=((Flows)accesor).clickbutton("bie.includeautocheckbox"); 
			 }
			 
			 if(chk == 1) {
		           	System.out.println("Auto checkbox selected");
		          }      
		         else{
		       	System.out.println("Auto checkbox  not selected");
		         }
			 
			 
			 chk=0;
			 chk=((Flows)accesor).dropdownbyval("bie.applicantownsbusinessautodropdown", data.get(29)); 
			 if(chk == 1) {
		           	System.out.println("Applicant own business drop down selected");
		          }      
		         else{
		       	System.out.println("Applicant own business drop down not selected");
		         }
			 
			 chk=0;
			 chk=((Flows)accesor).dropdownbyval("bie.blanketcoveragedropdown", data.get(30)); 
			 if(chk == 1) {
		           	System.out.println("Blanket coverage drop down selected");
		          }      
		         else{
		       	System.out.println("Blanket coverage drop down not selected");
		         }
			 
			 
			 
			 
			 
			 String nextfun = activerow.getCell(activerow.getLastCellNum()-1).toString();
	         return nextfun; 
			 
	 }
	 
	 
	 
	 
	 
	
}




	
