package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class J_01_Read_Data {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testData/readData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Read");

		int rows = sheet.getLastRowNum() + 1;
		int cells = sheet.getRow(0).getLastCellNum();

		System.out.println("Number of rows: " + rows);
		System.out.println("Number of cells: " + cells);

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cells; c++) {
				XSSFCell cell = row.getCell(c);
				System.out.print(cell.toString() + (" - "));
			}
			System.out.println();
		}

		workBook.close();
		file.close();
	}

}
