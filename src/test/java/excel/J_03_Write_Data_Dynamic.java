package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class J_03_Write_Data_Dynamic {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testData/writeData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("Dynamic");
		Scanner scanner = new Scanner(System.in);

		System.out.println("How namy rows?");
		int rows = scanner.nextInt();

		System.out.println("How namy cells?");
		int cells = scanner.nextInt();

		System.out.println("Write data");
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cells; c++) {
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(scanner.next());
			}
		}

		scanner.close();
		workBook.write(file);
		workBook.close();
		file.close();

		System.out.println("Done!");
	}

}
