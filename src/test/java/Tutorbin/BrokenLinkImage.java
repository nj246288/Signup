package Tutorbin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkImage {

	public static <HTTPURLConnection> void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tutorbin\\Desktop\\Selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://public.tutorbin.in/");

		List<WebElement> linksList = (List<WebElement>) driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of full links and images------>" + linksList.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < linksList.size(); i++) {
		System.out.println(linksList.get(i).getAttribute("href"));
		if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript")));{
		activeLinks.add(linksList.get(i));

		}
		}
		System.out.println("size of active links and images------>" + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) {

		try {
		HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String response = connection.getResponseMessage();
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href") + "------>" + response);
		}catch(Exception e) {
		continue;
		}

		}

	}
}
