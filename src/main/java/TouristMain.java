import java.io.IOException;
import java.util.List;


public class TouristMain
{
    public static final int UI_WIDTH = 1280;
    public static final int UI_HEIGHT = 720;

    public static void main(String[] args) throws IOException{
        // List<Attraction> dataList = ExcelParser.parseExcelFile("/Users/baejongchan/Downloads/SqlGen.xlsx");
        List<Attraction> dataList = AttractionDAO.getData();

        new UI();

    }
}
