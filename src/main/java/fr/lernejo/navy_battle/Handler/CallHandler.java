package fr.lernejo.navy_battle.Handler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class CallHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        String body = "OK";
        exchange.sendResponseHeaders(200,body.length());
        try (OutputStream os = exchange.getResponseBody())
        {
            os.write(body.getBytes());
        }
    }
}
