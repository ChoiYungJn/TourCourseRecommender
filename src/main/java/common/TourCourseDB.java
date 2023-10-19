package common;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TourCourseDB implements AutoCloseable {
    static Connection connection = getConnection();

    private ArrayList<TourCourseData> arr = new ArrayList<>();

    public TourCourseDB(){
        setData();
    }

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
    public void setData(){
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT theme_id, course_id, attraction_id, attraction_name, longitude, latitude, course_order, travel_time, location_type, theme_name FROM tourcourse");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                arr.add(new TourCourseData(
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
//            System.out.println(arr.get(0).getTheme_id());
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<TourCourseData> getData(){
        if(!arr.isEmpty()){
            return arr;
        }
        return null;
    }


    @Override
    public void close() throws Exception {
        connection.close();
    }
}
