package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    
    
 // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheet name as Arguments to this method
    @SuppressWarnings("deprecation")
    public static Object[][] getExcelData(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            // Access the required test data sheet
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int totalNoOfRows = ExcelWSheet.getLastRowNum();
            int totalNoOfCols = ExcelWSheet.getRow(1).getPhysicalNumberOfCells();
            tabArray = new String[totalNoOfRows][totalNoOfCols];
            for (int i = 1; i <= totalNoOfRows; i++) {
                for (int j = 0; j < totalNoOfCols; j++) {
                    Cell = ExcelWSheet.getRow(i).getCell(j);
                    int cel_Type = -1;
                    if (Cell != null)
                        cel_Type = Cell.getCellType();
                    switch (cel_Type) {
                    case XSSFCell.CELL_TYPE_NUMERIC: // 0
                        if (DateUtil.isCellDateFormatted(Cell)) {
                            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                            tabArray[i - 1][j] = df.format(Cell.getDateCellValue());
                        } else {
                            tabArray[i - 1][j] = String.format("%d", (long) Cell.getNumericCellValue());
                        }
                        break;
                    case XSSFCell.CELL_TYPE_STRING: // 1
                        tabArray[i - 1][j] = Cell.getStringCellValue();
                        break;
                    default:
                        tabArray[i - 1][j] = "";
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            // test.log(Status.FAIL, "Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            // test.log(Status.FAIL, "Could not read the Excel sheet");
            e.printStackTrace();
        }
        return tabArray;
    }
}
