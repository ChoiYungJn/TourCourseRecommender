package common;

import common.TourCourseData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {

    public static List<TourCourseData> parseExcelFile(String path) {
        List<TourCourseData> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(path));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // 첫 번째 시트 가져오기
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // 첫 번째 행은 헤더이므로 1부터 시작
                Row row = sheet.getRow(i);

                String themeId = row.getCell(0).getStringCellValue();
                int courseId = (int) row.getCell(1).getNumericCellValue();
                int attrId = (int) row.getCell(2).getNumericCellValue();
                String attrName = row.getCell(4).getStringCellValue();
                double longitude = row.getCell(5).getNumericCellValue();
                double latitude = row.getCell(6).getNumericCellValue();
                int courseOrder = (int) row.getCell(7).getNumericCellValue();
                int travelTime = (int) row.getCell(8).getNumericCellValue();
                String locType = row.getCell(9).getStringCellValue();
                String themeName = row.getCell(10).getStringCellValue();

                dataList.add(new TourCourseData(themeId, courseId, attrId, attrName, longitude, latitude, courseOrder, travelTime, locType, themeName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}