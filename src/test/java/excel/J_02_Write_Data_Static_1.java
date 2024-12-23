package excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class J_02_Write_Data_Static_1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testData/writeData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("Static");

		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Tools");
		row1.createCell(1).setCellValue("Version");
		row1.createCell(2).setCellValue("Comments");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Selenium");
		row2.createCell(1).setCellValue("4.27.0");
		row2.createCell(2).setCellValue("Updating");

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Java");
		row3.createCell(1).setCellValue("21.0.5");
		row3.createCell(2).setCellValue("LTS Version");

		workBook.write(file);
		workBook.close();
		file.close();

		System.out.println("Done!");
	}

}
