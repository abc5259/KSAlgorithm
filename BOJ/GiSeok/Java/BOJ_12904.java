package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        while (S.length() < T.length()) {
            if (T.endsWith("A")) {
                T = T.substring(0, T.length()-1);
            } else {
                T = T.substring(0, T.length()-1);
                StringBuffer sb = new StringBuffer(T);
                T = sb.reverse().toString();
            }
        }


        if (S.equals(T))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
