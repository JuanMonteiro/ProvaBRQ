package utils.evidencia;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import utils.DateTimeUtils;
import utils.InfraUtils;
import utils.readers.Config;

public class Cover {
	
	public static void insertCover() {
		insertLogon(Config.getProperty("path.upload.logon"));
		insertObjective();
		Evidencia.addText("Data atual: " + DateTimeUtils.insertDateNow());
		Evidencia.addText("Hora atual: " + DateTimeUtils.insertTimeNow() + " - hora do Brasil");
		Evidencia.addText("Endereco IP: " + InfraUtils.getIpClient());
		Evidencia.addText("Usuario local ou de rede: " + InfraUtils.getWindowsUser());
		Evidencia.addText("Nome do computador de execucao: " + InfraUtils.getPcName());
		Evidencia.addNewPage();
	}
	
	public static void insertObjective() {
		String text = "Evidencia de Teste\n" + "Funcionalidade: " + Evidencia.getfunci() + "\n" + "Cenario: " + Evidencia.getNomeCt() + "\n" + "Ambiente: " + Evidencia.getAmb().toLowerCase().replace("_", " ");
		Evidencia.addFormatedText(text, FontFactory.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE, 40, 200, Element.ALIGN_CENTER);
	}
	
	public static void insertLogon(String logonPath) {
		Evidencia.addExternalImage(logonPath, Element.ALIGN_JUSTIFIED, 300f, 150f);
	}
	
}
