package ex3;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
public class ClientSL {
    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("127.0.0.1",2000);
        System.out.println("Connected with socket "+socket.getInetAddress().getHostAddress());
        //streams
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String message= "Computer";
        int errno=3;

        out.writeObject(Integer.toString(message.length()));
        out.writeObject(Integer.toString(errno));
        System.out.println("message sent to server");

        for(int i=0;i<message.length();i++){
            out.writeObject(message.substring(i,i+1));
            System.out.println(message.substring(i,i+1));
        }
        System.out.println("Retransmitting error happend charachter");
        out.writeObject(message.substring(errno,errno+1));
        System.out.println(message.substring(errno,errno+1));
        socket.close();
        out.close();

    }
}
