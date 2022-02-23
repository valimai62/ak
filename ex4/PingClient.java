package ex4;

import java.net.*;
import java.io.*;
public class PingClient {
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",2000);
        String str=null;
        int c=0;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        while (c<4){
            long t1=System.currentTimeMillis();
            out.writeObject("welcome to network programs");
            str=(String) in.readObject();

            System.out.println(str);
            long t2 = System.currentTimeMillis();
            System.out.println("TTL = "+(t2-t1)+"ms");
            c++;
        }

    }
}
