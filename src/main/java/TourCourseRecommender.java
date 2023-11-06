import java.util.List;

public class TourCourseRecommender {
    private static volatile TourCourseRecommender instance;
    private List<Attraction> allAttractions;

    private TourCourseRecommender() {

    }

    public static TourCourseRecommender getInstance() {
        if (instance == null) {
            synchronized (TourCourseRecommender.class) {
                if (instance == null) {
                    instance = new TourCourseRecommender();
                }
            }
        }
        return instance;
    }


    public TourCourse recommendCourse(List<ISelectionCriteria> criteriaList) {

        TourCourseBuilder builder = new TourCourseBuilder(criteriaList);
        for (Attraction attraction : allAttractions) {
            builder.addAttraction(attraction);
        }

        return builder.build();
    }
}
