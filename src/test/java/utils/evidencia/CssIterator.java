package utils.evidencia;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Pages.BasePage;

public class CssIterator extends BasePage {
	
	public static List<String> style;
	
	/**
	 * Este m�todo adiciona o javascript de marca��o da p�gina web
	 * @author F�bio Vaz
	 * @since 27/09/2018
	 */
	public static void markWebElement(WebElement ... elements) {
		
		style = new LinkedList<>();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for (WebElement element : elements) {
			style.add(element.getCssValue("border").toString());			
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid Darkgreen;');", element);
		}
	}
	
	/**
	 * Este m�todo retira o javascript de marca��o da p�gina web
	 * @author F�bio Vaz
	 * @since 27/09/2018
	 */
	public static void markOffWebElement(WebElement ... elements) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		int i = 0;
		for (WebElement element : elements) {
			js.executeScript("arguments[0].setAttribute('style', '" + style.get(i++) + "');", element);
		}
	}
	
}
