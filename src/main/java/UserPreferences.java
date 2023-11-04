import java.util.Set;

public class UserPreferences {
    private boolean prefersIndoor;
    private boolean prefersOutdoor;
    private Set<String> preferredThemes;
    private String preferredLocation;

    public UserPreferences(boolean prefersIndoor, boolean prefersOutdoor, Set<String> preferredThemes, String preferredLocation) {
        this.prefersIndoor = prefersIndoor;
        this.prefersOutdoor = prefersOutdoor;
        this.preferredThemes = preferredThemes;
        this.preferredLocation = preferredLocation;
    }

    public boolean isPrefersIndoor() {
        return prefersIndoor;
    }

    public void setPrefersIndoor(boolean prefersIndoor) {
        this.prefersIndoor = prefersIndoor;
    }

    public boolean isPrefersOutdoor() {
        return prefersOutdoor;
    }

    public void setPrefersOutdoor(boolean prefersOutdoor) {
        this.prefersOutdoor = prefersOutdoor;
    }

    public Set<String> getPreferredThemes() {
        return preferredThemes;
    }

    public void setPreferredThemes(Set<String> preferredThemes) {
        this.preferredThemes = preferredThemes;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    // 사용자 선호도를 기반으로 필터링 로직을 추가할 수 있음
    public boolean matchesPreferences(Attraction attraction) {
        // 실내 및 실외 선호도 체크
        if ((prefersIndoor && attraction.isIndoor()) || (prefersOutdoor && attraction.isOutdoor())) {
            // 테마 선호도 및 위치 선호도 체크
            if (preferredThemes.contains(attraction.getTheme_name()) && preferredLocation.equalsIgnoreCase(attraction.getLocation())) {
                return true;
            }
        }
        return false;
    }
}

