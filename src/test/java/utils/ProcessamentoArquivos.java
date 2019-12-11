package utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

import Pages.BasePage;
import utils.evidencia.Evidencia;
import utils.evidencia.EvidenciaIterator;
import utils.readers.Config;

public class ProcessamentoArquivos extends BasePage {

	String date = LocalDate.now().toString();
	String time = LocalTime.now().toString();
	

	
	public void selecionarArquivoRobot(String nome) {

		System.setProperty("java.awt.headless", "true");
		
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString();
		
		//nome = "03.12.2019 - EnvioNPS.csv";
		//Nome = date + "_" + "Time" + " - " + "EnvioNPS.csv";
		

		path = path.concat(("./target/" + nome).replace("./", "/").replace("/", "\\"));
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		SeleniumUtils.wait(2000);


		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			SeleniumUtils.wait(3000);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception exception) {
			Evidencia.addFailedText("Não foi possivel acionar o ROBOT para manipular o upload de arquivo.");
			EvidenciaIterator.finishEvidencia(true);
		}

	}

	
	
}
