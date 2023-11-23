import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionDAO implements AutoCloseable {
    static Connection connection = getConnection();

    public static Connection getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/tourcourse?useUnicode=true&characterEncoding=euckr";
            String userID = "newuser";
            String pwd = "1q2w3e4r";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userID, pwd);
            System.out.println("The Connection Successful");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TourCourses를 가져옵니다.
    public static List<Attraction> getData(){
        List<Attraction> dataList = new ArrayList<>();
        
        try {       
            // location_id 는 생략
            PreparedStatement stmt = connection.prepareStatement("SELECT theme_id, course_id, attraction_id, attraction_name, longitude, latitude, course_order, travel_time, location_type, theme_name FROM tourcourse");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                dataList.add(new Attraction(
                    rs.getString("theme_id"),
                    rs.getInt("course_id"),
                    rs.getInt("attraction_id"),
                    rs.getString("attraction_name"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"),
                    rs.getInt("course_order"),
                    rs.getInt("travel_time"),
                    rs.getString("location_type"),
                    rs.getString("theme_name")
                ));
            }
            System.out.println("The data has been fetched");
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(!dataList.isEmpty()){
            return dataList;
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}