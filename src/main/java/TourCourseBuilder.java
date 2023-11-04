import java.util.ArrayList;
import java.util.List;

public class TourCourseBuilder {
    private List<Attraction> attractions = new ArrayList<>();

    public TourCourseBuilder addAttraction(Attraction attraction) {
        attractions.add(attraction);
        return this;
    }

    public TourCourse build() {
        // 코스 구성 로직...
        return new TourCourse(attractions);
    }
}

