package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int g = (k * (k+1)) / 2;

        n -= g;
        if (n < 0) {
            System.out.println(-1);
        } else {
            int ans = k - 1;

            int ch = n % k;
            if (ch > 0) ans++;

            System.out.println(ans);
        }
    }
}

// 1 2 3 4 5 ...로 주기
// 7 3
// 1 2 3
