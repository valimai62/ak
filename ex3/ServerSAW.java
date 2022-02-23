package ex3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSAW {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("SERVER");
        String frame = null;
        String ack = null;
//1. Creating a server socket
        ServerSocket ss = new ServerSocket(2000);
//2. Wait for connection
        System.out.println("Waiting for connection");
        Socket con = ss.accept();
        System.out.println("Connected with client IP " + con.getInetAddress().getHostAddress()); //3. Set input and output streams
        ObjectInputStream in = new ObjectInputStream(con.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream());


        String framelength = (String) in.readObject();
//5. Frame receiving and acknowledgement process
        int ackno = 0;
        for (int i = 0; i < Integer.parseInt(framelength); i++) {
            frame = (String) in.readObject();
            System.out.println("\nFrame received from client: " + frame); //swap acknowledgement no
            if (ackno == 0) {
                ackno = 1;
            } else {
                ackno = 0;
            }
//compose acknowledgement message
            ack = "ack" + ackno;
//send acknowledgement to client
            out.writeObject(ack);
            System.out.println("Acknowledgement sent to client: " + ack);
        }
        in.close();
        out.close();
        con.close();

        //streams
    }
}
