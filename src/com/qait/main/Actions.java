package com.qait.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author nachiketatripathi
 *
 */
public class Actions {

	public Object[][] readFromExcel() throws IOException {
		String Filepath ="./res/list.xlsx";
		
		//String Filepath = "C:/Users/nachiketatripathi/Downloads/list.xlsx";
		File fileName = new File(Filepath);
		FileInputStream inputStream = new FileInputStream(fileName);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet excelsheet = wb.getSheet("Sheet1");
		int rowCount = excelsheet.getLastRowNum() - excelsheet.getFirstRowNum() + 1;

		Object[][] obj = new String[rowCount][excelsheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < rowCount; i++) {
			Row row = excelsheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				obj[i][j] = row.getCell(j).getStringCellValue();
			}
		}

		return obj;
	}
}
