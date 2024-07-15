import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import utilities.Sample;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Create a context that listens for requests on "/api"
        server.createContext("/api", new MyHandler());
        server.createContext("/sample", new Sample());

        // Start the server
        server.start();

        System.out.println("Server started on port 8000");
    }

    // Define a handler to process requests
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Set response headers
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            // Set response status code and body
            String response = "{\"message\":\"Hello, World!\"}";
            exchange.sendResponseHeaders(200, response.length());

            // Write response body
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
