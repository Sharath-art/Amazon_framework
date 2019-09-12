package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {
	public XSSFWorkbook wb;
	public ExcelDataprovider() throws IOException {
		
		
		 
		try {
			File src = new File("C:\\Workspace\\Amazon\\Amazon\\TestData\\Data.xlsx");
			FileInputStream fis = new FileInputStream(src);
						
					 wb = new XSSFWorkbook(fis);
				
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("unable to get Excel file"+e.getMessage());
		}
		
		
	}

	public String getStringData(String SheetName, int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		}
	
	public double getNumericData(String SheetName, int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
		}

}
