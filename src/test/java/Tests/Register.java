package Tests;

import Actions.Register_Action;
import Commons.Result_Execls;
import Objects.Excel_Object;
import Objects.Register_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Register {
    //1. Move to Register page.
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;

    //Verify that Error message" Email already exists!" displays when user enters Email has been registered.
    @Test
    public void register1() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Register_Object register = new Register_Object();

        //2. Enter Email has been registered.
        register.setEmail("hongvanlkcit@gmail.com");

       // 3. Enter all field.
        register.setPassword("abc123");
        register.setConfirmPassword("abc123");
        register.setName("hongvan");
        register.setCompany("iviettech");
        register.setPhone("0935396638");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //4. Click on Register button.
        Register_Action.enterRegister(dr, register);
        Register_Action.clickRegister(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//p[text()='Email already exists!']")).isDisplayed() == true) {
            ex.setTC_ID("1");
            ex.setTC_Summary("Verify that Error message\" Email already exists!\" displays when user enters Email has been registered.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_10");
        } else {
            ex.setTC_ID("1");
            ex.setTC_Summary("Verify that Error message\" Email already exists!\" displays when user enters Email has been registered.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_10");
        }

        Result_Execls.saveResultExcel(ex);
    }

    //Verify that message" Please enter your password" displays when user leaves Password field blank.
    @Test
    public void register2() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Register_Object register = new Register_Object();
        register.setEmail("hongvanlkcit@gmail.com");
        //2. Leave Password field blank
        register.setPassword("");
        //3. Enter all field.
        register.setConfirmPassword("abc123");
        register.setName("hongvan");
        register.setCompany("iviettech");
        register.setPhone("0935396638");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //4. Click on Register button.
        Register_Action.enterRegister(dr, register);
        Register_Action.clickRegister(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Please enter your password']")).isDisplayed() == true) {
            ex.setTC_ID("2");
            ex.setTC_Summary("Verify that message\" Please enter your password\" displays when user leaves Password field blank.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_11");
        } else {
            ex.setTC_ID("2");
            ex.setTC_Summary("Verify that message\" Please enter your password\" displays when user leaves Password field blank.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_11");
        }

        Result_Execls.saveResultExcel(ex);
    }

    //Verify that User can not create account when user enter Phone are special characters or character.
    @Test
    public void register3() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Register_Object register = new Register_Object();
        //3. Enter all field.
        register.setEmail("hongvanlkcit@gmail.com");
        register.setPassword("abc123");
        register.setConfirmPassword("abc123");
        register.setName("hongvan");
        register.setCompany("iviettech");

        //2. Enter Phone is special character.
        register.setPhone("@$@%$FDG");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //4. Click on Register button.
        Register_Action.enterRegister(dr, register);
        Register_Action.clickRegister(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Only numbers 0-9']")).isDisplayed() == true) {
            ex.setTC_ID("3");
            ex.setTC_Summary("Verify that User can not create account when user enter Phone are special characters or character.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_19");
        } else {
            ex.setTC_ID("3");
            ex.setTC_Summary("Verify that User can not create account when user enter Phone are special characters or character.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_19");
        }

        Result_Execls.saveResultExcel(ex);
    }

    //Verify that validation message " Register success!" displays when user register successful.
    @Test
    public void register4() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Register_Object register = new Register_Object();
        //2. Enter all field correct.
        register.setEmail("hongvanlkcit436565243@gmail.com");
        register.setPassword("abc123");
        register.setConfirmPassword("abc123");
        register.setName("hongvan");
        register.setCompany("iviettech");
        register.setPhone("0935396638");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //3. Click Register button.
        Register_Action.enterRegister(dr, register);
        Register_Action.clickRegister(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//p[text()='Register success!']")).isDisplayed() == true) {
            ex.setTC_ID("4");
            ex.setTC_Summary("Verify that validation message \" Register success!\" displays when user register successful");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_022");
        } else {
            ex.setTC_ID("4");
            ex.setTC_Summary("Verify that validation message \" Register success!\" displays when user register successful");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_022");
        }

        Result_Execls.saveResultExcel(ex);
    }
    //Verify that error message" Password does not match the confirm password!" displays
    // when the user enter the Confirm password should be match the Password.
    @Test
    public void register5() throws IOException{
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Register_Object register = new Register_Object();
        register.setEmail("hongvanlkcit543@gmail.com");
        //2. Enter Password
        register.setPassword("abc123");
        //3. Enter Confirm password must match the Password.
        register.setConfirmPassword("abcd123");
        //4. Enter all field.
        register.setName("hongvan");
        register.setCompany("iviettech");
        register.setPhone("0935396638");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //5. Click on Register button.
        Register_Action.enterRegister(dr, register);
        Register_Action.clickRegister(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//p[text()='Password does not match the confirm password!']")).isDisplayed() == true) {
            ex.setTC_ID("5");
            ex.setTC_Summary("Verify that error message\" Password does not match the confirm password!\" displays " +
                            "when the user enter the Confirm password should be match the Password.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_013");
        } else {
            ex.setTC_ID("6");
            ex.setTC_Summary("Verify that error message\" Password does not match the confirm password!\" displays " +
                            "when the user enter the Confirm password should be match the Password.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_013");
        }

        Result_Execls.saveResultExcel(ex);
    }
}
