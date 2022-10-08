package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethod extends TestBaseBeforeClassAfterClass {
    //dependsOn(bagli olmak) methodu, kodlari birbirine baglar. eger bagladigimiz test pass olmazsa, bagli test te calismaz
//iki test biribirine bagli iken, bagladigimiz testi calistirinca once baglananan test calisir sonra bagli test calisir ama
// 3 test bagli ise bu sekilde olmaz
    @Test
    public void test1() {
        // amazon ana sayfasına gidelim
        driver.get("https://www.amazon.com");
    }

    @Test (dependsOnMethods = "test1")
    public void test2() {
        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test2")
    public void test3() {
        //Sonuc yazısının amazon içerdiğini test edelim
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }

}