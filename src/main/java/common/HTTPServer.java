package common;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTTPServer {

    public static class TouristInfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String filePath = "src/main/static/tourist_courses.html";
            byte[] response = Files.readAllBytes(Paths.get(filePath));
            t.sendResponseHeaders(200, response.length);
            OutputStream os = t.getResponseBody();
            os.write(response);
            os.close();
        }
    }
}
