package Utilidade;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.evidencia.Evidencia;
import utils.evidencia.EvidenciaIterator;

public class ProcuraElemento {
	public boolean ProcuraElemento(WebDriver driver, String TipoProcura, String valIdentifica, String acao,
			String valor, int tempo) throws Throwable {

		try {
			for (int i = 0; i < tempo; i++) {
				try {
					WebElement result = null;
					switch (TipoProcura) {
					case "id":
						result = driver.findElement(By.id(valIdentifica));
						break;
					case "name":
						result = driver.findElement(By.name(valIdentifica));
						break;
					case "class":
						result = driver.findElement(By.className(valIdentifica));
						break;
					case "xpath":
						result = driver.findElement(By.xpath(valIdentifica));
						break;
					case "Css":
						result = driver.findElement(By.cssSelector(valIdentifica));
						break;
					}
					// Verifica result

					if (result.isDisplayed() == true) {

						switch (acao) {
						case "send":
							result.sendKeys(valor);
							return true;
						// break;
						case "click":
							result.click();
							return true;
						case "exists":
							return true;
						case "clear":
							result.clear();
							return true;
						case "notexists":
							return false;
						}

					} else {

						Thread.sleep(2000);
					}

				} catch (Exception e) {
					Thread.sleep(1800);
				}
			} // end for
			if (acao.equals("notexists")) {
				return false;

			}

			else {
				Evidencia.addPrintFailed("Erro ao encontrar elemento: " + valIdentifica);
				EvidenciaIterator.finishEvidencia(true);
				driver.close();
				return false;
			}

		} catch (Exception e) {
			if (acao.equals("notexists")) {
				return false;

			}

			else {
				Evidencia.addPrintFailed("Erro ao encontrar elemento: " + valIdentifica);
				EvidenciaIterator.finishEvidencia(true);
				driver.close();
				return false;
			}
		}

	}

	public boolean ValidaMensagem(WebElement ElementoMsg, WebDriver driver, String Esperado, String Obtido)
			throws Throwable {

		if (Esperado.equals(Obtido)) {
			return true;
		} else {
			new HighLight().highlightElement(driver, ElementoMsg);
			Evidencia.addPrintFailed(
					"Erro ao comparar msgs:" + "\nTexto Esperado: " + Esperado + "\n Texto Obtido: " + Obtido);
			EvidenciaIterator.finishEvidencia(true);
			driver.close();
			return false;

		}

	}

}
