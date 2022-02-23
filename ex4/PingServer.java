package ex4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket socket = ss.accept();
        System.out.println("server");

        int c=0;
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        while (c<4){
            String str=(String) in.readObject();
            out.writeObject("Reply from "+ InetAddress.getLocalHost()+" "+str+" len is "+str.length());
            c++;
        }
        socket.close();
        ss.close();

    }
}
