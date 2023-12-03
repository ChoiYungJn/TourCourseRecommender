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

    public void showAllAttractions() {
        System.out.println("켜졌어");
        for (Attraction attraction : allAttractions) {
            System.out.println(attraction);
        }
    }

    public List<Attraction> getAllAttractions() {
        return allAttractions;
    }

    public String getAttractionInfo() {
        StringBuilder sb = new StringBuilder();
        for (Attraction attraction : allAttractions) {
            sb.append(attraction.toString());
            sb.append("<br>");
        }
        sb.append("<br> 자세한 정보는 하단을 참고해주세요!!");
        return sb.toString();
    }

    public String getAttractionHtml() {
        StringBuilder sb = new StringBuilder();
        for (Attraction attraction : allAttractions) {
            sb.append(attraction.toHTMLString());
            sb.append("<br>");
        }
        return sb.toString();
    }

    public void reset() {
        builder.clear();
        this.allAttractions.clear();
    }
}
