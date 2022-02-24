package ex5;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPFileClient {
    public static void main(String[] args) throws Exception {
        byte[] b = new byte[2002];
        Socket s = new Socket("localhost", 3000);
        System.out.println("Connected with server IP" + s.getInetAddress().getLocalHost());
        InputStream is = s.getInputStream();
        FileOutputStream fr = new FileOutputStream("G:\\SKCET\\Semester 5\\DCN\\sample1.txt");
        is.read(b, 0, b.length);
        fr.write(b, 0, b.length);
        System.out.println("File Received");
    }
}
