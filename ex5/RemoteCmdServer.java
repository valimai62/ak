package ex5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteCmdServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        ProcessBuilder pb = new ProcessBuilder();
        String[] strArray = new String[5];

        for (int i = 0; i < 3; i++) {
            strArray[i] = (String) in.readObject();
        }
        pb.command(strArray[0], strArray[1], strArray[2]);
        pb.directory(new File("C:\\Users"));

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));


        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        System.out.println("\nExited with error code : " + exitCode);

    }
}
