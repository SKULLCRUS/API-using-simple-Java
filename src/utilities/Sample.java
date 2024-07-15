package utilities;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Sample implements HttpHandler {

//    public static void example(){
//
//    System.out.println("Running utilities.Sample file");
//    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Set response headers
        exchange.getResponseHeaders().set("Content-Type", "application/json");

        // Set response status code and body
        String response = "{\"message\":\"this is the sample api endpoint!\"}";
        exchange.sendResponseHeaders(200, response.length());

        // Write response body
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
