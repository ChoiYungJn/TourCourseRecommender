import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TouristMain {
    public static final int UI_WIDTH = 1280;
    public static final int UI_HEIGHT = 720;

    public static void main(String[] args) {
        try (AttractionDAO attractionDAO = new AttractionDAO()) {
            List<Attraction> dataList = attractionDAO.getData();

            if (dataList == null || dataList.isEmpty()) {
                throw new RuntimeException("No data fetched from the database.");
            }

            TourCourseRecommender tourCourseRecommender = TourCourseRecommender.getInstance();
            tourCourseRecommender.setAllAttractions(dataList);

            new UI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

