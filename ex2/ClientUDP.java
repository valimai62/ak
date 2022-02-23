package ex2;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;


import java.io.IOException;
import java.net.DatagramSocket;

class ClientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] data = new byte[1000];
        InetAddress inet = InetAddress.getLocalHost();


        while(true){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        data=str.getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length,inet,3001);
            ds.send(dp);
            if(str.equals("bye")){
                break;
            }
        }
    }
}