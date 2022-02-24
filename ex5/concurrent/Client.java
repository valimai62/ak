package ex5.concurrent;

import java.util.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("Localhost");
            Socket s = new Socket(ip, 5057);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                System.out.println(dis.readUTF());
                String tosend = sc.nextLine();
                dos.writeUTF(tosend);
                if (tosend.equals("Exit")) {
                    System.out.println("Closing the Connection");
                    s.close();
                    System.out.println("Connection Closed");
                    break;
                }
                String received = dis.readUTF();
                System.out.println(received);
            }



            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}