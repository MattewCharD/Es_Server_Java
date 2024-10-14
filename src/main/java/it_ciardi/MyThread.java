package it_ciardi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread {

    private Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {

        Boolean b = false;

        System.out.println("qualcuno si è collegato");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta;
            do {

                stringaRicevuta = in.readLine();

                if (stringaRicevuta.equals("!")) {
                    break;
                }

                System.out.println("La sringa ricevuta: " + stringaRicevuta);

                String stringaMaiuscola = stringaRicevuta.toUpperCase();
                out.writeBytes(stringaMaiuscola + "\n");

            } while (!stringaRicevuta.equals("!"));

            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
