package ex6;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadToClient {
    public static void main(String[] args) throws Exception{
        String fileName = "sample2.jpg";
        String website = "https://images.unsplash.com/photo-1604580825024-e7bfa9ca7cbf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60";
        System.out.println("Downloading File From: " + website);
        URL url = new URL(website);
        InputStream inputStream = url.openStream();
        OutputStream outputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[2048];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            System.out.println("Buffer Read of length: " + length);
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
