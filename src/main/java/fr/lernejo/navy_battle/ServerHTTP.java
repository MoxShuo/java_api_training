package fr.lernejo.navy_battle;


import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.Handler.CallHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        httpServ.start();
    }


}
