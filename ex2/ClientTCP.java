package ex2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.*;
public class ClientTCP {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("127.0.0.1",2000);
        Scanner scs = new Scanner(s.getInputStream());
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        PrintStream pr = new PrintStream(s.getOutputStream());
        pr.println(num);
        System.out.println("From server : "+scs.nextInt());

    }
}
