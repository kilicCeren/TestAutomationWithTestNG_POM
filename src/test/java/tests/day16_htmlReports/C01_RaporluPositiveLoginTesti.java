package tests.day16_htmlReports;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {
    /*
        TestNG kendisi HTML rapor olusturamaz

        HTML rapor olusturabilmek icin
        farkli dependency'ler kullanilabilir
        biz aventstack dependency kullandik

         aventstack raporlama icin 3 objeye ihtiyac duyar
         Bu objeleri her class'da olusturmak ve gerekli islemleri yapmak yerine
         bu isslemleri bizim adimiza yapacak bir TestBaseRapor olusturduk

         olusturlmasi gereken 3 obje TestBaseRapor'da olusturuldu
         bu objeleri ve yapilan ayarlari kullanmanin
         en kisa yolu extends keyword ile TestBaseRapor'u parent edinmektir

         TestBaseRapor'da olusturulan 3 objeden
         extentReports ve extentHtmlReporter'a deger atamasi yapildi
         extentTest'e deger atamasi her test method'unda yapilmalidir

         HTML raporda gorunmesini istedigimiz test adimlarini
         extentTest objesi ile rapora isleyebiliriz
     */

    @Test
    public void raporluPositiveLoginTesti() {
        extentTest = extentReports.createTest("Positive Login Testi", "Gecerli bilgilerle sisteme giris yapilabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");
        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        ReusableMethods.bekle(1);
        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");
        // 6- Basarili olarak giris yapilabildigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        // Actions objesi olusturularak PAGE_DOWN "(PAGE_UP)'ta gerek halinde kullanilabilir" kullanilarak
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);
        // logout olun
        testotomasyonuPage.logoutButonu
                .click();
        extentTest.info("Logout butonuna basarak cikis yapar");

        extentTest.info("sayfayi kapatir");
    }
}