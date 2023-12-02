import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TourCourseBuilder {
    private List<Attraction> attractions = new ArrayList<>();
    private List<ISelectionCriteria> criteriaList;

    public TourCourseBuilder() {
        criteriaList = new ArrayList<ISelectionCriteria>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void addCriteria(ISelectionCriteria criteria) {
        criteriaList.add(criteria);
    }

    public TourCourse build() {
        List<Attraction> filteredAttractions = attractions.stream()
                .filter(attraction -> criteriaList.stream()
                        .allMatch(criteria -> criteria.matches(attraction)))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("빌드 사이즈는 " + filteredAttractions.size());

        return new TourCourse(filteredAttractions);
    }

}
