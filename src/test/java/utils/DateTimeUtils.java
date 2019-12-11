package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import utils.exceptions.ExceptionUtils;

public class DateTimeUtils {
	
	public static String formataData(String data) {
		return formataData(data, "");
	}

	public static String formataData(String data, String pattern) {

		if (data.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {

			String ano = data.substring(0, 4);
			String mes = data.substring(5, 7);
			String dia = data.substring(8, 10);

			return dia + "/" + mes + "/" + ano;
		}

		return data;
	}
	
	public static String insertDateNow() {		
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			return formatDate.format(new Date());
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
		return null;
	}
	
	public static String insertTimeNow() {		
		SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss a");
		return formatTime.format(new Date());
	}

}
