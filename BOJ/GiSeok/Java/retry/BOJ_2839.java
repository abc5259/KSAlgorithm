package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        while (N != 0) {
            if (N % 5 == 0) {
                ans += (N / 5);
                break;
            }

            N -= 3;
            ans++;

            if (N < 0) { ans = -1; break; }
        }

        System.out.println(ans);
    }
}
