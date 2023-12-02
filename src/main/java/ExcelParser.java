 import org.apache.poi.ss.usermodel.Row;
 import org.apache.poi.ss.usermodel.Sheet;
 import org.apache.poi.ss.usermodel.Workbook;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 import java.io.File;
 import java.io.FileInputStream;
 import java.util.ArrayList;
 import java.util.List;

 public class ExcelParser {

     public static List<Attraction> parseExcelFile(String path) {
         List<Attraction> dataList = new ArrayList<>();

         try (FileInputStream fis = new FileInputStream(new File(path));
              Workbook workbook = new XSSFWorkbook(fis)) {

             Sheet sheet = workbook.getSheetAt(0);
             for (int i = 1; i <= sheet.getLastRowNum(); i++) {
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

                 String[] parts = attrName.split("\\)", 2);
                 String location = parts[0].replace("(", "");
                 String name = parts.length > 1 ? parts[1].trim() : "";

                 dataList.add(new Attraction(themeId, courseId, attrId, attrName, longitude, latitude, courseOrder, travelTime, locType, themeName, location, name));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }

         return dataList;
     }
 }