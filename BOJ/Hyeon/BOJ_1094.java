package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (x > 0) {
            x = x & (x - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
// S5 막대기 비트마스킹
// 30분
// 그냥 풀었다.