 public class RegionCriteria implements ISelectionCriteria {
     private String location;

     public RegionCriteria() {

     }

     public RegionCriteria(String location) {
         this.location = location;
     }

     @Override
     public boolean matches(Attraction attraction) {
         return location.contains(attraction.getLocation());
     }
 }
