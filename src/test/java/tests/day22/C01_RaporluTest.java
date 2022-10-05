package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Pozitif Test", "Geçerli Kullanıcı Adı ve Password ile giris yapıldı");
        //    -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentacarUrl"));
        extentTest.info("Blue RentaCar sitesine gidıldı");
        //    -login butonuna bas
        BlueCar blueCar = new BlueCar();
        blueCar.login.click();
        extentTest.info("login butonuna basıldı");

        //    -test data user email: customer@bluerentalcars.com ,
        blueCar.email.sendKeys(ConfigReader.getProperty("useremail"));

        //    -test data password : 12345 dataları girip login e basın
        blueCar.password.sendKeys(ConfigReader.getProperty("datapassword"));// d yi eksik girdik bilerek hata yaptık
        //raporun resmını gormek ıcın ustune tıklayıp sag clıck yapıyoruz sonra open in sonra eksplorer a tıklamalıyız.


        //    -login butonuna tiklayin
        blueCar.passwordlogin.click();
        extentTest.info("dogru kullanıcı email ve password girildi");
        extentTest.info("ikinci login butonuna basıldı");
        //    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        assert blueCar.basariliGiris.isDisplayed();
        extentTest.info("Sayfaya basarili bir sekilde girildi");
        /*
        hocanın cozumu

         */

    }


}
