package com.maktab.excel;

import com.maktab.domains.Person;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelReader {
    //FIXME
    public List<Person> excelReader(InputStream inputStream) throws IOException {
        List<Person> personList = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Iterator<Sheet> sheets = workbook.sheetIterator();
            while (sheets.hasNext()) {
                Sheet sh = sheets.next();
                Iterator<Row> iterator = sh.iterator();
                while (iterator.hasNext()) {
                    Person person = new Person();
                    Row row = iterator.next();
                    String id = row.getCell(0).getStringCellValue();
                    String name = row.getCell(1).getStringCellValue();
                    String lastName = row.getCell(2).getStringCellValue();
                    String phoneNumber = row.getCell(3).getStringCellValue();
                    person.setId(id);
                    person.setName(name);
                    person.setLastName(lastName);
                    person.setPhoneNumber(phoneNumber);
                    personList.add(person);
                }

            }
            workbook.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        return personList;

    }

}