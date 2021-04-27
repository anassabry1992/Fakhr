package ibtikar.Fakhr;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase{
	
	protected WebDriver driver;
	
	@SuppressWarnings("resource")
	public void openMyBrowser(String url) {
		
		System.out.println("Choose a browser: Chrome - Firefox - Edge");
		String browser = new Scanner(System.in).next().toLowerCase();
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
}
