package ex5.chat;

import java.io.*;
import java.net.*;
import java.util.*;



public class Client {
    public static void main(String args[]) throws Exception{
        System.out.println("Client");
        System.out.println("");
        try{
            Socket s=new Socket("127.0.0.1", 1230);
            String msgin;
            String msgout;
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            System.out.print("Enter any msg to server: ");
            Scanner sc=new Scanner(System.in);
            msgout=sc.nextLine();
            System.out.println("Msg sent to server");
            out.writeObject(msgout);
            System.out.println("Client: " + msgout);
            msgin=(String)in.readObject();
            System.out.println("Reply from server");
            System.out.println("Server: " + msgin);
            s.close();
            in.close();
            out.close();
        }
        catch(Exception e)



        {
            System.out.println(e);
        }
    }
}