public class TourCourseRecommender{
    private static TourCourseRecommender instance;

    private TourCourseRecommender() {
        // 초기화 로직...
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
        // 사용자의 선호도에 따라 코스를 추천하는 로직
        TourCourseBuilder builder = new TourCourseBuilder();
        // 관광지 추가 로직...
        return builder.build();
    }
}

