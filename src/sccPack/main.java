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
		
        TestPage.Verify_Title_Text("Test page");

        TestPage.Verify_Paragraph_Text("Selenium automation");

        //TestPage.Click_ThisIsALink_Link();

        TestPage.Verify_Logo_Image("big-logo.png", true);

        TestPage.Verify_ColoredText_Color("rgba(241, 50, 9, 1)");

        TestPage.Verify_Background_Color("rgba(176, 187, 7, 1)");

        //TestPage.Click_Submit_Button();

        //TestPage.Click_Image_Button();

        TestPage.Verify_Hidden_Text("Display none");*/

        //TestPage.select_Complex_Dropdown("Example");

        //TestPage.Click_Female_RadioButton();

        TestPage.Click_SelectGender_RadioButton("other");

        TestPage.Set_FirstName_TextEdit("Hello");

        TestPage.Set_LastName_TextEdit("1245567789");

        TestPage.Set_ReadOnly_TextEdit("Hello");

        TestPage.Verify_ReadOnly_TextEdit("nhfhjfjhfhg");

        TestPage.Verify_ReadOnly_TextEdit("readonly");

        TestPage.Set_TextArea_Text("Hello");

        TestPage.Set_CarType_Select("Mercedes");

        TestPage.Click_HaveBike_Checkbox("check");

        TestPage.Click_Tab_Link("Seller");

        TestPage.Print_Table();

        TestPage.Verify_UserClientIP_Text("John Hardy", "192.168.1.155");

        TestPage.Verify_LoginServerIP_Text("Ana", "10.2.2.100");

        TestPage.Set_Password_Text("2314234@Acdc");

        //Verify_Error_Message(false);

        TestPage.Set_Password_Text("hrthdfgth");

        //Verify_Error_Message(true);

        TestPage.Set_Password_Text("$%^&**@!");

        //Verify_Error_Message(true);

        //TestPage.File_Upload("C:\\1,028041eaffac.jpg");

        //TestPage.File_Download_Link("D:\\Dev\\esuper\\images\\thumbs\\YYY.png");

        //TestPage.NewTabWorkAround();

        //TestPage.Click_TryIt_Button();

        //TestPage.Click_IFrame_Link();

        //TestPage.Verify_Dynamic_Element();

        //TestPage.Verify_Hint_Element("ajax call");

        TestPage.MouseMove();

        Thread.sleep(5000);
		
		ExitEnvironment();
	}
	
	public static void Verify_Title_Text(String ExpectedText){

        try{
            WebElement element = Common.driver.findElement(By.id("page_title_id"));

            String PageTitle = element.getText();

            if(PageTitle.trim().equals(ExpectedText)){
                System.out.println("Found page title: \"" + PageTitle + "\" equals to expected \"" + ExpectedText + "\"");
            }else{
                System.out.println("ERROR - Found page title: \"" + PageTitle + "\" Not equals to expected \"" + ExpectedText + "\"");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_Label_Text(String ExpectedText){

        try{
            WebElement element = Common.driver.findElement(By.name("free_text_name"));

            String ParagraphText = element.getText();

            if(ParagraphText.trim().equals(ExpectedText)){
                System.out.println("Found page Paragraph: \"" + ParagraphText + "\" equals to expected \"" + ExpectedText + "\"");
            }else{
                System.out.println("ERROR - Found page Paragraph: \"" + ParagraphText + "\" Not equals to expected \"" + ExpectedText + "\"");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Click_ThisIsALink_Link() {

        try{

            //WebElement element = Common.driver.findElement(By.className("a_class"));
            //WebElement element = Common.driver.findElement(By.linkText("This is a link"));
            WebElement element = Common.driver.findElement(By.partialLinkText("This is"));

            element.click();

            System.out.println("Link \"This Is A Link\" was clicked successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_Logo_Image(String ExpectedImageName, Boolean Expected) {

        try{

            WebElement element = Common.driver.findElement(By.id("someimage_id"));
            String imageName = element.getAttribute("src");

            if(Expected){
                if(imageName.trim().contains(ExpectedImageName.trim())){
                    System.out.println("Image: \"" + ExpectedImageName + "\" found on the page");
                }else{
                    System.out.println("ERROR Image: \"" + ExpectedImageName + "\" not found on the page");
                }
            }else{
                if(!imageName.contains(ExpectedImageName)){
                    System.out.println("Image: \"" + ExpectedImageName + "\" not found on the page");
                }else{
                    System.out.println("ERROR Image: \"" + ExpectedImageName + "\" found on the page");
                }
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_ColoredText_Color(String ExpectedColor) {

        try{
            //Explicit
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
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

    public static void Verify_Background_Color(String ExpectedColor) {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("background_colored_text_id")));

            String bgColor = element.getCssValue("background-color");

            if(bgColor.trim().contains(ExpectedColor.trim())){
                System.out.println("Expected color " + ExpectedColor + " equals to found " + bgColor);
            }else{
                System.out.println("ERROR: Expected color " + ExpectedColor + " not equals to found " + bgColor);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Click_Submit_Button() {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_id"))).click();
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit_id"))).submit();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content_id']/form[1]"))).submit();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Click_Arrow_Button() {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imagebutton_id"))).click();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_Hidden_Text(String ExpectedText){

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("display_none_id")));

            SetAttributeValue(element, "display","");

            String ElementText = element.getText();

            if(ElementText.trim().equalsIgnoreCase(ExpectedText)){
                System.out.println("Found text " + ElementText + " equals Expected " + ExpectedText);
            }else{
                System.out.println("ERROR: Found text " + ElementText + " Not equals to Expected " + ExpectedText);
            }

            SetAttributeValue(element, "display","none");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_VisibilityHidden_Text(String ExpectedText){

        try{
            WebElement element = Common.driver.findElement(By.id("visibility_text_id"));

            SetAttributeValue(element, "visibility","");

            String ElementText = element.getText();

            if(ElementText.trim().equalsIgnoreCase(ExpectedText)){
                System.out.println("Found text " + ElementText + " equals Expected " + ExpectedText);
            }else{
                System.out.println("ERROR: Found text " + ElementText + " Not equals to Expected " + ExpectedText);
            }

            SetAttributeValue(element, "visibility","hidden");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Select_ComplexDropdown_Combo(String SelectText) throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'dropdown-toggle')]"))).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-menu"))).isDisplayed();

            //Common.driver.findElement(By.xpath("//div[@id='content_id']//ul[@class='dropdown-menu']/li/a[text()='"+SelectText+"']")).click();
            //Common.driver.findElement(By.xpath("//div[@id='content_id']//ul[@class='dropdown-menu']/li/a[contains(text(),'"+SelectText+"')]")).click();
            //Common.driver.findElement(By.xpath("//div[@id='content_id']//ul[@class='dropdown-menu']/li/a[contains(.,'"+SelectText+"')]")).click();
            Common.driver.findElement(By.xpath("//div[@id='content_id']//ul[@class='dropdown-menu']/li/a[.='"+SelectText+"']")).click();

            System.out.println("Item \"" + SelectText + "\" selected successfully");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Click_Female_RadioButton() throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("female_id"))).click();

            System.out.println("Female radiobutton was clicked");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Click_SelectGender_RadioButton(String RBName){

        try{
            //Implicit
            Common.driver.findElement(By.xpath("//input[@name='gender' and @value='"+RBName.toLowerCase()+"']")).click();

            System.out.println("Gender radio button clicked successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Set_FirstName_TextEdit(String FirstName){

        try{

            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname_id"))).sendKeys(FirstName);

            System.out.println("Set text \"" + FirstName + "\" to FirstName_TextEdit successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Set_LastName_TextEdit(String LastName){

        try{

            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname_id")));
            element.clear();
            element.sendKeys(LastName);

            System.out.println("Set text \"" + LastName + "\" to FirstName_TextEdit successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Set_ReadOnly_TextEdit(String SomeText){
        try{

            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname_rd_id")));

            RemoveAttribute(element, "readonly");

            element.clear();
            element.sendKeys(SomeText);

            System.out.println("Set text \"" + SomeText + "\" to FirstName_TextEdit successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_ReadOnly_TextEdit(String ExpectedText){

        try{
            WebElement element = Common.driver.findElement(By.id("lastname_rd_id"));
            String FoundText = element.getAttribute("value");//element.getText();

            if(FoundText.equalsIgnoreCase(ExpectedText)){
                System.out.println("Found text " + FoundText + " equals to expected " + ExpectedText);
            }else{
                System.out.println("ERROR: Found text " + FoundText + " not equals to expected " + ExpectedText);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Set_TextArea_Text(String NewText) throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
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
            /*WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement CarSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cars")));

            Select dropDown = new Select(CarSelect);

            dropDown.selectByVisibleText(ElementToSelect);

            System.out.println("Selected " + ElementToSelect);*/

            WebElement selectBDElement = Common.driver.findElement(By.id("cars"));
            List<WebElement> allOptions = selectBDElement.findElements(By.tagName("option"));
            for (WebElement option : allOptions)
            {
                System.out.println("Value is: " + option.getText());
                if(option.getText().equals(ElementToSelect))
                {
                    option.click();
                    break;
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Click_HaveBike_Checkbox(String State) throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement BikeCheckBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bike_id")));

            //String state = BikeCheckBox.getAttribute("checked");

            if(BikeCheckBox.getAttribute("checked") == null && State.equalsIgnoreCase("check"))
            {
                BikeCheckBox.click();

                //state = BikeCheckBox.getAttribute("checked");

                System.out.println("Checked");
            }
            else if(BikeCheckBox.getAttribute("checked") != null && State.equalsIgnoreCase("uncheck"))
            {
                BikeCheckBox.click();

                System.out.println("UnChecked");
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Click_Tab_Link(String TabName) throws Exception {

        WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));

        try{

            switch (TabName) {

                case "Buyer":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab1_id"))).click();
                    break;

                case "Seller":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab2_id"))).click();
                    break;

                default:
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab1_id"))).click();
                    break;
            }

            System.out.println("Tab " + TabName + " clicked");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Print_Table()  {

        WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("usersrow")));

        List<WebElement> allRows = Common.driver.findElements(By.className("usersrow"));

        for(WebElement row : allRows)
        {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            for(WebElement column : columns) {
                System.out.println(column.getText());
            }

            System.out.println(System.lineSeparator());
        }
    }

    public static void Verify_UserClientIP_Text(String UserName, String ExpectedIP) throws Exception {
        try{
            boolean flgFound = false, flgIPequals = false;
            String foundUserIP = "";

            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("usersrow")));

            List<WebElement> allRows = Common.driver.findElements(By.className("usersrow"));

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

    public static void Verify_LoginServerIP_Text(String LoginName, String ExpectedIP){

        boolean flgFound = false, flgIPEquals = false;
        String foundUserIP = "";

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("usersrow")));

            List <WebElement> allRows = Common.driver.findElements(By.className("usersrow"));

            for(int i = 1; i <= allRows.size(); i++){

                WebElement userNameElement = Common.driver.findElement(By.xpath("//table[@id='dable_id']//tr[@class='usersrow']["+i+"]/td[2]"));

                if(userNameElement.getText().trim().equalsIgnoreCase(LoginName.trim())){

                    flgFound = true;

                    WebElement userIPElement = Common.driver.findElement(By.xpath("//table[@id='dable_id']//tr[@class='usersrow']["+i+"]/td[4]"));

                    foundUserIP = userIPElement.getText();

                    if(userIPElement.getText().trim().equalsIgnoreCase(ExpectedIP.trim())){
                        flgIPEquals = true;
                    }
                    break;
                }
            }

            if(!flgFound){
                System.out.println("User" + LoginName + " not found");
            }else{

                if(flgIPEquals){
                    System.out.println("Found user IP " + foundUserIP + " equals to expected " + ExpectedIP + " for user " + LoginName);
                }else{
                    System.out.println("User IP " + ExpectedIP + " not found for user " + LoginName);
                }
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Set_Password_Text(String Password) throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
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

    public static void File_Upload(String FileName){

        try{
            WebElement element = Common.driver.findElement(By.id("upload_id"));
            element.sendKeys(FileName);
            //element.submit();
            Common.driver.findElement(By.id("upload_submit_id")).click();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void File_Download_Link(String FileName){

        try{
            WebElement element = Common.driver.findElement(By.xpath("//a[@download='proposed_file_name']"));
            String FilePath = element.getAttribute("href");

            URL url = new URL(FilePath);

            BufferedImage bImage = ImageIO.read(url.openStream());
            ImageIO.write(bImage, "png", new File(FileName));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void File_Download_Button(String FileName){

        try{
            WebElement element = Common.driver.findElement(By.id("download_form_id"));
            String FilePath = element.getAttribute("action");

            URL url = new URL(FilePath);

            BufferedImage bImage = ImageIO.read(url.openStream());
            ImageIO.write(bImage, "png", new File(FileName));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void NewTabWorkAround() {

        try{

            Click_W3Schools_Link();

            SwitchToWindow("W3Schools Online Web Tutorials");

            CloseWindow("W3Schools Online Web Tutorials");

            Set_TextArea_Text("Automation");

            SwitchToWindow("Selenium automation");//Selenium automation test page

            Set_TextArea_Text("Automation Programming");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    public static void Click_TryIt_Button() throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryit_id"))).click();

            Alert alert = Common.driver.switchTo().alert();

            System.out.println("Alert: " + alert.getText() + " found and accepted");

            //alert.accept();
            alert.dismiss();

        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }
    }

    private static void SwitchToWindow(String WindowTitle) throws Exception {
        try{

            ArrayList<String> windows = new ArrayList<String>(Common.driver.getWindowHandles());

            for(String window : windows)
            {
                Thread.sleep(1000);
                Common.driver.switchTo().window(window);
                Common.driver.switchTo().defaultContent();

                if (Common.driver.getTitle().toLowerCase().trim().contains(WindowTitle.toLowerCase().trim()))
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

            ArrayList<String> windows = new ArrayList<String>(Common.driver.getWindowHandles());

            for(String window : windows)
            {
                Thread.sleep(1000);
                Common.driver.switchTo().window(window);

                if (Common.driver.getTitle().toLowerCase().trim().contains(WindowTitle.toLowerCase().trim()))
                {
                    Common.driver.close();
                    return;
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    private static void Click_W3Schools_Link() throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Visit W3Schools"))).click();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }
    }

    public static void Click_IFrame_Link() throws Exception {

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));

            Common.driver.switchTo().frame(Common.driver.findElement(By.xpath("//iframe[1]")));

            wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(("More information...")))).click();

            Click_TryIt_Button();

            Common.driver.switchTo().defaultContent();

            Click_TryIt_Button();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }
    }

    public static void Verify_Dynamic_Element(){

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            boolean flgFound = false;

            Common.driver.get("https://www.google.com/");

            WebElement SearchBar = Common.driver.findElement(By.name("q"));

            SearchBar.sendKeys("a");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe"))).isDisplayed();

            List <WebElement> allOptions = Common.driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

            for(WebElement row : allOptions){
                if(row.getText().equalsIgnoreCase("alarm")){
                    flgFound = true;
                    break;
                }
            }

            if(flgFound){
                System.out.println("alarm element exists");
                flgFound = false;
            }else{
                System.out.println("alarm element Not exists");
            }

            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor)Common.driver;
            js.executeScript("var newElement = document.createElement('li'); newElement.innerHTML = 'alarm'; document.getElementsByClassName('G43f7e')[0].appendChild(newElement);");

            Thread.sleep(1000);

            allOptions = Common.driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

            for(WebElement row : allOptions){
                if(row.getText().equalsIgnoreCase("alarm")){
                    flgFound = true;
                    break;
                }
            }

            if(flgFound){
                System.out.println("alarm element exists");
                flgFound = false;
            }else{
                System.out.println("alarm element Not exists");
            }

            SearchBar.sendKeys("jax");

            Thread.sleep(2000);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe"))).isDisplayed();

            allOptions = Common.driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

            for(WebElement row : allOptions){
                if(row.getText().equalsIgnoreCase("alarm")){
                    flgFound = true;
                    break;
                }
            }

            if(flgFound){
                System.out.println("alarm element exists");
                flgFound = false;
            }else{
                System.out.println("alarm element Not exists");
            }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Verify_Hint_Element(String HintName){

        try{
            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            int flgFound = -1;

            Common.driver.get("https://www.google.com/");

            WebElement SearchBar = Common.driver.findElement(By.name("q"));

            SearchBar.sendKeys("a");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe"))).isDisplayed();

            JavascriptExecutor js = (JavascriptExecutor)Common.driver;
            js.executeScript("var newElement = document.createElement('li'); newElement.innerHTML = 'alarm'; document.getElementsByClassName('G43f7e')[0].appendChild(newElement);");

            SearchBar.sendKeys("jax");

            for(int i = 0; i < 5; i++){

                List <WebElement> allOptions = Common.driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

                for(WebElement row : allOptions){
                    if(row.getText().equalsIgnoreCase("alarm")){
                        flgFound = 1;
                        break;
                    }else{
                        flgFound = 0;
                    }
                }

                if(flgFound == 0){
                    break;
                }

                Thread.sleep(2000);
            }

            if(flgFound == 0){
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("erkvQe"))).isDisplayed();

                List <WebElement> allOptions = Common.driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));

                for(WebElement row : allOptions){
                    if(row.getText().equalsIgnoreCase(HintName)){
                        flgFound = 1;
                        break;
                    }
                }

                if(flgFound == 1){
                    System.out.println("alarm " + HintName + " exists");
                }else{
                    System.out.println("ERROR alarm " + HintName + " Noe exists");
                }
            }else{
                System.out.println("ERROR Hint list is not updated");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void MouseMove() throws Exception {

        try{

            WebDriverWait wait = new WebDriverWait(Common.driver, Duration.ofSeconds(5));
            WebElement Textelement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab2_id")));

            Actions action = new Actions(Common.driver);

            action.moveToElement(Textelement).build().perform();

        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

    }

    private static void SetAttributeValue(WebElement element, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor)Common.driver;
        js.executeScript("arguments[0].style."+attributeName+" = '"+attributeValue+"'", element);
    }
    private static void RemoveAttribute(WebElement element, String attributeName){
        JavascriptExecutor js = (JavascriptExecutor)Common.driver;
        js.executeScript("arguments[0].removeAttribute('"+attributeName+"')", element);
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
