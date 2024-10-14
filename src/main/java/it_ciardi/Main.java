package it_ciardi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        
        ServerSocket ss2 = new ServerSocket(5672);
        do {
            Socket s = ss2.accept();
            MyThread t = new MyThread(s);
            t.start();
        } while (true);
        
        // Boolean b = false;
        // System.out.println("Hello world!");
        // ServerSocket ss = new ServerSocket(5672);
        // Socket s = ss.accept();
        // System.out.println("qualcuno si è collegato");

        // BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // do {
        //     String stringaRicevuta = in.readLine();
        //     if (stringaRicevuta.equals("!") ) {
        //         b=true;
        //         s.close();
        //         ss.close(); non devo chiuderlo
        //     }

        //     System.out.println("La sringa ricevuta: " + stringaRicevuta);

        //     String stringaMaiuscola = stringaRicevuta.toUpperCase();
        //     out.writeBytes(stringaMaiuscola + "\n");

        
        // } while (b==false);
        
    }

}