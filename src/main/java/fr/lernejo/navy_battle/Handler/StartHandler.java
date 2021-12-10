package fr.lernejo.navy_battle.Handler;
import fr.lernejo.navy_battle.Util.UtilJson;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import org.json.JSONObject;


public class StartHandler implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream bodyRequest = exchange.getRequestBody();
        String body = "";
        int code = 400;
        if (!"POST".equals(exchange.getRequestMethod())) {
            code = 404;
        } else if (checkbody(bodyRequest))
        {
            body = createbody(exchange);
            code = 202;
        }
        exchange.sendResponseHeaders(code,body.length());
        try(OutputStream os = exchange.getResponseBody())
        {
            os.write(body.getBytes());
        }
    }

    private boolean checkbody(InputStream bodyRequest)
    {
        JSONObject json = new UtilJson().inputStringTOJSON(bodyRequest);
        if (json != null)
        {
            try
            {
                String id = json.getString("id");
                String url = json.getString("url");
                String message = json.getString("message");
                if( id != null && url != null && message != null)
                {
                    return true;
                }
            }catch(Exception e){}
        }
        return false;
    }
    private String createbody(HttpExchange exchange)
    {
        int port = exchange.getHttpContext().getServer().getAddress().getPort();
        JSONObject objet = new JSONObject();
        objet.put("id", "xxx");
        objet.put("url", "http://localhost:"+port);
        objet.put("message", "UwU");
        return objet.toString();
    }
}

