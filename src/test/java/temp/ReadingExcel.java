package temp;

import io.maestrano.marlin.utils.Xls_Reader;

public class ReadingExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(System.getProperty("user.dir")+"/Data.xlsx");
		Xls_Reader xls = new Xls_Reader("/Users/premalathaeddyam/eclipse-workspace/Marlin/Data.xlsx");
		
		
		int rowCount  =xls.getRowCount("Data");
		System.out.println(rowCount);
	}

}
