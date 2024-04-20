package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split("-");

        int ans = 0;
        for (int i = 0; i < exp.length; i++) {
            int n = 0;
            for (String s : exp[i].split("\\+"))
                n += Integer.parseInt(s);
            
            if (i == 0) ans += n;
            else ans -= n;
        }

        System.out.println(ans);
    }
}