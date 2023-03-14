package Tutorbin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ClickDropDown {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tutorbin\\Desktop\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	//	Assert.assertFalse(driver.findElement(By.cssSelector(\"input[id*='SeniorCitizenDiscount']\")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("hrefIncAdt")).click();
	     /*	int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		} */
		//a[@value='BLR']
		
		for(int i=1; i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
	  //
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
	//	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 adult");)
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
	

}
}
