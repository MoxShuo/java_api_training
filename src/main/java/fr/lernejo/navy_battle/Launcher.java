package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {

    public static void main(String args[])throws IOException, InterruptedException
    {
        if(args.length < 1 || args.length >2){
            throw new IllegalArgumentException("il doit y avoir 1 ou 2 arguments pour fonctionner");
        }
        else{
            int port = Integer.parseInt(args[0]);
            if(args.length == 1)
            {
                try{
                    ServerHTTP serveur = new ServerHTTP(port);
                    serveur.initServer();
                }catch (Exception e){}

            }
            if(args.length == 2)
            {
                ServeurClient serverClient = new ServeurClient(port);
                serverClient.send(args[1]);
            }
        }



    }
}
