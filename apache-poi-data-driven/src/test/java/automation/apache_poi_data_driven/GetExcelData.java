package automation.apache_poi_data_driven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Excel sheet :- Sheet 1 Tab :-

	testcases		data1	data2	data3	
	login			a		a		a	
	purchase		b		b		b	
	add-profile		c		c		c	
	delete-profile	d		d		d	
				
*/
public class GetExcelData {

	/*
		java.util.ArrayList<String>
		
		Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list. (This class is roughly equivalent to Vector, except that it is unsynchronized.)
		
		The size, isEmpty, get, set, iterator, and listIterator operations run in constant time. The add operation runs in amortized constant time, that is, adding n elements requires O(n) time. All of the other operations run in linear time (roughly speaking). The constant factor is low compared to that for the LinkedList implementation.

	 */
	
	
	public ArrayList<Object> getXlData(String testCaseName) throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "/data-driven-apache-poi.xlsx");
		System.out.println(path);
		XSSFWorkbook x = new XSSFWorkbook(fis); //connected to the excel file

		ArrayList<Object> xlData = new ArrayList<Object>();
		
		int count = x.getNumberOfSheets();
		System.out.println(count);
		for(int i=0; i<count; i++) {
			System.out.println(x.getSheetName(i));
			if(x.getSheetName(i).equalsIgnoreCase("Sheet1")) {
			
				XSSFSheet sheet = x.getSheetAt(i); //sheet is Sheet 1 out of many sheet tabs in excel
				//now identify test cases column by scanning the entire first row
				System.out.println(x.getSheetName(i));
				Iterator<Row> it = sheet.iterator(); //iteration through all the rows 
				Row firstRow = it.next(); //reached to first row
				//sheet is a collection of cells
				//row is a collection of cells 
				Iterator<Cell> it2 = firstRow.cellIterator(); //iteration through all the cells of row
				
				int columnNo=0;
				System.out.println(columnNo);
				while(it2.hasNext()) { //if next cell is present
					Cell c = it2.next(); //moved to first cell
					System.out.println(columnNo);	
					if(c.getStringCellValue().equalsIgnoreCase("testcases")) {
						System.out.println("col no" + columnNo);
						break;
					}
					columnNo++;
				}
				
				//once column is identified, then scan entire testcase column to identify purchase testcase row
				while(it.hasNext()) {
					Row r = it.next(); //go to first row
					String cellValue = r.getCell(columnNo).getStringCellValue();
					System.out.println(cellValue);
					if(cellValue.equalsIgnoreCase(testCaseName)) {
						System.out.println(testCaseName + " found!");
						
						//purchase testcase row is grabbed, now pull all data of that row and feed into test
						Iterator<Cell> purchase = r.cellIterator();
						
						while(purchase.hasNext()) {
							Cell p = purchase.next();
							
							System.out.println(p.getCellType());
							if(p.getCellType() == CellType.STRING) {
								System.out.println("hello");
								xlData.add(p.getStringCellValue());
							}
							else {
//							xlData.add(NumberToTextConverter.toText(p.getNumericCellValue()));
							xlData.add(p.getNumericCellValue());
							}
						}
						
						break;
					}
				}
			}
		}
		System.out.println(xlData);
		return xlData;
	}
	
	public static void main(String[] args) throws IOException {
		
		GetExcelData e = new GetExcelData();
		e.getXlData("purchase");

	}
	
	
}
