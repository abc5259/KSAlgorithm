package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 1;

        while (true) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (res % arr[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= 3) {
                System.out.println(res);
                break;
            }
            res++;
        }
    }
}
// B1 적어도 대부분의 배수 완전탐색
// 걍 풀었다.