public class TourCourseRecommender{
    private static TourCourseRecommender instance;

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

    public TourCourse recommendCourse(UserPreferences preferences) {

        TourCourseBuilder builder = new TourCourseBuilder();

        return builder.build();
    }
}

