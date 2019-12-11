package utils.readers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import utils.exceptions.ExceptionUtils;

public class XlsxReader {
	
	private static JsonArray tabela = new JsonArray();
	private static boolean primeiraLinha = true;
	private static List<String> chaves = new LinkedList<>();
	private static int contHeaders;
	
	/**
	 * Este método realiza a leitura incremental das células da linha de uma aba da planilha
	 * @author Fábio Vaz
	 * @since 27/09/2018 
	 */
	public static void lerCelulas(Row row) {
		
		JsonObject objectLinha = new JsonObject();
		List<String> valores = new LinkedList<>();
		
		if (primeiraLinha == true) {
			contHeaders = row.getLastCellNum();
		}
		
		for (int colNum = 0; colNum < contHeaders; colNum++) {

			Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			switch (cell.getCellType()) {
				case STRING:
					valores.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					valores.add(Double.toString(cell.getNumericCellValue()).replaceAll("\\.[0-9]*", ""));
					break;
				case BLANK:
					valores.add("");
					break;
				default:
					valores.add("");
					break;
			}
			
		}
		
		if (primeiraLinha == true) {
			chaves = valores;
			primeiraLinha = false;
		} else {
			for (int cont = 0; cont < chaves.size(); cont++) {				
				String target = chaves.get(cont).trim();
				objectLinha.addProperty(target, valores.get(cont));
			}
			tabela.add(objectLinha);
		}
		
	}
	
	/**
	 * Este método realiza a leitura incremental das linhas da aba da planilha
	 * @author Fábio Vaz
	 * @since 27/09/2018 
	 */
	public static void lerLinhas(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			lerCelulas(row);
		}
	}
	
	/**
	 * Este método retorna um json array da primeira aba da planilha
	 * 
	 * A planilha deve estar na estrutura conforme exemplo: <br>
	 * | Nome  | idade | <br>
	 * | Fábio | 00029 | <br>
	 * 
	 * @author Fábio Vaz
	 * @since 27/09/2018 
	 */
	public static JsonArray getFirstSheetInJson(String pathWithExtension) {
		
		try {
			FileInputStream excelFile = new FileInputStream(new File(pathWithExtension));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = datatypeSheet.iterator();
	
			lerLinhas(rowIterator);
			workbook.close();
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
		
		return tabela;	
	}
		
}