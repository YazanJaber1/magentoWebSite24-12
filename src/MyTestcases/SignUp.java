package MyTestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1, enabled = true)
	public void myFirstTest() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.linkText("Create an Account")).click();

		// find the elements
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));

		WebElement CreateAccountButtonElement = driver
				.findElement(By.cssSelector("button[title='Create an Account'] span"));

		// interact with the elements
		FirstName.sendKeys(FirstNames[RandomIndex]);
		LastName.sendKeys(LastNames[RandomIndex]);
		Email.sendKeys(emailID);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);

		CreateAccountButtonElement.click();

		String WelcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(WelcomeMsg, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2, enabled = true)
	public void logoutProcess() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");

		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}

	@Test(priority = 3, enabled = true)
	public void LoginProcess() throws InterruptedException {

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(emailID);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();

		// driver.findElement(By.cssSelector(".panel.header")).getText(); we delete this
		// after write printing word.

		Thread.sleep(2000);// here i need this code to get text.

//		System.out.println(driver.findElement(By.cssSelector(".greet.welcome")).getText());

		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}

//	@Test(priority = 4, enabled = true)
//	public void addOneRandomItem() {
//
//		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
//		WebElement footer = driver.findElement(By.cssSelector(".footer.content"));
//		int theNumberOfTagA = footer.findElements(By.tagName("a")).size();
//		System.out.println(theNumberOfTagA);
//
//		int theNumberOfH1Tag = driver.findElements(By.tagName("h1")).size();
//	
//    System.out.println(theNumberOfH1Tag + "this is a total h1 tags inside page");

	@Test(priority = 4, enabled = true)
	public void addOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");

		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int NumberOfItems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(NumberOfItems);

		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();

		// we use css selector if we take more than one class name.
		WebElement SizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));

		// System.out.println(SizesContainer.findElements(By.className("swatch-option")).size());
		int theSizes = SizesContainer.findElements(By.className("swatch-option")).size();
		SizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
		Thread.sleep(2000);

		WebElement ColorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int TheColors = ColorsContainer.findElements(By.className("swatch-option")).size();
		ColorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(TheColors)).click();
		Thread.sleep(2000);

		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(5000);

		String ActualMasseage = driver.findElement(By.cssSelector(".page.messages")).getText();

		assertEquals(ActualMasseage.contains("You added"), true);

	}

}
