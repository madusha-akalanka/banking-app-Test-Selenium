package lk.unibanking.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtil {


    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;


    public static int getRowCount(String excelfile, String excelsheet) throws IOException {
        fi = new FileInputStream(excelfile);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(excelsheet);
        int lastRowNum = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return lastRowNum;

    }

    public static int getCellCount(String excelfile, String excelsheet, int rownum) throws IOException {
        fi = new FileInputStream(excelfile);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(excelsheet);
        row = sheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String excelfile,String excelSheet,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(excelfile);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(excelSheet);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);
        String data;

        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
           data="";
        }

        workbook.close();
        fi.close();
        return data;

    }

    public static void setcellData(String excelfile,String excelsheet,int rownum,int colnum,String data) throws IOException {
        fi=new FileInputStream(excelfile);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(excelsheet);
        row=sheet.getRow(rownum);
        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(excelfile);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();


    }

}
