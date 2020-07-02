package automation.apache_poi_data_driven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetExcelData g = new GetExcelData();
		ArrayList<Object> data = g.getXlData("purchase");
		
		for(int i=0; i<data.size(); i++) {
			data.get(i);
		}
	}

}
