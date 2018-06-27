package Tests;

//import Actions.CreateCustomer_Action;
import Actions.*;
import Commons.Result_Execls;
import Commons.WaitforControl;
import Objects.ClickShowAllCustomer_Object;
import Objects.CreateCustomer1_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testcases {
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;


    //Verify that error message ' Please enter your email' displays when user leave Email field blank
    @Test
    public void dangnhap1() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");

        Login_Object ob2 = new Login_Object();
        //2. Leave Email field blank
        ob2.setEmail("");
        //3. Enter password.
        ob2.setPassword("abc123");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //4. Click Login button.
        Login_Action.enterEmailAndPassword(dr, ob2);
        Login_Action.clickLogin(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Please enter your email']")).isDisplayed() == true) {
            ex.setTC_ID("6");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_01");
        } else {
            ex.setTC_ID("6");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_01");
        }

        Result_Execls.saveResultExcel(ex);
    }

    //Verify that Error message " The Email  or Password is incorrect !" displays when user login with incorrect Username or Password.
    @Test
    public void dangnhap2() throws IOException{
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");

        Login_Object ob2 = new Login_Object();
        //2. Enter email and password is incorrect
        ob2.setEmail("vyvanviet@gmail.com");
        ob2.setPassword("aab123");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //3. Click on Login button.
        Login_Action.enterEmailAndPassword(dr, ob2);
        Login_Action.clickLogin(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//p[text()='The email or password is incorrect!']")).isDisplayed() == true) {
            ex.setTC_ID("7");
            ex.setTC_Summary("Verify that Error message \" The Email  or Password is incorrect !\" displays when user login with incorrect Username or Password");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_04");
        } else {
            ex.setTC_ID("7");
            ex.setTC_Summary("Verify that Error message \" The Email  or Password is incorrect !\" displays when user login with incorrect Username or Password");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_04");
        }

        Result_Execls.saveResultExcel(ex);
    }


    //Verify that Moves to Customer List page when user login successfully.
    CreateCustomer1_Object create = new CreateCustomer1_Object();
    @BeforeMethod
    public void First () throws IOException{
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Login_Object ob1 = new Login_Object();
        //2. Enter email and password correct
        ob1.setEmail("vyvanviet@gmail.com");
        ob1.setPassword("abc123");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get(siteURL);

        //3. Click on Login button.
        Login_Action.enterEmailAndPassword(dr, ob1);
        Login_Action.clickLogin(dr);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div/div/div[2]")).isDisplayed() == true) {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_03");
        } else {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_03");
        }

        Result_Execls.saveResultExcel(ex);

    }

    //Verify that "Name", "Address", "Phone", "Email" fields displays when user selects "Create customer" in Customer dropdown.
    @Test
    public void CreateACustomer () throws IOException {
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");
        //2. Click on Create Customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);



        Excel_Object ex1 = new Excel_Object();
        if ((dr.findElement(By.xpath(".//label[text()='Name']")).isDisplayed() == true) && (dr.findElement(By.xpath(".//label[text()='Email']")).isDisplayed()==true)
                && (dr.findElement(By.xpath(".//label[text()='Phone']")).isDisplayed()==true) &&(dr.findElement(By.xpath(".//label[text()='Address']")).isDisplayed()==true) ){
            ex1.setTC_ID("9");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_026");
        } else {
            ex1.setTC_ID("9");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_026");
        }

        Result_Execls.saveResultExcel(ex1);
        //Assert.assertEquals(true,dr.findElement(By.xpath("//strong[text()='Create Customer']")).isDisplayed());


    }

    //Verify that Error message " Please enter your Name" displays when user leave Name field blank.
    @Test
    public void BlankName() throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);

        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");
        //2. Click on Create customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);

        //3. Leave Name field blank
        create.setName("");
        //4. Enter all field.
        create.setEmail("hongvanlkcit@gmail.com");
        create.setPhone("0935396638");
        create.setAddress("da nang");

        //5. Click on Create a customer button.
        CreateCustomer1_Action.enterCreateACustomer(dr,create);
        CreateCustomer1_Action.clickCreateACustomer(dr);

            Excel_Object ex1 = new Excel_Object();
            if (dr.findElement(By.xpath(".//span[text()='Please enter your name']")).isDisplayed() == true) {
                ex1.setTC_ID("10");
                ex1.setTC_Summary("Verify that Error message \" Please enter your Name\" displays when user leave Name field blank.");
                ex1.setTC_Result("Passed");
                ex1.setTC_Note("TC_027");
            } else {
                ex1.setTC_ID("10");
                ex1.setTC_Summary("Verify that Error message \" Please enter your Name\" displays when user leave Name field blank.");
                ex1.setTC_Result("Failed");
                ex1.setTC_Note("TC_027");
            }

            Result_Execls.saveResultExcel(ex1);
    }
    //Verify that User can not create a Customer when user enter Phone are special characters or character.
    @Test
    public void SpecialCharacterPhone() throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");

        //2. Click on Create customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);
        create.setName("VanMai");
        create.setEmail("hongvanlkcit@gmail.com");
        //3. Enter Phone field are special characters or characters.
        create.setPhone("dfl!#@$#");
        //4. Enter all field.
        create.setAddress("da nang");

        //5. Click on Create a customer button.
        CreateCustomer1_Action.enterCreateACustomer(dr,create);
        CreateCustomer1_Action.clickCreateACustomer(dr);

        Excel_Object ex1 = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Only numbers 0-9']")).isDisplayed() == true) {
            ex1.setTC_ID("11");
            ex1.setTC_Summary("Verify that User can not create a Customer when user enter Phone are special characters or character.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_034");
        } else {
            ex1.setTC_ID("11");
            ex1.setTC_Summary("Verify that User can not create a Customer when user enter Phone are special characters or character.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_034");
        }

        Result_Execls.saveResultExcel(ex1);
    }
    //Verify that User can not create a Customer when user enters Email field is special characters.
    @Test
    public void SpecialCharacterEmail()throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");

        //2. Click on Create customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);
        create.setName("VanMai");
        //3. Enter Email field is special characters.
        create.setEmail("$#^^&@gmail.com");
        //4. Enter all field.
        create.setPhone("0935396638");
        create.setAddress("da nang");

        //5. Click on Create a customer button.
        CreateCustomer1_Action.enterCreateACustomer(dr,create);
        CreateCustomer1_Action.clickCreateACustomer(dr);

        Excel_Object ex1 = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='The email is not valid (ex: abc@abc)']")).isDisplayed() == true) {
            ex1.setTC_ID("12");
            ex1.setTC_Summary("Verify that User can not create a Customer when user enters Email field is special characters.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_030");
        } else {
            ex1.setTC_ID("12");
            ex1.setTC_Summary("Verify that User can not create a Customer when user enters Email field is special characters");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_030");
        }

        Result_Execls.saveResultExcel(ex1);
    }

    //Verify that "Move to Customer List page" displays when user create a Customer successful.
    @Test
    public void CreateCustomerSuccess() throws IOException {
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");

        //2. Click on Create customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);
        create.setName("VanMai");
        //3. Enter correct all field.
        create.setEmail("hongvanlkcit@gmail.com");
        create.setPhone("0935396638");
        create.setAddress("da nang");

        //4. Click on Create a customer button.
        CreateCustomer1_Action.enterCreateACustomer(dr, create);
        CreateCustomer1_Action.clickCreateACustomer(dr);

        Excel_Object ex1 = new Excel_Object();
        if ((dr.findElement(By.xpath(".//strong[text()='Show All Customers']")).isDisplayed() == true) &&
                (dr.findElement(By.xpath(".//h5[text()='Customers List']")).isDisplayed() == true)) {
            ex1.setTC_ID("13");
            ex1.setTC_Summary("Verify that \"Move to Customer List page\" displays when user create a Customer successful");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_039");
        } else {
            ex1.setTC_ID("13");
            ex1.setTC_Summary("Verify that \"Move to Customer List page\" displays when user create a Customer successful");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_039");
        }

        Result_Execls.saveResultExcel(ex1);
    }
        //Verify that the duplicate information display when user enter a lead by name at Search field.
        @Test
        public void DuplicateInformation(){
        //1. Move to Customer dropdown.
            ClickCustomer_Action.clickCustomer(dr);
            WaitforControl.waitforControlVisible(dr, ".//a[text()='Show All Customers']");
        //2. Click on Show all customer
            ClickShowAllCustomer_Action.clickShowAllCustomer(dr);
            ClickShowAllCustomer_Action.clickName(dr);

            ClickShowAllCustomer_Object ob1 = new ClickShowAllCustomer_Object();
            ob1.setName("hong");


    }
}




