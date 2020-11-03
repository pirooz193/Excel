package com.maktab.excel;

import java.io.File;
import java.io.FileOutputStream;

import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.maktab.domains.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
    public void excel(Person[] person, OutputStream out) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet spreadsheet = workbook.createSheet("Person Info ");

        XSSFRow row;

        Map<String, Object[]> personInfo = new TreeMap<>();

        for (int i = 0; i < person.length; i++) {
            personInfo.put("" + (i + 1) + "", new Object[]{
                    person[i].getId(), person[i].getName(), person[i].getLastName(), person[i].getPhoneNumber()});
        }


        Set<String> keyid = personInfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = personInfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        workbook.write(out);
        out.close();
        System.out.println("Your Excel File written successfully");
    }


}