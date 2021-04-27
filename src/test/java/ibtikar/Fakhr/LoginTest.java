package ibtikar.Fakhr;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestData.ExcelSheetReader;

public class LoginTest extends TestBase{
	 
	private int indexData = 1;
	private int colsOnSheet = 2;
	private String url = "https://fakhr-landingpage.ibtik.net/ar/";
	private String profileUrl = "https://fakhr-landingpage.ibtik.net/ar/profile";
	
	@DataProvider(name="DataFakhr")
	public Object[][] getTestData() throws IOException{
		return new ExcelSheetReader().getExcelData(indexData,colsOnSheet);
	}
	
	@BeforeTest
	public void openBrowser() {
		openMyBrowser(url);
	}
	
	@Test(dataProvider = "DataFakhr", priority = 1)
	public void testLoginMethod(String username, String password, String resMsg){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginMethod(username, password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals(loginPage.getResponseMessage(), resMsg);
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//	}
}