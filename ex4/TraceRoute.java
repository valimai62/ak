package ex4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TraceRoute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        ip=sc.nextLine();
        //ping www.google.com

        try{
            Runtime r = Runtime.getRuntime();
            Process p =r.exec(ip);
            BufferedReader inStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while((s=inStream.readLine())!=null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
