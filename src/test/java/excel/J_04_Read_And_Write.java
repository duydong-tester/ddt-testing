package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class J_04_Read_And_Write {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "/testData/writeData.xlsx");

		XSSFWorkbook workBook = new XSSFWorkbook(fileInput);

		XSSFSheet sheet = workBook.getSheet("Read-Write");

		XSSFRow row = sheet.createRow(1);

		XSSFCell cell = row.createCell(1);

		cell.setCellValue("Alo");

		FileOutputStream fileOutput = new FileOutputStream(System.getProperty("user.dir") + "/testData/writeData.xlsx");

		workBook.write(fileOutput);

		workBook.close();
		fileInput.close();
		fileOutput.close();

		System.out.println("Done!");
	}

}
