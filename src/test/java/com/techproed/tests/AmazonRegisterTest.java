package com.techproed.tests;
import com.techproed.pages.AmazonRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AmazonRegisterTest extends TestBase {
    private AmazonRegisterPage amazonRegisterPage = new AmazonRegisterPage();
    @Test (priority = 0)
    public void ilkTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_register_url"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Amazon Registration");
    }
    // AC 01 : Name box görünür olmalı.
    @Test(priority = 1)
    public void nameBoxGorunurTesti(){
        boolean nameBoxGorunurMu = amazonRegisterPage.nameBox.isDisplayed();
        Assert.assertTrue(nameBoxGorunurMu);
    }
    //AC 03 : Email box görünür olmalı.
    @Test(priority = 2)
    public void emailBoxGorunurTesti(){
        boolean emailBoxGorunurMu = amazonRegisterPage.emailBox.isDisplayed();
        Assert.assertTrue(emailBoxGorunurMu);
    }
    //AC 07 : Şifre kutusu görünür olmalı.
    @Test (priority = 3)
    public void sifreKutusuGorunurTesti(){
        boolean passBoxGorunurMu = amazonRegisterPage.passwordBox.isDisplayed();
        Assert.assertTrue(passBoxGorunurMu);
    }
    //AC 09 : 2. Şifre kutusu görünür olmalı.
    @Test(priority = 4)
    public void reSifreKutusuGorunurTesti(){
        boolean rePassBoxGorunuyorMu = amazonRegisterPage.rePasswordBox.isDisplayed();
        Assert.assertTrue(rePassBoxGorunuyorMu);
    }
    //AC 13 : Create you amazon account butonu görünür olmalı.
    @Test(priority = 5)
    public void buttonGorunurMu(){
        boolean buttonGorunuyorMu = amazonRegisterPage.continueButton.isDisplayed();
        Assert.assertTrue(buttonGorunuyorMu);
    }
    //AC 02 : Name box boş bırakılamamalı.
    @Test(priority = 6)
    public void kayitTestiNameboxBos(){
        amazonRegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.emailBox.sendKeys(ConfigReader.getProperty("amazon_register_email"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
    //AC 04 : Email box boş bırakılamamalı.
    @Test(priority = 7)
    public void kayitTestiEmailboxBos(){
        amazonRegisterPage.emailBox.clear();
        amazonRegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.nameBox.sendKeys(ConfigReader.getProperty("amazon_register_name"));
        amazonRegisterPage.rePasswordBox.sendKeys(ConfigReader.getProperty("amazon_register_pass"));
        amazonRegisterPage.continueButton.click();
        Assert.assertFalse( Driver.getDriver().getTitle().equals("Authentication required") );
    }
}