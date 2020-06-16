package libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericExcel {
   public static String getValue(String path, String sheet, int r, int c) {
	   String value="";
	   try {
		   FileInputStream fin = new FileInputStream(path);
		   Workbook wb = WorkbookFactory.create(fin);
		   value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return value;
   }
   
   public static int getRowCount(String path, String sheet) {
	   int rc=0;
	   try {
		   FileInputStream fin = new FileInputStream(path);
		   Workbook wb = WorkbookFactory.create(fin);
		   rc = wb.getSheet(sheet).getLastRowNum();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return rc;
   }
   
   public static int getColumnCount(String path, String sheet, int r) {
	   int cc=0;
	   try {
		   FileInputStream fin = new FileInputStream(path);
		   Workbook wb = WorkbookFactory.create(fin);
		   cc = wb.getSheet(sheet).getRow(r).getLastCellNum();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return cc;
   }
   
}
