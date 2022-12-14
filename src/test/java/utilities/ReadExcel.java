package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ReadExcel {

	public static WebDriver driver;
	@DataProvider (name="testdata")
	public static String [][] getData() throws IOException {
		
		//step-1-set the path of file
		String path=System.getProperty("user.dir")+"\\data.xlsx";

		//step-2-create object of file
		File file=new File(path);

		//step-3-create object of fileInputstream
		FileInputStream fis=new FileInputStream(file);

		//step-4-create object of XSSFWorkbook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//step-5-locate the sheet under workbook
		XSSFSheet sheet=wb.getSheetAt(0);
		 
		//step-6-get row from sheet context
		int row=sheet.getLastRowNum();
		
		//step-7-get cell from sheet context
		int cell= sheet.getRow(0).getLastCellNum();

		String data [][]=new String[row][cell];
		for(int i=0;i<row;i++) {
			for(int j=0;j<cell;j++) {
				data
				[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
			}
		return data;
		}
		
}
