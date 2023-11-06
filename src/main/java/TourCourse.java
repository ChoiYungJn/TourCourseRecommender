import java.util.List;

public class TourCourse {
    private List<Attraction> attractions;

    public TourCourse(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

}