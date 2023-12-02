import java.util.ArrayList;
import java.util.List;

public class TourCourseRecommender {
    private static volatile TourCourseRecommender instance;
    private List<Attraction> allAttractions;

    TourCourseBuilder builder;

    private TourCourseRecommender() {
        builder = new TourCourseBuilder();
        allAttractions = new ArrayList<>();
    }

    public void setAllAttractions(List<Attraction> allAttractions) {
        for(Attraction attraction : allAttractions){
            builder.addAttraction(attraction);
        }
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

    public void addCriteria(ISelectionCriteria criteria) {
        builder.addCriteria(criteria);
    }


    public void recommendCourse() {
        for (Attraction attraction : allAttractions) {
            builder.addAttraction(attraction);
        }

        allAttractions = builder.build().getAttractions();
    }

    void showAllAttractions() {
        System.out.println("켜졌어");
        for (Attraction attraction : allAttractions) {
            System.out.println(attraction);
        }
    }
}
