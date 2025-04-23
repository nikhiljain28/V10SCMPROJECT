package Utilites;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {

    public String getFileLocation;
    public FileInputStream fis;
    public Workbook workbook;
    public Sheet sheet;

    public int rowCount(String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    public int columnCount(String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                return row.getLastCellNum();
            }
    }
        return 0;
    }

    public Object cell_Value(String sheetName) {
        workbook = new XSSFWorkbook();
        sheet = workbook.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);

        }
    }
    public ArrayList<String> readFile(String filename, String sheetName) throws IOException {
        fis = new FileInputStream(filename);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int i = sheet.getLastRowNum();
        ArrayList<String> list = new ArrayList<>();
        for(int k=1;k<i;k++){
            Row row = sheet.getRow(k);
            int m = row.getLastCellNum();
            for(int j=0;j<m;j++){
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String cellValue = formatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }
        workbook.close();
        fis.close();
        return list;
    }
}
