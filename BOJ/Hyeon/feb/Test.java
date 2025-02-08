package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < M - 2; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                cnt++;
                if (N == cnt) {
                    res++;
                    cnt--;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(res);
    }
}
