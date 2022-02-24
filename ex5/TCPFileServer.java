package ex5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        System.out.println("Socket established");
        System.out.println("Connected with client IP" + s.getInetAddress().getHostAddress());
        FileInputStream fr = new FileInputStream("G:\\SKCET\\Semester 5\\DCN\\sample.txt");
        byte[] b = new byte[2002];
        fr.read(b, 0, b.length);
        OutputStream os = s.getOutputStream();
        os.write(b, 0, b.length);
        System.out.println("File Transferred");

    }
}
