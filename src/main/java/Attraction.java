public class Attraction {

    private String theme_id;
    private int course_id;
    private int attraction_id;
    private String attraction_name;
    private double longitude;
    private double latitude;
    private int course_order;
    private int travel_time;
    private String location_type;
    private String theme_name;

    private String location;

    private String name;

    Attraction(
            String themeId,
            int courseId,
            int attrId,
            String attrName,
            double longitude,
            double latitude,
            int courseOrder,
            int travelTime,
            String locType,
            String themeName,
            String location,
            String name
    ){
        this.theme_id = themeId;
        this.course_id = courseId;
        this.attraction_id = attrId;
        this.attraction_name = attrName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.course_order = courseOrder;
        this.travel_time = travelTime;
        this.location_type = locType;
        this.theme_name = themeName;
        this.location = location;
        this.name = name;
    }

    public String getTheme_id() {
        return theme_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getAttraction_id() {
        return attraction_id;
    }

    public String getAttraction_name() {
        return attraction_name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getCourse_order() {
        return course_order;
    }

    public int getTravel_time() {
        return travel_time;
    }

    public String getLocation_type() {
        return location_type;
    }

    public String getTheme_name() {
        return theme_name;
    }

     public String getLocation() {
         return location;
     }

     public String getName() {
         return name;
     }

    public boolean isIndoor() {
        return location_type.equals("실내");
    }

    public boolean isOutdoor(){
        return location_type.equals("실외");
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "theme_id='" + theme_id + '\'' +
                ", course_id=" + course_id +
                ", attraction_id=" + attraction_id +
                ", attraction_name='" + attraction_name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", course_order=" + course_order +
                ", travel_time=" + travel_time +
                ", location_type='" + location_type + '\'' +
                ", theme_name='" + theme_name + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
