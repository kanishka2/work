package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {


public static Object[][] readvalues() throws Exception{
	
	Object[][] data = null;
	
	//Creating a File
	File file = new File("C:\\Users\\training_d2.03.07\\Desktop\\TestData.xlsx");
	
	//Converting File to a file Input Stream
	FileInputStream fis = new FileInputStream(file);
	
	//Creating the workbook
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	//Creating an object for Sheet
	XSSFSheet sheet = wb.getSheet("TestMeAppUser");
	
	XSSFRow row1 = sheet.getRow(0);
	
	//Getting the total no of rows present in excel
	//int row_count = sheet.getLastRowNum();
	
	int rows = sheet.getPhysicalNumberOfRows();
		
	int cols = row1.getLastCellNum();
	
	System.out.println("Physical Row Count is : " + rows);
	//Creating an object to store the array values
	data = new Object[rows][cols];
	
	for (int i = 0; i <rows; i++) {
		//Create an Object for Rows
		XSSFRow row = sheet.getRow(i);
		
		int total_cols = row.getLastCellNum();			
		
		System.out.println("Column count is  : " + total_cols);			
		
		for (int j = 0; j < total_cols; j++) {
			String value = row.getCell(j).getStringCellValue();
			System.out.println(value);
			data[i][j]=value;
		}
		
	}
	
	
	
	return data;
	
}


}
