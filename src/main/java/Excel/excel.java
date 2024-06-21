package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class excel {

	                @Test
		            public void fetchExcelData() throws IOException
		            {
		            String excelPath = "C:\\Users\\Unthinkable-lap\\Downloads\\bridge-loan-automation\\bridge-loan-automation\\TestData.xlsx";
		            String fileNameString = "TestData";
		            String sheetName = "Sheet1";
		            
		            // Create object of the file to get the file path
		            File file = new File(excelPath);
		            // to read file
		            FileInputStream fis = new FileInputStream (file);
		            
		            XSSFWorkbook wb = new XSSFWorkbook(fis);
		             XSSFSheet sheet =wb.getSheet(sheetName);
		             
		             int totalRowsCount =sheet.getLastRowNum();
		              
		             System.out.println("The total row count in excel file are "+totalRowsCount);
		             
		                                XSSFRow firstrow =sheet.getRow(0);
		                                //int totalColumnCunt =firstrow.getLastCellNum();
		                                
		           // System.out.println("The total column count : "+ totalColumnCunt );
		             
		             
		             //Firstrow and First column
		             String data =sheet.getRow(0).getCell(0).getStringCellValue();
		             System.out.println(data);
		             
		           //Firstrow and Second column
		             String data1 =sheet.getRow(0).getCell(1).getStringCellValue();
		             System.out.println(data1);
		            
		           //Secondow and First column
		             String data2 =sheet.getRow(1).getCell(0).getStringCellValue();
		             System.out.println(data2);
		            
		           //Secondow and Second column
		             String data3 =sheet.getRow(1).getCell(1).getStringCellValue();
		             System.out.println(data3);
		             
		             //Firstcolumn and first row
		             String data4 = sheet.getRow(0).getCell(0).getStringCellValue();
		             System.out.println("Cell : " +data4);
		             
		             //Firstcolumn and Second row
		             String data5 = sheet.getRow(1).getCell(0).getStringCellValue();
		             System.out.println("Cell : " +data5);
		             
		           //Secondcolumn and first row
		             String data6 = sheet.getRow(0).getCell(1).getStringCellValue();
		             System.out.println("Cell : " +data6);
		             
		             //Secondcolumn and Second row
		             String data7 = sheet.getRow(1).getCell(1).getStringCellValue();
		             System.out.println("Cell : " +data7);
		             //Create data in sheet.
		             
		             sheet.getRow(2).createCell(0).setCellValue("DataWrite");
		             FileOutputStream fos = new FileOutputStream(file);
		             wb.write(fos);
		             wb.close();
		             
		             //Create Data in excel if the row does not exist
		             
		             XSSFRow row = sheet.getRow(11);
		             if (row == null) {
		                 // If row doesn't exist, create it
		            	 
		                 row = sheet.createRow(11);
		             }
		                 row.createCell(0).setCellValue("DataWrite");
		                 
		             FileOutputStream fos1 = new FileOutputStream(file);
		             
		             wb.write(fos1);
		             
		             wb.close();
		            
	                
//		             for(int i=0;i<totalRowsCount;i++)
//		             {
//		            	 //XSSFRow row=sheet.getRow(i);
//		            	 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
//		            	 {
//		            		 String Sheetdata=sheet.getRow(i).getCell(j).getStringCellValue();
//		            		 System.out.print(Sheetdata+ " ");
		              
//		            	 }
//		            	 System.out.println();
//		             }
		            
		             
//		             for(int i=1;i<totalRowsCount;i++)
//		             {
//		            	
//		            	
//		            		 String Sheetdata=sheet.getRow(i).getCell(1).getStringCellValue();
//		            		 System.out.print(Sheetdata+ " ");
//		            	 
//		            	
//		            		
//		            	 System.out.println();
//		             }
		            /* for (int i = 1; i <= totalRowsCount; i++) { // Changed loop condition to <=
		                 XSSFRow row = sheet.getRow(i);
		                 if (row != null) {
		                     XSSFCell cell = row.getCell(1); // Assuming you want the value from the second column (index 1)
		                   
		                     if (cell != null) {
		                         if (cell.getCellType() == CellType.NUMERIC) {
		                             // If cell type is numeric, get the numeric value
		                        	 int sheetData = (int) cell.getNumericCellValue();
		                        	 System.out.print(sheetData + " ");
		                         } 
		                         else {
		                             // If cell type is not numeric, get string value
		                             String sheetData = cell.getStringCellValue();
		                             System.out.print(sheetData + " ");
		                         }
		                         
		                     }
		                 }
		                 System.out.println(); 
		             } */
		             
		            
//		            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
//
//		            // Specify the row and column
//		            int rowIndex = 0; // First row
//		            int columnIndex = 0; // First column
//
//		            XSSFRow row = sheet.getRow(rowIndex);
//		            XSSFCell cell = row.getCell(columnIndex);
//
//		            // Assuming the cell contains string data
//		            String cellData = cell.getStringCellValue();
//		            System.out.println("Data in row " + (rowIndex + 1) + ", column " + (columnIndex + 1) + ": " + cellData);

		        
//		        
//		            }
//	                
}
}



		
		




