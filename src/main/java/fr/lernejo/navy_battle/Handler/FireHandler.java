package fr.lernejo.navy_battle.Handler;
import fr.lernejo.navy_battle.Util.UtilJson;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class FireHandler implements HttpHandler{

    private int code = 400;
    private String body = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException
    {

        if(!exchange.getRequestMethod().equals("GET")){this.code = 404;}
        else
        {
            this.code = 202;
            this.body = createbody();
        }
        exchange.sendResponseHeaders(code, body.length());
        try(OutputStream outputStream = exchange.getResponseBody())
        {
            outputStream.write(body.getBytes());
        }
        System.out.println(body + code);
    }

    public String createbody()
    {
        JSONObject object = new JSONObject();
        object.put("consequence", "sunk");
        object.put("shipLeft", "true");
        return object.toString();
    }
}


