import java.util.ArrayList;
import java.util.List;

public class ThemeCriteria implements ISelectionCriteria {
    private List<String> themes;

    public ThemeCriteria() {
        this.themes = new ArrayList<>();
    }

    public void pushTheme(String theme) {
        themes.add(theme);
    }

    @Override
    public boolean matches(Attraction attraction) {
        return themes.contains(attraction.getTheme_id());
    }
}