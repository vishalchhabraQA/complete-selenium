package globalvariables;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Global {
	/* How to drive the global environmental values from external files to tests in java :- 
	 * How to write global parameters with java code :-
	 * .properties file:- in java we can drive values from .properties file
	 */
		public static void main(String[] args) throws IOException {
		
			Properties p = new Properties(); //Class help to extract/read values from .properties file
			FileInputStream f = new FileInputStream("/home/vishal/eclipse-workspace/propertiesFileGlobal/src/globalvariables/data.properties");
			//to get know properties class the path/location of .properties file
			p.load(f); //now p object have knowledge where .properties file is located! and got connected to f.
			//open file in read mode
			String browser = p.getProperty("browser"); //to get property of browser from .properties file
			String url = p.getProperty("url"); 
			
			System.out.println(browser);
			System.out.println(url);
			
			p.setProperty("name", "Vishal Chhabra");
			System.out.println(p.getProperty("name")); 
			//to get any property of .properties file but it will not update or write over .properties file
		
			//to update or write over .properties file then use: FileOutputStream
			
			FileOutputStream fo = new FileOutputStream("/home/vishal/eclipse-workspace/propertiesFileGlobal/src/globalvariables/data.properties");
			p.store(fo, null);  //open file in write mode
			//now if we run it got update the .properties file
		}
}
