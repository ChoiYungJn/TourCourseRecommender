import java.util.List;

public class ThemeCriteria implements ISelectionCriteria {
    private List<String> themes;

    public ThemeCriteria(List<String> themes) {
        this.themes = themes;
    }

    @Override
    public boolean matches(Attraction attraction) {
        return themes.contains(attraction.getTheme_name());
    }
}