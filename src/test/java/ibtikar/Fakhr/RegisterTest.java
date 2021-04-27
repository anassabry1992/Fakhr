package ibtikar.Fakhr;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestData.ExcelSheetReader;

public class RegisterTest extends TestBase{
	 
	private int indexData = 0;
	private int colsOnSheet = 10;
	private String url = "https://fakhr-landingpage.ibtik.net/ar/";
//	private String loginUrlAfterRegister = "https://fakhr-landingpage.ibtik.net/ar/login";
	
	@DataProvider(name="DataFakhr")
	public Object[][] getTestData() throws IOException{
		return new ExcelSheetReader().getExcelData(indexData,colsOnSheet);
	}
	
	@BeforeTest
	public void openBrowser() {
		openMyBrowser(url);
	}
	
	@Test(dataProvider = "DataFakhr", priority = 1)
	public void testRegisterMethod(String firName, String secName, String thrName, String famName, String idNum,
			String mobNum, String email, String password, String confPassword, String resMsg){
		RegisterPage regPage = new RegisterPage(driver);
		regPage.registerMethod(firName, secName, thrName, famName, idNum, mobNum, email, password, confPassword);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals(regPage.getResponseMsg(), resMsg);
		regPage.closeResponseMsg();
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//	}
}