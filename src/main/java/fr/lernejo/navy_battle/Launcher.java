package fr.lernejo.navy_battle;

public class Launcher {

    public static void main(String args[])
    {
        int port = Integer.parseInt(args[0]);
        if(args.length > 0)
        {
            try{
                ServerHTTP serveur = new ServerHTTP(port);
                serveur.initServer();
            }catch (Exception e){}
        }


    }
}
