package excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class J_02_Write_Data_Static_2 {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testData/writeData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("Static");

		int rows = 3;
		int cells = 3;

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cells; c++) {
				if (r == 0) {
					row.createCell(0).setCellValue("Tools");
					row.createCell(1).setCellValue("Version");
					row.createCell(2).setCellValue("Comments");
				} else if (r == 1) {
					row.createCell(0).setCellValue("Selenium");
					row.createCell(1).setCellValue("4.27.0");
					row.createCell(2).setCellValue("Updating");
				} else if (r == 2) {
					row.createCell(0).setCellValue("Java");
					row.createCell(1).setCellValue("21.0.5");
					row.createCell(2).setCellValue("LTS Version");
				}
			}
		}

		workBook.write(file);
		workBook.close();
		file.close();

		System.out.println("Done!");
	}

}
