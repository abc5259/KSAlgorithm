package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        String s = br. readLine();
        String[] cro = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for (int idx = 0; idx < cro.length; idx++) {
            s = s.replace(cro[idx], "0");
        }
        System.out.println (s.length());
    }
}
