package utils.evidencia;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import com.itextpdf.text.pdf.PdfWriter;

import utils.DateTimeUtils;
import utils.exceptions.ExceptionUtils;

public class EvidenciaIterator {
	
	/**
	 * Este m�todo tem a fun��o de preparar e salvar a evid�ncia em um local
	 * indicado
	 * 
	 * @author F�bio Vaz
	 * @since 27/09/2018
	 */
	public static void setPathToSaveEvidence(String path) {
		try {
			String date = LocalDate.now().toString();
			String time = LocalTime.now().toString();

			date = DateTimeUtils.formataData(date, "").replace("/", ".");
			String hora = time.substring(0, 2);
			String minutos = time.substring(3, 5);
			String segundos = time.substring(6, 8);

			time = hora + "h" + minutos + "m" + segundos + "s";

			File diretorio = new File(path);
			if (!diretorio.exists()) {
				diretorio.mkdirs();
			}
			
			Evidencia.setNomeEvidencia(date + "_" + time + " - " + Evidencia.getNomeCt() + "_" + ".pdf");
			Evidencia.setCaminho(path);

			PdfWriter.getInstance(Evidencia.getDocument(), new FileOutputStream(Evidencia.getCaminho() + Evidencia.getNome()));
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
	}
	
	/**
	 * Este m�todo deve ser chamado para finalizar o report, ao fim da execu��o
	 * 
	 * @author F�bio Vaz
	 * @since 27/09/2018
	 */
	public static void finishEvidencia(boolean isFalha) {

		Evidencia.getDocument().close();
		String novoNome = Evidencia.getNome().replace(".pdf", "");

		if (!isFalha) {
			novoNome = novoNome + "_PASSED.pdf";
		} else {
			novoNome = novoNome + "_FAILED.pdf";
		}

		new File(Evidencia.getCaminho() + Evidencia.getNome()).renameTo(new File(Evidencia.getCaminho() + novoNome));
		Evidencia.setNomeEvidencia(novoNome);
	}
	
}
