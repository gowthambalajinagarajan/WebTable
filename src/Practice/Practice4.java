package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice4 {
	public static void main(String[] args) throws IOException {
//Given an Input.Find out the Count of Input Present in the Excel
		File f=new File("C:\\Users\\acer\\Desktop\\Java\\Demo.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("Sheet1");
		
		for(int i=0;i<sh.getPhysicalNumberOfRows();i++) {
			Row r=sh.getRow(i);
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				Cell c=r.getCell(j);
				String Data=c.getStringCellValue();
				System.out.println(Data);
			}
		}
	}
}