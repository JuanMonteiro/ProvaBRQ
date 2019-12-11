package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Gerador {
	
	public class x {

		  public void main(String args[]) {
		    try {
		        FileInputStream fis = new FileInputStream("/src/test/resources/Others/Modelo.csv");
		        BufferedReader r = new BufferedReader(new InputStreamReader(fis,
		                "UTF8"));
		    
		        for (String s = ""; (s = r.readLine()) != null;) {
		            System.out.println(s);
		        }
		        r.close();
		        System.exit(0);
		    }

		    catch (Exception e) {
		        e.printStackTrace();
		        System.exit(1);
		    }
		  }
		}

}
