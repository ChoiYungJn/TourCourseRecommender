import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TourCourseBuilder {
    private List<Attraction> attractions = new ArrayList<>();
    private List<ISelectionCriteria> criteriaList;

    public TourCourseBuilder(List<ISelectionCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public TourCourse build() {
        List<Attraction> filteredAttractions = attractions.stream()
                .filter(attraction -> criteriaList.stream()
                        .allMatch(criteria -> criteria.matches(attraction)))
                .collect(Collectors.toList());

        return new TourCourse(filteredAttractions);
    }
}
