package ex2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds =new DatagramSocket(3001);

        byte[] data =new byte[1000];

        while(true){
            DatagramPacket dp = new DatagramPacket(data,data.length);
            ds.receive(dp);
            StringBuilder str = conv(data);

            if(str.toString().equals("bye")){
                System.out.println("bye");
                break;
            }
            System.out.println(str);
            data=new byte[1000];
        }
    }

    static StringBuilder conv(byte[] a){

        if(a==null)return null;
        StringBuilder sb = new StringBuilder("");
        for(byte aa:a){

            if ((char) aa != '\0') {
                sb.append((char) aa);
            }
        }

        return sb;
    }
}
