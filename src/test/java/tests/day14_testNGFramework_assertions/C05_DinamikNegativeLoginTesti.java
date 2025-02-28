package tests.day14_testNGFramework_assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_DinamikNegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test(groups = "smoke")
    public void gecersizPasswordTesti() {
        testotomasyonuPage = new TestotomasyonuPage();

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);

        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }

    @Test(groups = {"smoke", "regression"})
    public void gecersizEmailTesti() {
        testotomasyonuPage = new TestotomasyonuPage();

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        Driver.quitDriver();
    }

    @Test(groups = {"smoke", "E2E"})
    public void gecersizEmailGecersizPasswordTesti() {
        testotomasyonuPage = new TestotomasyonuPage();

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //  JavascriptExecutor objesi ile  sayfa ortlanarak hizlandi,
        // Web Elementleri'nin bulunmasinda cozunurluk ile ortaya cikacak sorunlar engellenmeye calisildi,
        // Gerek halinde bu kod revize edilebilir

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", testotomasyonuPage.loginButonu);

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        Driver.quitDriver();
    }
}