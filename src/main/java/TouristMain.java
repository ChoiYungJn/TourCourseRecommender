import com.sun.net.httpserver.HttpServer;
import common.HTTPServer;
import common.TourCourseData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import static common.ExcelParser.parseExcelFile;


public class TouristMain
{

    public static void main(String[] args) throws IOException{
        List<TourCourseData> dataList = parseExcelFile("/Users/baejongchan/Downloads/SqlGen.xlsx");
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new HTTPServer.TouristInfoHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        dataList.forEach(data -> {
            System.out.println(data.getAttraction_name());
        });

    }
}
