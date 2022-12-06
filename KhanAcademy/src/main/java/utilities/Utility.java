package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreen(WebDriver driver, int testID) throws IOException
	{
		SimpleDateFormat formattter = new SimpleDateFormat("DD-MM-YYYY hh-mm-ss");
		Date date = new Date();
		String d = formattter.format(date);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File ("testScreenshots\\KhanAcademyTest" +d+ ".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	public static String getDataFromExcel (String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String path ="src\\test\\resources\\testData\\TestData.xlsx";
		FileInputStream file = new FileInputStream (path);
		Cell c = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);
		
		String cellValue = "";
		
		try
		{
			cellValue = c.getStringCellValue();
		}
		catch (IllegalStateException ise)
		{
			Double numCellValue = c.getNumericCellValue();
		}
		catch (NullPointerException npe)
		{
			npe.printStackTrace();
			npe.getMessage();
		}
		
		return cellValue;
	}

}
