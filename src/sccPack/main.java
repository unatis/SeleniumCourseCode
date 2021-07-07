package sccPack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main {

    public enum Browser{
        CHROME,
        FIREFOX
    }
	
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	public static void main(String[] args) throws Exception {
		
		InitEnvironment(Browser.CHROME);
		
		NavigateTo("http://qadocs.com/selenium.html");
		
		//Verify_Title_Text("Test page");
		
	        //Verify_Label_Text("Selenium automation");
		
		//Click_ThisIsALink_Link();
		
		//Verify_Logo_Image("http://www.seleniumhq.org/images/big-logo.png", true);
		
		//Verify_ColoredText_Color("241, 50, 9");
		
		//Verify_BackgroundedText_Text("176, 187, 7");
		
		//Click_Submit_Button();
		
		//Click_ArrowImage_Button();
		
		//Verify_HiddenElement_Text("Display none");
		
		//Verify_VisibilityHiddenElement_Text("Visibility hidden");
		
		//Select_ComplexDropdown_Combo("youtube");
		
		//Click_Female_RadioButton();
		
		//Verify_Female_RadioButton();
		
		//Set_FirstName_Text("Albert");
		
		//Set_LastName_Text("Einstein");
		
		//Set_ReadOnly_Text("New Text");
		
		//Verify_ReadOnly_Text("readonly");
		
		//Set_TextArea_Text("Hello");
		
		//Set_CarType_Select("Mercedes");
		
		//Click_HaveBike_Checkbox("check");
		
		//Click_HaveCar_Checkbox("uncheck");
		
		//Click_Tab_Link("Seller");
		
		//Verify_TabText_Text("second tab");
		
		//Verify_UserClientIP_Text("Ana Trujillo", "192.168.1.203");
		
		//Verify_UserClientIP_Text("Michael Hardy", "192.168.1.220");
		
		//Set_Password_Text("12345");
		
		//UploadFile("C:\\Users\\ygpan\\Desktop\\search2.png");
		
		//DownloadFile("c:\\search2.png");
				
		//NewTabWorkAround();
				
		//Click_TryIt_Button();
		
		//Click_IFrame_Link();
		
		//MouseMove();
				
		//Verify_AjaxDynamicElementUpdate();

		Thread.sleep(5000);
		
		ExitEnvironment();
	}
	
	public static void Verify_Title_Text(String ExpectedText){

        try{

            WebElement element = driver.findElement(By.id("page_title_id"));

            String PageTitle = element.getText();

            if(PageTitle.trim().equalsIgnoreCase(ExpectedText)){
                System.out.println("Found page title: \"" + PageTitle + "\" equals to expected \"" + ExpectedText + "\"");
            }else{
                System.out.println("ERROR - Found page title: \"" + PageTitle + "\" Not equals to expected \"" + ExpectedText + "\"");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
	
	public static void Verify_Label_Text(String ExpectedText) throws Exception {
        
		try{

		    WebElement element = driver.findElement(By.name("free_text_name"));

		    String PageLabel = element.getText();

		    if(PageLabel.trim().equalsIgnoreCase(ExpectedText)){
			System.out.println("Found page label: \"" + PageLabel + "\" equals to expected \"" + ExpectedText + "\"");
		    }else{
			System.out.println("ERROR - Found page label: \"" + PageLabel + "\" Not equals to expected \"" + ExpectedText + "\"");
		    }

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
        
    }
	
	public static void Click_ThisIsALink_Link() throws Exception {
		
		 try{

		    //WebElement element = driver.findElement(By.className("a_class"));
		    //WebElement element = driver.findElement(By.linkText("This is a link"));
		    WebElement element = driver.findElement(By.partialLinkText("This is"));

		    element.click();

		    System.out.println("Link \"This Is A Link\" was clicked successfully");

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}		
                
	}
	
	public static void Verify_Logo_Image(String ImageName, Boolean Expected) throws Exception {
		
		try{

		    WebElement element = driver.findElement(By.id("someimage_id"));
		    String foundAttr = element.getAttribute("src").trim().toLowerCase();

		    if(Expected){

			if(foundAttr.contains(ImageName.toLowerCase())){
			    System.out.println("Image found successfully");
			}else{
			    System.out.println("ERROR : Image not found");
			}

		    }else{

			if(foundAttr.contains(ImageName.toLowerCase())){
			    System.out.println("ERROR: Image found");
			}else{
			    System.out.println("Image not found");
			}

		    }

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
                        
	}
		
	public static void Verify_ColoredText_Color(String ExpectedColor) throws Exception {
		
		try{
		    //Explicit
		    WebDriverWait wait = new WebDriverWait(driver, 5);
		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("colored_text_id")));

		    //String Color = element.getAttribute("style");
		    String Color = element.getCssValue("color");

		    if(Color.trim().contains(ExpectedColor.trim())){
			System.out.println("Expected color " + ExpectedColor + " equals to found " + Color);
		    }else{
			System.out.println("ERROR: Expected color " + ExpectedColor + " not equals to found " + Color);
		    }

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}       
                
	}
		
	public static void Verify_BackgroundedText_Color(String ExpectedColor){

		try{

		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("background_colored_text_id")));

		    //String Color = element.getAttribute("style");
		    String Color = element.getCssValue("background-color");

		    if(Color.trim().contains(ExpectedColor.trim())){
			System.out.println("Expected color " + ExpectedColor + " equals to found " + Color);
		    }else{
			System.out.println("ERROR: Expected color " + ExpectedColor + " not equals to found " + Color);
		    }

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
    }
		
	public static void Click_Submit_Button(){

        try{

            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_id"))).click();
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_id"))).submit();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content_id']/form[1]"))).submit();

            System.out.println("Submit button clicked successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
		
	public static void Click_Arrow_Button(){

		try{
		    //Implicit
		    driver.findElement(By.id("imagebutton_id")).click();

		    System.out.println("Arrow button clicked successfully");

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
	    }
		
	public static void Verify_HiddenElement_Text(String ExpectedText) throws Exception {
		
		try{				
			
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("display_none_id")));
	        	        
	        setAttributeValue(element, "display", "");
			    
	        String elementText = element.getText();
	        	        	        	        
			if(elementText.toLowerCase().trim().equals(ExpectedText.toLowerCase().trim()))
	        {
				System.out.println("Found text is " + elementText + " as expected");
	        }
	        else
	        {
	        	System.out.println("ERROR: Found text is " + elementText + " Not as expected " + ExpectedText);
	        }	        
			 
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Verify_VisibilityHiddenElement_Text(String ExpectedText) throws Exception {
		
		try{			
			
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibility_text_id")));
	        	        
	        setAttributeValue(element, "visibility", "");
			    
	        String elementText = element.getText();
	        	        	        	        
			if(elementText.toLowerCase().trim().equals(ExpectedText.toLowerCase().trim()))
	        {
				System.out.println("Found text is " + elementText + " as expected");
	        }
	        else
	        {
	        	System.out.println("ERROR: Found text is " + elementText + " Not as expected " + ExpectedText);
	        }	        
			 
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Select_ComplexDropdown_Combo(String DDElement) throws Exception {
		
		try{			
			
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content_id']//button[contains(@class,'dropdown-toggle')]"))).click();
	        	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-menu")));
	        	
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content_id']//ul[@class='dropdown-menu']//li/a[contains(text(),'"+DDElement+"')]"))).click();
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Click_Female_RadioButton() throws Exception {
		
		try{			
			
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("female_id"))).click();
			 
	        System.out.println("Female radiobutton was clicked");
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Verify_Female_RadioButton(String ExpectedState) throws Exception {
		
		try{				
			
	        WebElement FemaleRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("female_id")));
			 
			 if(ExpectedState.equals("checked"))
			 {
				if (FemaleRadio.getAttribute("checked") != null)
				{
					System.out.println("Female radiobutton is checked");
				}
				else
				{
					System.out.println("ERROR: Female radiobutton is unchecked");
				} 
			 }
			 else
			 {
				if (FemaleRadio.getAttribute("checked") != null)
				{
					System.out.println("ERROR: Female radiobutton is checked");
				}
				else
				{
					System.out.println("Female radiobutton is unchecked");
				} 
			 }
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Set_FirstName_Text(String FirstName) throws Exception {
		
		try{				
			
	        WebElement FirstNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname_id")));
			
	        FirstNameElement.sendKeys(FirstName);
	        
	        System.out.println("FirstName is " + FirstName);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Set_LastName_Text(String LastName) throws Exception {
		
		try{				
			
	        WebElement LastNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname_id")));
			
	        LastNameElement.clear();
	        LastNameElement.sendKeys(LastName);
	        
	        System.out.println("LastName is " + LastName);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Set_ReadOnly_Text(String NewString) throws Exception {
		
		try{			
			
	        WebElement ReadOnlyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname_rd_id")));
			
	        removeAttributeValue(ReadOnlyElement,"readonly","");
	        
	        ReadOnlyElement.clear();
	        ReadOnlyElement.sendKeys(NewString);
	        
	        System.out.println("NewString is " + NewString);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Verify_ReadOnly_Text(String ExpectedText) throws Exception {
		
		try{			
			
	        WebElement ReadOnlyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname_rd_id")));
				        	        	        
	        if(ReadOnlyElement.getAttribute("value").equals(ExpectedText))//getText() doesn't work
	        {
	        	System.out.println("Found text is equals to expected " + ExpectedText);
	        }
	        else
	        {
	        	System.out.println("ERROR: Found text "+ReadOnlyElement.getText()+" Not equals to expected " + ExpectedText);
	        }
	        
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Set_TextArea_Text(String NewText) throws Exception {
		
		try{	
			
			WebElement ReadOnlyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("textarea_id")));
				        
	        ReadOnlyElement.clear();
	        ReadOnlyElement.sendKeys(NewText);
	        
	        System.out.println("NewString is " + NewText);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}	
	
	public static void Set_CarType_Select(String ElementToSelect) throws Exception {
		
		try{			
			
			WebElement CarSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cars")));
			
			Select dropDown = new Select(CarSelect);
			     
			dropDown.selectByVisibleText(ElementToSelect);
	        
	        System.out.println("Selected " + ElementToSelect);
	        
	        /*
	         * 
	         * IWebElement selectBDElement = driver.FindElement(By.id("cars"));            
			   IList<IWebElement> allOptions = selectBDElement.FindElements(By.TagName("option"));
	            foreach (IWebElement option in allOptions)
	            {
	                System.Console.WriteLine("Value is: " + option.GetAttribute("value"));
	                if(option.GetAttribute("value").Equals("1977"))
	                {
	                    option.Click();
	                    break;
	                }
	            }

	         */
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Click_HaveBike_Checkbox(String State) throws Exception {
		
		try{			
			
			WebElement BikeCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bike_id")));
			
			if(BikeCheckBox.getAttribute("checked") == null && State == "check")
			{
				BikeCheckBox.click();
			}
			else if(BikeCheckBox.getAttribute("checked") != null && State == "uncheck")
			{
				BikeCheckBox.click();
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}

	public static void Click_HaveCar_Checkbox(String State) throws Exception {
		
		try{				
			
			WebElement CarCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("car_id")));
			
			if(CarCheckBox.getAttribute("checked") == null && State == "check")
			{
				CarCheckBox.click();
			}
			else if(CarCheckBox.getAttribute("checked") != null && State == "uncheck")
			{
				CarCheckBox.click();
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Click_Tab_Link(String TabName) throws Exception {
		
		try{
			
			switch (TabName) {
			
				case "Buyer": 
				
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("car_id"))).click();
				        
	            break;
	            
			   case "Seller":
			   
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab2_id"))).click();
			   		
			   break;
			  
			   default: 
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("car_id"))).click();
			   break;
			}
		
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Verify_TabText_Text(String ExpectedText) throws Exception {
		
		try{				
				        
	        WebElement Textelement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("text_tab1_id")));
			
	        if (Textelement.getText().toLowerCase().trim().equals(ExpectedText.toLowerCase().trim()))
            {
	        	System.out.println("Tab text equals to expected " + ExpectedText);
            }
            else
            {
            	System.out.println("Tab text "+Textelement.getText()+" equals to expected " + ExpectedText);
            }
	        
	        
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Verify_UserClientIP_Text(String UserName, String ExpectedIP) throws Exception {
		
		try{	
			
			boolean flgFound = false, flgIPequals = false;
			String foundUserIP = "";			
				        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("usersrow")));
			
	        List<WebElement> allRows = driver.findElements(By.className("usersrow"));
	        
	        for(WebElement row : allRows)
	        {
	        	WebElement userNameElement = row.findElement(By.className("username"));
	        		        	
	        	if(userNameElement.getText().equals(UserName))
	        	{
	        		WebElement userIPElement = row.findElement(By.className("client"));
	        		
	        		foundUserIP = userIPElement.getText();
	        		
	        		if(foundUserIP.equals(ExpectedIP))
	        		{
	        			System.out.println("User IP is as expected " + ExpectedIP);
	        			flgIPequals = true;	        			
	        		}
	        		
	        		flgFound = true;
	        		break;
	        	}
	        }
	        
	        if (!flgFound)
            {
	        	System.out.println("User " + UserName + " not found");
	        	return;
            }
	        
	        if (!flgIPequals)
            {
            	System.out.println("Found user IP " + foundUserIP + " not equals to expected " + ExpectedIP);
            }	        
	        
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
		
	public static void Set_Password_Text(String Password) throws Exception {
		
		try{	
						
	        WebElement PasswordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
				        
	        PasswordElement.clear();
	        PasswordElement.sendKeys(Password);
	        
	        System.out.println("Password is " + Password);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void UploadFile(String FileName) throws Exception {
		
		try{		
			
			WebElement UploadFileElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("upload_id")));
			
			UploadFileElement.sendKeys(FileName);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("upload_submit_id"))).click();
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}	

	public static void DownloadFile() throws Exception {
		
		try{			
			
			WebElement DownloadFileElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("download_form_id")));
			
			String filePath = DownloadFileElement.getAttribute("action");
			
			 //driver.navigate().to(filePath);	
			 			 
			 URL url = new URL(filePath);
             
             BufferedImage bufImgOne = ImageIO.read(url);
             ImageIO.write(bufImgOne, "png", new File("c:\\test.png"));
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
    public static void DownloadFile(String SaveFilePath) throws Exception {
		
		try{				
			
			WebElement DownloadFileElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("download_form_id")));
			
			String filePath = DownloadFileElement.getAttribute("action");
			
			 //driver.navigate().to(filePath);	
			 			 
			 URL url = new URL(filePath);
             
             BufferedImage bufImgOne = ImageIO.read(url);
             
             ImageIO.write(bufImgOne, "png", new File(SaveFilePath));
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void NewTabWorkAround() throws Exception {
		
		try{	
			
			Click_W3Schools_Link();
			
			SwitchToWindow("W3Schools Online Web Tutorials");
			
			CloseWindow("W3Schools Online Web Tutorials");
			
			Set_TextArea_Text("Hello");
			
			SwitchToWindow("Selenium automation");
			
			Set_TextArea_Text("Hello");
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Click_TryIt_Button() throws Exception {
		
		try{			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryit_id"))).click();		
			
			Alert alert = driver.switchTo().alert();
	        
			System.out.println("Alert: " + alert.getText() + " found and accepted");
			
	        alert.accept();
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	public static void Click_IFrame_Link() throws Exception {
		
		try{
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(("More information...")))).click();
			
			driver.switchTo().defaultContent();
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}                
	}

    public static void MouseMove(String NewText) throws Exception {
		
		try{
			
			WebElement Textelement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("text_tab1_id")));		
	        
			Actions action = new Actions(driver);
			
			action.moveToElement(Textelement).build().perform();	        
	        
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
    public static void Verify_AjaxDynamicElementUpdate() throws Exception {
		
		try{	
			
			boolean flgFound = false;
			
		    NavigateTo("https://www.google.com");
						
			WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));		
			
			searchBar.sendKeys("a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe")));
			
			List<WebElement> allRows = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
	        
	        for(WebElement row : allRows)
	        {		        	
	        	//validate no ajax in search result
	        	if(row.getText().equals("alarm"))
	        	{
	        		flgFound = true;
	        		break;
	        	}
	        }
			
	        if(flgFound)
	        {
	        	System.out.println("alarm element exists");
	        	flgFound = false;
	        }
	        else
	        {
	        	System.out.println("alarm element Not exists");
	        }
	        
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var newElement = document.createElement('li');newElement.innerHTML = 'alarm';document.getElementsByClassName('erkvQe')[0].appendChild(newElement);");
			
			allRows = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
	        
	        for(WebElement row : allRows)
	        {		        	
	        	//validate no ajax in search result
	        	if(row.getText().equals("alarm"))
	        	{
	        		flgFound = true;
	        		break;
	        	}
	        }
			
	        if(flgFound)
	        {
	        	System.out.println("alarm element exists");
	        	flgFound = false;
	        }
	        else
	        {
	        	System.out.println("alarm element Not exists");
	        }
			
			searchBar.sendKeys("jax");
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe")));
			
			allRows = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
	        
	        for(WebElement row : allRows)
	        {		        	
	        	//validate no ajax in search result
	        	if(row.getText().equals("alarm"))
	        	{
	        		flgFound = true;
	        		break;
	        	}
	        }
			
	        if(flgFound)
	        {
	        	System.out.println("alarm element exists");
	        	flgFound = false;
	        }
	        else
	        {
	        	System.out.println("alarm element Not exists");
	        }
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
    	
	private static void setAttributeValue(WebElement element, String attributeName, String newValue){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;        
        js.executeScript("arguments[0].style."+attributeName+"='"+newValue+"'", element);
		
	}
	
	private static void removeAttributeValue(WebElement element, String attributeName, String attribValue){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;        
        js.executeScript("arguments[0].removeAttribute('"+attributeName+"','"+attribValue+"')", element);
		
	}
	
	private static void Click_W3Schools_Link() throws Exception {
		
		try{			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Visit W3Schools"))).click();			
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	private static void SwitchToWindow(String WindowTitle) throws Exception {
		
		try{
			
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

            for(String window : windows)
            {
                Thread.sleep(1000);
                driver.switchTo().window(window);
                
                if (driver.getTitle().toLowerCase().trim().contains(WindowTitle.toLowerCase().trim()))
                {  
                    return;
                }
                
                
	        }		
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	private static void CloseWindow(String WindowTitle) throws Exception {
		
		try{
			
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

            for(String window : windows)
            {
                Thread.sleep(1000);
                driver.switchTo().window(window);

                if (driver.getTitle().toLowerCase().trim().contains(WindowTitle.toLowerCase().trim()))
                {                        
                    driver.close();
                    return;
                }

            }
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.toString());
		}
                
	}
	
	private static void InitEnvironment(Browser browser) {
		
		try{

		    switch (browser){

			case FIREFOX:

			    System.setProperty("webdriver.gecko.driver", ".//Tools//geckodriver.exe");

			    driver = new FirefoxDriver();

			    break;

			case CHROME:
			    System.setProperty("webdriver.chrome.driver", ".//Tools//chromedriver.exe");

			    driver = new ChromeDriver();
			    break;

			default:
			    driver = new ChromeDriver();
			    break;

		    }

		    driver.manage().window().maximize();
		    wait = new WebDriverWait(driver, 5);
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
                
	}
		
	private static void NavigateTo(String URL) throws Exception {
		
		try{			
			
			driver.get(URL);      
            
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
                
	}	
		
	private static void ExitEnvironment() throws Exception {
		
		try{			
			
	        driver.quit();
            
		}
		catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
                
	}
}
