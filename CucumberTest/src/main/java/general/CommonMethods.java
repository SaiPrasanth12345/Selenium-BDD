package general;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

public class CommonMethods {

	public static WebDriver driver;
	String searchText = "//textarea[@title='Search']";
	String searchresult = "//h3[.='Selenium']";
	String searchbtn = "//div[not(contains(style,'display:none'))]/div/center/input[@value='Google Search']";
	// String seleniumJavaSearch = "//div[@role='heading' and text()='Selenium
	// Java']";
	String seleniumJavaSearch = "//h3[.='Selenium WebDriver']";

	public void getDriver() {
		driver = DriverInstatntation.driverSetup();
	}

	public byte[] scrnscht() {
		TakesScreenshot takesScrnsht = (TakesScreenshot) driver;
		byte[] scrnsht = takesScrnsht.getScreenshotAs(OutputType.BYTES);
		return scrnsht;
	}

	public void googleLaunch() {
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	public void searchGoogleText(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchText)));
		driver.findElement(By.xpath(searchText)).sendKeys(text);
		driver.findElement(By.xpath(searchText)).sendKeys(Keys.ENTER);
	}

	public void searchGoogleTextusingJavaScript(String text) {
		WebElement ele = driver.findElement(By.xpath(searchText));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + text + "';", ele);

		WebElement eleClick = driver.findElement(By.xpath(searchbtn));
		// getLocation method
		Point point = eleClick.getLocation();
		System.out.println("X: " + point.getX() + " Y: " + point.getY());

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", eleClick);
	}

	public String getTextResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchresult)));
		return driver.findElement(By.xpath(searchresult)).getText();
	}

	public boolean searchDisplayed() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(searchresult)).isDisplayed();
	}

	public List<String> getDataFromExcel() throws Exception {
		List<String> dataLst = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("src/test/resources/excelData/testData.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			dataLst.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		return dataLst;
	}

	public boolean seleniumJavadisplayed() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(seleniumJavaSearch)).isDisplayed();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void amazonLaunch() {
		// driver.get("https://www.amazon.com/");
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	
	public void addProduct() {
		String searchBox = "//input[contains(@id,'searchtextbox')]";
		String prod1 = "//a/span[contains(.,'B. softies- 12\" Plush Bunny- Huggable Stuffed Animal Rabbit Toy- Soft & Cuddly Plush Bunny – Washable – Newborns, Toddlers, Kids- Happy Hues- Sprinkle Bunny - 0 Months +')]";
		String qty = "//select[@name='quantity']";
		String addCart = "//input[@id='add-to-cart-button']";
		
		driver.findElement(By.xpath(searchBox))
				.sendKeys("B. Toys by Battat – Happy Hues – Sprinkle Bunny – Huggable Stuffed Animal Rabbit Toy");
		driver.findElement(By.xpath(searchBox)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(prod1)).click();

		System.out.println(driver.findElements(By.xpath(qty)).size());
		Select sel = new Select(driver.findElement(By.xpath(qty)));
		sel.selectByVisibleText("2");
		driver.findElement(By.xpath(addCart)).click();
	}

	public String validateCartCount() {
		String cartCount = "//span[@id='nav-cart-count']";
		
		// validate cart count
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		System.out.println("Count:" +driver.findElement(By.xpath(cartCount)).getText());
		// Assert.assertEquals(driver.findElement(By.xpath(cartCount)).getText(), "2");
		return driver.findElement(By.xpath(cartCount)).getText();
	}

	public boolean validateCart() {
		String navCart = "//a[@id='nav-cart']";
		String shoppingCart = "//h1[' Shopping Cart']";
		String itemInCart = "//div[@class='sc-item-content-group']//a/span/span[contains(.,'B. toys- B. softies- 12\" Plush Bunny')]";

		driver.findElement(By.xpath(navCart)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(shoppingCart))));
		// Assert.assertTrue(driver.findElement(By.xpath(itemInCart)).isDisplayed());
		return (driver.findElement(By.xpath(itemInCart)).isDisplayed());
	}
}
