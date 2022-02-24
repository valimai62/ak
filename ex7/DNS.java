package ex7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DNS {
    public static void runSystemCommand(String command) {
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";
            while ((s = in.readLine()) != null) System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        System.out.println("Enter the host");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        runSystemCommand("nslookup " + str);
    }
}
