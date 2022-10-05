package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    /*Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    priority methodunu kullanırız
     Priority kullanmazsak default olarak 0 dır
     */
    @Test (priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }

    @Test // Burayı 0 kabul eder
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
    }
    //(mehmet hocadan:)
// testleri birbirine bagladigimizda
// 1- 2.methodu tek basina calistirmak istesek bile otomatik olarak once 1.method calisir
// 2= 1.method failed olursa 2.method ignore edilir yani hic calistirimaz
// eger 3 test veya daha fazlasi birbirine dependsOn ile baglandiysa
// 3.yu calistirmak istedigimizde zincir reaksiyon calisip 1.ye GITMEZ
    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }
    @Test (groups ="gp1")
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");
    }
}