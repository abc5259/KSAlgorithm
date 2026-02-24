package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();
        int zin = Integer.parseInt(st.nextToken());

        int ans = 0;
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char c = num.charAt(i);
            int n = 0;
            if (c >= 'A' && c <= 'Z') n = (c - 'A') + 10;
            else n = c - '0';
            ans += n * (int) Math.pow(zin, length - i - 1);
        }

        System.out.println(ans);
    }
}
