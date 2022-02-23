package ex3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ServerSL {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(2000);
        Socket socket = ss.accept();
        //streams
        ObjectInputStream in =new ObjectInputStream(socket.getInputStream());

        int msg_ln = Integer.parseInt((String) in.readObject());
        int errno = Integer.parseInt((String) in.readObject());
        System.out.println("Message recieved from client");

        for(int i=0;i<msg_ln;i++){
            System.out.println((String) in.readObject());
        }

        System.out.println("Receiving retransmitting message");
        System.out.println((String)in.readObject());
        //closing connections
        socket.close();
        ss.close();
        in.close();

    }
}
