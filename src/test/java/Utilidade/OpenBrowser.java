package Utilidade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenBrowser {
	
	public WebDriver abrirNavegador(WebDriver driver, String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("disable-infobars");
			driver = new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		} catch (Exception e) {
			System.out.println("Erro ao abrir o navegador\n" + e.getMessage());
			return null;
		}

	}


}
