package tests.day14_testNGFramework_assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PositiveLoginTesti {


    @Test(groups = {"smoke", "regression", "E2E"})
    public void positiveLoginTesti() {
        /*
            Testlerimizi DINAMIK yapmak
            ve test datalarina KOLAY ERISMEK icin
            test datalarini configuration.properties dosyasina yazip
            ihtiyacimiz oldugunda oradan almak istiyoruz

            Java ile o bilgilere ulasmak icin
            once dosya yolunu almamiz
            sonra oradaki bilgileri okumamiz
            bilgiler icerisinde ihtiyacimiz olan "toUrl", "toGecerliEmail"
            gibi bilgileri diger bilgilerden ayirip
            alip bu test class'ina getirmemiz tek satirla olabilecek bir islem degildir

            Bu uzun islemi bizim adimiza yapip
            verdigimiz "toUrl", "toGecerliEmail" gibi key'lerin
            karsisindaki value'leri alip bize getirecek hazir bir method olusturalim
         */

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);


        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("gecerli@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        ReusableMethods.bekle(1);

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                .click();

        // Actions objesi olusturularak PAGE_DOWN "(PAGE_UP)'ta gerek halinde kullanilabilir" kullanilarak
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(2);

        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());


        // logout olun

        testotomasyonuPage.logoutButonu
                .click();

        Driver.quitDriver();

    }


    @Test(groups = {"smoke", "regression"})
    public void dinamikPositiveLoginTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);


        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        ReusableMethods.bekle(1);

        // Actions objesi olusturularak PAGE_DOWN "(PAGE_UP)'ta gerek halinde kullanilabilir" kullanilarak
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        // logout olun
        testotomasyonuPage.logoutButonu
                .click();
        Driver.quitDriver();


    }
}