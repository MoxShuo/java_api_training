package fr.lernejo.navy_battle;


import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.Handler.CallHandler;
import fr.lernejo.navy_battle.Handler.StartHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.http.HttpRequest;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import  java.net.URI;
import java.net.http.HttpRequest.BodyPublishers;

public class ServerHTTP
{
    private final int port;

    public ServerHTTP(int p_port)
    {
        this.port = p_port;
    }


    public void initServer() throws IOException
    {
        System.out.println("Init Server");
        InetSocketAddress addressbind = new InetSocketAddress(this.port);
        HttpServer httpServ = HttpServer.create(addressbind,0);
        httpServ.setExecutor(Executors.newFixedThreadPool(1));
        httpServ.createContext("/ping",new CallHandler());
        httpServ.createContext("/api/game/start",new StartHandler());
        httpServ.start();
    }

}
