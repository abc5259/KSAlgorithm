package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_3474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int two = 0;
            int five = 0;

            for (int d = 2; d <= n; d *= 2) two += (n / d);
            for (int d = 5; d <= n; d *= 5) five += (n / d);

            System.out.println(Math.min(two, five));
        }
    }
}
