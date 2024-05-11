package Test;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.Version;


public  class SampleTest {
	
	@Test
	public void googleCheck() throws MalformedURLException, URISyntaxException, InterruptedException {
//		DesiredCapabilities capability=new DesiredCapabilities();
//		//capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
//		capability.setBrowserName("chrome");
//		capability.setPlatform(Platform.LINUX);
//		
//		//capability.setBrowserName("MicrosoftEdge");
//		WebDriver driver=new RemoteWebDriver(new URI("http://localhost:4444").toURL(),capability);
//		//WebDriver driver=new ChromeDriver();
//		driver.get("https://www.facebook.com/");
//		System.out.println(driver.getTitle());
//		driver.quit();
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[contains(@class,'logSprite')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("MAA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@id='autoSuggest-list']/li)[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("DEL");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@id='autoSuggest-list']/li)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		
        driver.findElement(By.xpath("//span[text()='Direct']")).click();
        int count=driver.findElements(By.xpath("//div[contains(@class,'srp-card-uistyles__SeoCard')]")).size();
		System.out.println(count);
		driver.quit();
}
}
