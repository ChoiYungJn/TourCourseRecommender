import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttractionDAO implements AutoCloseable {
    private static final String URL = "jdbc:h2:tcp://localhost/~/tourcourse"; // H2 파일 데이터베이스 URL
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String DRIVER = "org.h2.Driver"; // H2 드라이버

    private Connection connection;

    public AttractionDAO() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("The Connection Successful");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private void initializeDatabase() throws SQLException {
//        String createTableSQL = "CREATE TABLE IF NOT EXISTS 관광지 (" +
//                "`관광지ID` INT, " +
//                "`코스ID` INT, " +
//                "`지역ID` VARCHAR(255), " +
//                "`관광지명` VARCHAR(255), " +
//                "`경도` DOUBLE, " +
//                "`위도` DOUBLE, " +
//                "`코스순서` INT, " +
//                "`이동시간` INT, " +
//                "`실내구분` VARCHAR(255), " +
//                "`테마분류` VARCHAR(255)" +
//                ");";
//
//
//        try (Statement stmt = connection.createStatement()) {
//            stmt.execute(createTableSQL);
//            insertInitialData(stmt);
//        }
//    }

    private void insertInitialData(Statement stmt) {
        String excelFilePath = "/Users/baejongchan/Downloads/SqlGen.xlsx"; // 엑셀 파일 경로
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String insertQuery = row.getCell(11).getStringCellValue();
                if (insertQuery != null && !insertQuery.trim().isEmpty()) {
                    stmt.execute(insertQuery);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Attraction> getData() {
        List<Attraction> dataList = new ArrayList<>();
        String query = "SELECT 테마분류, 코스ID, 관광지ID, 관광지명, 경도, 위도, 코스순서, 이동시간, 실내구분 FROM 관광지";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String rawName = rs.getString("관광지명");
                int startIdx = rawName.indexOf("(");
                int endIdx = rawName.indexOf(")");
                String location = "";
                String name = rawName;

                if (startIdx != -1 && endIdx != -1) {
                    location = rawName.substring(startIdx + 1, endIdx);
                    name = rawName.substring(endIdx + 1).trim();
                }

                dataList.add(new Attraction(
                        rs.getString("테마분류"),
                        rs.getInt("코스ID"),
                        rs.getInt("관광지ID"),
                        rawName,
                        rs.getDouble("경도"),
                        rs.getDouble("위도"),
                        rs.getInt("코스순서"),
                        rs.getInt("이동시간"),
                        rs.getString("실내구분"),
                        rs.getString("테마분류"),
                        location,
                        name
                ));
            }
            System.out.println("The data has been fetched");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataList.isEmpty() ? null : dataList;
    }


    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
