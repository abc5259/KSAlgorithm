package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int start = 1;
        int end = start + M - 1;
        int min = 0;

        for (int i = 0; i < J; i++) {
            int num = Integer.parseInt(br.readLine());
            if (start <= num && num <= end) {
                continue;
            }
            if (Math.abs(num - start) < Math.abs(num - end)) {
                min += Math.abs(num - start);
                start = num;
                end = num + M - 1;
            } else {
                min += Math.abs(num - end);
                end = num;
                start = end - M + 1;
            }
        }
        System.out.println(min);
    }
}
// S5 사과 담기 게임 그리디
// 걍풀었다/