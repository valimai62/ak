package ex3;
import java.io.*;
import java.net.*;
public class ClientSAW {
    public static void main(String[] args) throws IOException,ClassNotFoundException{

        System.out.println("Client");
        String frame = null;
        String ack = null;
//1. Create a socket
        Socket con = new Socket("localhost",2000);
        System.out.println("Connected with server " + con.getInetAddress().getHostAddress()); //2. Set input & output streams

        ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream()); ObjectInputStream in = new ObjectInputStream(con.getInputStream());
        frame = "hello";
//3. Send the frame and receive ack
        out.writeObject(Integer.toString(frame.length()));
        String subFrame = null;
        int frameno = 0;
        for(int i=0; i<frame.length(); i++){
            subFrame = frame.substring(i, i+1);
            out.writeObject("Frame No:" + frameno + " " + subFrame);
            if(frameno == 0){
                frameno = 1;
            }else{
                frameno = 0;
            }
            ack = (String)in.readObject();
            System.out.println("Ack from Server: " + ack);
        }
//Close all objects
        in.close();
        out.close();
        con.close();

    }
}
