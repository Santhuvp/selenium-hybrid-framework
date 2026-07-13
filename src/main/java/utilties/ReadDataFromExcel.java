package utilties;

import constants.Framework_Constants;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {

    public static Object [][] getDatafromEcel(String shet) throws IOException {
        FileInputStream fis = new FileInputStream(Framework_Constants.EXCEL_PATH);
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet1 = book.getSheet(shet);
       int row_count=sheet1.getPhysicalNumberOfRows();
       int column_count = sheet1.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[row_count - 1][column_count];

        for(int i = 0 ;i<row_count-1;i++)
        {
            for(int j =0;j<column_count;j++)
            {
                data[i][j] = sheet1.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
