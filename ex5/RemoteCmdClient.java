package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RemoteCmdClient {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
Socket clsct=new Socket("127.0.0.1",3000);
//ObjectInputStream din=new ObjectInputStream(clsct.getInputStream());
ObjectOutputStream dout=new ObjectOutputStream(clsct.getOutputStream());

String[] strArray = new String[5];
System.out.println("Enter String");
for(int i=0;i<3;i++)
{
strArray[i]=in.readLine();
dout.writeObject(strArray[i]);
}
//String str1="cmd.exe";
//String str2="/c";
//String str3="dir";

clsct.close();
    }
}
