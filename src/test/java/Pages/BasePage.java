package Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.InfraUtils;
import Utilidade.ProcuraElemento;

public class BasePage {
	public static WebDriver driver;
	ProcuraElemento element = new ProcuraElemento();

	public BasePage() {
		BasePage.driver = driver;

	}

	@Before
	public WebDriver setUP(String url) throws IOException {
		/*System.setProperty("ambiente.teste", "it2");
		System.setProperty("ambiente.teste", "prod");*/

		if(InfraUtils.getOsName().contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		}

		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("disable-infobars");
		op.addArguments("disable-notifications");
		/*op.addArguments("--window-size=1366,768");
		op.addArguments("--headless");*/
		op.addArguments("--test-type");
		op.addArguments("--start-maximized");
		op.addArguments("--ignore-certificate-errors");
		op.addArguments("--disable-default-apps");
		op.addArguments("--disable-extensions");
		op.addArguments("--javascriptEnabled");
		op.addArguments("--applicationCacheEnabled");
		op.addArguments("--lang=pt-BR");
		op.addArguments("--incognito");


		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
		return driver;
	}
	
	@After
    public void tearDown() {
		driver.quit();
	}

}
