public class LocationTypeCriteria implements ISelectionCriteria {
    private String silnaesilwae; // "실내", "실외", "상관 없음"

    public LocationTypeCriteria() {
        this.silnaesilwae = "상관 없음";
    }

    public void setSilnaesilwae(String silnaesilwae) {
        this.silnaesilwae = silnaesilwae;
    }

    @Override
    public boolean matches(Attraction attraction) {
        return silnaesilwae.equals("상관 없음") || attraction.getLocation_type().equals(silnaesilwae);
    }
}