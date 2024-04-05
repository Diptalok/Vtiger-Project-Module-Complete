package com.Generic.Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile_Utility {
	public String readData(String name, int r, int c) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(name).getRow(r).getCell(c).getStringCellValue();
	}
}
