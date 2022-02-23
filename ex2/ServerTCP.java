package ex2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2000);
        Socket socket = ss.accept();
        System.out.println("Port activated");
        Scanner sc = new Scanner(socket.getInputStream());
        int num =sc.nextInt()/2;
        PrintStream pr =  new PrintStream(socket.getOutputStream());
        pr.println(num);

    }
}
